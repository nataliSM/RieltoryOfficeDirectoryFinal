<%--
  Created by IntelliJ IDEA.
  User: Natalia
  Date: 20.12.16
  Time: 0:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="../../style/bootstrap.min.css">
    <link rel="stylesheet" href="../../style/homeStyle.css">
    <script src="../../js/jquery-3.1.1.min.js"></script>
    <script src="../../js/bootstrap.min.js"></script>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

    <meta http-equiv="content-type" content="text/html; charset=cp1251">
    <title>Delete</title>
    <style>
        table,th,td{
            border: 1px solid black;
        }
    </style>
    <title>Update</title>
</head>
<body>


<div class="background-image">
</div>


<div id="content">
    <div class="offerce_table" id="ofference-hide">
        <table id="offer_table" class="table table-striped table-bordered" >
            <thead>

            <tr><th>№</th><th>Город</th><th>Улица</th><th>Дом</th><th>Кв</th><th>Комнаты</th><th>Состояние квартиры</th><th>Ремонт</th>
                <th>Стоимость</th><th>ФИО риелтора</th><th>Контактный телефон</th><th>Изменить</th>

            </thead>

            <tbody>
            <c:forEach items="${requestScope.offers}" var="offer">
            <tr ><td><c:out value="${offer.id}"></c:out></td>
                <td><c:out value="${offer.address.city.name}"></c:out></td>
                <td><c:out value="${offer.address.street.name}"></c:out></td>
                <td><c:out value="${offer.address.house}"></c:out></td>
                <td><c:out value="${offer.address.flat}"></c:out></td>
                <td><c:out value="${offer.feature.countOfRoom}"></c:out></td>
                <td><c:out value="${offer.feature.condition}"></c:out></td>
                <td><c:out value="${offer.feature.repair}"></c:out></td>
                <td><input value="${offer.cost}" placeholder="Цена"></td>
                <td><c:out value="${offer.trader.name}"></c:out></td>
                <td><c:out value="${offer.trader.phoneNumber}"></c:out></td>

                <td> <form>
                    <button  class="btn updBtn" ><a href="/update?id=${offer.id}&cost=${offer.cost}" class="btnAddHref" type="submit"> Изменить </a> </button>
                </form>
                </td>



                </c:forEach>
            </tbody>
        </table>
    </div>
</div>


 <script>

 </script>
</body>
</html>
