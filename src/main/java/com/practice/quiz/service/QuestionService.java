package com.practice.quiz.service;

import com.practice.quiz.model.Category;
import com.practice.quiz.model.Question;
import com.practice.quiz.repository.QuestionRepo;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class QuestionService {

    @Autowired
    private QuestionRepo repo;

    public void addQuestion(Question question) {
        repo.save(question);
    }

    public Question getQuestion(long questionId) {
        return repo.findById(questionId)
                .orElseThrow(() -> new EntityNotFoundException("Question With QuestionId : "+questionId+" Not Found"));
    }
    public List<Question> getAll() {
        return repo.findAll();
    }

    public List<Question> getByCategory(Category category) {
        return repo.findByCategory(category);
    }
    public void updateQuestion(long questionId, Question question) {
        Question dbQuestion = getQuestion(questionId);
        dbQuestion.setQuestionText(question.getQuestionText());
        dbQuestion.setOptions(question.getOptions());
        dbQuestion.setCategory(question.getCategory());
        dbQuestion.setLevel(question.getLevel());
        dbQuestion.setCorrectAnswer(question.getCorrectAnswer());

        repo.save(dbQuestion);
    }
    public void deleteQuestion(long questionId) {
        repo.deleteById(questionId);
    }

}
