/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jdbc;

/**
 *
 * @author haisw
 */
import Business.EventController;
import Middleware.Event;
import Middleware.Payment;
import static com.sun.corba.se.spi.presentation.rmi.StubAdapter.request;
import java.io.File;


import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import static java.lang.System.out;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.servlet.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpSession;


/**
 *
 * @author haiswin
 */
@WebServlet(name = "PaymentDAO", urlPatterns = {"/PaymentDAO"})
public class PaymentDAO extends HttpServlet {
  
    private String driver = "com.mysql.jdbc.Driver";
    private String dbName = "sdadatabase";
    private String url = "jdbc:mysql://db:3306/" + dbName + "?";
    private String userName = "root";
    private String password = "sdadatabase123";
    
    public Connection getConnection() {
        Connection con = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://db:3306/sdadatabase", "root", "sdadatabase123");
        } catch (Exception e) {
            System.out.println(e);
        }
        return con;
    }
    
    public int getAlumniID(String email, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        
        HttpSession session = request.getSession();
                                                                                                                              
        Connection conn = getConnection();
       
        
        PreparedStatement ps;
        Statement stmt;
        String sqlQuery;
        ResultSet rs;
        sqlQuery = "SELECT AlumniID FROM alumni WHERE Alumniemail=?";
        String d = null;
        int ff = 0;
        int aID = 0;
        try
        {   
           
            stmt = conn.createStatement();
            ps = conn.prepareStatement(sqlQuery);
            ps.setString(1, email);
            rs = ps.executeQuery();
         
            if(rs.next()) {
     
                aID = rs.getInt("AlumniID");
                
            }
     
            ps.close();
            rs.close();
            conn.close();
          
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
//            Logger.getLogger(EventMapping.class.getName()).log(Level.SEVERE, null, ex);
        }
        

        return aID;
            
        
    }
    
    public String getEventName(int eID) throws ServletException, IOException{
        
                                                                                  
        Connection conn = getConnection();
       
        
        PreparedStatement ps;
        Statement stmt;
        String sqlQuery;
        ResultSet rs;
        sqlQuery = "SELECT eventName FROM event WHERE eventID=?";
        String d = null;
        int ff = 0;
        String eventName = null;
        try
        {   
           
            stmt = conn.createStatement();
            ps = conn.prepareStatement(sqlQuery);
            ps.setInt(1, eID);
            rs = ps.executeQuery();
         
            if(rs.next()) {
     
                eventName = rs.getString("eventName");
                
            }
     
            ps.close();
            rs.close();
            conn.close();
          
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
//            Logger.getLogger(EventMapping.class.getName()).log(Level.SEVERE, null, ex);
        }
        

        return eventName;
            
        
    }
    
    private static PaymentDAO firstInstance = null;
    
    public static PaymentDAO getInstance(){
        
        if(firstInstance == null){
            firstInstance = new PaymentDAO();
            
        }
        
        return firstInstance;
    }

   
    
    /**
     *
     * @param is
     * @param eID
     * @param aID
     * @param request
     * @param response
     * @return 
     * @throws javax.servlet.ServletException
     * @throws java.io.IOException
     */
    
    
    public String insertReceipt(InputStream is,int eID, String aEmail, String name, String cat, double amount, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        HttpSession session = request.getSession();
 
        Connection conn = getConnection();
        int aID = getAlumniID(aEmail, request, response);
        
        String message = null;  // message will be sent back to client
        PreparedStatement statement;
        String sql = "INSERT INTO viewpayment (Alumniname, AlumniID, eventName, eventID, fileName, status, paymentType, paymentAmount, paidDate, paidTime) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try {
            // constructs SQL statement
            
            statement = conn.prepareStatement(sql);
            
            if (is != null) {
                // fetches input stream of the upload file for the blob column
                
                java.util.Date date=new java.util.Date();
                java.sql.Date sqlDate=new java.sql.Date(date.getTime());
                java.sql.Timestamp sqlTime=new java.sql.Timestamp(date.getTime());
                
                String eventName = getEventName(eID);
                
                statement.setString(1, name);
                statement.setInt(2, aID);
                statement.setString(3, eventName);
                statement.setInt(4, eID);
                statement.setBlob(5, is);
                statement.setString(6, "Pending");
                statement.setString(7, cat);
                statement.setDouble(8, amount);
                statement.setDate(9, sqlDate);
                statement.setTimestamp(10, sqlTime);
              
            }
                // sends the statement to the database server
                int row = statement.executeUpdate();
                if (row > 0) {
                    message = "File uploaded and saved into database";
                }
            } catch (SQLException ex) {
                message = "ERROR: " + ex.getMessage();
                ex.printStackTrace();
            } finally {
                if (conn!= null) {
                    // closes the database connection
                    try {
                        conn.close();
                    } catch (SQLException ex) {
                        ex.printStackTrace();
                    }
                }
            }
        return message;
        
    }
    
    
    
    public List<Payment> getFundingList(String aEmail, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        
        HttpSession session = request.getSession();
        List<Payment> fundings;
        fundings = new ArrayList<>();
        String dbUrl = null;
        
        Connection conn = getConnection();
        int aID = getAlumniID(aEmail, request, response);
        //1
        PreparedStatement ps;
        Statement stmt;
        String sqlQuery;
        ResultSet rs;
        sqlQuery = "SELECT * FROM viewpayment WHERE AlumniID=? AND paymentType=?";
        int cw = 0;
       
        try
        {   
            stmt = conn.createStatement();
            ps = conn.prepareStatement(sqlQuery);
            ps.setInt(1, aID);
            ps.setString(2, "fund");
            
            
            rs = ps.executeQuery();
           
            while (rs.next()){
               
                        int paymentID =  rs.getInt("paymentID");
                        String eventName =  rs.getString("eventName");
                        int eventID = rs.getInt("eventID");
                        String paymentStatus = rs.getString("status");
                        int paymentAmount = rs.getInt("paymentAmount");
                        String paymnetType =  rs.getString("paymentType");
                        InputStream fileName = null;
//                        java.sql.Time dbSqlTime = rs.getTime("paidDate");
//                        java.sql.Date dbSqlDate = rs.getDate("paidTime");

                        Payment funding;
                        funding = new Payment(paymentID, fileName, eventName, eventID, paymentStatus, paymentAmount, paymnetType);



                        fundings.add(funding);
                        
                    }
                   
          
            
            
            ps.close();
            rs.close();
            conn.close();
          
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
//            Logger.getLogger(EventMapping.class.getName()).log(Level.SEVERE, null, ex);
        }
        
//        HttpSession session = request.getSession(); 
        session.setAttribute("count", cw);
        return fundings;
        
    }
    
    

    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
