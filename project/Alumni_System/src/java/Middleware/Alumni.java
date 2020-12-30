package Middleware;


/**
 * @author SleepingLotus
 * @version 1.0
 * @created 30-Dec-2020 7:47:33 PM
 */
public class Alumni {

	private AlumniAddress address;
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