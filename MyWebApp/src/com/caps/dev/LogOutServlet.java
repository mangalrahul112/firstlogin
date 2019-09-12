package com.caps.dev;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/logout")
public class LogOutServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter out = resp.getWriter();
		HttpSession session = req.getSession(false);
		if(session!=null)
		{
			session.invalidate();
			Cookie[] cookies = req.getCookies();
			if(cookies!=null)
			{
				for(Cookie c:cookies)
				{
					if(c.getName().equals("JSESSIONID"))
					{
						c.setMaxAge(0);
						resp.addCookie(c);
						resp.sendRedirect("http://localhost:8080/MyWebApp/Login.html");
					}
				}
			}
		}
		else
		{
			resp.sendRedirect("http://localhost:8080/MyWebApp/Login.html");
		}
	}
}
