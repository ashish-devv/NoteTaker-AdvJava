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

    <title>NoteTaker-login</title>
  </head>
  <body>
  <div class="container-fluid border border-dark">
  <div class="row">
    <div class="col-lg m-0 p-0 border border-dark bg-primary">
    <div class="jumbotron jumbotron-fluid bg-primary text-white">
	  <div class="container">
	    <h1 class="display-4">Login ✅</h1>
	    <br>
	     <p class="lead">Login Here with Your Credientials.🔑</p>
	     <hr>
	  </div>
	</div>
      
    </div>
    <div class="col-lg border border-dark ">
      <form action="Login" method="POST">
	  <div class="form-group">
	    <label for="exampleInputEmail1">Email address</label>
	    <input type="email" class="form-control border border-dark" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="a@b.c" name="email" required title="Please Enter Your Email">
	  </div>
	  <div class="form-group">
	    <label for="password">Password</label>
	    <input type="password" class="form-control border border-dark" id="password" placeholder="Password" name="password" required title="Please Enter Your Password">
	  </div>
	  
	  <button type="submit" class="btn btn-success">Login🔑</button>
	  <hr>
	  <%
    if(request.getParameter("code")!=null)
    {
    	String message=request.getParameter("code");
    	out.println("<span style='color:red'>");
    	out.println(message);
    	out.println("</span>");
    	out.println("<br>");
    }
    %>
	  
	  <a href="./signup.jsp">Not a Member ? Sign up Here.</a>
</form>
    </div>
  </div>
</div>
  
   

    <!-- Optional JavaScript; choose one of the two! -->

    <!-- Option 1: jQuery and Bootstrap Bundle (includes Popper) -->
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ho+j7jyWK8fNQe+A12Hb8AhRq26LrZ/JpcUGGOn+Y7RsweNrtN/tE3MoK7ZeZDyx" crossorigin="anonymous"></script>

  </body>
</html>