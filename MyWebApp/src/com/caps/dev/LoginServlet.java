package com.caps.dev;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.caps.dao.JDBCImpl;
import com.caps.dao.StudentsInfoDAO;
import com.caps.dto.Student;

@WebServlet("/loginser")
public class LoginServlet extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String regno = req.getParameter("regno");
		String pass = req.getParameter("passwd");
		PrintWriter out = resp.getWriter();
		StudentsInfoDAO db = new JDBCImpl();
		Student s = db.login(Integer.parseInt(regno), pass);
		if(s.getRegNo()!=0)
		{
			out.print("<h1>Login Successful</h1>");
			HttpSession session = req.getSession();
			session.setAttribute("stu",s);
			
			String url ="http://localhost:8080/MyWebApp/home";
			resp.sendRedirect(url);
		}
		else
		{
			out.print("<h1>Login Failed</h1>");
		}
		
	}
}
