/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Prueba;

import Conexiones.DetalleIniciativa;
import Conexiones.Iniciativa;
import Conexiones.Persona;
import static com.sun.corba.se.spi.presentation.rmi.StubAdapter.request;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;
import javax.servlet.http.HttpSession;

/**
 *
 * @author aaper
 */
public class Testing {
    public static void main(String[] args) {
        Calendar fecha = new GregorianCalendar();
        String f = ""+fecha.get(Calendar.DAY_OF_MONTH)+"/"+(fecha.get(Calendar.MONTH)+1)+"/"+fecha.get(Calendar.YEAR);
        System.out.println(f);
        
        DetalleIniciativa di = new DetalleIniciativa();
        di.publicarIniciativa("Reba", "si");
        ArrayList<Iniciativa> iniciativas = di.getlistaIniciativa();
        
        for(Iniciativa ini : iniciativas ){
            System.out.println(ini.getIdiniciativa());
            System.out.println(ini.getNombre());
            System.out.println(ini.getDescripcion());
            System.out.println(ini.getFechainicio());
            System.out.println(ini.getFechafinal());
            System.out.println(ini.getMetaEconomica());
            System.out.println(ini.getIdUsuario());
            System.out.println(ini.getIdSubcategoria());
        }
        
                
    }
    
}
