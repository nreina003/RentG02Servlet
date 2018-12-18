/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package packModelo;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Date;
/**
 *
 * @author ADMIN
 */
public class Cliente {

    private Integer idClientes ;
    private String email;
    private String contraseña;
    private String nombre;
    private Integer dni;
    private String movil;

    public Cliente (Integer pIdClientes, String pEmail, String pContraseña, String pNombre, Integer pDni, String pMovil) {
        idClientes = pIdClientes;
        email = pEmail;
        contraseña = pContraseña;
        nombre = pNombre;
        dni = pDni;
        movil = pMovil;
    }

    public Integer getIdClientes() {
        return idClientes;
    }

    public void setIdClientes(Integer pIdClientes) {
        dni = pIdClientes;
    }
    
    public String getEmail() {
        return email;
    }

    public void setEmail(String pEmail) {
        email = pEmail;
    }
    
    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String pContraseña) {
        contraseña = pContraseña;
    }
         
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String pNombre) {
        nombre = pNombre;
    }
     public Integer getDni() {
        return dni;
    }

    public void setDni(Integer pdni) {
        dni = pdni;
    }
   
    public String getMovil() {
        return movil;
    }

    public void setMovil(String pMovil) {
        movil = pMovil;
    }
}