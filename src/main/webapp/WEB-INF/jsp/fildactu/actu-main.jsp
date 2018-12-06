<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
<link rel="stylesheet" href="<c:out value="/resources/static/style.css"></c:out>">

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
	  <button type="button" class="btn btn-outline-secondary"><a href="#1">Ajouter un topic</a></button>
	</div>
	
	<c:forEach items="${topics}" var="topic">
	<div class="container mt-3">
	  <h2><c:out value="${topic.titre}"></c:out><small><i> - par <c:out value="${topic.auteur}"></c:out></i></small></h2>
	 <c:forEach items="${topic.messages}" var="message">
	  <div class="media border p-3">
	    <img src="<c:url value="/resources/images/photo.PNG"/>" alt="John Doe" class="mr-3 mt-3 rounded-circle" style="width:60px;">
	    <div class="media-body">
	      <h4><c:out value="${message.message}"></c:out></h4>
	      <p><small><c:out value="${message.auteur}"></c:out> - <i><fmt:formatDate value="${message.date}" pattern="dd-MM-yyyy HH:mm" /></i></small></p>
	      <c:forEach items="${message.commentaires}" var="commentaire">
	      <div class="media commentaire">
	        <img src="<c:url value="/resources/images/photo.PNG"/>" alt="Jane Doe" class="mr-3 mt-3 rounded-circle" style="width:45px;">
	        <div class="media-body">
	          <h6><c:out value="${commentaire.message}"></c:out> </h6>
	          <p><small><c:out value="${commentaire.auteur}"></c:out> - <i><fmt:formatDate value="${commentaire.date}" pattern="dd-MM-yyyy HH:mm" /></i></small></p>
	        </div>
	      </div>  
	      </c:forEach>
	      <form name="ajoutCommentaire" method="post" action="/ajoutCommentaire">
	      	<label>Ajouter un commentaire : </label>
	      	<input type="text" name="newCommentaire" class="form-control form-control-sm">
	      	<input type="hidden" name="idTopic" value="<c:out value="${ topic.id }"/>">
	      	<input type="hidden" name="idMessage" value="<c:out value="${ message.id }"/>">
	      </form>
	    </div>
	  </div>
	  </c:forEach>
	  <div class="border message" style="padding:10px">
	  	  <form name="ajoutMessage" method="post" action="/ajoutMessage">
	      	<label><h3>Ajouter un message : </h3></label>
	      	<input type="text" name="newMessage" class="form-control form-control-sm">
	      	<input type="hidden" name="idTopic" value="<c:out value="${ topic.id }"/>">
	      </form>	
	  </div>
	</div>
	</c:forEach>
	
	<form name="ajoutTopic" method="post" action="/ajoutTopic">
	<div id="1" class="container mt-3">
	<h2>Ajouter un Topic</h2>
	  <input type="text" name="newTopic" class="form-control form-control-sm" placeholder="Titre du topic">
	  <div class="media border p-3">
	    <img src="<c:url value="/resources/images/photo.PNG"/>" alt="John Doe" class="mr-3 mt-3 rounded-circle" style="width:60px;">
	    <input type="text" name="newTopicMessage" class="form-control form-control-sm" placeholder="Message du topic">
	    <input type="Submit" name=submit value="Ajouter">
	  </div>
	</div>
	</form>
	
</body>
</html>