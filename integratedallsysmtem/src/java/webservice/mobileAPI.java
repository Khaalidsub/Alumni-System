/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webservice;
import jdbc.AlumniDAO;
import Middleware.Alumni;
import Middleware.Announcement;
import Middleware.Event;
import Middleware.SignIn;
import com.google.gson.Gson;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpSession;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.PathParam;
import jdbc.UserDAO;
/**
 *
 * @author hp
 */
@Path("endpoints")
public class mobileAPI {
    @GET
    @Path("/getalumnidata") // this path is used to identify method
    @Produces(MediaType.APPLICATION_JSON)
    public String getAlumniData(){
         AlumniDAO a = AlumniDAO.getInstance();
          Gson gson = new Gson();
         
        return gson.toJson(a.getAlumniList());
       
    }
    
    @GET
    @Path("/login/{email}/{password}") // this path is used to identify method
    @Produces(MediaType.APPLICATION_JSON)
    public String login(@PathParam("email") String wemail,@PathParam("password") String wpassword) throws SQLException, ClassNotFoundException{
         AlumniDAO a = AlumniDAO.getInstance();
          Gson gson = new Gson();
         
         String driver = "com.mysql.jdbc.Driver"; 
        String dbName = "sdadatabase";
        String url = "jdbc:mysql://localhost/" + dbName + "?";
        String userName = "root";
        String dbpassword = "";
        
           SignIn si=new SignIn();
        UserDAO user=new UserDAO(driver,url,userName,dbpassword);
         si=user.checkLogin(wemail, wpassword);
         
         if(si!=null)
         {
             
            return gson.toJson(a.getDetailedAlumniInfo(wemail));
         }
         
         return "false";
    }
    
    @GET
    @Path("/getuseraddress/{addressid}") // this path is used to identify method
    @Produces(MediaType.APPLICATION_JSON)
    public String getaddress(@PathParam("addressid") String aid) throws SQLException, ClassNotFoundException{
         AlumniDAO a = AlumniDAO.getInstance();
          Gson gson = new Gson();
        return gson.toJson(a.getAlumniAddressInfo(aid));

    }
    
    @GET
    @Path("/geteventdata") // this path is used to identify method
    @Produces(MediaType.APPLICATION_JSON)
    public String geteeventdata() throws SQLException, ClassNotFoundException{
        
          Gson gson = new Gson();
      
        List<Event> events;
        events = new ArrayList<>();
                                                                                                                              
        Connection conn = getConnection();
        Date todayDate = new Date();
        
        PreparedStatement ps;
        Statement stmt;
        String sqlQuery;
        ResultSet rs;
        sqlQuery = "SELECT * FROM event ORDER BY eventID DESC";
       
        
        try
        {   
       
            stmt = conn.createStatement();
             
            ps = conn.prepareStatement(sqlQuery);

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
                
           
              
               
                Event foundEvent;
                foundEvent = new Event(eID,eName,date ,time,venue,org,fee,fID);
              
                events.add(foundEvent);
                
                
            }
     
            ps.close();
            rs.close();
            conn.close();
          
        }
        catch (Exception ex)
        {
            ex.printStackTrace();

        }
        
        return gson.toJson(events);

    }
    
       @GET
    @Path("/getannouncements") // this path is used to identify method
    @Produces(MediaType.APPLICATION_JSON)
    public String getannouncementdata() throws SQLException, ClassNotFoundException{
        
          Gson gson = new Gson();
      
        List<Announcement> announcements= new ArrayList<>();                                                                                                                
        Connection conn = getConnection();
        Date todayDate = new Date();
        
        PreparedStatement ps;
        Statement stmt;
        String sqlQuery;
        ResultSet rs;
        sqlQuery = "SELECT * FROM `announcement`";
       
        
        try
        {   
       
            stmt = conn.createStatement();
             
            ps = conn.prepareStatement(sqlQuery);

            rs = ps.executeQuery();
         
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
            conn.close();
          
        }
        catch (Exception ex)
        {
            ex.printStackTrace();

        }
        
        return gson.toJson(announcements);

    }
    
    
    
    
    
    
    
    
    
    
    
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
    
    
    
    
}
