<%-- 
    Document   : registrationview
    Created on : Jun 16, 2013, 6:39:36 PM
    Author     : Roel_Storms
--%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
       <%-- <spring:nestedPath path="name"> --%>
            <form action="" method="post">
                Name:
               <%-- <spring:bind path="value">--%>
                    <input type="text" name="name" value="name">
               <%-- </spring:bind>--%>
                <input type="submit" value="OK">
            </form>
       <%-- </spring:nestedPath>--%>
    </body>
</html>
