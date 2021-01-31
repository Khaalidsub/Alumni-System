package Business;

import Middleware.Event;
import Middleware.SignIn;
import jdbc.EventDAO;
import static com.sun.corba.se.spi.presentation.rmi.StubAdapter.request;
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


/**
 * @author murli
 * @version 1.0
 * @created 01-Jan-2021 12:33:51 AM
 */
@WebServlet(name = "EventController", urlPatterns = {"/EventController"})
public class EventController extends HttpServlet {
    
    private EventDAO eventMapping;
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException{
        HttpSession session = request.getSession();
        SignIn signIn = null;
        signIn = (SignIn) session.getAttribute("signIn");
        String command = request.getParameter("action");
        int event = 0;
        
        try {
            switch (command) {
                //upcoming events
                case "view":
                    getList(request,response);
                    break;
                    
                // view an upcoming event    
                case "selectEvent":
                    event = Integer.parseInt(request.getParameter("eventID"));
                    getEvent(event,request,response);
                    break;
                    
                //join upcimng event
                case "join":
                    event = Integer.parseInt(request.getParameter("eventID"));
                    confirmAlumni(signIn.getEmail(), event, request, response);
                    break;
                    
                //view all joined events    
                case "joinedEvents":
                    getJoinedEvents(signIn.getEmail(), request,response);
                    break;
                
                //view an upcoming event    
                case "selectJoinedEvent":
                    event = Integer.parseInt(request.getParameter("eventID"));
                    getJoinedEvent(event, request, response);
                    break;
                 
                default:
                    break;
            }
                

        } catch (Exception exc) {
            throw new ServletException(exc);
        }
    }

    public EventController(){

    }

    @Override
    public void finalize() throws Throwable {

    }
    
    public void getJoinedEvent(int eId, HttpServletRequest request, HttpServletResponse response){
            
        Event joinedEvent = null;  
        
        try {
            eventMapping = new EventDAO();
            joinedEvent = eventMapping.getJoinedEvent(eId);
            RequestDispatcher dispatcher;
            dispatcher = request.getRequestDispatcher("/viewJoined.jsp");
            request.setAttribute("JOINED_EVENT",joinedEvent);
            dispatcher.forward(request, response);
                
        } catch (IOException | ServletException ex) {
            Logger.getLogger(EventController.class.getName()).log(Level.SEVERE, null, ex);
        } 
        
//        return joinedEvent;
    }
    
    
     public void getJoinedEvents(String aEmail, HttpServletRequest request, HttpServletResponse response){
            
    
        List<Event> joinedEvents = null;  
        try {
            eventMapping = new EventDAO();
            joinedEvents = eventMapping.getJoinedEventList(aEmail, request, response);
           
            RequestDispatcher dispatcher;
            dispatcher = request.getRequestDispatcher("/yourEvents.jsp");
            request.setAttribute("JOINED_EVENT_LIST", joinedEvents );
            dispatcher.forward(request, response);
                
        } catch (IOException | ServletException ex) {
            Logger.getLogger(EventController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * 
     * @param eventID
     * @param request
     * @param response 
     * @throws javax.servlet.ServletException
     * @throws java.io.IOException
	 */
    public void confirmAlumni(String aEmail, int eventID,  HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        eventMapping = new EventDAO();
       
        int r = eventMapping.insertJoinedEvent(eventID, aEmail, request, response);  
        
        SaveSuccessAlumni(aEmail, r, request, response);
    }
    
    /** 
     * 
     * @param r
     * @param request
     * @param response
     */
    public void SaveSuccessAlumni(String aEmail,int r ,HttpServletRequest request, HttpServletResponse response ){
        HttpSession session = request.getSession();
        session.setAttribute("jj", r);
      
        getJoinedEvents(aEmail, request,response);
        
//         try {
//               
////                RequestDispatcher dispatcher;
////                
////                dispatcher = request.getRequestDispatcher("/joinEvent.jsp");
////
////                request.setAttribute("RESULT", r);
////               
////                dispatcher.forward(request, response);
//                
//        
//                
//        } catch (IOException | ServletException ex) {
//            Logger.getLogger(EventController.class.getName()).log(Level.SEVERE, null, ex);
//        } 
    }

	/**
	 * 
	 * @param eventID
	 * @param StaffID
	 */
	public void ConfirmStaff(String eventID, String StaffID){

	}

	/**
	 * 
	 * @param event
	 */
	public void deleteEvent(Event event){

	}

	public void displayDetail(){

	}

	public void displayMessage(){

	}

	/**
	 * 
     * @param selectedEvent
     * @param request
//	 * @param eventID
//	 * @param eventName
//	 * @param date
//	 * @param organizer
//	 * @param time
//	 * @param venue
//	 * @param fee
     * @param response
	 */
	public void eventDetails(Event selectedEvent, HttpServletRequest request, HttpServletResponse response){
             HttpSession session = request.getSession();    
            try {

                Event event = selectedEvent;
                session.setAttribute("c", event);
                RequestDispatcher dispatcher;

                dispatcher = request.getRequestDispatcher("/viewSelected.jsp");

                request.setAttribute("SELECTED_EVENT", event);

                 dispatcher.forward(request, response);


            } catch (Exception ex) {
                Logger.getLogger(EventController.class.getName()).log(Level.SEVERE, null, ex);
            } 
            
	}

	public void getAllEvents(){
            
            
	}

	/**
	 * 
     * @param eId
     * @param request
     * @param response
	 * @param date
	 * @param time 
	 */
//	public void getEvent(String eventID, String eventName, String date, String organizer, String time, String venue, float fee){
//
//	}
        
        public void getEvent(int eId, HttpServletRequest request, HttpServletResponse response){
            
            Event event = null;  
            try {
                eventMapping = new EventDAO();
           
                event = eventMapping.getSelectedEvent(eId ,request, response);
                
                
            } catch (IOException | ServletException ex) {
                Logger.getLogger(EventController.class.getName()).log(Level.SEVERE, null, ex);
            } 
            
            eventDetails(event, request, response);
            
        }

	/**
	 * 
     * @param request
     * @param response
     * @return 
	 */
        public void getList(HttpServletRequest request, HttpServletResponse response){
            
            int alumniID = 2;
            List<Event> events = null;  
            try {
                eventMapping = new EventDAO();
           
                events = eventMapping.getEventList(request, response);
                listEvent(events, request, response);
                
            } catch (IOException | ServletException ex) {
                Logger.getLogger(EventController.class.getName()).log(Level.SEVERE, null, ex);
            }
	}

	/**
	 * 
     * @param events
     * @param request
     * @param response
	 */
	public void listEvent(List<Event> events,HttpServletRequest request, HttpServletResponse response){
            HttpSession session = request.getSession();
            int  h = 6;
            
            try {
                h = 7;
                List<Event> eventList = events;
                session.setAttribute("c", h);
                RequestDispatcher dispatcher;
                
                dispatcher = request.getRequestDispatcher("/viewUpcomingEvents.jsp");

                request.setAttribute("EVENT_LIST", eventList);
               
                dispatcher.forward(request, response);
                
        
                
            } catch (Exception ex) {
                Logger.getLogger(EventController.class.getName()).log(Level.SEVERE, null, ex);
            } 
	}

	/**
	 * 
	 * @param event
	 */
	public void modifyEvent(Event event){

	}

	

	/**
	 * 
	 * @param eventID
	 * @param staffID
	 */
	public void SaveSuccessStaff(String eventID, String staffID){

	}

	/**
	 * 
	 * @param date
	 */
	public void setDate(String date){

	}

	/**
	 * 
	 * @param eventID
	 */
	public void setEventID(String eventID){

	}

	/**
	 * 
	 * @param eventName
	 */
	public void setEventName(String eventName){

	}

	/**
	 * 
	 * @param fee
	 */
	public void setFee(float fee){

	}

	/**
	 * 
	 * @param organizer
	 */
	public void setOrganizer(String organizer){

	}

	/**
	 * 
	 * @param time
	 */
	public void setTime(String time){

	}

	/**
	 * 
	 * @param venue
	 */
	public void setVenue(String venue){

	}

	public void success(){

	}

}