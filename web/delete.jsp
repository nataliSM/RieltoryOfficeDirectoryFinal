
<%--
  Created by IntelliJ IDEA.
  User: Natalia
  Date: 19.12.16
  Time: 2:45
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="style/bootstrap.min.css">
    <%--<link rel="stylesheet" href="style/homeStyle.css">--%>
    <link rel="stylesheet" href="style/table.css">


    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

    <meta http-equiv="content-type" content="text/html; charset=cp1251">
    <title>Delete</title>
    <%--<style>--%>
        <%--table,th,td{--%>
            <%--border: 1px solid black;--%>
        <%--}--%>
    <%--</style>--%>
</head>

<body>

<script>
    function updateGetCost(obj) {
      var offer_id = obj.value;
        var cost = document.getElementById(offer_id).value;
        location.href = '/delete?id=' + offer_id + '&cost=' + cost;


    }
</script>
<%--<div class="background-image">--%>
    <%--</div>--%>


<%--<div id="content">--%>

    <%--<div class="offerce_table" id="ofference-hide">--%>
    <%--<table id="offer_table" class="table table-striped table-bordered" >--%>
        <%--<thead>--%>

        <%--<tr><th>№</th><th>Город</th><th>Улица</th><th>Дом</th><th>Кв</th><th>Комнаты</th><th>Состояние квартиры</th><th>Ремонт</th>--%>
            <%--<th>Стоимость</th><th>ФИО риелтора</th><th>Контактный телефон</th><th>Изменить</th>--%>

        <%--</thead>--%>

        <%--<tbody>--%>
        <%--<c:forEach items="${requestScope.offerList}" var="offer">--%>
        <%--<tr ><td><c:out value="${offer.id}"></c:out></td>--%>
            <%--<td><c:out value="${offer.address.city.name}"></c:out></td>--%>
            <%--<td><c:out value="${offer.address.street.name}"></c:out></td>--%>
            <%--<td><c:out value="${offer.address.house}"></c:out></td>--%>
            <%--<td><c:out value="${offer.address.flat}"></c:out></td>--%>
            <%--<td><c:out value="${offer.feature.countOfRoom}"></c:out></td>--%>
            <%--<td><c:out value="${offer.feature.condition}"></c:out></td>--%>
            <%--<td><c:out value="${offer.feature.repair}"></c:out></td>--%>
            <%--<td><input id="${offer.id}"  value="${offer.cost}" placeholder="Цена"></td>--%>
            <%--<td><c:out value="${offer.trader.name}"></c:out></td>--%>
            <%--<td><c:out value="${offer.trader.phoneNumber}"></c:out></td>--%>

            <%--<td>--%>
                <%--<button  class="btn delBtn" ><a href="/delete?id=${offer.id}" class="btnAddHref" type="submit"> Удалить </a> </button>--%>
                <%--<button value="${offer.id}" onclick="updateGetCost(this)" class="btn updBtn"  ><a  class="btnAddHref" > Изменить </a> </button>--%>

                <%--</td>--%>


            <%--</c:forEach>--%>
        <%--</tbody>--%>
    <%--</table>--%>
        <%--</div>--%>
<%--</div>--%>


<div>


    <!-- Responsive table starts here -->
    <!-- For correct display on small screens you must add 'data-title' to each 'td' in your table -->
    <div class="table-responsive-vertical shadow-z-1">
        <!-- Table starts here -->
        <table id="table" class="table table-hover table-mc-light-blue">
            <thead>
            <tr>
                <tr><th>№</th><th>Город</th><th>Улица</th><th>Дом</th><th>Кв</th><th>Комнаты</th><th>Состояние квартиры</th><th>Ремонт</th>
                <th>Стоимость</th><th>ФИО риелтора</th><th>Контактный телефон</th><th>Изменить</th>

            </tr>
            </thead>
            <tbody>
            <c:forEach items="${requestScope.offerList}" var="offer">
            <tr>
                <td><c:out value="${offer.id}"></c:out></td>
                <td><c:out value="${offer.address.city.name}"></c:out></td>
                <td><c:out value="${offer.address.street.name}"></c:out></td>
                <td><c:out value="${offer.address.house}"></c:out></td>
                <td><c:out value="${offer.address.flat}"></c:out></td>
                <td><c:out value="${offer.feature.countOfRoom}"></c:out></td>
                <td><c:out value="${offer.feature.condition}"></c:out></td>
                <td><c:out value="${offer.feature.repair}"></c:out></td>
                <td><input id="${offer.id}"  value="${offer.cost}" placeholder="Цена"></td>
                <td><c:out value="${offer.trader.name}"></c:out></td>
                <td><c:out value="${offer.trader.phoneNumber}"></c:out></td>

                <td>
                <button style="margin-bottom: 10px; width: 100%"  class="btn btn-primary delBtn" ><a href="/delete?id=${offer.id}" class="linkColor" type="submit"> Удалить </a> </button>
                <button style="margin-top: 10px; width: 100%" value="${offer.id}" onclick="updateGetCost(this)" class="btn btn-primary updBtn"  ><a  class="linkColor" > Изменить </a> </button>
                </td>
            </tr>

            </c:forEach>

            </tbody>
        </table>
    </div>



</div>
    <script src="js/jquery-3.1.1.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <script src="js/table.js"></script>

</body>

</html>
