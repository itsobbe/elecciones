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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import modelo.ApplicationException;
import modelo.Votante;

/**
 *
 * @author owa_7
 */
public class ControladorInicioSesion extends HttpServlet {
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
//            ConexionBBDD ConexBD = ConexionBBDD.GetConexion();
            Conexion = ConexionBBDD.GetConexion().GetCon();
        } catch (ClassNotFoundException cnfe) {
        } catch (SQLException sqle) {
        }
    }
    
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {  //preguntar si aqui va sqlexcepttion y abajo en doget y post que hay en el try catch
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            
            String nif=request.getParameter("nif");
            String contraseña=request.getParameter("contrasena");
            
            try {
                    //llamada a la funcion que si el usuario existe me devuelve un objeto y si no me lanza un excepcion
                    Votante obj=new Operaciones().inicioSesion(nif, contraseña, Conexion);
                    HttpSession session=request.getSession(true);
                    session.setAttribute("votante", obj);
                    session.setAttribute("usuario", contraseña);
                    session.setAttribute("password", nif);
                //ahora devuelto el objeto segun el rol que tenga lo mandamos a una vista u otra
                if (obj.getRol().equals("votante")) {
                    response.sendRedirect("VISTAS/VistaMenuVotante.jsp");
                     }else response.sendRedirect("VISTAS/VistaMenuAdmin.jsp");
            } catch (ApplicationException e) {
                //vista mensaje error sin menu arriba
                response.sendRedirect("VISTAS/VistaMensajeError.jsp?error="+e);
            }
            
            
        
            
            
            
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ControladorInicioSesion</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ControladorInicioSesion at " + request.getContextPath() + "</h1>");
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
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(ControladorInicioSesion.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(ControladorInicioSesion.class.getName()).log(Level.SEVERE, null, ex);
        }
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
