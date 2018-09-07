
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>Записная книжка Web App</title>
</head>
<body>
    <center>
        <h1>Записная книжка</h1>
        <h2>
            <a href="/NoteBook/new">Добавить нового пользователя</a>
            &nbsp;&nbsp;&nbsp;
            <a href="/Notebook/list">Список всех пользователей</a>
             
        </h2>
    </center>
    <div align="center">
    
        <table border="1" cellpadding="5">
            <caption><h2>Список пользователей</h2></caption>
            <tr>
                <th>ID</th>
                <th>Фамилия</th>
                <th>Имя</th>
                <th>Возраст</th>
                <th>Номер телефона</th>
                <th>Пол</th>
              
            <form action="" method="get">
            	<input type="text" class="form-control" name="q" placeholder="Search here..."/>
            </form>
        
                <th>Действие</th>
            </tr>
           
            <c:forEach var="user" items="${listUser}">
            
                <tr>
                    <td><c:out value="${user.id}" /></td>
                    <td><c:out value="${user.surname}" /></td>
                    <td><c:out value="${user.name}" /></td>
                    <td><c:out value="${user.age}" /></td>
                    <td><c:out value="${user.phone_number}" /></td>
                    <td><c:out value="${user.gender}" /></td>
           
                    <td>
                        <a href="/NoteBook/edit?id=<c:out value='${user.id}' />">Редактировать</a>
                        &nbsp;&nbsp;&nbsp;&nbsp;
                        <a href="/NoteBook/delete?id=<c:out value='${user.id}' />">Удалить</a>                     
                    </td>
                </tr>
            </c:forEach>
            
        </table>
    </div>   
</body>
</html>