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

<c:set var="abc" scope="session" value="5"/>
<c:if test="${sessionScope.abc == 1}">
    <h1>Сессия равна 1</h1>
</c:if>
<c:if test="${sessionScope.abc != 1}">
    <h1>Сессия НЕ равна 1</h1>
</c:if>
Типо здравствуйте. Тут наверно должно быть что-то типа списка доступных ресурсов и, после первого готового ресурса так и будет. А пока вот эта вот заглушка, бессмысленно отнимающая у вас время.

<%@ include file="footer.jsp" %>