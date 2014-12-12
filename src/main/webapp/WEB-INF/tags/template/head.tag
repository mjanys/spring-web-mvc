<%@tag description="Head Template" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<%@attribute name="headBegin" fragment="true" %>
<%@attribute name="headEnd" fragment="true" %>
<%@attribute name="title"%>

<c:if test="${empty title}">
    <spring:message code="main-page-title" var="title"/>
</c:if>

<head>
    <jsp:invoke fragment="headBegin"/>

    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>${title}</title>

    <link rel="shortcut icon" href="<c:url value="/img/favicon.png"/>">
    <link href="<c:url value="/css/bootstrap.css"/>" rel="stylesheet">
    <link href="<c:url value="/css/style.css"/>" rel="stylesheet">

    <script type="text/javascript" src="<c:url value="/js/jquery.min.js"/>"></script>
    <script type="text/javascript" src="<c:url value="/js/bootstrap.min.js"/>"></script>

    <jsp:invoke fragment="headEnd"/>
</head>