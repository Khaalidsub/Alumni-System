package Middleware;


/**
 * @author SleepingLotus
 * @version 1.0
 * @created 30-Dec-2020 7:47:34 PM
 */
public class AlumniAddress {

    /**
     * @return the city
     */
    public String getCity() {
        return city;
    }

    /**
     * @param city the city to set
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * @return the country
     */
    public String getCountry() {
        return country;
    }

    /**
     * @param country the country to set
     */
    public void setCountry(String country) {
        this.country = country;
    }

    /**
     * @return the houseNo
     */
    public String getHouseNo() {
        return houseNo;
    }

    /**
     * @param houseNo the houseNo to set
     */
    public void setHouseNo(String houseNo) {
        this.houseNo = houseNo;
    }

    /**
     * @return the postalCode
     */
    public String getPostalCode() {
        return postalCode;
    }

    /**
     * @param postalCode the postalCode to set
     */
    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    /**
     * @return the region
     */
    public String getRegion() {
        return region;
    }

    /**
     * @param region the region to set
     */
    public void setRegion(String region) {
        this.region = region;
    }

    /**
     * @return the state
     */
    public String getState() {
        return state;
    }

    /**
     * @param state the state to set
     */
    public void setState(String state) {
        this.state = state;
    }

    /**
     * @return the streetName
     */
    public String getStreetName() {
        return streetName;
    }

    /**
     * @param streetName the streetName to set
     */
    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

	private String city;
	private String country;
	private String houseNo;
	private String postalCode;
	private String region;
	private String state;
	private String streetName;

	public AlumniAddress(String city, String country, String houseNo, String postalCode, String region, String state, String streetName ){
      
            this.city=city;
            this.country=country;
            this.houseNo=houseNo;
            this.postalCode=postalCode;
            this.region=region;
            this.state=state;
            this.streetName=streetName;
	}

    @Override
	public void finalize() throws Throwable {

	}
}//end AlumniAddress