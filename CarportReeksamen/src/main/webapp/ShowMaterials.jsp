<%@page import="java.util.ArrayList"%>
<%@page import="DataLayer.Material"%>
<%@page import="DataLayer.Material"%>
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
            <%
                int carportWidth = (Integer) request.getAttribute("carportWidth");
                int carportLength = (Integer) request.getAttribute("carportLength");
                int shedWidth = (Integer) request.getAttribute("shedWidth");
                int shedLength = (Integer) request.getAttribute("shedLength");
                double distanceBetweenPoles = (double) request.getAttribute("distanceBetweenPoles");
                int amounts[] = (int[]) request.getAttribute("amounts");
                int amountOfPoles = amounts[1];
                int x = 0;
            %> 

            /* Hvis skurets længde er 0, bliver ikke viste noget (display:none) */
            <% if (shedLength == 0) {
            %>
            #shed {display:none;}
            <%}
            %>

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
        <br>
        <form action="FrontController" method="POST">
            <input type="hidden" name="command" value="showOrders"/>
            <input type="submit" value="Show all orders"/>
        </form>
        <br>
        <form action="FrontController" method="POST">
            <input type="hidden" name="command" value="selectMeasurements"/>
            <input type="submit" value="Return to Order page"/>
        </form>


        <!-- Denne svg tegner carporten plus stolperne -->
        <svg height="1000" width="1000">
        <rect x="0" y="100" height="<%= carportWidth%>" width="<%= carportLength%>" style="fill: #D3D3D3" />
        <!-- Her laver jeg Skuret -->
        <rect x="0" y="100" height="<%= shedWidth%>" width="<%= shedLength%>" style="fill: #a9a9a9" />

        <%-- linje 86 placeres stolperne øverst på tegningen 
        også på linje 87 placere den stolperne nederst på tegningen --%>
        <%
            for (int i = 0; i < amountOfPoles / 2; i++) {%>
        <rect x="<%= x%>" y="100" height="9.7" width="9.7" style="fill: #000000"/>
        <rect x="<%= x%>" y="<%= carportWidth - 9.7 + 100%>" height="9.7" width="9.7" style="fill: #000000"/>
        <% x += (distanceBetweenPoles + 9.7);
            }%>

        <!-- tekst der beskriver målene på carporten -->

        <!-- Mål for Carportens længde --> 
        <text x="<%= (carportLength) / 2%>" y="<%= carportWidth + 125%>" font-size="15px" text-anchor="middle" alignment-baseline="middle">Carportens Længde: <%= carportLength%>cm </text>
        <!-- Mål for Carportens bredde --> 
        <text x="<%= carportLength + 125%>" y="<%= carportWidth / 2%>" font-size="15px" text-anchor="middle" alignment-baseline="middle" transform="rotate(90,<%= carportLength + 25%>,<%= carportWidth / 2%>)"> Carportens bredde: <%= carportWidth%>cm </text>

        <!--g'et står for group-->
        <g id="shed">
        <!-- Mål for Skurets længde -->
        <text x="<%= (shedLength) / 2%>" y="85" font-size="15px" text-anchor="middle" alignment-baseline="middle">Skurets Længde: <%= shedLength%>cm </text>
        <!-- Mål for Skurets bredde -->
        <text x="<%= shedLength + 125%>" y="<%= shedWidth / 2%>" font-size="15px" text-anchor="middle" alignment-baseline="middle" transform="rotate(90,<%= shedLength + 25%>,<%= shedWidth / 2%>)"> Skurets bredde: <%= shedWidth%>cm </text>

        <!-- pilene der tilhører skuret --> 
        
        <!-- pilen til Skurets længde -->
        <line x1="15" y1="93" x2="<%= shedLength - 15%>" y2="93" stroke="#000" stroke-width="3" 
              marker-end="url(#endarrow)" marker-start="url(#startarrow)" />
        <!-- pilen til Skurets bredde -->
        <line x1="<%= shedLength + 5%>" y1="115" x2="<%= shedLength + 10%>" y2="<%= shedWidth + 85%>" stroke="#000" stroke-width="3" 
              marker-end="url(#endarrow)" marker-start="url(#startarrow)" />
        </g>
        
        <!-- pilene der tilhører carporten --> 

        <!-- pilen til Carportens længde --> 
        <line x1="15" y1="<%= carportWidth + 110%>" x2="<%= carportLength - 15%>" y2="<%= carportWidth + 110%>" stroke="#000" stroke-width="3" 
              marker-end="url(#endarrow)" marker-start="url(#startarrow)" />
        <!-- pilen til Carportens bredde --> 
        <line x1="<%= carportLength + 5%>" y1="115" x2="<%= carportLength + 10%>" y2="<%= carportWidth + 85%>" stroke="#000" stroke-width="3" 
              marker-end="url(#endarrow)" marker-start="url(#startarrow)" />

        <!-- enderne på pilene -->  
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
    </svg>
</body>
</html>

