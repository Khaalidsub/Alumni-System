/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import Middleware.SignIn;
import java.sql.Connection;
import javax.servlet.http.HttpSession;
import jdbc.UserDAO;
/**
 *
 * @author Muaz Amir
 */
@WebServlet(name = "SignInController", urlPatterns = {"/SignInController"})
public class SignInController extends HttpServlet {

    
      //  private Database m_Database;
      //  private ManageAcc m_ManageAcc;
    
    
    
    private UserDAO jdbcUtility;   
    private Connection con;
    
    @Override
    public void init() throws ServletException{
        
        String driver = "com.mysql.jdbc.Driver";
        
        String dbName = "alumni_account";
        String url = "jdbc:mysql://localhost/" + dbName + "?";
        String userName = "root";
        String password = "";
        

        jdbcUtility = new UserDAO(driver,
                                      url,
                                      userName,
                                      password);

        jdbcUtility.jdbcConnect();
        
        //get JDC connection
        //con = jdbcUtility.jdbcGetConnection();
        
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
        
        HttpSession session = request.getSession(true);
          
        
        String email = request.getParameter("Email");
        String password = request.getParameter("password");
        
        //session
        session.setAttribute("email", email);

        SignIn signIn = new SignIn();
        signIn.setEmail(email);
        signIn.setPassword(password);
        
        
        if(jdbcUtility.validateLogin(signIn))
        {
            response.sendRedirect("home.jsp");
        }
        else{
            PrintWriter out = response.getWriter();
            
            out.println("<script>");
            out.println("    alert('Incorrect email or password');");
            out.println("    window.location = '/UserModule/login.html'");
            out.println("</script>");
        }
      
    }

}
