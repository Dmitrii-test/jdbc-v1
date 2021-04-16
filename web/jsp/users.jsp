<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<html>
<head>
    <title>Title</title>
    <link href="/css/styles.css" rel="stylesheet">
</head>
<body>
<div class="form-style-2">
    <div class="form-style-2-heading">
        <h1>Already registered!</h1>
    </div>
    <br>
    <table>
        <tr>
            <th>First Name</th>
            <th>Adress</th>
        </tr>
        <c:forEach items="${usersFromServer}" var="user">
            <tr>
                <td>${user.firstName}</td>
                <td>${user.adress}<td>
                <td>
                <form:form method="DELETE" modelAttribute="id" action="${pageContext.request.contextPath}/${user.id}" >
                <input type="submit" value="Delete"/>
                </form:form>
                <td>
            </tr>
        </c:forEach>
    </table>
    <br>
    <a href="/jsp/addUser.jsp">Create new person</a>
</div>
</body>
</html>
