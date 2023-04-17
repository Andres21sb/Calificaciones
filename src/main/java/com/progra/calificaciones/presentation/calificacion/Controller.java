/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package com.progra.calificaciones.presentation.calificacion;

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
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ESCINF
 */
@WebServlet(name="calificacionController", urlPatterns={"/presentation/calificacion/show","/presentation/calificacion/calificar"})
public class Controller extends HttpServlet {
   
    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException, Exception {

        request.setAttribute("model", new Model());
        String viewUrl = "";
        switch (request.getServletPath()) {
            case "/presentation/calificacion/show":
                this.updateModel(request);
                viewUrl ="/presentation/calificacion/View.jsp";
                break;
            case "/presentation/calificacion/calificar":
                viewUrl=this.registro(request);
                break;
        }
        request.getRequestDispatcher(viewUrl).forward(request, response);
    } 
    
     private String show(HttpServletRequest request) {
        String viewUrl = "";
        Service service = Service.instance();
        Model model = (Model) request.getAttribute("model");

        HttpSession session = request.getSession(true);

        try {
            model.setCurrent(service.read(request.getParameter("Id")));
            viewUrl = "/presentation/calificacion/View.jsp";
        } catch (Exception ex) {
            //Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
            viewUrl = "/presentation/Error.jsp";
        }

        return viewUrl;
    }
     
     
    
    void updateModel(HttpServletRequest request) throws Exception{
        Model model = (Model) request.getAttribute("model");
        Service service = Service.instance();
        model.setCurrent(service.read(request.getParameter("Id")));
        //Guardo el model en la sesion
        request.getSession().setAttribute("model", model);
    }
    
     void updateModelCalificacion (HttpServletRequest request) throws Exception{
        Model model = (Model) request.getSession().getAttribute("model");
        model.getCalificacion().setNombre(request.getParameter("Nombre"));
        model.getCalificacion().setComentario(request.getParameter("Comentario"));
        model.getCalificacion().setPuntaje(Integer.parseInt(request.getParameter("Puntaje")));
     }
    
        public String registro(HttpServletRequest request){
        
        try {
            Map<String, String> errores = this.validar(request);
            if (errores.isEmpty()) {
                this.updateModelCalificacion(request);
                return this.registerAction(request);
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
        if (request.getParameter("Comentario").isEmpty()) {
            errores.put("Comentario", "Comentario requerida");
        }
        return errores;
    }
        
        
            public String registerAction(HttpServletRequest request) {
        Model model = (Model) request.getSession().getAttribute("model");
        Service service = Service.instance();
        HttpSession session = request.getSession(true);
        try {
            service.addCalificacion(model.getCurrent().getId(), model.getCalificacion());
            return "/presentation/hoteles/show";
            
        } catch (Exception ex) {
            Map<String, String> errores = new HashMap<>();
            request.setAttribute("errores", errores);
            errores.put("Comentario", "Comentario no valido");
            return "/presentation/hoteles/show";
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** 
     * Handles the HTTP <code>GET</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (Exception ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
    } 

    /** 
     * Handles the HTTP <code>POST</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (Exception ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /** 
     * Returns a short description of the servlet.
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
