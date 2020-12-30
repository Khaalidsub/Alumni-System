/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import java.io.IOException;
import java.io.OutputStream;
import static java.lang.System.out;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Bellarina C
 */
@WebServlet(name = "ImageLoaderServlet", urlPatterns = {"/ImageLoaderServlet"})
public class ImageLoaderServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ClassNotFoundException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        OutputStream o = response.getOutputStream();

        String url = "jdbc:mysql://localhost:3306/flying_wheel?useTimezone=true&serverTimezone=UTC";
        String use = "root";
        String password = "";
        String sql=null;

        int image_id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");

        try{
        // get a connection
            Class.forName("com.mysql.jdbc.Driver");

            Connection myConn = DriverManager.getConnection(url, use, password);
            // create sql statement
            //check if email exists
            System.out.println(" image loader"+name);
            if(name.equals("bicycle")){
                sql = "SELECT image FROM `bicycle` WHERE ID="+image_id+"";
            }
            else{
                sql = "SELECT image FROM `item` WHERE ID="+image_id+"";
            }

            // create prepared statement
            Statement stmt = myConn.createStatement();

            PreparedStatement ps = myConn.prepareStatement(sql);

            //execute query
            ResultSet rs = ps.executeQuery();

            //process resultset
            while (rs.next()){
                Blob image = rs.getBlob("image");
                byte[] imgData = image.getBytes(1,(int)image.length());            
            
                // display the image
                response.setContentType("image/jpg");
                o.write(imgData);            
            }
            
            o.flush();
            o.close();
            rs.close();
            stmt.close();
            myConn.close();
            
            } catch (Exception e) {
                out.println("Unable To Display image");
                out.println("Image Display Error=" + e.getMessage());
            } 
            
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ImageLoaderServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ImageLoaderServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ImageLoaderServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ImageLoaderServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
