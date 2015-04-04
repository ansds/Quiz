<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div class="content">
  <h1 class="contentLabel">${quiz.caption}</h1>
  <div class="quiz">
    <span class="quizText">Created by</span>
    <a href="user" class="userLink">${quiz.user.username}</a>
    <span class="quizDate">
      <fmt:formatDate value="${quiz.creationDate}" pattern="yyyy-MM-dd HH:mm:ss" />
    </span>
    <div class="quizInfo">
      <br/>
      <span class="descriptionTitle">Description</span>
      <br/>
                    <span class="description">
                        ${quiz.description}
                    </span>
    </div>
  </div>
  <c:url value="/quiz/${quiz.id}/start" var="linkStartQuiz" />
  <form action="${linkStartQuiz}" method="get">
    <input type="submit" class="startQuiz" value="Start quiz"/>
  </form>
</div>