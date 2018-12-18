/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package packServlets;

import java.io.*;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.logging.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import javax.swing.JOptionPane;
import packBD.*;

@WebServlet(name = "SrvLoguearse", urlPatterns = {"/SrvLoguearse"})
public class SrvLoguearse extends HttpServlet {

    private Connection con;
    private Statement set;
    private ResultSet rs;
    String cad;

    @Override
    public void init(ServletConfig cfg) throws ServletException {
        Conexion c = Conexion.getInstance();
        c.conectar();
    }

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
            throws ServletException, IOException, Exception {

        try {

            String email = request.getParameter("email");
            String contraseña = request.getParameter("contrasena");

            boolean encontrado = GestorClientes.getInstance().buscarCliente(email);
            if (!encontrado) {
                String path1 = "'inicioCliente.jsp'";
                response.setContentType("text/html");
                //PrintWriter out = null;
                try {
                    //out = response.getWriter();
                    JOptionPane.showMessageDialog(null, "email incorrecta", "RentG", JOptionPane.WARNING_MESSAGE);
                    response.sendRedirect("loguearse.jsp");
                } catch (IOException e) {
                    System.out.println("Se ha producido una IOException");
                    response.sendRedirect("loguearse.jsp");
                }

            } else {
                try {
                    //MIRAR CUAL FALLA SI EL EMAIL O LA CONTRASEÑA
                    //Y PASAR POR PANTALLA CUAL ES LA INCORRECTA!!!!
                    if (!GestorClientes.getInstance().comprobarContrasena(email, contraseña)) {
                        response.setContentType("text/html");
                        //PrintWriter out = null;

                        try {
                            //out = response.getWriter();
                            JOptionPane.showMessageDialog(null, "Contraseña incorrecta", "RentG", JOptionPane.WARNING_MESSAGE);
                            response.sendRedirect("loguearse.jsp");
                        } catch (IOException e) {
                            System.out.println("Se ha producido una IOException");
                            response.sendRedirect("loguearse.jsp");
                        }

                    } else {
                        HttpSession s = request.getSession(true);
                        s.setAttribute("Clientes", email);
                        response.sendRedirect("inicioCliente.jsp");
                    }
                } catch (IOException ex) {
                    System.out.println("Se ha producido una SQLException");
                    response.sendRedirect("loguearse.jsp");
                }
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Formato de email incorrecto", "RentG", JOptionPane.WARNING_MESSAGE);
            response.sendRedirect("loguearse.jsp");
        }
    }

    /**
     *
     * @author ADMIN
     */
    
     

    }
