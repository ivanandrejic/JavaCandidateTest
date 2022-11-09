package com.stepstone.quiz.repository;

import org.junit.jupiter.api.Test;

import static com.stepstone.quiz.controller.QuestionControllerTest.TEST_TYPE;
import static com.stepstone.quiz.controller.QuestionControllerTest.TRUE_ANSWER;
import static com.stepstone.quiz.repository.QuestionRepositoryImpl.data;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.notNullValue;
import static org.hamcrest.core.Is.is;

/**
 * Tests for Question Repository
 */

public class QuestionRepositoryTest {

    @Test
    public void findAll_should_return_questions(){
        // given
        final var questionRepository = new QuestionRepositoryImpl();

        // when
        final var questions = questionRepository.findAll();

        // then
        assertThat(questions, is(notNullValue()));
        assertThat(questions, is(hasSize(data.size())));
    }

    @Test
    public void findByType_should_return_questions(){
        // given
        final var questionRepository = new QuestionRepositoryImpl();

        // when
        final var questions = questionRepository.findByType(TEST_TYPE);

        // then
        assertThat(questions, is(notNullValue()));
        assertThat(questions, is(hasSize(4)));
    }


    @Test
    public void findAnswer_should_return_answer(){
        // given
        final var questionRepository = new QuestionRepositoryImpl();

        // when
        final var quizModel = questionRepository.findByQuestionIdAndAnswer(1L, TRUE_ANSWER);

        // then
        assertThat(quizModel, is(notNullValue()));
    }
}
