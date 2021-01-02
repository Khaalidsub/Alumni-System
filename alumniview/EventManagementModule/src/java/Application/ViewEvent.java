package Application;

import Business.EventHandler;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * @author murli
 * @version 1.0
 * @created 01-Jan-2021 1:07:56 AM
 */

@WebServlet(name = "ViewEvent", urlPatterns = {"/ViewEvent"})
public class ViewEvent extends HttpServlet {
    
    EventHandler evenHandler;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException{

        String command = request.getParameter("command");


        try {
            eventList(request,response);
                

        } catch (Exception exc) {
            throw new ServletException(exc);
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException{
        try {
            String command = request.getParameter("command");
            // if the command is missing, then default to login

//                switch (command) {
//              
//                        break;
//
//                }
        } catch (Exception exc) {
            throw new ServletException(exc);
        }
    }
    
	public ViewEvent(){ 
            evenHandler = new EventHandler(); 
	}

	public void finalize() throws Throwable {

	}

	/**
	 * 
	 * @param eventID
	 * @param eventName
	 * @param date
	 * @param fee
	 * @param organizer
	 * @param venue
	 * @param time
	 */
	public void displayEvent(String eventID, String eventName, String date, float fee, String organizer, String venue, String time){
               
	}

	/**
	 * 
	 * @param eventID
	 * @param eventName
	 */
	public void displayListEvent(String eventID, String eventName){

	}

	/**
	 * 
	 * @param eventID
	 * @param eventName
	 */
//	public void displayListEvent(String eventID, String eventName){
//
//	}

	/**
	 * 
	 * @param eventID
	 * @param eventName
	 * @param date
	 * @param fee
	 * @param organizer
	 * @param venue
	 */
	public void eventDetails(String eventID, String eventName, String date, float fee, String organizer, String venue){

	}

	public void eventList(HttpServletRequest request, HttpServletResponse response){
            evenHandler.getList(request, response);

	}

	public void selectEvent(){

	}

   
}

