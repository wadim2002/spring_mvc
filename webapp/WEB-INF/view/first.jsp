<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<body>
<h2>My FIRST spring mvc project</h2>
<h2>All Records</h2>
<br>
<table>
    <tr>
        <th>Id</th>
        <th>Name</th>
    </tr>

    <c:forEach var="emp" items="${ents}">
        <tr>
            <td>${emp.id}</td>
            <td>${emp.nameEntity}</td>
        </tr>
    </c:forEach>

</table>
</body>
</html>
