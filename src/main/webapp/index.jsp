<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: ru.asmi
  Date: 07.05.18
  Time: 21:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" session="true" %>
<% String title = "Учет успеваемости"; %>
<% String keywords = "Курсы, повышение квалификации, студенты"; %>
<% String description = "Подробная информация об успеваемости студентов <RandomName> университета!"; %>
<%@ include file="header.jsp" %>

<c:if test="${sessionScope.id == null}">
    <p>Рады привестствовать Вас на нашем сайте. Пожалуйста зарегистрируйтесь или авторизируйтесь для продолжения работы</p>
</c:if>
<c:if test="${sessionScope.id > 0}">
    <a href="/profile">Мой профиль</a>
</c:if>

<%@ include file="footer.jsp" %>