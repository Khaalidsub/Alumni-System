/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import Dao.UserDao;

import entity.User;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
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
@WebServlet(name = "LoginControllerServlet", urlPatterns = {"/LoginControllerServlet"})
public class LoginControllerServlet extends HttpServlet {

    private UserDao loginDAO;
    private User user;

    @Override
    public void init() throws ServletException {
        user = new User();
        loginDAO = new UserDao();

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession(true);

        try {
            String command = request.getParameter("command");
            // if the command is missing, then default to login
            if (command == null) {
                command = "LOGINPAGE";
            }

            switch (command) {
                case "LOGINPAGE":
                    loginPage(request, response);
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
            if (command == null) {
                command = "LOGINPAGE";
            }

            switch (command) {
                case "LOGIN":
                    findUser(request, response);
                    break;

            }

        } catch (Exception exc) {
            throw new ServletException(exc);
        }
    }

    private void findUser(HttpServletRequest request, HttpServletResponse response) throws Exception {
        RequestDispatcher dispatcher;

        String email = request.getParameter("email");
        String password = request.getParameter("password");

        user.setEmail(email);
        user.setPassword(password);

        System.out.println(user);
        //check what type of user it is 
        if (loginDAO.findUser(user)) {

            if (user.getRole().equals("customer")) {
                //get customer object
                //create session
                HttpSession session = request.getSession(true);
                session.setAttribute("customer", user.getEmail());
                session.setAttribute("customerid", user.getUserid());
                //later change the link to the customerservlet

                response.sendRedirect("CustomerControllerServlet");

            } else if (user.getRole().equals("admin")) {
                //get customer object
                //create session
                HttpSession session = request.getSession(true);
                session.setAttribute("admin", user.getEmail());

                //later change the link to the 
                response.sendRedirect("AdminControllerServlet");

            } else if (user.getRole().equals("manager")) {
                //later change the link to the 
                //create session
                if (user.getStatus().equals("disabled")) {
                    request.setAttribute("fail", "your account has been disabled!");
                    dispatcher = request.getRequestDispatcher("login-user.jsp");
                    dispatcher.forward(request, response);
                }
                HttpSession session = request.getSession(true);
                session.setAttribute("manager", user.getEmail());
                request.setAttribute("command", "HOME");
                response.sendRedirect("ManagerControllerServlet");
            }
        } else {

            //user does not exist, redirect to login with error message
            request.setAttribute("fail", "email/password are/is incorrect ");
            dispatcher = request.getRequestDispatcher("login-user.jsp");
            dispatcher.forward(request, response);
        }
    }

    private void loginPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        RequestDispatcher dispatcher;
        dispatcher = request.getRequestDispatcher("/login-user.jsp");
        dispatcher.forward(request, response);
    }
}
