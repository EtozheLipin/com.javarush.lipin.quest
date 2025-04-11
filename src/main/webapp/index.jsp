<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%
    request.setAttribute("now", new java.util.Date());
%>

<!DOCTYPE html>
<html>
<head>
    <title>Тест</title>
    <style>
        body {
            margin: 0;
            padding: 0;
            font-family: "Segoe UI", sans-serif;
            background: url('prog.jpg') no-repeat center center fixed;
            background-size: cover;
            color: #fff;
            text-align: center;
        }

        .container {
            background-color: rgba(0, 0, 0, 0.9);
            padding: 40px;
            margin: 100px auto;
            width: 500px;
            border-radius: 15px;
            box-shadow: 0 0 20px rgba(255, 255, 255, 0.2);
        }

        h1 {
            font-size: 2.5em;
            margin-bottom: 20px;
        }

        p {
            font-size: 1.2em;
            margin-bottom: 30px;
        }

        input[type="text"] {
            padding: 10px;
            font-size: 1em;
            border: none;
            border-radius: 5px;
            width: 80%;
            margin-bottom: 20px;
        }

        button {
            padding: 12px 25px;
            font-size: 1em;
            border: none;
            border-radius: 8px;
            background-color: #3474eb;
            color: white;
            cursor: pointer;
            transition: background-color 0.3s ease;
        }

        button:hover {
            background-color: #164191;
        }
    </style>
</head>
<body>
<div class="container">
    <h1>Выбираем первый язык программирования</h1>
    <p>Данный тест не несёт цели кого-либо оскорбить, наслаждайтесь!</p>

    <p style="font-size: 0.8em; color: #ccc;">
        Страница загружена:
        <fmt:formatDate value="${now}" pattern="dd.MM.yyyy HH:mm:ss" />
    </p>

    <form action="start-servlet" method="get">
        <input type="text" name="playerName" placeholder="Введи своё имя..." required />
        <br/>
        <button type="submit">Начать тест</button>
    </form>
</div>
</body>
</html>