

/**
 * @author Asus
 * @version 1.0
 * @created 30-Dec-2020 10:06:54 PM
 */

package Middleware;

public interface User {

	//private Register m_Register;

	 void dispError();

	 void displaySignInScreen();

	 void dispPic();

	 void dispSuccess();

	 void dispUserAcc();
         
         String dispWelcome();

	 void showSuggestions();
}