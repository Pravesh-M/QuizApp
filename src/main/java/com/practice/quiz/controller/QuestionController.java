package com.practice.quiz.controller;

import com.practice.quiz.model.Category;
import com.practice.quiz.model.Question;
import com.practice.quiz.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("question")
public class QuestionController {
    @Autowired
    private QuestionService service;

    @PostMapping
    public ResponseEntity<String> addQuestion(@RequestBody Question question) {
        service.addQuestion(question);
        return new ResponseEntity<>("Question Added", HttpStatus.CREATED);
    }

    @GetMapping("/{questionId}")
    public ResponseEntity<Question> getQuestion(@PathVariable long questionId) {
        return new ResponseEntity<>(service.getQuestion(questionId),HttpStatus.FOUND);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Question>> getAll() {
        return new ResponseEntity<>(service.getAll(),HttpStatus.FOUND);
    }

    @GetMapping("category/{category}")
    public ResponseEntity<List<Question>> getByCategory(@PathVariable String category) {
        return new ResponseEntity<>(service.getByCategory(Category.valueOf(category.toUpperCase())),HttpStatus.FOUND);
    }

    @PutMapping("/{questionId}")
    public ResponseEntity<String> updateQuestion(@PathVariable long questionId, @RequestBody Question question) {
        service.updateQuestion(questionId,question);
        return new ResponseEntity<>("Question Updated",HttpStatus.OK);
    }

    @DeleteMapping("/{questionId}")
    public ResponseEntity<String> deleteQuestion(@PathVariable long questionId) {
        service.deleteQuestion(questionId);
        return new ResponseEntity<>("Question Deleted", HttpStatus.OK);
    }

}
