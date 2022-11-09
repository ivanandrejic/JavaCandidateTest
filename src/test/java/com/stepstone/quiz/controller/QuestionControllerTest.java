package com.stepstone.quiz.controller;

import com.stepstone.quiz.repository.QuizModel;
import com.stepstone.quiz.service.QuestionService;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.notNullValue;
import static org.hamcrest.core.Is.is;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Tests for Question Controller
 */
public class QuestionControllerTest {

    public static final String SOME_QUESTION = "What is the capital of Cuba?";
    public static final String TRUE_ANSWER = "Havana";
    public static final QuizModel.QuizType TEST_TYPE = QuizModel.QuizType.GEOGRAPHY;

    public static final QuizDTO QUIZ_DTO = new QuizDTO(1L, SOME_QUESTION, TEST_TYPE);
    public static final QuizModel QUIZ_MODEL = new QuizModel(1L, SOME_QUESTION, TRUE_ANSWER, TEST_TYPE);

    @Test
    public void getQuestions_should_return_questions() {
        // given
        final var questionService = mock(QuestionService.class);
        final var questionController = new QuestionController(questionService);

        //when
        when(questionService.getAll()).thenReturn(List.of(QUIZ_DTO));
        final var questions = questionController.getAll();

        // then
        assertThat(questions, is(notNullValue()));
        assertThat(questions, hasSize(1));
    }

    @Test
    public void getByType_should_return_questions() {
        // given
        final var questionService = mock(QuestionService.class);
        final var questionController = new QuestionController(questionService);

        //when
        when(questionService.getByType(TEST_TYPE)).thenReturn(List.of(QUIZ_DTO));
        final var questions = questionController.getByType(TEST_TYPE);

        // then
        assertThat(questions, is(notNullValue()));
        assertThat(questions, hasSize(1));
    }

    @Test
    public void trueAnswer_should_return_true() {
        // given
        final var questionService = mock(QuestionService.class);
        final var questionController = new QuestionController(questionService);

        //when
        when(questionService.getByAnswer(1L, TRUE_ANSWER)).thenReturn(QUIZ_DTO);
        final var response = questionController.getByAnswer(1L, TRUE_ANSWER);

        // then
        assertThat(response, is(notNullValue()));
        assertThat(response, is(QUIZ_DTO));
    }

}
