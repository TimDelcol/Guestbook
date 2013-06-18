<%-- 
    Document   : newmessageform
    Created on : Jun 18, 2013, 11:24:05 AM
    Author     : Roel_Storms
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!doctype html>
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <title>Registration</title>
</head>
<body>
  <form:form method="post" action="newmessageform.htm" commandName="MessageClass">
    <table>
      <tr>
        <td>Username <font color="red"><form:errors path="title" /></font></td>
      </tr>
      <tr>
        <td><form:input path="title" /></td>
      </tr>
      <tr>
        <td>Email <font color="red"><form:errors path="body" /></font></td>
      </tr>
      <tr>
        <td><form:input path="body" /></td>
      </tr>
      <tr>
      <tr>
        <td><input type="submit" value="Submit" /></td>
      </tr>
    </table>
  </form:form>
</body>
</html>