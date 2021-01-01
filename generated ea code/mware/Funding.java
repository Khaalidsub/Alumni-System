package Middleware;


/**
 * @author murli
 * @version 1.0
 * @created 01-Jan-2021 1:25:01 AM
 */
public class Funding {

	private String alumniID;
	private String alumniName;
	private int eventID;
	private String eventName;
	private String fundingDesc;
	private int fundingID;

	public Funding(){

	}

	public void finalize() throws Throwable {

	}

	/**
	 * 
	 * @param eventName
	 * @param funderName
	 * @param date
	 * @param amount
	 * @param receiverName
	 */
	public void create(String eventName, String funderName, String date, int amount, String receiverName){

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

	public void fundingList(){

	}

}