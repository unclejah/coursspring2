package ru.tt.coursspring2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.tt.coursspring2.exeptions.OversizeException;
import ru.tt.coursspring2.model.Question;
import ru.tt.coursspring2.service.ExaminerServiceImpl;
import ru.tt.coursspring2.service.JavaQuestionServiceImpl;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ExaminerServiceImplTest {

    @Mock
    private JavaQuestionServiceImpl javaQuestionService;
    @InjectMocks
    private ExaminerServiceImpl examinerService;
    private List<Question> expected = Arrays.asList(
            new Question("q1", "q1"),
            new Question("q2", "q2"),
            new Question("q3", "q3"),
            new Question("q4", "q4"),
            new Question("q5", "q5")
    );
    @BeforeEach
    public void beforeEach (){
        when(javaQuestionService.getAll()).thenReturn(
                expected.stream().collect(Collectors.toList())
        );
    }
    @Test
    public void testOverSize(){
        assertThatExceptionOfType(OversizeException.class)
                .isThrownBy(()->examinerService.getQuestions(10));
    }

    @Test
    public void testQuestions(){

        when(javaQuestionService.getRandQuestion()).thenReturn(
                new Question("q1", "q1")
        );
        assertThat(examinerService.getQuestions(1)).
                isNotEmpty()
                .hasSize(1)
                .contains(expected.get(0));

    }
}

