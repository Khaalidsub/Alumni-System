/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webservice;

import jdbc.AnnouncementDAO;
import Middleware.Announcement;

import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import com.google.gson.Gson;
import java.io.IOException;
import javax.servlet.ServletException;
import jdbc.AlumniDAO;

/**
 *
 * @author haisw
 */
@Path("Announcement")
public class announcementAPI { 
    @GET
    @Path("/getdata") // this path is used to identify method
    @Produces(MediaType.APPLICATION_JSON)
    public String getDatainJSON() throws ServletException, IOException{
        AnnouncementDAO a = AnnouncementDAO.getInstance();
        Gson gson = new Gson();

        return gson.toJson(a.getAnnouncementList());
    }
}