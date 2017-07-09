<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div class="w3-content bodyDiv">
    <h1>Create your account below</h1>
    <form method="get" action="doCreateAccount">
        <div class="form-group">
            <input class="form-control" type="text" name="username" placeholder="username">
        </div>
        <div class="form-group">
            <input class="form-control" type="password" name="password" placeholder="password">
        </div>
        <!--Retype password for confirmation -->
        <div class="form-group">
            <a href="login" class="btn btn-default btn-md">Back</a>
            <input type="submit" value="Create Account" class="btn btn-info btn-md">
        </div>
    </form>
    <c:if test="${creationFailed}">
        ${accountError}
    </c:if>
</div>
