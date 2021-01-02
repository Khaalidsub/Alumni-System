package Application;


/**
 * @author murli
 * @version 1.0
 * @created 01-Jan-2021 1:07:44 AM
 */
public class ManageAnnouncement {

	private createAnnouncement m_createAnnouncement;
	private deleteAnnouncement m_deleteAnnouncement;

	public ManageAnnouncement(){

	}

	public void finalize() throws Throwable {

	}

	public void announcement(){

	}

	public createAnnouncement getcreateAnnouncement(){
		return m_createAnnouncement;
	}

	public deleteAnnouncement getdeleteAnnouncement(){
		return m_deleteAnnouncement;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setcreateAnnouncement(createAnnouncement newVal){
		m_createAnnouncement = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setdeleteAnnouncement(deleteAnnouncement newVal){
		m_deleteAnnouncement = newVal;
	}

}