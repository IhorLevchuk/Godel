<html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<head>
    <meta charset="UTF-8">
    <title>Create expense</title>
</head>
<body>
<form action="<c:url value="/expenses"/>" method="post">
    <label for="name">Name</label>
    <input name="name" type="text" id="name" required>
    <br>
    <label for="createdAt">Created at</label>
    <input id="createdAt" name="createdAt" type="date" required>
    <br>
    <label for="category">Category</label>
    <select name="category" size="1" id="category" required>
        <c:forEach var="category" items="${categories}">
            <option value="${category.id}">${category.name}</option>
        </c:forEach>
    </select>
    <br>
    <label for="amount">Amount</label>
    <input name="amount" type="text" id="amount" required>
    <br>
    <input type="submit" value="Add expense">
</form>
</body>
</html>
