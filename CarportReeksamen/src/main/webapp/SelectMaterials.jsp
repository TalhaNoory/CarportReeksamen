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
    int forBr�dt = 400;
    int sideBr�dt = 400;
    int amountOfPoles = (int) request.getAttribute("antalStolper");
    int stolpePrice = amountOfPoles * 400;
    int skurBr�dt = 1500;
    int plastmo = 1000;
    int skruer = 80;
    CalculateMaterials cm = new CalculateMaterials();
    int carportLength = (Integer) request.getAttribute("carportLength");
    int amountOfRafters = cm.getAmountOfRafters(carportLength);
    int sp�rPris = amountOfRafters * 100;
    int totalPris = forBr�dt + sideBr�dt + stolpePrice + skurBr�dt + plastmo + skruer + sp�rPris;

%>
<h2 class="text-center">Materialeliste</h2>
<div>
    <table>
        <tr>
            <th>Beskrivelse</th>
            <th>L�ngde</th>
            <th>Antal</th>
            <th>Enhed</th>
            <th>Pris</th>
            <th>Beskrivelse</th>
        </tr>
        <tr>
            <td>25x200mm. trykimp.	Br�dt</td>
            <td><%= request.getAttribute("tagBredde")%></td>
            <td>2</td>
            <td>Stk</td>
            <td><%= forBr�dt%>kr</td>
            <td>Tag konstruktion forende & bagende, hvor sp�r installeres p�</td>
        </tr>
        <tr>
            <td>25x200mm. trykimp. Br�dt</td>
            <td><%= request.getAttribute("carportLength")%></td>
            <td>2</td>
            <td>Stk</td>
            <td><%= sideBr�dt%>kr</td>
            <td>Tag konstruktion sider, hvor sp�r installeres p�</td>
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
            <td>19x100mm. trykimp. Br�dt</td>
            <td>210</td>
            <td>200</td>
            <td>Stk</td>
            <td><%= skurBr�dt%>kr</td>
            <td>Til bekl�dning af skur</td>
        </tr>
        <tr>
            <td>Plastmo Ecolite bl�tonet</td>
            <td><%= request.getParameter("carportWidth")%></td>
            <td>6</td>
            <td>Stk</td>
            <td><%= plastmo%>kr</td>
            <td>Tagplader monteres p� sp�r</td>
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
            <td>45x195mm. sp�rtr� ubh.</td>
            <td><%= request.getParameter("carportWidth")%></td>
            <td><%= amountOfRafters%></td>
            <td>Stk</td>
            <td><%= sp�rPris%>kr</td>
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

    <!--tekst der beskriver m�lene p� carporten -->

    <!--M�l for Carportens l�ngde -->
    <text x="<%= (carportLength) / 2%>" y="<%= carportWidth + 125%>" font-size="15px" text-anchor="middle" alignment-baseline="middle">Carportens L�ngde: <%= carportLength%>cm </text>
    <!--M�l for Carportens bredde -->
    <text x="<%= carportLength + 125%>" y="<%= carportWidth / 2%>" font-size="15px" text-anchor="middle" alignment-baseline="middle" transform="rotate(90,<%= carportLength + 25%>,<%= carportWidth / 2%>)"> Carportens bredde: <%= carportWidth%>cm </text>

    <!--pilene der h�rer til carporten -->

    <!--pilen til Carportens l�ngde -->
    <line x1="15" y1="<%= carportWidth + 110%>" x2="<%= carportLength - 15%>" y2="<%= carportWidth + 110%>" stroke="#000" stroke-width="3" 
          marker-end="url(#endarrow)" marker-start="url(#startarrow)" />
    <!--pilen til Carportens bredde -->
    <line x1="<%= carportLength + 5%>" y1="115" x2="<%= carportLength + 10%>" y2="<%= carportWidth + 85%>" stroke="#000" stroke-width="3" 
          marker-end="url(#endarrow)" marker-start="url(#startarrow)" />
    <!--enderne p� pilene --> 
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


