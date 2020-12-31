

/**
 * @author Asus
 * @version 1.0
 * @created 30-Dec-2020 10:06:52 PM
 */
public class SignInController {

	private Database m_Database;
	private ManageAcc m_ManageAcc;

	public SignInController(){

	}

	public void finalize() throws Throwable {

	}

	public Database getDatabase(){
		return m_Database;
	}

	public ManageAcc getManageAcc(){
		return m_ManageAcc;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setDatabase(Database newVal){
		m_Database = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setManageAcc(ManageAcc newVal){
		m_ManageAcc = newVal;
	}

	/**
	 * 
	 * @param ID
	 * @param password
	 */
	public String validateUser(String ID, String password){
		return "";
	}

}