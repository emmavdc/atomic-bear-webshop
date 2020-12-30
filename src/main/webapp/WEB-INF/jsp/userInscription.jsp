<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@ include file ="include/importTags.jsp" %>


<%--@elvariable id="currentUser" type="Customer"--%>
<form:form id="regForm"
           method="POST"
           action="/atomic-bear/registration"
           modelAttribute="currentUser">

    <div class="form-group row">
        <form:label path="username" class="col-sm-4 col-form-label">Email</form:label>
        <div class="col-sm-8">
            <form:input path="username" class="form-control"></form:input>
        </div>
        <form:errors path="username" class="regErrors"/>
        <span class="regErrors"><spring:message code="${usernameAlreadyExist}"/></span>
    </div>

    <div class="form-group row">
        <form:label path="password" class="col-sm-4 col-form-label"><spring:message code="password"/></form:label>
        <div class="col-sm-8">
            <form:input type="password" path="password" class="form-control"></form:input>
        </div>
        <form:errors path="password" class="regErrors"/>
    </div>

    <div class="form-group row">
        <form:label path="confirmPassword" class="col-sm-4 col-form-label"><spring:message code="confirmPassword"/></form:label>
        <div class="col-sm-8">
            <form:input type="password" path="confirmPassword" class="form-control"></form:input>
        </div>
        <span class="regErrors"><spring:message code="${pwdDontMatch}"/></span>
    </div>

    <div class="form-group row">
        <form:label path="firstName" class="col-sm-4 col-form-label"><spring:message code="firstName"/></form:label>
        <div class="col-sm-8">
            <form:input path="firstName" class="form-control"></form:input>
        </div>
        <form:errors path="firstName" class="regErrors"/>
    </div>

    <div class="form-group row">
        <form:label path="lastName" class="col-sm-4 col-form-label"><spring:message code="lastName"/></form:label>
        <div class="col-sm-8">
            <form:input path="lastName" class="form-control"></form:input>
        </div>
        <form:errors path="lastName" class="regErrors"/>
    </div>

    <div class="form-group row">
        <form:label path="phoneNumber" class="col-sm-4 col-form-label"><spring:message code="phoneNumber"/></form:label>
        <div class="col-sm-8">
            <form:input path="phoneNumber" class="form-control"></form:input>
        </div>
        <form:errors path="phoneNumber" class="regErrors"/>
    </div>

    <div class="form-group row">
        <form:label path="streetName" class="col-sm-4 col-form-label"><spring:message code="streetName"/></form:label>
        <div class="col-sm-8">
            <form:input path="streetName" class="form-control"></form:input>
        </div>
        <form:errors path="streetName" class="regErrors"/>
    </div>

    <div class="form-group row">
        <form:label path="streetNumber" class="col-sm-4 col-form-label"><spring:message code="streetNumber"/></form:label>
        <div class="col-sm-8">
            <form:input path="streetNumber" class="form-control"></form:input>
        </div>
        <form:errors path="streetNumber" class="regErrors"/>
    </div>

    <div class="form-group row">
        <form:label path="locality" class="col-sm-4 col-form-label"><spring:message code="locality"/></form:label>
        <div class="col-sm-8">
            <form:input path="locality" class="form-control"></form:input>
        </div>
        <form:errors path="locality" class="regErrors"/>
    </div>

    <div class="form-group row">
        <form:label path="zipCode" class="col-sm-4 col-form-label"><spring:message code="zipCode"/></form:label>
        <div class="col-sm-8">
            <form:input path="zipCode" class="form-control"></form:input>
        </div>
        <form:errors path="zipCode" class="regErrors"/>
    </div>

    <div class="form-group row">
        <form:label path="country" class="col-sm-4 col-form-label"><spring:message code="country"/></form:label>
        <div class="col-sm-8">
            <form:input path="country" class="form-control"></form:input>
        </div>
        <form:errors path="country" class="regErrors"/>
    </div>

    <form:button class="btn btn-primary"><spring:message code="signUp"/></form:button>
</form:form>