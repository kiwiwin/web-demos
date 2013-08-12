<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<table>
    <thead>
        <tr>
            <th>${userId}'s Books</th>
        </tr>
    </thead>
    <tbody>
    <c:forEach var="book" items="${books}">
        <tr>
            <td>${book}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>