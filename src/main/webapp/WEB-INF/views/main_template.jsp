<%@ taglib prefix="t" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<t:importAttribute name="stylesheets"/>

<html>
<head>
    <title>Quiz</title>
    <c:forEach var="css" items="${stylesheets}">
      <link rel="stylesheet" type="text/css" href="<c:url value="${css}"/>">
    </c:forEach>
</head>
<body>
    <div class="mainWrapper">
        <t:insertAttribute name="top"/>
        <t:insertAttribute name="content"/>
    </div>





  <%--<div id="container">--%>
    <%--<div id="top">--%>
      <%--<t:insertAttribute name="top"/>--%>
    <%--</div>--%>
    <%--<div id="content">--%>
      <%--<t:insertAttribute name="content"/>--%>
    <%--</div>--%>
  <%--</div>--%>
</body>
</html>
