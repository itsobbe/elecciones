/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import dao.ConexionBBDD;
import dao.Operaciones;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.ApplicationException;
import modelo.Parametros;

/**
 *
 * @author owa_7
 */
public class ControladorConsulta extends HttpServlet {
    
    private Connection Conexion;
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
           @Override
    public void init() throws ServletException {
        super.init();
        /* Establecemos la conexión, si no existe */
        try {
            Conexion = ConexionBBDD.GetConexion().GetCon();
        } catch (ClassNotFoundException cnfe) {
        } catch (SQLException sqle) {
        }
    }
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            
            try {
                int id=Integer.parseInt(request.getParameter("id"));
                new Operaciones().consultav2(id,Conexion);
                if (id ==1) {
                    ((Parametros)request.getSession().getAttribute("parametros")).setConsultaAbierta("N");
                }else ((Parametros)request.getSession().getAttribute("parametros")).setConsultaAbierta("S");
                
                
                String mensaje="Consulta actualizada correctamente";
                response.sendRedirect("VISTAS/VistaMensajeCorrecto.jsp?mensaje="+mensaje);
            } catch (ApplicationException e) {
                response.sendRedirect("VISTAS/VistaMensajeError.jsp?error="+e);
            }
            
            
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ControladorConsulta</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ControladorConsulta at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
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

}
