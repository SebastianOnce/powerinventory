/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto_final2024.newpackageModelo;
import java.sql.SQLException;
import java.util.List;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import proyecto_final2024.newpackageControlador.controladorAdministrador;
/**
 *
 * @author elshi
 */
public class ModeloAdministrador extends Administrador{
    
    Conexion cpg = new Conexion();

    public ModeloAdministrador() {
    }
    
    public SQLException grabarAdministrador(){
        
        
        
        String sql;
        
        sql = "INSERT INTO public.administrador	(usuario, contraseña, cedula)"
                + "VALUES( '"+getUsuario()+"', '"+getCedula()+"')";
        return cpg.accionDB(sql);
    }
    
    public static List<Administrador>listarAdministrador(){
        
        Conexion cpg = new Conexion();
        List<Administrador> listaAdministrador = new ArrayList<Administrador>();
        
        String sql;
        sql = "SELECT id_administrador, usuario, contraseña, cedula FROM administrador";
        ResultSet rs = cpg.consultaDB(sql);
        
        try {
            while(rs.next()){
                
                Administrador admin = new Administrador();
                
                
                admin.setId_administrador(rs.getString("id_administrador"));
                admin.setUsuario(rs.getString("usuario"));
                admin.setContraseña(rs.getString("contraseña"));
                admin.setCedula(rs.getString("cedula"));
                
                listaAdministrador.add(admin);
                
            }
            
            rs.close();
            return listaAdministrador;
            
        } catch (SQLException ex) {
            Logger.getLogger(ModeloAdministrador.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        
        
    }
    
    public SQLException eliminarAdministrador() {
        String sql;
        sql = "DELETE FROM public.administrador where = id_administrador'"+ controladorAdministrador.id_admin2+"'";
        return cpg.accionDB(sql);//DEVUELVO NULL SI ES CORRECTO.

    }
    
    public SQLException modificarPersona() {
        String sql;
        sql = "UPDATE public.administrador SET usuario='"+getUsuario()+"', contraseña='"+getContraseña()+"'";
        return cpg.accionDB(sql);//DEVUELVO NULL SI ES CORRECTO.

    }
    
    public static List<Administrador> administradorBuscado(){
        
        Conexion cpg = new Conexion();
        List<Administrador> listaAdmin = new ArrayList<Administrador>();
        
        String sql;
        sql = "SELECT id_administrador, usuario, contraseña, cedula FROM administrador WHERE id_administrador = '"+controladorAdministrador.id_admin2+"'";
        ResultSet rs = cpg.consultaDB(sql);
        
        try {
            while(rs.next()){
                Administrador admin = new Administrador();
                admin.setId_administrador(rs.getString("id_administrador"));
                admin.setUsuario(rs.getString("usuario"));
                admin.setContraseña(rs.getString("contraseña"));
                
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
