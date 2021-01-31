package Dao;

import entity.Cart;
import entity.Item;
import entity.User;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class CartDao {
    private String url = "jdbc:mysql://localhost:3306/flying_wheel?useTimezone=true&serverTimezone=UTC";
    private String use = "root";
    private String password = "";

    //return cart list
    public List<Cart> cartList(int userID) throws SQLException, ClassNotFoundException{
        List<Cart> cartList = new ArrayList<>();
        Cart cart_item = new Cart();
        
        //to save item info in Item class
        Item item = new Item();
        
        //to save user info in User class
        User user = new User();
        
        Connection myConn = null;
        Statement stmt = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        try{
            // get a connection
            Class.forName("com.mysql.jdbc.Driver");

            myConn = DriverManager.getConnection(url, use, password);
            
            // create sql statement
            String sql = "SELECT cart.*, item.*, user.* "
                    + "FROM cart "
                    + "JOIN item ON cart.item_id = item.ID "
                    + "JOIN user ON user.ID = cart.user_id "
                    + "WHERE cart.user_id=?";

            ps = myConn.prepareStatement(sql);
            
            // set params
            ps.setInt(1, userID);
          
            //execute query
            rs = ps.executeQuery();

            //when item is found
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
                
                //get cart info
                int quantity = rs.getInt("cart.quantity");
                int cartID = rs.getInt("cart.cart_id");
                
                item = new Item(item_id, item_name, cost, image, brand, stock);
//                user = new User(username, email, phone, userID);
                user.setUsername(username);
                user.setEmail(email);
                user.setPhone(phone);
                user.setUserid(userID);
                
                cart_item = new Cart(cartID,  user, item, quantity);
                cartList.add(cart_item);                
            }
            
        }finally{
            // close JDBC objects
            close(myConn, stmt, rs);
        }
        
        return cartList;       
        
    }
    
    //delete cart item
    public void deleteCartItem(int cartID) throws ClassNotFoundException, SQLException{
        Connection myConn = null;
        Statement stmt = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        try{
            // get a connection
            Class.forName("com.mysql.jdbc.Driver");

            myConn = DriverManager.getConnection(url, use, password);
            
            // create sql statement
            String sql = "delete from cart where cart_id=?";

            ps = myConn.prepareStatement(sql);
            
            // set params
            ps.setInt(1, cartID);
          

            //execute query
            ps.execute();

            
        }finally{
            // close JDBC objects
            close(myConn, stmt, rs);
        }
    }
 public void deleteAll(int userid) throws ClassNotFoundException, SQLException{
        Connection myConn = null;
        Statement stmt = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        try{
            // get a connection
            Class.forName("com.mysql.jdbc.Driver");

            myConn = DriverManager.getConnection(url, use, password);
            
            // create sql statement
            String sql = "delete  from cart where user_id=?";

            ps = myConn.prepareStatement(sql);
            
            // set params
            ps.setInt(1, userid);
          

            //execute query
            ps.execute();

            
        }finally{
            // close JDBC objects
            close(myConn, stmt, rs);
        }
    }
    //add to cart
    public void addToCart(int userID, int itemID, int quantity) throws ClassNotFoundException, SQLException{
        Connection myConn = null;
        Statement stmt = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        try{
            // get a connection
            Class.forName("com.mysql.jdbc.Driver");

            myConn = DriverManager.getConnection(url, use, password);
            
            // create sql statement
            String sql = "insert into cart (user_id, item_id, quantity) values(?,?,?)";

            ps = myConn.prepareStatement(sql);
            
            // set params
            ps.setInt(1, userID);
            ps.setInt(2, itemID);
            ps.setInt(3, quantity);          

            //execute query
            ps.execute();

            
        }finally{
            // close JDBC objects
            close(myConn, stmt, rs);
        }
    }
    
    //get cart item
    public Cart getCartItem(int cartID) throws ClassNotFoundException, SQLException{
        List<Cart> cartList = new ArrayList<>();
        Cart cart_item = new Cart();
        
        //to save item info in Item class
        Item item = new Item();
        
        //to save user info in User class
        User user = new User();
        
        Connection myConn = null;
        Statement stmt = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        try{
            // get a connection
            Class.forName("com.mysql.jdbc.Driver");

            myConn = DriverManager.getConnection(url, use, password);
            
            // create sql statement
            String sql = "SELECT cart.*, item.*, user.* "
                    + "FROM cart "
                    + "JOIN item ON cart.item_id = item.ID "
                    + "JOIN user ON user.ID = cart.user_id "
                    + "WHERE cart.cart_id=?";

            ps = myConn.prepareStatement(sql);
            
            // set params
            ps.setInt(1, cartID);
          
            //execute query
            rs = ps.executeQuery();

            //when item is found
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
                
                //get cart info
                int quantity = rs.getInt("cart.quantity");
                
                item = new Item(item_id, item_name, cost, image, brand, stock);
                user = new User(username, email, phone, userID);
                
                cart_item = new Cart(cartID,  user, item, quantity);               
            }
            
        }finally{
            // close JDBC objects
            close(myConn, stmt, rs);
        }
       
        return cart_item;  
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
