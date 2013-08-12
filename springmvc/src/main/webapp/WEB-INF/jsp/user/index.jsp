<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<table>
    <thead>
        <tr>
            <th>name</th>
        </tr>
    </thead>
    <tbody>
    <c:forEach var="user" items="${users}">
        <tr>
            <td>${user}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>