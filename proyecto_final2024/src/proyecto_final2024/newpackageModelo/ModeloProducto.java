/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto_final2024.newpackageModelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import proyecto_final2024.newpackageControlador.controladorProducto;
import proyecto_final2024.newpackageVista.VistaProducto;

/**
 *
 * @author elshi
 *///
public class ModeloProducto extends Producto {

    Conexion con = new Conexion();
    VistaProducto vista = new VistaProducto();

    public ModeloProducto() {
    }

    public SQLException CrearProducto() {
        String sql;
        sql = "INSERT INTO producto (nombre_producto, id_proveedor, descripcion_producto, cantidad_en_bodega, "
                + "precio_de_compra, precio_de_venta, disponibilidad, id_categoria, codigo_barras)"
                + " VALUES('" + getNombre_producto() + "', '" + getId_proveedor() + "', '" + getDescripcion_producto() + "', '" + getCantidad_en_bodega() + "',  "
                + "'" + getPrecio_de_compra() + "', '" + getPrecio_de_venta() + "', '" + getDisponibilidad() + "', '" + getId_categoria() + "', '" + getCodigo_barras() + "')";
        return con.accionDB(sql);
    }

    public SQLException modificarProducto() {
        String sql;
        sql = "UPDATE producto SET nombre_producto='" + getNombre_producto() + "', id_proveedor='" + getId_proveedor() + "', descripcion_producto='" + getDescripcion_producto() + "', cantidad_en_bodega='" + getCantidad_en_bodega() + "', "
                + "disponibilidad='" + getDisponibilidad() + "', id_categoria='" + getId_categoria() + "', precio_de_compra='" + getPrecio_de_compra() + "', precio_de_venta='" + getPrecio_de_venta() + "', codigo_barras='" + getCodigo_barras()+ "'"
                + " WHERE id_producto='" + getId_producto() + "'";
        return con.accionDB(sql);
    }

    public SQLException eliminarProducto() {
        String sql;
        sql = "DELETE FROM producto WHERE id_producto='" + getId_producto() + "'";
        return con.accionDB(sql);
    }

    public static List<Producto> listaProductos() {
        Conexion cpg = new Conexion();
        List<Producto> listaProductos = new ArrayList<>();

        String sql;
        sql = "SELECT id_producto, nombre_producto, id_proveedor, descripcion_producto, cantidad_en_bodega, disponibilidad, "
                + "id_categoria, precio_de_compra, precio_de_venta, codigo_barras FROM producto";
        ResultSet rs = cpg.consultaDB(sql);

        try {
            while (rs.next()) {
                Producto Miproducto = new Producto();
                Miproducto.setId_producto(rs.getString("id_producto"));
                Miproducto.setNombre_producto(rs.getString("nombre_producto"));
                Miproducto.setDescripcion_producto(rs.getString("descripcion_producto"));
                Miproducto.setDisponibilidad(rs.getString("disponibilidad"));
                Miproducto.setCantidad_en_bodega(Integer.valueOf(rs.getString("cantidad_en_bodega")));

                Miproducto.setId_categoria(rs.getString("id_categoria"));
                Miproducto.setId_proveedor(rs.getString("id_proveedor"));

                Miproducto.setPrecio_de_compra(Float.valueOf(rs.getString("precio_de_compra")));
                Miproducto.setPrecio_de_venta(Float.valueOf(rs.getString("precio_de_venta")));
                Miproducto.setCodigo_barras(rs.getString("codigo_barras"));

                listaProductos.add(Miproducto);

            }
            rs.close();
            return listaProductos;
        } catch (SQLException ex) {
            Logger.getLogger(ModeloPersona.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public static List<Producto> BuscarProducto() {
        Conexion cpg = new Conexion();
        List<Producto> listaProductos = new ArrayList<>();

        String sql;
        sql = "SELECT id_producto, nombre_producto, id_proveedor, descripcion_producto, cantidad_en_bodega, disponibilidad, "
                + "id_categoria, precio_de_compra, precio_de_venta, codigo_barras FROM producto WHERE CAST(id_producto AS VARCHAR) LIKE '" + controladorProducto.codigoBuscar + "%' or codigo_barras LIKE '" + controladorProducto.codigoBuscar + "%'";
       ResultSet rs = cpg.consultaDB(sql);
    try{
            while (rs.next()) {
                Producto Miproducto = new Producto();
                Miproducto.setId_producto(rs.getString("id_producto"));
                Miproducto.setNombre_producto(rs.getString("nombre_producto"));
                Miproducto.setDescripcion_producto(rs.getString("descripcion_producto"));
                Miproducto.setDisponibilidad(rs.getString("disponibilidad"));
                Miproducto.setCantidad_en_bodega(Integer.valueOf(rs.getString("cantidad_en_bodega")));

                Miproducto.setId_categoria(rs.getString("id_categoria"));
                Miproducto.setId_proveedor(rs.getString("id_proveedor"));

                Miproducto.setPrecio_de_compra(Float.valueOf(rs.getString("precio_de_compra")));
                Miproducto.setPrecio_de_venta(Float.valueOf(rs.getString("precio_de_venta")));
                Miproducto.setCodigo_barras(rs.getString("codigo_barras"));

                listaProductos.add(Miproducto);

            }
            rs.close();
            return listaProductos;
        } catch (SQLException ex) {
            return null;
        }
    }

    public static void cargarBoxes(VistaProducto vista) {
        cargarComboBox(vista.getCbcodigoproveedor(),
                "SELECT p.cedula, p.nombres, pr.id_proveedor FROM persona p INNER JOIN proveedor pr ON p.cedula = pr.cedula",
                "Error al cargar proveedores");
        cargarComboBox(vista.getCbcategoria(), "SELECT id_categoria, nombre_categoria FROM categoria_producto",
                "Error al cargar categorías");
    }

    public static void cargarComboBox(JComboBox comboBox, String sql, String errorMsg) {
        try (Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/superinver", "postgres", "1234");
                PreparedStatement preparedStatement = con.prepareStatement(sql);
                ResultSet resultSet = preparedStatement.executeQuery()) {
            System.out.println("Consulta SQL: " + sql);
            while (resultSet.next()) {
                String id = resultSet.getString(1);
                String nombre = resultSet.getString(2);
                System.out.println("ID: " + id + ", Nombre: " + nombre);
                comboBox.addItem(id + "-" + nombre);
            }

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println(errorMsg);
        }
    }
    
    public static List<Producto> BuscarProductoCodigoBarras() {
        Conexion cpg = new Conexion();
        List<Producto> listaProductos = new ArrayList<>();

        String sql;
        sql = "SELECT id_producto, nombre_producto, id_proveedor, descripcion_producto, cantidad_en_bodega, disponibilidad, "
                + "id_categoria, precio_de_compra, precio_de_venta, codigo_barras FROM producto WHERE codigo_barras = '"+ controladorProducto.codigoBuscar+"'";
       ResultSet rs = cpg.consultaDB(sql);
    try{
            while (rs.next()) {
                Producto Miproducto = new Producto();
                Miproducto.setId_producto(rs.getString("id_producto"));
                Miproducto.setNombre_producto(rs.getString("nombre_producto"));
                Miproducto.setDescripcion_producto(rs.getString("descripcion_producto"));
                Miproducto.setDisponibilidad(rs.getString("disponibilidad"));
                Miproducto.setCantidad_en_bodega(Integer.valueOf(rs.getString("cantidad_en_bodega")));

                Miproducto.setId_categoria(rs.getString("id_categoria"));
                Miproducto.setId_proveedor(rs.getString("id_proveedor"));

                Miproducto.setPrecio_de_compra(Float.valueOf(rs.getString("precio_de_compra")));
                Miproducto.setPrecio_de_venta(Float.valueOf(rs.getString("precio_de_venta")));
                Miproducto.setCodigo_barras(rs.getString("codigo_barras"));

                listaProductos.add(Miproducto);

            }
            rs.close();
            return listaProductos;
        } catch (SQLException ex) {
            return null;
        }
    }
}
