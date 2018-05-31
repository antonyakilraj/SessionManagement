package com.servlet.session;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final String userID = "akil";

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String user = request.getParameter("user");

		if(userID.equals(user)){
			HttpSession session = request.getSession();
			session.setAttribute("user", user);
			session.setMaxInactiveInterval(1*10);
			
			Cookie userName = new Cookie("user", user);
			userName.setMaxAge(1*10);
			response.addCookie(userName);
			
			
			response.sendRedirect("help.jsp");
			
			
		}

		else{
			PrintWriter out= response.getWriter();
			out.println("<font color=red>Either user name is wrong.</font>");
		}

	}

}