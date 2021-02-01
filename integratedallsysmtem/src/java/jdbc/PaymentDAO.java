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
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sdadatabase", "root", "sdadatabase123");
        } catch (Exception e) {
            System.out.println(e);
        }
        return con;
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
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        HttpSession session = request.getSession();
 
        Connection conn = getConnection();
        
        
        String message = null;  // message will be sent back to client
        PreparedStatement statement;
        ResultSet rs;
        
        String sql = "SELECT fileName FROM payment WHERE paymentID=?";
        
        try {
            // constructs SQL statement
            
            statement = conn.prepareStatement(sql);
            
            statement.setString(1, "20");
                        
            rs = statement.executeQuery();
        
         
                // sends the statement to the database server
                
                if (rs.next()) {
                    InputStream input = rs.getBinaryStream("filename");
//                    OutputStream output = response.getOutputStream();
                    response.setContentType("image/gif");
                    
                }
            } catch (SQLException ex) {
                message = "ERROR: " + ex.getMessage();
                ex.printStackTrace();
            } 
        
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
    
    
    public String insertReceipt(InputStream is,String eID, int aID, String name, String cat, double amount, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        HttpSession session = request.getSession();
 
        Connection conn = getConnection();
        
        String message = null;  // message will be sent back to client
        PreparedStatement statement;
        String sql = "INSERT INTO payment (fileName, paidDate, paidTime, alumniName, alumniID, eventName, eventID, paymentStatus, paymentAmount, paymentType) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try {
            // constructs SQL statement
            
            statement = conn.prepareStatement(sql);
            
            if (is != null) {
                // fetches input stream of the upload file for the blob column
                statement.setBlob(1, is);
                java.util.Date date=new java.util.Date();
                java.sql.Date sqlDate=new java.sql.Date(date.getTime());
                java.sql.Timestamp sqlTime=new java.sql.Timestamp(date.getTime());
      
                statement.setDate(2, sqlDate);
                statement.setTimestamp(3, sqlTime);
                statement.setString(4, "hhh");
                statement.setInt(5, aID);
                statement.setString(6, "JJJJ");
                statement.setString(7, eID);
                statement.setString(8, "Pending");
                statement.setDouble(9, amount);
                statement.setString(10, cat);
                
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
    
    
    
    public List<Payment> getFundingList(int aId,HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        
        HttpSession session = request.getSession();
        List<Payment> fundings;
        fundings = new ArrayList<>();
        String dbUrl = null;
        
        Connection conn = getConnection();
        //1
        PreparedStatement ps;
        Statement stmt;
        String sqlQuery;
        ResultSet rs;
        sqlQuery = "SELECT * FROM payment WHERE alumniID=? AND paymentType=?";
        int cw = 0;
       
        try
        {   
            stmt = conn.createStatement();
            ps = conn.prepareStatement(sqlQuery);
            ps.setInt(1, aId);
            ps.setString(2, "fund");
            
            
            rs = ps.executeQuery();
           
            while (rs.next()){
               
                        int paymentID =  rs.getInt("paymentID");
                        String eventName =  rs.getString("eventName");
                        String eventID = rs.getString("eventID");
                        String paymentStatus = rs.getString("paymentStatus");
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
