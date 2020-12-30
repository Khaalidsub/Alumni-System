/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import entity.Item;
import entity.Order;
import entity.TopUp;
import java.io.InputStream;
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
public class OrderDao {

    private String url = "jdbc:mysql://localhost:3306/flying_wheel?useTimezone=true&serverTimezone=UTC";
    private String use = "root";
    private String password = "";

    public void addOrder(Order order) throws Exception {

        Connection myConn = null;
        Statement stmt = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            // get a connection
            Class.forName("com.mysql.jdbc.Driver");

            myConn = DriverManager.getConnection(url, use, password);
            
            //create order
            String sql = "insert into order_item "
                    + "(user_id,item_id,quantity,total_cost,status) "
                    + "values (?,?,?,?,?)";

            ps = myConn.prepareStatement(sql);

            // set params            
            ps.setInt(1, order.getUser().getUserid());
            ps.setInt(2, order.getItem().getId());
            ps.setInt(3, order.getQuantity());
            ps.setFloat(4, order.getTotal_cost());
            ps.setString(5, "Order Placed");

            //execute query
            ps.execute();

            //reduce number of stock after buying
            int reduce = order.getQuantity();
            int currentStock = order.getItem().getStock();
            int updatedStock = currentStock - reduce;

            String sql_update = "update item set stock=? where ID=?";

            ps = myConn.prepareStatement(sql_update);

            //set params
            ps.setInt(1, updatedStock);
            ps.setInt(2, order.getItem().getId());

            //execute query
            ps.execute();

        } finally {
            // close JDBC objects
            close(myConn, stmt, rs);
        }

    }

    //get order list for manager
    //get new order list
    public List<Order> viewNewOrder() throws SQLException, ClassNotFoundException {

        Connection myConn = null;
        Statement stmt = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        List<Order> order_list = new ArrayList();

        try {
            // get a connection
            Class.forName("com.mysql.jdbc.Driver");
            myConn = DriverManager.getConnection(url, use, password);

            String sql = "SELECT order_item.*, user.*, item.* "
                    + "FROM order_item "
                    + "JOIN user ON user.ID = order_item.user_id "
                    + "JOIN item ON order_item.item_id = item.ID "
                    + "WHERE order_item.status ='Order Placed'";

            ps = myConn.prepareStatement(sql);

            //execute query
            rs = ps.executeQuery();

            while (rs.next()) {
                //get item info
                String item_name = rs.getString("item.name");
                String brand = rs.getString("item.brand");
                float cost = rs.getFloat("item.cost");
                int stock = rs.getInt("item.stock");
                int item_id = rs.getInt("item.ID");
                InputStream image = rs.getBinaryStream("item.image");

                //get user info
                String username = rs.getString("user.name");
                String email = rs.getString("user.email");
                String phone = rs.getString("user.phone");
                int userID = rs.getInt("user.ID");

                //get order info
                String status = rs.getString("status");
                int quantity = rs.getInt("order_item.quantity");
                float total_cost = rs.getFloat("order_item.total_cost");
                int order_id = rs.getInt("order_item.ID");

                Item item = new Item(item_id, item_name, cost, image, brand, stock);
              //  User user = new User(username, email, phone, userID);
                User user = new User();
                user.setEmail(email);
                user.setUsername(username);
                user.setPhone(phone);
                user.setUserid(userID);

                Order order = new Order(user, item, quantity, order_id, status, total_cost);

                order_list.add(order);
            }

        } finally {
            // close JDBC objects
            close(myConn, stmt, rs);
        }

        return order_list;
    }

    //get order detail 
    public Order getOrderDetail(int order_id) throws ClassNotFoundException, SQLException {

        Connection myConn = null;
        Statement stmt = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        Order order = new Order();

        try {
            // get a connection
            Class.forName("com.mysql.jdbc.Driver");
            myConn = DriverManager.getConnection(url, use, password);

            String sql = "SELECT order_item.*, user.*, item.* "
                    + "FROM order_item "
                    + "JOIN user ON user.ID = order_item.user_id "
                    + "JOIN item ON order_item.item_id = item.ID "
                    + "WHERE order_item.ID=?";

            ps = myConn.prepareStatement(sql);
            ps.setInt(1, order_id);

            //execute query
            rs = ps.executeQuery();

            while (rs.next()) {
                //get item info
                String item_name = rs.getString("item.name");
                String brand = rs.getString("item.brand");
                float cost = rs.getFloat("item.cost");
                int stock = rs.getInt("item.stock");
                int item_id = rs.getInt("item.ID");
                InputStream image = rs.getBinaryStream("image");

                //get user info
                String username = rs.getString("user.name");
                String email = rs.getString("user.email");
                String phone = rs.getString("user.phone");
                int userID = rs.getInt("user.ID");

                //get order info
                String status = rs.getString("status");
                int quantity = rs.getInt("order_item.quantity");
                float total_cost = rs.getFloat("order_item.total_cost");

                Item item = new Item(item_id, item_name, cost, image, brand, stock);
                User user = new User(username, email, phone, userID);

                order = new Order(user, item, quantity, order_id, status, total_cost);
            }

        } finally {
            // close JDBC objects
            close(myConn, stmt, rs);
        }

        return order;
    }

    //update order status
    //update order status
    public void updateOrderStatus(int orderID, String status) throws ClassNotFoundException, SQLException {
        Connection myConn = null;
        Statement stmt = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {

            // get a connection
            Class.forName("com.mysql.jdbc.Driver");
            myConn = DriverManager.getConnection(url, use, password);

            System.out.println(status);
            String sql = "update order_item set status=? where ID=?";

            ps = myConn.prepareStatement(sql);
            ps.setString(1, status);
            ps.setInt(2, orderID);

            ps.execute();

        } finally {
            // close JDBC objects
            close(myConn, stmt, rs);
        }
    }

    public List<Order> getOrders(String dateStart, String dateEnd) {
        List<Order> orders = new ArrayList<>();
        Connection myConn = null;
        Statement stmt = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            // get a connection
            Class.forName("com.mysql.jdbc.Driver");

            myConn = DriverManager.getConnection(url, use, password);

            String sql = "SELECT * FROM `order_item` WHERE"
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
                int itemid = rs.getInt("item_id");
                int quantity = rs.getInt("quantity");
                float cost = rs.getFloat("total_cost");
                Date date = rs.getDate("date");
                String status = rs.getString("status");

                Order order = new Order(userid, itemid, quantity, status, cost, date, id);
                orders.add(order);
            } while (rs.next());

            return orders;

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close(myConn, stmt, rs);
        }

        return null;

    }

    //view completed order for manager
    public List<Order> completedOrderList() throws ClassNotFoundException, SQLException {
        Connection myConn = null;
        Statement stmt = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        List<Order> order_list = new ArrayList();

        try {
            // get a connection
            Class.forName("com.mysql.jdbc.Driver");
            myConn = DriverManager.getConnection(url, use, password);

            String sql = "SELECT order_item.*, user.*, item.* "
                    + "FROM order_item "
                    + "JOIN user ON user.ID = order_item.user_id "
                    + "JOIN item ON order_item.item_id = item.ID "
                    + "WHERE order_item.status = 'Completed'";

            ps = myConn.prepareStatement(sql);

            //execute query
            rs = ps.executeQuery();

            while (rs.next()) {
                //get item info
                String item_name = rs.getString("item.name");
                String brand = rs.getString("item.brand");
                float cost = rs.getFloat("item.cost");
                int stock = rs.getInt("item.stock");
                int item_id = rs.getInt("item.ID");
                InputStream image = rs.getBinaryStream("image");

                //get user info
                String username = rs.getString("user.name");
                String email = rs.getString("user.email");
                String phone = rs.getString("user.phone");
                int userID = rs.getInt("user.ID");

                //get order info
                String status = rs.getString("status");
                int quantity = rs.getInt("order_item.quantity");
                float total_cost = rs.getFloat("order_item.total_cost");
                int order_id = rs.getInt("order_item.ID");

                Item item = new Item(item_id, item_name, cost, image, brand, stock);
                User user = new User(username, email, phone, userID);

                Order order = new Order(user, item, quantity, order_id, status, total_cost);
                order_list.add(order);
            }

        } finally {
            // close JDBC objects
            close(myConn, stmt, rs);
        }

        return order_list;
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

    // get customer Order
    public List<Order> customerOrder(int userid) throws ClassNotFoundException, SQLException {
        Connection myConn = null;
        Statement stmt = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        List<Order> order_list = new ArrayList();

        try {
            // get a connection
            Class.forName("com.mysql.jdbc.Driver");
            myConn = DriverManager.getConnection(url, use, password);

            String sql = "SELECT order_item.*, user.*, item.* "
                    + "FROM order_item "
                    + "JOIN user ON user.ID = order_item.user_id "
                    + "JOIN item ON order_item.item_id = item.ID "
                    + "WHERE order_item.status <>'Completed'"
                    + "AND user.ID=?";

            ps = myConn.prepareStatement(sql);

            ps.setInt(1, userid);

            //execute query
            rs = ps.executeQuery();

            while (rs.next()) {
                //get item info
                String item_name = rs.getString("item.name");
                String brand = rs.getString("item.brand");
                float cost = rs.getFloat("item.cost");
                int stock = rs.getInt("item.stock");
                int item_id = rs.getInt("item.ID");
                InputStream image = rs.getBinaryStream("image");

                //get user info
                String username = rs.getString("user.name");
                String email = rs.getString("user.email");
                String phone = rs.getString("user.phone");
                int userID = rs.getInt("user.ID");

                //get order info
                String status = rs.getString("status");
                int quantity = rs.getInt("order_item.quantity");
                float total_cost = rs.getFloat("order_item.total_cost");
                int order_id = rs.getInt("order_item.ID");

                Item item = new Item(item_id, item_name, cost, image, brand, stock);
                User user = new User(username, email, phone, userID);

                Order order = new Order(user, item, quantity, order_id, status, total_cost);

                order_list.add(order);
            }

        } finally {
            // close JDBC objects
            close(myConn, stmt, rs);
        }

        return order_list;
    }

    //get customer's completed order
    public List<Order> customerCompletedOrder(int userid) throws ClassNotFoundException, SQLException {

        Connection myConn = null;
        Statement stmt = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        List<Order> order_list = new ArrayList();

        try {
            // get a connection
            Class.forName("com.mysql.jdbc.Driver");
            myConn = DriverManager.getConnection(url, use, password);

            String sql = "SELECT order_item.*, user.*, item.* "
                    + "FROM order_item "
                    + "JOIN user ON user.ID = order_item.user_id "
                    + "JOIN item ON order_item.item_id = item.ID "
                    + "WHERE order_item.status ='Completed'"
                    + "AND user.ID=?";

            ps = myConn.prepareStatement(sql);

            ps.setInt(1, userid);

            //execute query
            rs = ps.executeQuery();

            while (rs.next()) {
                //get item info
                String item_name = rs.getString("item.name");
                String brand = rs.getString("item.brand");
                float cost = rs.getFloat("item.cost");
                int stock = rs.getInt("item.stock");
                int item_id = rs.getInt("item.ID");
                InputStream image = rs.getBinaryStream("image");

                //get user info
                String username = rs.getString("user.name");
                String email = rs.getString("user.email");
                String phone = rs.getString("user.phone");
                int userID = rs.getInt("user.ID");

                //get order info
                String status = rs.getString("status");
                int quantity = rs.getInt("order_item.quantity");
                float total_cost = rs.getFloat("order_item.total_cost");
                int order_id = rs.getInt("order_item.ID");

                Item item = new Item(item_id, item_name, cost, image, brand, stock);
                User user = new User(username, email, phone, userID);

                Order order = new Order(user, item, quantity, order_id, status, total_cost);

                order_list.add(order);
            }

        } finally {
            // close JDBC objects
            close(myConn, stmt, rs);
        }

        return order_list;
    }

    // get all preparing orders for manager
    public List<Order> viewPreparedOrder() throws ClassNotFoundException, SQLException {
        Connection myConn = null;
        Statement stmt = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        List<Order> order_list = new ArrayList();

        try {
            // get a connection
            Class.forName("com.mysql.jdbc.Driver");
            myConn = DriverManager.getConnection(url, use, password);

            String sql = "SELECT order_item.*, user.*, item.* "
                    + "FROM order_item "
                    + "JOIN user ON user.ID = order_item.user_id "
                    + "JOIN item ON order_item.item_id = item.ID "
                    + "WHERE order_item.status ='Preparing'";

            ps = myConn.prepareStatement(sql);

            //execute query
            rs = ps.executeQuery();

            while (rs.next()) {
                //get item info
                String item_name = rs.getString("item.name");
                String brand = rs.getString("item.brand");
                float cost = rs.getFloat("item.cost");
                int stock = rs.getInt("item.stock");
                int item_id = rs.getInt("item.ID");
                InputStream image = rs.getBinaryStream("item.image");

                //get user info
                String username = rs.getString("user.name");
                String email = rs.getString("user.email");
                String phone = rs.getString("user.phone");
                int userID = rs.getInt("user.ID");

                //get order info
                String status = rs.getString("status");
                int quantity = rs.getInt("order_item.quantity");
                float total_cost = rs.getFloat("order_item.total_cost");
                int order_id = rs.getInt("order_item.ID");

                Item item = new Item(item_id, item_name, cost, image, brand, stock);
                User user = new User(username, email, phone, userID);

                Order order = new Order(user, item, quantity, order_id, status, total_cost);

                order_list.add(order);
            }

        } finally {
            // close JDBC objects
            close(myConn, stmt, rs);
        }

        return order_list;
    }

    // get all ready orders for manager
    public List<Order> viewReadyOrder() throws ClassNotFoundException, SQLException {
        Connection myConn = null;
        Statement stmt = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        List<Order> order_list = new ArrayList();

        try {
            // get a connection
            Class.forName("com.mysql.jdbc.Driver");
            myConn = DriverManager.getConnection(url, use, password);

            String sql = "SELECT order_item.*, user.*, item.* "
                    + "FROM order_item "
                    + "JOIN user ON user.ID = order_item.user_id "
                    + "JOIN item ON order_item.item_id = item.ID "
                    + "WHERE order_item.status ='Ready for Collection'";

            ps = myConn.prepareStatement(sql);

            //execute query
            rs = ps.executeQuery();

            while (rs.next()) {
                //get item info
                String item_name = rs.getString("item.name");
                String brand = rs.getString("item.brand");
                float cost = rs.getFloat("item.cost");
                int stock = rs.getInt("item.stock");
                int item_id = rs.getInt("item.ID");
                InputStream image = rs.getBinaryStream("item.image");

                //get user info
                String username = rs.getString("user.name");
                String email = rs.getString("user.email");
                String phone = rs.getString("user.phone");
                int userID = rs.getInt("user.ID");

                //get order info
                String status = rs.getString("status");
                int quantity = rs.getInt("order_item.quantity");
                float total_cost = rs.getFloat("order_item.total_cost");
                int order_id = rs.getInt("order_item.ID");

                Item item = new Item(item_id, item_name, cost, image, brand, stock);
                User user = new User(username, email, phone, userID);

                Order order = new Order(user, item, quantity, order_id, status, total_cost);

                order_list.add(order);
            }

        } finally {
            // close JDBC objects
            close(myConn, stmt, rs);
        }

        return order_list;
    }
}
