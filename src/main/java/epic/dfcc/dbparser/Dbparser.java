/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package epic.dfcc.dbparser;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


/**
 *
 * @author isura_s
 */
public class Dbparser {
    public static void main(String[] args) {
        Connection con = null;
        DBConnection conIns = DBConnection.getConnectionInstance();
        con = conIns.getConnection();
        
        try{
            PreparedStatement psmt=con.prepareStatement("SELECT username, password FROM admin"); 
            ResultSet rs = psmt.executeQuery();
            while(rs.next()){
                System.out.println(rs.getString("username"));
                System.out.println(rs.getString("password"));
                System.out.println("--");
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }finally{
            if(con!=null){
                con=null;
            }
        }
    }
}
