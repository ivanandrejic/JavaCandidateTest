package com.stepstone.quiz.controller;

import com.stepstone.quiz.repository.QuizModel;
import com.stepstone.quiz.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

/**
 * Question Controller class
 */
@RestController
public class QuestionController {

    private QuestionService questionService;

    @Autowired
    public QuestionController(QuestionService questionService){
        this.questionService = questionService;
    }

    @GetMapping("/questions")
    public List<QuizDTO> getAll(){
        return questionService.getAll();
    }

    @GetMapping("/questions/search/byType")
    public List<QuizDTO> getByType(@RequestParam (name = "type") QuizModel.QuizType type){
        return questionService.getByType(type);
    }

    @GetMapping("/questions/search/byAnswer")
    public QuizDTO getByAnswer(@RequestParam (name = "questionId") Long questionId, @RequestParam (name = "answer") String answer){
        try {
            return questionService.getByAnswer(questionId, answer);
        } catch (IllegalStateException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Wrong Answer");
        } catch (IllegalArgumentException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
    }

}
