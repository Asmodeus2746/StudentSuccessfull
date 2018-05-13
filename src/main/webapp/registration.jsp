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

<form action="${pageContext.request.contextPath}/registration" method="post">
    <label>Имя: <input type="text" name="name"></label><BR>
    <label>Фамилия: <input type="text" name="soname"></label><BR>
    <label>email: <input type="text" name="email"></label><BR>
    <label>password: <input type="password" name="password"></label><BR>
    <label>age: <input type="text" name="age"></label><BR>
    <input type="submit" value="OK">
</form>

<%@ include file="footer.jsp" %>