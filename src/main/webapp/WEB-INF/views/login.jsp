<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div class="content">
  <h1 class="contentLabel">Login</h1>
  <div class="form">
    <c:url value="/j_spring_security_check" var="loginUrl" />
    <form method="post" action="${loginUrl}">
      <c:if test="${not empty error}">
        <span class="error">${error}</span>
        <br/>
      </c:if>
      <br/>
      <span class="label">Login or Email</span>
      <input type="text" name="j_username"/>
      <br/>
      <span class="label labelPassword">Password</span>
      <input type="password" name="j_password"/>
      <br/>
      <input type="submit" value="Log in"/>
      <br/>
      <br/>
      <span class="registerAsk">
      Are you not a member?
      <a href="registration" class="registrationLink">Register now</a>
      </span>
    </form>
  </div>
</div>
