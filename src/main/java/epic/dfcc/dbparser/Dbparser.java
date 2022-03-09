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

        getUsers();
        getBookMarks();
        
    }
    public static void getUsers(){
        Connection con = null;
        DBConnection conIns = DBConnection.getConnectionInstance();
        con = conIns.getConnection();
        
        try{
            PreparedStatement psmt=con.prepareStatement("SELECT username, password FROM admin"); 
            ResultSet rs = psmt.executeQuery();
            System.out.println("USERNAME\t\t : \tPASSOWRD");
            System.out.println("___________________________________");
            while(rs.next()){
                System.out.print(rs.getString("username"));
                System.out.print(" \t: ");
                System.out.print(rs.getString("password"));
                System.out.println();
            }
            System.out.println("------------------------------------");
        }catch(Exception ex){
            ex.printStackTrace();
        }finally{
            if(con!=null){
                con=null;
            }
        }
    }
    public static void getBookMarks(){
        Connection con = null;
        DBConnection conIns = DBConnection.getConnectionInstance();
        con = conIns.getConnection();
        
        try{
            PreparedStatement psmt=con.prepareStatement("SELECT name, detail FROM bookmarks"); 
            ResultSet rs = psmt.executeQuery();
            System.out.println("URL\t\t : \tDESCRIPTION");
            System.out.println("___________________________________");
            while(rs.next()){
                System.out.print(rs.getString("name"));
                System.out.print(" \t: ");
                System.out.print(rs.getString("detail"));
                System.out.println();
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
