<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<p>Overview of all agenda items</p>
<div class="w3-content bodyDiv">
    <table class="table table-condensed table-responsive">
        <thead>
        <tr>
            <th>ID</th>
            <th>Subject</th>
            <th>Date</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${eventList}" var="event" >
            <tr>
                <td>${event.id}</td>
                <td>${event.subject}</td>
                <td>${event.date}</td>
                <td>
                    <a href="/evencalender/details?id=${event.id}">Show Details</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
