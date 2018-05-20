<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: asmi
  Date: 20.05.18
  Time: 13:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" session="true" %>
<% String title = "Мой профиль"; %>
<% String keywords = ""; %>
<% String description = ""; %>
<%@ include file="header.jsp" %>

<c:if test="${sessionScope.id == null}">
    <p>Уважаемый пользователь! Для просмотра страницы профиля нужно сначала зарегистрироваться!</p>
    <br>
    <a href="registration.jsp">Регистрация</a>
</c:if>
<c:if test="${sessionScope.id > 0}">
    <%
        String error = "";
        if(request.getParameter("ret") != null) {
            if (request.getParameter("ret").equals("FAILED")) error = "Ошибка обновления";
            else if (request.getParameter("ret").equals("ALREADY_USED")) error = "Почта уже занята";
            else if (request.getParameter("ret").equals("INVALID_EMAIL")) error = "Невалидная почта";
            else if (request.getParameter("ret").equals("INVALID_PASSWORD")) error = "Неверный пароль";
            else if (request.getParameter("ret").equals("INVALID_NAME")) error = "Невалидное имя";
            else if (request.getParameter("ret").equals("INVALID_SONAME")) error = "Невалидная фамилия";
            else if (request.getParameter("ret").equals("INVALID_AGE")) error = "Невалидный возраст";
        }
    %>
    <p><%=error%></p>
    <c:if test="${sessionScope.email == null}">
        <p>Неизвестная ошибка! Попробуйте позже.</p>
    </c:if>
    <c:if test="${sessionScope.email != null}">
        <form action="${pageContext.request.contextPath}/update_profile" method="post">
            <label>Имя: <input type="text" name="name" value="<c:out value="${sessionScope.name}"></c:out>"></label><BR>
            <label>Фамилия: <input type="text" name="soname" value="<c:out value="${sessionScope.soname}"></c:out>"></label><BR>
            <label>email: <input type="text" name="email" value="<c:out value="${sessionScope.email}"></c:out>"></label><BR>
            <label>Возраст: <input type="text" name="age" value="<c:out value="${sessionScope.age}"></c:out>"></label><BR>
            <label>Подтвердите пароль: <input type="password" name="password"></label><BR>
            <input type="submit" value="Oбновить">
        </form>
    </c:if>
    <br>
    <a href="index.jsp">На главную</a>
</c:if>

<%@ include file="footer.jsp" %>
