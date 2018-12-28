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
import java.util.Vector;
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

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, Exception {

        try {
            System.out.println("aqui 1");
            String email = request.getParameter("email");
            String contrasena = request.getParameter("contrasena");
            System.out.println(contrasena);
            boolean encontrado = GestorClientes.getInstance().buscarCliente(email);
            if (!encontrado) {
                response.setContentType("text/html");
                System.out.println("aqui 2");
               // PrintWriter out = null;
                try {
                    //out = response.getWriter();
                    JOptionPane.showMessageDialog(null, "email incorrecta", "RentG", JOptionPane.WARNING_MESSAGE);
                    response.sendRedirect("loguearse.jsp");
                } catch (IOException e) {
                    System.out.println("Se ha producido una IOException");
                    response.sendRedirect("loguearse.jsp");
                }

            } else {
                System.out.println("aqui 3");
                try {
                    //MIRAR CUAL FALLA SI EL EMAIL O LA CONTRASEÑA
                    //Y PASAR POR PANTALLA CUAL ES LA INCORRECTA!!!!
                    System.out.println("aqui 4");
                    if (!GestorClientes.getInstance().comprobarContrasena(email, contrasena)) {
                        response.setContentType("text/html");
                        //PrintWriter out = null;
                            System.out.println("aqui 5");
                        try {
                            //out = response.getWriter();
                            JOptionPane.showMessageDialog(null, "Contraseña incorrecta", "RentG", JOptionPane.WARNING_MESSAGE);
                            response.sendRedirect("loguearse.jsp");
                        } catch (IOException e) {
                            System.out.println("Se ha producido una IOException");
                            response.sendRedirect("loguearse.jsp");
                        }

                    } else {
                        System.out.println("aqui 6");
                        HttpSession s = request.getSession(true);
                        s.setAttribute("Clientes", email);
                        response.sendRedirect("inicioCliente.jsp");
                    }
                } catch (IOException ex) {
                    System.out.println("aqui 7");
                    System.out.println("Se ha producido una SQLException");
                    response.sendRedirect("loguearse.jsp");
                }
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Formato de email incorrecto", "RentG", JOptionPane.WARNING_MESSAGE);
            response.sendRedirect("loguearse.jsp");
        }
    }

    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String nombre = (String) req.getParameter("NombreUsuario");

        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();

        Vector listado = (Vector) req.getSession().getAttribute("listado");
        if (listado == null) {
            listado = new Vector();
        }

        out.println("<html>");
        out.println("<head><title>Servlets y Sesiones</title></head>");
        out.println("<body>");
        if (nombre != null) {
            out.println("<br>Hola " + nombre + "<br>");
            listado.addElement(nombre);
        }

        req.getSession().setAttribute("listado", listado);
        out.println("<br>");
        out.println("Contigo, hoy me han visitado:<br>");
        for (int i = 0; i < listado.size(); i++) {
            out.println("<br>" + (String) listado.elementAt(i));
        }
        out.println("<center><a href=\"Formulario.html\">VOLVER</a></center>");

        out.println("</body></html>");
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession s = request.getSession(true);
        String email = (String) request.getParameter("email");
        s.setAttribute("email", email);
       /* s.setAttribute("pEmail", request.getParameter("email"));*/
        String contrasena = (String) request.getParameter("contrasena");
        s.setAttribute("contrasena", contrasena);

        //seguir o dejar
        try {
            processRequest(request, response);
        } catch (Exception ex) {
            Logger.getLogger(SrvLoguearse.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}

/*
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class SrvLoguearse extends HttpServlet {

    private Connection con;
    private Statement set;
    private PreparedStatement set2;
    private ResultSet rs;
    private ResultSet rs2;

    @Override
    public void init(ServletConfig cfg) throws ServletException {
        String sURL = "jdbc:mysql://localhost/rentg02";
        super.init(cfg);
        String userName = "root";
        String password = "root";
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            con = DriverManager.getConnection(sURL, userName, password);
            System.out.println("Se ha conectado.");
        } catch (ClassNotFoundException ex1) {
            System.out.println("No se ha conectado: " + ex1);
        } catch (IllegalAccessException ex2) {
            System.out.println("No se ha conectado: " + ex2);
        } catch (InstantiationException ex3) {
            System.out.println("No se ha conectado: " + ex3);
        } catch (SQLException ex4) {
            System.out.println("No se ha conectado:" + ex4);
        }
    }

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        //Obtener parámetros de la sesión
        HttpSession s = req.getSession(true);
        String email = (String) req.getParameter("email");
        s.setAttribute("email", email);
        s.setAttribute("pEmail", req.getParameter("email"));
        String contraseña = (String) req.getParameter("contraseña");
        s.setAttribute("contraseña", contraseña);
        s.setAttribute("pContraseña", req.getParameter("contraseña"));

        String nombreUSesion = "xabi";
        try {
            set2 = con.prepareStatement("SELECT * from clientes where email=?");
            set2.setString(2, email);
            rs2 = set2.executeQuery();
            while (rs2.next()) {
                nombreUSesion = rs2.getString("nombre");
            }
            set2.close();
            rs2.close();
        } catch (SQLException ee1) {
            ee1.printStackTrace();
            System.out.println("SvrLoguearse.java 1er try obtener nombre");
        }

        s.setAttribute("nombreUSesion", nombreUSesion);

        boolean existeEmail = false;
        boolean existeContraseña = false;
        try {
            set = con.createStatement();
            rs = set.executeQuery("SELECT * FROM clientes");
            while (rs.next()) {
                Integer num = rs.getInt("email");
                String cad = num.toString().trim();

                if (cad.compareTo(email) == 0) { //Comprobar si la Email existe en la base de datos
                    existeEmail = true;
                    String pContraseña = rs.getString("contraseña");
                    String cad2 = pContraseña.trim();

                    if (cad2.compareTo(contraseña) == 0) { //Comprobar si la fecha de nacimiento se corresponde con la Email
                        existeContraseña = true;

                    }
                }
            }
            if (existeEmail == true && existeContraseña == true) {
                req.getRequestDispatcher("inicioCliente.jsp").forward(req, res);
            } else if (existeContraseña == false || existeEmail == false) {
                //La fecha no existe
                System.out.println("Los datos estan mal");
                res.sendRedirect("loguearse.jsp");

            } 
            rs.close();
            set.close();
        } catch (SQLException ex1) {
            System.out.println("Error Servlet LoginSanitario" + ex1);
        }

    }

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        try {
            doPost(req, res);
        } catch (IOException e) {
        } catch (ServletException e) {
        }
    }

    @Override
    public void destroy() {
        try {
            con.close();
        } catch (SQLException e) {
        }
        super.destroy();
    }

}
*/
