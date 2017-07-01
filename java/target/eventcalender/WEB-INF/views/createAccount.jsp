<%--
  Created by IntelliJ IDEA.
  User: Maurits
  Date: 1-7-2017
  Time: 14:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div id="bodyDiv">
    <h1>Create you account below: </h1>
    <form method="get" action="doCreateAccount">
        <input type="text" name="username" placeholder="username">
        <input type="password" name="password" placeholder="password">
        <!--Retype password for confirmation -->
        <input type="submit" value="Create" class="btn btn-default">
    </form>
    <c:if test="${creationFailed}">
        ${accountError}
    </c:if>
</div>
