/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Prueba;

import Conexiones.DetalleIniciativa;
import Conexiones.Persona;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;

/**
 *
 * @author aaper
 */
public class Testing {
    public static void main(String[] args) {
        Calendar fecha = new GregorianCalendar();
        String f = ""+fecha.get(Calendar.DAY_OF_MONTH)+"/"+(fecha.get(Calendar.MONTH)+1)+"/"+fecha.get(Calendar.YEAR);
        System.out.println(f);
                
    }
    
}
