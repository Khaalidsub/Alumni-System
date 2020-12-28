/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

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
 * @author Khalid
 */
public class UserDao {

    private String url = "jdbc:mysql://localhost:3306/flying_wheel?useTimezone=true&serverTimezone=UTC";
    private String use = "root";
    private String password = "";

    public boolean findUser(User user) throws Exception {

        System.out.println("hiii" + user);
        Connection myConn = null;
        Statement stmt = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            // get a connection
            Class.forName("com.mysql.jdbc.Driver");

            myConn = DriverManager.getConnection(url, use, password);
            // create sql statement
            String sql = "select * from user where email=? and password=?";

            // create prepared statement
            stmt = myConn.createStatement();

            ps = myConn.prepareStatement(sql);
            // set params
            ps.setString(1, user.getEmail());
            ps.setString(2, user.getPassword());

            //execute query
            rs = ps.executeQuery();

            //check if user is found
            if (rs.next()) {

                //int userID = rs.getInt("ID");
                String role = rs.getString("role");
                user.setRole(role);
                user.setUserid(Integer.parseInt(rs.getString("ID")));
                user.setStatus(rs.getString("status"));
                System.out.println("hiii" + user);
                return true;
                //if user is a customer

            } else {
                return false;

            }

        } finally {
            // close JDBC objects
            close(myConn, stmt, rs);
        }

    }

    public boolean addUser(User user) throws Exception {

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

                return false;
            } //if email not found
            else {
                //create user
                String sql2 = "insert into user "
                        + "(name,email,phone,DOB,IC,password,role,amount) "
                        + "values (?,?,?,?,?,?,?,?)";
                //user.setRole("manager");

                System.out.println(user);
                ps = myConn.prepareStatement(sql2);
                // set params
                ps.setString(1, user.getUsername());
                ps.setString(2, user.getEmail());
                ps.setString(3, user.getPhone());
                ps.setString(4, String.valueOf(user.getDOB()));
                ps.setString(5, user.getIC());
                ps.setString(6, user.getPassword());
                ps.setString(7, user.getRole());
                ps.setString(8, String.valueOf(user.getAmount()));

                //execute query
                ps.execute();
                return true;
            }

        } finally {
            // close JDBC objects
            close(myConn, stmt, rs);
        }

    }

    public boolean amountSufficient(double cost, String email) {
        Connection myConn = null;
        Statement stmt = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        boolean sufficient = false;

        try {
            Class.forName("com.mysql.jdbc.Driver");

            myConn = DriverManager.getConnection(url, use, password);
            // create sql statement
            //check if email exists
            String sql = "select * from user where amount>=? AND email=?";

            // create prepared statement
            stmt = myConn.createStatement();

            ps = myConn.prepareStatement(sql);
            // set params
            ps.setDouble(1, cost);
            ps.setString(2, email);

            //execute query
            rs = ps.executeQuery();

            //check if user has the sufficient amount
            double currentAmount = 0;
            if (rs.next()) {
                currentAmount = Double.valueOf(rs.getString("amount"));
                User user = new User();
                user.setEmail(email);
                user.setAmount(currentAmount - cost);

                String sql2 = "update user set amount=? where email=?";

                stmt = myConn.createStatement();

                ps = myConn.prepareStatement(sql2);

                ps.setString(1, String.valueOf(user.getAmount()));
                ps.setString(2, user.getEmail());

                ps.execute();
                sufficient = true;
            } else {

                sufficient = false;
            }
        } catch (Exception e) {
            e.printStackTrace();

        } finally {
            close(myConn, stmt, rs);
        }
        return sufficient;
    }

    public String getBalance(String email) throws Exception {
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
            ps.setString(1, email);

            //execute query
            rs = ps.executeQuery();

            //check if email is found
            if (rs.next()) {

                return rs.getString("amount");

            } else {

                return null;
            }

        } finally {
            // close JDBC objects
            close(myConn, stmt, rs);
        }
    }

    public List<User> getManagers() throws Exception {

        List<User> managers = new ArrayList<>();

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
            String sql = "SELECT * FROM `user` WHERE `role` = 'manager'";

            // create prepared statement
            stmt = myConn.createStatement();

            ps = myConn.prepareStatement(sql);

            //execute query
            rs = ps.executeQuery();

            //process resultset
            while (rs.next()) {
                int id = rs.getInt("ID");
                String name = rs.getString("name");
                String email = rs.getString("email");
                Date DOB = Date.valueOf(rs.getString("DOB"));
                String role = rs.getString("role");
                String IC = rs.getString("IC");
                String phone = rs.getString("phone");
                User user = new User(id, name, email, phone, DOB, role);

                //list of all managers
                managers.add(user);
            }
        } finally {
            // close JDBC objects
            close(myConn, stmt, rs);
        }
        return managers;
    }

    public List<User> getCustomers() throws Exception {

        List<User> users = new ArrayList<>();

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
            String sql = "SELECT * FROM `user` WHERE role='customer'";

            // create prepared statement
            stmt = myConn.createStatement();

            ps = myConn.prepareStatement(sql);

            //execute query
            rs = ps.executeQuery();

            //process resultset
            while (rs.next()) {
                int id = rs.getInt("ID");
                String name = rs.getString("name");
                String email = rs.getString("email");
                Date DOB = Date.valueOf(rs.getString("DOB"));
                String role = rs.getString("role");
                String IC = rs.getString("IC");
                String phone = rs.getString("phone");
                User user = new User(id, name, email, phone, DOB, role);

                //list of all managers
                users.add(user);
            }
        } finally {
            // close JDBC objects
            close(myConn, stmt, rs);
        }
        return users;

    }

    public void deleteUser(String userid) throws Exception {
        Connection myConn = null;
        PreparedStatement ps = null;
        try {
            // get a connection
            Class.forName("com.mysql.jdbc.Driver");

            myConn = DriverManager.getConnection(url, use, password);
            // create sql statement
            // create sql to delete student
            String sql = "delete from user where ID=?";

            ps = myConn.prepareStatement(sql);

            ps.setInt(1, Integer.parseInt(userid));

            ps.execute();
        } finally {
            // clean up JDBC code
            close(myConn, ps, null);
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

    public User getUser(String email) throws Exception {
        User user = new User();

        Connection myConn = null;
        Statement stmt = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            // get a connection
            Class.forName("com.mysql.jdbc.Driver");

            myConn = DriverManager.getConnection(url, use, password);
            // create sql statement
            String sql = "select * from user where email=?";

            // create prepared statement
            stmt = myConn.createStatement();

            ps = myConn.prepareStatement(sql);

            // set params
            ps.setString(1, email);

            //execute query
            rs = ps.executeQuery();

            //check if user is found
            if (rs.next()) {

                String name = rs.getString("name");
                String phone = rs.getString("phone");
                String DOB = rs.getString("DOB");
                String IC = rs.getString("IC");

                //user.setRole(role);
                user.setEmail(email);
                user.setIC(IC);
                user.setPhone(phone);
                user.setUsername(name);
                user.setDOB(Date.valueOf(DOB));

                //if user is a customer
            } else {

            }

        } finally {
            // close JDBC objects
            close(myConn, stmt, rs);
        }
        return user;
    }

    public void updateManager(User user) throws Exception {
        Connection myConn = null;
        Statement stmt = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        System.out.println("id + " + user.getUserid() + user.getEmail() + user.getPhone());
        try {
            // get a connection
            Class.forName("com.mysql.jdbc.Driver");

            myConn = DriverManager.getConnection(url, use, password);
            // create sql statement
            String sql = "select * from user where ID=?";

            // create prepared statement
            stmt = myConn.createStatement();

            ps = myConn.prepareStatement(sql);

            // set params
            ps.setInt(1, user.getUserid());

            //execute query
            rs = ps.executeQuery();

            //check if user is found
            if (rs.next()) {
                String sql2 = "UPDATE `user` SET `email` =?, `phone` = ? WHERE ID =? ";
                stmt = myConn.createStatement();

                ps = myConn.prepareStatement(sql2);
                ps.setString(1, user.getEmail());
                ps.setString(2, user.getPhone());
                ps.setInt(3, user.getUserid());
                ps.executeUpdate();
                //if user is a customer
            }

        } finally {
            // close JDBC objects
            close(myConn, stmt, rs);
        }

    }

    public List<Integer> checkBooking(String date_start, String date_end, String time_start, String time_end, String number, String type) {
        Boolean available = false;
        List<Integer> value = new ArrayList<>();

        Connection myConn = null;
        Statement stmt = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            // get a connection
            Class.forName("com.mysql.jdbc.Driver");

            myConn = DriverManager.getConnection(url, use, password);
            // create sql statement

            String sql1 = "    SELECT *\n"
                    + "    FROM reserving r,bicycle c,booking b \n"
                    + "    WHERE r.bookingid = b.ID\n"
                    + "    AND r.bicycleid = c.ID AND\n"
                    + "    (" + date_end.replaceAll("-", "") + " >= b.date_start) AND\n"
                    + "   (" + date_start.replaceAll("-", "") + " <= b.date_end) ORDER BY r.bicycleid";
            // create prepared statement
            stmt = myConn.createStatement();

            ps = myConn.prepareStatement(sql1);
            //execute query
            rs = ps.executeQuery();
            List<String> numbercheck = new ArrayList<>();
            while (rs.next()) {
                numbercheck.add(rs.getString("bicycleid"));
                System.out.println("Addition booked : " + rs.getString("bicycleid"));
            }
            System.out.println("check number of bookings : " + numbercheck.size());

            String sql2 = "SELECT * FROM `bicycle` WHERE type =? ORDER BY ID";

            stmt = myConn.createStatement();

            ps = myConn.prepareStatement(sql2);

            // set params
            ps.setString(1, type);

            //execute query
            rs = ps.executeQuery();
            String size = null;
            List<String> bicyclecheck = new ArrayList<>();
            //bicycles
            while (rs.next()) {
                bicyclecheck.add(rs.getString("ID"));

                System.out.println("Addition cycles : " + rs.getString("ID"));
            }
            System.out.println("check bicycle size : " + bicyclecheck.size());
            //getting the difference of the both queries
            int num = bicyclecheck.size() - numbercheck.size();

            int av = 0;
            //comparing the number of cycles user used  with the size of free bicycles
            if (num >= Integer.parseInt(number)) {
                available = true;
                av = 1;

                System.out.println("check how many availabe cycles : " + num);
                int i = bicyclecheck.size();
                int z = numbercheck.size() - 1;
                int k = 0;
                int j = 0;
                int blom = Integer.parseInt(number);
                //add the cycles that are available
                while (blom > 0) {

                    //comparing the ids of the the bicycle and the booked bicycles
                    if (z > -1) {
                        System.out.println("z : " + z);
                        if (Integer.parseInt(numbercheck.get(k)) != Integer.parseInt(bicyclecheck.get(j))) {
                            value.add(Integer.parseInt(bicyclecheck.get(j)));
                            System.out.println("Addition inside " + bicyclecheck.get(j));
                            blom--;
                        }
                    } else {
                        value.add(Integer.parseInt(bicyclecheck.get(j)));
                        System.out.println("Addition " + num);
                        blom--;
                    }
                    k++;
                    j++;
                    i--;
                    z--;

                }

            } else {
                available = false;
                av = 0;
            }
            value.add(av);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close(myConn, stmt, rs);
        }

        return value;

    }

    public User getUserupdate(String id) throws Exception {
        User user = new User();

        Connection myConn = null;
        Statement stmt = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        System.out.println("id + " + id);
        try {
            // get a connection
            Class.forName("com.mysql.jdbc.Driver");

            myConn = DriverManager.getConnection(url, use, password);
            // create sql statement
            String sql = "select * from user where ID=?";

            // create prepared statement
            stmt = myConn.createStatement();

            ps = myConn.prepareStatement(sql);

            // set params
            ps.setString(1, id);

            //execute query
            rs = ps.executeQuery();

            //check if user is found
            if (rs.next()) {
                String email = rs.getString("email");
                String name = rs.getString("name");
                String phone = rs.getString("phone");
                String DOB = rs.getString("DOB");
                String IC = rs.getString("IC");

                //user.setRole(role);
                user.setEmail(email);
                user.setIC(IC);
                user.setPhone(phone);
                user.setUsername(name);
                user.setDOB(Date.valueOf(DOB));
                user.setUserid(Integer.valueOf(id));
                //if user is a customer
            } else {

            }

        } finally {
            // close JDBC objects
            close(myConn, stmt, rs);
        }
        return user;
    }

    public void updateProfile(User user) throws Exception {

        Connection myConn = null;
        Statement stmt = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        System.out.println("id + " + user.getUserid() + user.getEmail() + user.getPhone());
        try {
            // get a connection
            Class.forName("com.mysql.jdbc.Driver");

            myConn = DriverManager.getConnection(url, use, password);
            // create sql statement
            String sql = "select * from user where ID=?";

            // create prepared statement
            stmt = myConn.createStatement();

            ps = myConn.prepareStatement(sql);

            // set params
            ps.setInt(1, user.getUserid());

            //execute query
            rs = ps.executeQuery();

            //check if user is found
            if (rs.next()) {
                String sql2 = "UPDATE `user` SET `email` =?, `phone` = ? WHERE `user`.`ID` = " + user.getUserid() + ";";
                stmt = myConn.createStatement();

                ps = myConn.prepareStatement(sql2);
                ps.setString(1, user.getEmail());
                ps.setString(2, user.getPhone());

                ps.executeUpdate();
                //if user is a customer
            }

        } finally {
            // close JDBC objects
            close(myConn, stmt, rs);
        }

    }

    public void disableUser(String userid) throws Exception {
        Connection myConn = null;
        PreparedStatement ps = null;
        try {
            // get a connection
            Class.forName("com.mysql.jdbc.Driver");

            myConn = DriverManager.getConnection(url, use, password);
            // create sql statement
            // create sql to delete student
            String sql = "UPDATE  user SET status=? where ID=?";

            ps = myConn.prepareStatement(sql);
            ps.setString(1, "disabled");
            ps.setInt(2, Integer.parseInt(userid));

            ps.executeUpdate();
        } finally {
            // clean up JDBC code
            close(myConn, ps, null);
        }
    }

}
