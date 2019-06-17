<%@page import="java.util.ArrayList"%>
<%@page import="DataLayer.Material"%>
<%@page import="DataLayer.Material"%>
<%@page import="FunctionLayer.CalculateMaterials"%>
<%@page import="java.sql.ResultSet"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
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

        <h2>Material Table</h2>

        <table>
            <tr>
                <th>Material ID</th>
                <th>Name</th>
                <th>Amounts</th>
                <th>Price</th>
            </tr>
            
            <%
                        ArrayList<Material> materials = (ArrayList<Material>) request.getAttribute("materials");
                        int counter = 0;
                        int amounts[] = (int[]) request.getAttribute("amounts");
                        for (Material material : materials) {
                            
                            out.println("<tr>");

                            out.println("<td>" + material.getMaterial_Id() + "</td>");
                            out.println("<td>" + material.getName() + "</td>");
                            out.println("<td>" + amounts[counter] + "</td>");
                            out.println("<td>" + material.getCostPrice() + "</td>");
                            
                            out.println("<tr>");
                            
                            counter += 1;
                            
                        }
                            %>
        </table>
                            <form action="FrontController" method="POST">
                                <input type="hidden" name="command" value="showOrders"/>
                                <input type="submit" value="Show all orders"/>
                            </form>

            <%--
<%
    int carportWidth = (Integer) request.getAttribute("carportWidth");
%> 
<style>

        <% if (carportLength < 700) {
        %>
        #seksStolper {display: none;}
        <%}
        %>

    </style>
    <div class="text-center">
        <svg height="1000" width="1000">
        <rect x="0" y="100" height="<%= carportWidth%>" width="<%= carportLength%>" style="fill: #D3D3D3" />
        <!--Stolperne -->
        <rect x="0" y="100" height="9.7" width="9.7" style="fill:black"/>
        <rect x="0" y="<%= carportWidth + 100 - 9.7%>" height="9.7" width="9.7" style="fill:black"/>
        <rect x="<%= carportLength - 9.7%>" y="100" height="9.7" width="9.7" style="fill:black"/>
        <rect x="<%= carportLength - 9.7%>" y="<%= carportWidth + 100 - 9.7%>" height="9.7" width="9.7" style="fill:black"/>

        <!--tekst der beskriver målene på carporten -->

        <!--Mål for Carportens længde -->
        <text x="<%= (carportLength) / 2%>" y="<%= carportWidth + 125%>" font-size="15px" text-anchor="middle" alignment-baseline="middle">Carportens Længde: <%= carportLength%>cm </text>
        <!--Mål for Carportens bredde -->
        <text x="<%= carportLength + 125%>" y="<%= carportWidth / 2%>" font-size="15px" text-anchor="middle" alignment-baseline="middle" transform="rotate(90,<%= carportLength + 25%>,<%= carportWidth / 2%>)"> Carportens bredde: <%= carportWidth%>cm </text>

        <!--pilene der hører til carporten -->

        <!--pilen til Carportens længde -->
        <line x1="15" y1="<%= carportWidth + 110%>" x2="<%= carportLength - 15%>" y2="<%= carportWidth + 110%>" stroke="#000" stroke-width="3" 
              marker-end="url(#endarrow)" marker-start="url(#startarrow)" />
        <!--pilen til Carportens bredde -->
        <line x1="<%= carportLength + 5%>" y1="115" x2="<%= carportLength + 10%>" y2="<%= carportWidth + 85%>" stroke="#000" stroke-width="3" 
              marker-end="url(#endarrow)" marker-start="url(#startarrow)" />
        <!--enderne på pilene --> 
        <defs>
        <marker id="startarrow" markerWidth="5" markerHeight="3" 
                refX="5" refY="1.5" orient="auto">
            <polygon points="5 0, 5 3, 0 1.5" fill="black" />
        </marker>
        <marker id="endarrow" markerWidth="5" markerHeight="3" 
                refX="0" refY="1.5" orient="auto" markerUnits="strokeWidth">
            <polygon points="0 0, 5 1.5, 0 3" fill="black" />
        </marker>
        </defs>
        <g id="seksStolper">
        <rect x="<%= carportLength / 2 - 4.85%>" y="100" height="9.7" width="9.7" style="fill:black"/>
        <rect x="<%= carportLength / 2 - 4.85%>" y="<%= carportWidth - 9.7 + 100%>" height="9.7" width="9.7" style="fill:black"/>
        </g>
    </div> --%>
    </body>
</html>

