<%--
  Created by IntelliJ IDEA.
  User: Natalia
  Date: 09.10.16
  Time: 20:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="style/bootstrap.min.css">
    <link rel="stylesheet" href="style/loginStyle.css">
    <script src="js/jquery-3.1.1.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <title>LoginServlet</title>
</head>
<body>
<div class="background-image">

</div>
<div id ="screen">
    
<div id="login_container" class="container">

    <form id="login_form" class="form-signin" role="form" action="./login" method="post">
        <h2 class="form-signin-heading">Please sign in</h2>
        <input type="text" class="form-control" name="username" placeholder="User Name" required autofocus>
        <input type="password" class="form-control" name="password" placeholder="Password" required>

        <button class="btn btn-lg btn-primary btn-block" type="submit" value="Login">Login</button>
    </form>

    <form id="registration_form" action="./registration" method="get">
        <button class="btn btn-lg btn-primary btn-block" type="submit" value="Registration">Registration</button>
        <%--<input type="submit" value="Registration">--%>
    </form>
</div>
</div>






</body>
</html>
