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
import javax.swing.JOptionPane;
import proyecto_final2024.newpackageControlador.controladorClientes;

/**
 *
 * @author elshi
 */
public class ModeloCliente extends Cliente{
    Conexion cpg = new Conexion();

    public ModeloCliente() {
    }

    public SQLException grabarcliente() {
        String sql;
        String sql2;

        sql = "INSERT INTO public.cliente (frecuencia, calificacion, cedula)"
                + " VALUES ('" + getFecuencia()+ "', '" + getCalificacion()+ "', '" + getCedula() + "')";

        sql2 = "INSERT INTO public.persona (cedula, nombres, apellidos, direccion, genero, telefono, fecha_nacimiento)"
                + " VALUES ('" + getCedula() + "', '" + getNombres() + "', '" + getApellidos() + "', '" + getDireccion() + "', '" + getGenero() + "', '" + getTelefono() + "', '" + getFecha_nacimiento() + "')";

        cpg.accionDB(sql2);
        return cpg.accionDB(sql);

    }

    public static List<Cliente> listarClientes() {

        Conexion cpg = new Conexion();
        List<Cliente> listaAdministrador = new ArrayList<>();

        String sql;
        sql = "SELECT a.id_cliente, a.frecuencia, a.calificacion,a.cedula, p.nombres,p.apellidos, p.direccion, p.genero, p.telefono,p.fecha_nacimiento FROM public.cliente a JOIN public.persona p ON a.cedula = p.cedula";
        ResultSet rs = cpg.consultaDB(sql);

        try {
            while (rs.next()) {

                Cliente admin = new Cliente();

                admin.setId_cliente(rs.getString("id_cliente"));
                admin.setCalificacion(rs.getInt("calificacion"));
                admin.setFecuencia(rs.getString("frecuencia"));
                admin.setCedula(rs.getString("cedula"));
                admin.setNombres(rs.getString("nombres"));
                admin.setApellidos(rs.getString("apellidos"));
                admin.setDireccion(rs.getString("direccion"));
                admin.setGenero(rs.getString("genero"));
                admin.setTelefono(rs.getString("telefono"));
                admin.setFecha_nacimiento(rs.getDate("fecha_nacimiento"));
                

                listaAdministrador.add(admin);

            }

            rs.close();
            return listaAdministrador;

        } catch (SQLException ex) {
            Logger.getLogger(ModeloAdministrador.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }

    }

    public SQLException eliminarclientes() {
        String sql;
        String sql2;
        sql = "DELETE FROM public.cliente where cedula = '" + controladorClientes.cedulaC + "'";
        sql2 = "DELETE FROM public.persona where cedula = '" + controladorClientes.cedulaC + "'";
        cpg.accionDB(sql);//DEVUELVO NULL SI ES CORRECTO.
        return cpg.accionDB(sql2);//DEVUELVO NULL SI ES CORRECTO.
    }

    public SQLException modificarCliente() {
        String sql;
        String sql2;
        sql = "UPDATE public.cliente SET frecuencia='" + getFecuencia()+ "', calificacion='" + getCalificacion()+ "' WHERE cedula ='"+controladorClientes.cedulaC+"' " ;
        
        sql2 = "UPDATE public.persona\n" +
"	SET  cedula='" + getCedula() + "', nombres='" + getNombres() + "', apellidos='" + getApellidos() + "', direccion='" + getDireccion() + "', genero= '" + getGenero() + "', telefono= '" + getTelefono() + "', fecha_nacimiento= '" + getFecha_nacimiento() + "' WHERE cedula ='"+controladorClientes.cedulaC+"' ";
        cpg.accionDB(sql2);
        return cpg.accionDB(sql);//DEVUELVO NULL SI ES CORRECTO.

    }

    public static List<Cliente> clienteBuscado() {

        Conexion cpg = new Conexion();
        List<Cliente> listaAdmin = new ArrayList<>();

        String sql;
        sql = "SELECT a.id_cliente, a.frecuencia, a.calificacion,a.cedula, p.nombres,p.apellidos, p.direccion, p.genero, p.telefono,p.fecha_nacimiento FROM public.cliente a JOIN public.persona p ON a.cedula = p.cedula WHERE a.cedula like '"+controladorClientes.cliemnteBuscar+ "%'";
        ResultSet rs = cpg.consultaDB(sql);

        try {
            while (rs.next()) {
                Cliente admin = new Cliente();

                admin.setId_cliente(rs.getString("id_cliente"));
                admin.setCalificacion(rs.getInt("calificacion"));
                admin.setFecuencia(rs.getString("frecuencia"));
                admin.setCedula(rs.getString("cedula"));
                admin.setNombres(rs.getString("nombres"));
                admin.setApellidos(rs.getString("apellidos"));
                admin.setDireccion(rs.getString("direccion"));
                admin.setGenero(rs.getString("genero"));
                admin.setTelefono(rs.getString("telefono"));
                admin.setFecha_nacimiento(rs.getDate("fecha_nacimiento"));
                
                listaAdmin.add(admin);

            }
            rs.close();
            return listaAdmin;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "algo salio mal");
            Logger.getLogger(ModeloAdministrador.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }

    }

}
