<%-- 
    Document   : login
    Created on : 18-Jun-2013, 11:04:16
    Author     : matthias
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!doctype html>
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <title>Login</title>
</head>
<body>
  <form:form method="post" action="login.htm" commandName="LoginUser">
    <table>
      <tr>
        <td>Username <font color="red"><form:errors path="username" /></font></td>
      </tr>
      <tr>
        <td><form:input path="username" /></td>
      </tr>
      <tr>
        <td>Password <font color="red"><form:errors path="password" /></font></td>
      </tr>
      <tr>
        <td><form:password path="password" /></td>
      </tr>
      <tr>
        <td><input type="submit" name="_eventId_submit" value="Submit" /></td>
      </tr>
    </table>
  </form:form>
</body>
</html>