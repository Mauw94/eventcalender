<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="w3-content bodyDivAdd">
    <h1>Editing item: ${event.subject}</h1>
    <form method="post" action="doEdit">
        <div class="form-group">
            <label class="label label-info">Subject</label>
            <input type="text" value="${event.subject}" placeholder="subject" name="subject" class="form-control">
        </div>
        <div class="form-group">
            <label class="label label-info">Description</label>
            <input type="text" value="${event.description}" placeholder="description" name="description" class="form-control">
        </div>
        <div class="form-group">
            <label class="label label-info">Note</label>
            <input type="text" value="${event.note}" placeholder="note" name="note" class="form-control">
        </div>
        <div class="form-group">
            <label class="label label-info">Date</label>
            <input type="date" value="${event.date}" placeholder="date" name="date" class="form-control">
        </div>
        <div class="form-group">
            <label class="label label-info">Time</label>
            <input type="time" value="${event.time}" placeholder="time" name="time" class="form-control">
        </div>
        <div class="form-group">
            <input type="hidden" name="id" value="${event.id}">
            <a href="details?id=${event.id}" class="btn btn-default btn-md">Back</a>
            <input type="submit" value="Confirm Changes" class="btn btn-info btn-md">
        </div>
    </form>
    <p>${errorEdit}</p>
</div>