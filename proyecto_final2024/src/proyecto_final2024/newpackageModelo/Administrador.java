/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto_final2024.newpackageModelo;

import java.util.Date;

/**
 *
 * @author elshi
 */
public class Administrador extends Persona{
    
    private String id_administrador;
    private String usuario; 
    private String contraseña;

    public Administrador() {
        super();
    }

    public Administrador(String id_administrador, String usuario, String contraseña, String id_persona, String cedula, String nombres, String apellidos, String direccion, String genero, String telefono, Date fecha_nacimiento) {
        super(id_persona, cedula, nombres, apellidos, direccion, genero, telefono, fecha_nacimiento);
        this.id_administrador = id_administrador;
        this.usuario = usuario;
        this.contraseña = contraseña;
    }

    public String getId_administrador() {
        return id_administrador;
    }

    public void setId_administrador(String id_administrador) {
        this.id_administrador = id_administrador;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }
    
    
    
    
}
