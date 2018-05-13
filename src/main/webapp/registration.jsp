<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: ru.asmi
  Date: 07.05.18
  Time: 21:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" session="true" %>
<% String title = "Регистрация"; %>
<% String keywords = ""; %>
<% String description = ""; %>
<%@ include file="header.jsp" %>

<c:if test="${sessionScope.id == null}">
    <form action="${pageContext.request.contextPath}/registration" method="post">
        <label>Имя: <input type="text" name="name"></label><BR>
        <label>Фамилия: <input type="text" name="soname"></label><BR>
        <label>email: <input type="text" name="email"></label><BR>
        <label>Пароль: <input type="password" name="password"></label><BR>
        <label>Возраст: <input type="text" name="age"></label><BR>
        <input type="submit" value="OK">
    </form>
</c:if>
<c:if test="${sessionScope.id > 0}">
    <p>Уважаемый <c:out value="sessionScope.name"></c:out>! Вы уже зарегистрированы.</p>
    <br>
    <a href="index.jsp">На главную</a>
</c:if>

<%@ include file="footer.jsp" %>