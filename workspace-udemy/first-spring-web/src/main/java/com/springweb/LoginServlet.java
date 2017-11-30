package com.springweb;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/old_login.do")
public class LoginServlet extends HttpServlet {

	private static final long serialVersionUID = -2632493064191028838L;
	
	private UserValidationService userValidationService = new UserValidationService();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setAttribute("name", req.getParameter("name"));
		req.setAttribute("password", req.getParameter("password"));
		req.getRequestDispatcher("/pages/login.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		if (userValidationService.isUserValie(req.getParameter("name"), req.getParameter("password"))) {
			req.setAttribute("name", req.getParameter("name"));
			req.getRequestDispatcher("/pages/loginOk.jsp").forward(req, resp);
		} else {
			req.setAttribute("errorMessage", "Name or Password wrong! Please try again.");
			req.getRequestDispatcher("/pages/login.jsp").forward(req, resp);
		}
	}

}
