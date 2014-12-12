<%@tag description="Body Template" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags/template" %>
<%@ taglib prefix="f" tagdir="/WEB-INF/tags/form" %>

<%@attribute name="header" fragment="true" %>
<%@attribute name="footer" fragment="true" %>
<%@attribute name="content" fragment="true" %>

<%@attribute name="contentClass" %>

<body>
    <t:menu/>
    <div id="page" class="container">
        <jsp:invoke var="headerContent" fragment="header"/>
        <c:choose>
            <c:when test="${empty headerContent}">
                <t:header/>
            </c:when>
            <c:otherwise>
                ${headerContent}
            </c:otherwise>
        </c:choose>

        <div id="content" class="container-fluid ${contentClass}">

            <f:messages/>

            <jsp:invoke fragment="content"/>
        </div>

        <jsp:invoke var="footerContent" fragment="footer"/>
        <c:choose>
            <c:when test="${empty footerContent}">
                <t:footer/>
            </c:when>
            <c:otherwise>
                ${footerContent}
            </c:otherwise>
        </c:choose>

    </div>
</body>
