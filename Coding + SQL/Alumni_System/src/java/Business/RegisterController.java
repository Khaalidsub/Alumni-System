

/**
 * @author Asus
 * @version 1.0
 * @created 30-Dec-2020 10:06:48 PM
 */

package business;

import DAO.RegisterDAO;
;

import Middleware.Register;
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
    private RegisterDAO registerDao;
    
    public void init(){
        registerDao = new RegisterDAO();
    }
    
     protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
         
         String Address = request.getParameter("Address");
	 String CurrentJob = request.getParameter("CurrentJob");
	 String Email = request.getParameter("Email");
	 int GraduateYear = Integer.parseInt("GraduateYear");
	 String Name = request.getParameter("Name");
	 String password = request.getParameter("password");
	 String Phone = request.getParameter("Phone");
	 String PreviousJob = request.getParameter("PreviousJob");
	 double SalaryCurrent = Double.parseDouble("SalaryCurrent");
	 double SalaryPrevious = Double.parseDouble("SalaryPrevious");
         String Status = request.getParameter("Email");
         
         Register register = new Register();
         
         register.setAddress(Address);
         register.setCurrentJob(CurrentJob);
         register.setEmail(Email);
         register.setName(Name);
         register.setPassword(password);
         register.setPhone(Phone);
         register.setPreviousJob(PreviousJob);
         register.setSalaryCurrent(SalaryCurrent);
         register.setSalaryPrevious(SalaryPrevious);
         register.setStatus(Status);
         
         try{
             registerDao.registerAlumni(register);
         }catch(Exception e){
             e.printStackTrace();
         }
         
         
         response.sendRedirect("");
     }

        
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