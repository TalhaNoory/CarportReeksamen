<%-- 
    Document   : showAllOrdersPage
    Created on : Apr 25, 2019, 9:21:07 AM
    Author     : frede
--%>

<%@page import="FunctionLayer.LogicFacadeImplementation"%>
<%@page import="java.util.ArrayList"%>
<%@page import="DBAccess.Order"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<% if (null == session.getAttribute("employee")) {
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }
    LogicFacadeImplementation logic = new LogicFacadeImplementation();
%>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <jsp:include page='siteHeader.jsp'></jsp:include>
        <div class="row">
            <div class="col-sm-6">
                <script>
                    $(document).ready(function () {
                        $('#showAllOrdersPage').DataTable();
                    });
                </script>

                <table border="3" width="2" cellspacing="2" cellpadding="2" id="showAllOrdersPage" class="display">
                    <thead>
                        <tr>
                            <th>Order ID</th>
                            <th>Employee_ID</th>
                            <th>Employee Name</th>
                            <th>Customer_ID</th>
                            <th>Customer Name</th>
                            <th>Status</th>
                            <th>Sales_Price</th>
                            <th>Technical_Drawing</th>
                            <th>Set Status</th>
                        </tr>
                    </thead>
                    <tbody>
                    <%
                        ArrayList<Order> orders = (ArrayList<Order>) request.getAttribute("orders");
                        for (Order order : orders) {
                            out.println("<tr>");

                            out.println("<td>" + order.getOrderId() + "</td>");
                            out.println("<td>" + order.getEmployeeId() + "</td>");
                            out.println("<td>" + logic.getEmployeeByID(order.getEmployeeId()).getName() + "</td>");
                            out.println("<td>" + order.getCustomerId() + "</td>");
                            out.println("<td>" + logic.getCustomerID(order.getCustomerId()).getName() + "</td>");
                            out.println("<td>" + order.getStatus() + "</td>");
                            out.println("<td>" + order.getTotalSale() + "kr</td>");
                            out.println("<td>");
                        %>
                    <form action="FrontController" method="post">
                            <input type="hidden" name="command" value="seeDrawing">
                            <input type="hidden" name="orderId" value="<%=order.getOrderId()%>" />
                            <input type="submit" value="See drawing">
                        </form>
                    <%
                        
                            out.println("</td>");
                            out.println("<td>");
                            %>
                            <form action="FrontController" method="post">
                            <select name="status">
                                <option value="Sent">Sent </option>
                                <option value="Received">Received </option>
                                <option value="Cancelled">Cancelled </option>
                                <input type="hidden" name="OrderID" value="<%=order.getOrderId()%>"/>
                                <input type="hidden" name="command" value="SendOrder"/>
                                <input type="submit" value="Set status"/>
                        </form>
                                <%
                                    out.println("</td>");
                        
                    out.println("</tr>");
                    %>
                </tr>
                <%
                    }
                    %>
                </tbody>

            </table><br/><br/>
            </div>
        </div>
        <form action="FrontController" method="post">
            <input type="hidden" name="command" value="goToCarportSelect"/>
            <input type="submit" value ="Go back to menu"/>
        </form>
    </body>
</html>
