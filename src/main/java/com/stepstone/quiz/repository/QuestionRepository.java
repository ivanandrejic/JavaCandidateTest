package com.stepstone.quiz.repository;

import java.util.List;

/**
 * Question Repository Interface
 */
public interface QuestionRepository {
    List<QuizModel> findAll();
    QuizModel findByQuestionIdAndAnswer(Long questionId, String answer);
    List<QuizModel> findByType(QuizModel.QuizType type);
}
