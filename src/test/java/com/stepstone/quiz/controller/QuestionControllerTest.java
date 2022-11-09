package com.stepstone.quiz.controller;

import com.stepstone.quiz.service.QuestionService;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.core.Is.is;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Tests for Question Controller
 */
public class QuestionControllerTest {

    public static final String SOME_QUESTION = "What is the capital of Cuba?";
    public static final String TRUE_ANSWER = "Havana";
    public static final String TEST_TYPE = "Geography";

    @Test
    public void getQuestions_should_return_questions() {
        // given
        final var questionService = mock(QuestionService.class);
        final var questionController = new QuestionController(questionService);

        //when
        when(questionService.getAll()).thenReturn(List.of(SOME_QUESTION));
        final var questions = questionController.getAll();

        // then
        assertThat(questions, hasSize(1));
    }

    @Test
    public void getByType_should_return_questions() {
        // given
        final var questionService = mock(QuestionService.class);
        final var questionController = new QuestionController(questionService);

        //when
        when(questionService.getByType(TEST_TYPE)).thenReturn(List.of(SOME_QUESTION));
        final var questions = questionController.getByType(TEST_TYPE);

        // then
        assertThat(questions, hasSize(1));
    }

    @Test
    public void trueAnswer_should_return_true() {
        // given
        final var questionService = mock(QuestionService.class);
        final var questionController = new QuestionController(questionService);

        //when
        QuestionController.CheckAnswerRequest request = new QuestionController.CheckAnswerRequest();
        request.setQuestion(SOME_QUESTION);

        request.setAnswer(TRUE_ANSWER);
        when(questionService.checkAnswer(SOME_QUESTION, TRUE_ANSWER)).thenReturn(true);
        final var isTrueAnswer = questionController.checkAnswer(request);

        // then
        assertThat(isTrueAnswer, is(true));
    }

}
