package ru.tt.coursspring2.service;

import ru.tt.coursspring2.model.Question;

import java.util.Collection;
import java.util.Collections;

public interface ExaminerService {
    Collection<Question> getQuestion(int amount);
}
