<%@page contentType="text/html;charset=UTF-8" %>
<%@page pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ include file="header.jsp" %>
<body>
<div class="navbar navbar-inverse navbar-fixed-top">
    <div class="navbar-inner">
        <div class="container">
            <button type="button" class="btn btn-navbar" data-toggle="collapse" data-target=".nav-collapse">
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="brand" href="<c:url value='/' />">MedInfo</a>
            <div class="nav-collapse collapse">
                <ul class="nav">
                    <li class="active"><a href="<c:url value='/' />">Home</a></li>
                    <li><a href="<c:url value='/about' />">About</a></li>
                    <li><a href="<c:url value='/contact'/>">Contact</a></li>
                </ul>
            </div><!--/.nav-collapse -->
        </div>
    </div>
</div>
<!--[if lt IE 9]>
<div class="legacy-browser">You are using a Legacy Browser - it is not supported. Please upgrade to <a href="http://windows.microsoft.com/en-US/internet-explorer/downloads/ie-9/worldwide-languages">IE9</a>, Firefox, Safari, Chrome or Opera.</div>
<![endif]-->


<div class="container">
    <div class="hero-unit">
        <p>Go to <a href="<c:url value='/hcproviders' />">Manage Health Care Providers</a> </p>
        <p><a href="<c:url value='/smsflow' />">Instructions to get Health Care Providers details by SMS</a> </p>

    </div>

    <div class="pull-right">
        <form id="search" action="search" method="GET"/>
        Search by Pincode : <input type="search" id="pincode" name="pincode" class="search-query"/>
        <input type="submit" value="Search"/>
    </div>
    <table id="homepage" class="table table-striped">
        <legend>Health Care Providers List</legend>

        <c:choose>
            <c:when test="${searchCount == 0}">
                <div id="search-stat" class="alert-danger well">
                    <c:out value="No Result Found"/>
                </div>
            </c:when>
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
