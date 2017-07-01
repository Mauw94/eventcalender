<%--
  Created by IntelliJ IDEA.
  User: Maurits
  Date: 29-6-2017
  Time: 17:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div id="bodyDiv">
    <h1>Please login below</h1>
    <form method="get" action="doLogin">
        <input type="text" name="username">
        <input type="password" name="password">
        <input type="submit" name="submit" value="Login" class="btn btn-default">
    </form>
    <c:if test="${empty logedinUser}">
        ${errorMessage}
    </c:if>
</div>
