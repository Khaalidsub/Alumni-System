

/**
 * @author Asus
 * @version 1.0
 * @created 30-Dec-2020 10:06:48 PM
 */

package Business;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import java.sql.*;
import jdbc.UserDAO;


@WebServlet (name="RegisterController" , urlPatterns = {"/RegisterController"} )
public class RegisterController extends HttpServlet{
    
    private UserDAO jdbcUtility;
    
    private Connection con;
    
    @Override
    public void init() throws ServletException{
        
        String driver = "com.mysql.jdbc.Driver";
        
        String dbName = "E70UeYfD5B";
        String url = "jdbc:mysql://remotemysql.com:3306/" + dbName + "?sslmode=require";
        String userName = "E70UeYfD5B";
        String password = "z4TSaywGt9";
        

        jdbcUtility = new UserDAO(driver,
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
            throws ServletException, IOException{
        response.setContentType("text/html;charset=UTF-8");
        
         String Name = request.getParameter("Name");
         String password = request.getParameter("password");
         String Address = request.getParameter("Address");
         String Email = request.getParameter("Email");
	 String CurrentJob = request.getParameter("CurrentJob");	 
	 int GraduateYear = Integer.parseInt(request.getParameter("GraduateYear"));	 
	 String PhoneNo = request.getParameter("PhoneNo");
	 String PreviousJob = request.getParameter("PreviousJob");
         double SalaryPrevious = Double.parseDouble(request.getParameter("SalaryPrevious"));
	 double SalaryCurrent = Double.parseDouble(request.getParameter("SalaryCurrent"));	 
         String Status = request.getParameter("Status");
         try{
             PreparedStatement preparedStatement = jdbcUtility.getPsRegister();
             
             preparedStatement.setString(1,Name);           
             preparedStatement.setString(2,password);
             preparedStatement.setString(3, Address);
             preparedStatement.setString(4,Email);
             preparedStatement.setString(5, CurrentJob);            
             preparedStatement.setInt(6,GraduateYear);
             preparedStatement.setString(7,PhoneNo);
             preparedStatement.setString(8,PreviousJob);
             preparedStatement.setDouble(9,SalaryPrevious);
             preparedStatement.setDouble(10,SalaryCurrent);     
             preparedStatement.setString(11,Status);
             
             int insertStatus = 0;
             insertStatus = preparedStatement.executeUpdate();
             
             PrintWriter out = response.getWriter();
             
             out.println(insertStatus);
             
             if(insertStatus == 1){
                 out.println("<script>");
                 out.println("  alert('Register Success');");
                 out.println("    window.location = '/index.jsp'");
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
            out.println("    alert('alumni insert failed sqlexception ');");
            out.println("    window.location = '/register.html'");
            out.println("</script>");            
	}
	catch (java.lang.Exception ex)
	{
            ex.printStackTrace ();
            
            
            PrintWriter out = response.getWriter();
            
            out.println("<script>");
            out.println("    alert('alumni insert failed exception');");
            out.println("    window.location = '/register.html'");
            out.println("</script>");
	}    
         
         
    }
    }
                
            
     

