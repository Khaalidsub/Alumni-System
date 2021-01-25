/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jdbc;

import java.sql.*;
import Middleware.SignIn;
import Middleware.Admin;

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

    public UserDAO() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
              String insert_users ="INSERT INTO alumni(Title ,Alumniname, password, Alumnimatrics, Gender,Alumnicitizenship, Alumniemail,Phoneno, Coursename ,Edulevel, GraduateYear ) " +
                     " VALUES  (?,?,?,?,?,?,?,?,?,?,?) ";     
              String insert_address = "INSERT INTO alumniaddress(Houseno, Streetname,Region , City , State , Postalcode , Country) ) " +
                    " VALUES  (?,?,?,?,?,?,?) ";
            
            //prepare statement
            psRegisterController = con.prepareStatement(insert_users);    
            psRegisterController = con.prepareStatement(insert_address);  
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
    
    public PreparedStatement getPsRegister(){
        return psRegisterController;
    }
    
    //LOGIN DAO
    
    public void loadDriver(String driver)
	{
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		}
	}
    
    public Connection getConnection()
	{
		Connection con = null;
		try {
			con = DriverManager.getConnection(url, userName, password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return con;
	}
    
    
    public SignIn checkLogin(String email, String password)throws SQLException,
            ClassNotFoundException {
        
         
        loadDriver(driver);
        Connection con = getConnection();
        
        String sql = "select * from alumni where Alumniemail = ? and password = ?";
        PreparedStatement ps;
        

            ps = con.prepareStatement(sql);
            ps.setString(1, email);
            ps.setString(2, password);
            
            ResultSet result=ps.executeQuery();
            
            SignIn signIn = null;
            
            if(result.next()){
                signIn = new SignIn();
                signIn.setName(result.getString("Alumniname"));
                signIn.setEmail(email);
            }
             con.close();      
            return signIn;  
            }
    
    
    public Admin checkAdminLogin(String email, String password) throws SQLException,
            ClassNotFoundException {
        
         
        loadDriver(driver);
        Connection con = getConnection();
        
        String sql = "select * from admin where adminEmail = ? and adminPassword = ?";
        PreparedStatement ps;
        

            ps = con.prepareStatement(sql);
            ps.setString(1, email);
            ps.setString(2, password);
            
            ResultSet result=ps.executeQuery();
            
            Admin admin = null;
            
            if(result.next()){
                admin = new Admin();
                admin.setAdminName("(Admin) "+ (result.getString("adminName")));
                admin.setAdminEmail(email);
            }          
             con.close();      
            return admin;    
       
    }
    
    
}
