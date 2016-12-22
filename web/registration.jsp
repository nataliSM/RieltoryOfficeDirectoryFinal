<%--
  Created by IntelliJ IDEA.
  User: Natalia
  Date: 10.10.16
  Time: 12:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="style/bootstrap.min.css">
    <link rel="stylesheet" href="style/registration_style.css">
    <script src="js/jquery-3.1.1.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <title>RegistrationServlet</title>
</head>
<body>
<div class="background-image">

</div>
<div id ="screen">


<form id="registration_form" action="./registration" method="post">
    <h2 class="form-signin-heading">Your registration</h2>
    <input type="text" class="form-control" name="username" placeholder="User Name" required autofocus>
    <input type="password" class="form-control" name="password" placeholder="Password" required>

    <button class="btn btn-lg btn-primary btn-block" type="submit">Registration</button>



</form>

</div>
</body>
</html>
