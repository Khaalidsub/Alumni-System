/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jdbc;

import Middleware.Event;
import Middleware.Payment;
import Middleware.Funding;
import static com.sun.corba.se.spi.presentation.rmi.StubAdapter.request;


import java.io.IOException;
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
@WebServlet(name = "EventDAO", urlPatterns = {"/EventDAO"})
public class EventDAO extends HttpServlet {
  
    private String driver = "com.mysql.jdbc.Driver";
    private String dbName = "sdadatabase";
    private String url = "jdbc:mysql://localhost:3306/" + dbName + "?";
    private String userName = "root";
    private String password = "";
    
    public Connection getConnection() {
        Connection con = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sdadatabase", "root", "");
        } catch (Exception e) {
            System.out.println(e);
        }
        return con;
    }

    
    /**
     *
     * @param aId
     * @param request
     * @param response
     * @return
     * @throws javax.servlet.ServletException
     * @throws java.io.IOException
     */
    public List<Event> getEventList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        
        HttpSession session = request.getSession();
        List<Event> events;
        events = new ArrayList<>();
                                                                                                                              
        Connection conn = getConnection();
        Date todayDate = new Date();
        
        PreparedStatement ps;
        Statement stmt;
        String sqlQuery;
        ResultSet rs;
        sqlQuery = "SELECT * FROM event ORDER BY eventID DESC";
        String d = null;
        int ff = 0;
        
        try
        {   
            ff =10;
            stmt = conn.createStatement();
             
            ps = conn.prepareStatement(sqlQuery);
//            ps.setString(1, todayDate);
            rs = ps.executeQuery();
         
            while (rs.next()) {
     
                String eID = rs.getString("eventID");
                String eName =  rs.getString("eventName");
                String date =  rs.getString("date");
                String time = rs.getString("time");
                String venue = rs.getString("venue");
                String org = rs.getString("organizer");
                String fee =  rs.getString("fee");
                String fID = rs.getString("fundingID");
                
                d = eID;
              
               
                Event foundEvent;
                foundEvent = new Event(eID,eName,date ,time,venue,org,fee,fID);
                ff = 3;
                events.add(foundEvent);
                
                
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
        session.setAttribute("count", ff);
        return events;
            
        
    }

    
    public Event getSelectedEvent(String eId, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        
        HttpSession session = request.getSession();
        Event event = null;
        String seventID = eId;
        Funding foundFund = null;
       
        Connection conn = getConnection();
        PreparedStatement ps;
        Statement stmt;
        String sqlQuery;
        ResultSet rs;
        sqlQuery = "SELECT * FROM `event` WHERE eventID=?";
        String message = null;
        int c = 0;
        try
        {   
            stmt = conn.createStatement();
            ps = conn.prepareStatement(sqlQuery);
            ps.setString(1, seventID);
            rs = ps.executeQuery();
      
           
            if(rs.next()) {
              
                String eID = rs.getString("eventID");
                String eName =  rs.getString("eventName");
                String date =  rs.getString("date");
                String time = rs.getString("time");
                String venue = rs.getString("venue");
                String org = rs.getString("organizer");
                String fee =  rs.getString("fee");
                String fID = rs.getString("fundingID");
                event = new Event(eID,eName,date ,time,venue,org,fee,fID);
                
                if(fID != null){
                    c = 1;
                    PreparedStatement ps1;
                    String sqlQuery1;
                    ResultSet rs1;
                    sqlQuery1 = "SELECT * FROM `funding` WHERE fundingID=?";
                    
                    try
                    {   
                        
                        ps1 = conn.prepareStatement(sqlQuery1);
                        ps1.setString(1, fID);
                        rs1 = ps1.executeQuery();
                        

                        if(rs1.next()) {
                            c = 2;
                            String fdate =  rs1.getString("date");
                            String fName = rs1.getString("fundingName");
                            String desc = rs1.getString("description");
                            
                            foundFund = new Funding();
                            foundFund.create(fID, seventID, fdate, fName, desc);
                            
                            event.addFunding(foundFund);

                        }
                        ps1.close();
                        rs1.close();
                        

                    }
                    catch (Exception ex)
                    {
                        ex.printStackTrace();
            //            Logger.getLogger(EventMapping.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    
                }
                
                    c=3;
                    PreparedStatement ps2;
                    String sqlQuery2;
                    ResultSet rs2;
                    sqlQuery2 = "SELECT * FROM alumni_event WHERE eventID=?";
                    c=3;
                    try
                    {   
                        
                        ps2 = conn.prepareStatement(sqlQuery2);
                        ps2.setString(1, seventID);
                        rs2 = ps2.executeQuery();
                        

                        if(rs2.next()) {
                            message = "joined";

                        }else{   
                            message = "join";
                        }
                        
                        ps2.close();
                        rs2.close();
                        

                    }
                    catch (Exception ex)
                    {
                        ex.printStackTrace();
            //            Logger.getLogger(EventMapping.class.getName()).log(Level.SEVERE, null, ex);
                    }
                
               
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
        session.setAttribute("MESSAGE", message);
        return event;
            
        
    }
    
    public Event getJoinedEvent(String eId, int aId) throws ServletException, IOException{
        
//        HttpSession session = request.getSession();
        Event event = null;
        String seventID = eId;
        Funding foundFund = null;
                
        Connection conn = getConnection();
        
        PreparedStatement ps;
        Statement stmt;
        String sqlQuery;
        ResultSet rs;
        sqlQuery = "SELECT * FROM `event` WHERE eventID=?";
        String f = null;
        int c = 0;
        try
        {   
            stmt = conn.createStatement();
            ps = conn.prepareStatement(sqlQuery);
            ps.setString(1, seventID);
            rs = ps.executeQuery();
      
           
            if(rs.next()) {
              
                String eID = rs.getString("eventID");
                String eName =  rs.getString("eventName");
                String date =  rs.getString("date");
                String time = rs.getString("time");
                String venue = rs.getString("venue");
                String org = rs.getString("organizer");
                String fee =  rs.getString("fee");
                String fID = rs.getString("fundingID");
     
                event = new Event(eID,eName,date ,time,venue,org,fee,fID);
                
                if(fID != null){
                    c = 1;
                    PreparedStatement ps1;
                    String sqlQuery1;
                    ResultSet rs1;
                    sqlQuery1 = "SELECT * FROM `funding` WHERE fundingID=?";
                    
                    try
                    {   
                        
                        ps1 = conn.prepareStatement(sqlQuery1);
                        ps1.setString(1, fID);
                        rs1 = ps1.executeQuery();
                        

                        if(rs1.next()) {
                            c = 2;
                            String fdate =  rs1.getString("date");
                            String fName = rs1.getString("fundingName");
                            String desc = rs1.getString("description");
                            
                            foundFund = new Funding();
                            foundFund.create(fID, seventID, fdate, fName, desc);
                            
                            event.addFunding(foundFund);

                        }
                        ps1.close();
                        rs1.close();
                        

                    }
                    catch (Exception ex)
                    {
                        ex.printStackTrace();
            //            Logger.getLogger(EventMapping.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
               
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
//        session.setAttribute("cou", f);
        return event;
            
        
    }
    
    
    public int insertJoinedEvent(String eId, int aId, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        
        HttpSession session = request.getSession();
        Event event = null;
        int result = 0;
                
        Connection conn = getConnection();
        
        PreparedStatement pss;
        ResultSet rs;
        Statement stmt;
        String sqlTest = "SELECT * FROM alumni_event WHERE alumniID=? AND eventID=?";
        String c;
        
        try {
            stmt = conn.createStatement();
            pss = conn.prepareStatement(sqlTest);
           
            pss.setInt(1, aId);
            pss.setString(2, eId);
     
            rs = pss.executeQuery();
            while (rs.next()) {
                result = 1;
            }
            
            pss.close();
            
        }
        catch(SQLException ex) {
            System.out.println(ex.getMessage());
        }
        
        if(result == 0){
            
            PreparedStatement pi;
            String sqlInsert = "INSERT INTO alumni_event(alumniID,eventID) VALUES(?,?)";
            
            try {
                pi = conn.prepareStatement(sqlInsert);
                result = 2;
                pi.setInt(1, aId);
                pi.setString(2, eId);
                
                    // execute insert SQL stetement
                pi.executeUpdate();
               
                pi.close();
                conn.close();
                
            }catch(SQLException ex) {
                System.out.println(ex.getMessage());
            } 
        }

        return result;
          
    }
    
    public List<Event> getJoinedEventList(int aId,HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        
        HttpSession session = request.getSession();
        List<Event> events;
        events = new ArrayList<>();
        String dbUrl = null;
        Connection conn = getConnection();
        
        //1
        PreparedStatement ps;
        Statement stmt;
        String sqlQuery;
        ResultSet rs;
        sqlQuery = "SELECT e.* FROM event e , alumni_event a WHERE e.eventID = a.eventID AND a.alumniID=?";
        int cw = 0;
       
        try
        {   
            stmt = conn.createStatement();
            ps = conn.prepareStatement(sqlQuery);
            ps.setInt(1, aId);
            rs = ps.executeQuery();
           
            while (rs.next()){
    
                String eID = rs.getString("eventID");
                String eName =  rs.getString("eventName");
                String date =  rs.getString("date");
                String time = rs.getString("time");
                String venue = rs.getString("venue");
                String org = rs.getString("organizer");
                String fee =  rs.getString("fee");
                String fID = rs.getString("fundingID");
                
                Event foundEvent;
                foundEvent = new Event(eID,eName,date ,time,venue,org,fee,fID);
              
        
                if(!("Free".equals(fee))){
                    
                    PreparedStatement ps1;
                      
                    ResultSet rs1;
                    String sqlQuery2;
                    sqlQuery2 = "SELECT paymentID, paymentStatus FROM payment WHERE eventID=? AND alumniID=?";

                    try
                    {   
                        stmt = conn.createStatement();
                        ps1 = conn.prepareStatement(sqlQuery2);
                        ps1.setString(1, eID);
                        ps1.setInt(2, aId);
                        rs1 = ps1.executeQuery();


                        if (rs1.next()) {

                            int pID = rs1.getInt("paymentID");
                            String paymentStatus = rs1.getString("paymentStatus");
                            
                            Payment paid = new Payment(pID, paymentStatus);
                            foundEvent.addPayment(paid);

                        }

                        
                        
                    }
                    catch (Exception ex)
                    {
                        ex.printStackTrace();
                        Logger.getLogger(EventDAO.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    cw = 99;
                    events.add(foundEvent);
                }else{
                    cw =88;
                    events.add(foundEvent);
                }    
                    
//                cw++;
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
        return events;
        
    }
    
    
    public Event getPaidEvent(String eId, int aId, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        
        HttpSession session = request.getSession();
        Event event = null;
        String seventID = eId;
                
        Connection conn = getConnection();
        
        PreparedStatement ps;
        Statement stmt;
        String sqlQuery;
        ResultSet rs;
        sqlQuery = "SELECT * FROM `event` WHERE eventID=?";
       
       int c = 0;
        try
        {   
            stmt = conn.createStatement();
            ps = conn.prepareStatement(sqlQuery);
            ps.setString(1, seventID);
            rs = ps.executeQuery();
      
           
            if(rs.next()) {
               
                c = 9;
                String eID = rs.getString("eventID");
                String eName =  rs.getString("eventName");
                String date =  rs.getString("date");
                String time = rs.getString("time");
                String venue = rs.getString("venue");
                String org = rs.getString("organizer");
                String fee =  rs.getString("fee");
                String fID = rs.getString("fundingID");
          
                event = new Event(eID,eName,date ,time,venue,org,fee,fID);
               
                PreparedStatement ps1;
                ResultSet rs1;
                String sqlQuery2;
                sqlQuery2 = "SELECT paymentID, paymentStatus, fileName, paidDate, paidTime FROM payment WHERE eventID=? AND alumniID=?";

                    try
                    {   
                        stmt = conn.createStatement();
                        ps1 = conn.prepareStatement(sqlQuery2);
                        ps1.setString(1, eID);
                        ps1.setInt(2, aId);
                        rs1 = ps1.executeQuery();


                        if (rs1.next()) {

                            int pID = rs1.getInt("paymentID");
                            String paymentStatus = rs1.getString("paymentStatus");
                            String fileName = rs1.getString("fileName");
                            
                            Payment paid = new Payment(pID, paymentStatus);
                            event.addPayment(paid);

                        }else{
                            
                            event.addPayment(null);
                        }

                        
             
                    }
                    catch (Exception ex)
                    {
                        ex.printStackTrace();
                        Logger.getLogger(EventDAO.class.getName()).log(Level.SEVERE, null, ex);
                    }
                
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
        session.setAttribute("cou", seventID);
        return event;
            
        
    }
    
    

    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
