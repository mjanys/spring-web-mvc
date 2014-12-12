<%--@elvariable id="items" type="java.util.List<cz.janys.iface.dto.PersonDto>"--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@include file="init.jspf" %>

<t:html contentClass="person-app">
    <h2>
        <spring:message code="label-create-person"/>
    </h2>
    <div class="panel">
        <%@include file="components/form.jspf"%>
    </div>
</t:html>