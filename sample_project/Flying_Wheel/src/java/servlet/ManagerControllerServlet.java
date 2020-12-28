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
import entity.Path;
import entity.User;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

/**
 *
 * @author Khalid
 */
@WebServlet(name = "ManagerControllerServlet", urlPatterns = {"/ManagerControllerServlet"})
@MultipartConfig(
        fileSizeThreshold = 1024 * 1024 * 1, // 1 MB
        maxFileSize = 1024 * 1024 * 10, // 10 MB
        maxRequestSize = 1024 * 1024 * 15, // 15 MB
        location = "E:/Pictures"
)
public class ManagerControllerServlet extends HttpServlet {

    private BicycleDao bicycleDAO;
    private ItemDao itemDAO;
    private UserDao userDAO;
    private Bicycle bicycle;
    private Item item;
    private User user;
    private OrderDao orderDAO;
    private TopupDao topupDAO;

    @Override
    public void init() throws ServletException {
        bicycle = new Bicycle();
        topupDAO = new TopupDao();
        item = new Item();
        itemDAO = new ItemDao();
        bicycleDAO = new BicycleDao();
        user = new User();
        userDAO = new UserDao();
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
            if (session == null || session.getAttribute("manager") == null) {
                response.sendRedirect("index.jsp"); // No logged-in user found, so redirect to login page.

            } else {
                response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1.
                response.setHeader("Pragma", "no-cache"); // HTTP 1.0.
                response.setDateHeader("Expires", 0);

                switch (command) {
                    case "HOME":
                        managerPage(request, response);
                        break;
                    case "ADD-BICYCLE":
                        addBicyclePage(request, response);
                        break;
                    case "ADD-ITEM":
                        addItemPage(request, response);
                        break;
                    case "VIEW-BOOKING":
                        viewBooking(request, response);
                        break;
                    case "VIEW-BICYCLE":
                        viewBicycle(request, response);
                        break;
                    case "VIEW-ITEM":
                        viewItem(request, response);
                        break;
                    case "DELETE-ITEM":
                        deleteItem(request, response);
                        break;
                    case "DELETE-BICYCLE":
                        deleteBicycle(request, response);
                        break;
                    case "TOP-UP":
                        topup(request, response);
                        break;
                    case "VIEW-ORDER":
                        viewOrder(request, response);
                        break;
                    case "ORDER-DETAIL":
                        orderDetails(request, response);
                        break;
                    case "PREPARED-ORDER":
                        viewPreparedOrder(request, response);
                        break;
                    case "READY-ORDER":
                        viewReadyOrder(request, response);
                        break;
                    case "COMPLETED-ORDER":
                        completedOrder(request, response);
                        break;
                    case "UPDATE-ITEM":
                        updateItemPage(request, response);
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
                    managerPage(request, response);
                    break;
                case "ADD-ITEM":
                    addItem(request, response);
                    break;
                case "ADD-BICYCLE":
                    addBicycle(request, response);
                    break;
                case "TOP-UP":
                    addTopup(request, response);
                    break;
                case "UPDATE-STATUS":
                    updateStatus(request, response);
                    break;
                case "UPDATE-ITEM":
                    updateItem(request, response);
                    break;
            }

        } catch (Exception exc) {
            throw new ServletException(exc);
        }
    }

    private void managerPage(HttpServletRequest request, HttpServletResponse response) throws Exception {
        //getting the number of members
        List<User> customers = userDAO.getCustomers();
        request.setAttribute("customers", customers.size());
        //number of items
        List<Item> items = itemDAO.getItem();
        //number of bicycles
        List<Bicycle> bicycles = bicycleDAO.getBicycles();
        //number of booking
        List<Booking> bookings = new BookingDao().getAllBooking();
        
          List<Order> order_list = orderDAO.viewPreparedOrder();
           List<Order> order_list2 = orderDAO.viewNewOrder();

        request.setAttribute("bookings", bookings.size());
        request.setAttribute("bicycles", bicycles.size());
        request.setAttribute("items", items.size());
          request.setAttribute("orders", order_list.size() + order_list2.size());
        RequestDispatcher dispatcher;
        dispatcher = request.getRequestDispatcher("/manager/managerDashboard.jsp");
        dispatcher.forward(request, response);
    }

    private void deleteBicycle(HttpServletRequest request, HttpServletResponse response) throws Exception {
        //read bicycle id from data
        int delete_id = Integer.parseInt(request.getParameter("id"));

        //delete manager from db
        bicycleDAO.deleteBicycle(delete_id);

        //success and go to view page
        viewBicycle(request, response);
    }

    private void deleteItem(HttpServletRequest request, HttpServletResponse response) throws Exception {
        //read item id from data
        int item_id = Integer.parseInt(request.getParameter("itemId"));

        //delete manager from db
        itemDAO.deleteItem(item_id);
        request.setAttribute("success", "item has been successfully deleted!");
        //success and go to view page
        viewItem(request, response);

    }

    private void viewItem(HttpServletRequest request, HttpServletResponse response) throws Exception {
        //getting the items
        List<Item> items = itemDAO.getItem();

        //add bicycles to the request
        request.setAttribute("ITEM_LIST", items);

        RequestDispatcher dispatcher;
        dispatcher = request.getRequestDispatcher("/manager/viewItem.jsp");
        dispatcher.forward(request, response);
    }

    private void viewBicycle(HttpServletRequest request, HttpServletResponse response) throws Exception {
        //getting the bicycles
        List<Bicycle> bicycles = bicycleDAO.getBicycles();

        //add bicycles to the request
        request.setAttribute("BICYCLE_LIST", bicycles);

        RequestDispatcher dispatcher;
        dispatcher = request.getRequestDispatcher("/manager/viewBicycle.jsp");
        dispatcher.forward(request, response);
    }

    private void viewBooking(HttpServletRequest request, HttpServletResponse response) throws Exception {
        BookingDao bookDao = new BookingDao();
        List<Booking> bookings = bookDao.getAllBooking();

        request.setAttribute("BOOKING_LIST", bookings);

        RequestDispatcher dispatcher;
        dispatcher = request.getRequestDispatcher("/manager/viewBooking.jsp");
        dispatcher.forward(request, response);
    }

    private void addItemPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher;
        dispatcher = request.getRequestDispatcher("/manager/addItem.jsp");
        dispatcher.forward(request, response);
    }

    private void addBicyclePage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher;
        dispatcher = request.getRequestDispatcher("/manager/addBicycle.jsp");
        dispatcher.forward(request, response);
    }

    private void addItem(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException, Exception {
        String name = request.getParameter("name");
        String brand = request.getParameter("brand");
        double cost = Double.parseDouble(request.getParameter("cost"));
        String st = request.getParameter("stock");

        int stock = Integer.valueOf(st);
        Part filePart = request.getPart("image"); // Retrieves <input type="file" name="image">`
        String filePath = filePart.getSubmittedFileName();//Retrieves complete file name with path and directories
        Path p = new Path(filePath); //creates a Path object
        String fileName = p.getFilename().toString();//Retrieves file name from Path object
        InputStream fileContent = filePart.getInputStream();//converts Part data to input stream

        int len = (int) filePart.getSize();

        item.setName(name);
        item.setCost((float) cost);
        item.setBrand(brand);
        item.setImage(fileContent);
        item.setLength(len);
        item.setStock(stock);

        item = itemDAO.addItem(item);
        fileContent.close();
        request.setAttribute("success", "item has been successfully added!");
        viewItem(request, response);
    }

    private void addBicycle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, Exception {

        String name = request.getParameter("name");
        String type = request.getParameter("type");
        int rent = Integer.parseInt(request.getParameter("rent"));

        Part filePart = request.getPart("image"); // Retrieves <input type="file" name="image">`
        String filePath = filePart.getSubmittedFileName();//Retrieves complete file name with path and directories
        Path p = new Path(filePath); //creates a Path object
        String fileName = p.getFilename().toString();//Retrieves file name from Path object
        InputStream fileContent = filePart.getInputStream();//converts Part data to input stream

        int len = (int) filePart.getSize();

        bicycle.setName(name);
        bicycle.setRent_cost(rent);
        bicycle.setType(type);
        bicycle.setImage(fileContent);
        bicycle.setLength(len);

        bicycle = bicycleDAO.addBicycle(bicycle);
        fileContent.close();
        request.setAttribute("success", "bicycle has been successfully added!");
        viewBicycle(request, response);
    }

    private void topup(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        RequestDispatcher dispatcher;
        dispatcher = request.getRequestDispatcher("/manager/customerTopup.jsp");
        dispatcher.forward(request, response);

    }

    private void addTopup(HttpServletRequest request, HttpServletResponse response) throws Exception {

        RequestDispatcher dispatcher;
        String email = request.getParameter("email");
        double amount = Double.parseDouble(request.getParameter("amount"));

        user.setEmail(email);
        user.setAmount(amount);

        if (topupDAO.topUp(user)) {
            request.setAttribute("success", "Top-Up succesfull!");
            dispatcher = request.getRequestDispatcher("/manager/customerTopup.jsp");
            dispatcher.forward(request, response);
        } else {
            request.setAttribute("fail", "Email does not exist!");
            dispatcher = request.getRequestDispatcher("/manager/customerTopup.jsp");
            dispatcher.forward(request, response);
        }

    }

    private void viewOrder(HttpServletRequest request, HttpServletResponse response) throws Exception {

        List<Order> order_list = orderDAO.viewNewOrder();
        List<User> customer_list = userDAO.getCustomers();
        List<User> customer = new ArrayList<>();
        int size = 0;

        if (order_list.size() > 0) {
//            customer.add(order_list.get(0).getUser());

            //to get customer with orders
            for (int j = 0; j < customer_list.size(); j++) {
                System.out.println("break ");

                for (int i = 0; i < order_list.size(); i++) {

                    String cust = customer_list.get(j).getEmail();
                    String order_cust = order_list.get(i).getUser().getEmail();

                    if (cust.equals(order_cust)) {
                        if (customer.isEmpty()) {
                            customer.add(order_list.get(i).getUser());
                        } else {
                            for (int x = size; x < customer.size(); x++) {
                                if (!order_cust.equals(customer.get(x).getEmail())) {
                                    customer.add(order_list.get(i).getUser());
                                    size++;
                                }
                            }
                            System.out.println("customer " + customer);
                        }

                    }

                }

            }

        } else {
            request.setAttribute("fail", "No orders in here");
        }

        request.setAttribute("ORDER_LIST", order_list);
        request.setAttribute("CUSTOMERS", customer);
        RequestDispatcher dispatcher;
        dispatcher = request.getRequestDispatcher("/manager/viewOrder.jsp");
        dispatcher.forward(request, response);
    }

    private void viewPreparedOrder(HttpServletRequest request, HttpServletResponse response) throws Exception {

        List<Order> order_list = orderDAO.viewPreparedOrder();
        List<User> customer_list = userDAO.getCustomers();
        List<User> customer = new ArrayList<>();
        int size = 0;

        if (order_list.size() > 0) {
//            customer.add(order_list.get(0).getUser());

            //to get customer with orders
            for (int j = 0; j < customer_list.size(); j++) {
                System.out.println("break ");

                for (int i = 0; i < order_list.size(); i++) {

                    String cust = customer_list.get(j).getEmail();
                    String order_cust = order_list.get(i).getUser().getEmail();

                    if (cust.equals(order_cust)) {
                        if (customer.isEmpty()) {
                            customer.add(order_list.get(i).getUser());
                        } else {
                            for (int x = size; x < customer.size(); x++) {
                                if (!order_cust.equals(customer.get(x).getEmail())) {
                                    customer.add(order_list.get(i).getUser());
                                    size++;
                                }
                            }
                            System.out.println("customer " + customer);
                        }

                    }

                }

            }

        } else {
            request.setAttribute("fail", "No orders in here");
        }

        request.setAttribute("ORDER_LIST", order_list);
        request.setAttribute("CUSTOMERS", customer);
        RequestDispatcher dispatcher;
        dispatcher = request.getRequestDispatcher("/manager/viewPreparedOrder.jsp");
        dispatcher.forward(request, response);
    }

    private void orderDetails(HttpServletRequest request, HttpServletResponse response) throws Exception {

        int order_id = Integer.parseInt(request.getParameter("order_id"));

        Order orderDetails = orderDAO.getOrderDetail(order_id);

        request.setAttribute("order", orderDetails);

        RequestDispatcher dispatcher;
        dispatcher = request.getRequestDispatcher("/manager/orderDetails.jsp");
        dispatcher.forward(request, response);
    }

    private void updateStatus(HttpServletRequest request, HttpServletResponse response) throws Exception {

        String status = request.getParameter("status");
        int order_id = Integer.parseInt(request.getParameter("orderID"));

        orderDAO.updateOrderStatus(order_id, status);

        request.setAttribute("success", "Successfully updated status");

        viewOrder(request, response);
    }

    private void completedOrder(HttpServletRequest request, HttpServletResponse response) throws Exception {

        List<Order> order_list = orderDAO.completedOrderList();
        List<User> customer_list = userDAO.getCustomers();
        List<User> customer = new ArrayList<>();
        int size = 0;

        if (order_list.size() > 0) {
//            customer.add(order_list.get(0).getUser());

            //to get customer with orders
            for (int j = 0; j < customer_list.size(); j++) {
                System.out.println("break ");

                for (int i = 0; i < order_list.size(); i++) {

                    String cust = customer_list.get(j).getEmail();
                    String order_cust = order_list.get(i).getUser().getEmail();

                    if (cust.equals(order_cust)) {
                        if (customer.isEmpty()) {
                            customer.add(order_list.get(i).getUser());
                        } else {
                            for (int x = size; x < customer.size(); x++) {
                                if (!order_cust.equals(customer.get(x).getEmail())) {
                                    customer.add(order_list.get(i).getUser());
                                    size++;
                                }
                            }
                            System.out.println("customer " + customer);
                        }

                    }

                }

            }

        } else {
            request.setAttribute("fail", "No orders in here");
        }
        request.setAttribute("ORDER_LIST", order_list);
        request.setAttribute("CUSTOMERS", customer);
        RequestDispatcher dispatcher;
        dispatcher = request.getRequestDispatcher("/manager/completedOrder.jsp");
        dispatcher.forward(request, response);
    }

    private void viewReadyOrder(HttpServletRequest request, HttpServletResponse response) throws Exception {

        List<Order> order_list = orderDAO.viewReadyOrder();
        List<User> customer_list = userDAO.getCustomers();
        List<User> customer = new ArrayList<>();
        int size = 0;

        if (order_list.size() > 0) {
//            customer.add(order_list.get(0).getUser());

            //to get customer with orders
            for (int j = 0; j < customer_list.size(); j++) {
                System.out.println("break ");

                for (int i = 0; i < order_list.size(); i++) {

                    String cust = customer_list.get(j).getEmail();
                    String order_cust = order_list.get(i).getUser().getEmail();

                    if (cust.equals(order_cust)) {
                        if (customer.isEmpty()) {
                            customer.add(order_list.get(i).getUser());
                        } else {
                            for (int x = size; x < customer.size(); x++) {
                                if (!order_cust.equals(customer.get(x).getEmail())) {
                                    customer.add(order_list.get(i).getUser());
                                    size++;
                                }
                            }
                            System.out.println("customer " + customer);
                        }

                    }

                }

            }

        } else {
            request.setAttribute("fail", "No orders in here");
        }

        request.setAttribute("ORDER_LIST", order_list);
        request.setAttribute("CUSTOMERS", customer);
        RequestDispatcher dispatcher;
        dispatcher = request.getRequestDispatcher("/manager/viewReadyOrder.jsp");
        dispatcher.forward(request, response);
    }

    private void updateItem(HttpServletRequest request, HttpServletResponse response) throws Exception {
        //get the number of stock
        int stock = Integer.valueOf(request.getParameter("stock"));
        //int itemid = Integer.valueOf(request.getParameter("id"));
        HttpSession session = request.getSession();
        Item item = (Item) session.getAttribute("item");
        //update item in the dao
        itemDAO.updateStock(item, stock);
        //delete session for that item
        request.setAttribute("success", "item has been successfully updated!");

        viewItem(request, response);
    }

    private void updateItemPage(HttpServletRequest request, HttpServletResponse response) throws Exception {
        //get the item id
        int item_id = Integer.parseInt(request.getParameter("itemId"));
        //get the item
        Item item = itemDAO.findItem(item_id);
        //set the session for item
        HttpSession session = request.getSession();
        session.setAttribute("item", item);
        //display the update page
        request.setAttribute("item", item);

        RequestDispatcher ds = request.getRequestDispatcher("/manager/updateItem.jsp");
        ds.forward(request, response);
    }

    private void logout(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession(false);
        session.invalidate();
        response.sendRedirect("index.jsp");
    }
}
