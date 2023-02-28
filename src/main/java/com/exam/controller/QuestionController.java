package com.exam.controller;

import com.exam.model.User;
import com.exam.model.exam.Question;
import com.exam.model.exam.Quiz;
import com.exam.service.QuestionService;
import com.exam.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/question")
@CrossOrigin("*")
public class QuestionController {

    @Autowired
    private QuestionService questionService;

    @Autowired
    private QuizService quizService;

    //Add question
    @PostMapping("/")
    public ResponseEntity<Question> addQuestion(@RequestBody Question question) {

        Question addQuestion = this.questionService.addQuestion(question);
        return ResponseEntity.ok(addQuestion);
    }

    //Get question
    @GetMapping("/{questionId}")
    public Question getQuestion(@PathVariable("questionId") Long questionId) {
        return this.questionService.getQuestionById(questionId);
    }

    //Get all question
    @GetMapping("/")
    public ResponseEntity<?> getAllQuestions() {
        return ResponseEntity.ok(this.questionService.getAllQuestion());
    }

    //update question
    @PutMapping("/")
    public ResponseEntity<Question> updateCategory(@RequestBody Question question) {

        Question updateQuestion = this.questionService.updateQuestion(question);
        return ResponseEntity.ok(updateQuestion);
    }

    //delete question
    @DeleteMapping("/{questionId}")
    public void deleteCategory(@PathVariable("questionId") Long questionId) {
        this.questionService.deleteQuestionById (questionId);
    }

    //get all Question of any Quiz id

    @GetMapping("/quiz/{quizId}")
    public ResponseEntity<?> getQuestionsOfQuiz(@PathVariable("quizId") Long quizId) {
//        Type : 1
//        Quiz quiz = new Quiz();
//        quiz.setQid(quizId);
//        Set<Question> questionOfQuiz = this.questionService.getQuestionOfQuiz(quiz);
//        return ResponseEntity.ok(questionOfQuiz);

        //Ty    pe 2

        Quiz quiz = this.quizService.getQuizById(quizId);
        Set<Question> questions = quiz.getQuestions();
        List list = new ArrayList<>(questions);
        if (list.size() > Integer.parseInt(quiz.getNumberOfQuestions())) {
            list = list.subList(0, Integer.parseInt(quiz.getNumberOfQuestions() + 1));
        }
        Collections.shuffle(list);
        return ResponseEntity.ok(list);


    }

    @GetMapping("/quiz/all/{qid}")
    public ResponseEntity<?> getQuestionsOfQuizAdmin(@PathVariable("qid") Long qid) {
        Quiz quiz = new Quiz();
        quiz.setQid(qid);
        Set<Question> questionsOfQuiz = this.questionService.getQuestionOfQuiz(quiz);
        return ResponseEntity.ok(questionsOfQuiz);
    }

        //get single question
    @PostMapping("/eval-quiz")
    public ResponseEntity<?> evaluateQuiz(@RequestBody List<Question> questions) {
        System.out.println(questions);

        int correctAnswers = 0;
        double marksGot = 0;
        int attempted = 0;

        for (Question q : questions) {
            //Single Question
            Question question = this.questionService.get(q.getQuesId());
            if (question.getAnswer().equals(q.getGivenAnswer())) {
                //Correct Answer
                correctAnswers++;

                double markSingle = Double.parseDouble(questions.get(0).getQuiz().getMaxMarks()) / questions.size();
                marksGot += markSingle;
            }
            if (q.getGivenAnswer() != null) {

                attempted++;
            }

        }

        Map<String, Object> map = Map.of("marksGot", marksGot, "correctAnswer", correctAnswers, "attempted", attempted);
        return ResponseEntity.ok(map);
    }
}
