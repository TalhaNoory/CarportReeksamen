<%--<jsp:include page='/jsp/Header.jsp'></jsp:include>--%>

<!--<h2 class="text-center">Velkommen til Fog Carporte</h2>

<a href="/CarportPartTo/jsp/LoginOrCreate.jsp">Login/Register</a>-->
<%
    String redirectURL = "/CarportPartTo/jsp/LoginOrCreate.jsp";
    response.sendRedirect(redirectURL);
%>
<%--<jsp:include page='/jsp/Footer.jsp'></jsp:include>--%>

