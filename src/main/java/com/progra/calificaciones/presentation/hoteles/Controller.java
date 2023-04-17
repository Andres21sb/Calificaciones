/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.progra.calificaciones.presentation.hoteles;

import com.progra.calificaciones.logic.Service;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author ESCINF
 */
@WebServlet(name = "hotelesController", urlPatterns = {"/presentation/hoteles/show", "/presentation/hoteles/search"})
public class Controller extends HttpServlet {

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

        request.setAttribute("model", new Model());
        String viewUrl = "";
        switch (request.getServletPath()) {
            case "/presentation/hoteles/show":
                viewUrl = this.showTop3Hoteles(request);
                break;
            case "/presentation/hoteles/search":
                viewUrl = this.search(request);
                break;
        }
        request.getRequestDispatcher(viewUrl).forward(request, response);
    }

    private String showTop3Hoteles(HttpServletRequest request) {
        String viewUrl = "";
        Service service = Service.instance();
        Model model = (Model) request.getAttribute("model");

        HttpSession session = request.getSession(true);

        try {
            model.setHoteles(service.top3());
            viewUrl = "/presentation/hoteles/View.jsp";
        } catch (Exception ex) {
            //Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
            viewUrl = "/presentation/Error.jsp";
        }

        return viewUrl;
    }

    private String search(HttpServletRequest request) {
        try {
            Map<String, String> errores = this.validar(request);
            if (errores.isEmpty()) {
                this.updateModel(request);
                return "/presentation/hoteles/View.jsp";
            } else {
                request.setAttribute("errores", errores);
                return "/presentation/hoteles/View.jsp";
            }
        } catch (Exception e) {
            return "/presentation/Error.jsp";
        }
    }
    
        Map<String, String> validar(HttpServletRequest request) {
        Map<String, String> errores = new HashMap<>();
        if (request.getParameter("Nombre").isEmpty()) {
            errores.put("Nombre", "Nombre requerido");
        }
        return errores;
    }
        
        
            void updateModel(HttpServletRequest request) throws Exception {
        Model model = (Model) request.getAttribute("model");
         Service service = Service.instance();
        model.setHoteles(service.search(request.getParameter("Nombre")));
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

}
