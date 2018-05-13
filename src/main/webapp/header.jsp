<%--
  Created by IntelliJ IDEA.
  User: asmi
  Date: 13.05.18
  Time: 2:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8"/>
    <title><%=title%></title>
    <meta name="keywords" content="<%=keywords%>"/>
    <meta name="description" content="<%=description%>"/>
    <link href="resources/style.css" rel="stylesheet">
</head>

<body>

<div class="wrapper">

    <header class="header">
        <h1 class="headline"><%=title%></h1>
        В светлом будущем здесь будут ссылки, логин и прочее.
        <div class="logout">
            <c:if test="${sessionScope.id > 0}">
                <a href="/leave_session">Выйти</a>
            </c:if>
            <c:if test="${sessionScope.id == null}">
                <a href="auth.jsp">Войти</a> | <a href="registration.jsp">Регистрация</a>
            </c:if>
        </div>
    </header>

    <main class="content">