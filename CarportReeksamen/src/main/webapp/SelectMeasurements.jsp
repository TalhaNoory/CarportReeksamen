<%-- 
    Document   : Select
    Created on : Jun 15, 2019, 3:59:19 PM
    Author     : Dhono
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    </head>
    <body>
        <h3 class="text-center">Vælg venligst målene til din Carport!</h3>
        <%-- doGet Læser fra URL'en, hvorimod doPost kan læse hiddenParameter --%>
        <form action="FrontController" method="POST">
            <p>
                Carportens - Højde
            </p>
            <select name="carportHeight">
                <option value="230">230 cm </option>
            </select>
            <p>
                Carportens - Længde
            </p>
            <select name="carportLength">
                <option value="400">400 cm</option>
                <option value="450">450 cm</option>
                <option value="500">500 cm</option>
                <option value="550">550 cm</option>
                <option value="600">600 cm</option>
                <option value="650">650 cm</option>
                <option value="700">700 cm</option>
                <option value="750">750 cm</option>
                <option value="800">800 cm</option>
            </select>
            <p>
                Carportens - Bredde
            </p>
            <select name="carportWidth">
                <option value="400">400 cm </option>
                <option value="450">450 cm </option>
                <option value="500">500 cm</option>
                <option value="550">550 cm</option>
                <option value="600">600 cm</option>
            </select>
            <p>
                Skurets - Længde
            </p>
            <select name="shedLength">
                <option value="200">200 cm</option>
                <option value="250">250 cm</option>
                <option value="300">300 cm</option>
            </select>
            <p>
                Skurets - Bredde
            </p>
            <select name="shedWidth">
                <option value="200">200 cm</option>
                <option value="250">250 cm</option>
                <option value="300">300 cm</option>
            </select>
            <br><br>

            Customer name:  <input type="text" name="customerName"/><br><br>
            Email:          <input type="text" name="email"/><br><br>
            Address:        <input type="text" name="address"/><br><br>
            Zipcode:        <input type="text" name="zipCode"/><br><br>
            <input type="hidden" name="command" value="createOrder"/>
            <input type="submit" value="Create Order"/>
        </form>
    </body>
</html>