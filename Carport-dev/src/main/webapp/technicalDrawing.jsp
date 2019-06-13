<%-- 
    Document   : technicalDrawing
    Created on : Apr 30, 2019, 9:14:55 AM
    Author     : frede
--%>

<%@page import="FunctionLayer.LogicFacadeImplementation"%>
<%@page import="java.util.ArrayList"%>
<%@page import="DBAccess.LineItem"%>
<%@page import="DBAccess.Customer"%>
<%@page import="FunctionLayer.RoofBuilder"%>
<%@page import="DBAccess.Order"%>
<%@page import="FunctionLayer.PoleBuilder"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<% if (null == session.getAttribute("employee")) {
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }
%>
    <% Order order = (Order) request.getAttribute("order");
        int length = order.getCarportLength();
        int width = order.getCarportWidth();
        int shedLength = order.getShedLength();
        int shedWidth = order.getShedWidth();
        double distance = (Double) request.getAttribute("distance");
        double x = 10 + distance;
        Double boards = (length / 209.7 - 1);
        int numberOfBoards = boards.intValue();
        Double carportHeight = (Double) request.getAttribute("carportheight");
        Customer customer = (Customer) request.getAttribute("customer");
        Double sideRafterLength = (Double) request.getAttribute("siderafterlength");
        int roofAngle = order.getRoofAngle();
        LogicFacadeImplementation lf = new LogicFacadeImplementation();
    %>
        <jsp:include page='siteHeader.jsp'></jsp:include>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <script src="js/jspdf.js"></script>
        <script src="js/jquery-2.1.3.js"></script>
        <script src="js/pdfFromHTML.js"></script>
        <script src="js/html2canvas.js"></script>
        <style>
            <% if (shedLength == 0) {
            %>
            #shedwall {display:none;}
            #shedmeasurements {display:none;}
            <%}
            %>
        </style>
    </head>
    <button id="download">Save PDF</button><br><br>

    <div id="HTMLtoPDF">
        <body>
            Customer name: <%=customer.getName()%><br><br>
            <!--svg der viser carporten set oppefra -->
            <svg class=hidden height="<%= width + 150%>" width="<%= length + 400%>" transform="translate(50,50)">
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
        <!-- shedmeasurements bliver skjult hvis carporten ikke har et skur -->
        <g id ="shedmeasurements">
        <rect x="<%= length - shedLength%>" y="0" height="<%= shedWidth%>" width="<%= shedLength%>" style="fill: #D3D3D3" />
        <text x="<%= length - (shedLength / 2)%>" y="35" font-family="Verdana" font-size="13px" text-anchor="middle" alignment-baseline="middle"> Shed length: <%= shedLength%>cm </text>
        <text x="<%= length - shedLength - 25%>" y="<%= (shedWidth + 20) / 2%>" font-family="Verdana" font-size="15px" text-anchor="middle" alignment-baseline="middle" transform="rotate(270,<%=length - shedLength - 25%>,<%= (shedWidth + 20) / 2%>)"> Shed width: <%= shedWidth%>cm </text>
        <line x1="<%= length - shedLength + 15%>" y1="20" x2="<%= length - 25%>" y2="20" stroke="#000" stroke-width="3" 
              marker-end="url(#endarrow)" marker-start="url(#startarrow)" />
        <line x1="<%= length - shedLength - 10%>" y1="25" x2="<%= length - shedLength - 10%>" y2="<%=shedWidth - 25%>" stroke="#000" stroke-width="3" 
              marker-end="url(#endarrow)" marker-start="url(#startarrow)" />
        </g>
        <!-- siderne på carporten hvor stolperne går til -->
        <rect x="0" y="0" height="9.7" width="<%= length%> " style="fill: #808080"/>
        <rect x="0" y="<%= width - 9.7%>" height="9.7" width="<%= length%> " style="fill: #808080"/>       
        <rect x="0" y="0" height="<%= width%>" width="9.7" style="fill: #808080"/>
        <rect x="<%= length - 9.7%>" y="0" height="<%= width%>" width="9.7" style="fill: #808080"/>
        <!--stolperne i hjørnerne af carporten -->
        <rect x="0" y="0" height="9.7" width="9.7" style="fill: #000000"/>
        <rect x="<%= length - 9.7%>" y="0" height="9.7" width="9.7" style="fill: #000000"/>
        <rect x="0" y="<%= width - 9.7%>" height="9.7" width="9.7" style="fill: #000000"/>
        <rect x="<%= length - 9.7%>" y="<%= width - 9.7%>" height="9.7" width="9.7" style="fill: #000000"/> 
        <!--tekst der beskriver målene på carporten -->
        <text x="<%= (length) / 2%>" y="<%= width + 25%>" font-family="Verdana" font-size="15px" text-anchor="middle" alignment-baseline="middle">Length: <%= length%>cm </text>
        <text x="<%= length + 25%>" y="<%= width / 2%>" font-family="Verdana" font-size="15px" text-anchor="middle" alignment-baseline="middle" transform="rotate(90,<%=length + 25%>,<%= width / 2%>)"> Width: <%= width%>cm </text>
        <text x="<%= (distance + 15) / 2%>" y="<%= width - 35%>" font-family="Verdana" font-size="15px" text-anchor="middle" alignment-baseline="middle"> Between poles: <%= Math.round(distance * 10) / 10.0%>cm </text>
        <!--pilene der hører til carporten -->
        <line x1="15" y1="<%=width + 10%>" x2="<%= length - 15%>" y2="<%=width + 10%>" stroke="#000" stroke-width="3" 
              marker-end="url(#endarrow)" marker-start="url(#startarrow)" />
        <line x1="30" y1="<%=width - 20%>" x2="<%= distance - 10%>" y2="<%=width - 20%>" stroke="#000" stroke-width="3" 
              marker-end="url(#endarrow)" marker-start="url(#startarrow)" />
        <line x1="<%= length + 10%>" y1="15" x2="<%= length + 10%>" y2="<%=width - 15%>" stroke="#000" stroke-width="3" 
              marker-end="url(#endarrow)" marker-start="url(#startarrow)" />
        <!--loop der placere stolperne -->
        <%
            for (int i = 0; i < numberOfBoards; i++) {%>      
        <rect x="<%= x%>" y="0" height="9.7" width="9.7" style="fill: #000000"/>
        <rect x="<%= x%>" y="<%= width - 10%>" height="9.7" width="9.7" style="fill: #000000"/>
        <% x += (distance + 9.7);
            }%>
        <!--tekst der beskriver tegningen -->
        <text x="10" y="<%=width + 50%>" font-family="Verdana" font-size="15px" text-anchor="left" alignment-baseline="middle">Tegningen viser en grundplan af carporten. De sorte fikanter er stolperne.  </text>
        </svg><br/><br/><br/>



        <!--svg der viser carporten set fra gavlen -->
        <svg width="<%= width + 400%>" height="<%= carportHeight + 50%> " transform="translate(50,0)">
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
        <%
            double endpointX = 20 + 75 * Math.cos(Math.toRadians(roofAngle));
            double endpointY = carportHeight - 225 - 75 * Math.sin(Math.toRadians(roofAngle));
        %>
        <!--sider og loft -->
        <rect x="20" y="<%= carportHeight - 225%>" height="225" width="10" style="fill: #000000"/>
        <rect x="<%= width - 10 + 20%>" y="<%= carportHeight - 225%>" height="225" width="10" style="fill: #000000"/>
        <rect x="20" y="<%= carportHeight - 225%>" height="10" width="<%= width%>" style="fill: #000000"/>
        <!--skrå tagsider -->
        <rect x="<%= width / 2 + 20%>" y="0" height="10" width="<%= sideRafterLength%>" style="fill: #000000" transform="rotate(<%=90 - (180 - 90 - roofAngle)%>,<%= width / 2 + 20%>, 5)" />
        <rect x="<%= width / 2 + 20%>" y="0" height="10" width="<%= sideRafterLength%>" style="fill: #000000" transform="rotate(<%=90 + (180 - 90 - roofAngle)%>,<%= width / 2 + 20%>, 5)" />
        <!--<rect x="<%= width / 2 + 20 - 5%>" y="0" height="<%=carportHeight - 225%>" width="10" style="fill: #808080"/>-->
        <!--linjer på tegningen -->
        <line x1="<%= width + 40%>" y1="25" x2="<%= width + 40%>" y2="<%= carportHeight - 15%>" stroke="#000" stroke-width="3" 
              marker-end="url(#endarrow)" marker-start="url(#startarrow)" />
        <line x1="40" y1="<%= carportHeight - 225 + 15 + 15%>" x2="40" y2="<%= carportHeight - 15%>" stroke="#000" stroke-width="3" 
              marker-end="url(#endarrow)" marker-start="url(#startarrow)" />
        <!--tekst der beskriver målene -->
        <text x="80" y="<%= (carportHeight + carportHeight - 225) / 2%>" font-family="Verdana" font-size="15px" text-anchor="middle" alignment-baseline="middle">  225cm </text> 
        <text x="<%= width + 90%>" y="<%= carportHeight / 2%>" font-family="Verdana" font-size="15px" text-anchor="middle" alignment-baseline="middle">  <%= Math.round(carportHeight * 10) / 10.0%> cm </text>
        <text x="100" y="<%=(carportHeight - 225 + endpointY) / 2%>" font-family="Verdana" font-size="15px" text-anchor="left" alignment-baseline="middle">  <%= roofAngle%>°</text>  
        <!--buet linje der viser tagets hældning -->
        <path d="M 100 <%= carportHeight - 225%> A75 75, 0, 0, 0, <%= endpointX%> <%= endpointY%> Z" fill="black" stroke="black" stroke-width="3" /> 
        <!--tekst der beskriver tegningen -->
        <text x="20" y="<%=carportHeight + 20%>" font-family="Verdana" font-size="15px" text-anchor="left" alignment-baseline="middle">Tegningen viser carporten set fra gavlen.</text>
        </svg>

        <div id ="shedwall">
            </svg>
            <!--svg der viser skurets væg set indefra (mest for at kunne se hvordan brædderne skal sættes på) -->
            <svg height="<%=(225 + 50) * 2 + 150%>" width="<%=(shedWidth + 250) * 2%>">
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
            <!--loop der placere brædderne på indersiden, i+16 fordi brædderne er 10cm og der skal være 6cm mellemrum -->
            <%for (double i = 59.7; i < shedWidth + 50 - 9.7;) {%>
            <rect x="<%=i * 2%>" y="<%=50 * 2%>" height="<%=225 * 2%>" width="<%=10 * 2%>"  style="fill: #C0C0C0" />  
            <%i += 16;
                }
            %>
            <!--loop der placere brædderne på ydersiden af skuret -->
            <%for (double i = 69.7; i < shedWidth + 50 - 9.7;) {%>
            <rect x="<%=i * 2%>" y="<%=50 * 2%>" height="<%=225 * 2%>" width="<%=6 * 2%>"  style="fill: #696969" />  
            <%i += 16;
                }
            %>
            <!-- stolperne i hver side af skurvæggen -->
            <rect x="<%=(shedWidth + 50 - 9.7) * 2%>" y ="<%=50 * 2%>" width="<%=9.7 * 2%>" height="<%=225 * 2%>" style="fill: #000000"/>
            <rect x="<%=50 * 2%>" y ="<%=50 * 2%>" width="<%=9.7 * 2%>" height="<%=225 * 2%>" style="fill: #000000"/>
            <!--brædderne der går på tværs -->
            <rect x="<%=(50 + 9.7) * 2%>" y ="<%=50 * 2 + 20%>" width="<%=(shedWidth - 19.4) * 2%>" height="<%=10 * 2%>" style="fill: #A9A9A9"/>
            <rect x="<%=(50 + 9.7) * 2%>" y ="<%=50 * 2 + 225 - 10%>" width="<%=(shedWidth - 19.4) * 2%>" height="<%=10 * 2%>" style="fill: #A9A9A9"/>
            <rect x="<%=(50 + 9.7) * 2%>" y ="<%=50 * 2 + 225 * 2 - 10 * 2%>" width="<%=(shedWidth - 19.4) * 2%>" height="<%=10 * 2%>" style="fill: #A9A9A9"/>
            <!--linjer på tegningen -->
            <line x1="145.4" y1="65" x2="145.4" y2="98" stroke="#000" stroke-width="3" />
            <line x1="139.4" y1="98" x2="151.4" y2="98" stroke="#000" stroke-width="3" />
            <line x1="193.4" y1="45" x2="193.4" y2="98" stroke="#000" stroke-width="3" />
            <line x1="183.4" y1="98" x2="203.4" y2="98" stroke="#000" stroke-width="3" />
            <line x1="109.7" y1="45" x2="109.7" y2="98" stroke="#000" stroke-width="3" />
            <line x1="100" y1="98" x2="119.4" y2="98" stroke="#000" stroke-width="3" />
            <line x1="114.85" y1="85" x2="<%=50 * 2 + shedWidth * 2 - 20%>" y2="85" stroke="#000" stroke-width="3" 
                  marker-end="url(#endarrow)" marker-start="url(#startarrow)" />
            <!--tekst der beskriver målene -->
            <text x="145.4" y="60" font-family="Verdana" font-size="15px" text-anchor="middle" alignment-baseline="middle">  6cm </text> 
            <text x="193.4" y="40" font-family="Verdana" font-size="15px" text-anchor="middle" alignment-baseline="middle">  10cm </text> 
            <text x="109.4" y="40" font-family="Verdana" font-size="15px" text-anchor="middle" alignment-baseline="middle">  9.7cm </text> 
            <text x="<%=shedWidth + 100%>" y="75" font-family="Verdana" font-size="15px" text-anchor="middle" alignment-baseline="middle">  <%=shedWidth%>cm </text>
            <!--tekst der beskriver tegningen -->
            <text x="100" y="<%=225 * 2 + 120%>" font-family="Verdana" font-size="15px" text-anchor="left" alignment-baseline="middle">Tegningen viser en af skurets vægge set indefra. De sorte pæle er stolperne i hver ende af</text>
            <text x="100" y="<%=225 * 2 + 140%>" font-family="Verdana" font-size="15px" text-anchor="left" alignment-baseline="middle">væggen. De mørkegrå lodrette streger er brædderne på ydersiden af skuret, de lysegrå </text>
            <text x="100" y="<%=225 * 2 + 160%>" font-family="Verdana" font-size="15px" text-anchor="left" alignment-baseline="middle">lodrette streger er brædderne på indersiden. De vanrette streger er brædder som de øvrige  </text>
            <text x="100" y="<%=225 * 2 + 180%>" font-family="Verdana" font-size="15px" text-anchor="left" alignment-baseline="middle">brædder skal skrues fast i.  </text>
            </svg>


            <!--svg der viser konstruktionen af en dør til skuret -->
            <svg height="750" width="600">
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
            <!-- loop der placere brædderne på indersiden af døren -->
            <%int boardSpace = 0; %>
            <%for (int i = 0; i < 6; i++) {%>
            <rect x="<%=200 + boardSpace%>" y="200" height="440" width="20"  style="fill: #C0C0C0" />  
            <% boardSpace += 32;
                }
            %>
            <!-- loop der placere brædderne på ydersiden af døren -->
            <%int outerBoardSpace = 0; %>
            <%for (int i = 0; i < 5; i++) {%>
            <rect x="<%=220 + outerBoardSpace%>" y="200" height="440" width="12"  style="fill: #696969" />  
            <% outerBoardSpace += 32;
                }
            %>
            <!--top og bund af "Z" på døren -->
            <rect x="200" y="240" height="14.6" width="180" style="fill: #778899" />
            <rect x="200" y="585.4" height="14.6" width="180" style="fill: #778899" />
            <!--den skrå side i "Z"'et -->
            <polygon points='200,254.6 220,254.6 380,585.4 360,585.4' style='fill: #778899'/>
            <!-- lodret strej i midten af Z'et -->
            <rect x='200' y='413.2' height='14.6' width='96' style="fill: #778899" />
            <!--dørhåndtag -->
            <circle cx='210' cy='420' r='5' fill='#000000'/>
            <rect x='210' y='417.5' heigh='5' width='40' style="fill: #000000" />
            <line x1="210" y1="420" x2="230" y2="420" stroke="#000" stroke-width="5" />
            <!--linjer på tegningen -->
            <line x1="242" y1="160" x2="242" y2="185" stroke="#000" stroke-width="3" 
                  marker-end="url(#endarrow)"/>
            <line x1="395" y1="246.8" x2="425" y2="246.8" stroke="#000" stroke-width="3" 
                  marker-start="url(#startarrow)"/>
            <line x1="170" y1="420" x2="185" y2="420" stroke="#000" stroke-width="3" 
                  marker-end="url(#endarrow)"/>
            <!-- tekst der beskriver tegningen -->
            <text x="242" y="150" font-family="Verdana" font-size="15px" text-anchor="middle" alignment-baseline="middle"> 19x100 mm. trykimp. bræt </text>
            <text x="425" y="246.8" font-family="Verdana" font-size="15px" text-anchor="left" alignment-baseline="middle"> 38x73 mm. taglægte </text>
            <text x="10" y="420" font-family="Verdana" font-size="15px" text-anchor="left" alignment-baseline="middle"> Stalddørsgreb 50x75 </text>
            <text x="100" y="660" font-family="Verdana" font-size="15px" text-anchor="left" alignment-baseline="middle"> Tegningen viser døren til skuret set indefra. </text>
            <text x="100" y="680" font-family="Verdana" font-size="15px" text-anchor="left" alignment-baseline="middle"> Brædderne sidder med 6cm mellemrum ligesom på </text>
            <text x="100" y="700" font-family="Verdana" font-size="15px" text-anchor="left" alignment-baseline="middle"> skurvæggene. "Z"'et er lavet af det samme træ </text>
            <text x="100" y="720" font-family="Verdana" font-size="15px" text-anchor="left" alignment-baseline="middle"> som taglægterne. </text>
            </svg>
        </div>


        <h3>Go to see all orders page</h3>
        <form action="FrontController" method="post">
            <input type="hidden" name="command" value="goToSeeOrders"/>
            <input type="submit" value="Go to see orders page"/>
        </form>

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
                            <th>Unit Price</th>
                            <th>Material ID</th>
                            <th>Order ID</th>
                            <th>Qty</th>
                            <th>Length</th>
                            <th>Comment</th>
                        </tr>
                    </thead>
                    <tbody>
                     <%
                        ArrayList<LineItem> lineitems = (ArrayList<LineItem>) request.getAttribute("LT");
                        for (LineItem lineitem : lineitems) {
                            out.println("<tr>");

                            out.println("<td>" + lf.getMaterial(lineitem.getMaterialId()).getCostPrice() + "kr</td>");
                            out.println("<td>" + lf.getMaterial(lineitem.getMaterialId()).getName() + "</td>");
                            out.println("<td>" + lineitem.getOrderId() + "</td>");
                            out.println("<td>" + lineitem.getQty() + "</td>");
                            out.println("<td>" + lineitem.getLength() + "</td>");
                            out.println("<td>" + lineitem.getComment() + "</td>");
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
</div>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.0/jquery.min.js"></script>
<script>
    window.onload = function () {
        $("canvas").hide();
    };
</script>

<script>
    document.getElementById("download").addEventListener("click", function () {
        //selects div, containing entire webpage
        html2canvas(document.querySelector('#HTMLtoPDF')).then(function (canvas) {

        
            saveAs(canvas.toDataURL(), 'CarportGuide.png');
        });
    });


    function saveAs(uri, filename) {
        
        // creates link
        var link = document.createElement('a');

        if (typeof link.download === 'string') {
            
            //set reference to canvas created from html2canvas and sets filename
            link.href = uri;
            link.download = filename;

            //Firefox requires the link to be in the body
            document.body.appendChild(link);

            //simulate click
            link.click();

            //remove the link when done
            document.body.removeChild(link);

        } else {

            window.open(uri);

        }
    }
</script>
</body>
</html>
