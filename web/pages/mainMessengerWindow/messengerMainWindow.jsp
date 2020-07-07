<%@ page import="entity.User" %><%--
  Created by IntelliJ IDEA.
  User: aldub
  Date: 07.07.2020
  Time: 11:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Main Messenger Window</title>

    <style>
        html { overflow-x: hidden; }
        body{
            background: darkblue url("/pages/resources/exceptionBackgrownd.jpg");
            color: navy;
            background-attachment: fixed;
            background-repeat: repeat-x;
        }
    </style>

    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/pages/mainMessengerWindow/styles/MessengerMainWindowStyles.css">

</head>
<body>

    <%
        User user = (User)session.getAttribute("user");
        if(user == null){
            response.sendRedirect("/SignIn");
        }
    %>

    <div class="header-h1">
        <h1>Dav Messenger</h1>
    </div>

</body>
</html>
