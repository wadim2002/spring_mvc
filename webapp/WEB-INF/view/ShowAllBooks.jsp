<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=utf-8" language="java" pageEncoding="utf-8" %>
<html>
<body>
<h2>My FIRST spring mvc project</h2>
<h2>All Records</h2>
<br>
<table>
    <tr>
        <th>Id</th>
        <th>Label</th>
        <th>Author</th>
        <th>File</th>
        <th>Publishing House</th>
        <th>Operations</th>

    </tr>

    <c:forEach var="emp" items="${allbooks}">
        <c:url var="ShowBook" value="/showBook">
                <c:param name="id" value="${emp.ID}"/>
        </c:url>
        <c:url var="deleteButton" value="/deleteBook">
            <c:param name="id" value="${emp.ID}"/>
        </c:url>

<%--        <c:url var="addButton" value="AddBook.jsp">--%>
<%--            <c:param name="id" value="${emp.ID}"/>--%>
<%--        </c:url>--%>

        <tr>
            <td>${emp.ID}</td>
            <td>${emp.label}</td>
            <td>${emp.author}</td>
            <td>${emp.image}</td>
            <td>${emp.publishing_house}</td>
            <td>
                <input type="button" value="Show Book"
                onclick="window.location.href = '${ShowBook}'"/>
            </td>
            <td>
                <input type="button" value="Delete Book"
                       onclick="window.location.href = '${deleteButton}'"/>
            </td>
        </tr>
    </c:forEach>

</table>
<br>
<input type="button" value="New Book"
       onclick="window.location.href = 'addBook'"/>

</body>
</html>