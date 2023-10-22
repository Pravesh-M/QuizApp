package com.practice.quiz.model;

import lombok.Data;

@Data
public class QuizResponse {

    private long questionId;
    private String selectedOption;
}
