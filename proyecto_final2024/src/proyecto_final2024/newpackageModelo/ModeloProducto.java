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
 */
public class ModeloProducto extends Producto{
    Conexion con= new Conexion();
    
    public ModeloProducto(){
    }
    
    public SQLException CrearProducto(){
        String sql;
        sql="INSERT INTO producto (nombre_producto, codigo_del_proveedor, descripcion_producto, cantidad_en_bodega, "
                + "disponibilidad, id_categoria, precio_de_compra, precio_de_venta)"
                + " VALUES('"+getNombre_producto()+"', '"+getCodigo_del_proveedor()+"', '"+getDescripcion_producto()+"', "
                + "'"+getPrecio_de_compra()+"', '"+getPrecio_de_venta()+"', '"+getDisponibilidad()+"', '"+getId_categoria()+"')";
        return con.accionDB(sql);
    }
    
    public SQLException modificarProducto(){
        String sql;
        sql="UPDATE producto SET nombre_producto, codigo_del_proveedor, descripcion_producto, cantidad_en_bodega, "
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
        List<Producto> listaProductos = new ArrayList<Producto>();
        
        String sql;
        sql = "SELECT nombre_producto, codigo_del_proveedor, descripcion_producto, cantidad_en_bodega, disponibilidad, "
                + "id_categoria, precio_de_compra, precio_de_venta FROM productos";
        ResultSet rs = cpg.consultaDB(sql);
        
        try {
            while(rs.next()){
                Producto Miproducto = new Producto();
                Miproducto.setNombre_producto(rs.getString("nombre_producto"));
                Miproducto.setCodigo_del_proveedor(rs.getString("codigo_del_proveedor"));
                Miproducto.setDescripcion_producto(rs.getString("descripcion_producto"));
                Miproducto.setCantidad_en_bodega(Integer.valueOf(rs.getString("cantidad_en_bodega")));
                Miproducto.setDisponibilidad(rs.getString("disponibilidad"));
                Miproducto.setId_categoria(rs.getString("id_categoria"));
                Miproducto.setPrecio_de_compra(Float.valueOf(rs.getString("precio_de_compra")));
                Miproducto.setPrecio_de_venta(Float.valueOf(rs.getString("precio_de_venta")));
                
                listaProductos().add(Miproducto);
                
            }
            rs.close();
            return listaProductos;
        } catch (SQLException ex) {
            Logger.getLogger(ModeloPersona.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        } 
    }
}
