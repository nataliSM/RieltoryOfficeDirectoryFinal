<%--
  Created by IntelliJ IDEA.
  User: Natalia
  Date: 18.12.16
  Time: 21:45
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="style/bootstrap.min.css">
    <link rel="stylesheet" href="style/loginStyle.css">
    <script src="js/jquery-3.1.1.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <title>NewPostServlet</title>

    <script>

        function change(obj) {

            var selectBox = obj;
            var selected = selectBox.options[selectBox.selectedIndex].value;
            var arr = selectBox.options;

            var index;
            for (index = 0; index < arr.length; ++index)
            {
                var current = arr[index];
                    var temp = document.getElementById(current.value);
                if (temp != null)
                {
                    temp.style.display = "none";
                }
            }
            var select = document.getElementById(selected);

            select.style.display = "block";
        }
    </script>


</head>

<body>
<div class="background-image">

</div>

<div id ="screen">


        <div id="content">

        <h1 class="text-center">Добавить обьявление</h1>

        <form class="form-margin"  method="post" id="formx" action="/newPost" onsubmit="call()">



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

            <select class="form-control" id = "city" name="city" onchange="change(this)">
                <option value = "">Выберите город</option>
                <c:forEach items="${cityList}" var="currentCity">
                    <option value = "${currentCity.name}">${currentCity.name}</option>
                </c:forEach>
            </select>


            <c:forEach items="${cityList}" var="currentCity">
                <select id="${currentCity.name}" class="form-control" name="street" style="display: none">
                    <option value = "">Выберите улицу</option>
                    <c:forEach items="${streetList}" var="currentStreet">
                        <c:if test="${currentStreet.city.id == currentCity.id}">
                            <option value = "${currentStreet.name}">${currentStreet.name}</option>
                        </c:if>

                    </c:forEach>
                </select>
            </c:forEach>


            <input type="text" name="house" placeholder="Дом">
            <input type="text" name="flat" placeholder="Квартира">

            <input type="text" name="cost" placeholder="Цена">
            <input type="text" name="traderName" placeholder="ФИО">
            <input type="text" name="traderPhone" placeholder="Контактный телефон">



            <button class="btn  btn-primary btn-block btn-margin" type="submit" >Добавить Обьявление</button>

        </form>
        </div>




</div>

</body>
</html>
