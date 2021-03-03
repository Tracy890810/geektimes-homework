package org.geektimes.projects.user.web.controller;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

import org.geektimes.web.mvc.controller.PageController;

/**
 * 输出 “Hello,World” Controller
 */
@Path("/hello")
public class HelloWorldController implements PageController {

    @GET
    @POST
    @Path("/world") // /hello/world -> HelloWorldController
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Throwable {
    	try{
    		Context ctx = new InitialContext();
        	DataSource dataSource = (DataSource) ctx.lookup("java:comp/env/jdbc/UserPlatformDB");
        	
        	System.out.println(dataSource == null);
    	}catch(Exception e) {
    		e.printStackTrace();
    	}
    	
        return "index.jsp";
    }
}
