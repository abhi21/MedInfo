<%@page contentType="text/html;charset=UTF-8" %>
<%@page pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ include file="header.jsp" %>

<div class="container">
    <div class="hero-unit">
        <p>Go to <a href="<c:url value='/hcproviders' />">Manage Health Care Providers</a> page.</p>
    </div>

    <div class="pull-right">
        <form id="search" action="search" method="GET"/>
        Search by Pincode : <input type="search" id="pincode" name="pincode" class="search-query"/>
        <input type="submit" value="Search"/>
    </div>
    <table id="homepage" class="table table-striped">
        <legend>Health Care Providers List</legend>
        <div id="search-stat" class="alert-success well">
            <c:choose>
            <c:when test="${searchCount}==0">
                <c:out value="No Result Found"/>
            </c:when>
            <c:otherwise>
                <c:out value="${searchStat}: ${searchCount}"/>
            </c:otherwise>
            </c:choose>


            <thead>
            <tr id="table-header">
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
</div>
</body>
</html>
