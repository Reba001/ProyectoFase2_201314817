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
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Scanner;
import javax.servlet.http.HttpSession;

/**
 *
 * @author aaper
 */
public class Testing {
    public static void main(String[] args) throws ParseException {
        Calendar fecha = new GregorianCalendar();
        String f = ""+fecha.get(Calendar.DAY_OF_MONTH)+"/"+(fecha.get(Calendar.MONTH)+1)+"/"+fecha.get(Calendar.YEAR);
        String h = ""+fecha.get(Calendar.HOUR_OF_DAY);
        System.out.println(f);
        System.out.println(h);
        DetalleIniciativa di = new DetalleIniciativa();
        
        List<String> cadenas = new ArrayList();
        cadenas.add(h);
        cadenas.add(f);
        cadenas.add("prueba");
        cadenas.add("si hubo un buen resultado");
        if(cadenas != null){
            for(String c : cadenas){
                System.out.println(c);
            }
                
        }else {
            System.out.println("nada :V");
                    
        }
        
                
    }
    
}
