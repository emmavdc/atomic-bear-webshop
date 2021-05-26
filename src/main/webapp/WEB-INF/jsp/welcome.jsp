<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@ include file ="include/importTags.jsp" %>

<div class = "container welcome">
   <div class="row">
       <article class = "col-xs-12 col-sm-12 col-md-12 col-lg-12">
           <sec:authorize access="isAuthenticated()">
               <h2 class="text-center text-secondary name-title">Bonjour ${pageContext.request.userPrincipal.principal.firstName} !</h2>
           </sec:authorize>

           <h1><spring:message code="welcome"/></h1>
           <p class="text-center"><spring:message code="welcomeTxt"/></p>
       </article>
   </div>

    <div id="carouselExampleSlidesOnly" class="carousel slide" data-ride="carousel">
        <ol class="carousel-indicators">
            <li data-target="#carouselExampleIndicators" data-slide-to="0" class="active"></li>
            <li data-target="#carouselExampleIndicators" data-slide-to="1"></li>
            <li data-target="#carouselExampleIndicators" data-slide-to="2"></li>
            <li data-target="#carouselExampleIndicators" data-slide-to="3"></li>
        </ol>
        <div class="carousel-inner">
            <div class="carousel-item active">
                <img src='<spring:url value="/images/carousel/img1.jpg"/>' class="img-fluid rounded mx-auto d-block w-10" alt="motivation">
            </div>
            <div class="carousel-item">
                <img src='<spring:url value="/images/carousel/img2.jpg"/>' class="img-fluid rounded mx-auto d-block w-10" alt="body_box">
            </div>
            <div class="carousel-item">
                <img src='<spring:url value="/images/carousel/img3.jpg"/>' class="img-fluid rounded mx-auto d-block w-10" alt="body_dumbell">
            </div>
            <div class="carousel-item">
                <img src='<spring:url value="/images/carousel/img4.jpg"/>' class="img-fluid rounded mx-auto d-block w-10" alt="women_fitness">
            </div>
        </div>
    </div>

    <%--
    <!-- <div class="next">
        <img src='<spring:url value = "/images/background_next.png"/>' width="1280" height= "720" class="next-background img-fluid rounded" alt="Background next product">
        <img src='<spring:url value = "/images/whey_mass.png"/>' class="next-product img-fluid" alt="Next product">
    </div> -->
    <img src='<spring:url value = "/images/background_next.png"/>' width="555" height= "312.1875" class="img-fluid rounded mx-auto d-block" alt="Next product">
    <p class="text-center">Vous pourrez bientôt passer cette commande !</p>

    <img src='<spring:url value = "/images/background_next2.jpg"/>' width="555" height= "312.1875" class="img-fluid rounded mx-auto d-block" alt="Next product">

    <img src='<spring:url value = "/images/logo_img.png"/>' width="555" height= "312.1875" class="img-fluid rounded mx-auto d-block" alt="Logo">
    --%>

    <%-- <p>User : ${user.getPassword()}</p> --%>
</div>