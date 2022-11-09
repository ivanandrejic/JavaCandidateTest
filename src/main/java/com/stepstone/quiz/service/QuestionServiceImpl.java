package com.stepstone.quiz.service;

import com.stepstone.quiz.controller.QuizDTO;
import com.stepstone.quiz.repository.QuestionRepository;
import com.stepstone.quiz.repository.QuizModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Question Service implementation
 */
@Service
public class QuestionServiceImpl implements QuestionService {

    private final QuestionRepository questionRepository;

    @Autowired
    public QuestionServiceImpl(final QuestionRepository questionRepository){
        this.questionRepository = questionRepository;
    }

    public List<QuizDTO> getAll() {
        return questionRepository.findAll()
                .stream()
                .map(quizModel -> new QuizDTO(quizModel.getId(), quizModel.getQuestion(), quizModel.getType()))
                .collect(Collectors.toList());
    }

    public List<QuizDTO> getByType(QuizModel.QuizType type) {
        return questionRepository.findByType(type)
                .stream()
                .map(quizModel -> new QuizDTO(quizModel.getId(), quizModel.getQuestion(), quizModel.getType()))
                .collect(Collectors.toList());
    }

    public QuizDTO getByAnswer(Long questionId, String answer) {
        if (questionId == null || !StringUtils.hasLength(answer)) {
            throw new IllegalArgumentException();
        }
        QuizModel quizModel = questionRepository.findByQuestionIdAndAnswer(questionId, answer);
        if (quizModel == null) {
            throw new IllegalStateException();
        }
        return new QuizDTO(quizModel.getId(), quizModel.getQuestion(), quizModel.getType());
    }
}
