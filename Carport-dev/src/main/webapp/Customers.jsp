<%-- 
    Document   : Customers
    Created on : 24-Apr-2019, 19:49:34
    Author     : frederik
--%>

<%@page import="DBAccess.Customer"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<% if (null == session.getAttribute("employee")) {
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }
%>
        <jsp:include page='siteHeader.jsp'></jsp:include>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <h1>Kunde oversigt</h1>
        


        <form name="SearchCustomer" action="FrontController" method="POST">
            <input type="text" name="customeremail" value="Søg">
            <input type="hidden" name="command" value="SearchCustomers">
            <input type="submit" value="Søg">
        </form>


        <br/><br/>

        <form name="Customers" action="FrontController" method="POST">
            <input type="hidden" name="command" value="Customers">
            <input type="submit" value="See All Customers">
        </form>
        
        <br/><br/>
        <form action="FrontController" method="post">
            <input type="hidden" name="command" value="goToCarportSelect"/>
            <input type="submit" value ="Go back to menu"/>
        </form>
    </body>

</html>
