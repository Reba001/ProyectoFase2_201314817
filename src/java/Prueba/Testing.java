/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Prueba;

import Conexiones.DetalleIniciativa;
import Conexiones.Persona;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author aaper
 */
public class Testing {
    public static void main(String[] args) {
        DetalleIniciativa di = new DetalleIniciativa();
        
        ArrayList<String> subcategorias = di.listaSubcategoria(4);
        
        for(String s : subcategorias){
            System.out.println(s);
        }
       
        
                
    }
    
}
