package ru.tt.coursspring2.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.tt.coursspring2.model.Question;
import ru.tt.coursspring2.service.ExaminerService;
import ru.tt.coursspring2.service.ExaminerServiceImpl;


import java.util.Collection;

@RestController
@RequestMapping("/exam/java")
public class ExaminerController {
    private final ExaminerService examinerService;

    public ExaminerController(ExaminerServiceImpl examinerServiceImpl) {
        this.examinerService = examinerServiceImpl;
    }
    @GetMapping(value ="/get", params = "amount")
    public Collection<Question> getQuestions(@RequestParam int amount){
        return examinerService.getQuestions(amount);
    }
}
