

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
    
    
    
}


