/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import Dao.BicycleDao;
import Dao.BookingDao;
import Dao.ItemDao;
import Dao.OrderDao;
import Dao.TopupDao;
import Dao.UserDao;
import entity.Bicycle;
import entity.Booking;
import entity.Item;
import entity.Order;
import entity.TopUp;
import entity.User;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Khalid
 */
@WebServlet(name = "AdminControllerServlet", urlPatterns = {"/AdminControllerServlet"})
public class AdminControllerServlet extends HttpServlet {

    private UserDao userDAO;
    private User user;
    private BicycleDao bicycleDAO;
    private ItemDao itemDAO;
    private BookingDao bookingDAO;
    private TopupDao topupDAO;
    private OrderDao orderDAO;

    @Override
    public void init() throws ServletException {
        user = new User();
        userDAO = new UserDao();
        bicycleDAO = new BicycleDao();
        itemDAO = new ItemDao();
        bookingDAO = new BookingDao();
        topupDAO = new TopupDao();
        orderDAO = new OrderDao();

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //get first vaues from login to verify logged
        //then create 
        //sessions

        //response.sendRedirect("/customer/customer-register.jsp");
        try {
            String command = request.getParameter("command");
            System.out.println(command);
            // if the command is missing, then default to login
            if (command == null) {
                command = "HOME";
            }

            HttpSession session = request.getSession(true);
            if (session == null || session.getAttribute("admin") == null) {
                response.sendRedirect("index.jsp"); // No logged-in user found, so redirect to login page.

            } else {
                response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1.
                response.setHeader("Pragma", "no-cache"); // HTTP 1.0.
                response.setDateHeader("Expires", 0);

                switch (command) {
                    case "HOME":
                        adminPage(request, response);
                        break;
                    case "VIEW-MANAGER":
                        viewManager(request, response);
                        break;
                    case "ADD-MANAGER":
                        addManagerPage(request, response);
                        break;
                    case "VIEW-MEMBER":
                        viewUser(request, response);
                        break;
                    case "VIEW-BICYCLE":
                        viewBicycle(request, response);
                        break;
                    case "VIEW-ITEM":
                        viewItem(request, response);
                        break;
                    case "LOAD":
                        loadManager(request, response);
                        break;
                    case "DELETE":
                        deleteManager(request, response);
                        break;
                    case "DISABLE":
                        disableManager(request, response);
                        break;
                    case "VIEW-FINANCIAL-REPORT":
                        selectFinancialReport(request, response);
                        break;
                    case "LOGOUT":
                        logout(request, response);
                        break;
                }
            }

        } catch (Exception exc) {
            throw new ServletException(exc);
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession(true);

        try {
            String command = request.getParameter("command");
            // if the command is missing, then default to login
            if (command == null) {
                command = "HOME";
            }

            switch (command) {
                case "HOME":
                    adminPage(request, response);
                    break;
                case "ADD-MANAGER":
                    addManager(request, response);
                    break;
                case "UPDATE-MANAGER":
                    updateManager(request, response);
                    break;
                case "FINANCIAL-REPORT":
                    showFinancialReport(request, response);
                    break;

            }

        } catch (Exception exc) {
            throw new ServletException(exc);
        }
    }

    private void addManager(HttpServletRequest request, HttpServletResponse response) throws Exception {

        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String IC = request.getParameter("IC");
        String password = request.getParameter("password");
        String phone = request.getParameter("phone");
        Date DOB = Date.valueOf(request.getParameter("DOB"));

        user = new User();
        user.setUsername(name);
        user.setEmail(email);
        user.setIC(IC);
        user.setDOB(DOB);
        user.setPassword(password);
        user.setPhone(phone);
        user.setRole("manager");

        //System.out.println(user);
        if (userDAO.addUser(user)) {
            //success and go to view page
            request.setAttribute("success", user.getUsername());
            viewManager(request, response);
        } else {
            //failed since email already taken!
            request.setAttribute("fail", "email already exists");
            addManagerPage(request, response);
        }

    }

    private void adminPage(HttpServletRequest request, HttpServletResponse response) throws Exception, IOException {
        //getting the number of members
        List<User> customers = userDAO.getCustomers();
        request.setAttribute("customers", customers.size());
        //number of items
        List<Item> items = itemDAO.getItem();
        //number of bicycles
        List<Bicycle> bicycles = bicycleDAO.getBicycles();
        //number of managers
        List<User> managers = userDAO.getManagers();
        request.setAttribute("managers", managers.size());
        request.setAttribute("bicycles", bicycles.size());
        request.setAttribute("items", items.size());

        RequestDispatcher dispatcher;
        dispatcher = request.getRequestDispatcher("/admin/adminDashboard.jsp");
        dispatcher.forward(request, response);
    }

    private void addManagerPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher;
        dispatcher = request.getRequestDispatcher("/admin/addManagers.jsp");
        dispatcher.forward(request, response);
    }

    private void viewManager(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, Exception {

        //getting the mangers
        List<User> managers = userDAO.getManagers();

        //add managers to the request
        request.setAttribute("MANAGER_LIST", managers);

        RequestDispatcher dispatcher;
        dispatcher = request.getRequestDispatcher("/admin/viewManager.jsp");
        dispatcher.forward(request, response);
    }

    private void viewUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, Exception {

        //getting the mangers
        List<User> managers = userDAO.getCustomers();

        //add managers to the request
        request.setAttribute("MANAGER_LIST", managers);

        RequestDispatcher dispatcher;
        dispatcher = request.getRequestDispatcher("/admin/viewUser.jsp");
        dispatcher.forward(request, response);
    }

    private void viewItem(HttpServletRequest request, HttpServletResponse response) throws Exception {
        //getting the items
        List<Item> items = itemDAO.getItem();

        //add bicycles to the request
        request.setAttribute("ITEM_LIST", items);

        RequestDispatcher dispatcher;
        dispatcher = request.getRequestDispatcher("/admin/viewItem.jsp");
        dispatcher.forward(request, response);
    }

    private void viewBicycle(HttpServletRequest request, HttpServletResponse response) throws Exception {
        //getting the bicycles
        List<Bicycle> bicycles = bicycleDAO.getBicycles();

        //add bicycles to the request
        request.setAttribute("BICYCLE_LIST", bicycles);

        RequestDispatcher dispatcher;
        dispatcher = request.getRequestDispatcher("/admin/viewBicycle.jsp");
        dispatcher.forward(request, response);
    }

    private void deleteManager(HttpServletRequest request, HttpServletResponse response) throws IOException, Exception {

        //read manager id from data
        String userid = request.getParameter("userId");

        //delete manager from db
        userDAO.deleteUser(userid);

        //success and go to view page
        viewManager(request, response);

    }

    private void disableManager(HttpServletRequest request, HttpServletResponse response) throws Exception{
        //read manager id from data
        String userid = request.getParameter("userId");

        //delete manager from db
        userDAO.disableUser(userid);

        //success and go to view page
        viewManager(request, response);
    }

    private void loadManager(HttpServletRequest request, HttpServletResponse response) throws Exception {

        String id = request.getParameter("userId");

        user = userDAO.getUserupdate(id);
        System.out.println("load manager" + user);
        RequestDispatcher dispatcher;
        request.setAttribute("user", user);
        dispatcher = request.getRequestDispatcher("/admin/updateManager.jsp");
        dispatcher.forward(request, response);
    }

    private void updateManager(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");
        user.setPhone(phone);
        user.setEmail(email);
        userDAO.updateManager(user);

        viewManager(request, response);
    }

    private void selectFinancialReport(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher;
        dispatcher = request.getRequestDispatcher("/admin/selectFinancialReport.jsp");
        dispatcher.forward(request, response);
    }

    private void showFinancialReport(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String reportType = request.getParameter("reportType");
        String dateStart = request.getParameter("date-start");
        String dateEnd = request.getParameter("date-end");
        int totalcost = 0;

        if (Date.valueOf(dateStart).getTime() > Date.valueOf(dateEnd).getTime()) {
            request.setAttribute("fail", "Wrong date format! date from cannot ever be greater than date-to");
            selectFinancialReport(request, response);
        }

        if (reportType.equals("booking")) {
            List<Booking> bookinglist = bookingDAO.getBookings(dateStart, dateEnd);
            if (bookinglist == null) {
                request.setAttribute("fail", "Sorry. Dont have earnings on selected dates.");
                RequestDispatcher dispatcher;
                dispatcher = request.getRequestDispatcher("/admin/selectFinancialReport.jsp");
                dispatcher.forward(request, response);
            } else {
                request.setAttribute("BOOKING_LIST", bookinglist);
                for (int i = 0; i < bookinglist.size(); i++) {
                    totalcost += bookinglist.get(i).getCost();
                }
                request.setAttribute("TotalCost", "Total Earning: RM " + totalcost + ".00");
                RequestDispatcher dispatcher;
                dispatcher = request.getRequestDispatcher("/admin/FinancialReport.jsp");
                dispatcher.forward(request, response);
            }

        } else if (reportType.equals("items")) {

            List<Order> orderList = orderDAO.getOrders(dateStart, dateEnd);
            if (orderList == null) {
                request.setAttribute("fail", "Sorry. Dont have earnings on selected dates.");
                RequestDispatcher dispatcher;
                dispatcher = request.getRequestDispatcher("/admin/selectFinancialReport.jsp");
                dispatcher.forward(request, response);
            } else {
                request.setAttribute("ORDER_LIST", orderList);
                for (int i = 0; i < orderList.size(); i++) {
                    totalcost += orderList.get(i).getTotal_cost();
                }
                request.setAttribute("TotalCost", "Total Earning: RM " + totalcost + ".00");
                RequestDispatcher dispatcher;
                dispatcher = request.getRequestDispatcher("/admin/FinancialReport.jsp");
                dispatcher.forward(request, response);
            }
        } else if (reportType.equals("topup")) {

            List<TopUp> topList = topupDAO.getTopUps(dateStart, dateEnd);
            if (topList == null) {
                request.setAttribute("fail", "Sorry. Dont have earnings on selected dates.");
                RequestDispatcher dispatcher;
                dispatcher = request.getRequestDispatcher("/admin/selectFinancialReport.jsp");
                dispatcher.forward(request, response);
            } else {
                request.setAttribute("TOP_LIST", topList);
                for (int i = 0; i < topList.size(); i++) {
                    totalcost += topList.get(i).getAmount();
                }
                request.setAttribute("TotalCost", "Total Earning: RM " + totalcost + ".00");
                RequestDispatcher dispatcher;
                dispatcher = request.getRequestDispatcher("/admin/FinancialReport.jsp");
                dispatcher.forward(request, response);
            }
        }

    }

    private void logout(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession(false);
        session.invalidate();
        response.sendRedirect("index.jsp");
    }

}
