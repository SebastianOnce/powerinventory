/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto_final2024.newpackageModelo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import proyecto_final2024.newpackageVista.VistaProveedor;

/**
 *
 * @author elshi
 */
public class ModeloProveedor extends Proveedor{
    
    Conexion cpg = new Conexion();

    public ModeloProveedor() {
    }

    public SQLException grabarAdministrador() {
        String sql;
        String sql2;

        sql = "INSERT INTO public.proveedor (id_empresa, cedula)"
                + " VALUES ('" + getId_empresa()+ "', '" + getCedula() + "')";

        sql2 = "INSERT INTO public.persona (cedula, nombres, apellidos, direccion, genero, telefono, fecha_nacimiento)"
                + " VALUES ('" + getCedula() + "', '" + getNombres() + "', '" + getApellidos() + "', '" + getDireccion() + "', '" + getGenero() + "', '" + getTelefono() + "', '" + getFecha_nacimiento() + "')";

        cpg.accionDB(sql2);
        return cpg.accionDB(sql);

    }
    
    public static List<Proveedor> listarProveedor() {

        Conexion cpg = new Conexion();
        List<Proveedor> listaProveedor = new ArrayList<>();

        String sql;
        sql = "SELECT a.id_proveedor,e.nombre_empresa, a.cedula, p.nombres,p.apellidos, p.direccion, p.genero, p.telefono,p.fecha_nacimiento FROM public.proveedor a JOIN public.persona p ON a.cedula = p.cedula JOIN public.empresa e ON a.id_empresa = e.id_empresa";
        ResultSet rs = cpg.consultaDB(sql);

        try {
            while (rs.next()) {

                Proveedor provee = new Proveedor();

                provee.setId_empresa(rs.getString("nombre_empresa"));
                provee.setId_proveedor(rs.getString("id_proveedor"));
                provee.setCedula(rs.getString("cedula"));
                provee.setNombres(rs.getString("nombres"));
                provee.setApellidos(rs.getString("apellidos"));
                provee.setDireccion(rs.getString("direccion"));
                provee.setGenero(rs.getString("genero"));
                provee.setTelefono(rs.getString("telefono"));
                provee.setFecha_nacimiento(rs.getDate("fecha_nacimiento"));
                

                listaProveedor.add(provee);

            }

            rs.close();
            return listaProveedor;

        } catch (SQLException ex) {
            Logger.getLogger(ModeloAdministrador.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }

    }
    
}
