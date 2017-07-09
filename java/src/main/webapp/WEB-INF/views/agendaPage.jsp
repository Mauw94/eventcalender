<%@ include file="header.jsp"%>
<div class="w3-content bodyDivTable">
    <h1>Welcome, ${logedinUser.userName}</h1>
    <table class="table table-condensed table-responsive">
        <thead>
        <tr class="active">
            <th class="info">Subject</th>
            <th class="info">Date</th>
            <th class="info">Time</th>
            <th class="info">Details</th>
            <th class="info">Delete?</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${eventList}" var="event" >
            <tr>
                <td>${event.subject}</td>
                <td>${event.date}</td>
                <td>${event.time}</td>
                <td><a href="details?id=${event.id}" class="btn btn-sm btn-success">Details</a></td>
                <td><a href="delete?id=${event.id}" class="btn btn-danger btn-sm">Delete</a></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <hr color="black">
    <a href="add" class="btn btn-info btn-md">Add new item</a>
</div>
<%@ include file="footer.jsp"%>