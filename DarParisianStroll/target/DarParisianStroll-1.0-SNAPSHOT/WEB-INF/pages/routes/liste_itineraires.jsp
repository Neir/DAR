<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="fr">
	<head>
		<meta http-equiv="content-type" content="text/html; charset=utf-8">
		<jsp:include page="../import.jsp"></jsp:include>
		<meta name="generator" content="Bootply" />
		<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    	<link rel="stylesheet" href="<c:url value="/resources/select2-3.5.4/select2.css"/>" media="screen"/>
		<link rel="stylesheet" href="<c:url value="/resources/css/liste_itineraires.css"/>" media="screen"/>
		<script src="<c:url value="/resources/js/liste_itineraires.js" />"></script>
		<script src="<c:url value="/resources/select2-3.5.4/select2.min.js" />"></script>
		<script src="<c:url value="/resources/js/routes/create_itineraire.js" />"></script>
		<!-- Faire fonctionner les balises structurantes de HTML5 -->
    	<!--[if lt IE 9]>
      		<script src="http://html5shiv.googlecode.com/svn/trunk/html5.js"></script>
    	<![endif]-->
		<title>Recherche itinéraires</title>
		
		<style type="text/css">
      		body
			{
			    background-repeat:no-repeat;
			    background-size:cover;
			    font-family: 'PT Sans', Helvetica, Arial, sans-serif;
			    font-size: 16px;
			}
    	</style>
	</head>
	<body style="background-image:url(<c:url value="/resources/images/paris.jpg" />)">
		<jsp:include page="../header.jsp">
			<jsp:param name="page_active" value="liste_inteneraires" />
			<jsp:param name="connected" value="${connected}" />
		</jsp:include>

		<div id="container" class="container">

		<div class="panel panel-default">
			<div class="panel-heading">
				<label>Rechercher un Itinéraire</label>
			</div>
			<div class="panel-body">
				<form class="form-horizontal" action="liste_itineraires" method="post">
					<div class="row">
						<div class="col-md-6">
							<fieldset>

								<div class="form-group input-group">
					    			<span class="input-group-addon">
				              			<span class="glyphicon">Activité 1</span>
				              		</span>
									<select id="act1" name="act1" class="form-control select2-allow-clear select2-offscreen" tabindex="-1">
										<option> </option>
										<c:forEach items="${activities}" var="act">
							  		 		<option value="${act.id_activity}">${act.name}</option>
							  			</c:forEach>
			    					</select>
					    		</div>
					    		
					    		<div class="form-group input-group">
					    			<span class="input-group-addon">
				              			<span class="glyphicon">Activité 2</span>
				              		</span>
									<select id="act2" name="act2" class="form-control select2-allow-clear select2-offscreen" tabindex="-1">
										<option> </option>
										<c:forEach items="${activities}" var="act">
							  		 		<option value="${act.id_activity}">${act.name}</option>
							  			</c:forEach>
			    					</select>
					    		</div>
					    		
					    		<div class="form-group input-group">
					    			<span class="input-group-addon">
				              			<span class="glyphicon">Activité 3</span>
				              		</span>
									<select id="act3" name="act3" class="form-control select2-allow-clear select2-offscreen" tabindex="-1">
										<option> </option>
										<c:forEach items="${activities}" var="act">
							  		 		<option value="${act.id_activity}">${act.name}</option>
							  			</c:forEach>
			    					</select>
					    		</div>
					    		
					    		<div>
					    			<button type="submit" class="btn btn-primary" id="valider" style="margin-left:250px;">
					      			<span style="color:white;">Valider</span>
					    		</button>
								</div>
								
								<c:if test="${routes != null}">
								<div class="row">
									<div class="col-md-6">
			
										<table id="groups"
											class="table table-condensed table-striped table-hover responsive" width="500px;">
											<thead>
												<tr>
													<th class="col-md-1"></th>
													<th><label>Nom</label></th>
													<th><label>Description</label></th>
													<th class="col-md-1"></th>
												</tr>
											</thead>
											<tbody>
												<c:forEach items="${routes}" var="rt" varStatus="status">
													<tr id="route-${rt.route_id}">
														<td style='display: none;'><input type="hidden"
															value="${rt.route_id}" /></td>
			
														<td><a href="itineraire?id=${rt.route_id}">${rt.name}</a></td>
														<td>${rt.description}</td>
														<td></td>
													</tr>
												</c:forEach>
											</tbody>
										</table>
									</div>
								</div>
								</c:if>
							</fieldset>
						</div>
					</div>
				</form>
			</div>
		</div>
		</div>
	</body>
</html>