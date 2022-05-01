/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package three.level.password.authentication.system;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javax.swing.JOptionPane;

/**
 *
 * @author Suja Mohamed
 */
public class DBConnection {
   
 /*   
    Connection con =null;
    
    public static Connection ConnectDB(){
      
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost/tlpas","root","");
            System.out.println("ConnectionEstablished");
            return con;
            
        } catch (Exception e) {
           JOptionPane.showMessageDialog(null, e);
           return null;
        }  
    } */
        public static Connection ConnectDB() {
        Connection con = null;
        try {
            Class.forName("org.sqlite.JDBC");
            con=DriverManager.getConnection("jdbc:sqlite:lock.sqlite");
            
        } catch (ClassNotFoundException |SQLException e) {
                JOptionPane.showMessageDialog(null, e);
        }
     return con;
    }
        
        
        public static ObservableList<tablelist> getData(){
        Connection con = ConnectDB();
        PreparedStatement ps =null;
        ResultSet rs=null;
        ObservableList list =FXCollections.observableArrayList();
    
        try {
            ps =con.prepareStatement("Select * from officers");
            rs=ps.executeQuery();
            
            while(rs.next()){
                list.add(new tablelist(rs.getString("id"),rs.getString("name"),rs.getString("ia")));
                
            
            }            
            
        } catch (Exception e) {
             JOptionPane.showMessageDialog(null, e);
            
        }finally{
            try {
                ps.cancel();
                rs.close();
            } catch (SQLException ex) {
                Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        
        }
    
    
    return list;
    }
      
 
       
    
}
