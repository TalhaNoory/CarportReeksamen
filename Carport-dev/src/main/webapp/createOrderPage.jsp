<%-- 
    Document   : createOrderPage
    Created on : Apr 24, 2019, 12:37:45 PM
    Author     : frede
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<% if (null == session.getAttribute("employee")) {
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }
%>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <jsp:include page='siteHeader.jsp'></jsp:include>
        <style>
            <%  String roofType = (String) session.getAttribute("rooftype");
                if (roofType.equals("fladt")) {
            %>
            #roofangle {display:none;}
            <%}
            %>
            <%  String shed = (String) session.getAttribute("shed");
                if (shed.equals("noshed")) {
            %>
            #shed {display:none;}
            <%}
            %>
        </style>
        <h1>Create Order Page</h1>
        <% String error = (String) request.getAttribute("error");
            if (error != null) {
                out.println("<H2>Error!!</h2>");
                out.println(error);
            }
        %>
        <form action="FrontController" method="post">
            <h3> Please add carport specifications </h3>
              Carport length:<select name="carportlength">
                <option value="240">240 cm </option>
                <option value="270">270 cm </option>
                <option value="300">300 cm </option>
                <option value="330">330 cm </option>
                <option value="360">360 cm </option>
                <option value="390">390 cm </option>
                <option value="420">420 cm </option>
                <option value="450">450 cm </option>
                <option value="480">480 cm </option>
                <option value="510">510 cm </option>
                <option value="540">540 cm </option>
                <option value="570">570 cm </option>
                <option value="600">600 cm </option>
                <option value="630">630 cm </option>
                <option value="660">660 cm </option>
                <option value="690">690 cm </option>
                <option value="720">720 cm </option>
                <option value="750">750 cm </option>
                <option value="780">780 cm </option>
            </select><br/><br/>
            Carport width:<select name="carportwidth">
                <option value="240">240 cm </option>
                <option value="270">270 cm </option>
                <option value="300">300 cm </option>
                <option value="330">330 cm </option>
                <option value="360">360 cm </option>
                <option value="390">390 cm </option>
                <option value="420">420 cm </option>
                <option value="450">450 cm </option>
                <option value="480">480 cm </option>
                <option value="510">510 cm </option>
                <option value="540">540 cm </option>
                <option value="570">570 cm </option>
                <option value="600">600 cm </option>
                <option value="630">630 cm </option>
                <option value="660">660 cm </option>
                <option value="690">690 cm </option>
                <option value="720">720 cm </option>
                <option value="750">750 cm </option>
                <option value="780">780 cm </option>
            </select><br/><br/>
            The height to roof of carport is always 225cm, total height depends on roof angle and width of carport <br/><br/>
            <div id="roofangle">
            Roof angle:<select name="roofangle">
                <option value="15">15°</option>
                <option value="20">20°</option>
                <option value="25">25°</option>
                <option value="30">30°</option>
                <option value="35">35°</option>
                <option value="40">40°</option>
                <option value="45">45°</option>
            </select><br/><br/>
            </div>
            <div id="shed">
            Shed width:<select name="shedwidth">
                <option value="210">210 cm </option>
                <option value="240">240 cm </option>
                <option value="270">270 cm </option>
                <option value="300">300 cm </option>
                <option value="330">330 cm </option>
                <option value="360">360 cm </option>
                <option value="390">390 cm </option>
                <option value="420">420 cm </option>
                <option value="450">450 cm </option>
                <option value="480">480 cm </option>
                <option value="510">510 cm </option>
                <option value="540">540 cm </option>
                <option value="570">570 cm </option>
                <option value="600">600 cm </option>
                <option value="630">630 cm </option>
                <option value="660">660 cm </option>
                <option value="690">690 cm </option>
                <option value="720">720 cm </option>
            </select><br/><br/>
            Shed length:<select name="shedlength">
                <option value="150">150 cm </option>
                <option value="180">180 cm </option>
                <option value="210">210 cm </option>
                <option value="240">240 cm </option>
                <option value="270">270 cm </option>
                <option value="300">300 cm </option>
                <option value="330">330 cm </option>
                <option value="360">360 cm </option>
                <option value="390">390 cm </option>
                <option value="420">420 cm </option>
                <option value="450">450 cm </option>
                <option value="480">480 cm </option>
                <option value="510">510 cm </option>
                <option value="540">540 cm </option>
                <option value="570">570 cm </option>
                <option value="600">600 cm </option>
                <option value="630">630 cm </option>
                <option value="660">660 cm </option>
                <option value="690">690 cm </option>
            </select><br/><br/>
            </div>
            <h3> Please add customer information </h3>
            Customer name:<input type="text" name="customername"/> (Only danish letters and whitespaces accepted)<br/><br/>
            Customer email:<input type="text" name="customeremail"/> (Danish letters, numbers, dots and @ accepted)<br/><br/>
            Customer address:<input type="text" name="customeraddress"/> (Danish letters, numbers and whitespaces accepted)<br/><br/>
            Customer zipcode:<input type="text" name="customerzipcode"/> (Only numbers accepted, must be 4 digits long)<br/><br/>
            Customer phonenumber:<input type="text" name="customerphonenumber"/> (Only numbers accepted, must be 8 digits long)<br/><br/>
            Customer comment:<br/> <textarea name="customercomment" rows="6" cols="50"></textarea><br/><br/>
            <input type="hidden" name="command" value="createOrder">
            <input type="submit" value="Save order"/>  
        </form> <br/><br/>
        <form action="FrontController" method="post">
            <input type="hidden" name="command" value="goToCarportSelect"/>
            <input type="submit" value="Go back to menu"/>
        </form> <br>
    </body>
</html>
