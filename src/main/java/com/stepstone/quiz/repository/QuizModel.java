package com.stepstone.quiz.repository;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class QuizModel {

    public enum QuizType {
        GEOGRAPHY, SCIENCE
    }

    private final Long id;
    private final String question;
    private final String answer;
    private final QuizType type;

}
