package com.practice.quiz.service;

import com.practice.quiz.model.*;
import com.practice.quiz.repository.QuestionRepo;
import com.practice.quiz.repository.QuizRepo;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
        //Saving Quiz and returning Quiz ID
        return quizRepo.save(quiz).getQuizId();
    }

    public List<QuestionWrapper> getQuiz(long quizId) {
        //Checking Quiz is Present with quizId
        Quiz quiz = quizRepo.findById(quizId)
                .orElseThrow(() -> new EntityNotFoundException("Quiz With QuizId : "+quizId+" Not Found"));
        List<QuestionWrapper> questionsForUser =  new ArrayList<>();

        //Mapping Questions to QuestionWrapper
        for(Question q : quiz.getQuestions()) {
            questionsForUser.add(new QuestionWrapper(q.getQuestionId(),q.getQuestionText(),q.getOptions()));
        }
        return questionsForUser;
    }

    public int getMarks(long quizId, List<QuizResponse> response) {
        Quiz quiz = quizRepo.findById(quizId)
                .orElseThrow(() -> new EntityNotFoundException("Quiz With QuizId : "+quizId+" Not Found"));

        int marks = 0;
        int i=0;

        //Calculating Marks
        for(Question q : quiz.getQuestions()) {
            //Checking Selected Option is Corrected or Not
            if(q.getCorrectAnswer().equals(response.get(i).getSelectedOption())) {
                marks++;
            }
            i++;
        }
        return marks;
    }
}
