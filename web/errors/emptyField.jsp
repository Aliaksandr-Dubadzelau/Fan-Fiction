<%--
  Created by IntelliJ IDEA.
  User: aldub
  Date: 06.07.2020
  Time: 22:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Empty field</title>

    <style>
        html { overflow-x: hidden; }
        body{
            background: darkblue url("/resources/exceptionBackgrownd.jpg");
            color: navy;
            background-attachment: fixed;
            background-repeat: repeat-x;
        }
    </style>

    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/errors/styles/Styles.css">

</head>
<body>

<div class="header-h1">
    <h1>Dav Messenger</h1>
</div>

<div id="not-found">
    <h2>Some fields is empty</h2>
</div>

</body>
</html>
