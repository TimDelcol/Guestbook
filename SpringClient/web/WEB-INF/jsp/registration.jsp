<%-- 
    Document   : nameView
    Created on : Jun 8, 2013, 3:20:17 PM
    Author     : Roel_Storms
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!doctype html>
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <title>My User Form!</title>
</head>
<body>
  <form:form method="post" action="registration.htm" commandName="User">
    <table>
      <tr>
        <td>Username: <font color="red"><form:errors path="username" /></font></td>
      </tr>
      <tr>
        <td><form:input path="username" /></td>
      </tr>
      <tr>
        <td>Password: <font color="red"><form:errors path="password" /></font></td>
      </tr>
      <tr>
        <td><form:input path="password" /></td>
      </tr>
      <tr>
        <td><input type="submit" value="Submit" /></td>
      </tr>
    </table>
  </form:form>
</body>
</html>