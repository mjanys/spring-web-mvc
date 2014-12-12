<%--@elvariable id="person" type="cz.janys.iface.dto.PersonDto"--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@include file="init.jspf" %>

<c:set var="col1" value="col-md-2 bold"/>
<c:set var="col2" value="col-md-10"/>

<t:html>
    <h2><spring:message code="label-person-detail-page"/></h2>
    <div class="list-group">
        <div class="row list-group-item">
            <div class="${col1}">
                <spring:message code="label-id"/>:
            </div>
            <div class="${col2}">
                <c:out value="${person.id}"/>
            </div>
        </div>
        <div class="row list-group-item">
            <div class="${col1}">
                <spring:message code="label-name"/>:
            </div>
            <div class="${col2}">
                <c:out value="${person.name}"/>
            </div>
        </div>
        <div class="row list-group-item">
            <div class="${col1}">
                <spring:message code="label-email"/>:
            </div>
            <div class="${col2}">
                <c:out value="${person.email}"/>
            </div>
        </div>
        <div class="row list-group-item">
            <div class="${col1}">
                <spring:message code="label-created"/>:
            </div>
            <div class="${col2}">
                <fmt:formatDate value="${person.timestamp}" pattern="<%=Constants.DATE_TIME_FORMAT%>" />
            </div>
        </div>
        <div class="row list-group-item">
            <div class="col-md-6">
                <c:url value="/person/edit/${person.id}" var="updateUrl"/>
                <h:link href="${updateUrl}">
                    <spring:message code="label-update-person" var="updateLabel"/>
                    <bs:button text="${updateLabel}" cssClass="btn-default"/>
                </h:link>
            </div>
            <a class="col-md-6">
                <c:url value="/person/delete" var="deleteUrl"/>
                <form:form id="deleteForm" action="${deleteUrl}" method="post">
                    <input type="hidden" name="id" value="${person.id}"/>
                </form:form>
                <h:link href="javascript:$('#deleteForm').submit()">
                    <spring:message code="label-delete-person" var="deleteLabel"/>
                    <bs:button text="${deleteLabel}" cssClass="btn-default"/>
                </h:link>
            </a>
        </div>
    </div>
</t:html>