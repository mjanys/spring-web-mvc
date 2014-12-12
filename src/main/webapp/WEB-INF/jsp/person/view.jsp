<%--@elvariable id="items" type="java.util.List<cz.janys.iface.dto.PersonDto>"--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@include file="init.jspf" %>

<%@page import="static cz.janys.app.person.PersonConstants.*" %>

<t:html contentClass="person-app">
    <div id="personView">
        <div class="panel panel-default">
            <!-- Default panel contents -->
            <div class="panel-heading">All persons.</div>
            <%--<div class="panel-body"></div>--%>

            <!-- Table -->
            <%@include file="components/table.jspf"%>

            <div class="panel-footer">
                <c:url value="/person/create" var="createUrl"/>
                <h:link href="${createUrl}">
                    <spring:message code="label-create-person" var="createLabel"/>
                    <bs:button text="${createLabel}" cssClass="btn-default"/>
                </h:link>
            </div>
        </div>
    </div>
</t:html>
