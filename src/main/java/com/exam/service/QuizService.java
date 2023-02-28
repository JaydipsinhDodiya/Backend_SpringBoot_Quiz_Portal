package com.exam.service;

import com.exam.model.exam.Category;
import com.exam.model.exam.Quiz;

import java.util.List;
import java.util.Set;

public interface QuizService {

    //add
    public Quiz addQuiz(Quiz quiz);

    //update
    public Quiz updateQuiz (Quiz quiz);

    //Get all
    public Set<Quiz> getAllQuizzes();

    //Get by Id
    public Quiz getQuizById(Long quizId);

    //Delete by id
    public  void deleteQuizById(Long quizId);

    public List<Quiz> findQuizzesByCategoryId(Category category);

    public List<Quiz> findAllActiveQuiz();

    public List<Quiz> findAllActiveQuizOfCategory(Category category);


}
