package com.mycompany.proyectobd.unidosporelobjetivo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author angeldvp
 */
public class Principal {

         public static void main(String[] args)   throws ClassNotFoundException, SQLException{
       String hostname = "localhost";
            String sqlInstanceName = "DESKTOP-BUQ5QOC"; //computer name 
            String sqlDatabase = "prueba";  //sql server database name
            String sqlUser = "sa";
            String sqlPassword = "Angpro500"; //passwrod sa account

            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

            //jdbc:sqlserver://localhost:1433;instance=COMPUTERBERRY;databaseName=Database;
            String connectURL = "jdbc:sqlserver://" + hostname + ":1433" 
                    + ";instance=" + sqlInstanceName + ";databaseName=" + sqlDatabase+";encrypt=true; trustServerCertificate=true;" +
     "trustStore=storeName;trustStorePassword=storePassword"+ "hostNameInCertificate=hostName";
;

            Connection conn = DriverManager.getConnection(connectURL, sqlUser, sqlPassword);
            System.out.println("Connect to database successful!!"); 
    
    }
}
