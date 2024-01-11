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

/**
 *
 * @author elshi
 *///
public class ModeloProducto extends Producto{
    Conexion con= new Conexion();
    
    public ModeloProducto(){
    }
    
    public SQLException CrearProducto(){
        String sql;
        sql="INSERT INTO producto (nombre_producto, id_proveedor, descripcion_producto, cantidad_en_bodega, "
                + "disponibilidad, id_categoria, precio_de_compra, precio_de_venta)"
                + " VALUES('"+getNombre_producto()+"', '"+getId_proveedor()+"', '"+getDescripcion_producto()+"', '"+getCantidad_en_bodega()+"',  "
                + "'"+getPrecio_de_compra()+"', '"+getPrecio_de_venta()+"', '"+getDisponibilidad()+"', '"+getId_categoria()+"')";
        return con.accionDB(sql);
    }
    
    public SQLException modificarProducto(){
        String sql;
        sql="UPDATE producto SET nombre_producto, id_proveedor, descripcion_producto, cantidad_en_bodega, "
                + "disponibilidad, id_categoria, precio_de_compra, precio_de_venta"
                + " WHERE id_producto='"+getId_producto()+"'";
        return con.accionDB(sql);
    }
    
    public SQLException eliminarProducto(){
        String sql;
        sql="DELETE FROM producto WHERE id_producto='"+getId_producto()+"'";
        return con.accionDB(sql);
    }
    
    public static List<Producto> listaProductos(){
        Conexion cpg = new Conexion();
        List<Producto> listaProductos = new ArrayList<>();
        
        String sql;
        sql = "SELECT id_producto, nombre_producto, id_proveedor, descripcion_producto, cantidad_en_bodega, disponibilidad, "
                + "id_categoria, precio_de_compra, precio_de_venta FROM producto";
        ResultSet rs = cpg.consultaDB(sql);
        
        try {
            while(rs.next()){
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
                
                listaProductos.add(Miproducto);
                
            }
            rs.close();
            return listaProductos;
        } catch (SQLException ex) {
            Logger.getLogger(ModeloPersona.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        } 
    }
}
