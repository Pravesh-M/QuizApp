package com.practice.quiz.controller;


import com.practice.quiz.model.Category;
import com.practice.quiz.model.Question;
import com.practice.quiz.model.Quiz;
import com.practice.quiz.repository.QuestionRepo;
import com.practice.quiz.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("quiz")
public class QuizController {

    @Autowired
    private QuizService service;


    @PostMapping("/{quizName}/{category}/{noOfQuestions}")
    public ResponseEntity<String> createQuiz(@PathVariable String quizName,@PathVariable String category,@PathVariable int noOfQuestions) {
        long quizId = service.createQuiz(quizName,noOfQuestions,category);
        return new ResponseEntity<>("Quiz : "+quizName+" Created with Quiz Id : "+quizId, HttpStatus.CREATED);
    }

    @GetMapping("/{quizId}")
    public ResponseEntity<Quiz> getQuiz(@PathVariable long quizId) {
        return new ResponseEntity<>(service.getQuiz(quizId), HttpStatus.FOUND);
    }


}
