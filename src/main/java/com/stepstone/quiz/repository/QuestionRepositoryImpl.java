package com.stepstone.quiz.repository;

import lombok.Getter;
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
            new QuizModel("What is the capital of Cuba?", "Havana", "Geography"),
            new QuizModel("What is the capital of France?", "Paris", "Geography"),
            new QuizModel("What is the capital of Poland?", "Warsaw", "Geography"),
            new QuizModel("What is the capital of Germany?", "Berlin", "Geography"),
            new QuizModel("What is the hardest natural substance on Earth?", "Diamond", "Science")
    );

    public List<String> findAll() {
        return data.stream()
                .map(QuizModel::getQuestion)
                .collect(Collectors.toList());
    }

    public List<String> findByType(final String type) {
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

    @Getter
    private static class QuizModel {
        private final String question;
        private final String answer;
        private final String type;

        private QuizModel(String question, String answer, String type) {
            this.question = question;
            this.answer = answer;
            this.type = type;
        }
    }

}
