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

import java.sql.*;
import jdbc.reportingDAO;

/**
 *
 * @author GATES
 */
@WebServlet(name = "SelectAllLogActivity", urlPatterns = {"/SelectAllLogActivity"})
public class SelectAllLogActivity extends HttpServlet {
    
    private reportingDAO jdbcUtility;
    //private Connection con;
    
    @Override
    //this method run once only for the servlet lifecycle
    //when the servlet loaded the first time in Glassfish/Tomcat
    //the next run of servlet, this method will not be executed
    public void init() throws ServletException {
        String driver = "com.mysql.jdbc.Driver";

        String dbName = "sdadatabase";
        String url = "jdbc:mysql://localhost/" + dbName + "?";
        String userName = "root";
        String password = "";

        jdbcUtility = new reportingDAO(driver,
                                      url,
                                      userName,
                                      password);

        jdbcUtility.jdbcConnect();
        
        //get JDC connection
        //con = jdbcUtility.jdbcGetConnection();
        
        //prepare the statement once only
        //for the entire servlet lifecycle
        jdbcUtility.prepareSQLStatementSelectAllLogActivity();
    }

    @Override
    //this method run once only for the servlet lifecycle
    //when the servlet unloaded in application server (Glassfish/Tomcat)
    //or when the application server shutdown
    public void destroy() {   
        jdbcUtility.jdbcConClose();
    }

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        try {
            
            //get the prepared statement that is needed for jdbcutility class
            PreparedStatement ps = jdbcUtility.getPsSelectAllLogActivity();

	    //execute the statement
            ResultSet rs = ps.executeQuery();
            
            PrintWriter out = response.getWriter();

            //generate output for browser
            
            out.println("<table border='1'>");
            out.println("  <thead>");
            out.println("    <tr>");
            out.println("      <th>Name</th>");
            out.println("      <th>Event Name</th>");
            out.println("      <th>Sponsorship</th>");
            out.println("      <th>Qualified Architect</th>");
            out.println("      <th>Nationality</th>");
            out.println("    </tr>");
            out.println("  </thead>");
            out.println("  <tbody>");            
            
            while (rs.next()) {
                
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String eventName = rs.getString("eventName");
                String sponsorship = rs.getString("sponsorship");
                String qualified = rs.getString("qualified");
                String nationality = rs.getString("nationality");                
                
                out.println("    <tr>");
                out.println("      <td>" + name + "</td>");
                out.println("      <td>" + eventName + "</td>");
                out.println("      <td>" + sponsorship + "</td>");
                out.println("      <td>" + qualified + "</td>");
                out.println("      <td>" + nationality + "</td>");
                out.println("    </tr>");
            } 
            
            out.println("  </tbody>");
            out.println("</table>");            
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
            out.println("</script>");            
	}
	catch (java.lang.Exception ex)
	{
            ex.printStackTrace ();
            
            PrintWriter out = response.getWriter();
            
            out.println("<script>");
            out.println("    alert('Select student failed');");
            out.println("</script>");
	} 
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
