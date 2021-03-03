package org.geektimes.projects.user.web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Path;

import org.geektimes.projects.user.domain.User;
import org.geektimes.projects.user.service.UserService;
import org.geektimes.web.mvc.controller.PageController;

@Path("/")
public class UserController implements PageController {

	@Path("/register")
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		String method = request.getMethod();
		if ("GET".equalsIgnoreCase(method)) {
		
			return "register.jsp";
		
		} else {
			User user = new User();
			user.setName(request.getParameter("name"));
			user.setPhoneNumber(request.getParameter("phone"));
			user.setEmail(request.getParameter("email"));
			user.setPassword(request.getParameter("password"));

			UserService userService = (UserService)request.getServletContext().getAttribute("userService");
			boolean result = userService.register(user);
			
			return "result.jsp?result=" + result;

		}

	}

}
