<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html; charset=utf-8" language="java" pageEncoding="utf-8" %>

<html>
<body>

<h2>Add new Book</h2>
<br>
<form:form action="saveBook" modelAttribute="book">

    label <form:input path="label"/>
    <br><br>
    author <form:input path="author"/>
    <br><br>
    Napublishing_houseme <form:input path="publishing_house"/>
    <br><br>
    Nimageame <form:input path="image"/>
    <br><br>
    <input type="submit" value="ok">

</form:form>



</body>
</html>