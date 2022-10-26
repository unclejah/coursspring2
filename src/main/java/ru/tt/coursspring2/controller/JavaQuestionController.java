package ru.tt.coursspring2.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.tt.coursspring2.model.Question;
import ru.tt.coursspring2.service.JavaQuestionServiceImpl;
import ru.tt.coursspring2.service.QuestionService;

import java.util.Collection;

@RestController
@RequestMapping("/exam/java")
public class JavaQuestionController {

    private final QuestionService questionService;

    public JavaQuestionController(JavaQuestionServiceImpl javaQuestionServiceImpl) {
        this.questionService = javaQuestionServiceImpl;
    }

    @GetMapping("/add")
    public Question addQuestion(@RequestParam String question, @RequestParam String answer){
        return questionService.add(question,answer);
    }
    @GetMapping("/remove")
    public Boolean removeQuestion(@RequestParam String question, @RequestParam String answer){
        Question question1 = new Question(question,answer);
        return questionService.remove(question1);
    }
    @GetMapping(value = "/")
    public Collection<Question> getQuestions(){
        return  questionService.getAll();
    }
}
