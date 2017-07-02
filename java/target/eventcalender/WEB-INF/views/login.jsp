<%--
  Created by IntelliJ IDEA.
  User: Maurits
  Date: 29-6-2017
  Time: 17:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div class="w3-content bodyDiv">
    <h1>Please login below</h1>
    <form method="get" action="doLogin">
        <div class="form-group">
            <input class="form-control" type="text" name="username" placeholder="username">
        </div>
        <div class="form-group">
            <input class="form-control" type="password" name="password" placeholder="password">
        </div>
        <div class="form-group">
            <input type="submit" name="submit" value="Login" class="btn btn-default">
            <a href="/eventcalender/createAccount" class="btn btn-default">Create Account</a>
        </div>
    </form>
    <c:if test="${empty logedinUser}">
        ${errorMessage}
    </c:if>
</div>
