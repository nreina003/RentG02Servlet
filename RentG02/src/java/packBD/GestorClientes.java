/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package packBD;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import packModelo.Cliente;

public class GestorClientes {

    private static GestorClientes gc;
    private Connection con;
    private Statement set;
    private ResultSet rs;

    public void init(ServletConfig cfg) throws ServletException {
        String sURL = "jdbc:mysql://localhost:3306/rentg02";
        //super.init(cfg);
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

    private GestorClientes() {
    }

    public static GestorClientes getInstance() {
        if (gc == null) {
            gc = new GestorClientes();
        }
        return gc;
    }

    public boolean buscarCliente(String pEmail) {
        ResultSet resultado;
        boolean encontrado = false;
        Conexion c = Conexion.getInstance();
        c.conectar();

        try {
            resultado = c.getSt().executeQuery("SELECT email FROM clientes WHERE email = '" + pEmail + "'");
            if (resultado.next()) {
                encontrado = true;
            }
        } catch (SQLException ex) {
            System.err.println("SQLException: " + ex.getMessage());
        } finally {
            c.desconectar();
        }
        return encontrado;
    }

    public boolean comprobarContrasena(String pEmail, String pContrasena) {
        ResultSet resultado;
        boolean coincide = false;
        Conexion c = Conexion.getInstance();
        c.conectar();

        try {
            resultado = c.getSt().executeQuery("SELECT contraseña FROM clientes WHERE email = '" + pEmail + "' AND contraseña = '" + pContrasena + "'");

            if (resultado.next()) {
                coincide = true;
            }

        } catch (SQLException ex) {
            System.err.println("SQLException: " + ex.getMessage());
        }
        return coincide;
    }

    public String getNombre(String pEmail) {
        ResultSet r;
        Conexion c = Conexion.getInstance();
        c.conectar();

        String nombre = null;

        try {
            
            r = c.getSt().executeQuery("SELECT nombre FROM clientes WHERE email = '" + pEmail + "'");
            
            r.first();
            nombre = r.getString("nombre");
        } catch (SQLException ex) {
            System.err.println("SQLException: " + ex.getMessage());
        }
        return nombre;
        
    }

    public void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {

        HttpSession s = req.getSession(true);

        //Botones de navegación
        String button1 = null;
        String button2 = null;
        button1 = req.getParameter("loguearse");
        button2 = req.getParameter("realizarReserva");

        if (button1 != null) {
            req.getRequestDispatcher("inicioCliente.jsp").forward(req, res);
            System.out.println("Pulsado loguearse");
        } else if (button2 != null) {
            req.getRequestDispatcher("ReservaLogueado.jsp").forward(req, res);
            System.out.println("realizarReserva");
        } else {
            System.out.println("Error");
        }
        //Logout
        String btn = req.getParameter("Logout");
        if ("Logout".equals(btn)) {
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
/*

    public boolean altaPaciente(Integer pTIS, Date pFechaNacimiento, String pNombre, String pSexo, Integer pTelefono) {

        Conexion c = Conexion.getInstance();

        c.conectar();

        boolean insertado = false;

        try {

            Connection con = c.getConexion();

            PreparedStatement ps = con.prepareStatement("INSERT INTO paciente(TIS, fechaNacimiento, nombrePaciente, sexo, telefono) "
                    + "VALUES (?, ?, ?, ?, ?)");

            ps.setInt(1, pTIS);
            ps.setDate(2, pFechaNacimiento);
            ps.setString(3, pNombre);
            ps.setString(4, pSexo);
            ps.setLong(5, pTelefono);


            ps.executeUpdate();
            insertado = true;

        } catch (SQLException pEx) {
            System.out.println("Paciente no añadido");
            pEx.getStackTrace();
        } finally {
            c.desconectar();
        }
        return insertado;
    }
    
    public ArrayList<Sanitario> sanitarios(String pTIS) {
        ResultSet r;
        Conexion c = Conexion.getInstance();
        c.conectar();

        ArrayList<Sanitario> sanitarios = new ArrayList<>();

        try {
            r = c.getSt().executeQuery("SELECT * FROM sanitariopaciente WHERE TIS = '" + pTIS + "'");

            while (r.next()) {
                int numColegiado = r.getInt("numColegiado");
                String nombreSanitario = r.getString("nombreSanitario");
                String tipo = r.getString("tipo");
                String contrasena = r.getString("contrasena");

                sanitarios.add(new Sanitario(numColegiado, nombreSanitario, tipo, contrasena));
            }
        } catch (SQLException ex) {
            System.err.println("SQLException: " + ex.getMessage());
        } finally {
            c.desconectar();
        }
        return sanitarios;
    }

    public ArrayList<Paciente> pacientes(String pNumColegiado) {
        ResultSet r;

        Conexion c = Conexion.getInstance();

        c.conectar();

        ArrayList<Paciente> pacientes = new ArrayList<>();

        try {
            r = c.getSt().executeQuery("SELECT * FROM sanitariopaciente WHERE numColegiado = '" + pNumColegiado + "'");

            while (r.next()) {
                int TIS = r.getInt("TIS");
                String fechaNacimiento = r.getString("fechaNacimiento");
                String nombrePaciente = r.getString("nombrePaciente");
                String sexo = r.getString("sexo");
                int telefono = r.getInt("telefono");

                pacientes.add(new Paciente(TIS, fechaNacimiento, nombrePaciente, sexo, telefono));
            }
        } catch (SQLException ex) {
            System.err.println("SQLException: " + ex.getMessage());
        } finally {
            c.desconectar();
        }
        return pacientes;
    }
    
    public boolean comprobarContrasena(int pTIS, String pFechaNacimiento) {
        ResultSet resultado;
        boolean coincide = false;
        Conexion c = Conexion.getInstance();
        c.conectar();

        try {
            resultado = c.getSt().executeQuery("SELECT fechaNacimiento FROM Paciente WHERE TIS = '" + pTIS + "' AND fechaNacimiento = '" + pFechaNacimiento + "'");

            if (resultado.next()) {
                coincide = true;
            }
        } catch (SQLException ex) {
            System.err.println("SQLException: " + ex.getMessage());
        }
        return coincide;
    }

    
    
    public Paciente mostrarPerfil(Integer TIS) {
        ResultSet r;
        Conexion c = Conexion.getInstance();
        c.conectar();
        
        String fechaNacimiento;
        String nombrePaciente;
        String sexo;
        Integer telefono;
        
        Paciente u = null;

        try {
            r = c.getSt().executeQuery("SELECT * FROM Paciente WHERE TIS = '" + TIS + "'");

            r.first();

            fechaNacimiento = r.getString("fechaNacimiento");
            nombrePaciente = r.getString("nombrePaciente");
            sexo = r.getString("sexo");
            telefono = r.getInt("telefono");

            u = new Paciente(TIS, fechaNacimiento, nombrePaciente, sexo, telefono);
        } catch (SQLException ex) {
            System.err.println("SQLException: " + ex.getMessage());
        } finally {
            c.desconectar();
        }
        return u;
    }
    
    public String getTelefonoPaciente (String pTIS) {
        ResultSet r;
        Conexion c = Conexion.getInstance();
        c.conectar();
        
        String telefonoPaciente = null;
        
        try{
            r = c.getSt().executeQuery("SELECT telefono FROM Paciente WHERE TIS = '" + pTIS + "'");
            r.first();
            telefonoPaciente = r.getString("telefono");
        }
        catch (SQLException ex) {
            System.err.println("SQLException: " + ex.getMessage());
        }
        return telefonoPaciente;
    }

    public String getNombrePaciente(String pTIS) {
        ResultSet r;
        Conexion c = Conexion.getInstance();
        c.conectar();
        
        String nombrePaciente = null;
        
        try{
            r = c.getSt().executeQuery("SELECT nombrePaciente FROM Paciente WHERE TIS = '" + pTIS + "'");
            r.first();
            nombrePaciente = r.getString("nombrePaciente");
        }
        catch (SQLException ex) {
            System.err.println("SQLException: " + ex.getMessage());
        }
        return nombrePaciente;
    }

    public String getNombreMedico(String pTIS) {
        ResultSet r1;
        Conexion c = Conexion.getInstance();
        c.conectar();
        
        String nombreMedico = null;
        
        try{
            r1 = c.getSt().executeQuery("SELECT nombreSanitario, tipo FROM sanitarioPaciente left join sanitario on sanitarioPaciente.numColegiado = sanitario.numColegiado where TIS = '" + pTIS + "'" );
            
            while(r1.next()){
                String ns = r1.getString("nombreSanitario");
                
                String tipo = r1.getString("tipo");
                
                if (tipo.equalsIgnoreCase("ME")){
                    nombreMedico = ns;
                }
            }
        }
        catch (SQLException ex) {
            System.err.println("SQLException: " + ex.getMessage());
        }
        return nombreMedico;
    }
    
    public String getNombreEnfermero(String pTIS) {
        ResultSet r1;
        Conexion c = Conexion.getInstance();
        c.conectar();
        
        String nombreEnfermero = null;
        
        try{
            r1 = c.getSt().executeQuery("SELECT nombreSanitario, tipo FROM sanitarioPaciente left join sanitario on sanitarioPaciente.numColegiado = sanitario.numColegiado where TIS = '" + pTIS + "'" );
            
            while(r1.next()){
                String ns = r1.getString("nombreSanitario");
                
                String tipo = r1.getString("tipo");
                
                if (tipo.equalsIgnoreCase("EN")){
                    nombreEnfermero = ns;
                }
            }
        }
        catch (SQLException ex) {
            System.err.println("SQLException: " + ex.getMessage());
        }
        return nombreEnfermero;
    }
    
    public String getNombreMatrona(String pTIS) {
        ResultSet r1;
        Conexion c = Conexion.getInstance();
        c.conectar();
        
        String nombreMatrona = null;
        
        try{
            r1 = c.getSt().executeQuery("SELECT nombreSanitario, tipo FROM sanitarioPaciente left join sanitario on sanitarioPaciente.numColegiado = sanitario.numColegiado where TIS = '" + pTIS + "'" );
            
            while(r1.next()){
                String ns = r1.getString("nombreSanitario");
                
                String tipo = r1.getString("tipo");
                
                if (tipo.equalsIgnoreCase("MA")){
                    nombreMatrona = ns;
                }
            }
        }
        catch (SQLException ex) {
            System.err.println("SQLException: " + ex.getMessage());
        }
        return nombreMatrona;
    }
    
    public String getNumColegiado(String pTIS, String pTipo) {
        ResultSet r1;
        Conexion c = Conexion.getInstance();
        c.conectar();
        
        String numColegiado = null;
        try{
            String query = "SELECT * FROM sanitarioPaciente inner join sanitario on sanitarioPaciente.numColegiado = sanitario.numColegiado where TIS = '" + pTIS + "' AND tipo='" + pTipo +"'";
            r1 = c.getSt().executeQuery( query );
            System.out.println(query);
            r1.first();
            
            numColegiado = r1.getString("numColegiado");
        }
        catch (SQLException ex) {
            System.err.println("SQLException: " + ex.getMessage());
            ex.printStackTrace();
        }
        return numColegiado;
    }

    public ArrayList<Paciente> buscarPacientesSanitario(String pNumColegiado) {
        ResultSet r;

        Conexion c = Conexion.getInstance();

        c.conectar();

        ArrayList<Paciente> pacientes = new ArrayList<>();

        try {
                r = c.getSt().executeQuery("SELECT * FROM paciente left join sanitarioPaciente on paciente.TIS=sanitarioPaciente.TIS WHERE sanitarioPaciente.numColegiado = '" + pNumColegiado + "'");
            while (r.next()) {
                int TIS = r.getInt("TIS");
                String fechaNacimiento = r.getString("fechaNacimiento");
                String nombrePaciente = r.getString("nombrePaciente");
                String sexo = r.getString("sexo");
                int telefono = r.getInt("telefono");

                pacientes.add(new Paciente(TIS, fechaNacimiento, nombrePaciente, sexo, telefono));
            }
        } catch (SQLException ex) {
            System.err.println("SQLException: " + ex.getMessage());
        } finally {
            c.desconectar();
        }
        return pacientes;
    }
 */

/**
 * public Cita buscarSanitario(Integer pTIS, String pTipo) { ResultSet r;
 *
 * Conexion c = Conexion.getInstance();
 *
 * c.conectar();
 *
 * Sanitairo sanitario = null;
 *
 * try {
 *
 * r = c.getSt().executeQuery("SELECT * FROM sanitarioPaciente WHERE paciente =
 * '" + pTIS + "'");
 *
 * while (r.next()) { int TIS = r.getInt("TIS"); Date fechaNacimiento =
 * r.getDate("fechaNacimiento"); String nombrePaciente =
 * r.getString("nombrePaciente"); String sexo = r.getString("sexo"); int
 * telefono = r.getInt("telefono");
 *
 * paciente = new Paciente(TIS, fechaNacimiento, nombrePaciente, sexo,
 * telefono); } } catch (SQLException ex) { System.err.println("SQLException: "
 * + ex.getMessage()); } finally { c.desconectar(); } return paciente; }
 *
 */
