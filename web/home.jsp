<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Natalia
  Date: 09.10.16
  Time: 20:06
  To change this template use File | Settings | File Templates.
--%>
<%--<%@ page contentType="text/html;charset=UTF-8" language="java" %>--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
 <link rel="stylesheet" href="style/bootstrap.min.css">
    <link rel="stylesheet" href="style/homeStyle.css">
    <script src="js/jquery-3.1.1.min.js"></script>
    <script src="js/bootstrap.min.js"></script>

        <meta http-equiv="content-type" content="text/html; charset=cp1251">
    <title>Home Page</title>
    <style>
        table,th,td{
            border: 1px solid black;
        }
    </style>
</head>
<body>



<div class="background-image">

</div>


<div id="content">
    <h1 class="text-center">Найди свои апартаменты</h1>
    <form action="/newPost" method="get">
        <button class="btn btnAdd" ><a class="btnAddHref" type="submit"> Добавить обьявление </a> </button>
    </form>
    <form action="/delete" method="get">
        <button class="btn buttonAdd" ><a class="btnAddHref" type="submit"> Удалить обьявление </a> </button>
    </form>
<form class="form-margin"  method="POST" id="formx" action="/home" onsubmit="call()">
    <select class="form-control" name="numberOfRooms">
        <option value="1">1 комната</option>
        <option value="2">2 комнаты</option>
        <option value="3">3 комнаты</option>
    </select>

    <select class="form-control" name="repair">
        <option value="Евро-ремонт">Евро-ремонт</option>
        <option value="Косметический">Косметический</option>
        <option value="Черновой">Черновой</option>
    </select>

    <select class="form-control" name="condition">
        <option value="Замечательное">Замечательное</option>
        <option value="Хорошее">Хорошее</option>
        <option value="Удовлетворительное">Удовлетворительное</option>
        <option value="Плохое">Плохое</option>
    </select>

    <select class="form-control" name="city">
        <c:forEach items="${cityList}" var="currentCity">
            <option value = "${currentCity.name}">${currentCity.name}</option>
        </c:forEach>
    </select>

    <input type="text" class="form-control" name="startCost" placeholder="От" required autofocus>
    <input type="text" class="form-control" name="endCost" placeholder="До" required autofocus>
    <button class="btn  btn-primary btn-block" onclick="showTable('ofference-hide'); return false" type="submit" >Найти</button>

</form>

<div class="offerce_table" id="ofference-hide">

    <table id="offer_table" class="table table-striped table-bordered" >
    <thead>

    <tr><th>№</th><th>Город</th><th>Улица</th><th>Дом</th><th>Кв</th><th>Комнаты</th><th>Состояние квартиры</th><th>Ремонт</th>
        <th>Стоимость</th><th>ФИО риелтора</th><th>Контактный телефон</th>

    </thead>
        <tbody>
        <c:forEach items="${requestScope.offerList}" var="offer">
    <tr><td><c:out value="${offer.id}"></c:out></td>
        <td><c:out value="${offer.address.city.name}"></c:out></td>
        <td><c:out value="${offer.address.street.name}"></c:out></td>
        <td><c:out value="${offer.address.house}"></c:out></td>
        <td><c:out value="${offer.address.flat}"></c:out></td>
        <td><c:out value="${offer.feature.countOfRoom}"></c:out></td>
        <td><c:out value="${offer.feature.condition}"></c:out></td>
        <td><c:out value="${offer.feature.repair}"></c:out></td>
        <td><c:out value="${offer.cost}"></c:out></td>
        <td><c:out value="${offer.trader.name}"></c:out></td>
        <td><c:out value="${offer.trader.phoneNumber}"></c:out></td>

        </c:forEach>
    </tbody>
</table>
</div>
</div>

</body>
</html>