<%--
  Created by IntelliJ IDEA.
  User: aldub
  Date: 08.07.2020
  Time: 13:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Unauthorized access</title>

    <style>
        html { overflow-x: hidden; }
        body{
            background: darkblue url("/pages/resources/exceptionBackgrownd.jpg");
            color: navy;
            background-attachment: fixed;
            background-repeat: repeat-x;
        }
    </style>

    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/pages/errors/styles/Styles.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/pages/resources/styles/GeneralPageStyle.css">

</head>
<body>

    <div class="header-h1">
        <h1>Dav - Fan fiction</h1>
    </div>

    <div id="error-message-position">
        <h2>Unauthorized access</h2>
    </div>

</body>
</html>
