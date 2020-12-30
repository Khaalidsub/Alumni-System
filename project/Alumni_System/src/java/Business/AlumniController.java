/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import Middleware.Alumni;
import Middleware.AlumniAddress;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Middleware.Alumni;
import Middleware.AlumniAddress;
import Middleware.EduLevel;
import Middleware.alumniTitle;

/**
 *
 * @author SleepingLotus
 */
@WebServlet(name = "AlumniController", urlPatterns = {"/AlumniController"})
public class AlumniController extends HttpServlet {

private Alumni m_Alumni;

	public AlumniController(){

	}

	public void finalize() throws Throwable {

	}
	public Alumni getAlumni(){
		return m_Alumni;
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
	public Alumni[] getFilteredAlumniList(String alumniName, String query){
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
	public void setAlumni(Alumni newVal){
		m_Alumni = newVal;
	}



	/**
	 * 
	 * @param address
	 * @param alumniEmail
	 * @param phoneNo
	 * @param eduLevel
	 * @param graduateYear
	 * @param courseName
	 */
	public void updateAlumniInfo(AlumniAddress address, String alumniEmail, int phoneNo, EduLevel eduLevel, int graduateYear, String courseName){

	}

	/**
	 * 
	 * @param address
	 * @param eduLevel
	 * @param phoneNumber
	 * @param title
	 * @param courseName
	 * @param graudateYear
	 */
	public boolean validateFields(AlumniAddress address, EduLevel eduLevel, int phoneNumber, alumniTitle title, String courseName, int graudateYear){
		return false;
	}


}
