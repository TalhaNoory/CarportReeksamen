<%-- 
    Document   : CustomerView
    Created on : 25-Apr-2019, 14:27:25
    Author     : frederik
--%>


<%@page import="FunctionLayer.LogicFacadeImplementation"%>
<%@page import="java.util.ArrayList"%>
<%@page import="DBAccess.Order"%>
<%@page import="DBAccess.Customer"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<% if (null == session.getAttribute("employee")) {
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }
%>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <jsp:include page='siteHeader.jsp'></jsp:include>
        <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
        

        <%
            Customer customer = (Customer) request.getAttribute("c");
            LogicFacadeImplementation logic = new LogicFacadeImplementation();

        %>
        Kunde: <%=customer.getName()%> ID: <%=customer.getCustomerId()%>
        <div class="row">
            <div class="col-sm-6">
                <script>
                    $(document).ready(function () {
                        $('#customerView').DataTable();
                    });
                </script>

                <table border="3" width="2" cellspacing="2" cellpadding="2" id="customerView" class="display">
                    <thead>
                        <tr>
                            <th>Customer ID</th>
                            <th>Name</th>
                            <th>Email</th>
                            <th>Address</th>
                            <th>Zip Code</th>
                            <th>Phone Number</th>
                        </tr>
                    </thead>
                    <tbody>
                    <%
                            out.println("<tr>");
                            out.println("<td>" + customer.getCustomerId()+ "</td>");
                            out.println("<td>" + customer.getName() + "</td>");
                            out.println("<td>" + customer.getEmail() + "</td>");
                            out.println("<td>" + customer.getAddress() + "</td>");
                            out.println("<td>" + customer.getZipcode() + "</td>");
                            out.println("<td>" + customer.getPhonenumber() + "</td>");
                    out.println("</tr>");
                    %>
                </tr>

                </tbody>

            </table><br/><br/>
            </div>
        </div>
        
        <div class="row">
            <div class="col-sm-6">
                <script>
                    $(document).ready(function () {
                        $('#showAllOrdersPage').DataTable();
                    });
                </script>

                <table border="3" width="2" cellspacing="2" cellpadding="2" id="customerView" class="display">
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
                        </tr>
                    </thead>
                    <tbody>
                     <%
                        ArrayList<Order> orders = (ArrayList<Order>) request.getAttribute("oc");
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
    </body>
</table>

        <br/><br/>
        <form action="FrontController" method="post">
            <input type="hidden" name="command" value="Customers"/>
            <input type="submit" value ="Go back to customer list"/>
        </form>

</body>
</html>
