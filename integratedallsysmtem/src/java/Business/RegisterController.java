/**
 * @author Asus
 * @version 1.0
 * @created 30-Dec-2020 10:06:48 PM
 */
package Business;

import Middleware.AlumniAddress;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.sql.*;
import java.util.List;
import jdbc.AlumniDAO;
import jdbc.UserDAO;

@WebServlet(name = "RegisterController", urlPatterns = {"/RegisterController"})
public class RegisterController extends HttpServlet {

    private UserDAO jdbcUtility;

    private Connection con;

    @Override
    public void init() throws ServletException {

        String driver = "com.mysql.jdbc.Driver";

        String dbName = "sdadatabase";
        String url = "jdbc:mysql://db:3306/" + dbName + "?";
        String userName = "root";
        String password = "sdadatabase123";

        jdbcUtility = new UserDAO(driver,
                url,
                userName,
                password);

        jdbcUtility.jdbcConnect();

        //get JDC connection
        con = jdbcUtility.jdbcGetConnection();

        //prepare the statement once only
        //for the entire servlet lifecycle
        jdbcUtility.prepareSQLStatementRegister();

    }

    @Override

    public void destroy() {
        jdbcUtility.jdbcConClose();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        String title = request.getParameter("title");
        String Name = request.getParameter("Name");
        String password = request.getParameter("password");
        String matrics = request.getParameter("matrics");
        String gender = request.getParameter("gender");
        String citizenship = request.getParameter("citizenship");
        String edulevel = request.getParameter("edulevel");
        String Email = request.getParameter("Email");
        String GraduateYear = request.getParameter("GraduateYear");
        String Phoneno = request.getParameter("Phoneno");
        String courseName = request.getParameter("courseName");

        String Houseno = request.getParameter("Houseno");
        String Streetname = request.getParameter("Streetname");
        String Region = request.getParameter("Region");
        String City = request.getParameter("City");
        String State = request.getParameter("State");
        String Postalcode = request.getParameter("Postalcode");
        String Country = request.getParameter("Country");
        AlumniAddress address = new AlumniAddress(City, Country, Houseno, Postalcode, Region, State, Streetname);

        AlumniDAO alumnidao = AlumniDAO.getInstance();

        try {
            int count = alumnidao.getnumberofAddresses();
            String id = this.appendaddressID(count);
            alumnidao.addAlumniAddress(address, id);
            PreparedStatement preparedStatement = jdbcUtility.getPsRegister();

            preparedStatement.setString(1, title);
            preparedStatement.setString(2, Name);
            preparedStatement.setString(3, password);
            preparedStatement.setString(4, matrics);
            preparedStatement.setString(5, gender);
            preparedStatement.setString(6, citizenship);
            preparedStatement.setString(7, Email);
            preparedStatement.setString(8, Phoneno);
            preparedStatement.setString(9, courseName);
            preparedStatement.setString(10, edulevel);
            preparedStatement.setString(11, GraduateYear);
            preparedStatement.setString(12, id);

            int insertStatus = 0;
            insertStatus = preparedStatement.executeUpdate();

            PrintWriter out = response.getWriter();

            out.println(insertStatus);

            if (insertStatus == 1) {
                out.println("<script>");
                out.println("  alert('Register Success');");
                out.println("    window.location.href  = '/integratedallsysmtem/index.jsp'");
                out.println("</script>");
            }
        } catch (SQLException ex) {
            while (ex != null) {
                System.out.println("SQLState: " + ex.getSQLState());
                System.out.println("Message:  " + ex.getMessage());
                System.out.println("Vendor:   " + ex.getErrorCode());
                ex = ex.getNextException();
                System.out.println("");
            }

            PrintWriter out = response.getWriter();

            out.println("<script>");
            out.println("    alert('alumni insert failed sqlexception ');");
            out.println("    window.location.href = '/register.html'");
            out.println("</script>");
        } catch (java.lang.Exception ex) {
            ex.printStackTrace();

            PrintWriter out = response.getWriter();

            out.println("<script>");
            out.println("    alert('alumni insert failed exception');");
            out.println("    window.location = '/register.html'");
            out.println("</script>");
        }

    }

    String appendaddressID(int size) {
        String alumniID = "Aid";
        if (size + 1 > 100) {
            alumniID += (size + 1);

        } else if (size + 1 > 10) {
            alumniID += "0" + (size + 1);
        } else {
            alumniID += "00" + (size + 1);
        }
        return alumniID;
    }

}
