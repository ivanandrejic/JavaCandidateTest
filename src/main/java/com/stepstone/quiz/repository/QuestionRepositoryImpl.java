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
            new QuizModel("What is the capital of Cuba?", "Havana", QuizModel.QuizType.GEOGRAPHY),
            new QuizModel("What is the capital of France?", "Paris", QuizModel.QuizType.GEOGRAPHY),
            new QuizModel("What is the capital of Poland?", "Warsaw", QuizModel.QuizType.GEOGRAPHY),
            new QuizModel("What is the capital of Germany?", "Berlin", QuizModel.QuizType.GEOGRAPHY),
            new QuizModel("What is the hardest natural substance on Earth?", "Diamond", QuizModel.QuizType.SCIENCE)
    );

    public List<String> findAll() {
        return data.stream()
                .map(QuizModel::getQuestion)
                .collect(Collectors.toList());
    }

    public List<String> findByType(final QuizModel.QuizType type) {
        return data.stream()
                .filter(quizModel ->  Objects.equals(quizModel.getType(), type))
                .map(QuizModel::getQuestion)
                .collect(Collectors.toList());
    }

    public String findAnswer(final String question) {
        return data.stream()
                .filter(quizModel -> Objects.equals(quizModel.getQuestion(), question))
                .map(QuizModel::getAnswer)
                .findAny()
                .orElse(null);
    }



}
