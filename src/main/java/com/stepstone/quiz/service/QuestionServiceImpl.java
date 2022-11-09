package com.stepstone.quiz.service;

import com.stepstone.quiz.repository.QuestionRepository;
import com.stepstone.quiz.repository.QuizModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Objects;

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

    public List<String> getAll() {
        return questionRepository.findAll();
    }

    public List<String> getByType(QuizModel.QuizType type) {
        return questionRepository.findByType(type);
    }

    public Boolean checkAnswer(String question, String answer) {
        if (!StringUtils.hasLength(question) || !StringUtils.hasLength(answer)) {
            return false;
        }
        String trueAnswer = questionRepository.findAnswer(question);
        if (!StringUtils.hasLength(trueAnswer)) {
//            throw exception?
            return false;
        }
        return Objects.equals(trueAnswer, answer);
    }
}
