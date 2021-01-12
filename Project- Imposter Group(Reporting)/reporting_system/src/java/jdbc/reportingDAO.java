/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jdbc;

import java.sql.*;

/**
 *
 * @author GATES
 */
public class reportingDAO {
    
    Connection con = null;
    String driver;
    String url;
    String userName;
    String password;
    
    PreparedStatement psInsertLogActivity = null;
    PreparedStatement psSelectAllLogActivity = null;
    PreparedStatement psSelectLogActivityById = null;
    PreparedStatement psUpdateLogActivityById = null;  
    PreparedStatement psDeleteLogActivityById = null;  
    PreparedStatement psSelectAllSponsor = null;  
    PreparedStatement psSelectAllEvent = null;
    PreparedStatement psSelectAllAlumni = null;

    public reportingDAO(String driver,
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
    
    public void prepareSQLStatementInsertLogActivity(){
        
        try {
           
            //create SQL statement
            String sqlInsertLogActivity = "INSERT INTO logactivity(name, eventName, sponsorship, qualified, nationality, addeddate)" +
                                      " VALUES(?, ?, ?,?,?, NOW())";            
            
            //prepare statement
            psInsertLogActivity = con.prepareStatement(sqlInsertLogActivity);            
        }
        catch (SQLException ex) {
            ex.printStackTrace ();
        }
    }
    
    public PreparedStatement getPsInsertLogActivity(){
        return psInsertLogActivity;
    }
    
    public void prepareSQLStatementSelectAllLogActivity(){
        
        try {
           
            //create SQL statement
            String sqlSelectAllLogActivity = "SELECT * FROM logactivity";            
            
            //prepare statement
            psSelectAllLogActivity = con.prepareStatement(sqlSelectAllLogActivity);            
        }
        catch (SQLException ex) {
            ex.printStackTrace ();
        }
    }
    
    public PreparedStatement getPsSelectAllLogActivity(){
        return psSelectAllLogActivity;
    }
    
    public void prepareSQLStatementSelectLogActivityById(){
        
        try {
           
            //create SQL statement
            String sqlSelectLogActivityById = "SELECT *" + 
                                          " FROM logactivity" +
                                          " WHERE id = ?";            
            
            //prepare statement
            psSelectLogActivityById = con.prepareStatement(sqlSelectLogActivityById);            
        }
        catch (SQLException ex) {
            ex.printStackTrace ();
        }
    }
    
    public PreparedStatement getPsSelectLogActivityById(){
        return psSelectLogActivityById;
    }
    
    public void prepareSQLStatementUpdateLogActivityById(){
        
        try {
           
            //create SQL statement
            String sqlUpdateLogActivityById = "UPDATE logactivity" +
                                          " set name = ?," +
                                          " eventName = ?" +
                                          " WHERE id = ?";            
            
            //prepare statement
            psUpdateLogActivityById = con.prepareStatement(sqlUpdateLogActivityById);            
        }
        catch (SQLException ex) {
            ex.printStackTrace ();
        }
    }

    public PreparedStatement getPsUpdateLogActivityById(){
        return psUpdateLogActivityById;
    }    
    
    //psDeleteLogActivityById
    public void prepareSQLStatementDeleteLogActivityById(){
        
        try {
           
            //create SQL statement
            String sqlDeleteLogActivityById = "DELETE FROM logactivity" +
                                          " WHERE id = ?";            
            
            //prepare statement
            psDeleteLogActivityById = con.prepareStatement(sqlDeleteLogActivityById);            
        }
        catch (SQLException ex) {
            ex.printStackTrace ();
        }
    } 
    
    public PreparedStatement getPsDeleteLogActivityById(){
        return psDeleteLogActivityById;
    } 
    
     public void prepareSQLStatementSelectAllSponsor(){
        
        try {
           
            //create SQL statement
            String sqlSelectAllSponsor = "SELECT * FROM funding";            
            
            //prepare statement
            psSelectAllSponsor = con.prepareStatement(sqlSelectAllSponsor);            
        }
        catch (SQLException ex) {
            ex.printStackTrace ();
        }
    }
    
    public PreparedStatement getPsSelectAllSponsor(){
        return psSelectAllSponsor;
    }
    
    public void prepareSQLStatementSelectAllEvent(){
        
        try {
           
            //create SQL statement
            String sqlSelectAllEvent = "SELECT * FROM event";            
            
            //prepare statement
            psSelectAllEvent = con.prepareStatement(sqlSelectAllEvent);            
        }
        catch (SQLException ex) {
            ex.printStackTrace ();
        }
    }
    
    public PreparedStatement getPsSelectAllEvent(){
        return psSelectAllEvent;
    }
    
    public void prepareSQLStatementSelectAllAlumni(){
        
        try {
           
            //create SQL statement
            String sqlSelectAllAlumni = "SELECT * FROM alumni";            
            
            //prepare statement
            psSelectAllAlumni = con.prepareStatement(sqlSelectAllAlumni);            
        }
        catch (SQLException ex) {
            ex.printStackTrace ();
        }
    }
    
    public PreparedStatement getPsSelectAllAlumni(){
        return psSelectAllAlumni;
    }
    
}
