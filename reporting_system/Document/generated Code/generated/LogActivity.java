package Middleware;

import Business.reportController;

/**
 * @author User
 * @version 1.0
 * @created 30-Dec-2020 11:16:32 PM
 */
public class LogActivity {

	private String activityDate;
	private String activityName;
	private String activitiyType;
	public reportController m_reportController;
	public Sponsorship m_Sponsorship;
	public Event m_Event;
	public Graph m_Graph;

	public LogActivity(){

	}

	public void finalize() throws Throwable {

	}

	public String activityDetails(){
		return "";
	}

	/**
	 * 
	 * @param sponsorAvailability
	 * @param sponsorDate
	 * @param sponsorName
	 */
	public Void viewSponsorshipInvolvement(bool sponsorAvailability, String sponsorDate, String sponsorName){

	}

	public Void viewGraph(){

	}

	/**
	 * 
	 * @param eventAlumniParticipant
	 * @param eventAvailability
	 * @param eventDate
	 * @param eventVenue
	 */
	public Void viewEventInvolvement(int eventAlumniParticipant, bool eventAvailability, String eventDate, String eventVenue){

	}

	public void requestSponsorshipInvolvment(){

	}

	public void reqestEventInvolvement(){

	}

	public void requestViewGraph(){

	}

}