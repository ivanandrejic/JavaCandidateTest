package com.stepstone.quiz.controller;

import com.stepstone.quiz.service.QuestionService;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.notNullValue;
import static org.hamcrest.core.Is.is;
import static org.mockito.Mockito.mock;

/**
 * Tests for Question Controller
 */
public class QuestionControllerTest {

    @Test
    public void getQuestions_should_return_questions() {
        // given
        final var questionService = mock(QuestionService.class);
        final var questionController = new QuestionController(questionService);

        //when
        final var questions = questionController.getAll();

        // then
        assertThat(questions, is(notNullValue()));
    }

}
