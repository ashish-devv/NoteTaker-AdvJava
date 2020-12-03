package com.notetaker.app.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.notetaker.app.dao.Notedao;
import com.notetaker.app.entity.Note;


@WebServlet("/Edit")
public class Edit extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String nid=request.getParameter("nid");
			HttpSession httpSession=request.getSession();
			String uname=(String) httpSession.getAttribute("uname");
			boolean status=Notedao.Checknotes(uname, nid);
			if(status)
			{
				RequestDispatcher rs=request.getRequestDispatcher("Edit.jsp");
				Note note=Notedao.retrivenote(nid);
				request.setAttribute("nid", nid);
				request.setAttribute("note_heading", note.getNote_heading());
				request.setAttribute("note_content", note.getNote_content());
				rs.forward(request,response);
				
			}
			else
			{
				response.sendRedirect("Logout.jsp");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			response.sendRedirect("Logout.jsp");
		}
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			HttpSession httpSession=request.getSession();
			String uname=(String) httpSession.getAttribute("uname");
			String nid=request.getParameter("nid");
			boolean status=Notedao.Checknotes(uname, nid);
			if(status)
			{
				Note n =new Note();
				String note_heading=request.getParameter("note_heading");
				String note_content=request.getParameter("note_content");
				n.setNote_heading(note_heading);
				n.setNote_content(note_content);
				n.setNid(Integer.parseInt(nid));
				n.setUname(uname);
				System.out.println(n);
				int action = Notedao.edit(n);
				if(action==1)
				{
					response.sendRedirect("home.jsp?code=Post edited Successfully!");
				}
				else
				{
					response.sendRedirect("home.jsp?code=Unable To edit the post");
				}
			}
			else
			{
				response.sendRedirect("logout.jsp");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			response.sendRedirect("logout.jsp");
		}

	}

}
