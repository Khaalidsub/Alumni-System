package Business;

import Middleware.Announcement;
import jdbc.AnnouncementDAO;
import Middleware.Event;
import java.util.ArrayList;
import java.util.List;
import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.System.out;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpSession;
import jdbc.EventDAO;

/**
 * @author murli
 * @version 1.0
 * @created 01-Jan-2021 12:33:49 AM
 */
@WebServlet(name = "AnnouncementController", urlPatterns = {"/AnnouncementController"})
public class AnnouncementController extends HttpServlet {
    private AnnouncementDAO aDAO;
    private List<Announcement> announcements = null; 
    
    
    /**
     *
     * @param request
     * @param response
     * @throws ServletException
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException{

        String command = request.getParameter("command");
        

        try {
            switch (command) {
                case "announcementList":
                    getList(request, response);
                    break;
                case "select":
                    int announcementID = Integer.parseInt(request.getParameter("announcementID"));
                    existingAnouncement(announcementID ,request,response);
                    break;

                default:
                    break;
            }
                
                
            
                

        } catch (Exception exc) {
            throw new ServletException(exc);
        }

    }


    /**
     *
     */
    public AnnouncementController(){

	}
    
    public void getList(HttpServletRequest request, HttpServletResponse response){
                        
            
//            view = new ViewAnnouncement();
            try {
                aDAO = new AnnouncementDAO();
           
                announcements = aDAO.getAnnouncementList();
                
                
            } catch (IOException | ServletException ex) {
                Logger.getLogger(EventController.class.getName()).log(Level.SEVERE, null, ex);
            } 
            
            ListAnnouncement(announcements, request, response);
             
    }

	public void finalize() throws Throwable {
            
	}

	/**
	 * 
	 * @param announcementID
	 * @param announcementName
	 * @param author
	 * @param date
	 * @param description
	 */
	public void announcementDetails(int announcementID, String announcementName, String author, String date, String description){
            
	}

	/**
	 * 
	 * @param anouncementID
	 */
	public void existingAnouncement(int anouncementID, HttpServletRequest request, HttpServletResponse response){
            AnnouncementDAO a = AnnouncementDAO.getInstance();
            Announcement selected = null;
            try {
                
                selected = a.getAnnouncement(anouncementID);
                RequestDispatcher dispatcher;
                dispatcher = request.getRequestDispatcher("/selectAnnouncement.jsp");
                request.setAttribute("SELECTED_ANNOUNCEMENT",selected);
                dispatcher.forward(request, response);
                
            } catch (IOException | ServletException ex) {
                Logger.getLogger(EventController.class.getName()).log(Level.SEVERE, null, ex);
            } 
	}

	/**
	 * 
	 * @param announcementID
	 * @param announcementName
	 * @param author
	 * @param date
	 * @param description
	 */
	public void getAnnouncement(String announcementID, String announcementName, String author, String date, String description){
                
	}

	/**
	 * 
	 * @param announcementID
	 * @param announcementName
	 */
	

	/**
	 * 
	 * @param announcementID
	 * @param announcementName
	 */
	public void ListAnnouncement(List<Announcement> announcements,HttpServletRequest request, HttpServletResponse response){
               try {
                
                List<Announcement> a = announcements; 
                RequestDispatcher dispatcher;
                
                dispatcher = request.getRequestDispatcher("/viewAnnouncement.jsp");

                request.setAttribute("ANNOUNCEMENT_LIST", a);
               
                dispatcher.forward(request, response);
                
        
                
            } catch (Exception ex) {
                Logger.getLogger(EventController.class.getName()).log(Level.SEVERE, null, ex);
            } 
	}

}