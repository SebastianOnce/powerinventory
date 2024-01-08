/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto_final2024.newpackageModelo;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import proyecto_final2024.newpackageControlador.controladorPersonas;

/**
 *
 * @author elshi
 */
public class ModeloPersona extends Persona{
    
    Conexion cpg = new Conexion();

    public ModeloPersona() {
    }
    
    public SQLException grabarPersona(){
        
        String sql;
        sql = "INSERT INTO public.persona (cedula, nombres, apellidos, direccion, genero, telefono, fecha_nacimiento)"
                + "VALUES('"+getCedula()+"', '"+getNombres()+"', '"+getApellidos()+"', '"+getDireccion()+"', '"+getGenero()+"', '"+getTelefono()+"', '"+getFecha_nacimiento()+"')";
        return cpg.accionDB(sql);
    }
    
    public static List<Persona> listarPersonas(){
        Conexion cpg = new Conexion();
        List<Persona> listaPersonas = new ArrayList<Persona>();
        
        String sql;
        sql = "SELECT id_persona, cedula, nombres, apellidos, direccion, genero, telefono, fecha_nacimiento FROM persona";
        ResultSet rs = cpg.consultaDB(sql);
        
        try {
            while(rs.next()){
                Persona Mipersona = new Persona();
                Mipersona.setId_persona(rs.getString("id_persona"));
                Mipersona.setCedula(rs.getString("cedula"));
                Mipersona.setNombres(rs.getString("nombres"));
                Mipersona.setApellidos(rs.getString("apellidos"));
                Mipersona.setDireccion(rs.getString("direccion"));
                Mipersona.setGenero(rs.getString("genero"));
                Mipersona.setTelefono(rs.getString("telefono"));
                Mipersona.setFecha_nacimiento(rs.getDate("fecha_nacimiento"));
                
                listaPersonas.add(Mipersona);
            }
            rs.close();
            return listaPersonas;
        } catch (SQLException ex) {
            Logger.getLogger(ModeloPersona.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
    public SQLException eliminarPersona(){
        String sql;
        sql = "DELETE FROM public.persona where cedula= '"+controladorPersonas.cedula2+"'";
        return cpg.accionDB(sql);
    }
    
    
}
