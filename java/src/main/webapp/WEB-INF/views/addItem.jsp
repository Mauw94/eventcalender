<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="w3-content bodyDivAdd">
    <h1>Add new item</h1>
    <form method="get" action="/eventcalender/doAdd">
        <div class="form-group">
            <label class="label label-info">Subject</label>
            <input type="text" class="form-control" name="subject" required>
        </div>
        <div class="form-group">
            <label class="label label-info">Description</label>
            <input type="text" class="form-control" name="description" required>
        </div>
        <div class="form-group">
            <label class="label label-info">Date</label>
            <input type="date" class="form-control" name="date">
        </div>
        <div class="form-group">
            <label class="label label-info">Time</label>
            <input type="time" class="form-control" name="time">
        </div>
        <div class="form-group">
            <label class="label label-info">Note</label>
            <input type="text" class="form-control" name="note" placeholder="optional">
        </div>
        <div class="form-group">
            <a href="/eventcalender/events" class="btn btn-default btn-md">Back</a>
            <input type="submit" class="btn btn-info btn-md" value="Add">
        </div>
    </form>
</div>
