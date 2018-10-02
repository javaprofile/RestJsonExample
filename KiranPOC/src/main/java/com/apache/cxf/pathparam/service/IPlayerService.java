package com.apache.cxf.pathparam.service;
 

import java.util.HashMap;
import java.util.Map;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.ModelAttribute;

 
@Path("/player")
public interface IPlayerService {
	

	
	
    // http://localhost:8080/ApacheCXF-PathParam/services/player/welcome/Dravid
    @GET
    @Path("/welcome/{name}")
    public Response welcomePlayer(@PathParam("name") String playerName);
 
    // http://localhost:8080/ApacheCXF-PathParam/services/player/playerinfo/Sachin/41/200
   /* @GET
    @Path("playerinfo/{name}/{age}/{matches}")
    public Response getPlayerInfo(
            @PathParam("name") String playerName,
            @PathParam("age") int age,
            @PathParam("matches") int matches);
    */
    
    
    @POST
    @Path("playerinfojson/playertype")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
     public Response getPlayerInfo(
           PlayerType p );
 
}
