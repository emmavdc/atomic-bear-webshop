<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@ include file ="include/importTags.jsp" %>

<c:if test="${!isOrderConfirmed}">
    <div class="orderResume">
        <form:form id="orderForm"
                   method="POST"
                   action="order"
                   modelAttribute="currentOrder">

            <h1><spring:message code="orderSummary"/></h1>
            <br>

            <p><strong><spring:message code="orderFrom"/> :</strong> ${currentUser.firstName} ${currentUser.lastName}</p>

            <br>
            <div class="container">
                <div class="row">
                    <div class="col-sm">
                        <p><strong><spring:message code="deliveryAdress"/> :</strong></p>
                        <%-- ${pageContext.request.userPrincipal.streetName}, ${pageContext.request.userPrincipal.streetNumber}
                        ${pageContext.request.userPrincipal.locality} ${pageContext.request.userPrincipal.zipCode}
                        ${pageContext.request.userPrincipal.country} --%>
                        <p>${currentUser.streetName}, ${currentUser.streetNumber}</p>
                        <p>${currentUser.locality} ${currentUser.zipCode}</p>
                        <p>${currentUser.country}</p>
                    </div>
                    <div class="col-sm">
                        <p><strong><spring:message code="billingAdress"/> :</strong></p>
                        <p>${currentUser.streetName}, ${currentUser.streetNumber}</p>
                        <p>${currentUser.locality} ${currentUser.zipCode}</p>
                        <p>${currentUser.country}</p>
                    </div>
                </div>
            </div>

            <table class="table tableOrderResume">
                <thead class="thead-dark">
                    <tr>
                        <th width="400px" class="cartImg"><spring:message code="product"/></th>
                        <th><spring:message code="price"/></th>
                        <th><spring:message code="quantity"/></th>
                        <th><spring:message code="totalPrice"/></th>
                    </tr>
                </thead>

                <c:forEach var="orderLine" items = "${sessionScope.cart}">
                    <tr>
                        <td class="cartImg"><img height="125px" width="125px" src='<spring:url value="/images/products/${orderLine.value.item.category.categoryID}/${orderLine.value.item.filePath}"/>' alt="${orderLine.value.item.filePath}"></td>
                        <td>${orderLine.value.item.price} €</td>
                        <td>${orderLine.value.quantity}</td>
                        <td>${orderLine.value.price} €</td>
                    </tr>
                </c:forEach>
            </table>

            <h3><strong><spring:message code="subTotal"/> : ${totalPriceCart} €</strong></h3>
            <br>

            <p class="text-center"><spring:message code="confirmOrder"/></p>
            <form:button class="btn btn-primary confirmOrder"><spring:message code="confirm"/></form:button>

        </form:form>
    </div>
</c:if>

<c:if test="${isOrderConfirmed}">
    <div class="container">
        <c:forEach items="${returnCodesSaveOrder}" var="returnCode">
            <div id="orderStatus" width="${boxSize}px">
                <img src='<spring:url value = "/images/${orderStatus}.gif"/>' width="200" height="150"  alt="orderStatus"/>
                <spring:message code="${returnCode}"/>
            </div>
        </c:forEach>
    </div>
</c:if>