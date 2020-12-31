

/**
 * @author Asus
 * @version 1.0
 * @created 30-Dec-2020 10:06:50 PM
 */
public class SignIn {

	private String ID;
	private String password;
	private SignInController m_SignInController;

	public SignIn(){

	}

	public void finalize() throws Throwable {

	}

	public void accessSignInScreen(){

	}

	public void dispSigned(){

	}

	public SignInController getSignInController(){
		return m_SignInController;
	}

	/**
	 * 
	 * @param ID
	 * @param password
	 */
	public String LoginAcc(String ID, String password){
		return "";
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setSignInController(SignInController newVal){
		m_SignInController = newVal;
	}

	public void userNotFound(){

	}

	public void wrongLogin(){

	}

}