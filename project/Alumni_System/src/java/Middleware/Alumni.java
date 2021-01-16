package Middleware;


/**
 * @author SleepingLotus
 * @version 1.0
 * @created 30-Dec-2020 7:47:33 PM
 */
public class Alumni {

    /**
     * @return the alumniAddressID
     */
    public String getAlumniAddressID() {
        return alumniAddressID;
    }
    
    /**
     * @param alumniAddressID the alumniAddressID to set
     */
   public void setAlumniAddressID(String alumniAddressID) {
        this.alumniAddressID = alumniAddressID;
    }
      
	private String alumniCitizenship;
	private String alumniEmail;
	private String alumniMatric;
	private String alumniName;
	private String batchName;
	private String courseName;
        private String alumniAddressID;
         private AlumniAddress alumniAddress;
	private EduLevel eduLevel;
	private Gender gender;
	private int graduateYear;
	private int phoneNo;
	private alumniTitle title;
	

    public Alumni(String alumniCitizenship, String alumniEmail, String alumniName, String batchName, EduLevel eduLevel, Gender gender, int graduateYear,alumniTitle title) {
    
        this.alumniCitizenship = alumniCitizenship;
        this.alumniEmail = alumniEmail;
   
        this.alumniName = alumniName;
        this.batchName = batchName;
   
        this.eduLevel = eduLevel;
        this.gender = gender;
        this.graduateYear = graduateYear;

        this.title = title;
   
    }

    public Alumni(String alumniCitizenship, String alumniEmail, String alumniMatric, String alumniName, String batchName, String courseName, EduLevel eduLevel, Gender gender, int graduateYear, int phoneNo, alumniTitle title, String alumniAddressID) {
        this.alumniCitizenship = alumniCitizenship;
        this.alumniEmail = alumniEmail;
        this.alumniMatric = alumniMatric;
        this.alumniName = alumniName;
        this.batchName = batchName;
        this.courseName = courseName;
        this.eduLevel = eduLevel;
        this.gender = gender;
        this.graduateYear = graduateYear;
        this.phoneNo = phoneNo;
        this.title = title;
        this.alumniAddressID = alumniAddressID;
    }
    
    
        
        

	public Alumni(){

	}
        
        public void setAlumniAddress(AlumniAddress alumniAddress){
            this.alumniAddress = alumniAddress;
        }
        public AlumniAddress getAlumniAddress(){
            return alumniAddress;
        }

    /**
     * @return the alumniCitizenship
     */
    public String getAlumniCitizenship() {
        return alumniCitizenship;
    }

    /**
     * @param alumniCitizenship the alumniCitizenship to set
     */
    public void setAlumniCitizenship(String alumniCitizenship) {
        this.alumniCitizenship = alumniCitizenship;
    }

    /**
     * @return the alumniEmail
     */
    public String getAlumniEmail() {
        return alumniEmail;
    }

    /**
     * @param alumniEmail the alumniEmail to set
     */
    public void setAlumniEmail(String alumniEmail) {
        this.alumniEmail = alumniEmail;
    }

    /**
     * @return the alumniMatric
     */
    public String getAlumniMatric() {
        return alumniMatric;
    }

    /**
     * @param alumniMatric the alumniMatric to set
     */
    public void setAlumniMatric(String alumniMatric) {
        this.alumniMatric = alumniMatric;
    }

    /**
     * @return the alumniName
     */
    public String getAlumniName() {
        return alumniName;
    }

    /**
     * @param alumniName the alumniName to set
     */
    public void setAlumniName(String alumniName) {
        this.alumniName = alumniName;
    }

    /**
     * @return the batchName
     */
    public String getBatchName() {
        return batchName;
    }

    /**
     * @param batchName the batchName to set
     */
    public void setBatchName(String batchName) {
        this.batchName = batchName;
    }

    /**
     * @return the courseName
     */
    public String getCourseName() {
        return courseName;
    }

    /**
     * @param courseName the courseName to set
     */
    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    /**
     * @return the eduLevel
     */
    public EduLevel getEduLevel() {
        return eduLevel;
    }

    /**
     * @param eduLevel the eduLevel to set
     */
    public void setEduLevel(EduLevel eduLevel) {
        this.eduLevel = eduLevel;
    }

    /**
     * @return the gender
     */
    public Gender getGender() {
        return gender;
    }

    /**
     * @param gender the gender to set
     */
    public void setGender(Gender gender) {
        this.gender = gender;
    }

    /**
     * @return the graduateYear
     */
    public int getGraduateYear() {
        return graduateYear;
    }

    /**
     * @param graduateYear the graduateYear to set
     */
    public void setGraduateYear(int graduateYear) {
        this.graduateYear = graduateYear;
    }

    /**
     * @return the phoneNo
     */
    public int getPhoneNo() {
        return phoneNo;
    }

    /**
     * @param phoneNo the phoneNo to set
     */
    public void setPhoneNo(int phoneNo) {
        this.phoneNo = phoneNo;
    }

    /**
     * @return the title
     */
    public alumniTitle getTitle() {
        return title;
    }

    /**
     * @param title the title to set
     */
    public void setTitle(alumniTitle title) {
        this.title = title;
    }

    
        
        

}//end Alumni