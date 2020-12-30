/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import entity.Booking;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Khalid
 */
public class BookingDao {

    private String url = "jdbc:mysql://localhost:3306/flying_wheel?useTimezone=true&serverTimezone=UTC";
    private String use = "root";
    private String password = "";

    public void addBooking(List<Integer> list, Booking book, int id) throws Exception {
        Connection myConn = null;
        Statement stmt = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        //System.out.println("SQL : " + sql);
        try {
            // get a connection
            Class.forName("com.mysql.jdbc.Driver");

            myConn = DriverManager.getConnection(url, use, password);
            // create sql statement
            String sql = "insert into booking"
                    + "(date_start,date_end,time_from,time_to,cost,userid) "
                    + "values (?,?,?,?,?,?)";

            ps = myConn.prepareStatement(sql);
            ps.setString(1, book.getDate_start().toString());
            ps.setString(2, book.getDate_end().toString());
            ps.setString(3, book.getTime_start());
            ps.setString(4, book.getTime_end());
            ps.setString(5, String.valueOf(book.getCost()));
            ps.setString(6, String.valueOf(id));

            //execute query
            ps.execute();

            String bookingid = null;
            String sql3 = "SELECT * FROM booking WHERE userid = " + id;
            ps = myConn.prepareStatement(sql3);

            rs = ps.executeQuery(sql);
            if (rs.next()) {
                bookingid = rs.getString("ID");
            }
            System.out.println("ID " + bookingid);
            int i = list.size();
            while (i != 0) {
                String sql2 = "insert into reserving"
                        + "(bicycleid,bookingid)"
                        + "values (" + list.get(i - 1) + " ," + bookingid + " )";
                ps = myConn.prepareStatement(sql2);
                ps.execute();
                i--;
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close(myConn, stmt, rs);
        }
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

    public List<Booking> getUserBooking(int id) {
        List<Booking> bookings = new ArrayList<>();
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
            String sql = "SELECT * FROM `Booking` WHERE userid= " + id;

            // create prepared statement
            stmt = myConn.createStatement();

            ps = myConn.prepareStatement(sql);

            //execute query
            rs = ps.executeQuery();

            while (rs.next()) {
                int bookid = rs.getInt("ID");
                int userid = rs.getInt("userid");
                Date date_start = rs.getDate("date_start");
                Date date_end = rs.getDate("date_end");
                String time_start = rs.getString("time_from");
                String time_end = rs.getString("time_to");
                int cost = rs.getInt("cost");
                Booking Book = new Booking(date_start, date_end, time_start, time_end, cost, bookid, userid);
                bookings.add(Book);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close(myConn, stmt, rs);
        }

        return bookings;
    }

    public List<Booking> getAllBooking() {
        List<Booking> bookings = new ArrayList<>();
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
            String sql = "SELECT * FROM `Booking`";

            // create prepared statement
            stmt = myConn.createStatement();

            ps = myConn.prepareStatement(sql);

            //execute query
            rs = ps.executeQuery();

            while (rs.next()) {
                int bookid = rs.getInt("ID");
                int userid = rs.getInt("userid");
                Date date_start = rs.getDate("date_start");
                Date date_end = rs.getDate("date_end");
                String time_start = rs.getString("time_from");
                String time_end = rs.getString("time_to");
                int cost = rs.getInt("cost");
                Booking Book = new Booking(date_start, date_end, time_start, time_end, cost, bookid, userid);
                bookings.add(Book);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close(myConn, stmt, rs);
        }

        return bookings;
    }

    public List<Booking> getBookings(String dateStart, String dateEnd) {
        List<Booking> bookings = new ArrayList<>();
        Connection myConn = null;
        Statement stmt = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            // get a connection
            Class.forName("com.mysql.jdbc.Driver");

            myConn = DriverManager.getConnection(url, use, password);

            String sql = "SELECT * FROM `Booking` WHERE"
                    + " (date_start BETWEEN '" + dateStart + "' AND '" + dateEnd + "')";

            // create prepared statement
            stmt = myConn.createStatement();

            ps = myConn.prepareStatement(sql);

            //execute query
            rs = ps.executeQuery();

            if (!rs.next()) {
                return null;
            }

            do {
                int bookid = rs.getInt("ID");
                int userid = rs.getInt("userid");
                Date date_start = rs.getDate("date_start");
                int cost = rs.getInt("cost");

                Booking Book = new Booking();
                Book.setId(bookid);
                Book.setUserid(userid);
                Book.setDate_start(date_start);
                Book.setCost(cost);
                bookings.add(Book);
            } while (rs.next());

            return bookings;

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close(myConn, stmt, rs);
        }

        return null;

    }
}
