<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="w3-content bodyDivTable">
    <table class="table table-condensed table-responsive">
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
    <a href="events" class="btn btn-default btn-md">Back</a>
    <a href="edit?id=${event.id}" class="btn btn-info btn-md">Edit</a>
    <a href="delete" class="btn btn-danger btn-md">Delete</a>
</div>
