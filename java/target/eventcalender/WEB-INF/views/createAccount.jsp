<%@ include file="header.jsp"%>
<div class="w3-content bodyDiv">
    <h1>Create account</h1>
    <form method="get" action="doCreateAccount"  onsubmit="return checkPasswords();">
        <div class="form-group">
            <input class="form-control" type="text" name="username" placeholder="username">
        </div>
        <div class="form-group">
            <input class="form-control" type="password" name="password" placeholder="password" id="password">
        </div>
        <div class="form-group">
            <input class="form-control" type="password" name="passwordConfirm" placeholder="password confirm" id="passwordConfirm">
        </div>
        <!--Retype password for confirmation -->
        <div class="form-group">
            <a href="login" class="btn btn-default btn-md">Back</a>
            <input type="submit" value="Create" class="btn btn-info btn-md">
        </div>
    </form>
    <c:if test="${creationFailed}">
        ${accountError}
    </c:if>
</div>
<script>
    function checkPasswords() {
        var pw = document.getElementById("password").value;
        var confirmPw = document.getElementById("passwordConfirm").value;

        if (pw !== confirmPw) {
            alert("Passwords don't match");
            return false;
        } else {
            return true;
        }
    }
</script>
<%@ include file="footer.jsp"%>