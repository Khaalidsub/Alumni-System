package Middleware;

import business.RegisterController;



/**
 * @author Asus
 * @version 1.0
 * @created 30-Dec-2020 10:06:46 PM
 */
public class Register {

	private String Address;
	private String CurrentJob;
	private String Email;
	private int GraduateYear;
	private String Name;
	private String password;
	private String Phone;
	private String PreviousJob;
	private double SalaryCurrent;
	private double SalaryPrevious;
        private String Status;
	private RegisterController m_RegisterController;
	private SignIn m_SignIn;

         //SETTER AND GETTER
         public String getAddress() {
        return Address;
        }
         public void setAddress(String Address) {
        this.Address = Address;
        }
         
        public String getCurrentJob() {
            return CurrentJob;
        }

        public void setCurrentJob(String CurrentJob) {
            this.CurrentJob = CurrentJob;
        }

        public String getEmail() {
            return Email;
        }

        public void setEmail(String Email) {
            this.Email = Email;
        }

        public int getGraduateYear() {
            return GraduateYear;
        }

        public void setGraduateYear(int GraduateYear) {
            this.GraduateYear = GraduateYear;
        }

        public String getName() {
            return Name;
        }

        public void setName(String Name) {
            this.Name = Name;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public String getPhone() {
            return Phone;
        }

        public void setPhone(String Phone) {
            this.Phone = Phone;
        }

        public String getPreviousJob() {
            return PreviousJob;
        }

        public void setPreviousJob(String PreviousJob) {
            this.PreviousJob = PreviousJob;
        }

        public double getSalaryCurrent() {
            return SalaryCurrent;
        }

        public void setSalaryCurrent(double SalaryCurrent) {
            this.SalaryCurrent = SalaryCurrent;
        }

        public double getSalaryPrevious() {
            return SalaryPrevious;
        }

        public void setSalaryPrevious(double SalaryPrevious) {
            this.SalaryPrevious = SalaryPrevious;
        }

        public String getStatus() {
            return Status;
        }

        public void setStatus(String Status) {
            this.Status = Status;
        }

         
         ///////////////////////////////////////////////////
        
	public Register(){

	}

	public void finalize() throws Throwable {

	}

	public void accessRegisterScreen(){

	}

	public void displayExample(){

	}

	public void errorMessage(){

	}

	public RegisterController getRegisterController(){
		return m_RegisterController;
	}

	public SignIn getSignIn(){
		return m_SignIn;
	}

	/**
	 * 
	 * @param Address
	 * @param CurrentJob
	 * @param Email
	 * @param GraduateYear
	 * @param Name
	 * @param password
	 * @param PreviousJob
	 * @param SalaryCurrent
	 * @param SalaryPrevious
	 * @param Status
	 * @param Phone
	 */
	public void RegisterNew(String Address, String CurrentJob, String Email, int GraduateYear, String Name, String password, String PreviousJob, double SalaryCurrent, double SalaryPrevious, String Status, String Phone){

	}

	/**
	 * 
	 * @param newVal
	 */
	public void setRegisterController(RegisterController newVal){
		m_RegisterController = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setSignIn(SignIn newVal){
		m_SignIn = newVal;
	}

	public void successMessage(){

	}

}