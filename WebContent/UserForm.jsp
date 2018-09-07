<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>Записная книжка web app</title>
</head>
<body>

    <center>
        <h1>Записная книжка</h1>
        <h2>
            <a href="/NoteBook/new">Добавить нового пользователя</a>
            &nbsp;&nbsp;&nbsp;
            <a href="/NoteBook/list">Список всех пользователей</a>
             
        </h2>
    </center>
  
    <div align="center">
        <c:if test="${user != null}">
            <form action="update" method="post">
        </c:if>
        <c:if test="${user == null}">
            <form action="insert" method="post">
        </c:if>
        <table border="1" cellpadding="5">
            <caption>
                <h2>
                    <c:if test="${user != null}">
                        Редактировать
                    </c:if>
                    <c:if test="${user == null}">
                        Добавить
                    </c:if>
                </h2>
            </caption>
                <c:if test="${user != null}">
                    <input type="hidden" name="id" value="<c:out value='${user.id}' />" />
                </c:if>           
            <tr>
                <th>Фамилия: </th>
                <td>
                    <input type="text" name="surname" size="45"  minlength="5" maxlength="35"
                            value="<c:out value='${user.surname}' />"
                        />
                </td>
            </tr>
            <tr>
                <th>Имя: </th>
                <td>
                    <input type="text" name="name" size="45" minlength="5" maxlength="20"
                            value="<c:out value='${user.name}' />"
                   required />
                </td>
            </tr>
            <tr>
                <th>Возраст: </th>
                <td>
                    <input type="number" name="age" size="5"
                            value="<c:out value='${user.age}' />"
                    required patern="^[ 0-9]+$"/>
                </td>
            </tr>
            <tr>
                <th>Номер телефона: </th>
                <td>
                
                    <input type="text" id="phone" name="phone_number" size="45"
                    placeholder="+380-000-00-00-00" pattern="^\+380-\d{3}-\d{2}-\d{2}$"
                            value="<c:out value='${user.phone_number}' />"
                    required/>
                   
                </td>
            </tr>
            <tr>
                <th>Пол: </th>
                <td>
                	<select name="gender" value="<c:out value='${user.gender}' />">
                		<option>M</option>
                		<option>Ж</option>
                	</select>  
              </td>
            </tr>
            
            <tr>
                <td colspan="2" align="center">
                    <input type="submit" value="Save" />
                </td>
            </tr>
        </table>
        </form>
    </div>   
</body>
</html>