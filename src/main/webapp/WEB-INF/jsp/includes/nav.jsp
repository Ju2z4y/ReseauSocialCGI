<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">

<!-- jQuery library -->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>

<!-- Popper JS -->
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>

<!-- Latest compiled JavaScript -->
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>

<link rel="stylesheet"
	href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">

<link rel="stylesheet" href="/resources/demos/style.css">

<script src="https://code.jquery.com/jquery-1.12.4.js"></script>

<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>

<script>
	$(function() {
		var availableTags = [ "Le", "Coureur", "Maxime", "Thomas", "Julien",
				"Cours", "Bonjour", "Je", "Suis", "Etre", "Avoir", "J'ai",
				"Toujours", "Eu", "Des", "Lisp", "Perl", "PHP", "Python",
				"Ruby", "Scala", "Scheme" ];
		function split(val) {
			return val.split(/ \s*/);
		}
		function extractLast(term) {
			return split(term).pop();
		}

		$("#tags")
		// don't navigate away from the field on tab when selecting an item
		.on(
				"keydown",
				function(event) {
					if (event.keyCode === $.ui.keyCode.TAB
							&& $(this).autocomplete("instance").menu.active) {
						event.preventDefault();
					}
				}).autocomplete(
				{
					minLength : 0,
					source : function(request, response) {
						// delegate back to autocomplete, but extract the last term
						response($.ui.autocomplete.filter(availableTags,
								extractLast(request.term)));
					},
					focus : function() {
						// prevent value inserted on focus
						return false;
					},
					select : function(event, ui) {
						var terms = split(this.value);
						// remove the current input
						terms.pop();
						// add the selected item
						terms.push(ui.item.value);
						// add placeholder to get the comma-and-space at the end
						terms.push("");
						this.value = terms.join(" ");
						return false;
					}
				});
	});
</script>

<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
	<!-- Brand -->
	<a class="navbar-brand" href="/index">Mon reseau social</a>

	<!-- Links -->
	<ul class="navbar-nav">
		<li class="nav-item"><a class="nav-link" href="/fildactu">Fil
				d'actualité</a></li>
	</ul>
	<ul class="navbar-nav ml-auto">
		<li class="nav-item">
			<form class="form-inline" name="recherche" method="post"
				action="/recherche">
				<div class="input-group">
					<input id="tags" type="text" name="search"
						class="form-control mr-sm-2" placeholder="Rechercher...">
					<div class="input-group-btn">
						<button type="submit" class="btn btn-info my-2 my-sm-0">
							<span class="fa fa-search"></span> Chercher
						</button>
					</div>
				</div>
			</form>
		</li>
	</ul>
	<ul class="navbar-nav ml-auto">
		<li class="nav-item"><c:choose>
				<c:when
					test="${empty sessionScope.userName || sessionScope.userName eq 'empty'}">
					<a class="nav-link">Vous n'êtes pas connecté</a>
				</c:when>							
				<c:otherwise>
					<span class="nav-link">Vous êtes connecté en tant que : <c:out
							value="${ sessionScope.userName }" />
					<a href="/deconnexion"> - Déconnexion</a></span>
				</c:otherwise>
			</c:choose></li>
	</ul>
</nav>