<%@page contentType="text/html;charset=UTF-8"%>
<%@page pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<title>Spring MVC skeleton with Gradle build, Hibernate persistance and Selenium functional testing</title>
		<link rel="stylesheet" href="<c:url value='/styles/default.css' />" type="text/css" />
		<script type="text/javascript" src="<c:url value='/scripts/lib/prototype.js' />"></script>
	</head>
	<body>
		<!--[if lt IE 9]>
			<div class="legacy-browser">You are using a Legacy Browser - it is not supported. Please upgrade to <a href="http://windows.microsoft.com/en-US/internet-explorer/downloads/ie-9/worldwide-languages">IE9</a>, Firefox, Safari, Chrome or Opera.</div>
		<![endif]-->
		<h1><div class="heading">Welcome to MedInfo !</div></h1>
		<h2>This is your Spring MVC skeleton with Gradle build, Hibernate persistance and Selenium functional testing</h2>
		<p>Go to <a href="<c:url value='/hcproviders' />">Health Care Providers</a> page.</p>

        <table id="homepage">
            <thead>
            <tr>
                <th>Name</th>
                <th>Phone</th>
                <th>Role</th>
                <th>Street</th>
                <th>City</th>
                <th>State</th>
                <th>Pincode</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="hcpMap" items="${hcpGrid.hcpMap}" varStatus="row">
                <tr>
                    <td><c:out value="${hcpMap.value.name}"/></td>
                    <td><c:out value="${hcpMap.value.phone}"/></td>
                    <td><c:out value="${hcpMap.value.role}"/></td>
                    <td><c:out value="${hcpMap.value.street}"/></td>
                    <td><c:out value="${hcpMap.value.city}"/></td>
                    <td><c:out value="${hcpMap.value.state}"/></td>
                    <td><c:out value="${hcpMap.value.pincode}"/></td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
	</body>
</html>
