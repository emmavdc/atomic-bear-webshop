<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@ include file ="include/importTags.jsp" %>

<div class="container">
    <c:if test="${!isOrderConfirmed}">
        <form:form id="orderForm"
                   method="POST"
                   action="order"
                   modelAttribute="currentOrder">



            <div class="form-group row">
                <div class="col-sm-4 col-form-label">
                    <spring:message code="confirmOrder"/>
                </div>
            </div>
            <form:button class="btn btn-primary"><spring:message code="confirm"/></form:button>

        </form:form>
    </c:if>

    <c:if test="${isOrderConfirmed}">
        <c:forEach items="${returnCodesSaveOrder}" var="returnCode">
            <spring:message code="${returnCode}"/>
        </c:forEach>
    </c:if>
</div>