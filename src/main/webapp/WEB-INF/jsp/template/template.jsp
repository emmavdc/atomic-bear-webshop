<%@ page pageEncoding = "UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ include file ="../include/importTags.jsp" %>
<%@ taglib uri ="http://tiles.apache.org/tags-tiles" prefix="tiles" %>

<html>
    <head>
        <link type="text/css" href= "<spring:url value='/css/template.css'/>" rel="Stylesheet" />
        <title>${title}</title>
    </head>
    <body>
        <header>
            <!--<img style = "width: 100px; height: 100px"src='<spring:url value = "/images/test.PNG"/>'/>-->
            <div>
                <p>Test dans le header</p>
            </div>
        </header>
        <main>
            <tiles:insertAttribute name = "main-content"/>
        </main>
        <footer>
            <div>
                <p>Suivez nous !</p>
                <a href="https://www.facebook.com/Atomic-Bear-179050482751059/?modal=admin_todo_tour">Atomic Bear</a>
                <a href="https://twitter.com/AtomicBearShop">Atomic Bear</a>
                <p> Copyright &copy; Sohet Dylan & Vandecasteele Emma - 2020 - All right Reserved</p>
            </div>
        </footer>
    </body>
</html>