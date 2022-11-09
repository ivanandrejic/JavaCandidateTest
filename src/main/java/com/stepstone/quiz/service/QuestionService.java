package com.stepstone.quiz.service;

import com.stepstone.quiz.repository.QuizModel;

import java.util.List;

/**
 *  Question Service Interface
 */
public interface QuestionService {
    List<String> getAll();

    List<String> getByType(QuizModel.QuizType type);

    Boolean checkAnswer(String question, String answer);
}
