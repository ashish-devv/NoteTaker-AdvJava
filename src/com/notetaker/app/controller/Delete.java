package com.notetaker.app.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.notetaker.app.dao.Notedao;


@WebServlet("/Delete")
public class Delete extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			HttpSession httpSession=request.getSession();
		String nid=request.getParameter("nid");
		String uname=(String) httpSession.getAttribute("uname");
		boolean status=Notedao.Checknotes(uname, nid);
		if(status)
		{
			System.out.println("post deleted");
			int r=Notedao.deletenote(nid);
			if(r!=1)
			{
				throw new Exception("Error Occured");
			}
		}
		else
		{
			System.out.println("Error Occured");
			response.sendRedirect("signin.jsp");
		}
		}
		catch (Exception e) {
			e.printStackTrace();
			response.sendRedirect("signin.jsp");
		}
		response.sendRedirect("home.jsp");
	}

}
