/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jdbc;

import java.sql.*;
//import Middleware.SignIn;

/**
 *
 * @author muaz amir
 */
public class UserDAO {
    
    Connection con = null;
    String driver;
    String url;
    String userName;
    String password;
    
    PreparedStatement psRegisterController = null;
    PreparedStatement psSignInController = null;
   
    public UserDAO(String driver,
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
            String insert_users ="INSERT INTO alumni(Name, password,Address, Email,CurrentJob, GraduateYear,  PhoneNo, PreviousJob, SalaryPrevious , SalaryCurrent, ,Status ) " +
                     " VALUES  (?,?,?,?,?,?,?,?,?,?,?) ; ";           
            
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
    
    //LOGIN DAO
    /*
    public void prepareSQLStatementLogin(){
        
        try {
           
            //create SQL statement
            //String select_users ="select * from alumni where email = "Email" and password = "password"";        
            //Sign In Statement
            //prepare statement
            psSignInController = con.prepareStatement(select_users);            
        }
        catch (SQLException ex) {
            ex.printStackTrace ();
        }
    }
    
    public PreparedStatement getPsLogin(){
        return psSignInController;
    }
*/
    
    
    
   
    
    
    
}
