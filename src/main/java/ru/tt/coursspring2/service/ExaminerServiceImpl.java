package ru.tt.coursspring2.service;

import org.springframework.stereotype.Service;
import ru.tt.coursspring2.exeptions.ExeptionOverSize;
import ru.tt.coursspring2.model.Question;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Service
public class ExaminerServiceImpl implements ExaminerService{
    private final JavaQuestionServiceImpl javaQuestionService;

    public ExaminerServiceImpl(JavaQuestionServiceImpl javaQuestionService) {
        this.javaQuestionService = javaQuestionService;
    }


    @Override
    public Collection<Question> getQuestion(int amount) {
        Set<Question> questions = new HashSet<>();
        if(amount > javaQuestionService.getAll().size()){
            throw new ExeptionOverSize("OverSize");
        }
        while (questions.size()!=amount){
            Question question = javaQuestionService.getRandQuestion();
            if(!questions.contains(question)){
                questions.add(javaQuestionService.getRandQuestion());
            }
        }
        return questions;
    }
}
