package com.practice.quiz.controller;

import com.practice.quiz.model.QuestionWrapper;
import com.practice.quiz.model.QuizResponse;
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
    public ResponseEntity<List<QuestionWrapper>> getQuiz(@PathVariable long quizId) {
        return new ResponseEntity<>(service.getQuiz(quizId), HttpStatus.FOUND);
    }

    @PostMapping("/submit/{quizId}")
    public ResponseEntity<String> submitQuiz(@PathVariable long quizId, @RequestBody List<QuizResponse> response) {
        int marks = service.getMarks(quizId,response);
        return new ResponseEntity<>("Total Marks for the Quiz are : "+marks,HttpStatus.OK);
    }
}
