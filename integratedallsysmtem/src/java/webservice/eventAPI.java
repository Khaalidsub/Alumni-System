/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webservice;

import jdbc.EventDAO;
import Middleware.Event;

import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import com.google.gson.Gson;
import jdbc.AlumniDAO;

/**
 *
 * @author haisw
 */
@Path("Event")
public class eventAPI { 
    @GET
    @Path("/getdata") // this path is used to identify method
    @Produces(MediaType.APPLICATION_JSON)
    public String getDatainJSON(){
        EventDAO e = EventDAO.getInstance();
        Gson gson = new Gson();

        return gson.toJson(e.getAllRecords());
    }
}

