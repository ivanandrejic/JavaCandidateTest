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
        when(mockQuestionRepository.findAll()).thenReturn(List.of(QUIZ_MODEL));
        final var questions = questionService.getAll();

        // then
        assertThat(questions, is(notNullValue()));
        assertThat(questions, is(hasSize(1)));
    }

    @Test
    public void checkAnswer_should_return_true(){
        // given
        final var mockQuestionRepository = mock(QuestionRepository.class);
        final var questionService = new QuestionServiceImpl(mockQuestionRepository);

        // when
        when(mockQuestionRepository.findByQuestionIdAndAnswer(1L, TRUE_ANSWER)).thenReturn(QUIZ_MODEL);
        final var quizDTO = questionService.getByAnswer(1L, TRUE_ANSWER);

        // then
        assertThat(quizDTO, is(notNullValue()));
        assertThat(quizDTO.getId(), is(1L));
    }

    @Test
    public void getByType_should_return_questions(){
        // given
        final var mockQuestionRepository = mock(QuestionRepository.class);
        final var questionService = new QuestionServiceImpl(mockQuestionRepository);

        // when
        when(mockQuestionRepository.findByType(TEST_TYPE)).thenReturn(List.of(QUIZ_MODEL));
        final var questions = questionService.getByType(TEST_TYPE);

        // then
        assertThat(questions, is(notNullValue()));
    }
}
