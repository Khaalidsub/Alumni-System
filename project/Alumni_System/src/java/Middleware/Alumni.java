package Middleware;


/**
 * @author SleepingLotus
 * @version 1.0
 * @created 30-Dec-2020 7:47:33 PM
 */
public class Alumni {


	private String alumniCitizenship;
	private String alumniEmail;
	private String alumniMatric;
	private String alumniName;
	private String batchName;
	private String courseName;
	private EduLevel eduLevel;
	private Gender gender;
	private int graduateYear;
	private int phoneNo;
	private alumniTitle title;
	private AlumniAddress m_AlumniAddress;

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

    public Alumni(String alumniCitizenship, String alumniEmail, String alumniMatric, String alumniName, String batchName, String courseName, EduLevel eduLevel, Gender gender, int graduateYear, int phoneNo, alumniTitle title, AlumniAddress m_AlumniAddress) {
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
        this.m_AlumniAddress = m_AlumniAddress;
    }
    
    
        
        

	public Alumni(){

	}

	public void finalize() throws Throwable {

	}
	/**
	 * 
	 * @param createdAlumni
	 */
	public void addAlumni(Alumni createdAlumni){

	}

	public AlumniAddress getAlumniAddress(){
		return m_AlumniAddress;
	}

	/**
	 * 
	 * @param alumniEmail
	 */
	public Alumni getAlumniInfo(String alumniEmail){
		return null;
	}

	public Alumni[] getAlumniList(){
		return null;
	}

	/**
	 * 
	 * @param alumniEmail
	 */
	public Alumni getDetailedAlumniInfo(String alumniEmail){
		return null;
	}

	/**
	 * 
	 * @param alumniName
	 * @param query
	 */
	public Alumni[] getFilteredAlumni(String alumniName, String query){
		return null;
	}

	/**
	 * 
	 * @param alumniName
	 */
	public Alumni[] getSearchedAlumni(String alumniName){
		return null;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setAlumniAddress(AlumniAddress newVal){
		m_AlumniAddress = newVal;
	}

	/**
	 * 
	 * @param alumni
	 */
	public void updateAlumniDetails(Alumni alumni){

	}
}//end Alumni