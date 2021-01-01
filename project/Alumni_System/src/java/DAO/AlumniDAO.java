/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Middleware.Alumni;
import Middleware.AlumniAddress;
import Middleware.EduLevel;
import Middleware.Gender;
import Middleware.alumniTitle;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author SleepingLotus
 */
public class AlumniDAO {

    private String url = "jdbc:mysql://localhost:3306/test?useTimezone=true&serverTimezone=UTC";
    private String use = "root";
    private String password = "";

    private Alumni alumni;

    /**
     *
     * @param alumniEmail
     */
    public Alumni getAlumniInfo(String alumniEmail) {
        System.out.println("hiii" + alumniEmail);
        Connection myConn = null;
        Statement stmt = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            // get a connection
            Class.forName("com.mysql.jdbc.Driver");

            myConn = DriverManager.getConnection(url, use, password);
            // create sql statement
            String sql = "select * from alumni where Alumniemail=?";

            // create prepared statement
            stmt = myConn.createStatement();

            ps = myConn.prepareStatement(sql);
            // set params
            ps.setString(1, alumniEmail);

            //execute query
            rs = ps.executeQuery();

            //check if user is found
            if (rs.next()) {

                Alumni foundAlumni = new Alumni(rs.getString("Alumnicitizenship"), rs.getString("Alumniemail"), rs.getString("Alumniname"), rs.getString("Batchname"), EduLevel.valueOf(rs.getString("Edulevel")), Gender.valueOf(rs.getString("Gender")), rs.getInt("Graduateyear"), alumniTitle.valueOf(rs.getString("Title")));
                return foundAlumni;
                //if user is a customer

            }

        } catch (Exception ex) {
            Logger.getLogger(AlumniDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            // close JDBC objects
            close(myConn, stmt, rs);
        }

        return null;

    }

    public List<Alumni> getAlumniList() {
        List<Alumni> alumnis = new ArrayList<>();

        Connection myConn = null;
        Statement stmt = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            // get a connection
            Class.forName("com.mysql.jdbc.Driver");

            myConn = DriverManager.getConnection(url, use, password);
            // create sql statement
            //check if email exists
            String sql = "SELECT * FROM `alumni`";

            // create prepared statement
            stmt = myConn.createStatement();

            ps = myConn.prepareStatement(sql);

            //execute query
            rs = ps.executeQuery();

            //process resultset
            while (rs.next()) {
                Alumni foundAlumni = new Alumni(rs.getString("alumniCitizenship"), rs.getString("alumniEmail"), rs.getString("alumniName"), rs.getString("batchName"), EduLevel.valueOf(rs.getString("eduLevel")), Gender.valueOf(rs.getString("gender")), rs.getInt("graduateYear"), alumniTitle.valueOf(rs.getString("alumniTitle")));

                //list of all managers
                alumnis.add(foundAlumni);
            }
        } catch (Exception ex) {
            Logger.getLogger(AlumniDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            // close JDBC objects
            close(myConn, stmt, rs);
        }
        return alumnis;
    }

    /**
     *
     * @param alumniEmail
     */
    public Alumni getDetailedAlumniInfo(String alumniEmail) {
        return null;
    }

    /**
     *
     * @param alumniName
     * @param query
     */
    public List<Alumni> getFilteredAlumni(String alumniName, String query) {
                   List<Alumni> alumnis = new ArrayList<>();

        Connection myConn = null;
        Statement stmt = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            // get a connection
            Class.forName("com.mysql.jdbc.Driver");

            myConn = DriverManager.getConnection(url, use, password);
            // create sql statement
            //check if email exists
            String sql = "SELECT * FROM `alumni` WHERE  " + query +"="+alumniName;

            // create prepared statement
            stmt = myConn.createStatement();

            ps = myConn.prepareStatement(sql);

            //execute query
            rs = ps.executeQuery();

            //process resultset
            while (rs.next()) {
                Alumni foundAlumni = new Alumni(rs.getString("alumniCitizenship"), rs.getString("alumniEmail"), rs.getString("alumniName"), rs.getString("batchName"), EduLevel.valueOf(rs.getString("eduLevel")), Gender.valueOf(rs.getString("gender")), rs.getInt("graduateYear"), alumniTitle.valueOf(rs.getString("alumniTitle")));

                //list of all managers
                alumnis.add(foundAlumni);
            }
        } catch (Exception ex) {
            Logger.getLogger(AlumniDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            // close JDBC objects
            close(myConn, stmt, rs);
        }
        return alumnis;
    }

    /**
     *
     * @param alumniName
     */
    public List<Alumni> getSearchedAlumni(String alumniName) {
             List<Alumni> alumnis = new ArrayList<>();

        Connection myConn = null;
        Statement stmt = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            // get a connection
            Class.forName("com.mysql.jdbc.Driver");

            myConn = DriverManager.getConnection(url, use, password);
            // create sql statement
            //check if email exists
            String sql = "SELECT * FROM `alumni` WHERE  alumniName="+alumniName;

            // create prepared statement
            stmt = myConn.createStatement();

            ps = myConn.prepareStatement(sql);

            //execute query
            rs = ps.executeQuery();

            //process resultset
            while (rs.next()) {
                Alumni foundAlumni = new Alumni(rs.getString("alumniCitizenship"), rs.getString("alumniEmail"), rs.getString("alumniName"), rs.getString("batchName"), EduLevel.valueOf(rs.getString("eduLevel")), Gender.valueOf(rs.getString("gender")), rs.getInt("graduateYear"), alumniTitle.valueOf(rs.getString("alumniTitle")));

                //list of all managers
                alumnis.add(foundAlumni);
            }
        } catch (Exception ex) {
            Logger.getLogger(AlumniDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            // close JDBC objects
            close(myConn, stmt, rs);
        }
        return alumnis;
    }

    /**
     *
     * @param alumni
     */
    public void updateAlumniDetails(Alumni alumni) {

    }

    //close connection
    private void close(Connection myConn, Statement myStmt, ResultSet myRs) {

        try {
            if (myRs != null) {
                myRs.close();
            }

            if (myStmt != null) {
                myStmt.close();
            }

            if (myConn != null) {
                myConn.close();   // doesn't really close it ... just puts back in connection pool
            }
        } catch (Exception exc) {
            exc.printStackTrace();
        }
    }

}
