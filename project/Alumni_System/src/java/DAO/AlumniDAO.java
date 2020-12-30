/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Middleware.Alumni;
import Middleware.AlumniAddress;

/**
 *
 * @author SleepingLotus
 */
public class AlumniDAO {
    
    private String url = "jdbc:mysql://localhost:3306/flying_wheel?useTimezone=true&serverTimezone=UTC";
    private String use = "root";
    private String password = "";
    
   private Alumni alumni;
    
    
    	public void addAlumni(Alumni createdAlumni){

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
	 * @param alumni
	 */
	public void updateAlumniDetails(Alumni alumni){

	}
    
}
