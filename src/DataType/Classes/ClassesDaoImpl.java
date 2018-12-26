/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataType.Classes;

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
public class ClassesDaoImpl implements ClassesDao{

    @Override
    public int insertClasses(Classes classes) {
        int i=0;
        Connection con =new DBConnection().connectDB();
        if(con !=null ){
            try {
                String sql = "INSERT INTO `classtable`(`Name`, `Fee`, `computer`) VALUES (?,?,?)";
                PreparedStatement stm=con.prepareStatement(sql);
                stm.setString(1,classes.getName());
                stm.setInt(2,classes.getTutionFee());
                stm.setInt(3,classes.getComputer());
                i = stm.executeUpdate();
               
                
            } catch (SQLException ex) {
                Logger.getLogger(ClassesDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
                System.out.print(ex);
            }
            try {
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(ClassesDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
                System.out.print(ex);
            }
         }
        return i;
    }
    
     @Override
    public Classes[] selectClasses() {
       int i = -1;
        Classes[] cls = new Classes[30];
       // Vector
        Connection con =new DBConnection().connectDB();
        if(con !=null ){
            try {
                String sql = "SELECT `ClassID`, `Name`, `Fee`, `computer` FROM `classtable`";
               Statement stmt=con.createStatement();  
                ResultSet rs=stmt.executeQuery(sql);
               
                
                while(rs.next()){
                   i+=1;
                    cls[i] =new Classes();
                    
                    cls[i].setId(rs.getInt("ClassID"));
                    cls[i].setName(rs.getString("Name"));
                    cls[i].setTutionFee(rs.getInt("Fee"));
                    cls[i].setComputer(rs.getInt("computer"));
                    
                }
               
                
            } catch (SQLException ex) {
                Logger.getLogger(ClassesDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
                System.out.print("Select Me error");
                System.out.print(ex);
            }
            try {
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(ClassesDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
                System.out.print(ex);
            }
         }
       
        return cls;
    }
    
     @Override
    public int updateClasses(Classes classes) {
        int i=0;
        Connection con =new DBConnection().connectDB();
        if(con !=null ){
            try {
                String sql = "UPDATE `classtable` SET `Name`=?,`Fee`=?,`computer`=? WHERE  `ClassID`=?";
                PreparedStatement stm=con.prepareStatement(sql);
                stm.setString(1,classes.getName());
                stm.setInt(2,classes.getTutionFee());
                stm.setInt(3,classes.getComputer());
                stm.setInt(4,classes.getId());
                i = stm.executeUpdate();
               
                
            } catch (SQLException ex) {
                System.out.print("\n\nError during update");
                Logger.getLogger(ClassesDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
                
                System.out.print(ex);
            }
            try {
                con.close();
            } catch (SQLException ex) {
                  System.out.print("\n\nError during update");
                Logger.getLogger(ClassesDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
                System.out.print(ex);
            }
         }
        return i;
    }
    
}
