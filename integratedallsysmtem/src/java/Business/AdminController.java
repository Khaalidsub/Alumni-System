package Business;

import Middleware.Alumni;
import Middleware.AlumniAddress;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import jdbc.AlumniDAO;
import jdbc.UserDAO;



/**
 * @author Asus
 * @version 1.0
 * @created 30-Dec-2020 10:06:32 PM
 */

@WebServlet(name = "AdminController", urlPatterns = {"/AdminController"})
public class AdminController extends HttpServlet{
    
    private UserDAO userdao;
    private AlumniDAO alumniDao;

    private Connection con;

    @Override
    public void init() throws ServletException {

        String driver = "com.mysql.jdbc.Driver";

        String dbName = "sdadatabase";
        String url = "jdbc:mysql://db:3306/" + dbName + "?";
        String userName = "root";
        String password = "";

        userdao = new UserDAO(driver,
                url,
                userName,
                password);

        userdao.jdbcConnect();

        //get JDC connection
        con = userdao.jdbcGetConnection();

        //prepare the statement once only
        //for the entire servlet lifecycle
        userdao.prepareSQLStatementRegister();

    }

    @Override

    public void destroy() {
        userdao.jdbcConClose();
    }

        @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession session = request.getSession();
        String command = request.getParameter("command");
        
        if(command==null){
            command="";
        }
        
        try{
            
            response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1.
            response.setHeader("Pragma", "no-cache"); // HTTP 1.0.
            response.setDateHeader("Expires", 0);
            
            switch(command){
                
                case "Manage-Alumni":
                    if(session.getAttribute("admin")!=null){
                        request.getRequestDispatcher("manageAlumni.jsp").forward(request, response);
                    }
                    break;
                    
                case "Add-Alumni-Page":
                     if(session.getAttribute("admin")!=null){
                        request.getRequestDispatcher("addAlumni.jsp").forward(request, response);
                    }
                    break;
                    
                case "Delete-Alumni-Page":
                     getAlumniList(request, response);                  
                    break;
                    
                case "View-Alumni-Page":
                     if(session.getAttribute("admin")!=null){
                        request.getRequestDispatcher("viewAlumni.jsp").forward(request, response);
                    }
                    break;
                    
              
                
                case "Delete-Alumni":
                    String id = request.getParameter("id");
                    try{
                    Statement st = con.createStatement();           
                    int status = st.executeUpdate("DELETE FROM alumni WHERE alumniID="+ id);
                    
                    }catch(Exception e){
                        System.out.print(e);
                        e.printStackTrace();
                    }
                    PrintWriter out = response.getWriter();
                    
                    out.println("<script>");
                        out.println("    alert('User Deleted Successfully!');");
                        out.println("    window.location = '" + request.getContextPath() + "/AdminController?command=Delete-Alumni-Page'");
                    out.println("</script>");
                   
                    
                    break;

                    
                 default:
                     if(session.getAttribute("admin")!=null){
                        request.getRequestDispatcher("adminHome.jsp").forward(request, response);
                    }
                     break;
            }
        
        
        }catch (Exception exc) {
            throw new ServletException(exc);
        }
        
        
    }
    
     protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         
         HttpSession session = request.getSession();
         String command = request.getParameter("command");
        
            if(command==null){
              command="";
              }
            
            try{
                 
            response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1.
            response.setHeader("Pragma", "no-cache"); // HTTP 1.0.
            response.setDateHeader("Expires", 0);
            
            switch(command){

                    case "Add-Alumni":    
                      AddAlumni(request, response);
                      break;
                      
                      default:
                         if(session.getAttribute("admin")!=null){
                        request.getRequestDispatcher("adminHome.jsp").forward(request, response);
                    }
                     break;
                          
                
                
            }
                
            }catch (Exception exc) {
            throw new ServletException(exc);
             }
            
            
            
     }
     
     
       public void getAlumniList(HttpServletRequest request, HttpServletResponse response) {
        try {
            request.getRequestDispatcher("deleteAlumni.jsp").forward(request, response);
            List<Alumni> alumnis = alumniDao.getAlumniList();       
            System.out.println(alumnis.get(0).toString());
            request.setAttribute("ALUMNI_LIST", alumnis);
            
        } catch (Exception ex) {
            Logger.getLogger(AdminController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
       
    
    
    public void AddAlumni(HttpServletRequest request, HttpServletResponse response) throws IOException , ServletException{
        
            
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
        String Coursename = request.getParameter("Coursename");

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
            PreparedStatement preparedStatement = userdao.getPsRegister();

            preparedStatement.setString(1, title);
            preparedStatement.setString(2, Name);
            preparedStatement.setString(3, password);
            preparedStatement.setString(4, matrics);
            preparedStatement.setString(5, gender);
            preparedStatement.setString(6, citizenship);
            preparedStatement.setString(7, Email);
            preparedStatement.setString(8, Phoneno);
            preparedStatement.setString(9, Coursename);
            preparedStatement.setString(10, edulevel);
            preparedStatement.setString(11, GraduateYear);
            preparedStatement.setString(12, id);

            int insertStatus = 0;
            insertStatus = preparedStatement.executeUpdate();

            if(insertStatus == 1){
                try (PrintWriter out = response.getWriter()) {
                        out.println("<script>");
                        out.println("    alert('USER ADDED SUCCESSFULLY!');");
                        out.println("    window.location = '" + request.getContextPath() + "/AdminController?command=Manage-Alumni'");
                        out.println("</script>");
                } 
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
            out.println("    window.location.href  = '/integratedallsysmtem/manageAlumni.jsp'");
            out.println("</script>");
        } catch (java.lang.Exception ex) {
            ex.printStackTrace();

            PrintWriter out = response.getWriter();

            out.println("<script>");
            out.println("    alert('alumni insert failed exception');");
            out.println("    window.location.href  = '/integratedallsysmtem/manageAlumni.jsp'");
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
    

