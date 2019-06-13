<%-- 
    Document   : index
    Created on : Apr 24, 2019, 12:36:23 PM
    Author     : frede
--%>

<%@page import="DBAccess.Order"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <jsp:include page='siteHeaderLogIn.jsp'></jsp:include>
        <%--
        <form action="FrontController" method="post">
            Email:<input type="text" name="email"/><br/><br/>
            Password:<input type="password" name="password"/><br/><br/>
            <input type="hidden" name="command" value="login">
            <input type="submit" value="login"/>  
        </form>
        --%>
        <div class="container-fluid">
  <div class="row no-gutter">
    <img src="https://i.imgur.com/kpHB4BY.png" 
                 alt="FOG Banner" style="float: top; margin: auto; display: table;" ></img>
    <div class="col-md-8 col-lg-6">
      <div class="login d-flex align-items-center py-5">
        <div class="container">
          <div class="row">
            <div class="col-md-9 col-lg-8 mx-auto">
              <h3 class="login-heading mb-4">Welcome back!</h3>
              <form action="FrontController" method="post">
                <div class="form-label-group">
                  <input type="text" name="email" id="email" class="form-control" placeholder="Email" required autofocus>
                  <label for="email">Email address</label>
                </div>

                <div class="form-label-group">
                  <input type="password" name="password" id="password" class="form-control" placeholder="Password" required>
                  <label for="password">Password</label>
                </div>
                  <button class="btn btn-lg btn-primary btn-block btn-login text-uppercase font-weight-bold mb-2" type="hidden" name="command" value="login" type="submit">Sign in</button>
              </form>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</div>
        <% String error = (String) request.getAttribute( "error");
           if ( error != null) { 
               out.println("<H2>Error!!</h2>");
               out.println(error);
           }
        %>
    </body>
</html>
