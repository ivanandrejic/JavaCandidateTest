package com.stepstone.quiz.controller;

import com.stepstone.quiz.repository.QuizModel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class QuizDTO {
    private final Long id;
    private final String question;
    private final QuizModel.QuizType type;
}
