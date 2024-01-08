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
public class CategoriaProducto extends Producto{
    
    private String nombre_categoria;
    private String descripcion_categoria;
    private String id_categoria;

    public CategoriaProducto() {
        super();
    }

    public CategoriaProducto(String nombre_categoria, String descripcion_categoria, String id_categoria, String id_producto, String nombre_producto, String codigo_del_proveedor, String descripcion_producto, String precio_de_compra, String precio_de_venta, int cantidad_en_bodega, String disponibilidad, Byte foto_producto, String id_proveedor, String nombre_proveedor, String ruc_proveedor, String id_persona, String cedula, String nombres, String apellidos, String direccion, String genero, String telefono, Date fecha_nacimiento) {
        super(id_producto, nombre_producto, codigo_del_proveedor, descripcion_producto, precio_de_compra, precio_de_venta, cantidad_en_bodega, disponibilidad, foto_producto, id_proveedor, nombre_proveedor, ruc_proveedor, id_persona, cedula, nombres, apellidos, direccion, genero, telefono, fecha_nacimiento);
        this.nombre_categoria = nombre_categoria;
        this.descripcion_categoria = descripcion_categoria;
        this.id_categoria = id_categoria;
    }

    

    public String getNombre_categoria() {
        return nombre_categoria;
    }

    public void setNombre_categoria(String nombre_categoria) {
        this.nombre_categoria = nombre_categoria;
    }

    public String getDescripcion_categoria() {
        return descripcion_categoria;
    }

    public void setDescripcion_categoria(String descripcion_categoria) {
        this.descripcion_categoria = descripcion_categoria;
    }

    public String getId_categoria() {
        return id_categoria;
    }

    public void setId_categoria(String id_categoria) {
        this.id_categoria = id_categoria;
    }
    
}
