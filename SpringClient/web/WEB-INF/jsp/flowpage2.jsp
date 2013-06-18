<%-- 
    Document   : flowpage2
    Created on : 18-Jun-2013, 16:00:37
    Author     : matthias
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Flow Page 2</title>
  </head>
  <body>
    <h1>This is flow page 2</h1>
    <table>
      <tr>
        <td>
          <a href="${flowExecutionUrl}&_eventId=flow1link">Flow Page 1</a>
        </td>
        <td>
          <a href="${flowExecutionUrl}&_eventId=flow3link">Flow Page 3</a>
        </td>
        <td>
          <a href="${flowExecutionUrl}&_eventId=homeLink">Home</a>
        </td>
      </tr>
    </table>
  </body>
</html>
