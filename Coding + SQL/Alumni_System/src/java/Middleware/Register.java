

/**
 * @author Asus
 * @version 1.0
 * @created 30-Dec-2020 10:06:46 PM
 */
public class Register {

	private String Address;
	private String CurrentJob;
	private String Email;
	private int GraduateYear;
	private String Name;
	private String password;
	private String Phone;
	private String PreviousJob;
	private double SalaryCurrent;
	private double SalaryPrevious;
	private String Status;
	private RegisterController m_RegisterController;
	private SignIn m_SignIn;

	public Register(){

	}

	public void finalize() throws Throwable {

	}

	public void accessRegisterScreen(){

	}

	public void displayExample(){

	}

	public void errorMessage(){

	}

	public RegisterController getRegisterController(){
		return m_RegisterController;
	}

	public SignIn getSignIn(){
		return m_SignIn;
	}

	/**
	 * 
	 * @param Address
	 * @param CurrentJob
	 * @param Email
	 * @param GraduateYear
	 * @param Name
	 * @param password
	 * @param PreviousJob
	 * @param SalaryCurrent
	 * @param SalaryPrevious
	 * @param Status
	 * @param Phone
	 */
	public void RegisterNew(String Address, String CurrentJob, String Email, int GraduateYear, String Name, String password, String PreviousJob, double SalaryCurrent, double SalaryPrevious, String Status, String Phone){

	}

	/**
	 * 
	 * @param newVal
	 */
	public void setRegisterController(RegisterController newVal){
		m_RegisterController = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setSignIn(SignIn newVal){
		m_SignIn = newVal;
	}

	public void successMessage(){

	}

}