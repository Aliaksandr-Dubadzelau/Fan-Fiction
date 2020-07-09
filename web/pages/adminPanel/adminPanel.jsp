<%@ page import="entity.User" %>
<%@ page import="java.util.List" %>
<%@ page import="java.io.IOException" %><%--
  Created by IntelliJ IDEA.
  User: aldub
  Date: 07.07.2020
  Time: 16:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Admin panel</title>

    <style>
        html { overflow-x: hidden; }
        body{
            background: darkblue url("/pages/resources/exceptionBackgrownd.jpg");
            color: navy;
            background-attachment: fixed;
            background-repeat: repeat-x;
        }
    </style>

    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/pages/adminPanel/styles/AdminPanelStyle.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/pages/resources/styles/GeneralPageStyle.css">
</head>
<body>
<form name="adminPanelForm" action="${pageContext.request.contextPath}/AdminPanel" method="post">
    <div class="header-h1">
        <h1>Dav - Fan fiction</h1>
    </div>

    <div id="usersTable">

        <table>
            <tr>
                <th>User login</th>
                <th>User password</th>
                <th>Delete</th>
            </tr>


            <%
                int id = 0;
                for (User user : (List<User>) request.getAttribute("users")){
            %>

            <tr>
                <td> <%= user.getLogin() %> </td>
                <td> <%= user.getPassword() %> </td>
                <td> <button name="delete" value=<%= id%>>Delete</button></td>
            </tr>

            <% id++;
                }%>

        </table>

    </div>


</body>
</html>
