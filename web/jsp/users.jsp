<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<html>
<head>
    <title>Title</title>
    <link href="/css/styles.css" rel="stylesheet" type="text/css">
</head>
<body>
<div class="form-style-2">
    <div class="form-style-2-heading">
        Already registered!
    </div>
    <table>
        <tr>
            <th>First Name</th>
        </tr>
        <c:forEach items="${usersFromServer}" var="user">
            <tr>
                <td>${user.firstName}</td>
                <td>${user.adress}</td>
            </tr>
        </c:forEach>
    </table>
    <a href="/jsp/addUser.jsp">Create new person</a>
</div>
</body>
</html>
