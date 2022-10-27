package ru.tt.coursspring2.service;

import org.springframework.stereotype.Service;
import ru.tt.coursspring2.exeptions.OversizeException;
import ru.tt.coursspring2.model.Question;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Service
public class ExaminerServiceImpl implements ExaminerService{
    private final QuestionService javaQuestionService;
    public ExaminerServiceImpl(QuestionService javaQuestionService) {
        this.javaQuestionService = javaQuestionService;
    }


    @Override
    public Collection<Question> getQuestions(int amount) {
        Set<Question> questions = new HashSet<>();
        if(amount > javaQuestionService.getAll().size()){
            throw new OversizeException("OverSize");
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
