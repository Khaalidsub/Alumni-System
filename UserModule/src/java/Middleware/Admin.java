

/**
 * @author Asus
 * @version 1.0
 * @created 30-Dec-2020 10:06:30 PM
 */
public class Admin extends User {

	private String AdminEmail;
	private String AdminID;
	private String AdminName;
	private AdminUI m_AdminUI;

	public Admin(){

	}

	public void finalize() throws Throwable {
		super.finalize();
	}

	public void dispError(){

	}

	public void displayError(){

	}

	public void displaySignInScreen(){

	}

	public void displaySuccess(){

	}

	public void displayUser(){

	}

	public void dispPic(){

	}

	public void dispSuccess(){

	}

	public void dispUserAcc(){

	}

	public AdminUI getAdminUI(){
		return m_AdminUI;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setAdminUI(AdminUI newVal){
		m_AdminUI = newVal;
	}

	public void showSuggestions(){

	}

}