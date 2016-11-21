/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentacion;

import despliegue.UsuarioManagerRemote;
import dominio.Descripcioncomponente;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import javax.ejb.EJB;
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
@WebServlet(name = "UsuarioServlet", urlPatterns = {"/login"})
public class UsuarioServlet extends HttpServlet {

    @WebServiceRef(wsdlLocation = "WEB-INF/wsdl/sergio-desktop_8080/ModelPCWS/ModelPCWS.wsdl")
    private ModelPCWS_Service service;

    @EJB
    private UsuarioManagerRemote usuarioManager;

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
        
        String nifcif;
        String passwd;
        
        try {
            String accion = request.getParameter("accion");
            /* No es un formulario */
            if(accion != null) {
                switch(accion) {
                    case "Login":
                        nifcif = request.getParameter("nifcif");
                        passwd = request.getParameter("passwd");
                        if(usuarioManager.isUser(nifcif, passwd)) {
                            ArrayList<Configuracionpc> catalogo = new ArrayList<>(getCatalogo());
                            if(usuarioManager.tipoUser(nifcif).getTipo().equals("Empresa")) {
                                request.setAttribute("catalogo", catalogo);
                                this.url = "/empresa.jsp";
                            }
                            else {
                                Set<Integer> idsDescrp = new HashSet<Integer>();
                                for(Configuracionpc c : catalogo) {
                                    idsDescrp.add(c.getIdconfiguracion());
                                }
                                request.setAttribute("descripciones", idsDescrp);
                                this.url = "/empleado.jsp";
                            }
                            request.getSession().setAttribute("user", nifcif);
                        }
                        else {
                            this.url = "/index.jsp";
                        }
                        break;
                    default:
                        this.url = "/index.jsp";
                        break;
                }
            }
            else {
                this.url = "/index.jsp";
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

}
