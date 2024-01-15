package proyecto_final2024.newpackageModelo;

import proyecto_final2024.newpackageControlador.ControladorFactura;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import proyecto_final2024.newpackageControlador.controladorProveedor;

public class ModeloFactura extends Factura {

    Conexion cpg = new Conexion();
    
    static public String nombre, codigobarras;
    static public float precio;

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

    public static List<Proveedor> ProveedorBuscadp() {

        Conexion cpg = new Conexion();
        List<Proveedor> listaProveedor = new ArrayList<>();

        String sql;
        sql = "SELECT a.id_proveedor,e.nombre_empresa, a.cedula, p.nombres,p.apellidos, p.direccion, p.genero, p.telefono,p.fecha_nacimiento FROM public.proveedor a JOIN public.persona p ON a.cedula = p.cedula JOIN public.empresa e ON a.id_empresa = e.id_empresa WHERE a.cedula like '" + controladorProveedor.cedulaCienteBuscado + "%'";
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

    public static void BuscarProducto(String texto) {
        Conexion cpg = new Conexion();

        String sql;
        sql = "SELECT codigo_barras, nombre_producto, id_proveedor, descripcion_producto, cantidad_en_bodega, disponibilidad, "
                + "id_categoria, precio_de_compra, precio_de_venta FROM producto WHERE codigo_barras='" + texto + "'";
        ResultSet rs = cpg.consultaDB(sql);
        try {
            rs.next();
            if (rs.getRow() == 0) {
                JOptionPane.showMessageDialog(null, "El producto no existe");
            } else {
                nombre = rs.getString("nombre_producto");
            }
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(ModeloFactura.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static List<Producto> BuscarProducto() {
        Conexion cpg = new Conexion();
        List<Producto> listaProductos = new ArrayList<>();

        String sql;
        sql = "SELECT codigo_barras, nombre_producto, id_proveedor, descripcion_producto, cantidad_en_bodega, disponibilidad, "
                + "id_categoria, precio_de_compra, precio_de_venta FROM producto WHERE codigo_barras LIKE '" + ControladorFactura.codigoBuscar + "%' or codigo_barras LIKE '" + ControladorFactura.codigoBuscar + "%' or nombre_producto LIKE '" + ControladorFactura.codigoBuscar + "%'";
        ResultSet rs = cpg.consultaDB(sql);
        try {
            while (rs.next()) {
                Producto Miproducto = new Producto();
                Miproducto.setId_producto(rs.getString("codigo_barras"));
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
            return null;
        }
    }

    public static List<Producto> listaProductos() {
        Conexion cpg = new Conexion();
        List<Producto> listaProductos = new ArrayList<>();

        String sql;
        sql = "SELECT codigo_barras, nombre_producto, id_proveedor, descripcion_producto, cantidad_en_bodega, disponibilidad, "
                + "id_categoria, precio_de_compra, precio_de_venta FROM producto";
        ResultSet rs = cpg.consultaDB(sql);

        try {
            while (rs.next()) {
                Producto Miproducto = new Producto();
                Miproducto.setId_producto(rs.getString("codigo_barras"));
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

    public static void MandarProducto(String texto) {
        Conexion cpg = new Conexion();

        String sql;
        sql = "SELECT codigo_barras, nombre_producto, precio_de_venta FROM producto WHERE codigo_barras='" + texto + "'";
        ResultSet rs = cpg.consultaDB(sql);
        try {
            rs.next();
            if (rs.getRow() == 0) {
                JOptionPane.showMessageDialog(null, "El producto no existe");
            } else {
                nombre = rs.getString("nombre_producto");
                codigobarras = rs.getString("codigo_barras");
                precio = rs.getFloat("precio_de_venta");
            }
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(ModeloFactura.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public SQLException grabarEncabezadoFacura() {
        String sql;
        sql = "INSERT INTO public.factura(\n"
                + "idfactura, id_administrador, fecha_factura, fac_estado,cedulacliente)\n"
                + "	VALUES ( '" + getIdFctura()+ "', '" + getIdAdministrador()+ "', '" + getFechaFactura()+ "', '" + getEstado()+ "','" + getIdCliente()+ "')";
        return cpg.accionDB(sql);
    }
    
     public SQLException grabarDetalleFacura() {
        String sql = "";
        
        Integer cantidadProductos = ControladorFactura.cantidadProductos;
         for (int i = 0; i < cantidadProductos; i++) {
             sql = "INSERT INTO public.detallefactura(id_productos, cantidad, precio,id_factura) VALUES ('" + ControladorFactura.idproductoV+ "', '" + ControladorFactura.cantidadProductosV+ "','" + ControladorFactura.precioproductosV+ "', '" + ControladorFactura.idFactura+ "')";
         }
        return cpg.accionDB(sql);
    }
     
     public static String generarCodigoFacrura(){
         Conexion cpg = new Conexion();
         
         String sql;
         sql = "SELECT max(idfactura)+1 as codigo FROM factura";
         ResultSet rs = cpg.consultaDB(sql);
        try {
            rs.next();
            String codigoFactura = rs.getString("codigo");
            System.out.println(codigoFactura);
            rs.close();
            return codigoFactura;
        } catch (SQLException ex) {
            Logger.getLogger(ModeloFactura.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
     }
}
