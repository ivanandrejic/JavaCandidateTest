package com.stepstone.quiz.repository;

import lombok.Getter;

@Getter
public class QuizModel {

    public enum QuizType {
        GEOGRAPHY, SCIENCE
    }

    private final String question;
    private final String answer;
    private final QuizType type;

    QuizModel(String question, String answer, QuizType type) {
        this.question = question;
        this.answer = answer;
        this.type = type;
    }
}
