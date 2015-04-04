<%@ page import="com.ds.quiz.model.Quiz" %>
<%@ page import="com.ds.quiz.model.Question" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div class="content">
  <h1 class="contentLabel">${quiz.caption}</h1>
  <div class="quiz">
    <span class="quizText">Created by</span>
    <a href="user" class="userLink">${quiz.user.username}</a>
    <span class="quizDate"><fmt:formatDate value="${quiz.creationDate}" pattern="yyyy-MM-dd HH:mm:ss" /></span>

    <form method="post">
      <div class="questionsWrapper">
        <span class="questionnumber">
          <%
            int counter = Integer.parseInt((String) session.getAttribute("questionCounter"));
            String questionsQuantity = (String) session.getAttribute("questionQuantity");
            out.println(++counter + "/" + questionsQuantity);
          %>
        </span>
        <span class="question">${question.question}</span>
        <br/>
        <c:forEach var="answer" items="${question.answers}">
          <input type="radio" name="ans" value="${answer.id}" id="answer${answer.id}"/>
          <label for="answer${answer.id}"><span></span>${answer.answer}</label><br/>
          <%--<sf:radiobutton path="ans" value="${answer.id}" id="answer${answer.id}"/>--%>
          <%--<sf:label path="lab" for="answer${answer.id}"><span></span>${answer.answer}</sf:label><br/>--%>
        </c:forEach>
        <input type="submit" value="Next question" class="nextQuestion"/>
      </div>

    </form>
  </div>
</div>
