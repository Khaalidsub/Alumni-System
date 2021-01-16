/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import DAO.AlumniDAO;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Middleware.Alumni;
import Middleware.AlumniAddress;
import Middleware.EduLevel;
import Middleware.alumniTitle;
import static com.sun.org.apache.xalan.internal.xsltc.compiler.util.Type.String;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;

/**
 *
 * @author SleepingLotus
 */
@WebServlet(name = "AlumniController", urlPatterns = {"/AlumniController"})
public class AlumniController extends HttpServlet {

    private AlumniDAO alumniDao;

    @Override
    public void init() throws ServletException {
        alumniDao = AlumniDAO.getInstance();

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String command = request.getParameter("command");


        try {

            // if the command is missing, then default to login
            if (command == null) {
                command = "ALUMNI-INFO";
            }

            switch (command) {
                case "ALUMNI-SEARCH":
                    getAlumniList(request,response);
                    break;

                case "MY-PROFILE":
                   getAlumniInfo(request, response);
                    break;
                case "ALUMNI-INFO":
                    getAlumniInfo(request, response);

                case "INFO-DETAIL":
                    getDetailedAlumniInfo(request, response);
                    
               case "EDIT-PROFILE":
                    updateAlumniInfoPage(request, response);
                   
                    break;

            }

        } catch (Exception exc) {
            throw new ServletException(exc);
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            String command = request.getParameter("command");
            // if the command is missing, then default to login

//                switch (command) {
//              
//                        break;
//
//                }
        } catch (Exception exc) {
            throw new ServletException(exc);
        }
    }

    public void finalize() throws Throwable {

    }

    /**
     *
     * @param alumniEmail
     */

    public void getAlumniInfo(HttpServletRequest request, HttpServletResponse response) {

        try {
            Alumni alumni;
            System.out.println(request.getParameter("alumniEmail"));
            if(request.getParameter("alumniEmail")!=null){
                alumni = alumniDao.getAlumniInfo(request.getParameter("alumniEmail"));
            }else{
            alumni = alumniDao.getAlumniInfo("6naseer.far@wditu.com");}
            RequestDispatcher dispatcher;
            dispatcher = request.getRequestDispatcher("/alumni/alumniProfile.jsp");
            request.setAttribute("alumni", alumni);
            dispatcher.forward(request, response);
        } catch (Exception ex) {
            Logger.getLogger(AlumniController.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }
    public void getAlumniList(HttpServletRequest request, HttpServletResponse response) {
         try {
            List<Alumni> alumnis = alumniDao.getAlumniList();
            RequestDispatcher dispatcher;
            dispatcher = request.getRequestDispatcher("/alumni/search_alumni.jsp");
            request.setAttribute("ALUMNI_LIST", alumnis);
            dispatcher.forward(request, response);
        } catch (Exception ex) {
            Logger.getLogger(AlumniController.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }
    
    
        public void updateAlumniInfoPage(HttpServletRequest request, HttpServletResponse response) {

       try {
            Alumni alumni;
            AlumniAddress alumniAddress;
            System.out.println(request.getParameter("alumniEmail"));
            if(request.getParameter("alumniEmail")!=null){
                alumni = alumniDao.getDetailedAlumniInfo(request.getParameter("alumniEmail"));
                alumniAddress = alumniDao.getAlumniAddressInfo(alumni.getAlumniAddressID());
            }else{
            alumni = alumniDao.getDetailedAlumniInfo("6naseer.far@wditu.com");
            alumniAddress = alumniDao.getAlumniAddressInfo(alumni.getAlumniAddressID());
            }
            RequestDispatcher dispatcher;
            dispatcher = request.getRequestDispatcher("/alumni/edit_information.jsp");
            request.setAttribute("alumni", alumni);
            request.setAttribute("alumniAddress", alumniAddress);
            dispatcher.forward(request, response);
        } catch (Exception ex) {
            Logger.getLogger(AlumniController.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }

    /**
     *
     * @param alumniEmail
     */
    public void getDetailedAlumniInfo(HttpServletRequest request, HttpServletResponse response) {
        try {
            Alumni alumni;
            AlumniAddress alumniAddress;
            System.out.println(request.getParameter("alumniEmail"));
            if(request.getParameter("alumniEmail")!=null){
                alumni = alumniDao.getDetailedAlumniInfo(request.getParameter("alumniEmail"));
                alumniAddress = alumniDao.getAlumniAddressInfo(alumni.getAlumniAddressID());
            }else{
            alumni = alumniDao.getDetailedAlumniInfo("6naseer.far@wditu.com");
            alumniAddress = alumniDao.getAlumniAddressInfo(alumni.getAlumniAddressID());
            }
            RequestDispatcher dispatcher;
            dispatcher = request.getRequestDispatcher("/alumni/alumniInfo.jsp");
            request.setAttribute("alumni", alumni);
            request.setAttribute("alumniAddress", alumniAddress);
            dispatcher.forward(request, response);
        } catch (Exception ex) {
            Logger.getLogger(AlumniController.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }

    /**
     *
     * @param alumniName
     * @param query
     */
    public Alumni[] getFilteredAlumniList(String alumniName, String query) {
        return null;
    }

    /**
     *
     * @param alumniName
     */
    public Alumni[] getSearchedAlumni(String alumniName) {
        return null;
    }

  

    /**
     *
     * @param address
     * @param alumniEmail
     * @param phoneNo
     * @param eduLevel
     * @param graduateYear
     * @param courseName
     */
  /*  public void updateAlumniInfo(HttpServletRequest request, HttpServletResponse response) throw Exception{
        
        Alumni alumni = new Alumni();
        
        
    } */

    /**
     *
     * @param address
     * @param eduLevel
     * @param phoneNumber
     * @param title
     * @param courseName
     * @param graudateYear
     */
    public boolean validateFields(AlumniAddress address, EduLevel eduLevel, int phoneNumber, alumniTitle title, String courseName, int graudateYear) {
        return false;
    }

}
