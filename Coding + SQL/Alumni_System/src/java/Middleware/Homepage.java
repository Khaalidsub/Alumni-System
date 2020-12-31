
import Middleware.Register;



/**
 * @author Asus
 * @version 1.0
 * @created 30-Dec-2020 10:06:41 PM
 */
public class Homepage {

	private SignIn m_SignIn;
	private Register m_Register;

	public Homepage(){

	}

	public void finalize() throws Throwable {

	}

	public Register getRegister(){
		return m_Register;
	}

	public SignIn getSignIn(){
		return m_SignIn;
	}

	public void onClickReg(){

	}

	public void onClickSignin(){

	}

	/**
	 * 
	 * @param newVal
	 */
	public void setRegister(Register newVal){
		m_Register = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setSignIn(SignIn newVal){
		m_SignIn = newVal;
	}

}