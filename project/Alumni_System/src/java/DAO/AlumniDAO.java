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

    private static AlumniDAO instance;

    private String url = "jdbc:mysql://localhost:3306/alumni?useTimezone=true&serverTimezone=UTC";
    private String use = "root";
    private String password = "";

    private Alumni alumni;

    private AlumniDAO() {
        try {
            Thread.sleep(1000);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static AlumniDAO getInstance() {
        if (instance == null) {
            instance = new AlumniDAO();
        }
        return instance;
    }

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
                Alumni foundAlumni = new Alumni(rs.getString("Alumnicitizenship"), rs.getString("Alumniemail"), rs.getString("Alumniname"), rs.getString("Batchname"), EduLevel.valueOf(rs.getString("Edulevel")), Gender.valueOf(rs.getString("Gender")), rs.getInt("Graduateyear"), alumniTitle.valueOf(rs.getString("Title")));

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
            String sql = "SELECT * FROM alumni WHERE Alumniemail=? ";

            //"select * from alumni where Alumniemail=? "
            // create prepared statement
            stmt = myConn.createStatement();

            ps = myConn.prepareStatement(sql);
            // set params
            ps.setString(1, alumniEmail);

            //execute query
            rs = ps.executeQuery();

            //check if user is found
            if (rs.next()) {

                Alumni foundAlumniInfo = new Alumni(rs.getString("Alumnicitizenship"), rs.getString("Alumniemail"), rs.getString("Alumnimatric"), rs.getString("Alumniname"), rs.getString("Batchname"), rs.getString("Coursename"), EduLevel.valueOf(rs.getString("Edulevel")), Gender.valueOf(rs.getString("Gender")), rs.getInt("Graduateyear"), rs.getInt("Phoneno"), alumniTitle.valueOf(rs.getString("Title")), rs.getString("AlumniaddressID"));
                return foundAlumniInfo;
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

    public AlumniAddress getAlumniAddressInfo(String alumniAddressID) {
        System.out.println("hiii" + alumniAddressID);
        Connection myConn = null;
        Statement stmt = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            // get a connection
            Class.forName("com.mysql.jdbc.Driver");

            myConn = DriverManager.getConnection(url, use, password);
            // create sql statement
            String sql = "SELECT * FROM alumniaddress WHERE AlumniaddressID=? ";

            //"select * from alumni where Alumniemail=? "
            // create prepared statement
            stmt = myConn.createStatement();

            ps = myConn.prepareStatement(sql);
            // set params
            ps.setString(1, alumniAddressID);

            //execute query
            rs = ps.executeQuery();

            //check if user is found
            if (rs.next()) {

                AlumniAddress foundAlumniAddressInfo = new AlumniAddress(rs.getString("City"), rs.getString("Country"), rs.getString("Houseno"), rs.getString("Postalcode"), rs.getString("Region"), rs.getString("State"), rs.getString("Streetname"));
                return foundAlumniAddressInfo;
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

    /**
     *
     * @param alumniName
     * @param query
     */
    public List<Alumni> getFilteredAlumni(String alumniName, String query, String queryValue) {
        List<Alumni> alumnis = new ArrayList<>();
        if (alumniName == null) {
            alumniName = "";
        }

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
            String sql = "SELECT * FROM `alumni` WHERE "+query+" LIKE '%' ? '%' AND Alumniname LIKE '%' ? '%'";

            // create prepared statement
            stmt = myConn.createStatement();
            ps = myConn.prepareStatement(sql);
            System.out.println(alumniName+ query + queryValue);
            
      
            
            ps.setString(1, queryValue);
             ps.setString(2, alumniName);
            //execute query
            rs
                    = ps.executeQuery();

            //process resultset
            while (rs.next()) {

                Alumni foundAlumniInfo = new Alumni(rs.getString("Alumnicitizenship"), rs.getString("Alumniemail"), rs.getString("Alumnimatric"), rs.getString("Alumniname"), rs.getString("Batchname"), rs.getString("Coursename"), EduLevel.valueOf(rs.getString("Edulevel")), Gender.valueOf(rs.getString("Gender")), rs.getInt("Graduateyear"), rs.getInt("Phoneno"), alumniTitle.valueOf(rs.getString("Title")), rs.getString("AlumniaddressID"));
                //list of all managers

                alumnis.add(foundAlumniInfo);
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
            String sql = "SELECT * FROM `alumni` WHERE Alumniname LIKE '%' ? '%'";

            // create prepared statement
            stmt = myConn.createStatement();

            ps = myConn.prepareStatement(sql);
            ps.setString(1, alumniName);
            //execute query
            rs = ps.executeQuery();

            //process resultset
            while (rs.next()) {

                Alumni foundAlumniInfo = new Alumni(rs.getString("Alumnicitizenship"), rs.getString("Alumniemail"), rs.getString("Alumnimatric"), rs.getString("Alumniname"), rs.getString("Batchname"), rs.getString("Coursename"), EduLevel.valueOf(rs.getString("Edulevel")), Gender.valueOf(rs.getString("Gender")), rs.getInt("Graduateyear"), rs.getInt("Phoneno"), alumniTitle.valueOf(rs.getString("Title")), rs.getString("AlumniaddressID"));
                //list of all managers

                alumnis.add(foundAlumniInfo);
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
     * @return
     */
    public Alumni updateAlumniDetails(Alumni alumni) {
        Connection myConn = null;
        Statement stmt = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String sql = "UPDATE `alumni` SET `Title` =?, `Phoneno` = ?, `Graduateyear` = ? WHERE alumniEmail=? ";
            myConn = DriverManager.getConnection(url, use, password);
            stmt = myConn.createStatement();
            ps = myConn.prepareStatement(sql);
            ps.setString(1, alumni.getTitle().toString());
            ps.setString(2, String.valueOf(alumni.getPhoneNo()));
            ps.setString(3, String.valueOf(alumni.getGraduateYear()));
            ps.setString(4, String.valueOf(alumni.getAlumniEmail()));
            ps.executeUpdate();

            String sql2 = "UPDATE `alumniaddress` SET `Streetname` =?, `Houseno` = ?, `Postalcode` = ?,  `state` = ?, `city` = ?, `country` = ?, `region` = ? WHERE AlumniaddressID=? ";
            stmt = myConn.createStatement();
            ps = myConn.prepareStatement(sql2);
            ps.setString(1, alumni.getAlumniAddress().getStreetName());
            ps.setString(2, alumni.getAlumniAddress().getHouseNo());
            ps.setString(3, alumni.getAlumniAddress().getPostalCode());
            ps.setString(4, alumni.getAlumniAddress().getState());
            ps.setString(5, alumni.getAlumniAddress().getCity());
            ps.setString(6, alumni.getAlumniAddress().getCountry());
            ps.setString(7, alumni.getAlumniAddress().getRegion());
            ps.setString(8, alumni.getAlumniAddressID());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close(myConn, stmt, rs);
        }

        return null;

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
