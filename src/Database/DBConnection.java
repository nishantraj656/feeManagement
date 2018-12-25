/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author kumar
 */
public class DBConnection {
    
    private Connection conn;
    private ResultSet resultSet;
    private Statement smt;

    public Connection connectDB(){
        String dbURL = "jdbc:mysql://localhost:3306/hemalayan?zeroDateTimeBehavior=convertToNull";//"jdbc:oracle:thin:@localhost:1521:xe";
        String username = "root";
        String password = "";
        boolean flag =false;

        try {

           conn = DriverManager.getConnection(dbURL, username, password);
        } catch (SQLException ex) {
        }
        return conn;
    }
   
    
    
    
}
