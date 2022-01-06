<html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<head>
    <meta charset="UTF-8">
    <title>Update</title>
</head>
<body>
<form action="<c:url value="/expenses/${id}"/>" method="post">
    <input type="hidden" name="_method" value="patch">
    <label for="name">Name</label>
    <input name="name" type="text" id="name" value="${expense.name}" required>
    <br>
    <label for="createdAt">Created at</label>
    <input id="createdAt" name="createdAt" type="date" value="${expense.createdAt}" required>
    <br>
    <label for="current">Current category:</label>
    <label id="current">${expense.category}</label>
    <br>
    <label for="category">Category</label>
    <select name="category" size="1" id="category" required>
        <c:forEach var="category" items="${categories}">
            <option value="${category.id}">${category.name}</option>
        </c:forEach>
    </select>
    <br>
    <label for="amount">Amount</label>
    <input name="amount" type="text" id="amount" value="${expense.amount}" required>
    <br>
    <input type="submit" value="Update">
</form>
</body>
</html>
