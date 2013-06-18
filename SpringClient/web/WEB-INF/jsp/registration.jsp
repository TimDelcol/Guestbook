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
<!--
  <script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.5.2/jquery.min.js"></script>
  <script type="text/javascript" src="http://www.kelvinluck.com/assets/jquery/datePicker/v2/demo/scripts/date.js"></script>

    <script type="text/javascript" src="http://www.kelvinluck.com/assets/jquery/datePicker/v2/demo/scripts/jquery.datePicker.js"></script>

  <link rel="stylesheet" type="text/css" media="screen" href="http://www.kelvinluck.com/assets/jquery/datePicker/v2/demo/styles/datePicker.css">
-->
<link rel="stylesheet" href="js/jquery-ui-1.10.3.custom/css/ui-lightness/jquery-ui-1.10.3.custom.css" />
<script src="js/jquery-1.10.1.js"></script>
<script src="js/jquery-ui-1.10.3.custom/js/jquery-ui-1.10.3.custom.js"></script>

  <script type="text/javascript" src="js/jquery-ui-1.10.3.custom/development-bundle/ui/jquery.ui.datepicker.js"></script>

  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  
<script type="text/javascript" charset="utf-8">
$(function() {
    $( "#dateOfBirth" ).datepicker();
})
		</script>

            
  <title>Registration</title>
</head>
<body>
  <form:form method="post" action="registration.htm" commandName="TempUser">
    <table>
      <tr>
        <td>Username <font color="red"><form:errors path="username" /></font></td>
      </tr>
      <tr>
        <td><form:input path="username" /></td>
      </tr>
      <tr>
        <td>Email <font color="red"><form:errors path="email" /></font></td>
      </tr>
      <tr>
        <td><form:input path="email" /></td>
      </tr>
      <tr>
        <td>Password <font color="red"><form:errors path="password" /></font></td>
      </tr>
      <tr>
        <td><form:password path="password" /></td>
      </tr>
      <tr>
        <td>Date of birth ("dd/MM/yyyy") <font color="red"><form:errors path="dateOfBirth"/></font></td>
      </tr>
      <tr>
        <td><form:input path="dateOfBirth" /></td>
      </tr>
      <tr>
        <td><input type="submit" name="_eventId_submit" value="Submit" /></td>
      </tr>
    </table>
  </form:form>
</body>
</html>