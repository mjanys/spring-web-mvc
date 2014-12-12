<%@tag description="Html Template" pageEncoding="UTF-8"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags/template" %>

<%@attribute name="headBegin" fragment="true" %>
<%@attribute name="headEnd" fragment="true" %>
<%@attribute name="contentClass"%>
<%@attribute name="title"%>

<%@attribute name="header" fragment="true" %>
<%@attribute name="footer" fragment="true" %>

<!DOCTYPE html>
<html>
    <t:head>
        <jsp:attribute name="headBegin">
            <jsp:invoke fragment="headBegin"/>
        </jsp:attribute>
        <jsp:attribute name="headEnd">
            <jsp:invoke fragment="headEnd"/>
        </jsp:attribute>
        <jsp:attribute name="title">
            <c:out value="${title}"/>
        </jsp:attribute>
    </t:head>

    <t:body>
        <jsp:attribute name="contentClass">
            <c:out value="${contentClass}"/>
        </jsp:attribute>
        <jsp:attribute name="header">
            <jsp:invoke fragment="header"/>
        </jsp:attribute>
        <jsp:attribute name="content">
            <jsp:doBody/>
        </jsp:attribute>
        <jsp:attribute name="footer">
            <jsp:invoke fragment="footer"/>
        </jsp:attribute>
    </t:body>
</html>