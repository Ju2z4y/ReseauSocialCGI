<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">

<!-- jQuery library -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>

<!-- Popper JS -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>

<!-- Latest compiled JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>

</head>
<body>
<c:import url="../includes/nav.jsp"></c:import>
	<div class="jumbotron">
	  <h1>Fil d'actualité</h1>  
	</div>
	<div class="container mt-3">
	  <h2>Titre de la discussion</h2>
	  <p>Quel est le but de cette discussion : </p><br>
	  <div class="media border p-3">
	    <img src="<c:url value="/resources/images/photo.PNG"/>" alt="John Doe" class="mr-3 mt-3 rounded-circle" style="width:60px;">
	    <div class="media-body">
	      <h4>Auteur du message <small><i>Date de la publication du message</i></small></h4>
	      <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.</p>
	      <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.</p>
	      <div class="media p-3">
	        <img src="<c:url value="/resources/images/photo.PNG"/>" alt="Jane Doe" class="mr-3 mt-3 rounded-circle" style="width:45px;">
	        <div class="media-body">
	          <h4>Auteur du message <small><i>Date de la publication du message</i></small></h4>
	          <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.</p>
	          <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.</p>
	        </div>
	      </div>  
	    </div>
	  </div>
	  
	</div>
</body>
</html>