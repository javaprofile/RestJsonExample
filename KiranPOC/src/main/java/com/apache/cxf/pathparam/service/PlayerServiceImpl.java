package com.apache.cxf.pathparam.service;
 
import javax.ws.rs.core.Response;
 
import org.apache.cxf.jaxrs.JAXRSServerFactoryBean;
import org.codehaus.jackson.jaxrs.JacksonJsonProvider;
import org.codehaus.jackson.map.util.JSONPObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
 
@Service("playerService")
public class PlayerServiceImpl implements IPlayerService {
 
	@Autowired
	private Person person;
    /**
     * this method takes one argument from PathParam and returns a Response
     */
    @Override
    public Response welcomePlayer(String playerName) {
 
        String greetMessage = "Welcome " + playerName + " to Lords - the home of cricket";
        return Response.status(200).entity(greetMessage).build();
    }
 
  
    @Bean
    public org.codehaus.jackson.jaxrs.JacksonJsonProvider jsonProvider(){
    JacksonJsonProvider jsonProvider = new JacksonJsonProvider();
    return jsonProvider;
    }
    /**
     * this method takes three argument from PathParam and returns a Response
     */
    @Override
    public Response getPlayerInfo(PlayerType p) {
 
       // String playerInfo = "[name=" + playerName +  ", age=" + age + ", matches=" + matches + "]";
       // System.out.println(playerInfo);
    	System.out.println("Response from first service : ");
       // p.setName("Graham Thorpe");
       // p.setAge(45);
       // p.setMatches(100);
        
        return Response.status(200).entity(p).build();
       //  return getplayer;
       //return Response.status(200).entity(playerInfo).build();
    }
}