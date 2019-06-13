<%-- 
    Document   : Materials
    Created on : May 7, 2019, 11:32:41 AM
    Author     : frede
--%>

<%@page import="DBAccess.Employee"%>
<%@page import="DBAccess.Material"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<% if (null == session.getAttribute("employee")) {
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <jsp:include page='siteHeader.jsp'></jsp:include>
        <title>Materials Page</title>
    </head>
    <body>
        <h1>Materials Page</h1>
        <%  Material newestMaterial = (Material) request.getAttribute("newestmaterial");
            if (null != newestMaterial) {
                out.println("<h3><i>You just created a new material with ID: " + newestMaterial.getMaterialId() + "</i></h3>");
            }
        %>
        <form action="FrontController" method="post">
            <h4>Add new material: </h4>
            <h4>Name:</h4>
            <input type="text" name="materialname"/> (Danish letters, numbers and whitespaces accepted)
            <h4>MSRP:</h4>
            <input type="text" name="msrp"/> (Only numbers accepted)
            <h4>Cost price:</h4>
            <input type="text" name="costprice"/> (Only numbers accepted)<br/><br/>
            <input type="hidden" name="command" value="createMaterial"/>
            <input type="submit" value ="Create new material"/>
        </form>
        <% String error = (String) request.getAttribute("error");
            if (error != null) {
                out.println("<H2>Error!!</h2>");
                out.println(error);
            }
        %>
        <br/><br/>
        <div class="row">
            <div class="col-sm-6">
                <script>
                    $(document).ready(function () {
                        $('#materials').DataTable();
                    });
                </script>

                <table border="3" width="2" cellspacing="2" cellpadding="2" id="materials" class="display">
                    <thead>
                        <tr>
                            <th>Material ID</th>
                            <th>Name</th>
                            <th>MSRP</th>
                            <th>Cost Price</th>
                            <th>Edit Material</th>
                        </tr>
                    </thead>
                    <tbody>
                    <%
                        ArrayList<Material> materials = (ArrayList<Material>) session.getAttribute("materials");
                        for (Material material : materials) {
                            out.println("<tr>");

                            out.println("<td>" + material.getMaterialId() + "</td>");
                            out.println("<td>" + material.getName() + "</td>");
                            out.println("<td>" + material.getMsrp() + "</td>");
                            out.println("<td>" + material.getCostPrice() + "</td>");
                            out.println("<td>");
                            %>
                    <form action="FrontController" method="post">
                            <input type="hidden" name="command" value="goToEditMaterial">
                            <input type="hidden" name="materialId" value="<%=material.getMaterialId()%>" />
                            <input type="submit" value="Edit Material">
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
                </div>
            </div>

            </table><br/><br/>
        <form action="FrontController" method="post">
            <input type="hidden" name="command" value="goToCarportSelect"/>
            <input type="submit" value ="Go back to menu"/>
        </form>
    </body>
</html>
