<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!doctype html>
<html lang="en">
  <head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
	<script src="https://cdn.tiny.cloud/1/timhjb17fsk2uhk8snehz1m5tnzajc67d3b2iflysdrta6lp/tinymce/5/tinymce.min.js" referrerpolicy="origin"></script>
    <title>NoteTaker-Home</title>
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
        <a class="btn btn-danger" href="Logout.jsp">Logout 🚪</a>
      </li>
    </ul>
  </div>
</nav>
<section>
	<div class="container">
	<form action="Edit" method="POST">
	<div class="container border border-dark">
	<h1 class="text-center display-3"> Edit Note 📝</h1>
	
	<div class="container">
	<input type="hidden" value="<%=request.getAttribute("nid") %>" name="nid"/>
	<div class="row">
	<div class="col">
	<label for="heading">Note Heading</label>
    <input type="text" class="form-control" id="heading" aria-describedby="headHelp" placeholder="Note Heading" value="<%=request.getAttribute("note_heading") %>" name="note_heading" required>
    <small id="headHelp" class="form-text text-muted">Give Your Heading.</small>
	</div>
	</div>
	<div class="row">
	<div class="col">
	<label for="content">Content</label>
	
    <textarea class="form-control" id="content"  placeholder="Your Note Here...." value="" name="note_content" ></textarea>
	</div>
	</div>
	<div class="row m-2">
	<div class="col">
	<button type="submit" class="btn btn-danger">+Add</button>
	</div>
	</div>
	</div>
	</div>
	</form>
	</div>
  
   

    <!-- Optional JavaScript; choose one of the two! -->
    <script>
    <% String a=(String)request.getAttribute("note_content"); %>
	var a= '<%=a%>';
    tinymce.init({
      selector: '#content',
      setup: function (editor) {
          editor.on('init', function (e) {
            editor.setContent(a);
          });
        },
      plugins: 'a11ychecker advcode casechange formatpainter linkchecker autolink lists checklist media mediaembed pageembed permanentpen powerpaste table advtable tinycomments tinymcespellchecker',
      toolbar: 'table',
      toolbar_mode: 'floating',
      tinycomments_mode: 'embedded',
      tinycomments_author: 'Author name',
    });
  </script>

    <!-- Option 1: jQuery and Bootstrap Bundle (includes Popper) -->
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ho+j7jyWK8fNQe+A12Hb8AhRq26LrZ/JpcUGGOn+Y7RsweNrtN/tE3MoK7ZeZDyx" crossorigin="anonymous"></script>

  </body>
</html>