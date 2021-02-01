package Application;


/**
 * @author murli
 * @version 1.0
 * @created 01-Jan-2021 1:07:39 AM
 */
public class DeleteEvent {

	private ManageEvent m_ManageEvent;

	public DeleteEvent(){

	}

	public void finalize() throws Throwable {

	}

	/**
	 * 
	 * @param eventID
	 * @param eventName
	 * @param time
	 * @param venue
	 * @param date
	 * @param organizer
	 * @param fee
	 */
	public void deleteEvent(String eventID, String eventName, String time, String venue, String date, String organizer, float fee){

	}

	public void displayList(){

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