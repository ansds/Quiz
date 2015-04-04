<%--
  Created by IntelliJ IDEA.
  User: DS
  Date: 16.03.2015
  Time: 13:03
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<header>
  <div class="top">
    <h1 class="slogan">Slogan about quiz site</h1>
    <div class="loginWrapper">
      <sec:authorize access="isAuthenticated()">
        <c:url value="/j_spring_security_logout" var="logoutUrl" />
        <form action="${logoutUrl}" method="post" id="logoutForm"></form>
        <script>
          function formSubmit() {
            document.getElementById("logoutForm").submit();
          }
        </script>
        <c:url value="/profile" var="profile" />
        Hello, <a href="${profile}" class="profile logout"><sec:authentication property="principal.username"/></a>
        <span> | </span>
        <a href="javascript:formSubmit()" class="logout">Logout</a>
      </sec:authorize>
      <sec:authorize access="!isAuthenticated()">
        <c:url value="/login" var="login" />
        <a href="${login}" class="login">Register / Login</a>
      </sec:authorize>

    </div>
  </div>
  <div class="navigation">
    <h1 class="logo">
      <c:url value="/home" var="home" />
      <a href="${home}" class="logoLink">Quiz</a>
    </h1>
    <div class="nav">
      <c:url value="/quiz" var="quiz" />
      <a href="${quiz}" class="navLink">Create Quiz</a>
      <c:url value="/home" var="home" />
      <a href="${home}" class="navLink">Home</a>
    </div>
  </div>
</header>