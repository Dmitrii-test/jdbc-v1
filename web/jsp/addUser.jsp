<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link href="/css/styles.css" rel="stylesheet">
</head>
<body>
<div class="form-style-2">
    <div class="form-style-2-heading">
        <h1>Please add user</h1>
        <br>
    </div>
    <form method="post" action="/">
        <label for="first-name">First Name
            <input class="input-field" type="text" id="first-name" name="first-name">
        </label>
        <br>
        <label for="adress_tes">Adress
            <input class="input-field" type="text" id="adress_tes" name="adress_tes">
        </label>
        <br>
        <input type="submit" value="Add user">
    </form>
</div>
</body>
</html>