package com.caps.dev;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.caps.dto.Student;

@WebServlet("/home")
public class HomeServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		HttpSession session = req.getSession(false);
		if(session!=null)
		{
			PrintWriter out = resp.getWriter();
			Student s = (Student)session.getAttribute("stu");
			out.println("<table border="+1+" cellspacing=+"+1+" cellpading="+1+"><tr><td><h2>RegNo</h2></td><td><h2>FName</h2></td><td><h2>LName</h2></td></tr>"
					+"<tr><td><h3>"+s.getRegNo()+"</h3></td><td><h3>"+s.getFName()+"</h3></td><td><h3>"+s.getLName()
					+"</h3></td>"+"</tr></table>");
			out.println("<a href='http://localhost:8080/MyWebApp/logout'><input type='submit' value='LogOut'/></a>");
			
		}
		else
		{
			resp.sendRedirect("http://localhost:8080/MyWebApp/Login.html");
		}
	}
}
