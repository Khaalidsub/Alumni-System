    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Middleware;

/**
 *
 * @author Afiq
 */

import Business.reportController;

/**
 * @author User
 * @version 1.0
 * @created 30-Dec-2020 11:16:32 PM
 */
public class LogActivity {

    /**
     * @return the alumniName
     */
    public String getAlumniName() {
        return alumniName;
    }

    /**
     * @param alumniName the alumniName to set
     */
    public void setAlumniName(String alumniName) {
        this.alumniName = alumniName;
    }

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
     * @return the qualification
     */
    public String getQualification() {
        return qualification;
    }

    /**
     * @param qualification the qualification to set
     */
    public void setQualification(String qualification) {
        this.qualification = qualification;
    }

    /**
     * @return the nationality
     */
    public String getNationality() {
        return nationality;
    }

    /**
     * @param nationality the nationality to set
     */
    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    /**
     * @return the sponsorName
     */
    public String getSponsorName() {
        return sponsorName;
    }

    /**
     * @param sponsorName the sponsorName to set
     */
    public void setSponsorName(String sponsorName) {
        this.sponsorName = sponsorName;
    }
        private String alumniName;
        private String eventName;
        private String qualification;
        private String nationality;
        private String sponsorName;
        private int eventAlumniParticipant;
        private String  eventDate;
	public reportController m_reportController;
	public Sponsorship m_Sponsorship;
	public Event m_Event;
	public Graph m_Graph;

	public LogActivity(Graph m_Graph,Event m_Event,Sponsorship m_Sponsorship,reportController m_reportController){
            this.m_Graph=m_Graph;
            this.m_Event=m_Event;
            this.m_Sponsorship=m_Sponsorship;
            this.m_reportController=m_reportController;
	}

	public void finalize() throws Throwable {

	}

	public String activityDetails(){
		return (eventDate + eventAlumniParticipant);
	}

	/**
	 * 
	 * @param sponsorAvailability
	 * @param sponsorDate
	 * @param sponsorName
	 */
	public void viewSponsorshipInvolvement(String sponsorName){
            this.setSponsorName(sponsorName);
	}

	public void viewGraph(){
            
	}

	/**
	 * 
	 * @param eventAlumniParticipant
	 * @param eventAvailability
	 * @param eventDate
	 * @param eventVenue
	 */
	public void viewEventInvolvement(int eventAlumniParticipant, String eventDate){
            this.eventAlumniParticipant=eventAlumniParticipant;
            this.eventDate=eventDate;
            
	}


	public int reqestEventInvolvement(){
                return eventAlumniParticipant;
	}

	public void requestViewGraph(){
            
	}

}