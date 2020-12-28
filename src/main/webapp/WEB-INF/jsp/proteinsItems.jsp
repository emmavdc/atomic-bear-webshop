<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@ include file ="include/importTags.jsp" %>

<form:form id="proteinItemsForm"
           method="POST"
           action="/sportNutrition/shop/${urlCateg}"
           modelAttribute="orderLine">
    <div style="width: 1200px; margin-left: auto; margin-right: auto">
        <% int iItem = 0; %>

        <c:forEach items="${items}" var="item">

            <%= (iItem == 0 ? "<div class='card-deck'>" : "") %>

            <div class="card text-center" style="width: 18rem; margin-top: 30px">
                    <img class="card-img-top" src='<spring:url value="/images/products/1/${item.filePath}"/>' alt="Proteins">
                    <div class="card-body">
                        <h5 class="card-title">${item.label}</h5>
                        <p class="card-text">${item.description}</p>
                        <form:input path="itemFK" class="form-control" type="hidden" id="itemFK" value="${item.itemID}"></form:input>
                        <div class="form-group row">
                            <label for="quantity" class="col-sm-5 col-form-label"><spring:message code="quantity"/></label>
                            <div class="col-sm-6">
                                <form:select path="quantity" class="form-control" id="quantity">
                                    <option>1</option>
                                    <option>2</option>
                                    <option>3</option>
                                    <option>4</option>
                                    <option>5</option>
                                </form:select>
                            </div>
                        </div>
                        <br>
                        <form:button class="btn btn-primary"><spring:message code="addToCart"/></form:button>
                    </div>
                </div>

            <%
                iItem++;
                String closeDiv = "";
                if (iItem == 4) {
                    iItem = 0;
                    closeDiv = "</div>";
                }
            %>
            <%= closeDiv %>

        </c:forEach>
        </div>
</form:form>