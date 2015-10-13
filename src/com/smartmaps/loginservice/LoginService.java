package com.smartmaps.loginservice;

import java.sql.SQLException;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

import javax.ws.rs.Produces;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
//import javax.ws.rs.core.UriInfo;
@Path("user/loginservice")
public class LoginService {
	
	Response resp=null;
	String x=null;
	
	
	@Path("/log")
	@POST	
	@Consumes("application/x-www-form-urlencoded")
	@Produces(MediaType.APPLICATION_JSON)
	public Response userService(
			//@Context HttpHeaders hh,  //HttpHeader For Reading Cookies From Request
			//@Context UriInfo uriInfo,    
			@FormParam("username") String username,
			@FormParam("password") String password
			) {

		//String retString="";
		Login_Validate loginValidate=new Login_Validate();
		
		try {
			x = loginValidate.loginUser(username,password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        resp=Response.ok(x).build();
		return resp;
     
     
	
	}
}

