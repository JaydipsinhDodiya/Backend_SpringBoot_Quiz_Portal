package com.exam.service;

import com.exam.model.exam.Question;
import com.exam.model.exam.Quiz;

import java.util.Set;

public interface QuestionService {

    //add
    public Question addQuestion(Question question);

    //get by id
    public Question getQuestionById(Long questionId);

    //get all
    public Set<Question> getAllQuestion();

    //update
    public Question updateQuestion(Question question);

    //delete
    public void deleteQuestionById(Long questionId);

    //get question of quiz
    public Set<Question> getQuestionOfQuiz(Quiz quiz);

    public Question get(Long questionId);
}
