<html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<head>
    <meta charset="UTF-8">
    <title>Expenses</title>
</head>
<body>
<table border="1" id="searchingResults" align="center">
    <tr>
        <td width="112">Date</td>
        <td width="112">Expense</td>
        <td width="112">Amount</td>
        <td width="112">Category</td>
    </tr>
    <c:forEach var="expense" items="${expenses}">
        <tr>
            <td>${expense.name}</td>
            <td>${expense.createdAt}</td>
            <td>${expense.amount}</td>
            <td>${expense.category}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
