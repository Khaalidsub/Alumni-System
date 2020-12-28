/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import entity.TopUp;
import entity.User;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Muhammad Mohsin
 */
public class TopupDao {
    
    private String url = "jdbc:mysql://localhost:3306/flying_wheel?useTimezone=true&serverTimezone=UTC";
    private String use = "root";
    private String password = "";
    
    
    public boolean topUp(User user) throws ClassNotFoundException, SQLException {
        Connection myConn = null;
        Statement stmt = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {

            Class.forName("com.mysql.jdbc.Driver");

            myConn = DriverManager.getConnection(url, use, password);
            // create sql statement
            //check if email exists
            String sql = "select * from user where email=?";

            // create prepared statement
            stmt = myConn.createStatement();

            ps = myConn.prepareStatement(sql);
            // set params
            ps.setString(1, user.getEmail());

            //execute query
            rs = ps.executeQuery();

            //check if email is found
            if (rs.next()) {
                
                double currentamount = Double.parseDouble(rs.getString("amount"));
                double newamount = user.getAmount() + currentamount;
                int userid = Integer.parseInt(rs.getString("ID"));

                String sql2 = "update user set amount=? where ID=?";

                stmt = myConn.createStatement();

                ps = myConn.prepareStatement(sql2);

                ps.setString(1, String.valueOf(newamount));
                ps.setString(2, String.valueOf(userid));

                ps.execute();
                
                String sql3 = "insert into top_up "
                        + "(user_id,user_email,amount) "
                        + "values (?,?,?)";
                
                ps = myConn.prepareStatement(sql3);
               
                ps.setString(1, String.valueOf(userid));
                ps.setString(2, user.getEmail());
                ps.setString(3, String.valueOf(user.getAmount()));
                
                ps.execute();

                return true;

            } else {

                return false;
            }

        } finally {
            // close JDBC objects
            close(myConn, stmt, rs);
        }
    }
      public List<TopUp> getTopUps(String dateStart, String dateEnd) {
        List<TopUp> topups = new ArrayList<>();
        Connection myConn = null;
        Statement stmt = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            // get a connection
            Class.forName("com.mysql.jdbc.Driver");

            myConn = DriverManager.getConnection(url, use, password);

            String sql = "SELECT * FROM `top_up` WHERE"
                    + " (date BETWEEN '" + dateStart + "' AND '" + dateEnd + "')";

            // create prepared statement
            stmt = myConn.createStatement();

            ps = myConn.prepareStatement(sql);

            //execute query
            rs = ps.executeQuery();

            if (!rs.next()) {
                return null;
            }

            do {
                int id = rs.getInt("ID");
                int userid = rs.getInt("user_id");
                Date date = rs.getDate("date");
                int amount = rs.getInt("amount");
                String email = rs.getString("user_email");

                TopUp top = new TopUp(id, userid, email, amount, date);

                topups.add(top);
            } while (rs.next());

            return topups;

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

    public List<TopUp> getUserTopUps(int user_id) {
         List<TopUp> topups = new ArrayList<>();
        Connection myConn = null;
        Statement stmt = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            // get a connection
            Class.forName("com.mysql.jdbc.Driver");

            myConn = DriverManager.getConnection(url, use, password);

            String sql = "SELECT * FROM `top_up` WHERE user_id = " + user_id;
                  

            // create prepared statement
            stmt = myConn.createStatement();

            ps = myConn.prepareStatement(sql);

            //execute query
            rs = ps.executeQuery();

            if (!rs.next()) {
                return null;
            }

            do {
                int id = rs.getInt("ID");
                int userid = rs.getInt("user_id");
                Date date = rs.getDate("date");
                int amount = rs.getInt("amount");
                String email = rs.getString("user_email");

                TopUp top = new TopUp(id, userid, email, amount, date);

                topups.add(top);
            } while (rs.next());

            return topups;

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close(myConn, stmt, rs);
        }

        return null;
    }



}
