package Middleware;


/**
 * @author fadhi
 * @version 1.0
 * @created 01-Jan-2021 1:24:58 AM
 */
public class Announcement {

	private String announcementID;

    /**
     *
     */
    protected String announcementName;

    /**
     *
     */
    protected String author;

    /**
     *
     */
    protected String date;

    /**
     *
     */
    protected String description;

    /**
     *
     */
    public Announcement(){

    }
    
    public Announcement(String aID,String aName,String author,String date,String desc){
        announcementID = aID;
        announcementName = aName;
        this.author = author;
        this.date = date;
        description = desc;
        
        
    }

	public void finalize() throws Throwable {

	}

	/**
	 * 
	 * @param announcementID
	 */
	public void announcementList(String announcementID){

	}

	/**
	 * 
	 * @param announcementID
	 * @param announcementName
	 * @param author
	 * @param date
	 * @param description
	 */
	public void create(String announcementID, String announcementName, String author, String date, String description){

	}

	/**
	 * 
	 * @param announcementID
	 */
	public void deleteAnnouncement(String announcementID){

	}

	/**
	 * 
	 * @param announcementID
	 * @param announcementName
	 * @param author
	 * @param date
	 * @param description
	 */
	public void RetreiveAnnouncement(String announcementID, String announcementName, String author, String date, String description){

	}

	/**
	 * 
	 * @param announcementID
	 * @param announcementName
	 */
	public void RetreiveList(String announcementID, String announcementName){

	}

    /**
     *
     */
    public void submit(){

	}

	/**
	 * 
	 * @param announcementID
	 * @param announcementName
	 * @param author
	 * @param date
	 * @param description
	 */
	public void update(String announcementID, String announcementName, String author, String date, String description){

	}
        
        public String getAnnouncementName(){
            return announcementName;
	}
        
        public String getAnnouncementDate(){
            return date;
	}

}