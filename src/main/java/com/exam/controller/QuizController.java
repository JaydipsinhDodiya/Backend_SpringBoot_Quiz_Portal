package com.exam.controller;

import com.exam.model.exam.Category;
import com.exam.model.exam.Quiz;
import com.exam.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/quiz")
@CrossOrigin(origins = "http://localhost:4200")
public class QuizController {

    @Autowired
    private QuizService quizService;

    //Add quiz
    @PostMapping("/")
    public ResponseEntity<Quiz> addQuestion(@RequestBody Quiz quiz) {

        Quiz addQuiz = this.quizService.addQuiz(quiz);
        return ResponseEntity.ok(addQuiz);
    }

    //Get quiz
    @GetMapping("/{quizId}")
    public Quiz getQuiz(@PathVariable("quizId") Long quizId) {
        return this.quizService.getQuizById(quizId);
    }

    //Get all quiz
    @GetMapping("/")
    public ResponseEntity<?> getAllQuizzes() {
        return ResponseEntity.ok(this.quizService.getAllQuizzes());
    }

    //update quiz
    @PutMapping("/")
    public ResponseEntity<Quiz> updateQuiz(@RequestBody Quiz quiz) {

        Quiz updateQuiz = this.quizService.updateQuiz(quiz);
        return ResponseEntity.ok(updateQuiz);
    }


    //delete quiz
    @DeleteMapping("/{quizId}")
    public void deleteCategory(@PathVariable("quizId") Long quizId) {
        this.quizService.deleteQuizById(quizId);
    }


    @GetMapping("/Bycategory/{categoryId}")
    public ResponseEntity<?> getQuizzesByCategoryId(@PathVariable("cid") Long cid){
        Category category=new Category();
        category.setCid(cid);
        return ResponseEntity.ok(this.quizService.findQuizzesByCategoryId(category));
    }

    @GetMapping("/active")
    public ResponseEntity<?> getAllActiveQuizzes(){
        return ResponseEntity.ok(this.quizService.findAllActiveQuiz());
    }

    @GetMapping("/category/active/{cid}")
    public ResponseEntity<?> getAllActiveQuizzesOfCategory(@PathVariable("cid") Long cid){
        Category category=new Category();
        category.setCid(cid);
        return ResponseEntity.ok(this.quizService.findAllActiveQuizOfCategory(category));
    }



}
