/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto_final2024.newpackageControlador;

import java.io.FileInputStream;
import proyecto_final2024.newpackageModelo.ModeloPersona;

/**
 *
 * @author elshi
 */
public class controladorPersonas {
    
    private ModeloPersona modelo;
    
    static public String cedula2,id2,nombres2,apellidos2,direccion2,genero2,telefono2,fecha_nacimiento2;
    static public String cedulaPersonaBuscar;
    private FileInputStream Pep;

    public controladorPersonas() {
    }
    
    public controladorPersonas(ModeloPersona modelo){
        this.modelo = modelo;
        
        
    }
    
    public void iniciaControl(){
        
        
    }
    
}
