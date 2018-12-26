/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataType.Session;

import Database.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author kumar
 */
public class SessionDaoImpl implements SessionDao {
   
   @Override
    public int insertSession(Session session) {
        int i=0;
        Connection con =new DBConnection().connectDB();
        if(con !=null ){
           
            try {
                
                String sql = "INSERT INTO `sessiontable`(`Name`) VALUES (?)";
                PreparedStatement stm=con.prepareStatement(sql);
                stm.setString(1,session.getName());
                i = stm.executeUpdate();
                
                
                
                try {
                    con.close();
                } catch (SQLException ex) {
                    Logger.getLogger(SessionDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
                    System.out.print(ex);
                }
            } catch (SQLException ex) {
                Logger.getLogger(SessionDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
         }
        return i;
    }
    
     @Override
    public Session[] selectSession() {
       int i = -1;
        Session[] cls = new Session[30];
       // Vector
        Connection con =new DBConnection().connectDB();
        if(con !=null ){
            try {
                String sql = "SELECT `sessionID`, `Name` FROM `sessiontable`";
               Statement stmt=con.createStatement();  
                ResultSet rs=stmt.executeQuery(sql);
               
                
                while(rs.next()){
                   i+=1;
                    cls[i] =new Session();
                    
                    cls[i].setId(rs.getInt("sessionID"));
                    cls[i].setName(rs.getString("Name"));
                   
                    
                }
               
                
            } catch (SQLException ex) {
                Logger.getLogger(SessionDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
                System.out.print("Select Me error");
                System.out.print(ex);
            }
            try {
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(SessionDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
                System.out.print(ex);
            }
         }
       
        return cls;
    }
    
     @Override
    public int updateSession(Session session) {
        int i=0;
        Connection con =new DBConnection().connectDB();
        if(con !=null ){
            try {
                String sql = "UPDATE `sessiontable` SET `Name`=? WHERE `sessionID`=?";
                PreparedStatement stm=con.prepareStatement(sql);
                stm.setString(1,session.getName());
                
                stm.setInt(2,session.getId());
                i = stm.executeUpdate();
               
                
            } catch (SQLException ex) {
                System.out.print("\n\nError during update");
                Logger.getLogger(SessionDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
                
                System.out.print(ex);
            }
            try {
                con.close();
            } catch (SQLException ex) {
                  System.out.print("\n\nError during update");
                Logger.getLogger(SessionDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
                System.out.print(ex);
            }
         }
        return i;
    }
    
    
}
