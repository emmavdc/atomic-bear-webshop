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
        <link type="text/css" href= "<spring:url value='/css/bootstrap-social.css'/>" rel="Stylesheet" />

        <!--OUR CSS -->
        <link type="text/css" href= "<spring:url value='/css/template.css'/>" rel="Stylesheet" />
        <link type="text/css" href= "<spring:url value='/css/welcome.css'/>" rel="Stylesheet" />

        <title>${title}</title>
    </head>
    <body>
        <header class = "headerStyle">
            <!-- NAVBAR -->
            <nav class="navbar navbar-expand-lg navbar-light bg-light">
                <img src='<spring:url value = "/images/logo_icon.ico"/>' width="110" height="110" class="d-inline-block align-top" alt="" loading="lazy">
                <a class="navbar-brand navBarTitle" href="#">Atomic Bear</a>
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
                                Catalogue
                            </a>
                            <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                                <a class="dropdown-item" href="#">Action</a>
                                <a class="dropdown-item" href="#">Another action</a>
                                <div class="dropdown-divider"></div>
                                <a class="dropdown-item" href="#">Something else here</a>
                            </div>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link navBarElementStyle" href="#">Test</a>
                        </li>
                    </ul>
                    <!-- RIGHT ELEMENTS -->
                    <ul class="navbar-nav ml-auto">
                        <li class="nav-item">
                            <a class="nav-link navBarElementStyle" href="#">Panier</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link navBarElementStyle" href="#">Mon compte</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link navBarElementStyle" href="#">Langue</a>
                        </li>
                        <li>
                            <a class="nav-link navBarElementStyle" href="#">Test</a>
                        </li>
                    </ul>
                </div>
            </nav>
        </header>
        <main>
            <tiles:insertAttribute name = "main-content"/>
        </main>
        <footer class="footer">
            <div>
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
        </footer>
    </body>
</html>