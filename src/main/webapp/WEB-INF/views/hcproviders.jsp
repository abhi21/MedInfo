<%@page contentType="text/html;charset=UTF-8" %>
<%@page pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
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
        <div><h2>Manage Health Care Providers</h2></div>
    </div>
    <form:form action="" method="post" modelAttribute="HCProviderCommand">
        <fieldset class="fieldcontainer">
            <legend>Add New Health Care Provider</legend>
            <div class="block">
                <div class="field span3">
                    <form:label for="name" path="name">Name:</form:label>
                    <form:errors path="name" cssClass="errors"/>
                    <form:input path="name"/>
                </div>
                <div class="field span3">
                    <form:label for="phone" path="phone">Phone:</form:label>
                    <form:errors path="phone" cssClass="errors"/>
                    <form:input path="phone"/>
                </div>
            </div>
            <div class="block">
                <div class="field span3">
                    <form:label for="street" path="street">Street:</form:label>
                    <form:errors path="street" cssClass="errors"/>
                    <form:textarea path="street"/>
                </div>
                <div class="field span3">
                    <form:label for="city" path="city">City:</form:label>
                    <form:errors path="city" cssClass="errors"/>
                    <form:input path="city"/>
                </div>
                <div class="field span3">
                    <form:label for="state" path="state">State:</form:label>
                    <form:errors path="state" cssClass="errors"/>
                    <form:input path="state"/>
                </div>
                <div class="field span3">
                    <form:label for="pincode" path="pincode">Pincode:</form:label>
                    <form:errors path="pincode" cssClass="errors"/>
                    <form:input path="pincode"/>
                </div>
                <div class="field span3">
                    <form:label for="role" path="role">Role:</form:label>
                    <form:select path="role">
                        <form:option value="" label="Select"/>
                        <form:options items="${hcpRoles}"/>
                    </form:select>
                </div>
                <div class="field vertical">
                    <input id="submit" type="submit" value="Create new HCProvider">
                </div>
            </div>

        </fieldset>
    </form:form>

    <legend>All Current Registered Health Care Providers</legend>
    <form:form action="" method="post" modelAttribute="hcpGrid">
        <table class="table table-striped">
            <thead>
            <tr>
                <th><input type="checkbox" class="toggleAll"/></th>
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
            <c:forEach var="hcpEntry" items="${hcpGrid.hcpMap}" varStatus="row">
                <tr>
                    <td>
                        <form:input type="hidden" cssClass="disablable-hidden" disabled="${!hcpEntry.value.selected}"
                                    path="hcpMap[${hcpEntry.key}].id"/>
                        <c:if test="${hcpMap[hcpEntry.key].selected}">
                            <input type="checkbox" checked="checked" class="rowSelector"/>
                        </c:if>
                        <c:if test="${!hcpMap[hcpEntry.key].selected}">
                            <input type="checkbox" class="rowSelector"/>
                        </c:if>
                    </td>
                    <td>
                        <form:errors path="hcpMap[${hcpEntry.key}].name" cssClass="errors"/>
                        <form:input disabled="${!hcpEntry.value.selected}" path="hcpMap[${hcpEntry.key}].name"/>
                    </td>
                    <td>
                        <form:errors path="hcpMap[${hcpEntry.key}].phone" cssClass="errors"/>
                        <form:input disabled="${!hcpEntry.value.selected}" path="hcpMap[${hcpEntry.key}].phone"/>
                    </td>
                    <td>
                        <form:errors path="hcpMap[${hcpEntry.key}].role" cssClass="errors"/>
                        <form:input disabled="${!hcpEntry.value.selected}" path="hcpMap[${hcpEntry.key}].role"/>
                    </td>
                    <td>
                        <form:errors path="hcpMap[${hcpEntry.key}].street" cssClass="errors"/>
                        <form:input disabled="${!hcpEntry.value.selected}" path="hcpMap[${hcpEntry.key}].street"/>
                    </td>
                    <td>
                        <form:errors path="hcpMap[${hcpEntry.key}].city" cssClass="errors"/>
                        <form:input disabled="${!hcpEntry.value.selected}" path="hcpMap[${hcpEntry.key}].city"/>
                    </td>
                    <td>
                        <form:errors path="hcpMap[${hcpEntry.key}].state" cssClass="errors"/>
                        <form:input disabled="${!hcpEntry.value.selected}" path="hcpMap[${hcpEntry.key}].state"/>
                    </td>
                    <td>
                        <form:errors path="hcpMap[${hcpEntry.key}].pincode" cssClass="errors"/>
                        <form:input disabled="${!hcpEntry.value.selected}" path="hcpMap[${hcpEntry.key}].pincode"/>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
        <p>
            <input type="submit" class="sub-btn" disabled="${!hcpEntry.value.selected}" value="Update all enabled items" name="update">
            <input type="submit" class="sub-btn" disabled="${!hcpEntry.value.selected}" value="Delete all enabled items" name="delete">
        </p>
    </form:form>
</div>
</body>
</html>
