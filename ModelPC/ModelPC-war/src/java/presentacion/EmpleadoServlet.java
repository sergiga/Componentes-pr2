/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentacion;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.WebServiceRef;
import webservice.ModelPCWS_Service;

/**
 *
 * @author sergio
 */
@WebServlet(name = "EmpleadoServlet", urlPatterns = {"/empleado"})
public class EmpleadoServlet extends HttpServlet {

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
        
        try {
            String accion = request.getParameter("accion");
            /* No es un formulario */
            if(accion != null) {
                switch(accion) {
                    case "Add configuracion":
                        ArrayList<Integer> idsDescrComp = new ArrayList<>();
                        double velCPU = Double.parseDouble(request.getParameter("velCPU"));
                        int capRAM = Integer.parseInt(request.getParameter("capRAM"));
                        int capDD = Integer.parseInt(request.getParameter("capDD"));
                        double velTarGraf = Double.parseDouble(request.getParameter("velTarGraf"));
                        int memTarGraf = Integer.parseInt(request.getParameter("memTarGraf"));
                        short idTipoCPU = Short.parseShort(request.getParameter("idTipoCPU"));
                        idsDescrComp.add(Integer.parseInt(request.getParameter("grafica")));
                        idsDescrComp.add(Integer.parseInt(request.getParameter("discoDuro")));
                        idsDescrComp.add(Integer.parseInt(request.getParameter("procesador")));
                        idsDescrComp.add(Integer.parseInt(request.getParameter("caja")));
                        idsDescrComp.add(Integer.parseInt(request.getParameter("chipset")));
                        idsDescrComp.add(Integer.parseInt(request.getParameter("ram")));
                        
                        addConfiguracion(velCPU, capRAM, capDD, velTarGraf, memTarGraf, idTipoCPU, idsDescrComp);
                        this.url = "/configuracion.jsp";
                        break;
                    case "Volver empleado":
                        this.url = "/empleado.jsp";
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

    private void addConfiguracion(double velCPU, int capRAM, int capDD, double velTarGraf, int memTarGraf, short idTipoCPU, java.util.List<java.lang.Integer> idsDescrComp) {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        webservice.ModelPCWS port = service.getModelPCWSPort();
        port.addConfiguracion(velCPU, capRAM, capDD, velTarGraf, memTarGraf, idTipoCPU, idsDescrComp);
    }

}
