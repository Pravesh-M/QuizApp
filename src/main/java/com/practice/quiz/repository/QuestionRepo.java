package com.practice.quiz.repository;

import com.practice.quiz.model.Category;
import com.practice.quiz.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface QuestionRepo extends JpaRepository<Question,Long> {

    List<Question> findByCategory(Category category);
}
