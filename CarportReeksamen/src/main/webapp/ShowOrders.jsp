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
                <th>Employee username</th>
                <th>Customer ID</th>
                <th>Customer name</th>
                <th>Total price</th>
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
                    out.print("<td>" + order.getTotalPrice() + "</td>");

                    out.println("</tr>");

                }
            %>
        </table>
        <br>
        <form action="FrontController" method="POST">
            <input type="hidden" name="command" value="selectMeasurements"/>
            <input type="submit" value="Return to Order page"/>
        </form>
<!--    <br>
        <form action="FrontController" method="POST">
            <input type="hidden" name="command" value="showMaterials"/>
            <input type="submit" value="Return to Material page"/>
        </form> -->
    </body>
</html>
