<%@page contentType="text/html;charset=UTF-8" %>
<%@page pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ include file="header.jsp" %>

<div class="container">
    <div class="hero-unit">
        <p>Go to <a href="<c:url value='/hcproviders' />">Health Care Providers</a> page.</p>
    </div>

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
</div>
</body>
</html>
