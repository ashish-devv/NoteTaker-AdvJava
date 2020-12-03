package com.notetaker.app.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.notetaker.app.dao.LoginDao;
import com.notetaker.app.entity.Regbean;




@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private LoginDao loginDao;
	
	public void init() {
        loginDao = new LoginDao();
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		auth(request,response);
	}
	
	private void auth(HttpServletRequest request,HttpServletResponse response)
	{
		String username = request.getParameter("email");
        String password = request.getParameter("password");
        Regbean regbean=new Regbean();
        regbean.setUsername(username);
        regbean.setPassword(password);
        System.out.println(regbean);
        
        try
        {
        	if(LoginDao.validate(regbean))
        	{
        		
        		HttpSession httpSession =request.getSession();
        		httpSession.setAttribute("loggedin", "true");
        		httpSession.setAttribute("uname",username);
        		response.sendRedirect("home.jsp");
        		
        	}
        	else
        	{
        		
        		response.sendRedirect("signin.jsp?code=login fail");
        	}
        }
        catch (Exception e) {
			// TODO: handle exception
        	e.printStackTrace();
		}
	}

}
