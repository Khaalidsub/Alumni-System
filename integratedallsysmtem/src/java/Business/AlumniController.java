/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import jdbc.AlumniDAO;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Middleware.Alumni;
import Middleware.AlumniAddress;
import Middleware.EduLevel;
import Middleware.SignIn;
import Middleware.alumniTitle;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpSession;

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

        HttpSession session = request.getSession();
        SignIn signIn = (SignIn) session.getAttribute("signIn");
        System.out.println("session exists : " + signIn.getEmail());
        request.setAttribute("signEmail", signIn.getEmail());
        try {

            // if the command is missing, then default to login
            if (command == null) {
                command = "ALUMNI-INFO";
            }

            switch (command) {
                case "ALUMNI-SEARCH":
                    getAlumniList(request, response);
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
        String command = request.getParameter("command");

        try {

            // if the command is missing, then default to login
            if (command == null) {
                command = "ALUMNI-INFO";
            }

            switch (command) {
                case "UPDATE-ALUMNI":
                    updateAlumniInfo(request, response);

                case "SEARCH-ALUMNI":
                    getSearchedAlumni(request, response);
                    break;
                case "FILTER-ALUMNI":
                    getFilteredAlumniList(request, response);
                    break;
            }

        } catch (Exception exc) {
            throw new ServletException(exc);
        }
    }

    public void finalize() throws Throwable {

    }

    public void updateAlumniInfo(HttpServletRequest request, HttpServletResponse response) {

        String streetName = request.getParameter("streetName");
        String houseNo = request.getParameter("houseNo");
        String postalCode = request.getParameter("postalCode");
        String state = request.getParameter("state");
        String city = request.getParameter("city");
        String country = request.getParameter("country");
        String region = request.getParameter("region");
        String title = request.getParameter("title");
        String graduateYear = request.getParameter("graduateYear");
        String phone = request.getParameter("phone");

        try {
            Alumni alumni = alumniDao.getDetailedAlumniInfo(request.getParameter("email"));

            AlumniAddress alumniAddress = alumniDao.getAlumniAddressInfo(alumni.getAlumniAddressID());
            alumni.setPhoneNo(Integer.valueOf(phone));
            alumni.setTitle(alumniTitle.valueOf(title));
            alumni.setGraduateYear(Integer.valueOf(graduateYear));
            alumni.setAlumniEmail(request.getParameter("email"));

            alumniAddress.setCity(city);
            alumniAddress.setCountry(country);
            alumniAddress.setHouseNo(houseNo);
            alumniAddress.setRegion(region);
            alumniAddress.setState(state);
            alumniAddress.setPostalCode(postalCode);
            alumniAddress.setStreetName(streetName);

            alumni.setAlumniAddress(alumniAddress);
            System.out.println("Business.AlumniController.updateAlumniInfo() : " + alumniAddress);

            alumniDao.updateAlumniDetails(alumni);
            request.setAttribute("alumniEmail", alumni.getAlumniEmail());
            getAlumniInfo(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    /**
     *
     * @param alumniEmail
     */
    public void getAlumniInfo(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        SignIn signIn = (SignIn) session.getAttribute("signIn");
        try {
            Alumni alumni;
            System.out.println("session" + signIn.getEmail() != null);
            if (request.getParameter("alumniEmail") != null) {
                alumni = alumniDao.getAlumniInfo(request.getParameter("alumniEmail"));
            } else if (signIn != null) {
                alumni = alumniDao.getAlumniInfo(signIn.getEmail());
            } else {
                alumni = alumniDao.getAlumniInfo("6naseer.far@wditu.com");
            }

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
            System.out.println(alumnis.get(0).toString());
            request.setAttribute("ALUMNI_LIST", alumnis);
            dispatcher.forward(request, response);
        } catch (Exception ex) {
            Logger.getLogger(AlumniController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void updateAlumniInfoPage(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        SignIn signIn = (SignIn) session.getAttribute("signIn");
        RequestDispatcher dispatcher;
        try {
            Alumni alumni;
            AlumniAddress alumniAddress;
            System.out.println(request.getParameter("alumniEmail"));

            if (signIn != null) {
                alumni = alumniDao.getDetailedAlumniInfo(signIn.getEmail());

                alumniAddress = alumniDao.getAlumniAddressInfo(alumni.getAlumniAddressID());
            } else if (request.getParameter("alumniEmail") != null) {
                alumni = alumniDao.getDetailedAlumniInfo(request.getParameter("alumniEmail"));
                alumniAddress = alumniDao.getAlumniAddressInfo(alumni.getAlumniAddressID());
            } else {
                alumni = alumniDao.getDetailedAlumniInfo("6naseer.far@wditu.com");
                alumniAddress = alumniDao.getAlumniAddressInfo(alumni.getAlumniAddressID());
            }

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
            if (request.getParameter("alumniEmail") != null) {
                alumni = alumniDao.getDetailedAlumniInfo(request.getParameter("alumniEmail"));
                alumniAddress = alumniDao.getAlumniAddressInfo(alumni.getAlumniAddressID());
            } else {
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
    public void getFilteredAlumniList(HttpServletRequest request, HttpServletResponse response) {
        List<Alumni> alumnis = new ArrayList<>();
        try {
            String alumniName = request.getParameter("alumniName");
            String query = request.getParameter("filter");
            String queryValue = request.getParameter(query + "_input");

            alumnis = alumniDao.getFilteredAlumni(alumniName, query, queryValue);
            RequestDispatcher dispatcher;
            dispatcher = request.getRequestDispatcher("/alumni/search_alumni.jsp");
            request.setAttribute("ALUMNI_LIST", alumnis);
            dispatcher.forward(request, response);
        } catch (Exception ex) {
            Logger.getLogger(AlumniController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     *
     * @param alumniName
     */
    public void getSearchedAlumni(HttpServletRequest request, HttpServletResponse response) {
        List<Alumni> alumnis = new ArrayList<>();

        try {
            alumnis = alumniDao.getSearchedAlumni(request.getParameter("alumniName"));
            RequestDispatcher dispatcher;
            dispatcher = request.getRequestDispatcher("/alumni/search_alumni.jsp");
            request.setAttribute("ALUMNI_LIST", alumnis);
            dispatcher.forward(request, response);
        } catch (Exception ex) {
            Logger.getLogger(AlumniController.class.getName()).log(Level.SEVERE, null, ex);
        }

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

    public void validateUser(HttpServletRequest request, HttpServletResponse response) throws ServletException {

//         String command = request.getParameter("command");
//        String userType = request.getSession("userType");
////       int register = request.getSession("login");
//         
//         if (userType == "UTM_Alumni"){
//             
//             if (login == 1){
//               
//                if (register == 1){
//                try {
//
//            
//            if (command == null) {
//                command = "ALUMNI-INFO";
//            }
//
//            switch (command) {
//                case "UPDATE-ALUMNI":
//                    updateAlumniInfo(request, response);
//
//                case "SEARCH-ALUMNI":
//                    getSearchedAlumni(request, response);
//                    break;
//                case "FILTER-ALUMNI":
//                    getFilteredAlumniList(request, response);
//                    
//                case "INFO-DETAIL":
//                    getDetailedAlumniInfo(request, response);
//                    
//                case "ALUMNI-INFO":
//                    getAlumniInfo(request, response);
//                    
//                    break;
//            }
//
//        } catch (Exception exc) {
//            throw new ServletException(exc);
//        }
//        }
//                 else {
//                    try {
//            if (command == null) {
//                command = "ALUMNI-INFO";
//            }
//
//            switch (command) {
//                
//
//                case "SEARCH-ALUMNI":
//                    getSearchedAlumni(request, response);
//                    break;
//                case "FILTER-ALUMNI":
//                    getFilteredAlumniList(request, response);
//                    
//                case "INFO-DETAIL":
//                    getDetailedAlumniInfo(request, response);
//                    
//                case "ALUMNI-INFO":
//                    getAlumniInfo(request, response);
//                    
//                    break;
//            }
//
//        } catch (Exception exc) {
//            throw new ServletException(exc);
//        }
//            }   
//            } else {   getDetailedAlumniInfo(request, response);}  
//             
//        } else { getDetailedAlumniInfo(request, response);}     
    }
}
