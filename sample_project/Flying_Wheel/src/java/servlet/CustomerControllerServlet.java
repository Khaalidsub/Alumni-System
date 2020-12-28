/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import Dao.BicycleDao;
import Dao.BookingDao;
import Dao.CartDao;
import Dao.ItemDao;
import Dao.OrderDao;
import Dao.TopupDao;
import Dao.UserDao;
import entity.Bicycle;
import entity.Booking;
import entity.Cart;
import entity.Item;
import entity.Order;
import entity.TopUp;
import entity.User;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;
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
@WebServlet(name = "CustomerControllerServlet", urlPatterns = {"/CustomerControllerServlet"})
public class CustomerControllerServlet extends HttpServlet {

    private UserDao userDAO;
    private User user;
    private TopupDao topupDAO;
    private ItemDao itemDAO;
    private OrderDao orderDAO;
    private Order order;
    private Item item;
    private CartDao cartDAO;

    @Override
    public void init() throws ServletException {
        user = new User();
        userDAO = new UserDao();
        itemDAO = new ItemDao();
        orderDAO = new OrderDao();
        order = new Order();
        item = new Item();
        topupDAO = new TopupDao();
        cartDAO = new CartDao();

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        //response.sendRedirect("/customer/customer-register.jsp");
        String command = request.getParameter("command");
        HttpSession session = request.getSession(true);
        System.out.println("customerid" + session.getAttribute("customerid"));
        if (session == null || session.getAttribute("customer") == null || session.getAttribute("customerid") == null) {
            if (command == null) {

                response.sendRedirect("index.jsp"); // No logged-in user found, so redirect to login page.
            } else {
                registerPage(request, response);
            }

        } else {
            response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1.
            response.setHeader("Pragma", "no-cache"); // HTTP 1.0.
            response.setDateHeader("Expires", 0);

            try {

                // if the command is missing, then default to login
                if (command == null) {
                    command = "HOME";
                }

                switch (command) {
                    case "REGISTER":
                        registerPage(request, response);
                        break;
                    case "HOME":
                        customerPage(request, response);
                        break;
                    case "LOGOUT":
                        logout(request, response);
                        break;
                    case "ADD-BOOKING":
                        addBookingPage(request, response);
                        break;
                    case "VIEW-BOOKING":
                        viewBookingPage(request, response);
                        break;
                    case "VIEW-TRANSACTION":
                        viewTransaction(request, response);
                        break;
                    case "VIEW-SHOP":
                        viewItem(request, response);
                        break;
                    case "ADD-CART-ITEM":
                        addToCartPage(request, response);
                        break;
                    case "VIEW-CART":
                        viewCart(request, response);
                        break;
                    case "DELETE-CART-ITEM":
                        deleteCartItem(request, response);
                        break;
                    case "VIEW-ORDER":
                        viewOrder(request, response);
                        break;
                    case "VIEW-ORDER-DETAIL":
                        viewOrderDetail(request, response);
                        break;
                    case "COMPLETED-ORDER":
                        completedOrder(request, response);
                        break;
                    case "TOP-UP":
                        topUp(request, response);
                        break;

                }

            } catch (Exception exc) {
                throw new ServletException(exc);
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            String command = request.getParameter("command");
            // if the command is missing, then default to login
            HttpSession session = request.getSession(true);
            if (session == null || session.getAttribute("customer") == null) {
                if (!command.equals("ADD-CUSTOMER")) {
                    System.out.println(command);

                    response.sendRedirect("index.jsp"); // No logged-in user found, so redirect to login page.
                } else {
                    addMember(request, response);
                }

            } else {
                response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1.
                response.setHeader("Pragma", "no-cache"); // HTTP 1.0.
                response.setDateHeader("Expires", 0);
                switch (command) {
                    case "ADD-CUSTOMER":
                        addMember(request, response);
                        break;
                    case "CHECK-BOOKING":
                        checkBooking(request, response);
                        break;
                    case "ADD-BOOKING":
                        addBooking(request, response);
                        break;

                    case "EDIT-PROFILE":
                        editProfile(request, response);
                        break;
                    case "TOP-UP":
                        addTopup(request, response);
                        break;
                    case "ADD-TO-CART":
                        addToCart(request, response);
                        break;
                    case "CHECK-OUT":
                        checkOut(request, response);
                        break;
                    case "ADD-ORDER":
                        addOrder(request, response);
                        break;

                }
            }
        } catch (Exception exc) {
            throw new ServletException(exc);
        }
    }

    private void addMember(HttpServletRequest request, HttpServletResponse response) throws Exception {
        PrintWriter out = response.getWriter();

        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String IC = request.getParameter("IC");
        String password = request.getParameter("password");
        String phone = request.getParameter("phone");
        Date DOB = Date.valueOf(request.getParameter("DOB"));

        user.setUsername(name);
        user.setEmail(email);
        user.setIC(IC);
        user.setDOB(DOB);
        user.setPassword(password);
        user.setPhone(phone);
        user.setRole("customer");
        user.setAmount(0.00);

        RequestDispatcher dispatcher;
        if (userDAO.addUser(user)) {
            //success and go to login page
            //user = userDAO.firstAmount(user);

            request.setAttribute("success", user.getUsername() + " your account has been created successfully!");
            dispatcher = request.getRequestDispatcher("/customer/customer-register.jsp");
            dispatcher.forward(request, response);
        } else {
            //not success go back to register page
            request.setAttribute("fail", "email already exists");
            dispatcher = request.getRequestDispatcher("/customer/customer-register.jsp");
            dispatcher.forward(request, response);
        }

    }

    private void addBooking(HttpServletRequest request, HttpServletResponse response) throws Exception {
        HttpSession session = request.getSession(true);
        System.out.println("list" + session.getAttribute("bicycleList"));
        //getting the booking and the bicycle lists
        List<Integer> list = (List<Integer>) session.getAttribute("bicycleList");
        Booking book = (Booking) session.getAttribute("booking");
        int id = (int) session.getAttribute("customerid");
        //removing the sessions
        session.removeAttribute("booking");
        session.removeAttribute("bicycleList");

        BookingDao booking = new BookingDao();

        //get the total cost
        //find wether user has that certain amount
        int cost = (int) session.getAttribute("cost");
        System.out.println("cost : " + cost);
        String email = (String) session.getAttribute("customer");
        System.out.println("email " + email);
        if (userDAO.amountSufficient(cost, email)) {
            if (book == null) {
                request.setAttribute("fail", "Error during booking ,please try again later!");

            } else {
                booking.addBooking(list, book, id);
                request.setAttribute("success", id);
            }

        } else {
            request.setAttribute("fail", "Insufficient Balance !");
        }

        viewBookingPage(request, response);
    }

    private void addBookingPage(HttpServletRequest request, HttpServletResponse response) throws Exception {

        RequestDispatcher dispatcher;
        dispatcher = request.getRequestDispatcher("/customer/bookingForm.jsp");
        dispatcher.forward(request, response);
    }

    private void registerPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        RequestDispatcher dispatcher;
        request.setAttribute("success", "email/password are/is incorrect ");
        dispatcher = request.getRequestDispatcher("/customer/customer-register.jsp");
        dispatcher.forward(request, response);
    }

    private void customerPage(HttpServletRequest request, HttpServletResponse response) throws Exception {
        //getting the value of the user
        HttpSession session = request.getSession(false);
        String email = (String) session.getAttribute("customer");

        user = userDAO.getUser(email);
        String balance = userDAO.getBalance(email);
        request.setAttribute("user", user);
        request.setAttribute("balance", balance);

        RequestDispatcher dispatcher;
        dispatcher = request.getRequestDispatcher("/customer/customerDashboard.jsp");
        dispatcher.forward(request, response);
    }

    private void checkBooking(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String date_start = request.getParameter("date-start");
        String date_end = request.getParameter("date-end");
        String time_start = request.getParameter("time-start");
        String time_end = request.getParameter("time-end");

        if (Date.valueOf(date_start).getTime() > Date.valueOf(date_end).getTime()) {
            request.setAttribute("fail", "Wrong date format! date from cannot ever be greater than date-to");
            addBookingPage(request, response);
        }
        String number = request.getParameter("number");
        String type = request.getParameter("type");
        List<Integer> value
                = userDAO.checkBooking(date_start, date_end, time_start, time_end, number, type);
        //  for (int i = 0; i < value.size(); i++) {
        System.out.println("check value " + value.toString());
        int size = value.size() - 1;

        System.out.println("check available " + value.get(size));
        //if bicycles not available : 
        if (value.get(size) == 0) {
            request.setAttribute("fail", "The amount of bicycles you asked for are not available at that exact date !");
            addBookingPage(request, response);
        } else {
            HttpSession session = request.getSession(true);

            Booking book = new Booking();
            book.setDate_start(Date.valueOf(date_start));
            book.setDate_end(Date.valueOf(date_end));
            book.setTime_start(time_start);
            book.setTime_end(time_end);

            request.setAttribute("available", "available now");

            value.remove(size);

            session.setAttribute("bicycleList", value);

            BicycleDao cycle = new BicycleDao();
            int cost
                    = cycle.getCost(value);

            request.setAttribute("cost", cost);
            session.setAttribute("cost", cost);
            book.setCost(cost);
            session.setAttribute("booking", book);
            addBookingPage(request, response);
        }

    }

    private void viewBookingPage(HttpServletRequest request, HttpServletResponse response) throws Exception {
        BookingDao bookDao = new BookingDao();
        HttpSession session = request.getSession(true);
        int id = (int) session.getAttribute("customerid");
        List<Booking> bookings = bookDao.getUserBooking(id);

        request.setAttribute("BOOKING_LIST", bookings);

        RequestDispatcher dispatcher;
        dispatcher = request.getRequestDispatcher("/customer/viewBooking.jsp");
        dispatcher.forward(request, response);
    }

    private void viewItem(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, Exception {

        //getting the items
        List<Item> items = itemDAO.getItem();

        //add items to the request
        request.setAttribute("ITEM_LIST", items);

        RequestDispatcher dispatcher;
        dispatcher = request.getRequestDispatcher("/customer/viewItem.jsp");
        dispatcher.forward(request, response);
    }

    private void editProfile(HttpServletRequest request, HttpServletResponse response) throws Exception {
        HttpSession session = request.getSession(true);
        int id = (int) session.getAttribute("customerid");

        User user = new User();
        user.setUserid(id);
        System.out.println(request.getParameter("email"));
        user.setEmail(request.getParameter("email"));
        user.setPhone(request.getParameter("phone"));
        userDAO.updateProfile(user);

        session.setAttribute("customer", user.getEmail());
        request.setAttribute("success", "Profile has been changed!");
        customerPage(request, response);
    }

    private void topUp(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        RequestDispatcher dispatcher;
        dispatcher = request.getRequestDispatcher("/customer/topup.jsp");
        dispatcher.forward(request, response);

    }

    private void addTopup(HttpServletRequest request, HttpServletResponse response) throws Exception {

        RequestDispatcher dispatcher;
        HttpSession session = request.getSession(true);
        String email = (String) session.getAttribute("customer");
        double amount = Double.parseDouble(request.getParameter("amount"));

        user.setEmail(email);
        user.setAmount(amount);

        if (topupDAO.topUp(user)) {
            request.setAttribute("success", "Top-Up succesfull!");
            dispatcher = request.getRequestDispatcher("/customer/topup.jsp");
            dispatcher.forward(request, response);
        } else {
            request.setAttribute("fail", "Topup failed.");
            dispatcher = request.getRequestDispatcher("/customer/topup.jsp");
            dispatcher.forward(request, response);
        }

    }

    private void viewTransaction(HttpServletRequest request, HttpServletResponse response) throws Exception {
        //get customerid from session
        HttpSession session = request.getSession(true);
        int id =  (int) session.getAttribute("customerid");
        //get all top up  transaction from topupdao
        List<TopUp> list = topupDAO.getUserTopUps(id);
        //set the list
        request.setAttribute("TOP_LIST", list);
        //dispatch the transaction page
        RequestDispatcher dispatcher;
        dispatcher = request.getRequestDispatcher("/customer/viewTransactions.jsp");
        dispatcher.forward(request, response);
    }

    private void addToCartPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, Exception {

        //get item id from 
        int item_id = Integer.parseInt(request.getParameter("itemId"));

        //get item and price 
        List<Item> findItem = new ArrayList<>();
        item = itemDAO.findItem(item_id);
        findItem.add(item);

        //add items to the request
        request.setAttribute("ITEM", findItem);

        RequestDispatcher dispatcher;
        dispatcher = request.getRequestDispatcher("/customer/addToCartForm.jsp");
        dispatcher.forward(request, response);
    }

    private void addOrder(HttpServletRequest request, HttpServletResponse response) throws Exception {

        //get order information
        String[] quantity_list = request.getParameterValues("quantity[]");
        String[] item_id_list = request.getParameterValues("itemID[]");
        String[] total_list = request.getParameterValues("total[]");
        float grandtotal = Float.parseFloat(request.getParameter("grandtotal"));

        //get current user info
        HttpSession session = request.getSession(false);
        int userid = (int) session.getAttribute("customerid");
        user = userDAO.getUserupdate(Integer.toString(userid));
        System.out.println("order user" + user);

        //store order info into list
        List<Order> order_items = new ArrayList<>();
        Order addOrder;

        for (int i = 0; i < quantity_list.length; i++) {
            int quantity = Integer.parseInt(quantity_list[i]);
            int itemID = Integer.parseInt(item_id_list[i]);
            float total = Float.parseFloat(total_list[i]);
            item = itemDAO.findItem(itemID);
            addOrder = new Order(user, item, quantity, total);
            order_items.add(addOrder);
        }

        //if balance is alright
        if (userDAO.amountSufficient(grandtotal, user.getEmail())) {
            //add Order
            cartDAO.deleteAll(userid);
            request.setAttribute("success", "Your item is successfully ordered!");

            for (int i = 0; i < order_items.size(); i++) {
                orderDAO.addOrder(order_items.get(i));
            }

        } else {
            //else give an error
            request.setAttribute("fail", "Your balance is insufficient!!");
        }

        viewOrder(request, response);
    }

    private void viewCart(HttpServletRequest request, HttpServletResponse response) throws Exception {

        HttpSession session = request.getSession(false);
        int userID = (int) session.getAttribute("customerid");

        List<Cart> cart = cartDAO.cartList(userID);

        request.setAttribute("cart", cart);
        RequestDispatcher dispatcher;
        dispatcher = request.getRequestDispatcher("/customer/viewCart.jsp");
        dispatcher.forward(request, response);
    }

    private void deleteCartItem(HttpServletRequest request, HttpServletResponse response) throws Exception {
        int cartID = Integer.parseInt(request.getParameter("cartID"));
        cartDAO.deleteCartItem(cartID);
        viewCart(request, response);
    }

    private void addToCart(HttpServletRequest request, HttpServletResponse response) throws Exception {
        //get user_id
        HttpSession session = request.getSession(false);
        int userid = (int) session.getAttribute("customerid");

        int quantity = Integer.parseInt(request.getParameter("quantity"));
        int stock = Integer.parseInt(request.getParameter("stock"));
        int item_id = Integer.parseInt(request.getParameter("item"));

        if (quantity > stock) {
            //get item
            List<Item> findItem = new ArrayList<>();
            item = itemDAO.findItem(item_id);
            findItem.add(item);

            //add order to the request
            request.setAttribute("ITEM", findItem);
            request.setAttribute("fail", "Quantity entered should not be more than the available stock");
            RequestDispatcher dispatcher;
            dispatcher = request.getRequestDispatcher("/customer/addToCartForm.jsp");
            dispatcher.include(request, response);

        } else {
            //add into cart table in database
            cartDAO.addToCart(userid, item_id, quantity);

            //successful message
            request.setAttribute("success", "Your item is successfully added!");

            //go back to item list
            viewItem(request, response);
        }

    }

    private void checkOut(HttpServletRequest request, HttpServletResponse response) throws Exception {

        //get values from previous page        
        String[] items = request.getParameterValues("item_id[]");
        String[] item_costs = request.getParameterValues("cost[]");
        String[] item_quantity = request.getParameterValues("quantity[]");

        //to get cart item information
        HttpSession session = request.getSession(false);
        int userID = (int) session.getAttribute("customerid");
        List<Cart> cart = cartDAO.cartList(userID);

        //calculate item number & grand_total
        int total_item = 0;
        float grand_total = 0;
        float item_total_price = 0;

        for (int i = 0; i < cart.size(); i++) {
            int quantity = Integer.parseInt(item_quantity[i]);
            int stock = cart.get(i).getItem().getStock();

            if (quantity > stock) {
                //display error message
                request.setAttribute("fail", "Quantity entered should not be more than the available stock");
                viewCart(request, response);

            } else {
                item_total_price = (Float.parseFloat(item_costs[i])) * (Float.parseFloat(item_quantity[i]));
                grand_total += item_total_price;
                total_item += Integer.parseInt(item_quantity[i]);

                //set new quantity into cart list
                cart.get(i).setQuantity(Integer.parseInt(item_quantity[i]));
                cart.get(i).setTotal(item_total_price);
            }
        }

        //pass grandtotal and total item ordered to next page
        request.setAttribute("total_item", total_item);
        request.setAttribute("grand_total", grand_total);
        request.setAttribute("cart_item", cart);
        RequestDispatcher dispatcher;
        dispatcher = request.getRequestDispatcher("/customer/check_out_page.jsp");
        dispatcher.forward(request, response);

    }

    private void viewOrder(HttpServletRequest request, HttpServletResponse response) throws Exception {
        //get user_id
        HttpSession session = request.getSession(false);
        int userid = (int) session.getAttribute("customerid");

        //get order List
        List<Order> orders = orderDAO.customerOrder(userid);

        //pass to view order page
        request.setAttribute("orders", orders);
        RequestDispatcher dispatcher;
        dispatcher = request.getRequestDispatcher("/customer/viewOrder.jsp");
        dispatcher.forward(request, response);

    }

    private void viewOrderDetail(HttpServletRequest request, HttpServletResponse response) throws Exception {

        //get order ID
        int orderID = Integer.parseInt(request.getParameter("orderID"));

        Order order_details = orderDAO.getOrderDetail(orderID);

        request.setAttribute("order", order_details);
        RequestDispatcher dispatcher;
        dispatcher = request.getRequestDispatcher("/customer/orderDetails.jsp");
        dispatcher.forward(request, response);
    }

    private void completedOrder(HttpServletRequest request, HttpServletResponse response) throws Exception {

        //get user_id
        HttpSession session = request.getSession(false);
        int userid = (int) session.getAttribute("customerid");

        //get order List
        List<Order> orders = orderDAO.customerCompletedOrder(userid);

        //pass to view order page
        request.setAttribute("orders", orders);
        RequestDispatcher dispatcher;
        dispatcher = request.getRequestDispatcher("/customer/viewCompletedOrder.jsp");
        dispatcher.forward(request, response);
    }

    private void logout(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession(false);
        session.invalidate();
        response.sendRedirect("index.jsp");
    }

}
