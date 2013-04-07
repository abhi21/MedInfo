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
                    <li><a href="<c:url value='/' />">Home</a></li>
                    <li><a href="<c:url value='/about' />">About</a></li>
                    <li class="active"><a href="<c:url value='/contact'/>">Contact</a></li>
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
        <div class="lead">

            <h2 align="center">
            https://github.com/nningego/MedInfo
            </h2>

            <h2 align="center">
            Collaborators:
            </h2>

            <ul>
            <li><a href="mailto:jkabhishek88@gmail.com">Abhishek Sharma</a>
            <li><a href="mailto:nishitha.ningegowda@gmail.com">Nishitha Ningegowda</a>
            <li><a href="mailto:vjagannath09@gmail.com">Vaikuntham Jagannath</a>
            <li><a href="mailto:vishnu_him@yahoo.co.in">Vishnu Karthik L</a>
            </ul>
        </div>

    </div>
</div>