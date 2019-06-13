<%-- 
    Document   : carportSelectPage
    Created on : Apr 25, 2019, 2:55:24 PM
    Author     : frede
--%>

<%@page import="DBAccess.Employee"%>
<%@page import="DBAccess.Order"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<% if (null == session.getAttribute("employee")) {
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }
    Employee employee = (Employee) session.getAttribute("employee");
%>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <jsp:include page='siteHeader.jsp'></jsp:include>
        <style>
            <% if (!employee.isAdmin()) {
            %>
            #materials {display:none;}
            <%}
            %>
        </style>
        <h1>Main Menu</h1>
        <%  Order newestOrder = (Order) request.getAttribute("newestorder");
            if (null != newestOrder) {
                out.println("<h3><i>You just created an order with ID: " + newestOrder.getOrderId() + "</i></h3>");
            }
        %>
        <form action="FrontController" method="post">
            <h3> Select premade carport </h3>
            <select id="premadeCarport" name="premadeCarport">
                <option value="1">CARPORT ENKELT 3,60X7,20M CAR01HR MED REDSKABSRUM 3,60X2,20M</option>
                <option value="2">CARPORT ENKELT 3,60X5,40M CAR01H HØJ REJSNING</option>
                <option value="3">CARPORT ENKELT 3,00X6,00 M CAR01R FLADT TAG MED REDSKABSRUM 1,50X2,70 M</option>
            </select><br/><br/>
            <input type="hidden" name="command" value="carportSelectPremade">
            <input type="submit" value="Submit"/>
        </form> </br>
        <form action="FrontController" method="post">
            <h3> Select for carport with custom values </h3>
            Roof type:<select id="rooftype" name="rooftype">
                <option value="fladt">Flat roof</option>
                <option value="med rejsning">Roof with height</option>
            </select><br/><br/>
            Shed:<select id="shed" name="shed">
                <option value="shed">With shed</option>
                <option value="noshed">No shed</option>
            </select><br/><br/>
            <input type="hidden" name="command" value="carportSelectCustom">
            <input type="submit" value="Submit"/> 
        </form> </br>
        <h3>Go to see all orders page</h3>
        <form action="FrontController" method="post">
            <input type="hidden" name="command" value="goToSeeOrders"/>
            <input type="submit" value="Go to see orders page"/>
        </form> <br>
        <div id="materials">
            <h3>Go to materials page</h3>
            <form action="FrontController" method="post">
                <input type="hidden" name="command" value="goToMaterials"/>
                <input type="submit" value="Go to materials page"/>
            </form> <br>
        </div>
        <h3>Søg efter kunde (E-mail)</h3>
        <br/>
        <form name="SearchCustomer" action="FrontController" method="POST">
            <input type="text" name="customeremail" value="Søg">
            <input type="hidden" name="command" value="SearchCustomers">
            <input type="submit" value="Søg">
        </form>

        <br/>

        <form name="Customers" action="FrontController" method="POST">
            <input type="hidden" name="command" value="Customers">
            <input type="submit" value="See All Customers">
        </form>

    </body>
</html>
