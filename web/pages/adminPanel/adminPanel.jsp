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

    <div class="header-h1">
        <h1>Dav Messenger</h1>
    </div>

    <div id="usersTable">

        <table>
            <tr>
                <th>User login</th>
                <th>User password</th>
                <th>Delete</th>
            </tr>


            <%
                for (User user : (List<User>) request.getAttribute("users")){
            %>

            <tr>
                <td> <%= user.getLogin() %> </td>
                <td> <%= user.getPassword() %> </td>
                <td> Button would be hear </td>
            </tr>

            <%}%>

        </table>

    </div>


</body>
</html>
