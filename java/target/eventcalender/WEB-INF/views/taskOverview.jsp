<%@ include file="header.jsp"%>
<div class="w3-content bodyDivTable">
    <h1>Tasks</h1>
    <table class="table table-condensed table-responsive">
        <thead>
        <tr class="active">
            <th class="info">Subject</th>
            <th class="info">Duration</th>
            <th class="info">Estimated</th>
            <th class="info">Details</th>
            <th class="info">Delete?</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${taskList}" var="task" >
            <tr>
                <td>${task.subject}</td>
                <td>${task.duration}</td>
                <td>${task.estimated}</td>
                <td><a href="?id=${task.id}" class="btn btn-sm btn-success">Details</a></td>
                <td><a href="?id=${task.id}" class="btn btn-danger btn-sm">Delete</a></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <hr color="black">
    <a href="addTask" class="btn btn-info btn-md">Add new task</a>
</div>
<%@ include file="footer.jsp"%>