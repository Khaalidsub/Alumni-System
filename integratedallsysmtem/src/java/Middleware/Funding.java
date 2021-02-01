package Middleware;


/**
 * @author murli
 * @version 1.0
 * @created 01-Jan-2021 1:25:01 AM
 */
public class Funding {

	private int alumniID;
	private String alumniName;
        
	private int eventID;
	private String eventName;
	private String fundingDesc;
	private int fundingID;
        private String date;
        private String fundingName;
        private String description;                
        
      

    /**
     *
     */
    public Funding(){

	}

	public void finalize() throws Throwable {

	}

	/**
	 * 
     * @param fundingID
     * @param eventID
	 * @param eventName
     * @param fundingName
     * @param description
	 * @param funderName
	 * @param date
	 * @param amount
	 * @param receiverName
	 */
	public void create(int fundingID, int eventID ,String date, String fundingName, String description){
            this.eventID = eventID;
            this.description = description;
            this.fundingID = fundingID;
            this.fundingName = fundingName;
            this.date = date;
	}
        
        public String getFundingnName(){
            return fundingName;
        }
        
        public String getFundingnDesc(){
            return description;
        }

	/**
	 * 
	 * @param fund_Id
	 */
	public void delete(String fund_Id){

	}

	/**
	 * 
	 * @param funderName
	 * @param date
	 * @param amount
	 * @param receiverName
	 */
	public void edit(String funderName, String date, int amount, String receiverName){

	}

    /**
     *
     */
    public void fundingList(){
    
    }

}