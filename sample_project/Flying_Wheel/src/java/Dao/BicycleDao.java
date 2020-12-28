/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import entity.Bicycle;
import entity.User;
import java.io.InputStream;
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
public class BicycleDao {

    private String url = "jdbc:mysql://localhost:3306/flying_wheel?useTimezone=true&serverTimezone=UTC";
    private String use = "root";
    private String password = "";

    public List<Bicycle> getBicycles() throws Exception {

        List<Bicycle> bicycle = new ArrayList<>();

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
            String sql = "SELECT * FROM `bicycle`";

            // create prepared statement
            stmt = myConn.createStatement();

            ps = myConn.prepareStatement(sql);

            //execute query
            rs = ps.executeQuery();

            //process resultset
            while (rs.next()) {
                int id = rs.getInt("ID");
                String name = rs.getString("name");
                String type = rs.getString("type");
                int rent = rs.getInt("rent_cost");
                InputStream image = rs.getBinaryStream("image");
                Bicycle newBicycle = new Bicycle(id, name, type, rent, image);

                //list of all managers
                bicycle.add(newBicycle);
            }
        } finally {
            // close JDBC objects
            close(myConn, stmt, rs);
        }
        return bicycle;
    }

    public Bicycle addBicycle(Bicycle bicycle) throws Exception {

        Connection myConn = null;
        Statement stmt = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            // get a connection
            Class.forName("com.mysql.jdbc.Driver");

            myConn = DriverManager.getConnection(url, use, password);

            // create prepared statement
            stmt = myConn.createStatement();

            //create bicycle
            String sql = "insert into bicycle "
                    + "(name,type,rent_cost,image) "
                    + "values (?,?,?,?)";

            System.out.println(bicycle);
            ps = myConn.prepareStatement(sql);
            // set params
          
            ps.setString(1, bicycle.getName());
            ps.setString(2, bicycle.getType());
            ps.setDouble(3, bicycle.getRent_cost());
            ps.setBinaryStream(4, bicycle.getImage(), bicycle.getLength());

            //execute query
            ps.execute();

        } finally {
            // close JDBC objects
            close(myConn, stmt, rs);
        }

        return bicycle;
    }

    public void deleteBicycle(int id) throws Exception {
        Connection myConn = null;
        PreparedStatement ps = null;
        try {
            // get a connection
            Class.forName("com.mysql.jdbc.Driver");

            myConn = DriverManager.getConnection(url, use, password);

            // create sql to delete student
            String sql = "delete from bicycle where ID=?";

            ps = myConn.prepareStatement(sql);

            ps.setInt(1, id);

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

    public int getCost(List<Integer> list) throws Exception {
        Connection myConn = null;
        Statement stmt = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        int cost = 0;
        //System.out.println("SQL : " + sql);
        try {
            // get a connection
            Class.forName("com.mysql.jdbc.Driver");

            myConn = DriverManager.getConnection(url, use, password);
            // create sql statement
            //check if email exists
            String sql = "SELECT * FROM `bicycle` WHERE ";
            int i = list.size();
            while (i != 1) {
                sql += " ID = " + list.get(i - 1) + " OR ";

                i--;
            }
            //last one;
            sql += " ID = " + list.get(0);
            System.out.println("SQL : " + sql);

            // create prepared statement
            stmt = myConn.createStatement();

            ps = myConn.prepareStatement(sql);

            //execute query
            rs = ps.executeQuery();

            
            while (rs.next()) {
                cost += Integer.parseInt(rs.getString("rent_cost"));
            }

            System.out.println("cost : " + cost);

        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            close(myConn, stmt, rs);
        }
        
        return cost;
    }

}
