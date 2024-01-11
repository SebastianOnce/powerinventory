/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto_final2024.newpackageModelo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import proyecto_final2024.newpackageControlador.ControladorEmpresas;
import proyecto_final2024.newpackageControlador.controladorProveedor;

/**
 *
 * @author USER
 */
public class ModeloEmpresa extends Empresa {

    Conexion cpg = new Conexion();

    public SQLException grabarEmpre() {
        String sql;
        sql = "INSERT INTO public.empresa (nombre_empresa, descripcio_empresa)"
                + " VALUES ('" + getNombre_empresa() + "', '" + getDescripcion_empresa() + "')";
        return cpg.accionDB(sql);
    }

    public static List<Empresa> listarEmpre() {

        Conexion cpg = new Conexion();
        List<Empresa> listaProveedor = new ArrayList<>();

        String sql;
        sql = "SELECT id_empresa, nombre_empresa,descripcio_empresa From empresa";
        ResultSet rs = cpg.consultaDB(sql);

        try {
            while (rs.next()) {

                Empresa empre = new Empresa();
                empre.setNombre_empresa(rs.getString("nombre_empresa"));
                empre.setId_empresa(rs.getInt("id_empresa"));
                empre.setDescripcion_empresa(rs.getString("descripcio_empresa"));

                listaProveedor.add(empre);
            }

            rs.close();
            return listaProveedor;

        } catch (SQLException ex) {
            Logger.getLogger(ModeloAdministrador.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    public static List<Empresa> buscarEmpre() {

        Conexion cpg = new Conexion();
        List<Empresa> listaProveedor = new ArrayList<>();

        String sql;
        sql = "SELECT id_empresa,nombre_empresa,descripcio_empresa From empresa  WHERE CAST(id_empresa AS VARCHAR) LIKE '" + ControladorEmpresas.codigoBuscar + "%'";
        ResultSet rs = cpg.consultaDB(sql);

        try {
            while (rs.next()) {

                Empresa empre = new Empresa();
                empre.setId_empresa(rs.getInt("id_empresa"));
                empre.setNombre_empresa(rs.getString("nombre_empresa"));
                empre.setDescripcion_empresa(rs.getString("descripcio_empresa"));

                listaProveedor.add(empre);
            }

            rs.close();
            return listaProveedor;

        } catch (SQLException ex) {
            Logger.getLogger(ModeloAdministrador.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public SQLException modificarEmpre() {
        String sql;
        sql = "UPDATE public.empresa SET nombre_empresa='" + getNombre_empresa() + "', descripcio_empresa='" + getDescripcion_empresa() + "' WHERE id_empresa ='" + ControladorEmpresas.id + "' ";
        return cpg.accionDB(sql);//DEVUELVO NULL SI ES CORRECTO.
    }

    public SQLException eliminarEmpre() {
        String sql2;
        sql2 = "DELETE FROM public.empresa where id_empresa = '" + ControladorEmpresas.id+ "'";
        return cpg.accionDB(sql2);//DEVUELVO NULL SI ES CORRECTO.
    }
}
