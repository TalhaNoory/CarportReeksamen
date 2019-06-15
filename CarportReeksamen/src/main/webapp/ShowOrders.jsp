<%-- 
    Document   : ShowOrders
    Created on : Jun 15, 2019, 5:32:57 PM
    Author     : Dhono
--%>

<%@page import="FunctionLayer.LogicFacadeImplementation"%>
<%@page import="java.util.ArrayList"%>
<%@page import="DataLayer.Order"%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%-- Spørgsmål  : Hvad gør denne if-statement, præcis? --%>
<%-- Svar       :                                      --%>
<% if (null == session.getAttribute("employee")) {
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }
    LogicFacadeImplementation logic = new LogicFacadeImplementation();
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <table>
            <tr>
                <th>Order ID</th>
                <th>Employee ID</th>
                <th>Employee username</th>
                <th>Customer ID</th>
                <th>Customer name</th>
            </tr>
        </table>
    <%
        ArrayList<Order> orders = (ArrayList<Order>) request.getAttribute("orders");
        for (Order order : orders) {

            out.print("<td>" + order.getOrder_Id() + "</td>");
            out.print("<td>" + order.getEmployee_Id() + "</td>");
            out.print("<td>" + logic.getEmployeeByID(order.getEmployee_Id()).getUsername() + "</td>");
            out.print("<td>" + order.getCustomer_Id() + "</td>");
            out.print("<td>" + logic.getCustomerByID(order.getCustomer_Id()).getName() + "</td>");
            
        }
    %>
    </body>
</html>
