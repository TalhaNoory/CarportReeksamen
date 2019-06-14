<%--<jsp:include page='/jsp/Header.jsp'></jsp:include>--%>

    <style>
        .container {
            width: 500px;
            clear: both;
        }

        .container input {
            width: 100%;
            clear: both;
        }
    </style>

    <div class="container">
        <h1>Login</h1>
        <form action="FrontController" method="POST">
            Email:<input type="text" name="email"/><br/><br/>
            Password:<input type="password" name="password"/><br/><br/>
            <input type="hidden" name="command" value="login">
            <input type="submit" value="login"/>
        </form>

        <h1> Register </h1>
        <form action="FrontController" method="POST">
            Email:<input type="text" name="email"/><br/><br/>
            Password:<input type="password" name="password"/><br/><br/>
            <input type="hidden" name="command" value="register">
            <input type="submit" value="register"/>
        </form>
    </div>

<%--<jsp:include page='/jsp/Footer.jsp'></jsp:include>--%>