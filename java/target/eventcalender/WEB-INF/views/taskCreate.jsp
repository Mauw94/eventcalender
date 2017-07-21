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
            <label class="label label-info">Estimated time </label>
            <input class="form-control" name="estimated">
        </div>
        <div class="form-group"></div>
        <div class="form-group"></div>
    </form>
</div>
<%@include file="footer.jsp" %>
