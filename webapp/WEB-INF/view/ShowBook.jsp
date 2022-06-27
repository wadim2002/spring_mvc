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
    </tr>

        <tr>
            <td>${onebook.ID}</td>
            <td>${onebook.label}</td>
            <td>${onebook.author}</td>
            <td>${onebook.image}</td>
            <td>${onebook.publishing_house}</td>
        </tr>

</table>
</body>
</html>