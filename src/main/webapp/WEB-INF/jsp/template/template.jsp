<%@ page pageEncoding = "UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ include file ="../include/importTags.jsp" %>
<%@ taglib uri ="http://tiles.apache.org/tags-tiles" prefix="tiles" %>

<html>
    <head>
        <!-- BOOTSTRAP -->
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
        <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ho+j7jyWK8fNQe+A12Hb8AhRq26LrZ/JpcUGGOn+Y7RsweNrtN/tE3MoK7ZeZDyx" crossorigin="anonymous"></script>

        <!-- BOOTSTRAP SOCIAL ICON AND FONTAWESOME ICON -->
        <script src="https://kit.fontawesome.com/a076d05399.js"></script>
        <link type="text/css" href= "<spring:url value='/resources/static/css/bootstrap-social.css'/>" rel="Stylesheet" />

        <!-- LANGUAGE -->
        <spring:url var="localeFr" value="">
            <spring:param name="locale" value="fr"/>
        </spring:url>

        <spring:url var="localeEn" value="">
            <spring:param name="locale" value="en"/>
        </spring:url>

        <!--OUR CSS -->
        <link type="text/css" href= "<spring:url value='/resources/static/css/template.css'/>" rel="Stylesheet" />
        <link type="text/css" href="<spring:url value='/resources/static/css/welcome.css'/>" rel="Stylesheet" />
        <link type="text/css" href="<spring:url value='/resources/static/css/login.css'/>" rel="Stylesheet" />
        <link type="text/css" href="<spring:url value='/resources/static/css/about.css'/>" rel="Stylesheet" />
        <link type="text/css" href="<spring:url value='/resources/static/css/shop.css'/>" rel="Stylesheet" />
        <link type="text/css" href="<spring:url value='/resources/static/css/cart.css'/>" rel="Stylesheet" />

        <!-- SCRIPT -->
        <script type="text/javascript" src="<spring:url value='/script/template.js'/>"></script>

        <!-- TITLE + ICON -->
        <title>${title}</title>
        <link rel="icon" href='<spring:url value = "/images/logo_icon.ico"/>' />
    </head>
    <body>
        <header class = "headerStyle">
            <!-- NAVBAR -->
            <nav id="navbar_top" class="navbar navbar-expand-lg navbar-dark bg-dark">
                <%-- <a href="<spring:url value='/home'/>"><img src='<spring:url value = "/images/logo_img.png"/>' width="110" height="110" class="d-inline-block align-top" alt="" loading="lazy"></a>
                <a class="navbar-brand navBarTitle" href="<spring:url value='/home'/>">Atomic Bear</a> --%>
                <a href="<spring:url value='/'/>"><img src='<spring:url value = "/images/logo_title.png"/>' width="260" height="110" class="d-inline-block align-top" alt="" loading="lazy"></a>
                <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>
                <div class="collapse navbar-collapse" id="navbarSupportedContent">
                    <ul class="navbar-nav mr-auto">
                        <!--<li class="nav-item active">
                            <a class="nav-link navBarElementStyle" href="#">Accueil <span class="sr-only">(current)</span></a>
                        </li>-->
                        <li class="nav-item dropdown">
                            <a class="nav-link dropdown-toggle navBarElementStyle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                <spring:message code="catalog" />
                            </a>
                            <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                                <a class="dropdown-item" href="<spring:url value='/shop/proteins'/>">${proteins}</a>
                                <a class="dropdown-item" href="<spring:url value='/shop/muscledev'/>">${muscleDev}</a>
                                <a class="dropdown-item" href="<spring:url value='/shop/energy'/>">${energy}</a>
                                <a class="dropdown-item" href="<spring:url value='/shop/fatBurners'/>">${fatBurners}</a>
                                <a class="dropdown-item" href="<spring:url value='/shop/vitamins'/>">${vitamins}</a>
                                <a class="dropdown-item" href="<spring:url value='/shop/snackAndDrinks'/>">${snackAndDrinks}</a>
                                <div class="dropdown-divider"></div>
                                <a class="dropdown-item" href="<spring:url value='/shop/accessories'/>">${accessories}</a>
                            </div>
                        </li>
                        <li class="nav-item dropdown">
                            <a class="nav-link dropdown-toggle navBarElementStyle" href="#" <%-- id="navbarDropdown" --%> role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                <spring:message code="language" />
                            </a>
                            <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                                <a class="dropdown-item" href="${localeFr}"><spring:message code="frenchLanguage" /> <img alt="fr" src='<spring:url value="/images/lang/localeFr.png"/>' style="height: 18px; width: 25px" /></a>
                                <a class="dropdown-item" href="${localeEn}"><spring:message code="englishLanguage" /> <img alt="fr" src='<spring:url value="/images/lang/localeEn.png"/>' style="height: 20px; width: 20px" /></a>
                            </div>
                        </li>
                    </ul>
                    <!-- RIGHT ELEMENTS -->
                    <ul class="navbar-nav ml-auto">
                        <li class="nav-item">
                            <a class="nav-link navBarElementStyle" href="<spring:url value='/cart'/>"><spring:message code="basket" /> <span class="badge badge-pill badge-primary">${(cart.size() > 0 ? cart.size() : "")}</span></a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link navBarElementStyle" href="<spring:url value='/aboutUs'/>"><spring:message code="about" /></a>
                        </li>
                        <%-- <li>
                            <a class="nav-link navBarElementStyle" href="#">Test</a>
                        </li> --%>
                        <sec:authorize access="isAuthenticated()">
                            <li>
                                <a class="nav-link navBarElementStyle" href="<spring:url value='/logout'/>">
                                    <div class="text-center">
                                        <div>
                                            <spring:message code="logout" />
                                        </div>
                                        <div>
                                            <small>(${pageContext.request.userPrincipal.name})</small>
                                        </div>
                                    </div>
                                </a>
                            </li>
                        </sec:authorize>
                        <sec:authorize access="!isAuthenticated()">
                            <li>
                                <a class="nav-link navBarElementStyle" href="<spring:url value='/goToLogin'/>"><spring:message code="login" /></a>
                            </li>
                        </sec:authorize>
                    </ul>
                </div>
            </nav>
        </header>

        <main>
            <tiles:insertAttribute name = "main-content"/>
        </main>

        <%-- <footer class="footer-dark bg-dark">
            <div class="container text-center">
                <p>Suivez nous !</p>
                <a class="btn btn-social-icon btn-twitter" href="https://twitter.com/AtomicBearShop" target="_blank">
                    <span class="fab fa-twitter"></span>
                </a>
                <a class="btn btn-social-icon btn-github" href = "https://github.com/emmavdc/webshop-sportnutrition" target="_blank">
                    <span class="fab fa-github"></span>
                </a>
                <a class="btn btn-social-icon btn-facebook" href="https://www.facebook.com/Atomic-Bear-179050482751059/?modal=admin_todo_tour" target="_blank">
                    <span class="fab fa-facebook"></span>
                </a>
                <p> Copyright &copy; Sohet Dylan & Vandecasteele Emma - 2020 - All right Reserved</p>
            </div>
        </footer> --%>

        <!-- Footer -->
        <footer class="page-footer footer-dark pt-4 bg-dark">

            <!-- Footer Elements -->
            <div class="container">

                <!-- Social buttons -->
                <%--
                <ul class="list-unstyled list-inline text-center">
                    <!-- <li class="list-inline-item">
                        <a class="btn-floating btn-fb mx-1" href="https://www.facebook.com/Atomic-Bear-179050482751059">
                            <i class="fab fa-facebook-f"> </i>
                        </a> -->
                        <!-- <a class="btn-floating btn-lg btn-fb" type="button" role="button"><i class="fab fa-facebook-f"></i></a> -->
                        <!-- <a class="btn-floating btn-lg btn-fb waves-effect waves-light" type="button" role="button"><i class="fab fa-facebook-f"></i></a> -->
                    </li>
                    <li class="list-inline-item">
                        <a class="btn-floating btn-tw mx-1" href="https://twitter.com/AtomicBearShop">
                            <i class="fab fa-twitter"> </i>
                        </a>
                    </li>
                    <li class="list-inline-item">
                        <a class="btn-floating btn-git mx-1" href="https://github.com/emmavdc/webshop-sportnutrition">
                            <i class="fab fa-github"> </i>
                        </a>
                    </li>
                </ul>
                --%>
                <!-- Social buttons -->

                <!-- Social buttons -->
                <ul class="list-unstyled list-inline text-center">
                    <li class="list-inline-item ">
                        <a class=" mx-1" href="https://www.facebook.com/Atomic-Bear-179050482751059">
                            <div class="bg-logo bg-logo-fb">
                                <img class="social-logo" src='<spring:url value = "/images/social/fb.png"/>' alt="Facebook" >
                            </div>
                        </a>
                    </li>
                    <li class="list-inline-item ">
                        <a class="btn-floating btn-tw mx-1" href="https://twitter.com/AtomicBearShop">
                            <div class="bg-logo bg-logo-tw">
                                <img class="social-logo" src='<spring:url value = "/images/social/tw.png"/>' alt="Twitter" >
                            </div>
                        </a>
                    </li>
                    <li class="list-inline-item ">
                        <a class="btn-floating btn-git mx-1" href="https://github.com/emmavdc/webshop-sportnutrition">
                            <div class="bg-logo bg-logo-git">
                                <img class="social-logo" src='<spring:url value = "/images/social/git.png"/>' alt="Github" >
                            </div>
                        </a>
                    </li>
                </ul>
                <!-- Social buttons -->

            </div>
            <!-- Footer Elements -->

            <!-- Copyright -->
            <div class="copyright text-center py-3">Copyright Sohet Dylan & Vandecasteele Emma - 2020 - All right Reserved</div>
            <!-- Copyright -->

        </footer>
    </body>
</html>