package Middleware;
import java.sql.*;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import jdbc.reportingDAO;


/**
 * @author Afiq
 * @version 1.0
 * @created 30-Dec-2020 11:16:38 PM
 */
public class Event {
    
    private String eventName;
    private int eventAlumniParticipant;

	public Event(){
            
	}

	public void finalize() throws Throwable {

	}

	public void getEventInfo(int eventAlumniParticipant,String eventName){
            this.eventAlumniParticipant=eventAlumniParticipant;
            this.eventName=eventName;
	}

	public int viewLatestEventInvolvement(){
            return eventAlumniParticipant;
	}

	public int displayLatestEventInvolvement(){
            return eventAlumniParticipant;
	}

}