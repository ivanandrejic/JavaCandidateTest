package com.stepstone.quiz.controller;

import com.stepstone.quiz.service.QuestionService;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    public List<String> getAll(){
        return questionService.getAll();
    }

    @GetMapping("/questions/{type}")
    public List<String> getByType(@RequestParam(name = "type") String type){
        return questionService.getByType(type);
    }

    @PostMapping("/check-answer")
    public Boolean checkAnswer(@RequestBody CheckAnswerRequest request){
        return questionService.checkAnswer(request.getQuestion(), request.getAnswer());
    }

    @Getter@Setter
    public static class CheckAnswerRequest {
        private String question;
        private String answer;
    }

}
