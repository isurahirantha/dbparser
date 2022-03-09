/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package epic.dfcc.dbparser;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author isura_s
 */
public class DBConnection {

   
   private static DBConnection DBconIns;
   private Connection connection = null;
   private DBConnection(){
       
   try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");  
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/passworddb","root","password");
            //connection = DriverManager.getConnection("jdbc:mysql://appdb/passworddb","root","password");
        }
        catch(ClassNotFoundException | SQLException e)
        {
            System.out.println(e);
        }
   
   }
   
   public Connection getConnection(){
    return connection;
   }
   
   public static synchronized DBConnection getConnectionInstance(){
       if(DBconIns==null){
       DBconIns = new DBConnection();
       }
       return DBconIns;
   }

}
