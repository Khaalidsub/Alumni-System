package Middleware;

import java.io.InputStream;


/**
 * @author mrhr10
 * @version 1.0
 * @created 01-Jan-2021 1:25:02 AM
 */
public class Payment {

	private int alumniID;
	private String alumniName;
	private int eventID;
	private String eventName;
	private int paidAmount;
	private InputStream fileName;
	private String paidDate;
	private String paidTime;
	private int paymentID;
        private String paymentStatus;

    /**
     *
     * @param paymentID
     * @param fileName
     * @param paymentStatus
     * @param eventID
     * @param eventName
     * @param paymentAmount
     * @param paymnetType
     */
        
    public Payment(int paymentID, InputStream fileName, String eventName, int eventID, String paymentStatus, int paymentAmount, String paymnetType){
        this.paymentID = paymentID;
        this.eventName = eventName;
        this.paidAmount = paymentAmount;
        this.paymentStatus = paymentStatus;
        this.eventID = eventID;
        this.fileName = fileName;
    }    
    
    /**
     *
     * @param paymentID
     * @param paymentStatus
     */
    public Payment(int paymentID, String paymentStatus){
        this.paymentID = paymentID;
        this.paymentStatus = paymentStatus;
    }
    
    /**
     *
     * @return
     */
    public String getStatus(){
        return paymentStatus;
    }  
    
    public String getEventName(){
        return eventName;
    }    

    public int getEventID(){
        return eventID;
    }    

    public int getPaymentAmount(){
        return paidAmount;
    }    
    
    
    public int getPaymentID(){
        return paymentID;
    }   
    
   
    public void finalize() throws Throwable {

    }

    /**
     * 
     * @param paymentID
     * @return 
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