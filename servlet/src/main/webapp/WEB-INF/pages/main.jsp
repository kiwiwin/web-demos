<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
    <head>
    </head>
    <body>
        <div>
            <c:choose>
                <c:when test="${sessionScope.name == null}">
                    <a href="/login?type=login">login</a>
                </c:when>
                <c:otherwise>
                    ${sessionScope.name}
                    <a href="/login?type=logout">logout</a>
                </c:otherwise>
            </c:choose>
        </div>
        <div>
            <jsp:include page="${page}"/>
        </div>
    </body>
</html>