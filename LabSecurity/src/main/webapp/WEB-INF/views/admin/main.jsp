<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib prefix="sql_rt" uri="http://java.sun.com/jstl/sql_rt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Insert title here</title>
</head>
<body>
${mainText}<br/>
<c:if test="${studentsList ne null}">
    <c:forEach items="${studentsList}" var="student" varStatus="index">
        ${index.index+1}.) <a href="students/${student.studentId}">${student.pib}</a><br/>
    </c:forEach>
</c:if>
<form method="post" style="margin-top: 30px">
    <input type="text" name="pib" placeholder="PIB">
    <input type="number" name="course" placeholder="Course">
    <button type="submit">Add new student</button>
</form>

<c:url value="/j_spring_security_logout" var="logoutUrl" />
<form action="${logoutUrl}" method="post" id="logoutForm">
    <button type="submit" name="${_csrf.parameterName}"
            value="${_csrf.token}" >Logout</button>
</form>
</body>
</html>