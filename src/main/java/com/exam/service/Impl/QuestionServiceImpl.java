package com.exam.service.Impl;

import com.exam.model.exam.Question;
import com.exam.model.exam.Quiz;
import com.exam.repository.QuestionRepository;
import com.exam.service.QuestionService;
import com.exam.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedHashSet;
import java.util.Set;

@Service
public class QuestionServiceImpl implements QuestionService {

    @Autowired
    private QuestionRepository questionRepository;

    //add
    @Override
    public Question addQuestion(Question question) {
        return this.questionRepository.save(question);
    }

    //get by id
    @Override
    public Question getQuestionById(Long questionId) {
        return this.questionRepository.getById(questionId);
    }

    //get all
    @Override
    public Set<Question> getAllQuestion() {
        return new LinkedHashSet<>(this.questionRepository.findAll());
    }

    //update
    @Override
    public Question updateQuestion(Question question) {
        return this.questionRepository.save(question);
    }

    //delete by id
    @Override
    public void deleteQuestionById(Long questionId) {
        Question question = new Question();
        question.setQuesId(questionId);
        this.questionRepository.delete(question);
    }

    // get question of quiz
    @Override
    public Set<Question> getQuestionOfQuiz(Quiz quiz) {
        return this.questionRepository.findByQuiz(quiz);
    }

    @Override
    public Question get(Long questionId) {
        return this.questionRepository.getOne(questionId);
    }
}
