package Business;

import Middleware.Event;
import jdbc.PaymentDAO;
import Middleware.Payment;
import Middleware.SignIn;
import jdbc.EventDAO;
import static com.sun.corba.se.spi.presentation.rmi.StubAdapter.request;
import java.util.ArrayList;
import java.util.List;
import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.System.out;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.Part;
import javax.servlet.*;
import java.io.InputStream;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpSession;



/**
 * @author murli
 * @version 1.0
 * @created 01-Jan-2021 12:33:53 AM
 */

@MultipartConfig(maxFileSize = 16177215)    // upload file's size up to 16MB
@WebServlet(name = "PaymentController", urlPatterns = {"/PaymentController"})
public class PaymentController extends HttpServlet {
    PaymentDAO pD = new PaymentDAO();
    EventController callPaidEvent = new EventController();
    /**
     *
     * @param request
     * @param response
     * @throws javax.servlet.ServletException
     */
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException{

        String command = request.getParameter("action");

        try {
            switch (command) {
                case "fundingList":
                    getFundingList(request,response);
                    break;
//                case "select":
//                    getEvent(event,request,response);
//                    break;
//                case "join":
//                    confirmAlumni(event, request, response);
//                    break;
//                case "joinedEvent":
//                    getJoinedEvents(request,response);
//                    break;
                default:
                    break;
            }
                

        } catch (Exception exc) {
            throw new ServletException(exc);
        }
    }
    

    
//    public void getUnpaidList(HttpServletRequest request, HttpServletResponse response){
//            int alumniID = 2;
//            
//            List<Event> unpaidEvents = null;  
//            try {
//                pD = new PaymentDAO();
//                unpaidEvents = pD.getUnpaidEventList(alumniID, request, response);
//
//                RequestDispatcher dispatcher;
//                dispatcher = request.getRequestDispatcher("/makePaymentPage.jsp");
//                request.setAttribute("UNPAID_EVENT_LIST", unpaidEvents );
//                dispatcher.forward(request, response);
//
//            } catch (IOException | ServletException ex) {
//                Logger.getLogger(EventController.class.getName()).log(Level.SEVERE, null, ex);
//            }
//    }
    
    @Override
     protected void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException
        {
//            // gets values of text fields
//            String firstName = request.getParameter("firstName");
//            String lastName = request.getParameter("lastName");
            int eventID = Integer.parseInt(request.getParameter("eventID"));
            InputStream inputStream = null; // input stream of the upload file
            String name = request.getParameter("name");
            String category = request.getParameter("category");
            double amount = Double.parseDouble(request.getParameter("amount"));

            // obtains the upload file part in this multipart request
            Part filePart = request.getPart("photo");
            
            if (filePart != null) {
                // prints out some information for debugging
                System.out.println(filePart.getName());
                System.out.println(filePart.getSize());
                System.out.println(filePart.getContentType());

                // obtains input stream of the upload file
                inputStream = filePart.getInputStream();
            }
            
            uploadReceipt(inputStream, eventID, name, category, amount, request, response);

            
//                // sets the message in request scope
//                request.setAttribute("Message", message);
//
//                // forwards to the message page
//                getServletContext().getRequestDispatcher("/Message.jsp").forward(request, response);
            
        }
     
    //after paid 
     
    public void uploadReceipt(InputStream fileName, int eventID, String name, String cat, double amount, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        HttpSession session = request.getSession();
       
        SignIn signIn = null;
        signIn = (SignIn) session.getAttribute("signIn");
        pD = new PaymentDAO();
        int alumniID = 2;
        String message = pD.insertReceipt(fileName, eventID, signIn.getEmail(), name, cat , amount, request, response);  
        
        session.setAttribute("message", message);
        
        callPaidEvent.getJoinedEvent(eventID, request, response);
         
    }
    
    public void getFundingList(HttpServletRequest request, HttpServletResponse response){
        HttpSession session = request.getSession();
       
        SignIn signIn = null;
        signIn = (SignIn) session.getAttribute("signIn");
        List<Payment> fundingList;
        
        try {
            PaymentDAO pd =  PaymentDAO.getInstance();
            fundingList = pd.getFundingList(signIn.getEmail(), request, response);
            RequestDispatcher dispatcher;
            dispatcher = request.getRequestDispatcher("/fundingHistory.jsp");
            request.setAttribute("FUNDING_LIST",fundingList);
            dispatcher.forward(request, response);
                
        } catch (IOException | ServletException ex) {
            Logger.getLogger(EventController.class.getName()).log(Level.SEVERE, null, ex);
        } 
        
    }    

    
    public PaymentController(){

	}

	public void finalize() throws Throwable {

	}

	/**
	 * 
	 * @param paymentID
	 */
	public void approve(int paymentID){

	}

	/**
	 * 
	 * @param paymentID
	 */
	public void delete(int paymentID){

	}

	/**
	 * 
	 * @param paymentID
	 */
	public void deleteReceipt(int paymentID){

	}

	/**
	 * 
	 * @param paymentID
	 */
	public void getPayment(int paymentID){

	}

	/**
	 * 
	 * @param eventID
	 */
	public void getPaymentList(int eventID){

	}

	/**
	 * 
	 * @param paymentID
	 */
	public void reject(int paymentID){

	}

	/**
	 * 
	 * @param paymentID
	 * @param paidDate
	 * @param alumiName
	 * @param paidTime
	 * @param alumniID
	 */
	public void respondPaymentDetails(int paymentID, String paidDate, String alumiName, String paidTime, String alumniID){

	}

	/**
	 * 
	 * @param fileName
	 * @param alumniID
	 * @param eventID
	 * @param eventName
	 * @param alumniName
	 * @param fee
	 */
	public void uploadReceipt(String fileName, String alumniID, int eventID, String eventName, String alumniName, float fee){

	}

	/**
	 * 
	 * @param fileName
	 */
	public void verifyReceiptFormat(String fileName){

	}

	/**
	 * 
	 * @param paymentID
	 */
	public void viewReceipt(String paymentID){

	}

}