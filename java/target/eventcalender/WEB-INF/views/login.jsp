<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div class="w3-content bodyDiv ">
    <h1>Please login below</h1>
    <form method="get" action="doLogin">
        <div class="form-group">
            <input class="form-control" type="text" name="username" placeholder="username">
        </div>
        <div class="form-group">
            <input class="form-control" type="password" name="password" placeholder="password">
        </div>
        <div class="form-group">
            <input type="submit" name="submit" value="Login" class="btn btn-default btn-md">
            <a href="createAccount" class="btn btn-info btn-md">Create Account</a>
        </div>
    </form>
    <c:if test="${empty logedinUser}">
        ${errorMessage}
    </c:if>
</div>
