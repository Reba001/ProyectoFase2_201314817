/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataBase;

/**
 *
 * @author aaper
 */

import java.sql.Connection;
import java.sql.DriverManager;

import java.sql.SQLException;
import javax.swing.JOptionPane;
import org.postgresql.Driver;
    public class Conexion {

         //-- DRIVER --
        private static final String DB_DRIVER = "org.postgresql.Driver";

        private static final String cHOST = "127.0.0.1";
        private static final String cPORT = "5432"; //Postgresql PORT
        private static final String cDATABASE = "ProyectoFase2_201314817";

        // -- DATOS DE USUARIO DE BD -- //
        private static final String cUSER = "postgres";
        private static final String cPASSWORD = "26653754Zu";

        private static final String DB_CONNECTION = "jdbc:postgresql://" + cHOST + ":" + cPORT + "/" + cDATABASE;
        //jdbc:postgresql://HOST:PORT/basedeDatos
        /**
        * Metodo para conectar a la base de datos.
        * @return Conexion
        */
        public Connection getDBConnection() {
            Connection dbConnection = null;
            try {
                Class.forName(DB_DRIVER);
                System.out.println("Conectado :v ");
            } catch (ClassNotFoundException e) {
                System.out.println(e.getMessage());
                System.out.println("Error: "+ e.toString());
            }
            try {
                dbConnection = DriverManager.getConnection(DB_CONNECTION, cUSER, cPASSWORD);
                System.out.println("Conectado papu 2");
                return dbConnection;
            } catch (SQLException e) {
                System.out.println(e.getMessage());
                System.out.println("Error2 : "+e.toString());
            }
                return dbConnection;
        }

        public static java.sql.Timestamp getCurrentTimeStamp() {
            java.util.Date today = new java.util.Date();
            return new java.sql.Timestamp(today.getTime());
        }
        
        
    }
