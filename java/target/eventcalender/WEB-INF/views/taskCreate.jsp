<%@include file="header.jsp" %>
<div class="w3-content bodyDivAdd">
    <h1>Add new task</h1>
    <form action="taskCreate">
        <div class="form-group">
            <label class="label label-info">Subject </label>
            <input class="form-control" name="subject" required>
        </div>
        <div class="form-group">
            <label class="label label-info">Description</label>
            <input class="form-control" name="description">
        </div>
        <div class="form-group">
            <label class="label label-info">Estimated duration </label>
            <input  class="form-control" name="estimated">
        </div>
        <div class="form-group">
            <label class="label label-info">Fixed duration </label>
            <input class="form-control" name="duration">
        </div>
        <div class="form-group">
            <input type="checkbox" name="finished" id="finished" autocomplete="off" />
            <div class="btn-group">
                <label for="finished" class="btn btn-default">
                    <span class="glyphicon glyphicon-ok"></span>
                    <span></span>
                </label>
            </div>
        </div>
        <div class="form-group">
            <a href="task" class="btn btn-default">Back</a>
            <input class="btn btn-info" type="submit" value="Create task">
        </div>
    </form>
</div>
<%@include file="footer.jsp" %>
