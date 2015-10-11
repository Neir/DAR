<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>Liste des activités</h2>
	<table>
		<tr>
			<td>Id</td>
			<td>Nom</td>
			<td>Adresse</td>
			<td>CP</td>
			<td>Latitude</td>
			<td>Longitude</td>
			<td>Categorie</td>
			<td></td>
		</tr>
		<c:forEach items="${activities}" var="activity">
			<tr>
				<td>${activity.id_activity}</td>
				<td>${activity.name}</td>
				<td>${activity.address}</td>
				<td>${activity.zip_code}</td>
				<td><c:if test="${empty activity.lat}">
    					null
					</c:if> <c:if test="${not empty activity.lat}">
   					 ${activity.lat}
					</c:if></td>
				<td><c:if test="${empty activity.lon}">
    					var1 is empty or null.
					</c:if> <c:if test="${not empty activity.lon}">
   					 ${activity.lon}
					</c:if></td>
				<td>${activity.category}</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>