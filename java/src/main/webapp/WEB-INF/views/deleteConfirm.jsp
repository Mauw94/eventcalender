<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="w3-content bodyDiv">
    <h1>Are you sure you want to delete ${event.subject}?</h1>
    <a href="doDelete?id=${event.id}" class="btn btn-danger btn-sm">Yes</a>
    <a href="events" class="btn btn-success btn-sm">No</a>
</div>
