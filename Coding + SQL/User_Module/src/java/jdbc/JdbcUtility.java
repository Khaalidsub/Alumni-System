/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jdbc;

import java.sql.*;
import Middleware.SignIn;

/**
 *
 * @author muaz amir
 */
public class JdbcUtility {
    
    Connection con = null;
    String driver;
    String url;
    String userName;
    String password;
    
    PreparedStatement psRegisterController = null;
    PreparedStatement psSignInController = null;
   
    public JdbcUtility(String driver,
                       String url,
                       String userName,
                       String password) {
        this.driver = driver;
        this.url = url;
        this.userName = userName;
        this.password = password;
    }
    
    public  void jdbcConnect(){
        
        try {
         
            Class.forName (driver);
            con = DriverManager.getConnection(url, userName, password);
            DatabaseMetaData dma = con.getMetaData ();
            System.out.println("\nConnected to " + dma.getURL());
            System.out.println("Driver       " + dma.getDriverName());
            System.out.println("Version      " + dma.getDriverVersion());
            System.out.println("");
            
	}
	catch (SQLException ex){
            
            while (ex != null){
		System.out.println ("SQLState: " + ex.getSQLState ());
                System.out.println ("Message:  " + ex.getMessage ());
		System.out.println ("Vendor:   " + ex.getErrorCode ());
                ex = ex.getNextException ();
		System.out.println ("");
            }

            System.out.println("Connection to the database error");
	}
	catch (java.lang.Exception ex){
            ex.printStackTrace ();
	}
    }
    
    public Connection jdbcGetConnection(){
        return con;
    }
    
    public void jdbcConClose(){
        
   	try {
         con.close();
   	}
   	catch (Exception ex){
            ex.printStackTrace ();
        }
        
    }
    
    public void prepareSQLStatementRegister(){
        
        try {
           
            //create SQL statement
            String insert_users ="INSERT INTO alumni" + 
                "(Address, CurrentJob,Email, GraduateYear, Name, password, PhoneNo, PreviousJob, "
                + "SalaryCurrent, SalaryPrevious,Status ) VALUES " +
                "(?,?,?,?,?,?,?,?,?,?,?) ; ";           
            
            //prepare statement
            psRegisterController = con.prepareStatement(insert_users);            
        }
        catch (SQLException ex) {
            ex.printStackTrace ();
        }
    }
    
    public PreparedStatement getPsRegister(){
        return psRegisterController;
    }
    
    public void prepareSQLStatementSignIn(){
        
        SignIn signIn = new SignIn();
   
        
        try {
           
            //create SQL statement
            PreparedStatement preparedStatement = connection.prepareStatement("select * from alumni where email = ? and password = ? ")) {
			preparedStatement.setString(1, SignIn.());
			preparedStatement.setString(2, loginBean.getPassword());

			System.out.println(preparedStatement);
			ResultSet rs = preparedStatement.executeQuery();
			status = rs.next();        
            
            //prepare statement
            psRegisterController = con.prepareStatement(insert_users);            
        }
        catch (SQLException ex) {
            ex.printStackTrace ();
        }
        
        }
        
    }
    
   
    
    
    
}
