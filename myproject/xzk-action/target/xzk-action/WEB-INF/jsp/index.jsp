<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<body>
<h2>Hello World!</h2>
${time}
<br>
${formate}

<f:form action="/index" method="post">
    <input type="text" name="date" value="<fmt:formatDate value="${formate}" pattern="yyyy-MM-dd"/>">
    <input type="submit" value="提交"/>
</f:form>
</body>
</html>
