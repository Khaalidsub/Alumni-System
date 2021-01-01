package Middleware;


/**
 * @author mrhr10
 * @version 1.0
 * @created 01-Jan-2021 1:25:02 AM
 */
public class Payment {

	private String alumniID;
	private String alumniName;
	private int eventID;
	private String eventName;
	private float fee;
	private String fileName;
	private String paidDate;
	private String paidTime;
	private int paymentID;

	public Payment(){

	}

	public void finalize() throws Throwable {

	}

	/**
	 * 
	 * @param paymentID
	 */
	public String getFileName(int paymentID){
		return "";
	}

	/**
	 * 
	 * @param receipt
	 * @param alumniID
	 * @param eventID
	 * @param eventName
	 * @param AlumniName
	 * @param fee
	 * @param paymentStatus
	 */
	public void makePayment(String receipt, String alumniID, int eventID, String eventName, String AlumniName, float fee, String paymentStatus){

	}

	/**
	 * 
	 * @param paymentID
	 */
	public void removePaymentDetails(int paymentID){

	}

	/**
	 * 
	 * @param eventID
	 */
	public void retrivePaymentReceipt(String eventID){

	}

}