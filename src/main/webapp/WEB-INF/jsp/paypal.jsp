<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@ include file ="include/importTags.jsp" %>

</form:form> --%>

<div class="orderResume">
    <h2><spring:message code="paymentMethod"/></h2>
    <br>

    <form action="https://www.sandbox.paypal.com/cgi-bin/webscr" method="post">
        <input type="hidden" name="business" value="atomic-bear@gmail.com">
        <input type="hidden" name="password" value="EPflaFgJnM8gokJhVf1FxO1d2HSzyArT4OnCP5pra0NfVvq1VgV_46btS4fC2pqLEaSKOHbZMBvQabdm">
        <input type="hidden" name="cert_id" value="ASnupiRg_NwkP0y5lTwGJJnvMvNmybzKNOKX5jw17TrqwAom3gjYAAXRyogKZ1yFba9xhKJ5o9T38KEs">
        <input type="hidden" name="cmd" value="_cart">
        <input type="hidden" name="upload" value="1">

        <c:forEach items="${sessionScope.cart}" var="orderLine" varStatus="loop">
            <input type="hidden" name="item_name_${loop.index+1}" value="${orderLine.value.item.label}">
            <input type="hidden" name="amount_${loop.index+1}" value="${orderLine.value.item.discount == null ? orderLine.value.item.price : (orderLine.value.item.price - (orderLine.value.item.price * orderLine.value.item.discount.discount)/100)}">
            <input type="hidden" name="quantity_${loop.index+1}" value="${orderLine.value.quantity}">
        </c:forEach>
        <%--<input type="hidden" name="amount" value="${totalPriceCart}">--%>

        <%--<input type="hidden" name="shipping_1" value="5">--%>
        <input type="hidden" name="currency_code" value="EUR">
        <input type="hidden" name="locale" value="fr_FR">

        <!-- Enable override of buyers's address stored with PayPal -->
        <input type="hidden" name="address_override" value="1">
        <!-- Set variables that override the address stored with PayPal -->
        <input type="hidden" name="first_name" value="${pageContext.request.userPrincipal.principal.firstName}">
        <input type="hidden" name="last_name" value="${pageContext.request.userPrincipal.principal.lastName}">
        <input type="hidden" name="night_phone_b" value="${pageContext.request.userPrincipal.principal.phoneNumber}">
        <input type="hidden" name="address1" value="${pageContext.request.userPrincipal.principal.streetNumber} ${pageContext.request.userPrincipal.principal.streetName}">
        <input type="hidden" name="city" value="${pageContext.request.userPrincipal.principal.locality}">
        <input type="hidden" name="zip" value="${pageContext.request.userPrincipal.principal.zipCode}">
        <input type="hidden" name="country" value="BE">
        <input type="hidden" name="cancel_return" value="http://localhost:8082/atomic-bear/cart/orderFailed">
        <input type="hidden" name="return" value="http://localhost:8082/atomic-bear/cart/orderSuccess">
        <input type="image" name="submit"
               src="http://assets.stickpng.com/images/580b57fcd9996e24bc43c530.png"
               height="60px" width="200px"
               alt="PayPal - The safer, easier way to pay online">
    </form>
    <%-- https://www.paypalobjects.com/webstatic/en_US/i/buttons/ppcredit-logo-small.png https://www.paypalobjects.com/en_US/i/btn/btn_buynow_LG.gif --%>
</div>