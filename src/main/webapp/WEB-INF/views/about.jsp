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
                    <li class="active"><a href="<c:url value='/about' />">About</a></li>
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
        <div class="lead">

            <h2 align="center">
            About MEDINFO :
            </h2>

            <p>
            The project provides the user information about the nearest Health Care Providers (i.e. a hospital/doctor/midwife, an Anganwadi/ASHA worker or an ANC)
            near his/her location.The project effectively leverages the pre-existing mobile infrastructure to be effective at the grass root level.
            It allows a person to send an SMS to the preset number to get information on the medical help available in the locality / area and the same
            can also be accessible through the website, thus making it effective both in Urban & Rural India.
            </p>

            <br>

            <h2 align="center">
            Why we decided to do it :
            </h2>

            <p>
            The number of deaths caused in India due to various reasons like accidents, malnutrition, ignorance, etc. could be drastically decreased
            if the affected people get the required medical attention at the right time.
            So, we in our own way are trying to make the right information available to the people in a manner that is both convenient and economical for them.
            </p>

        </div>

    </div>
</div>