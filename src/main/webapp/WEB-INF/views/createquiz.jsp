<div class="content">
  <h1 class="contentLabel">Create new quiz</h1>
  <div class="quiz">
    <form method="post">
      <input type="hidden" id="questions" value="1" name="questions"/>
      <div class="quizWrapper">
        <span class="quizNameLabel">Quiz name:</span>
        <input type="text" class="quizNameInput" name="quizName"/>
        <br/>
        <span class="quizNameLabel">Description:</span>
        <textarea name="quizDescription"class="quizDescription"></textarea>
        <div class="questionWrapper">
          <span class="questionLabel">Question1: </span>
          <input type="text" class="questionInput" name="question1"/>
          <br/>
          <span class="answerLabel">Answer1:</span>
          <input class="answerInput" type="text" name="answer1.1"/>
          <input type="radio" name="question1radio" id="radio1.1" value="1" checked/><label for="radio1.1"></label>
          <br/>
          <span class="answerLabel">Answer2:</span>
          <input class="answerInput" type="text" name="answer1.2"/>
          <input type="radio" name="question1radio" id="radio1.2" value="2"/><label for="radio1.2"></label>
          <br/>
          <span class="answerLabel">Answer3:</span>
          <input class="answerInput" type="text" name="answer1.3"/>
          <input type="radio" name="question1radio" id="radio1.3" value="3"/><label for="radio1.3"></label>
          <br/>
          <span class="answerLabel">Answer4:</span>
          <input class="answerInput" type="text" name="answer1.4"/>
          <input type="radio" name="question1radio" id="radio1.4" value="4"/><label for="radio1.4"></label>
          <br/>
        </div>
        <button class="addQuestion" onclick="addQuestion()" type="button">Add question</button>
      </div>
      <input type="submit" value="createQuiz"/>
    </form>
  </div>
</div>
<script>
  var questions=1;
  function addQuestion() {
    questions++;
    var questionsHidden = document.getElementById("questions");
    questionsHidden.value = questions;
    var div = document.getElementsByClassName("quizWrapper")[0];
    var button = document.getElementsByClassName("addQuestion")[0];
    var newQuestion = "<div class=\"questionWrapper\">";
    newQuestion += "<span class=\"questionLabel\">Question" + questions + ": </span>";
    newQuestion += "<input type=\"text\" class=\"questionInput\" name=\"question" + questions + "\"/>";
    newQuestion += "<br/>";
    newQuestion += "<span class=\"answerLabel\">Answer1:</span>";
    newQuestion += "<input class=\"answerInput\" type=\"text\" name=\"answer" + questions + ".1\"/>";
    newQuestion += "<input type=\"radio\" name=\"question" + questions + "radio\" id=\"radio" + questions + ".1\" value = \"1\" checked/><label for=\"radio" + questions + ".1\"></label>";
    newQuestion += "<br/>";
    newQuestion += "<span class=\"answerLabel\">Answer2:</span>";
    newQuestion += "<input class=\"answerInput\" type=\"text\" name=\"answer" + questions + ".2\"/>";
    newQuestion += "<input type=\"radio\" name=\"question" + questions + "radio\" id=\"radio" + questions + ".2\" value = \"2\"/><label for=\"radio" + questions + ".2\"></label>";
    newQuestion += "<br/>";
    newQuestion += "<span class=\"answerLabel\">Answer3:</span>";
    newQuestion += "<input class=\"answerInput\" type=\"text\" name=\"answer" + questions + ".3\"/>";
    newQuestion += "<input type=\"radio\" name=\"question" + questions + "radio\" id=\"radio" + questions + ".3\" value = \"3\"/><label for=\"radio" + questions + ".3\"></label>";
    newQuestion += "<br/>";
    newQuestion += "<span class=\"answerLabel\">Answer4:</span>";
    newQuestion += "<input class=\"answerInput\" type=\"text\" name=\"answer" + questions + ".4\"/>";
    newQuestion += "<input type=\"radio\" name=\"question" + questions + "radio\" id=\"radio" + questions + ".4\" value = \"4\"/><label for=\"radio" + questions + ".4\"></label>";
    newQuestion += "<br/>";
    newQuestion += "</div>";
    var newNode = document.createElement("div");
    newNode.innerHTML = newQuestion;
    div.insertBefore(newNode, button);
  }
</script>