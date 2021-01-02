package Middleware;

/**
 * @author User
 * @version 1.0
 * @created 01-Jan-2021 1:24:59 AM
 */
public class Event {

	protected String date;
	private String eventID;
	protected String eventName;
	protected float fee;
	protected String organizer;
	protected String time;
	protected String venue;

	public Event(){

	}
        
        public Event(String eventID, String eventName,String date, String time, String venue, String organizer, String fee, String fundingID ){
            this.eventID = eventID;
            this.eventName = eventName;
            this.date = date;
            this.time = time;
            this.venue = venue;
            this.organizer = organizer;
            this.fee = Float.parseFloat(fee);
       
                    
	}

	public void finalize() throws Throwable {

	}

	public void confirmation(){

	}

	public String getDate(){
		return "";
	}

	public void getEventDetails(){
            
	}

	public String getEventID(){
		return "";
	}

	public String getEventName(){
		return "";
	}

	public float getFee(){
		return fee;
	}

	public String getOrganizer(){
		return "";
	}

	public String getTime(){
		return "";
	}

	public String getVenue(){
		return "";
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

}