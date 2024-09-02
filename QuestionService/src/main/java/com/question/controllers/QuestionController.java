package com.question.controllers;

import com.question.entities.Question;
import com.question.services.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/question")
public class QuestionController {

    @Autowired
    private QuestionService questionService;

    @PostMapping
    public Question create(@RequestBody Question question){
        return questionService.create(question);
    }

    @GetMapping
    public List<Question> getAll(){
        return questionService.getAllQuestions();
    }

    @GetMapping("/{id}")
    public Question getById(@PathVariable Long id){
        return questionService.getOne(id);
    }

    @GetMapping("quiz/{quizId}")
    public List<Question> getAllQuestionByQuizId(@PathVariable Long quizId){
        return questionService.getAllQuestionsByQuizId(quizId);
    }
}
