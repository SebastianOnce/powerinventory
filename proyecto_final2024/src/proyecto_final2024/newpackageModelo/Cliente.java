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
public class Cliente extends Persona{
    
    private String id_cliente;
    private String fecuencia;
    private int calificacion;

    public Cliente() {
        super();
    }

    public Cliente(String id_cliente, String fecuencia, int calificacion, String id_persona, String cedula, String nombres, String apellidos, String direccion, String genero, String telefono, Date fecha_nacimiento) {
        super(id_persona, cedula, nombres, apellidos, direccion, genero, telefono, fecha_nacimiento);
        this.id_cliente = id_cliente;
        this.fecuencia = fecuencia;
        this.calificacion = calificacion;
    }

    

    public String getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(String id_cliente) {
        this.id_cliente = id_cliente;
    }

    public String getFecuencia() {
        return fecuencia;
    }

    public void setFecuencia(String fecuencia) {
        this.fecuencia = fecuencia;
    }

    public int getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(int calificacion) {
        this.calificacion = calificacion;
    }
    
    
    
    
}
