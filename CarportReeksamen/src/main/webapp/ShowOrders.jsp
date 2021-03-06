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
<%-- Tjekker om en er logget ind, 
så hvis der ikke er en der logget ind sender den employee tilbage til index.jsp siden --%>
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
        <style>
            table {
                font-family: arial, sans-serif;
                border-collapse: collapse;
                width: 100%;
            }

            td, th {
                border: 1px solid #dddddd;
                text-align: left;
                padding: 8px;
            }

            tr:nth-child(even) {
                background-color: #dddddd;
            }
        </style>
        <table>
            <tr>
                <th>Order ID</th>
                <th>Employee ID</th>
                <th>Employee Username</th>
                <th>Customer ID</th>
                <th>Customer Name</th>
                <th>Customer Email</th>
                <th>Customer Address</th>
                <th>Customer Zip Code</th>
                <th>Total Price</th>
                <th>Order Details</th>  
            </tr>

            <%
                ArrayList<Order> orders = (ArrayList<Order>) request.getAttribute("orders");
                for (Order order : orders) {

                    out.println("<tr>");
                    out.print("<td>" + order.getOrder_Id() + "</td>");
                    out.print("<td>" + order.getEmployee_Id() + "</td>");
                    out.print("<td>" + logic.getEmployeeByID(order.getEmployee_Id()).getUsername() + "</td>");
                    out.print("<td>" + order.getCustomer_Id() + "</td>");
                    out.print("<td>" + logic.getCustomerByID(order.getCustomer_Id()).getName() + "</td>");
                    out.print("<td>" + logic.getCustomerByID(order.getCustomer_Id()).getEmail() + "</td>");
                    out.print("<td>" + logic.getCustomerByID(order.getCustomer_Id()).getAddress() + "</td>");
                    out.print("<td>" + logic.getCustomerByID(order.getCustomer_Id()).getZipCode() + "</td>");
                    out.print("<td>" + order.getTotalPrice() + "</td>");
                    out.println("<td>");
            %>
            <form action="FrontController" method="post">
                <input type="hidden" name="command" value="showOrderDetails">
                <input type="hidden" name="orderId" value="<%= order.getOrder_Id()%>" />
                <input type="submit" value="See Order Details">
            </form>
            <%

                    out.println("</td>");
                    out.println("</tr>");
                }
            %>
        </table>
        <br>
        <form action="FrontController" method="POST">
            <input type="hidden" name="command" value="selectMeasurements"/>
            <input type="submit" value="Return to Order page"/>
        </form>
    </body>
</html>
