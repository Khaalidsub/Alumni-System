

/**
 * @author Asus
 * @version 1.0
 * @created 30-Dec-2020 10:06:30 PM
 */

package Middleware;

public class Admin implements User {

    
    
         private String AdminEmail;
	private String AdminID;
	private String AdminName;
        private String AdminPassword;
	private AdminUI m_AdminUI;
        
        
    /**
     * @return the AdminEmail
     */
    public String getAdminEmail() {
        return AdminEmail;
    }

    /**
     * @param AdminEmail the AdminEmail to set
     */
    public void setAdminEmail(String AdminEmail) {
        this.AdminEmail = AdminEmail;
    }

    /**
     * @return the AdminID
     */
    public String getAdminID() {
        return AdminID;
    }

    /**
     * @param AdminID the AdminID to set
     */
    public void setAdminID(String AdminID) {
        this.AdminID = AdminID;
    }

    /**
     * @return the AdminName
     */
    public String getAdminName() {
        return AdminName;
    }

    /**
     * @param AdminName the AdminName to set
     */
    public void setAdminName(String AdminName) {
        this.AdminName = AdminName;
    }

    /**
     * @return the AdminPassword
     */
    public String getAdminPassword() {
        return AdminPassword;
    }

    /**
     * @param AdminPassword the AdminPassword to set
     */
    public void setAdminPassword(String AdminPassword) {
        this.AdminPassword = AdminPassword;
    }
    
      

   
	

	public Admin(){

	}



	public void dispError(){

	}

	public void displayError(){

	}

	public void displaySignInScreen(){

	}

	public void displaySuccess(){

	}

	public void displayUser(){

	}

	public void dispPic(){

	}

	public void dispSuccess(){

	}

	public void dispUserAcc(){
                   System.out.println("Admin");

	}

	public AdminUI getAdminUI(){
		return m_AdminUI;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setAdminUI(AdminUI newVal){
		m_AdminUI = newVal;
	}

	public void showSuggestions(){

	}
        
         @Override
     public String dispWelcome(){
        
        String destPage =   "adminHome.jsp"; 
        return destPage;
        
    }

}