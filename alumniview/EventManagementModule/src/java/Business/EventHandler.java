package Business;

import Middleware.Event;
import Mapping.eventMapping;
import java.util.ArrayList;
import java.util.List;

import java.io.IOException;
import java.io.PrintWriter;
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
public class EventHandler {
    
        private eventMapping EventMapping;

	public EventHandler(){

	}

	public void finalize() throws Throwable {

	}

	/**
	 * 
	 * @param eventID
	 * @param alumniID
	 */
	public void ConfirmAlumni(String eventID, String alumniID){

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
	 * @param eventID
	 * @param eventName
	 * @param date
	 * @param organizer
	 * @param time
	 * @param venue
	 * @param fee
	 */
	public void eventDetails(String eventID, String eventName, String date, String organizer, String time, String venue, float fee){

	}

	public void getAllEvents(){
            
            
	}

	/**
	 * 
	 * @param eventID
	 * @param eventName
	 * @param date
	 * @param organizer
	 * @param time
	 * @param venue
	 * @param fee
	 */
	public void getEvent(String eventID, String eventName, String date, String organizer, String time, String venue, float fee){

	}

	/**
	 * 
	 * @param eventID
	 * @param eventName
	 */
//	public void getList(String eventID, String eventName){
//               
//            
//	}
        
        public void getList(HttpServletRequest request, HttpServletResponse response){
            
            EventMapping = new eventMapping();
            try {
                List<Event> events = EventMapping.getEventList();
                
                RequestDispatcher dispatcher;
                
                dispatcher = request.getRequestDispatcher("viewEvent.jsp");
                request.setAttribute("EVENT_LIST", events);
                dispatcher.forward(request, response);
            } catch (Exception ex) {
                Logger.getLogger(EventHandler.class.getName()).log(Level.SEVERE, null, ex);
            } 
             
            
	}

	/**
	 * 
	 * @param eventID
	 * @param eventName
	 */
	public void listEvent(String eventID, String eventName){

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
	 * @param alumniID
	 */
	public void SaveSuccessAlumni(String eventID, String alumniID){

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