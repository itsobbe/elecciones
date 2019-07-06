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
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.ApplicationException;
import modelo.Parametros;
import modelo.Partido;
import modelo.Votante;
import sun.applet.AppletIOException;

/**
 *
 * @author owa_7
 */
public class ControladorCargarDatosVistaVotar extends HttpServlet {
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
                String votado=((Votante)request.getSession().getAttribute("votante")).getVotado();
                Votante votante = (Votante) request.getSession().getAttribute("votante");
                Parametros parametro = (Parametros) request.getSession().getAttribute("parametros");
                if (votante.getVotado().equals("S")) {
                    String mensaje = "No puede votar una vez votado";
                    response.sendRedirect("VISTAS/VistaMensajeError.jsp?error=" + mensaje);
                    return;
                }else if (parametro.getConsultaAbierta().equals("N")) {
                    String mensaje = "No puede votar con consulta cerrada";
                    response.sendRedirect("VISTAS/VistaMensajeError.jsp?error=" + mensaje);
                    return;
                }else if (parametro.getEscrutinioAbierto().equals("N")) {
                    String mensaje = "No puede votar con escrutinio cerrado";
                    response.sendRedirect("VISTAS/VistaMensajeError.jsp?error=" + mensaje);
                    return;
                }

                ArrayList<Partido> i=new ArrayList();
                i=new Operaciones().devuelvePartidos(Conexion);
                request.getSession().setAttribute("partido", i);
                response.sendRedirect("VISTAS/VistaVotar.jsp");
            } catch (ApplicationException e) {
                 response.sendRedirect("VISTAS/VistaMensajeError.jsp?error="+e);
            }
            
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
