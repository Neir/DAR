<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="fr">
<head>
<jsp:include page="../import.jsp"></jsp:include>

<!-- Bootstrap -->
<link rel="stylesheet"
	href="<c:url value="/resources/bootstrap/css/bootstrap.css"/>"
	media="screen" />
<link rel="stylesheet"
	href="<c:url value="/resources/css/routes/itineraire.css"/>"
	media="screen" />
<!-- Faire fonctionner les balises structurantes de HTML5 -->
<!--[if lt IE 9]>
      		<script src="http://html5shiv.googlecode.com/svn/trunk/html5.js"></script>
    	<![endif]-->

<style type="text/css">
body {
	background-repeat: no-repeat;
	background-size: cover;
	font-family: 'PT Sans', Helvetica, Arial, sans-serif;
	font-size: 16px;
}
</style>
</head>
<body
	style="background-image:url(<c:url value="/resources/images/paris.jpg" />)">
	<jsp:include page="../header.jsp">
		<jsp:param name="page_active" value="liste_inteneraires" />
	</jsp:include>

	<div id="container" class="container">

		<div class="panel panel-default">
			<div class="panel-heading">
				<label>Rechercher un Itinéraire</label>
			</div>
			<div class="panel-body">
				<form class="form-horizontal">
					<div class="row">
						<div class="col-md-6">
							<fieldset>

								<div class="form-group">
									<label class="col-md-4 control-label" for="activityId1">Activité
										1 :</label>
									<div class="col-md-4">
										<select name="activityId1" class="form-control input-md"
											id="activityId1">
											<c:forEach items="${activities}" var="act" varStatus="status">
												<option value="${act.id}">${act.name}</option>
											</c:forEach>
										</select>
									</div>
								</div>

								<div class="form-group">
									<label class="col-md-4 control-label" for="activityId">Activité
										2 :</label>
									<div class="col-md-4">
										<select name="activityId2" class="form-control input-md"
											id="activityId2">
											<c:forEach items="${activities}" var="act" varStatus="status">
												<option value="${act.id}">${act.name}</option>
											</c:forEach>
										</select>
									</div>
								</div>
								<div class="form-group">
									<label class="col-md-4 control-label" for="activityId3">Activité
										3 :</label>
									<div class="col-md-4">
										<select name="activityId3" class="form-control input-md"
											id="activityId3">
											<c:forEach items="${activities}" var="act" varStatus="status">
												<option value="${act.id}">${act.name}</option>
											</c:forEach>
										</select>
									</div>
								</div>

							</fieldset>
						</div>
					</div>


					<div class="row">
						<div class="col-md-6">

							<table id="groups"
								class="table table-condensed table-striped table-hover responsive">
								<thead>
									<tr>
										<th class="col-md-1"></th>
										<th><label>Nom</label></th>
										<th><label>Auteur</label></th>
										<th><label>Description</label></th>
										<th class="col-md-1"></th>
									</tr>
								</thead>
								<tbody>
									<c:forEach items="${routes}" var="rt" varStatus="status">


										<tr id="route-${rt.id}">
											<td style='display: none;'><input type="hidden"
												value="${rt.id}" /></td>

											<td>${rt.name}</td>
											<td>${rt.user.name}</td>
											<td>${rt.description}</td>
											<td></td>
										</tr>
									</c:forEach>
								</tbody>
							</table>
						</div>
					</div>

				</form>
			</div>
		</div>



	</div>

</body>
</html>