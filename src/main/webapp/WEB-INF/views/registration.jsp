
<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>

<%--<div>--%>
  <%--<h2>Create a new account</h2>--%>

  <%--<sf:form method="post" modelAttribute="user" enctype="multipart/form-data">--%>
    <%--<label>Login:</label>--%>
    <%--<br/>--%>
    <%--<sf:errors path="username"/>--%>
    <%--<br/>--%>
    <%--<sf:input path="username" size="15"/>--%>
    <%--<br/>--%>
    <%--<label>Email:</label>--%>
    <%--<br/>--%>
    <%--<sf:errors path="email"/>--%>
    <%--<br/>--%>
    <%--<sf:input path="email"/>--%>
    <%--<br/>--%>
    <%--<label>Password</label>--%>
    <%--<sf:errors path="password"/>--%>
    <%--<br/>--%>
    <%--<sf:input path="password" showPassword="false"/>--%>
    <%--<br/>--%>
    <%--<label>Profile image</label>--%>
    <%--<input name="image" type="file"/>--%>
    <%--<br/>--%>
    <%--<input name="submit" type="submit">--%>
  <%--</sf:form>--%>
<%--</div>--%>

<div class="content">
  <h1 class="contentLabel">Create new account</h1>
  <div class="form">
    <sf:form method="post" modelAttribute="user" enctype="multipart/form-data">
      <sf:errors path="username" cssClass="errors"/>
      <br/>
      <span class="label">Login</span>
      <sf:input path="username"/>
      <br/>
      <sf:errors path="email" cssClass="errors"/>
      <br/>
      <span class="label">Email</span>
      <sf:input path="email"/>
      <br/>
      <sf:errors path="password" cssClass="errors"/>
      <br/>
      <span class="label labelPassword">Password</span>
      <sf:input path="password" showPassword="false"/>
      <br/>
      <br/>
      <span class="label photoLabel">Photo</span>
      <input name="image" type="file"/>
      <br/>
      <br/>
      <input type="submit" value="Create new account"/>
    </sf:form>
  </div>
</div>