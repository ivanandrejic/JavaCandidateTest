package com.stepstone.quiz.service;

import com.stepstone.quiz.repository.QuestionRepository;
import org.junit.jupiter.api.Test;

import java.util.List;

import static com.stepstone.quiz.controller.QuestionControllerTest.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.notNullValue;
import static org.hamcrest.core.Is.is;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Tests for Question Service
 */
public class QuestionServiceTest {

    @Test
    public void getAll_should_return_questions(){
        // given
        final var mockQuestionRepository = mock(QuestionRepository.class);
        final var questionService = new QuestionServiceImpl(mockQuestionRepository);

        // when
        when(mockQuestionRepository.findAll()).thenReturn(List.of(SOME_QUESTION));
        final var questions = questionService.getAll();

        // then
        assertThat(questions, is(hasSize(1)));
    }

    @Test
    public void checkAnswer_should_return_true(){
        // given
        final var mockQuestionRepository = mock(QuestionRepository.class);
        final var questionService = new QuestionServiceImpl(mockQuestionRepository);

        // when
        when(mockQuestionRepository.findAnswer(SOME_QUESTION)).thenReturn(TRUE_ANSWER);
        final var isTrueAnswer = questionService.checkAnswer(SOME_QUESTION, TRUE_ANSWER);

        // then
        assertThat(isTrueAnswer, is(true));
    }

    @Test
    public void badRequest_should_return_false(){
        // given
        final var mockQuestionRepository = mock(QuestionRepository.class);
        final var questionService = new QuestionServiceImpl(mockQuestionRepository);

        // when
        when(mockQuestionRepository.findAnswer(SOME_QUESTION)).thenReturn(TRUE_ANSWER);
        final var isTrueAnswer = questionService.checkAnswer(null, null);

        // then
        assertThat(isTrueAnswer, is(false));
    }

    @Test
    public void missingQuestion_should_return_false(){
        // given
        final var mockQuestionRepository = mock(QuestionRepository.class);
        final var questionService = new QuestionServiceImpl(mockQuestionRepository);

        // when
        when(mockQuestionRepository.findAnswer(SOME_QUESTION)).thenReturn(TRUE_ANSWER);
        final var isTrueAnswer = questionService.checkAnswer("wrongQuestion", TRUE_ANSWER);

        // then
        assertThat(isTrueAnswer, is(false));
    }

    @Test
    public void getByType_should_return_questions(){
        // given
        final var mockQuestionRepository = mock(QuestionRepository.class);
        final var questionService = new QuestionServiceImpl(mockQuestionRepository);

        // when
        when(mockQuestionRepository.findByType(TEST_TYPE)).thenReturn(List.of(SOME_QUESTION));
        final var questions = questionService.getByType(TEST_TYPE);

        // then
        assertThat(questions, is(notNullValue()));
    }
}
