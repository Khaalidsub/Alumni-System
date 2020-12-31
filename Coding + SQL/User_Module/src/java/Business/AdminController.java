

/**
 * @author Asus
 * @version 1.0
 * @created 30-Dec-2020 10:06:32 PM
 */
public class AdminController {

	private Database m_Database;

	public AdminController(){

	}

	public void finalize() throws Throwable {

	}

	/**
	 * 
	 * @param ID
	 */
	public String delete(String ID){
		return "";
	}

	public Database getDatabase(){
		return m_Database;
	}

	/**
	 * 
	 * @param ID
	 */
	public String SearchUsername(String ID){
		return "";
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setDatabase(Database newVal){
		m_Database = newVal;
	}

}