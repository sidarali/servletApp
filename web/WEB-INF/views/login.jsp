<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<p>Today <%= new java.util.Date() %></p>
<p><font color="red">${errorMessage}</font></p>
<form action="LoginServlet" method="POST">
    <p> Name : <input name = "name" type="text" /> <input type="submit" />
    </p>
    <p> Password : <input name="password" type="password" />
    </p>
</form>

<div>
    <form action="RegisterServlet" method="GET">
        <input class ="button-main-page" type="submit" value="Регистрация"/>
    </form>
</div>

</body>
</html>