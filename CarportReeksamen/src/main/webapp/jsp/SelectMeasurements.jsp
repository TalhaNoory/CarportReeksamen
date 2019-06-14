<%--<jsp:include page='/jsp/Header.jsp'></jsp:include>--%>

    <h3 class="text-center">Vælg venligst målene til din Carport!</h3>
    <form action="FrontController" method="GET">
        <div class="container">
            <div class="row">
                <div class="text-center">
                    <div class="col-md-4">
                        <p>
                            Carportens - Højde
                        </p>
                        <select name="carportHeight">
                            <option value="230">230 cm </option>
                        </select>
                    </div>
                    <div class="col-md-4">
                        <p>
                            Carportens - Længde
                        </p>
                        <select name="carportLength">
                            <option value="250">250 cm</option>
                            <option value="300">300 cm</option>
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
                    </div>
                    <div class="col-md-4">
                        <p>
                            Carportens - Bredde
                        </p>
                        <select name="carportWidth">
                            <option value="250">250 cm</option>
                            <option value="300">300 cm</option>
                            <option value="350">350 cm</option>
                            <option value="400">400 cm </option>
                            <option value="450">450 cm </option>
                            <option value="500">500 cm</option>
                            <option value="550">550 cm</option>
                            <option value="600">600 cm</option>
                        </select>
                    </div>
                    <div class="col-md-4">
                        <p>
                            Skurets - Længde
                        </p>
                        <select name="shedLength">
                            <option value="200">200 cm</option>
                            <option value="250">250 cm</option>
                            <option value="300">300 cm</option>
                            <option value="350">350 cm</option>
                            <option value="400">400 cm</option>
                        </select>
                    </div>
                    <div class="col-md-4">
                        <p>
                            Skurets - Bredde
                        </p>
                        <select name="shedWidth">
                            <option value="200">200 cm</option>
                            <option value="250">250 cm</option>
                            <option value="300">300 cm</option>
                            <option value="350">350 cm</option>
                            <option value="400">400 cm</option>
                        </select>
                    </div>
                    <div class="col-md-4">
                        <br>
                        <button name="command" value="calculate">
                            Beregn
                        </button>                      
                        <button name="command" value="createOrder">
                            Save order
                        </button>
                    </div>
                </div>
            </div>
    
        </div>
    </form>
<%--<jsp:include page='/jsp/Footer.jsp'></jsp:include>--%>