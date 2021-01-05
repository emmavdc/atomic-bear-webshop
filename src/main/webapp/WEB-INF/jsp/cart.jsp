<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@ include file ="include/importTags.jsp" %>

<div id="cartTable">
    <table class="table">
        <thead class="thead-dark">
            <tr>
                <th>#</th>
                <th width="600px" class="cartImg"><spring:message code="product"/></th>
                <th><spring:message code="price"/></th>
                <th colspan="3"><spring:message code="quantity"/></th>
                <th><spring:message code="totalPrice"/></th>
                <th><spring:message code="delete"/></th>
            </tr>
        </thead>

        <% int iItem = 1; %>
        <c:forEach var="orderLine" items = "${sessionScope.cart}">
            <tr>
                <td><%= iItem %></td>
                <td class="cartImg"><img height="250px" width="250px" src='<spring:url value="/images/products/${orderLine.value.item.category.categoryID}/${orderLine.value.item.filePath}"/>' alt="${orderLine.value.item.filePath}"></td>
                <td>${orderLine.value.item.price} €</td>
                <td>
                    <spring:url var="actionValue" value="/cart/minusQuantity"/>
                    <form:form id="minus${orderLine.key}"
                               method="POST"
                               action="${actionValue}"
                               modelAttribute="product">
                        <form:hidden path="orderLineID" value="<%= iItem %>"/>
                        <form:hidden path="itemID" value="${orderLine.value.itemID}"/>
                        <form:hidden path="quantity" value="${orderLine.value.quantity}"/>
                        <form:button><img height="20px" width="20px" src="https://icons.getbootstrap.com/icons/cart-dash.svg" alt="cartDash"></form:button>
                    </form:form>
                </td>
                <td>${orderLine.value.quantity}</td>
                <td>
                    <spring:url var="actionValue" value="/cart/plusQuantity"/>
                    <form:form id="plus${orderLine.key}"
                               method="POST"
                               action="${actionValue}"
                               modelAttribute="product">
                        <form:hidden path="orderLineID" value="<%= iItem %>"/>
                        <form:hidden path="itemID" value="${orderLine.value.itemID}"/>
                        <form:hidden path="quantity" value="${orderLine.value.quantity}"/>
                        <form:button><img height="20px" width="20px" src="https://icons.getbootstrap.com/icons/cart-plus.svg" alt="cartPlus"></form:button>
                    </form:form>
                </td>
                <td>${orderLine.value.price} €</td>
                <td>
                    <spring:url var="actionValue" value="/cart/removeProduct"/>
                    <form:form id="remove${orderLine.key}"
                               method="POST"
                               action="${actionValue}"
                               modelAttribute="product">
                        <form:hidden path="orderLineID" value="<%= iItem %>"/>
                        <form:hidden path="itemID" value="${orderLine.value.itemID}"/>
                        <form:button><img height="20px" width="20px" src="https://icons.getbootstrap.com/icons/trash.svg" alt="trash"></form:button>
                    </form:form>
                </td>
            </tr>
            <% iItem++; %>
        </c:forEach>
    </table>

    <sec:authorize access="isAuthenticated()">
        <div class="placeOrder">
            <a href="<spring:url value='/cart/order'/>">
                <c:choose>
                    <c:when test="${empty sessionScope.cart}">
                        <button disabled class="btn btn-primary"><spring:message code="placeOrder"/></button>
                    </c:when>
                    <c:otherwise>
                        <button class="btn btn-primary"><spring:message code="placeOrder"/></button>
                    </c:otherwise>
                </c:choose>
            </a>
        </div>
    </sec:authorize>
    <sec:authorize access="!isAuthenticated()">
        <p class="text-center"><spring:message code="loginToOrder" /></p>
    </sec:authorize>
</div>

