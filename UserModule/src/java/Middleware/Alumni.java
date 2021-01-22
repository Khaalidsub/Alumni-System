package Middleware;



/**
 * @author Asus
 * @version 1.0
 * @created 30-Dec-2020 10:06:35 PM
 */
public class Alumni implements User {

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
	

	public Alumni(){

	}



	public void dispError(){
               System.out.println("Error");
	}

	public void displaySignInScreen(){

	}

	public void dispPic(){

	}

	public void dispSuccess(){
               System.out.println("Success");
	}

	public void dispUserAcc(){
                   System.out.println("Alumni");
	}

	public void showSuggestions(){

	}

}