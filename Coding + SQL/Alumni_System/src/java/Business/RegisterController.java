

/**
 * @author Asus
 * @version 1.0
 * @created 30-Dec-2020 10:06:48 PM
 */
public class RegisterController {
        
    boolean valid = true;
	private Database m_Database;

	public RegisterController(){

	}

	public void finalize() throws Throwable {

	    super.finalize();

	}

	public Database getDatabase(){
		return m_Database;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setDatabase(Database newVal){
		m_Database = newVal;
	}

	public boolean validate(){
		return valid;
	}

	/**
	 * 
	 * @param Address
	 * @param CurrentJob
	 * @param PreviousJob
	 * @param Email
	 * @param GraduateYear
	 * @param Name
	 * @param password
	 * @param SalaryCurrent
	 * @param SalaryPrevious
	 * @param Status
	 * @param Phone
	 */
	public void validateDetails(String Address, String CurrentJob, String PreviousJob, String Email, int GraduateYear, String Name, String password, double SalaryCurrent, double SalaryPrevious, String Status, String Phone){

	}

}