package ru.tt.coursspring2.service;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import ru.tt.coursspring2.exeptions.ExeptionEmpty;
import ru.tt.coursspring2.model.Question;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class JavaQuestionServiceImpl implements QuestionService{
    private final Set<Question> questions;

    public JavaQuestionServiceImpl() {
        this.questions = new HashSet<>();
    }

    @Override
    public Question add(String question, String answer) {

        if(StringUtils.isEmpty(question)||StringUtils.isEmpty(answer)){
            throw new ExeptionEmpty("Empty paratere");
        }
        Question question1 = new Question(question,answer);
        questions.add(question1);
        return question1;
    }

    @Override
    public Question add(Question question) {
        if(StringUtils.isEmpty(question.getQuestion())||StringUtils.isEmpty(question.getAnswer())){
            throw new ExeptionEmpty("Empty paratere");
        }
        questions.add(question);
        return question;
    }

    @Override
    public Question remove(Question question) {
        if(StringUtils.isEmpty(question.getQuestion())||StringUtils.isEmpty(question.getAnswer())){
            throw new ExeptionEmpty("Empty parameter");
        }
        questions.remove(question);
        return question;
    }

    @Override
    public Collection<Question> getAll() {
        return questions.stream().collect(Collectors.toList());
    }

    @Override
    public Question getRandQuestion() {

        Question[] arrayQuestions = questions.toArray(new Question[questions.size()]);

        Random rndm = new Random();

        int rndmNumber = rndm.nextInt(questions.size());

        return arrayQuestions[rndmNumber];
    }
}
