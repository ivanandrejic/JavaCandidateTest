package com.stepstone.quiz.repository;

import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * Static Question Repository implementation
 */
@Repository
public class QuestionRepositoryImpl implements QuestionRepository {

    static final List<QuizModel> data = List.of(
            new QuizModel(1L, "What is the capital of Cuba?", "Havana", QuizModel.QuizType.GEOGRAPHY),
            new QuizModel(2L, "What is the capital of France?", "Paris", QuizModel.QuizType.GEOGRAPHY),
            new QuizModel(3L, "What is the capital of Poland?", "Warsaw", QuizModel.QuizType.GEOGRAPHY),
            new QuizModel(4L, "What is the capital of Germany?", "Berlin", QuizModel.QuizType.GEOGRAPHY),
            new QuizModel(5L, "What is the hardest natural substance on Earth?", "Diamond", QuizModel.QuizType.SCIENCE)
    );

    public List<QuizModel> findAll() {
        return data;
    }

    public List<QuizModel> findByType(final QuizModel.QuizType type) {
        return data.stream()
                .filter(quizModel ->  quizModel.getType() == type)
                .collect(Collectors.toList());
    }

    public QuizModel findByQuestionIdAndAnswer(final Long questionId, final String answer) {
        return data.stream()
                .filter(quizModel -> Objects.equals(quizModel.getId(), questionId) && Objects.equals(quizModel.getAnswer(), answer))
                .findAny()
                .orElse(null);
    }



}
