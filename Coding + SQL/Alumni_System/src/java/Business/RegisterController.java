

/**
 * @author Asus
 * @version 1.0
 * @created 30-Dec-2020 10:06:48 PM
 */

package business;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet (name="RegisterController" , urlPatterns = {"/register"} )
public class RegisterController extends HttpServlet{
        
    boolean valid = true;
	//private Database m_Database;

	public RegisterController(){

	}

	public void finalize() throws Throwable {

	    super.finalize();

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