<%--<jsp:include page='/jsp/Header.jsp'></jsp:include>--%>

<%--<%@page import="FunctionLayer.CalculateMaterials"%>--%>

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
<%
    int forBrædt = 400;
    int sideBrædt = 400;
    int amountOfPoles = (int) request.getAttribute("antalStolper");
    int stolpePrice = amountOfPoles * 400;
    int skurBrædt = 1500;
    int plastmo = 1000;
    int skruer = 80;
    CalculateMaterials cm = new CalculateMaterials();
    int carportLength = (Integer) request.getAttribute("carportLength");
    int amountOfRafters = cm.getAmountOfRafters(carportLength);
    int spærPris = amountOfRafters * 100;
    int totalPris = forBrædt + sideBrædt + stolpePrice + skurBrædt + plastmo + skruer + spærPris;

%>
<h2 class="text-center">Materialeliste</h2>
<div>
    <table>
        <tr>
            <th>Beskrivelse</th>
            <th>Længde</th>
            <th>Antal</th>
            <th>Enhed</th>
            <th>Pris</th>
            <th>Beskrivelse</th>
        </tr>
        <tr>
            <td>25x200mm. trykimp.	Brædt</td>
            <td><%= request.getAttribute("tagBredde")%></td>
            <td>2</td>
            <td>Stk</td>
            <td><%= forBrædt%>kr</td>
            <td>Tag konstruktion forende & bagende, hvor spær installeres på</td>
        </tr>
        <tr>
            <td>25x200mm. trykimp. Brædt</td>
            <td><%= request.getAttribute("carportLength")%></td>
            <td>2</td>
            <td>Stk</td>
            <td><%= sideBrædt%>kr</td>
            <td>Tag konstruktion sider, hvor spær installeres på</td>
        </tr>
        <tr>
            <td>97x97mm. trykimp. Stolpe</td>
            <td>300</td>
            <td><%= request.getAttribute("antalStolper")%></td>
            <td>Stk</td>
            <td><%= stolpePrice%>kr</td>
            <td>Stolper nedgraves 90cm. i jord</td>
        </tr>
        <tr>
            <td>19x100mm. trykimp. Brædt</td>
            <td>210</td>
            <td>200</td>
            <td>Stk</td>
            <td><%= skurBrædt%>kr</td>
            <td>Til beklædning af skur</td>
        </tr>
        <tr>
            <td>Plastmo Ecolite blåtonet</td>
            <td><%= request.getParameter("carportWidth")%></td>
            <td>6</td>
            <td>Stk</td>
            <td><%= plastmo%>kr</td>
            <td>Tagplader monteres på spær</td>
        </tr>
        <tr>
            <td>4,5x70mm. Skruer 400 stk.</td>
            <td></td>
            <td>2</td>
            <td>Pakker</td>
            <td><%= skruer%>kr</td>
            <td>Til montering</td>
        </tr>
        <tr>
            <td>45x195mm. spærtræ ubh.</td>
            <td><%= request.getParameter("carportWidth")%></td>
            <td><%= amountOfRafters%></td>
            <td>Stk</td>
            <td><%= spærPris%>kr</td>
            <td>Remme i sider, sadles ned i stolper</td>
        </tr>
        <tr>
            <td><b>Total:</b></td>
            <td></td>
            <td></td>
            <td></td>
            <td><b><%= totalPris%>kr</b></td>
            <td></td>
        </tr>
    </table>
    <button name="command" value="createOrder">
        Save order
    </button>
</div>
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
</div>

<%--<jsp:include page='/jsp/Footer.jsp'></jsp:include>--%>


