/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import Middleware.Admin;
import Middleware.Creator;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import Middleware.SignIn;
import Middleware.User;
import java.sql.Connection;
import java.sql.SQLException;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpSession;
import jdbc.UserDAO;
/**
 *
 * @author Muaz Amir
 */
@WebServlet("/SignInController")
public class SignInController extends HttpServlet {
    
   

    
      //  private Database m_Database;
      //  private ManageAcc m_ManageAcc;
    
    
    
    private UserDAO jdbcUtility;   
    private Connection con;
    
    @Override
    public void init() throws ServletException{
        
         String driver = "com.mysql.jdbc.Driver"; 
        String dbName = "sdadatabase";
        String url = "jdbc:mysql://localhost/" + dbName + "?";
        String userName = "root";
        String password = "";

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
            throws ServletException, IOException {
        
          
        
        String email = request.getParameter("Email");
        String password = request.getParameter("password");
        
       int user;
        
       Creator crt = new Creator();
      
        
        try{
           Admin admin = jdbcUtility.checkAdminLogin(email, password);
           SignIn signIn = jdbcUtility.checkLogin(email, password);
           String destPage = "index.jsp";
           
           if(signIn != null){
                       
                      HttpSession session = request.getSession();
                      session.setAttribute("signIn", signIn);
                      user = 1;
                      User obj = crt.FactoryMethod(user);
                      destPage = obj.dispWelcome();
           }
           if(admin != null){
               
                      HttpSession session = request.getSession();
                      session.setAttribute("admin", admin);
                      user = 2;
                      User obj = crt.FactoryMethod(user);
                      
                      destPage = obj.dispWelcome();
           }
           else{
               String message = "Invalid email or password";
               request.setAttribute("message", message);
           }
           
            RequestDispatcher dispatcher = request.getRequestDispatcher(destPage);
            dispatcher.forward(request, response);
        } catch (SQLException | ClassNotFoundException ex) {
            throw new ServletException(ex);

    }

}
    
}
