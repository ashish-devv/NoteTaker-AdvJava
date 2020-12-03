<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page import="com.notetaker.app.config.*"%>
<!doctype html>
<html lang="en">
  <head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">

    <title>NoteTaker-Home</title>
    <style>
    .card:hover {
  box-shadow: 5px 10px 20px 0 rgba(13, 69, 160, 0.678);
}
    </style>
  </head>
  <body>
  <%
  String check=(String)session.getAttribute("loggedin");
  if(check.equals(null))
  {
	  response.sendRedirect("login.jsp");
  }
  %>
  <nav class="navbar navbar-expand-lg navbar-dark bg-primary">
  <a class="navbar-brand" href="home.jsp">📝 NoteTaker</a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>
  <div class="collapse navbar-collapse" id="navbarNav">
    <ul class="navbar-nav mx-4 mr-auto">
      <li class="nav-item active">
        <a class="nav-link" href="home.jsp"> 🏠 Home</a>
      </li>
      <li class="nav-item active">
        <a class="btn btn-success" href="addnote.jsp">Take Note ➕</a>
      </li>
      <li class="nav-item active">
        <a class="btn btn-success mx-1" href="search.jsp">Search 🔎</a>
      </li>
      <li class="nav-item active">
        <a class="btn btn-danger" href="Logout.jsp">Logout 🚪</a>
      </li>
    </ul>
  </div>
</nav>
<div class="jumbotron jumbotron-fluid bg-primary text-white">
	  <div class="container">
	    <h1 class="display-4">Hey! Ashish Kumar. 👦</h1>
	    <p class="lead">All your Notes are Present here .</p>
	  </div>
	</div>
	<div class="container">
	<h1>Notes 📝</h1>
	<form action="search.jsp" method="get" class="form-inline">
	<input type="text" class="form-control border border-dark" placeholder="Search for your Post 🔥" name="keyword" required>
	<button type="submit" class="btn btn-success">🔎</button>
	</form>
	<hr>
	<div class="container">
	<% 
	try{
	  Connection connection=JDBCConnection.getConnection();
	  Statement statement= connection.createStatement();
	  String sql="select * from note where uname='"+session.getAttribute("uname")+"' order by nid DESC";
	  ResultSet rs= statement.executeQuery(sql);
	  while (rs.next())
	  {
	  %>
	  <div class="card text-center border border-dark mb-2">
	  <div class="card-body border border-dark">
	  
	  <h4 class="card-title">
	  <%=rs.getString("note_heading") %><br>
	  <small class="btn btn-sm btn-success">Created On:<%=rs.getString("creation_date") %></small>
	  </h4>
	  <div class="card-text border border-dark">
	  <%=rs.getString("note_content") %>
	  </div>
	  <a class="btn btn-danger" href="Delete?nid=<%=rs.getString("nid") %>" onclick="return confirm('Are you sure to Delete🚮?')">Delete🚮</a>
	  <a class="btn btn-warning" href="Edit?nid=<%=rs.getString("nid") %>" onclick="return confirm('Are you sure to Edit✏?')">Edit✏</a>
	  </div>
	  </div>
	  <%
	}
	connection.close();
	  }
	  catch(Exception e)
	  {
		  e.printStackTrace();
	  }
	  
	  %>
	</div>
	<hr>
	<h3 class="text-center">No More Notes.<a href="addnote.jsp">Add from Here.</a></h3>
	</div>
  
  
   

    <!-- Optional JavaScript; choose one of the two! -->

    <!-- Option 1: jQuery and Bootstrap Bundle (includes Popper) -->
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ho+j7jyWK8fNQe+A12Hb8AhRq26LrZ/JpcUGGOn+Y7RsweNrtN/tE3MoK7ZeZDyx" crossorigin="anonymous"></script>

  </body>
</html>