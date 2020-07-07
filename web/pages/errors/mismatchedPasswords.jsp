<%--
  Created by IntelliJ IDEA.
  User: aldub
  Date: 01.07.2020
  Time: 14:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Mismatched passwords</title>

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
        <h1>Dav Messenger</h1>
    </div>

    <div id="error-message-position">
        <h2>Mismatched passwords</h2>
    </div>

</body>
</html>
