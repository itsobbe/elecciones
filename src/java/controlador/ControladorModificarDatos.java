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
import java.time.LocalDate;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.ApplicationException;
import modelo.Votante;

/**
 *
 * @author owa_7
 */
public class ControladorModificarDatos extends HttpServlet {
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
            throws ServletException, IOException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {

            String nombre=request.getParameter("nombre");
            String nif=request.getParameter("nif");
            String contrasena=request.getParameter("contrasena");
            String apellidos=request.getParameter("apellidos");
            LocalDate fechaNac=LocalDate.parse(request.getParameter("fechaNac"));
            String domicilio=request.getParameter("domicilio");
            
            Votante nuevosDatos=new Votante(nombre, apellidos, domicilio, fechaNac, contrasena, nif);
            
            //vamos al controlador
            try {
                boolean correcto=new Operaciones().cambioDatos(nuevosDatos, Conexion);
                if (correcto) {
                    //escribimos mensaje exito personalizado
                    String mensaje="Actualización realizada";
                    response.sendRedirect("VISTAS/VistaMensajeCorrecto.jsp?mensaje="+mensaje);
                }
            } catch (ApplicationException e) {
                    response.sendRedirect("VISTAS/VistaMensajeError.jsp?error="+e);
            }
            
            
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ControladorModificarDatos</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ControladorModificarDatos at " + request.getContextPath() + "</h1>");
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
            Logger.getLogger(ControladorModificarDatos.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(ControladorModificarDatos.class.getName()).log(Level.SEVERE, null, ex);
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
