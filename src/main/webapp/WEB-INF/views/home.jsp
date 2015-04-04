<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div class="content">
  <h1 class="contentLabel">Last added quizzes</h1>

  <c:forEach var="quiz" items="${quizzes}">
    <div class="quiz">
      <a href="user"><img src="/Quiz-1.0-SNAPSHOT/resources/img/av.png" alt="" class="avatar"/></a>
      <div class="quizInfo">
        <c:url value="/quiz/${quiz.id}" var="quizLink" />
        <a href="${quizLink}" class="quizLink">${quiz.caption}</a>
        <span class="quizText">was added by</span>
        <a href="user" class="userLink">${quiz.user.username}</a>
        <br/>
        <span class="quizDate"><fmt:formatDate value="${quiz.creationDate}" pattern="yyyy-MM-dd HH:mm:ss" /></span>
      </div>
    </div>
  </c:forEach>

</div>
