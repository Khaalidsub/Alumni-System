/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jdbc;

import Middleware.Announcement;
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
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpSession;


/**
 *
 * @author haiswin
 */
@WebServlet(name = "AnnouncementDAO", urlPatterns = {"/AnnouncementDAO"})
public class AnnouncementDAO extends HttpServlet {
  
    
    private Connection con;
    private String driver = "com.mysql.jdbc.Driver";
    private String dbName = "sdadatabase";
    private String url = "jdbc:mysql://db:3306/" + dbName + "?";
    private String userName = "root";
    private String password = "sdadatabase123";
  
//   @Override
//   public void init() throws ServletException
//    {
//        String driver = "com.mysql.jdbc.Driver";
//
//        String dbName = "scsj3303";
//        String url = "jdbc:mysql://localhost/" + dbName + "?";
//        String userName = "root";
//        String password = "";
//        
//        try {
//            Class.forName(driver);
//            con = DriverManager.getConnection(url, userName, password);
//        } catch (ClassNotFoundException | SQLException ex) {
//            Logger.getLogger(EventMapping.class.getName()).log(Level.SEVERE, null, ex);
//        }
//
//
////        jdbcUtility = new JDBCUtility(driver,
////                                      url,
////                                      userName,
////                                      password);
////
////        jdbcUtility.jdbcConnect();
////        con = jdbcUtility.jdbcGetConnection();
//    }    
    
    /**
     *
     * @param request
     * @param response
     * @return
     * @throws javax.servlet.ServletException
     * @throws java.io.IOException
     */
    public List<Announcement> getAnnouncementList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        
        HttpSession session = request.getSession();
        List<Announcement> announcements;
        announcements = new ArrayList<>();
      
        try {
            Class.forName(driver);
            con = DriverManager.getConnection(url, userName, password);
            
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(EventDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        PreparedStatement ps;
        Statement stmt;
        String sqlQuery;
        ResultSet rs;
        sqlQuery = "SELECT * FROM `announcement`";
       
        try
        {   
            stmt = con.createStatement();
            ps = con.prepareStatement(sqlQuery);
            rs = ps.executeQuery();
            
//            if(con == null){
//                c =10;
//            }    
           
            while (rs.next()) {
               
                String aID = rs.getString("announcementID");
                String aName =  rs.getString("announcementName");
                String author = rs.getString("author");
                String date = rs.getString("date");
                String desc = rs.getString("description");
             
               
                Announcement foundAnnouncement;
                foundAnnouncement = new Announcement(aID,aName,author,date,desc);
                announcements.add(foundAnnouncement);
         
            }
     
            ps.close();
            rs.close();
            con.close();
          
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
            Logger.getLogger(EventDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
//        HttpSession session = request.getSession(); 
//        session.setAttribute("count", dbUrl);
        return announcements;
            
        
    }

    
//    public Event getSelectedEvent(String eId, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
//        
//        HttpSession session = request.getSession();
//        Event event = null;
//        String seventID = eId;
//                
//        try {
//            Class.forName(driver);
//            con = DriverManager.getConnection(url, userName, password);
//            
//        } catch (ClassNotFoundException | SQLException ex) {
//            Logger.getLogger(EventMapping.class.getName()).log(Level.SEVERE, null, ex);
//        }
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
//            stmt = con.createStatement();
//            ps = con.prepareStatement(sqlQuery);
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
//            }else{
//                c =8;
//            }    
//     
//            ps.close();
//            rs.close();
//            con.close();
//          
//        }
//        catch (Exception ex)
//        {
//            ex.printStackTrace();
////            Logger.getLogger(EventMapping.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        
////        HttpSession session = request.getSession(); 
//        session.setAttribute("cou", seventID);
//        return event;
//            
//        
//    }

    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}