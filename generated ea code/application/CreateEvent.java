package Application;


/**
 * @author murli
 * @version 1.0
 * @created 01-Jan-2021 1:07:36 AM
 */
public class CreateEvent {

	private ManageEvent m_ManageEvent;

	public CreateEvent(){

	}

	public void finalize() throws Throwable {

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
	public createEvent(String eventID, String eventName, String date, String time, String venue, String organizer, float fee){

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

}