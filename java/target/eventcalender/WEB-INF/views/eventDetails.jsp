<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="w3-content bodyDivTable">
    <table class="table table-condensed table-responsive">
        <thead>
        <tr>
            <th>ID</th>
            <th>Subject</th>
            <th>Description</th>
            <th>Note</th>
            <th>Date</th>
            <th>Time</th>
        </tr>
        </thead>
        <tbody>
        <tr>
            <td>${event.id}</td>
            <td>${event.subject}</td>
            <td>${event.description}</td>
            <td>${event.note}</td>
            <td>${event.date}</td>
            <td>${event.time}</td>
        </tr>
        </tbody>
    </table>
    <a href="/eventcalender/events" class="btn btn-default">Back</a>
    <p>${eventError}</p>
    <p>a button with EXPAND that opens another form view using javascript, with edit options and bigger overview</p>
</div>
