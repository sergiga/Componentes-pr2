/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentacion;

import despliegue.CarritoManagerRemote;
import despliegue.PedidoManagerRemote;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.WebServiceRef;
import webservice.Configuracionpc;
import webservice.ModelPCWS_Service;

/**
 *
 * @author sergio
 */
@WebServlet(name = "EmpresaServlet", urlPatterns = {"/empresa"})
public class EmpresaServlet extends HttpServlet {

    @EJB
    private PedidoManagerRemote pedidoManager;

    private static final String CART_SESSION_KEY = "shoppingCart";
    
    CarritoManagerRemote carritoManager;

    @WebServiceRef(wsdlLocation = "WEB-INF/wsdl/sergio-desktop_8080/ModelPCWS/ModelPCWS.wsdl")
    private ModelPCWS_Service service;

    private String url;
    
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        carritoManager = (CarritoManagerRemote) request.getSession().getAttribute(CART_SESSION_KEY);
        
        if(carritoManager == null) {
            carritoManager = lookupCarritoManagerRemote();
            carritoManager.addUser((String) request.getSession().getAttribute("user"));
            request.getSession().setAttribute(CART_SESSION_KEY, carritoManager);
        }
        try {
            String accion = request.getParameter("accion");
            /* No es un formulario */
            if(accion != null) {
                switch(accion) {
                    case "Al carro":
                        Configuracionpc config = getConfiguracion(
                            Integer.parseInt(request.getParameter("configuracion")));
                        int cantidad = Integer.parseInt(request.getParameter("cantidad"));
                        carritoManager.addPedido(config.getIdconfiguracion(), cantidad);
                        setRespuestaCatalogo(request);
                        setRespuestaCarrito(request, carritoManager.getItems());
                        this.url = "/empresa.jsp";
                        break;
                    case "Quitar del carro":
                        carritoManager.removePedido(Integer.parseInt(request.getParameter("configuracion")));
                        setRespuestaCatalogo(request);
                        setRespuestaCarrito(request, carritoManager.getItems());
                        this.url= "/empresa.jsp";
                        break;
                    case "Tramitar pedido":
                        Map<Integer, Integer> configs = carritoManager.getItems();
                        Iterator it = configs.keySet().iterator();
                        while(it.hasNext()){
                            Integer key = (Integer) it.next();
                            pedidoManager.addPedido(configs.get(key), key, carritoManager.getUser());
                        }
                        setRespuestaCatalogo(request);
                        carritoManager.removeAll();
                        break;
                    default:
                        setRespuestaCatalogo(request);
                        setRespuestaCarrito(request, carritoManager.getItems());
                        this.url = "/empresa.jsp";
                        break;
                }
            }
            else {
                setRespuestaCatalogo(request);
                setRespuestaCarrito(request, carritoManager.getItems());
                this.url = "/empresa.jsp";
            }
        }
        catch (Exception e) {
            request.setAttribute("type", e.toString());
            this.url = "/error.jsp";
        }
        finally {
            RequestDispatcher respuesta = getServletContext().getRequestDispatcher(this.url);
            respuesta.forward(request, response);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    private java.util.List<webservice.Configuracionpc> getCatalogo() {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        webservice.ModelPCWS port = service.getModelPCWSPort();
        return port.getCatalogo();
    }
    
    private Configuracionpc getConfiguracion(int idConfiguracion) {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        webservice.ModelPCWS port = service.getModelPCWSPort();
        return port.getConfiguracion(idConfiguracion);
    }

    private CarritoManagerRemote lookupCarritoManagerRemote() {
        try {
            Context c = new InitialContext();
            return (CarritoManagerRemote) c.lookup("java:global/ModelPC/Carrito-ejb/CarritoManager!despliegue.CarritoManagerRemote");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }
    
    private void setRespuestaCatalogo(HttpServletRequest request) {
        ArrayList<Configuracionpc> catalogo = new ArrayList<>(getCatalogo());
        request.setAttribute("catalogo", catalogo);
    }

    private void setRespuestaCarrito(HttpServletRequest request, Map<Integer, Integer> items) {
        Map<Configuracionpc, Integer> configs = new HashMap<>();
        Iterator it = items.keySet().iterator();
        while(it.hasNext()){
            Integer key = (Integer) it.next();
            configs.put(getConfiguracion(key), items.get(key));
        }
        request.setAttribute("configuracionCarrito", configs);
    }
}
