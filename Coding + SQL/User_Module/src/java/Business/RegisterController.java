

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

import java.sql.*;
import jdbc.JdbcUtility;


@WebServlet (name="RegisterController" , urlPatterns = {"/RegisterController"} )
public class RegisterController extends HttpServlet{
    
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
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
        response.setContentType("text/html;charset=UTF-8");
        
        String Address = request.getParameter("Address");
	 String CurrentJob = request.getParameter("CurrentJob");
	 String Email = request.getParameter("Email");
	 int GraduateYear = Integer.parseInt(request.getParameter("GraduateYear"));
	 String Name = request.getParameter("Name");
	 String password = request.getParameter("password");
	 String Phone = request.getParameter("Phone");
	 String PreviousJob = request.getParameter("PreviousJob");
	 double SalaryCurrent = Double.parseDouble(request.getParameter("SalaryCurrent"));
	 double SalaryPrevious = Double.parseDouble(request.getParameter("SalaryPrevious"));
         String Status = request.getParameter("Status");
        
         try{
             PreparedStatement preparedStatement = jdbcUtility.getPsRegister();
             
             preparedStatement.setString(1, Address);
             preparedStatement.setString(2, CurrentJob);
             preparedStatement.setString(3,Email);
             preparedStatement.setInt(4,GraduateYear);
             preparedStatement.setString(5,Name);
             preparedStatement.setString(6,password);
             preparedStatement.setString(7,Phone);
             preparedStatement.setString(8,PreviousJob);
             preparedStatement.setDouble(9,SalaryCurrent);
             preparedStatement.setDouble(10,SalaryPrevious);
             preparedStatement.setString(11,Status);
             
             int insertStatus = 0;
             insertStatus = preparedStatement.executeUpdate();
             
             PrintWriter out = response.getWriter();
             
             out.println(insertStatus);
             
             if(insertStatus == 1){
                 out.println("<script>");
                 out.println("  alert('Register Success');");
                 out.println("    window.location = '/RegisterController'");
                 out.println("</script>");
         }
         }
         catch (SQLException ex)
	{
            while (ex != null) {
                System.out.println ("SQLState: " + ex.getSQLState ());
                System.out.println ("Message:  " + ex.getMessage ());
		System.out.println ("Vendor:   " + ex.getErrorCode ());
                ex = ex.getNextException ();
		System.out.println ("");
            }
            
            PrintWriter out = response.getWriter();
            
            out.println("<script>");
            out.println("    alert('Student insert failed');");
            out.println("    window.location = '/RegisterController'");
            out.println("</script>");            
	}
	catch (java.lang.Exception ex)
	{
            ex.printStackTrace ();
            
            PrintWriter out = response.getWriter();
            
            out.println("<script>");
            out.println("    alert('Student insert failed');");
            out.println("    window.location = '/User_module/RegisterController'");
            out.println("</script>");
	}    
         
         
    }
    }
                
            
     

