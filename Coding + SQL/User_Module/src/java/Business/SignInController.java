

/**
 * @author Asus
 * @version 1.0
 * @created 30-Dec-2020 10:06:52 PM
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

import java.sql.*;
import jdbc.JdbcUtility;
import Middleware.SignIn;


@WebServlet (name="SignInController" , urlPatterns = {"/SignInController"} )
public class SignInController extends HttpServlet{
    
    private JdbcUtility jdbcUtility;
    
    private Connection con;
    
    @Override
    public void init() throws ServletException{
        
        String driver = "com.mysql.jdbc.Driver";
        
        String dbName = "alumni_account";
        String url = "jdbc:mysql://localhost/" + dbName + "?";
        String userName = "root";
        String password = "";
        Connection con = null;

        jdbcUtility = new JdbcUtility(driver,
                                      url,
                                      userName,
                                      password);

        jdbcUtility.jdbcConnect();
        
        //get JDC connection
        con = jdbcUtility.jdbcGetConnection();
        
        //prepare the statement once only
        //for the entire servlet lifecycle
        jdbcUtility.prepareSQLStatementRegister();
             
    }
    
    @Override
    
    public void destroy(){
        jdbcUtility.jdbcConClose();
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String Email = request.getParameter("Email");
		String password = request.getParameter("password");
		SignIn signIn = new SignIn();
		signIn.setEmail(Email);
		signIn.setPassword(password);

		try {
			if (loginDao.validate(loginBean)) {
				//HttpSession session = request.getSession();
				// session.setAttribute("username",username);
				response.sendRedirect("loginsuccess.jsp");
			} else {
				HttpSession session = request.getSession();
				//session.setAttribute("user", username);
				//response.sendRedirect("login.jsp");
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
    
    
    
    
}


