
package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
/**
 *
 * @author Muaz Amir
 */

import Middleware.Register;
import java.sql.DriverManager;

public class RegisterDAO {
    
    public int registerAlumni(Register register)
        throws ClassNotFoundException{
        String insert_users ="INSERT INTO alumni" + 
                "(Address, CurrentJob,Email, GraduateYear, Name, password, Phone, PreviousJob, "
                + "SalaryCurrent, SalaryPrevious,Status ) VALUES " +
                "(?,?,?,?,?,?,?,?,?,?,?) ; ";
        
        int result = 0;
        
        Class.forName("com.mysql.jdbc.Driver");
        
        try (Connection connection =  DriverManager.getConnection("jdbc:mysql://localhost:3306/mysql_database?useSSL=false", "root", "");
            
                PreparedStatement preparedStatement =connection.prepareStatement(insert_users)){
                preparedStatement.setInt(1,1);
                preparedStatement.setString(2,register.getAddress());
            
                System.out.println(preparedStatement);
                
                result = preparedStatement.executeUpdate();
        }
        
        catch(SQLException e){
            printSQLException(e);
        }
        return result;
                }
    
    private void printSQLException(SQLException ex) {
        for (Throwable e: ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }
    
    
    
    }
