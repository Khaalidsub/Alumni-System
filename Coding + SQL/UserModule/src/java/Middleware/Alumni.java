

/**
 * @author Asus
 * @version 1.0
 * @created 30-Dec-2020 10:06:35 PM
 */
public class Alumni extends User {

	private String AlumniAddress;
	protected String AlumniCurrentJob;
	protected String AlumniEmail;
	protected int AlumniGraduateYear;
	protected String AlumniLocation;
	protected String AlumniMembershipNo;
	protected String AlumniName;
	private String AlumniPhoneNo;
	private String AlumniPreviousJob;
	private double AlumniSalaryPrevious;
	private double AlumniSalaryuCurrent;
	protected String AlumniSatus;
	private Homepage m_Homepage;

	public Alumni(){

	}

	public void finalize() throws Throwable {
		super.finalize();
	}

	public void dispError(){

	}

	public void displaySignInScreen(){

	}

	public void dispPic(){

	}

	public void dispReqScreen(){

	}

	public void dispSuccess(){

	}

	public void dispUserAcc(){

	}

	public Homepage getHomepage(){
		return m_Homepage;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setHomepage(Homepage newVal){
		m_Homepage = newVal;
	}

	public void showSuggestions(){

	}

}