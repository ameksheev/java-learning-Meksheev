import org.example.Homework;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class HomeworkTestClass {

    @BeforeEach
    void before() {
        System.out.println("========================");
        System.out.println("Test method start");
    }
    @AfterEach
    void after() {
        System.out.println("Test method end");
        System.out.println("========================");
    }

    @Test
    void testIsEven() {
        Random random = new Random();
        int randomNumber = random.nextInt(101);
        boolean result = Homework.isEven(randomNumber);
        System.out.println("Метод isEven: " + randomNumber + " = " + result);

    }

    @RepeatedTest(20)
    void testCheckAccess() {
        Random random = new Random();
        int age = random.nextInt(100);
        String access = Homework.checkAccess(age);
        System.out.println("Метод checkAccess: " + age + " = " + access);
    }

    static List<Integer> randomNumbers() {
        List<Integer> numbers = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < 3; i++) {
            numbers.add(random.nextInt(101));
        }
        return numbers;
    }

    @ParameterizedTest
    @MethodSource("randomNumbers")
    void testGetGrade(int score) {
        String grade = Homework.getGrade(score);
        System.out.println("Метод getGrade: " + score + " = " + grade);
    }

}
