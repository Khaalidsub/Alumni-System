/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import entity.Item;
import java.io.InputStream;
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
public class ItemDao {

    private String url = "jdbc:mysql://localhost:3306/flying_wheel?useTimezone=true&serverTimezone=UTC";
    private String use = "root";
    private String password = "";

    public Item addItem(Item item) throws Exception {

        Connection myConn = null;
        Statement stmt = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            // get a connection
            Class.forName("com.mysql.jdbc.Driver");

            myConn = DriverManager.getConnection(url, use, password);

            //create item
            String sql = "insert into item "
                    + "(name,cost,brand,image, stock) "
                    + "values (?,?,?,?,?)";

            System.out.println(item);
            ps = myConn.prepareStatement(sql);

            // set params            
            //  ps.setInt(1, item.getId());
            ps.setString(1, item.getName());
            ps.setDouble(2, item.getCost());

            ps.setString(3, item.getBrand());
            ps.setBinaryStream(4, item.getImage(), item.getLength());
            ps.setInt(5, item.getStock());

            //execute query
            ps.execute();

        } finally {
            // close JDBC objects
            close(myConn, stmt, rs);
        }

        return item;
    }

    public List<Item> getItem() throws Exception {

        List<Item> item = new ArrayList<>();

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
            String sql = "SELECT * FROM `item`";

            // create prepared statement
            stmt = myConn.createStatement();

            ps = myConn.prepareStatement(sql);

            //execute query
            rs = ps.executeQuery();

            //process resultset
            while (rs.next()) {
                int id = rs.getInt("ID");
                String name = rs.getString("name");
                String brand = rs.getString("brand");
                float cost = rs.getFloat("cost");
                InputStream image = rs.getBinaryStream("image");
                int stock = rs.getInt("stock");
                Item newItem = new Item(id, name, cost, image, brand, stock);

                //list of item
                item.add(newItem);
            }
        } finally {
            // close JDBC objects
            close(myConn, stmt, rs);
        }
        return item;
    }

    //to identify which item goes to the order form
    //to identify which item goes to the order form
    public Item findItem(int item_id) throws ClassNotFoundException, SQLException {

        Item item = new Item();
        Connection myConn = null;
        Statement stmt = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            // get a connection
            Class.forName("com.mysql.jdbc.Driver");

            myConn = DriverManager.getConnection(url, use, password);
            // create sql statement
            String sql = "select * from item where ID=?";

            // create prepared statement
            stmt = myConn.createStatement();

            ps = myConn.prepareStatement(sql);

            // set params
            ps.setInt(1, item_id);

            //execute query
            rs = ps.executeQuery();

            //when item is found
            if (rs.next()) {

                String name = rs.getString("name");
                String brand = rs.getString("brand");
                float cost = rs.getFloat("cost");
                int stock = rs.getInt("stock");
                int id = rs.getInt("ID");
                InputStream image = rs.getBinaryStream("image");

                item = new Item(id, name, cost, image, brand, stock);
            }

        } finally {
            // close JDBC objects
            close(myConn, stmt, rs);
        }

        return item;
    }

    public void updateStock(Item item, int stock) throws Exception {
        Connection myConn = null;
        Statement stmt = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            // get a connection
            Class.forName("com.mysql.jdbc.Driver");

            myConn = DriverManager.getConnection(url, use, password);
            // create sql statement
            String sql = "update Item set stock=? where ID=?";

            // create prepared statement
            stmt = myConn.createStatement();

            ps = myConn.prepareStatement(sql);
            int total = stock + item.getStock();
            // set params
            ps.setInt(1, total);
            ps.setInt(2, item.getId());

            //execute query
            ps.executeUpdate();

            //when item is found
        } finally {
            // close JDBC objects
            close(myConn, stmt, rs);
        }

    }

    //to identify which item goes to the order form
    public Item orderItem(String item_id) throws ClassNotFoundException, SQLException {

        Item newItem = new Item();

        Connection myConn = null;
        Statement stmt = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            // get a connection
            Class.forName("com.mysql.jdbc.Driver");

            myConn = DriverManager.getConnection(url, use, password);
            // create sql statement
            String sql = "select * from item where ID=?";

            // create prepared statement
            stmt = myConn.createStatement();

            ps = myConn.prepareStatement(sql);

            // set params
            ps.setString(1, item_id);

            //execute query
            rs = ps.executeQuery();

            //when item is found
            if (rs.next()) {

                String name = rs.getString("name");
                String brand = rs.getString("brand");
                float cost = rs.getFloat("cost");
                int stock = rs.getInt("stock");
                int id = rs.getInt("ID");
                InputStream image = rs.getBinaryStream("image");

                newItem = new Item(id, name, cost, image, brand, stock);

            }

        } finally {
            // close JDBC objects
            close(myConn, stmt, rs);
        }

        return newItem;
    }

    public void deleteItem(int itemid) throws Exception {
        Connection myConn = null;
        PreparedStatement ps = null;
        try {
            // get a connection
            Class.forName("com.mysql.jdbc.Driver");

            myConn = DriverManager.getConnection(url, use, password);
            // create sql statement
            // create sql to delete student
            String sql = "delete from item where ID=?";

            ps = myConn.prepareStatement(sql);

            ps.setInt(1, itemid);

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

}
