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
public class Proveedor extends Persona{
    
    private String id_proveedor;
    private String nombre_proveedor;
    private String ruc_proveedor;

    public Proveedor() {
        super();
    }

    public Proveedor(String id_proveedor, String nombre_proveedor, String ruc_proveedor, String id_persona, String cedula, String nombres, String apellidos, String direccion, String genero, String telefono, Date fecha_nacimiento) {
        super(id_persona, cedula, nombres, apellidos, direccion, genero, telefono, fecha_nacimiento);
        this.id_proveedor = id_proveedor;
        this.nombre_proveedor = nombre_proveedor;
        this.ruc_proveedor = ruc_proveedor;
    }

    public String getId_proveedor() {
        return id_proveedor;
    }

    public void setId_proveedor(String id_proveedor) {
        this.id_proveedor = id_proveedor;
    }

    public String getNombre_proveedor() {
        return nombre_proveedor;
    }

    public void setNombre_proveedor(String nombre_proveedor) {
        this.nombre_proveedor = nombre_proveedor;
    }

    public String getRuc_proveedor() {
        return ruc_proveedor;
    }

    public void setRuc_proveedor(String ruc_proveedor) {
        this.ruc_proveedor = ruc_proveedor;
    }
    
    
    
}
