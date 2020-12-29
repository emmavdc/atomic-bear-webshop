<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@ include file ="include/importTags.jsp" %>

<form:form id="logForm"
           method="POST"
           modelAttribute="user">
    <div class="form-group">
        <form:label path="username">Email</form:label>
        <form:input path="username" class="form-control"></form:input>
        <small id="emailHelp" class="form-text text-muted"><spring:message code="notShare"/></small>
    </div>
    <br>
    <div class="form-group">
        <form:label path="password">
            <spring:message code="password"/>
        </form:label>
        <form:input path="password" type="password" class="form-control"></form:input>
    </div>
    <br>
    <div class="form-group">
        <span class="regErrors"><spring:message code="${badCredential}"/></span>
    </div>
    <div class="mb-2">
        <form:button class="btn btn-primary">
            <spring:message code="login" />
        </form:button>
    </div>
    <br>
    <a href="<spring:url value='/registration'/>"><spring:message code="noAccountYet"/></a>
</form:form>