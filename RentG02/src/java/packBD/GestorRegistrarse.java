/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package packBD;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author ADMIN
 */
public class GestorRegistrarse extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */

    
public boolean comprobarCliente(String pEmail, String pMovil, String pDni) {
        ResultSet resultado;
        boolean coincide = false;
        Conexion c = Conexion.getInstance();
        c.conectar();

        try {
            resultado = c.getSt().executeQuery("SELECT email,movil,dni FROM clientes WHERE email = '" + pEmail + "' OR movil = '" + pMovil + "' OR dni = '" + pDni);

            if (resultado.next()) {
                coincide = true;
            }

        } catch (SQLException ex) {
            System.err.println("SQLException: " + ex.getMessage());
        }
          System.err.println("usuario ya registrado"+ coincide);
        return coincide;
    }


 public void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
 //Logout
        String btn = req.getParameter("logoff");
        if ("logoff".equals(btn)) {
            res.sendRedirect("loguearse.jsp");
            HttpSession session = req.getSession();
            session.invalidate();
        }
    }

    public void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        try {
            doPost(req, res);
        } catch (IOException e) {
        } catch (ServletException e) {
        }
    }
}