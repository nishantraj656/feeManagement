/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataType.Session;

import Database.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author kumar
 */
public class SessionDaoImpl implements SessionDao {
   
    @Override
    public int insertStudent(Session session) {
        try (Connection conn =new DBConnection().connectDB()) {
     
    // code to execute SQL queries goes here...
        String sql = "INSERT INTO sessiontable (sessionID, name) VALUES (?, ?)";
 
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, session.getId());
            statement.setString(2,session.getName());
           

            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("A new user was inserted successfully!");
            }
            conn.close();
        } catch (SQLException ex) {
            
            ex.printStackTrace();
        }
       return 0; 
    }
    
}
