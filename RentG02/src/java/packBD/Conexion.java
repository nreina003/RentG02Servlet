/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package packBD;

import com.mysql.jdbc.*;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;




public class Conexion {

    private Connection con;
    private Statement st;
    private final String url;
    private final String userName = "root";
    private final String password = "root";
    private static Conexion conexion;

    private Conexion() {
        url = "jdbc:mysql://localhost/rentg02";
    }

    public static Conexion getInstance() {
        if (conexion == null) {
            conexion = new Conexion();
        }
        return conexion;
    }

    public void conectar() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = (Connection) DriverManager.getConnection(url, userName, password);
            st = (Statement) con.createStatement();
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void desconectar() {
        try {
            st.close();
            con.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public Connection getConexion() {

        return con;
    }

    public Statement getSt() {
        return st;
    }

     public java.sql.Statement getSt(int resultSetType , int resultSetConcurrency ) throws SQLException
    {
        return con.createStatement(resultSetType, resultSetConcurrency );
    }
}





