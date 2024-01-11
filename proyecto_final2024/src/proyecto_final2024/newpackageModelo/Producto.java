/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto_final2024.newpackageModelo;

import java.util.Date;

/**
 *
 * @author elshi
 *///
public class Producto extends Proveedor{
    
    private String id_producto;
    private String nombre_producto;
    private String descripcion_producto;
    private int cantidad_en_bodega;
    private String disponibilidad;
    private String id_categoria;
    private float precio_de_compra;
    private float precio_de_venta;
    private Byte foto_producto;
    
    

    public Producto() {
        super();
    }

    public Producto(String id_producto, String nombre_producto, String descripcion_producto, int cantidad_en_bodega, String disponibilidad, String id_categoria, float precio_de_compra, float precio_de_venta, Byte foto_producto, String id_proveedor, String id_empresa, String id_persona, String cedula, String nombres, String apellidos, String direccion, String genero, String telefono, Date fecha_nacimiento) {
        super(id_proveedor, id_empresa, id_persona, cedula, nombres, apellidos, direccion, genero, telefono, fecha_nacimiento);
        this.id_producto = id_producto;
        this.nombre_producto = nombre_producto;
        this.descripcion_producto = descripcion_producto;
        this.cantidad_en_bodega = cantidad_en_bodega;
        this.disponibilidad = disponibilidad;
        this.id_categoria = id_categoria;
        this.precio_de_compra = precio_de_compra;
        this.precio_de_venta = precio_de_venta;
        this.foto_producto = foto_producto;
    }
    

    public float getPrecio_de_compra() {
        return precio_de_compra;
    }

    public void setPrecio_de_compra(float precio_de_compra) {
        this.precio_de_compra = precio_de_compra;
    }

    public float getPrecio_de_venta() {
        return precio_de_venta;
    }

    public void setPrecio_de_venta(float precio_de_venta) {
        this.precio_de_venta = precio_de_venta;
    }

    public String getId_producto() {
        return id_producto;
    }

    public void setId_producto(String id_producto) {
        this.id_producto = id_producto;
    }

    public String getNombre_producto() {
        return nombre_producto;
    }

    public void setNombre_producto(String nombre_producto) {
        this.nombre_producto = nombre_producto;
    }

    public String getDescripcion_producto() {
        return descripcion_producto;
    }

    public void setDescripcion_producto(String descripcion_producto) {
        this.descripcion_producto = descripcion_producto;
    }

    public int getCantidad_en_bodega() {
        return cantidad_en_bodega;
    }

    public void setCantidad_en_bodega(int cantidad_en_bodega) {
        this.cantidad_en_bodega = cantidad_en_bodega;
    }

    public String getDisponibilidad() {
        return disponibilidad;
    }

    public void setDisponibilidad(String disponibilidad) {
        this.disponibilidad = disponibilidad;
    }

    public Byte getFoto_producto() {
        return foto_producto;
    }

    public void setFoto_producto(Byte foto_producto) {
        this.foto_producto = foto_producto;
    }
    
    public String getId_categoria() {
        return id_categoria;
    }

    public void setId_categoria(String id_categoria) {
        this.id_categoria = id_categoria;
    }

    
}
