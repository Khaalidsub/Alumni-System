package Application;


/**
 * @author murli
 * @version 1.0
 * @created 01-Jan-2021 1:07:53 AM
 */
public class UpdateEvent {

	private ManageEvent m_ManageEvent;

	public UpdateEvent(){

	}

	public void finalize() throws Throwable {

	}

	public void displayDetail(){

	}

	public ManageEvent getManageEvent(){
		return m_ManageEvent;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setManageEvent(ManageEvent newVal){
		m_ManageEvent = newVal;
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
	 */
	public void updateEvent(String eventID, String eventName, String date, String time, String venue, String organizer, float fee){

	}

}