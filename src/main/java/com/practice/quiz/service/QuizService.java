package com.practice.quiz.service;

import com.practice.quiz.model.Category;
import com.practice.quiz.model.Question;
import com.practice.quiz.model.Quiz;
import com.practice.quiz.repository.QuestionRepo;
import com.practice.quiz.repository.QuizRepo;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuizService {

    @Autowired
    private QuizRepo quizRepo;

    @Autowired
    private QuestionRepo questionRepo;


    public long createQuiz(String quizName, int noOfQuestions, String category) {

        List<Question> questions = questionRepo.findRandomQuestionsByCategory(Category.valueOf(category.toUpperCase()),noOfQuestions);

        Quiz quiz = new Quiz();
        quiz.setQuizName(quizName);
        quiz.setQuestions(questions);
        return quizRepo.save(quiz).getQuizId();
    }

    public Quiz getQuiz(long quizId) {
        return quizRepo.findById(quizId)
                .orElseThrow(() -> new EntityNotFoundException("Quiz With QuizId : "+quizId+" Not Found"));
    }
}
