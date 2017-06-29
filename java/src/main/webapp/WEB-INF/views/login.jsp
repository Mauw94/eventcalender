<%--
  Created by IntelliJ IDEA.
  User: Maurits
  Date: 29-6-2017
  Time: 17:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div id="bodyDiv">
    <h1>Please login below</h1>
    <form method="get" action="doLogin">
        <input type="text" name="username">
        <input type="password" name="password">
        <input type="submit" name="submit" value="Login">
    </form>

    <p>${errorMessage}</p>
</div>
