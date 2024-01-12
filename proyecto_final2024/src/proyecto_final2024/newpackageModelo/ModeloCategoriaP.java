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
import proyecto_final2024.newpackageControlador.controladorCategoria;

/**
 *
 * @author elshi
 */
public class ModeloCategoriaP extends Categoria {

    Conexion con = new Conexion();

    public ModeloCategoriaP() {
    }

    public SQLException crearCategoria() {
        String sql;
        sql = "INSERT INTO categoria_producto (nombre_categoria, descripcion_categoria)"
                + " VALUES ('" + getNombre_categoria() + "', '" + getDescripcion_categoria() + "')";
        return con.accionDB(sql);
    }

    public SQLException eliminarCategoria() {
        String sql;
        sql = "DELETE FROM categoria_producto WHERE id_categoria = '" + getId_categoria() + "'";
        return con.accionDB(sql);
    }

    public SQLException modificarCategoria() {
        String sql;
        sql = "UPDATE categoria_producto SET nombre_categoria='" + getNombre_categoria() + "', descripcion_categoria='"
                + getDescripcion_categoria() + "' WHERE id_categoria='" +controladorCategoria.id_cat+ "'";
        return con.accionDB(sql);
    }

    public static List<Categoria> listaCategorias() {

        Conexion cpg = new Conexion();
        List<Categoria> listaCategoria = new ArrayList<>();

        String sql;
        sql = "SELECT * FROM categoria_producto";
        ResultSet rs = cpg.consultaDB(sql);

        try {
            while (rs.next()) {

                Categoria catego = new Categoria();
                catego.setId_categoria(Integer.valueOf(rs.getString("id_categoria")));
                catego.setNombre_categoria(rs.getString("nombre_categoria"));
                catego.setDescripcion_categoria(rs.getString("descripcion_categoria"));
                listaCategoria.add(catego);
            }

            rs.close();
            return listaCategoria;

        } catch (SQLException ex) {
            Logger.getLogger(ModeloAdministrador.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public static List<Categoria> buscarCategoria() {

        Conexion con = new Conexion();
        List<Categoria> listaCategorias = new ArrayList<>();
        String sql;
        sql = "SELECT id_categoria, nombre_categoria, descripcion_categoria FROM categoria_producto WHERE CAST(id_categoria AS VARCHAR) LIKE '" + controladorCategoria.idBuscara + "%'";
        ResultSet rs = con.consultaDB(sql);
        try {
            while (rs.next()) {
                Categoria catego = new Categoria();
                catego.setId_categoria(Integer.valueOf(rs.getString("id_categoria")));
                catego.setNombre_categoria(rs.getString("nombre_categoria"));
                catego.setDescripcion_categoria(rs.getString("descripcion_categoria"));
                listaCategorias.add(catego);
            }
            rs.close();
            return listaCategorias;
        } catch (SQLException ex) {
            Logger.getLogger(ModeloAdministrador.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
}
