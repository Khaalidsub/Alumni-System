/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webservice;
import jdbc.AlumniDAO;
import Middleware.Alumni;
import com.google.gson.Gson;
import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author hp
 */
@Path("alumni")
public class mobileAPI {
    @GET
    @Path("/getdata") // this path is used to identify method
    @Produces(MediaType.APPLICATION_JSON)
    public String getDatainJSON(){
         AlumniDAO a = AlumniDAO.getInstance();
          Gson gson = new Gson();
         
        return gson.toJson(a.getAlumniList());
       
    }
}
