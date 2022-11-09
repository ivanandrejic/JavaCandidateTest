package com.stepstone.quiz.service;

import com.stepstone.quiz.controller.QuizDTO;
import com.stepstone.quiz.repository.QuizModel;

import java.util.List;

/**
 *  Question Service Interface
 */
public interface QuestionService {
    List<QuizDTO> getAll();

    List<QuizDTO> getByType(QuizModel.QuizType type);

    QuizDTO getByAnswer(Long questionId, String answer);
}
