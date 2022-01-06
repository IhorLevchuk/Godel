<html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<head>
    <meta charset="UTF-8">
    <title>Expense</title>
</head>
<body>
<table border="1" id="searchingResults" align="center">
    <tr>
        <td width="112">Date</td>
        <td width="112">Expense</td>
        <td width="112">Amount</td>
        <td width="112">Category</td>
    </tr>
    <tr>
        <td>${expense.name}</td>
        <td>${expense.createdAt}</td>
        <td>${expense.amount}</td>
        <td>${expense.category}</td>
    </tr>
</table>
<form action="<c:url value="/expenses/${id}"/>" method="post">
    <input type="hidden" name="_method" value="delete">
    <input type="submit" value="Delete">
</form>
</body>
</html>
