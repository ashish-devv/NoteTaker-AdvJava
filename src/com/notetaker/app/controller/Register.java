package com.notetaker.app.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.notetaker.app.dao.RegisterDao;
import com.notetaker.app.entity.Regbean;


@WebServlet("/Register")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String name=(String) request.getParameter("name");
			String email=(String) request.getParameter("email");
			String pwd=(String) request.getParameter("password");
			if(name.equals("")||email.equals("")||pwd.equals(""))
			{
				throw new Exception("any of the Fields can't be empty");
			}
			Regbean regbean=new Regbean();
			regbean.setName(name);
			regbean.setUsername(email);
			regbean.setPassword(pwd);
			int result=RegisterDao.register(regbean);
			if(result==1)
			{
				response.sendRedirect("signup.jsp?code=Successful Registeration !");
			}
			else
			{
				response.sendRedirect("signup.jsp?code=Some Error Occured!");
			}
		} catch (Exception e) {
			e.printStackTrace();
			response.sendRedirect("signup.jsp?code=failed !");
			
		}
	}

}
