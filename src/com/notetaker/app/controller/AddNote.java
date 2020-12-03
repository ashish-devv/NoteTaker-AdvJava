package com.notetaker.app.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.notetaker.app.dao.Notedao;
import com.notetaker.app.dao.RegisterDao;
import com.notetaker.app.entity.Note;
import com.sun.net.httpserver.HttpExchange;


@WebServlet("/AddNote")
public class AddNote extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			HttpSession httpSession=request.getSession();
			String uname=(String)httpSession.getAttribute("uname");
			if(!(uname.equals(null)))
			{
				Note n=new Note();
				n.setUname(uname);
				n.setNote_heading(request.getParameter("note_heading"));
				n.setNote_content(request.getParameter("note_content"));
				int status=Notedao.add(n);
				if(status==1)
				{
					response.sendRedirect("addnote.jsp?code=Note Added Successfully!");
				}
				else
				{
					response.sendRedirect("addnote.jsp?code=Try Again ! After login");
				}
			}
			else
			{
				response.sendRedirect("signin.jsp");
			}
		} catch (Exception e) {
			e.printStackTrace();
			response.sendRedirect("signin.jsp");
		}
		
	}

}
