<%--
  Created by IntelliJ IDEA.
  User: aldub
  Date: 07.07.2020
  Time: 11:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Sign Up</title>

    <style>
        html { overflow-x: hidden; }
        body{
            background: darkblue url("/pages/resources/backgrownd.png");
            color: navy;
            background-attachment: fixed;
            background-repeat: repeat-x;
        }
    </style>

    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/pages/signUp/styles/SignUpStyles.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/pages/resources/styles/GeneralPageStyle.css">

</head>
<body>
<form name="signUpForm" action="${pageContext.request.contextPath}/SignUp" method="post">

    <div class="header-h1">
        <h1>Dav Messenger</h1>
    </div>

    <div id="rectangle"></div>

    <div class="input-field">
        <p><label >
            <input type="text" name="login" placeholder="Login"/>
        </label></p>
        <p><label>
            <input type="password" name="password" placeholder="Password" />
        </label></p>
        <p><label>
            <input type="password" name="repeatPassword" placeholder="Repeat password" />
        </label></p>
    </div>

    <div class="buttons">
        <div class="ccd"><button name="signUpButton" class="ddott">Sign Up</button></div>
    </div>

</form>
</body>
</html>