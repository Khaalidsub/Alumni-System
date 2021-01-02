/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Mapping;

import Middleware.Event;


import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;
import jdbc.JDBCUtility;

/**
 *
 * @author haisw
 */
@WebServlet(name = "eventMapping", urlPatterns = {"/eventMapping"})

public class eventMapping extends HttpServlet {
   
    String eventID;
    String eventName;
    private JDBCUtility jdbcUtility;
    private Connection con;
    
    @Override
    public void init() throws ServletException
    {
        String driver = "com.mysql.jdbc.Driver";

        String dbName = "event";
        String url = "jdbc:mysql://localhost/" + dbName + "?";
        String userName = "root";
        String password = "";

        jdbcUtility = new JDBCUtility(driver,
                                      url,
                                      userName,
                                      password);

        jdbcUtility.jdbcConnect();
        con = jdbcUtility.jdbcGetConnection();
    } 
    
    public List<Event> getEventList() {
        List<Event> events = new ArrayList<>();
        
        PreparedStatement preparedStatementSelect = null;
        String sqlQuery = "SELECT * FROM event";
        
        try
        {
            preparedStatementSelect = con.prepareStatement(sqlQuery);
//          preparedStatementSelect.setString(1, eventID);
            ResultSet rs = preparedStatementSelect.executeQuery();
                
            while (rs.next()) {
                Event foundEvent = new Event(rs.getString("eventID"), rs.getString("eventName"), rs.getString("date"), rs.getString("time"), rs.getString("venue"), rs.getString("organizer"), rs.getString("fee"), rs.getString("fundingID"));

                //list of all managers
                events.add(foundEvent);
            }
                   
            //add beans into request
            //request.setAttribute("student", std);
                    
            //add beans into session
            //session.setAttribute("student", std);
                    
        }
        catch (java.lang.Exception ex)
        {
            ex.printStackTrace ();
        }
            
        return events;
    }

    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
