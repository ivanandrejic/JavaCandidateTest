package com.stepstone.quiz.repository;

import java.util.List;

/**
 * Question Repository Interface
 */
public interface QuestionRepository {
    List<String> findAll();
    String findAnswer(String question);
    List<String> findByType(QuizModel.QuizType type);
}
