<%@include file="init.jspf" %>

<t:html>
    <div class="jumbotron">
        <p>
            Sample of Spring MVC application with JSP, HSQL in-memory database, JPA (hibernate) and Bootstrap compiled from LESS on Maven.
            There is also basic template pattern.
        </p>
        <p>
            For example of CRUD application continue to Person page.
        </p>
        <p>
            <c:url value="/person" var="personUrl"/>
            <h:link href="${personUrl}">
                <spring:message code="label-person-page" var="btnText"/>
                <bs:button text="${btnText}" cssClass="btn-default"/>
            </h:link>
        </p>
    </div>
</t:html>
