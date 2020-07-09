<%@ page import="entity.User" %>
<%@ page import="java.util.List" %>
<%@ page import="entity.Message" %><%--
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

    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/pages/fanFictionMainWindow/styles/FanFictionMainWindowStyles.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/pages/resources/styles/GeneralPageStyle.css">

</head>
<body>
    <form name="mainWindowForm" action="${pageContext.request.contextPath}/FanFictionMainWindow" method="post">

        <div class="header-h1">
            <h1>Dav - Fan fiction</h1>
        </div>

        <%
            for (Message message : (List<Message>) request.getAttribute("messages")) {
            %>


        <label>
            <textarea name="messenger" class="fanFiction" readonly><%=message.toString()%></textarea>
        <%}%>

            <textarea name="message" class="message" onload="" placeholder="Your fan fiction" autofocus ></textarea>
        </label>

        <% User user = (User) session.getAttribute("user");%>

        <label>
            <input type="submit" value=""/>
        </label>
    </form>
</body>
</html>
