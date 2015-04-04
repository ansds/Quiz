<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<div class="content">
  <h1 class="contentLabel">User Profile</h1>
  <form method="post">
    <div class="user">
      <div class="labels">
        <span class="usernameLabel">Username:</span>
        <br/>
        <span class="emailLabel">Email:</span>
        <%--<br/>--%>
        <%--<span class="passwordLabel">Password:</span>--%>
      </div>
      <div class="inputs">
        <input class="usernameInput" type="text" name="username" value="${user.username}"/>
        <br/>
        <input class="emailInput" type="text" name="email" value="${user.email}"/>
        <%--<br/>--%>
        <%--<input class="passwordInput" type="password" name="password"/>--%>
      </div>
      <input type="submit" value="Update profile" class="updateButton"/>
    </div>
  </form>
  <table class="resultTable">
    <tr>
      <th>Quiz</th>
      <th>Result</th>
    </tr>
    <c:if test="${statisticsList != null}">
      <c:forEach var="statistics" items="${statisticsList}">
        <tr>
          <td>${statistics.quiz.caption}</td>
          <td>${statistics.countRight}/${fn:length(statistics.quiz.questions)}</td>
        </tr>
      </c:forEach>
    </c:if>
  </table>
</div>