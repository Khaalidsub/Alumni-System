package Application;


/**
 * @author murli
 * @version 1.0
 * @created 01-Jan-2021 1:07:43 AM
 */
public class MakePaymentInterface {

	public MakePaymentInterface(){

	}

	public void finalize() throws Throwable {

	}

	/**
	 * 
	 * @param paymentID
	 */
	public void deletePayment(int paymentID){

	}

	public void returnEvents(){

	}

	/**
	 * 
	 * @param deletionMsg
	 */
	public void sendPaymentDeletionMsg(String deletionMsg){

	}

	/**
	 * 
	 * @param failureMesage
	 */
	public void sendPaymentFailedMsg(String failureMesage){

	}

	/**
	 * 
	 * @param message
	 * @param paymentID
	 * @param paymentTime
	 * @param paymentStatus
	 */
	public void sendPaymentSuccessMsg(String message, int paymentID, String paymentTime, String paymentStatus){

	}

	/**
	 * 
	 * @param fileName
	 * @param alumniID
	 * @param eventID
	 */
	public void upload(String fileName, String alumniID, int eventID){

	}

}