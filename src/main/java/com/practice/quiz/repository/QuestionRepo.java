package com.practice.quiz.repository;

import com.practice.quiz.model.Category;
import com.practice.quiz.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface QuestionRepo extends JpaRepository<Question,Long> {

    List<Question> findByCategory(Category category);

    @Query("SELECT q FROM Question q WHERE q.category = :category ORDER BY RAND() LIMIT :noOfQuestions")
    List<Question> findRandomQuestionsByCategory(Category category, int noOfQuestions);
}
