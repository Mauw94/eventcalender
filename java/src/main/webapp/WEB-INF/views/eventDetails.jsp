<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="w3-content bodyDivTable">
    <table class="table table-striped table-responsive">
        <thead>
        <tr class="info">
            <th class="info">Subject</th>
            <th class="info">Description</th>
            <th class="info">Note</th>
            <th class="info">Date</th>
            <th class="info">Time</th>
        </tr>
        </thead>
        <tbody>
        <tr>
            <td>${event.subject}</td>
            <td>${event.description}</td>
            <td>${event.note}</td>
            <td>${event.date}</td>
            <td>${event.time}</td>
        </tr>
        </tbody>
    </table>
    <a href="/eventcalender/events" class="btn btn-default btn-md">Back</a>
    <a href="/eventcalender/add" class="btn btn-default btn-md">Add</a>
    <a href="/eventcalender/edit" class="btn btn-default btn-md">Edit</a>
    <p>${eventError}</p>
</div>
