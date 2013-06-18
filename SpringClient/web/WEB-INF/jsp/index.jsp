
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
  <head><title>Distributed Applications - Guestbook</title></head>
  <body>
    <h1>Guestbook</h1>
    <table>
      <tr>
        <td>
          <a href="${contextPath}/SpringClient/index.htm">Home</a>
        </td>
        <td>
          <a href="${contextPath}/SpringClient/login.htm">Login</a>
        </td>
        <td>
          <a href="${contextPath}/SpringClient/registration.htm">Register</a>
        </td>
        <td>
          <a href="${contextPath}/SpringClient/newmessageform.htm">Post Message</a>
        </td>
        <td>
          <a href="${contextPath}/SpringClient/flowpage1.htm">Flow Pages</a>
        </td>
      </tr>
    </table>
        ${messages}
  </body>
</html>