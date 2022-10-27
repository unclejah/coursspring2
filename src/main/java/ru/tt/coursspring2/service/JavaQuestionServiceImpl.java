package ru.tt.coursspring2.service;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import ru.tt.coursspring2.exeptions.EmptyInputParamException;
import ru.tt.coursspring2.exeptions.UserNotRemovedException;
import ru.tt.coursspring2.model.Question;

import java.util.*;

@Service
public class JavaQuestionServiceImpl implements QuestionService{
    private final Set<Question> questions;

    public JavaQuestionServiceImpl() {
        this.questions = new HashSet<>();
    }

    @Override
    public Question add(String question, String answer) {

        if(StringUtils.isEmpty(question)||StringUtils.isEmpty(answer)){
            throw new EmptyInputParamException("Empty paratere");
        }
        Question question1 = new Question(question,answer);
        questions.add(question1);
        return question1;
    }

    @Override
    public Question add(Question question) {
        if(StringUtils.isEmpty(question.getQuestion())||StringUtils.isEmpty(question.getAnswer())){
            throw new EmptyInputParamException("Empty paratere");
        }
        questions.add(question);
        return question;
    }

    @Override
    public Question remove(Question question) {
        if(StringUtils.isEmpty(question.getQuestion())||StringUtils.isEmpty(question.getAnswer())){
            throw new EmptyInputParamException("Empty parameter");
        }
        boolean isRemoved = questions.remove(question);
        if (isRemoved == false) { throw new UserNotRemovedException("User not removed");  }
        return question;
    }

    @Override
    public Collection<Question> getAll() {
        return new ArrayList<Question>(questions);
    }

    @Override
    public Question getRandQuestion() {

        Question[] arrayQuestions = questions.toArray(new Question[questions.size()]);

        Random rndm = new Random();

        int rndmNumber = rndm.nextInt(questions.size());

        return arrayQuestions[rndmNumber];
    }
}
