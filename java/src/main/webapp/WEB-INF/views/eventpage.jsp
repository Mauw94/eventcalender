<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="w3-content bodyDiv">
    <h1>Welcome ${logedinUser.userName}</h1>
    <table class="table table-condensed table-responsive" id="hastoslide">
        <thead>
        <tr>
            <th>ID</th>
            <th>Subject</th>
            <th>Date</th>
            <th>Details</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${eventList}" var="event" >
            <tr>
                <td>${event.id}</td>
                <td>${event.subject}</td>
                <td>${event.date}</td>
                <td>
                    <a href="/eventcalender/details?id=${event.id}">Show Details</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <p>${eventError}</p>
</div>
