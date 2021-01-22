/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webservice;

import com.google.gson.Gson;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.ws.rs.Path;

import jdbc.UserDAO;

/**
 *
 * @author Muaz Amir
 */
@WebServlet(name = "databaseController", urlPatterns = {"/databaseController"})


public class databaseController extends HttpServlet{
    
    private UserDAO jdbcUtility;
    private Connection con;
    

    
    public ArrayList<database> getDataInJSON(HttpServletRequest request, 
            HttpServletResponse response) throws ServletException, IOException
    {

      
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
        
        String query = "Select * from alumni";
        HttpSession session =  request.getSession();
        
       ArrayList<database> dbb=new ArrayList<database>();
        database db = new database();
        try{
               Statement st=con.createStatement();
               ResultSet rs=st.executeQuery(query);
               
               while(rs.next())
        {
           
            db.setAddress(rs.getString("Address"));
            db.setCurrentJob(rs.getString("CurrentJob"));
            db.setEmail(rs.getString("Email"));
            db.setGraduateYear(rs.getInt("GraduateYear"));
            db.setName(rs.getString("Name"));
            db.setPassword(rs.getString("password"));
            db.setPhone(rs.getString("PhoneNo"));
            db.setPreviousJob(rs.getString("PreviousJob"));
            db.setSalaryCurrent(rs.getDouble("SalaryCurrent"));
            db.setSalaryPrevious(rs.getDouble("SalaryPrevious"));
            db.setStatus(rs.getString("Status"));
            dbb.add(db);
        }   
        session.setAttribute("dbb", dbb);
        
        /*
        String query2 ="Select * from admin";
        rs = st.executeQuery(query2);
        
        while(rs.next()){
            
            db.setAdminEmail(rs.getString("AdminEmail"));
            db.setAdminID(rs.getString("AdminID"));
            db.setAdminName(rs.getString("AdminName"));
            db.setAdminPassword(rs.getString("AdminPassword"));
            dbb.add(db);
        }
        */
         
        }
             catch(SQLException ex) {
                System.out.println(ex.getMessage());
            } 
            catch (NullPointerException e) {
            try (PrintWriter out = response.getWriter()) {
                    out.println("ADA ERROR WOI!");
                } 
     
            }
             return dbb;    
    }
    
  @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException{
            response.setContentType("text/html");
            try (PrintWriter out = response.getWriter()){
                ArrayList<database> db = getDataInJSON(request, response);
                Gson gson = new Gson();
                String jsonString = gson.toJson(db);

                out.println(jsonString);

                out.close();
            }
        }
    
      
}




