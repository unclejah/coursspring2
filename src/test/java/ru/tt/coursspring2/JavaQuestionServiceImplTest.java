package ru.tt.coursspring2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.tt.coursspring2.exeptions.ExeptionEmpty;
import ru.tt.coursspring2.exeptions.ExeptionOverSize;
import ru.tt.coursspring2.model.Question;
import ru.tt.coursspring2.service.JavaQuestionServiceImpl;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.mockito.Mockito.when;

public class JavaQuestionServiceImplTest {
    private JavaQuestionServiceImpl javaQuestionService = new JavaQuestionServiceImpl();
    private List<Question> expected = Arrays.asList(
            new Question("q1", "q1"),
            new Question("q2", "q2"),
            new Question("q3", "q3"),
            new Question("q4", "q4"),
            new Question("q5", "q5")
    );


    @Test
    public void testGetAll(){
        javaQuestionService.add(expected.get(0));
        javaQuestionService.add(expected.get(1));
        javaQuestionService.add(expected.get(2));
        javaQuestionService.add(expected.get(3));
        javaQuestionService.add(expected.get(4));
        assertThat(javaQuestionService.getAll()).
                isNotEmpty()
                .hasSize(5)
                .isEqualTo(expected.stream().collect(Collectors.toList()));

    }
    @Test
    public void testGetRandQuestion(){
        javaQuestionService.add(expected.get(0));
        assertThat(javaQuestionService.getRandQuestion())
                .isEqualTo(expected.get(0));
    }
    @Test
    public void testEmptyString(){
        assertThatExceptionOfType(ExeptionEmpty.class)
                .isThrownBy(()->javaQuestionService.add("asd",""));
    }
    @Test
    public void testAdd(){
        assertThat(javaQuestionService.add("q2","q2"))
                .isEqualTo(expected.get(1));
}
    @Test
    public void testRemvoe(){
        assertThat(javaQuestionService.remove(expected.get(2)))
                .isEqualTo(expected.get(2));
    }
}
