<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html lang="fr">
<head>
<jsp:include page="../import.jsp"></jsp:include>
<script
	src="http://maps.googleapis.com/maps/api/js?sensor=false&extension=.js&output=embed"></script>
<script src="<c:url value="/resources/js/activites/activite.js"/>"></script>
<script src="//ajax.googleapis.com/ajax/libs/jquery/2.0.2/jquery.min.js"></script>


<meta http-equiv="content-type" content="text/html; charset=utf-8">
<meta name="generator" content="Bootply" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1">

<!-- Bootstrap -->
<link rel="stylesheet"
	href="<c:url value="/resources/bootstrap/css/bootstrap.css"/>"
	media="screen" />
<link rel="stylesheet"
	href="<c:url value="/resources/css/activites/activite.css"/>"
	media="screen" />
<!-- Faire fonctionner les balises structurantes de HTML5 -->
<!--[if lt IE 9]>
      		<script src="http://html5shiv.googlecode.com/svn/trunk/html5.js"></script>
    	<![endif]-->
<title>${activity.name}</title>
</head>
<body
	style="background-image:url(<c:url value="/resources/images/paris.jpg" />)"
	onload="initialize()">
	<jsp:include page="../header.jsp">
		<jsp:param name="page_active" value="hello" />
	</jsp:include>

	<div id="container" class="container">

		<div class="panel panel-default">
			<div class="panel-heading">
				<label>${activity.name}</label>
			</div>
			<div class="panel-body">

				<div class="column">
					<div class="col-md-6">
						<fieldset>
							<div
								class="form-group row col-xs-12 col-sm-12 col-md-12 col-lg-12">
								<div class="col-xs-6 col-sm-6 col-md-6 col-lg-6">
									<div class="row">
										<label class="control-label" for="name">Adresse : </label>
										<p id="address">${activity.address}<br>${activity.zip_code}&nbsp;Paris
										</p>
										<c:if test="${empty activity.lat}"></c:if>
										<c:if test="${empty activity.lon}"></c:if>
									</div>

								</div>
								<div class="col-xs-6 col-sm-6 col-md-6 col-lg-6">
									<div class="row">
										<label
											class="control-label col-xs-8 col-sm-8 col-md-8 col-lg-8"
											for="name">Note : </label>
										<div class="rating">
											<c:forEach begin="1" end="${activityRate}" varStatus="loop">
												<span>&#9733;</span>
											</c:forEach>
											<c:forEach begin="${activityRate}" end="4" varStatus="loop">
												<span>&#9734;</span>
											</c:forEach>
										</div>
									</div>
									<div class="row">
										<label
											class="control-label col-xs-8 col-sm-8 col-md-8 col-lg-8 control-label"
											for="name">Coût moyen : </label>${averageCost}&euro;
									</div>
									<div class="row">
										<label
											class="control-label col-xs-8 col-sm-8 col-md-8 col-lg-8 control-label"
											for="name">Durée moyenne : </label>${averageDuration}
									</div>
								</div>
							</div>


							<div
								class="row form-group row col-xs-12 col-sm-12 col-md-12 col-lg-12">
								<label class="control-label" for="name">Catégorie : </label>
								${category.name}
							</div>

							<div
								class="row form-group row col-xs-12 col-sm-12 col-md-12 col-lg-12">
								<label class="control-label" for="name">Itinéraires en
									rapport :</label>
								<c:choose>
									<c:when test="${fn:length(routeList) eq 0}">
										<p>Aucun itinéraire associé</p>
									</c:when>
									<c:when test="${fn:length(routeList) gt 3}">
										<p>
											<c:forEach begin="0" end="2" varStatus="loop">
												${routeList[loop.index].name} 
												<c:forEach begin="1" end="${reviewList[loop.index]}"
													varStatus="loop">
													<span>&#9733;</span>
												</c:forEach>
												<c:forEach begin="${reviewList[loop.index]}" end="4"
													varStatus="loop">
													<span>&#9734;</span>
												</c:forEach>
												<br>
											</c:forEach>
										</p>
									</c:when>
									<c:otherwise>
										<p>
											<c:forEach begin="0" end="${fn:length(routeList)}"
												varStatus="loop">
												${routeList[loop.index].name}<br>
											</c:forEach>
										</p>
									</c:otherwise>
								</c:choose>
							</div>
							<hr>
							<div
								class="row form-group row col-xs-12 col-sm-12 col-md-12 col-lg-12">
								<label class="control-label" for="name">Commentaires :</label>
								<c:choose>
									<c:when test="${fn:length(activityReviews) eq 0}">
										<p>Aucun commentaire</p>
									</c:when>
									<c:when test="${fn:length(activityReviews) gt 3}">
										<p>
											<c:forEach begin="0" end="2" varStatus="loop">
												${activityReviews[loop.index].description}<br>
												<hr>
											</c:forEach>
										</p>
									</c:when>
									<c:otherwise>
										<p>
											<c:forEach begin="0" end="${fn:length(activityReviews)}"
												varStatus="loop">
												${activityReviews[loop.index].description}<br>
												<hr>
											</c:forEach>
										</p>
									</c:otherwise>
								</c:choose>
								<c:choose>
									<c:when test="${empty user}">
										<a id="addComment" onClick="showMsg();">Ajouter un
											commentaire</a>
										<div id="theForm" style="visibility: hidden;">
											<form accept-charset="utf-8"
												onsubmit="return func('${param.id}')">
												<fieldset class="form-group">
													<label for="select1">Note</label> <select
														class="form-control" id="select1">
														<option value="1">1</option>
														<option value="2">2</option>
														<option value="3">3</option>
														<option value="4">4</option>
														<option value="5">5</option>
													</select>
												</fieldset>
												<fieldset class="form-group">
													<label for="textarea"></label>
													<textarea class="form-control" id="textarea" rows="3">Entrez votre commentaire ...</textarea>
												</fieldset>
												<fieldset class="form-group">
													<button type="submit" id="submit" class="btn btn-primary">Envoyer</button>
												</fieldset>
											</form>

										</div>
									</c:when>
									<c:otherwise>Pour ajouter un
												commentaire,
											<a href="./connexion_inscription"> connectez vous</a>
									</c:otherwise>
								</c:choose>
							</div>

						</fieldset>
					</div>
				</div>

				<div class="col-md-6">
					<div class="container-fluid">
						<label>Plan :</label>
						<div id="map-canvas">
							<p>Veuillez patienter pendant le chargement de la carte...</p>
						</div>
					</div>
				</div>

			</div>
		</div>
	</div>
</body>
</html>