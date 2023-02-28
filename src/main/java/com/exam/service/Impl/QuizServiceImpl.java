package com.exam.service.Impl;

import com.exam.model.exam.Category;
import com.exam.model.exam.Quiz;
import com.exam.repository.QuizRepository;
import com.exam.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

@Service
public class QuizServiceImpl implements QuizService {

    @Autowired
    private QuizRepository quizRepository;

    //create
    @Override
    public Quiz addQuiz(Quiz quiz) {
        return this.quizRepository.save(quiz);
    }

    //uodate
    @Override
    public Quiz updateQuiz(Quiz quiz) {
        return this.quizRepository.save(quiz);
    }

    //get all
    @Override
    public Set<Quiz> getAllQuizzes() {
        return new LinkedHashSet<>(this.quizRepository.findAll());
    }

    //get by id
    @Override
    public Quiz getQuizById(Long quizId) {
        return this.quizRepository.getById(quizId);
    }

    //delete by id
    @Override
    public void deleteQuizById(Long quizId) {

        Quiz quiz = new Quiz();
        quiz.setQid(quizId);
        this.quizRepository.delete(quiz);

    }

    @Override
    public List<Quiz> findQuizzesByCategoryId(Category category) {

        List<Quiz> listOfQuizzesByCategory=this.quizRepository.findQuizzesByCategory(category);

        System.out.println(listOfQuizzesByCategory);

        return this.quizRepository.findQuizzesByCategory(category);

    }

    @Override
    public List<Quiz> findAllActiveQuiz() {

        return this.quizRepository.findByActive(true);
    }

    @Override
    public List<Quiz> findAllActiveQuizOfCategory(Category category) {

        return this.quizRepository.findByCategoryAndActive(category, true);
    }

}
