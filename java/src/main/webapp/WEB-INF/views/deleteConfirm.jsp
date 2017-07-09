<%@ include file="header.jsp"%>
<div class="w3-content bodyDiv">
    <div style="text-align: center">
        <h2>Delete item ${event.subject}?</h2>
        <a href="doDelete?id=${event.id}" class="btn btn-danger btn-lg">Yes</a>
        <a href="events" class="btn btn-success btn-lg">No</a>
    </div>
</div>
<%@ include file="footer.jsp"%>