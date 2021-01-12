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

    /**
     * @return the eventName
     */
    public String getEventName() {
        return eventName;
    }

    /**
     * @param eventName the eventName to set
     */
    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    /**
     * @return the eventAlumniParticipant
     */
    public int getEventAlumniParticipant() {
        return eventAlumniParticipant;
    }

    /**
     * @param eventAlumniParticipant the eventAlumniParticipant to set
     */
    public void setEventAlumniParticipant(int eventAlumniParticipant) {
        this.eventAlumniParticipant = eventAlumniParticipant;
    }
    
    private String eventName;
    private int eventAlumniParticipant;

	public Event(){
            
	}

	public void finalize() throws Throwable {

	}

	public void getEventInfo(int eventAlumniParticipant,String eventName){
            this.setEventAlumniParticipant(eventAlumniParticipant);
            this.setEventName(eventName);
	}

	public int viewLatestEventInvolvement(){
            return getEventAlumniParticipant();
	}

	public int displayLatestEventInvolvement(){
            return getEventAlumniParticipant();
	}

}