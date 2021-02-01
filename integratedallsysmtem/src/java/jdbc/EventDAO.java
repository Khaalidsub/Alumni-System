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
    private String url = "jdbc:mysql://localhost:/" + dbName + "?";
    private String userName = "root";
    private String password = "sdadatabase123";
    
    private static EventDAO firstInstance = null;
    
    public static EventDAO getInstance(){
        
        if(firstInstance == null){
            firstInstance = new EventDAO();
            
        }
        
        return firstInstance;
    }
    
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
     
    public List<Event> getAllRecords() {
        List<Event> list = new ArrayList<Event>();

        try {
            Connection con = getConnection();
            PreparedStatement ps = con.prepareStatement("select * from event");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Event e = new Event();
                e.setEventID(rs.getInt("eventID"));
                e.setEventName(rs.getString("eventName"));
                e.setDate(rs.getString("date"));
                e.setTime(rs.getString("time"));
                e.setVenue(rs.getString("venue"));
                e.setOrganizer(rs.getString("organizer"));
                e.setFee(rs.getString("fee"));
                list.add(e);
            }
        } catch (Exception f) {
            System.out.println(f);
        }
        return list;
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
     
                int eID = rs.getInt("eventID");
                String eName =  rs.getString("eventName");
                String date =  rs.getString("date");
                String time = rs.getString("time");
                String venue = rs.getString("venue");
                String org = rs.getString("organizer");
                String fee =  rs.getString("fee");
                int fID = rs.getInt("fundingID");
                
           
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

    
    public Event getSelectedEvent(int eId, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        
        HttpSession session = request.getSession();
        Event event = null;
        int seventID = eId;
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
            ps.setInt(1, seventID);
            rs = ps.executeQuery();
      
           
            if(rs.next()) {
              
                int eID = rs.getInt("eventID");
                String eName =  rs.getString("eventName");
                String date =  rs.getString("date");
                String time = rs.getString("time");
                String venue = rs.getString("venue");
                String org = rs.getString("organizer");
                String fee =  rs.getString("fee");
                int fID = rs.getInt("fundingID");
                event = new Event(eID,eName,date ,time,venue,org,fee,fID);
                
                if(fID != 0){
                    c = 1;
                    PreparedStatement ps1;
                    String sqlQuery1;
                    ResultSet rs1;
                    sqlQuery1 = "SELECT * FROM `funding` WHERE fundingID=?";
                    
                    try
                    {   
                        
                        ps1 = conn.prepareStatement(sqlQuery1);
                        ps1.setInt(1, fID);
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
                        ps2.setInt(1, seventID);
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
    
    public Event getJoinedEvent(int eId) throws ServletException, IOException{
        
//        HttpSession session = request.getSession();
        Event event = null;
        int seventID = eId;
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
            ps.setInt(1, seventID);
            rs = ps.executeQuery();
      
           
            if(rs.next()) {
              
                int eID = rs.getInt("eventID");
                String eName =  rs.getString("eventName");
                String date =  rs.getString("date");
                String time = rs.getString("time");
                String venue = rs.getString("venue");
                String org = rs.getString("organizer");
                String fee =  rs.getString("fee");
                int fID = rs.getInt("fundingID");
     
                event = new Event(eID,eName,date ,time,venue,org,fee,fID);
                
                if(fID != 0){
                    c = 1;
                    PreparedStatement ps1;
                    String sqlQuery1;
                    ResultSet rs1;
                    sqlQuery1 = "SELECT * FROM `funding` WHERE fundingID=?";
                    
                    try
                    {   
                        
                        ps1 = conn.prepareStatement(sqlQuery1);
                        ps1.setInt(1, fID);
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
    
    
    public int insertJoinedEvent(int eId, String aEmail, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        
        HttpSession session = request.getSession();
        Event event = null;
        int result = 0;
                
        int aID = getAlumniID(aEmail, request, response);
        Connection conn = getConnection();
        
        PreparedStatement pss;
        ResultSet rs;
        Statement stmt;
        String sqlTest = "SELECT * FROM alumni_event WHERE alumniID=? AND eventID=?";
        String c;
        
        try {
            stmt = conn.createStatement();
            pss = conn.prepareStatement(sqlTest);
           
            pss.setInt(1, aID);
            pss.setInt(2, eId);
     
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
            String sqlInsert = "INSERT INTO alumni_event(AlumniID,eventID) VALUES(?,?)";
            
            try {
                pi = conn.prepareStatement(sqlInsert);
                result = 2;
                pi.setInt(1, aID);
                pi.setInt(2, eId);
                
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
    
    public List<Event> getJoinedEventList(String aEmail, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        
        HttpSession session = request.getSession();
        List<Event> events;
        events = new ArrayList<>();
        String dbUrl = null;
        Connection conn = getConnection();
        
        int aID = getAlumniID(aEmail, request, response);
        
        //1
        PreparedStatement ps;
        Statement stmt;
        String sqlQuery;
        ResultSet rs;
        sqlQuery = "SELECT e.* FROM event e , alumni_event a WHERE e.eventID = a.eventID AND a.AlumniID=?";
        int cw = 0;
       
        try
        {   
            stmt = conn.createStatement();
            ps = conn.prepareStatement(sqlQuery);
            ps.setInt(1, aID);
            rs = ps.executeQuery();
           
            while (rs.next()){
    
                int eID = rs.getInt("eventID");
                String eName =  rs.getString("eventName");
                String date =  rs.getString("date");
                String time = rs.getString("time");
                String venue = rs.getString("venue");
                String org = rs.getString("organizer");
                String fee =  rs.getString("fee");
                int fID = rs.getInt("fundingID");
                
                Event foundEvent;
                foundEvent = new Event(eID,eName,date ,time,venue,org,fee,fID);
                
        
                if(!("Free".equals(fee))){
                    cw = 1;
                    PreparedStatement ps1;
                      
                    ResultSet rs1;
                    String sqlQuery2;
                    sqlQuery2 = "SELECT paymentID, status FROM viewpayment WHERE eventID=? AND AlumniID=?";

                    try
                    {   
                        
                        ps1 = conn.prepareStatement(sqlQuery2);
                        ps1.setInt(1, eID);
                        ps1.setInt(2, aID);
                        rs1 = ps1.executeQuery();


                        if (rs1.next()) {

                            int pID = rs1.getInt("paymentID");
                            String paymentStatus = rs1.getString("status");
                            
                            Payment paid = new Payment(pID, paymentStatus);
                            foundEvent.addPayment(paid);

                        }

                        
                        
                    }
                    catch (Exception ex)
                    {
                        ex.printStackTrace();
                        
                    }
                    
                    events.add(foundEvent);
                }else{
                    
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
    
//    
//    public Event getPaidEvent(String eId, int aId, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
//        
//        HttpSession session = request.getSession();
//        Event event = null;
//        String seventID = eId;
//                
//        Connection conn = getConnection();
//        
//        PreparedStatement ps;
//        Statement stmt;
//        String sqlQuery;
//        ResultSet rs;
//        sqlQuery = "SELECT * FROM `event` WHERE eventID=?";
//       
//       int c = 0;
//        try
//        {   
//            stmt = conn.createStatement();
//            ps = conn.prepareStatement(sqlQuery);
//            ps.setString(1, seventID);
//            rs = ps.executeQuery();
//      
//           
//            if(rs.next()) {
//               
//                c = 9;
//                String eID = rs.getString("eventID");
//                String eName =  rs.getString("eventName");
//                String date =  rs.getString("date");
//                String time = rs.getString("time");
//                String venue = rs.getString("venue");
//                String org = rs.getString("organizer");
//                String fee =  rs.getString("fee");
//                String fID = rs.getString("fundingID");
//          
//                event = new Event(eID,eName,date ,time,venue,org,fee,fID);
//               
//                PreparedStatement ps1;
//                ResultSet rs1;
//                String sqlQuery2;
//                sqlQuery2 = "SELECT paymentID, paymentStatus, fileName, paidDate, paidTime FROM payment WHERE eventID=? AND alumniID=?";
//
//                    try
//                    {   
//                        stmt = conn.createStatement();
//                        ps1 = conn.prepareStatement(sqlQuery2);
//                        ps1.setString(1, eID);
//                        ps1.setInt(2, aId);
//                        rs1 = ps1.executeQuery();
//
//
//                        if (rs1.next()) {
//
//                            int pID = rs1.getInt("paymentID");
//                            String paymentStatus = rs1.getString("paymentStatus");
//                            String fileName = rs1.getString("fileName");
//                            
//                            Payment paid = new Payment(pID, paymentStatus);
//                            event.addPayment(paid);
//
//                        }else{
//                            
//                            event.addPayment(null);
//                        }
//
//                        
//             
//                    }
//                    catch (Exception ex)
//                    {
//                        ex.printStackTrace();
//                        Logger.getLogger(EventDAO.class.getName()).log(Level.SEVERE, null, ex);
//                    }
//                
//            } 
//     
//            ps.close();
//            rs.close();
//            conn.close();
//          
//        }
//        catch (Exception ex)
//        {
//            ex.printStackTrace();
////            Logger.getLogger(EventMapping.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        
//        HttpSession session = request.getSession(); 
//        session.setAttribute("cou", seventID);
//        return event;
//            
        
//    }
    
    

    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
