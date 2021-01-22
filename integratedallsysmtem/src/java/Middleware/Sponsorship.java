package Middleware;

/**
 * @author Afiq
 * @version 1.0
 * @created 30-Dec-2020 11:16:44 PM
 */
public class Sponsorship {

    /**
     * @return the sponsorName
     */
    private String sponsorName;
    

	public Sponsorship(){
	}

	public void finalize() throws Throwable {

	}

	public String displaySponsor(){
            return sponsorName;
	}

	public void requestSponsorshipData(String sponsorName){
            this.sponsorName=sponsorName;
	}



}