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
    
        private String date;
        private int eventID;
        private String eventName;
        private String fee;
        private String organizer;
        private String time;
        private String venue;
        private int fundingID;
        private Funding funding;
        private Payment payment;
        private int pID;
        private String paymentStatus = "not paid";
        private int eventAlumniParticipant;

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

        public Event(){

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
        
        

        /**
         *
         * @param eventID
         * @param eventName
         * @param date
         * @param time
         * @param venue
         * @param organizer
         * @param fee
         * @param fundingID
         */
        public Event(int eventID, String eventName,String date, String time, String venue, String organizer, String fee, int fundingID ){
                this.eventID = eventID;
                this.eventName = eventName;
                this.date = date;
                this.time = time;
                this.venue = venue;
                this.organizer = organizer;
                this.fee = fee;
                this.fundingID = fundingID;
        }

        public void addFunding(Funding f){
            funding = f;
        }

        public Funding getFunding(){
            return funding;
        }

       public int getFundingID(){
           return fundingID;
       }

        public void addPayment(Payment p){
            payment = p;
        }

        public Payment getPayment(){
            return payment;
        }    

        public void setPaymentID(int pid){
            pID = pid;
            paymentStatus = "paid";
        }

        public String getPaymentStatus(){
            return paymentStatus;
        }

        /**
         *
         */
        public void confirmation(){

        }

        /**
         *
         * @return
         */
        public String getDate(){
            return date;
        }

        /**
         *
         */
        public void getEventDetails(){

        }

        /**
         *
         * @return
         */
        public int getEventID(){
            return eventID;
        }

        /**
         *
         * @return
         */
        public String getFee(){
            return fee;
        }

        /**
         *
         * @return
         */
        public String getOrganizer(){
            return organizer;
        }

        /**
         *
         * @return
         */
        public String getTime(){
            return time;
        }

        /**
         *
         * @return
         */
        public String getVenue(){
            return venue;
        }

	/**
	 * 
	 * @param eventID
	 * @param eventName
	 */
	public void retreiveEvent(String eventID, String eventName){

	}

	/**
	 * 
	 * @param eventID
	 * @param eventName
	 */
	public void retreivelist(String eventID, String eventName){
            
            
	}

        /**
         *
         */
        public void save(){
            
	}

	/**
	 * 
	 * @param eventID
	 * @param alumniID
	 */
	public void saveDataAlumni(String eventID, String alumniID){

	}

	/**
	 * 
	 * @param eventID
	 * @param staffID
	 */
	public void saveDataStaff(String eventID, String staffID){

	}
        
        public void setDate(String date){
                this.date = date;
	}

	/**
	 * 
	 * @param eventID
	 */
	public void setEventID(int eventID){
                this.eventID = eventID;
	}

	/**
	 * 
	 * @param eventName
	 */
	

	/**
	 * 
	 * @param fee
	 */
	public void setFee(String fee){
                this.fee = fee;
	}

	/**
	 * 
	 * @param organizer
	 */
	public void setOrganizer(String organizer){
                this.organizer = organizer;
	}

	/**
	 * 
	 * @param time
	 */
	public void setTime(String time){
                this.time = time;
	}

	/**
	 * 
	 * @param venue
	 */
	public void setVenue(String venue){
                this.venue = venue;
	}
}