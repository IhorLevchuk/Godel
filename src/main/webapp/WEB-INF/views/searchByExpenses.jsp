<html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<head>
    <meta charset="UTF-8">
    <title>Expenses</title>
    <script>
        function autoCompleteEmptyDate() {
            if (search.from_date.value === '') {
                search.from_date.value = '1970-01-01'
            }
            if (search.to_date.value === '') {
                search.to_date.value = '1970-01-01'
            }
            search.submit()
        }
    </script>
</head>
<body>
<form name="search" action="<c:url value="/expenses/parameters"/>" novalidate>
    <table align="center">
        <tr>
            <td>
                <select name="selectedCategory" size="1">
                    <option selected value="0">Category</option>
                    <option value="011">All</option>
                    <c:forEach var="category" items="${categories}">
                        <option value="${category.id}">${category.name}</option>
                    </c:forEach>
                </select>
            </td>
            <td>
                <input id="from_date" name="from_date" type="date">
            </td>
            <td>
                <input id="to_date" name="to_date" type="date">
            </td>
            <td>
                <input type=button value="Search" onclick="return autoCompleteEmptyDate()"/>
            </td>
        </tr>
    </table>
    <div align="center">
        <input type="checkbox" name="statistic" value="true">Get statistics<Br>
    </div>
</form>
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
<div id="textStatistics" align="center">
    <c:forEach var="stat" items="${statistics}">
        ${stat.name}${stat.value}<br>
    </c:forEach>
</div>
</body>
</html>
