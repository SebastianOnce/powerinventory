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
import proyecto_final2024.newpackageControlador.ControladorLogin;

/**
 *
 * @author USER
 */
public class ModeloLogin extends Administrador{
    
    Conexion cpg = new Conexion();
    ControladorLogin login;
    
    
    public ModeloLogin() {
    }
    
    public static List<Administrador> listaAdmin = new ArrayList<>();
    
    public List<Administrador> administradores(){
        Conexion cn = new Conexion();
        
        String sql;//SELECT * FROM TABLA
        sql = "SELECT id_administrador,usuario, contrasena FROM public.administrador  where usuario='"+ login.usuarios+"' and contrasena='"+ login.contrasena +"';";
        ResultSet rs = cn.consultaDB(sql);
         try {
            while (rs.next()) {
                Administrador admin = new Administrador();
                admin.setId_administrador(rs.getString("id_administrador"));
                admin.setUsuario(rs.getString("usuario"));;
                admin.setContraseña(rs.getString("contrasena"));
                listaAdmin.add(admin);
            }
            rs.close();//CIERRO CONEXION CON LA BASE DE DATOS.
            return listaAdmin;
        } catch (SQLException ex) {
            Logger.getLogger(ModeloProducto.class.getName()).log(Level.SEVERE, null, ex);
            return null;//CUANDO REGRESA NULL, HUBO ERROR EN EL QUERY
        }
    }
}
