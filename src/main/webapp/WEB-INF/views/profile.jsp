<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="cl" uri="http://cloudinary.com/jsp/taglib" %>
<div class="content">
  <h1 class="contentLabel">User Profile</h1>
  <form method="post" enctype="multipart/form-data">
    <div class="user">
      <div class="userImageWrapper">
        <img src="${user.imageLink}" height="50px" width="50px" alt="" class="userImage"/>
      </div>
      <br/>
      <div class="labels">
        <span class="photoLabel">Photo:</span>
        <br/>
        <span class="usernameLabel">Username:</span>
        <br/>
        <span class="emailLabel">Email:</span>
        <%--<br/>--%>
        <%--<span class="passwordLabel">Password:</span>--%>
      </div>
      <div class="inputs">
        <input name="image" class="userImageInput" type="file" onchange="previewImage();"/>
        <br/>
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
<script>
  function previewImage() {
    var oFReader  = new FileReader();
    oFReader .readAsDataURL(document.getElementsByClassName("userImageInput")[0].files[0]);
    oFReader .onload = function(oFREvent) {
      document.getElementsByClassName("userImage")[0].src = oFREvent.target.result;
    };
  };
</script>