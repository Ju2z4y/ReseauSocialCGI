<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
  <!-- Brand -->
  <a class="navbar-brand" href="/index">Mon reseau social</a>

  <!-- Links -->
  <ul class="navbar-nav">
    <li class="nav-item">
      <a class="nav-link" href="/fildactu">Fil d'actualité</a>
    </li>
    <li class="nav-item">
      <a class="nav-link" href="#">Contacts</a>
    </li>

    <!-- Dropdown -->
    <li class="nav-item dropdown">
      <a class="nav-link dropdown-toggle" href="#" id="navbardrop" data-toggle="dropdown">
        Dropdown link
      </a>
      <div class="dropdown-menu">
        <a class="dropdown-item" href="#">Link 1</a>
        <a class="dropdown-item" href="#">Link 2</a>
        <a class="dropdown-item" href="#">Link 3</a>
      </div>
    </li>
   </ul>
   <ul class="navbar-nav ml-auto">
    <li class="nav-item">
		<c:choose>
		   <c:when test="${empty sessionScope.prenom} || ${empty sessionScope.nom}">
		   	<a class="nav-link">Vous n'êtes pas connecté</a>
		   </c:when>
		   <c:otherwise>
		   	<a class="nav-link">Vous êtes connecté en tant que : 
		   	<c:out value="${ sessionScope.prenom }" />
		   	<c:out value="${ sessionScope.nom }" /></a>
		   </c:otherwise>
		</c:choose>
    </li>
  </ul>
</nav>