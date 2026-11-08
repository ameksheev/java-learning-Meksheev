import org.example.Homework;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.as;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class TaskForWebinarOne {

    //Test 1
    @Tag("homework2")
    @RepeatedTest(10)
    void testIsPositive() {
        Random random = new Random();
        int randomNumber = random.nextInt(-100, 100);
        boolean isPositive = Homework.isPositive(randomNumber);
        boolean result = randomNumber >= 0;
        assertThat(result)
                .as("isPositive для числа " + randomNumber)
                .isEqualTo(isPositive);
    }

    //Test 2
    @Tag("homework2")
    @RepeatedTest(10)
    void testIsEven() {
        Random random = new Random();
        int randomNumber = random.nextInt(101);
        boolean result = Homework.isEven(randomNumber);
        boolean expectedResult = randomNumber % 2 == 0;
        assertThat(result)
                .as("isEven для числа " + randomNumber)
                .isEqualTo(expectedResult);
    }

    //Test 3
    @Tag("homework2")
    @RepeatedTest(10)
    void testCheckAccess() {
        Random random = new Random();
        int randomNumber = random.nextInt(0, 100);
        String result = Homework.checkAccess(randomNumber);
        String expectedResult = (randomNumber > 18) ? "Allowed" : "Denied";
        assertThat(result)
                .as("checkAccess для возраста " + randomNumber)
                .isEqualTo(expectedResult);
    }

    //Test 4
    @Tag("homework2")
    @RepeatedTest(10)
    void testSumToN() {
        Random random = new Random();
        int randomNumber = random.nextInt(0, 101);
        int result = Homework.sumToN(randomNumber);
        int expectedResult = 5050;
        assertThat(result)
                .as("sumToN для числа " + randomNumber)
                .isEqualTo(expectedResult);
    }

    //Test 5
    @Tag("homework2")
    @RepeatedTest(10)
    void testBlastOff() {
        int start = new Random().nextInt(1, 10);
        String result = Homework.blastOff(start);
        String expected = "5 4 3 2 1 Поехали!";
        assertThat(result)
                .as("blastOff для start = " + start)
                .isEqualTo(expected);
    }

    //Test 6
    @Tag("homework2")
    @RepeatedTest(10)
    void testFindMax() {
        Random random = new Random();
        int[] array = new int[random.nextInt(1, 8)];
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(0, 101);
        }
        int result = Homework.findMax(array);
        int expected = 92;
        assertThat(result)
                .as("findMax для массива " + Arrays.toString(array))
                .isEqualTo(expected);
    }

    //Test 7
    @Tag("homework2")
    @RepeatedTest(10)
    void testCalcAverage() {
        Random random = new Random();
        List<Integer> list = new ArrayList<>();
        int size = random.nextInt(1, 11);
        for (int i = 0; i < size; i++) {
            list.add(random.nextInt(1, 101));
        }
        int result = Homework.calcAverage(list);
        int expected = 63;
        assertThat(result)
                .as("calcAverage для списка " + list)
                .isEqualTo(expected);
    }

    //Test 8
    @Tag("homework2")
    @RepeatedTest(10)
    void testGetEvenInRange() {
        int start = new Random().nextInt(0, 10);
        int end = new Random().nextInt(11, 20);
        String result = Homework.getEvenInRange(start, end);
        String expected = "8 10 12 14";
        assertThat(result)
                .as("getEvenInRange для диапазона " + start + ".." + end)
                .isEqualTo(expected);
    }

    //Test 9
    // Использую метод с класса HomeworkTestClass
    @Tag("homework2")
    @ParameterizedTest
    @MethodSource("HomeworkTestClass#randomNumbers")
    void testGetGrade(int score) {
        String result = Homework.getGrade(score);
        String expected = "D";
        assertThat(result)
                .as("getGrade для балла " + score)
                .isEqualTo(expected);
    }


    //Метод для создания рандомного массива из заготовленного выбора
    static String[] randomStrings() {
        String[] pool = {"Bug", "Anna", "DEBUG", "Linux", "John", "Innotech", "Java"};
        Random random = new Random();
        String[] result = new String[random.nextInt(1, 7)];
        for (int i = 0; i < result.length; i++) {
            result[i] = pool[random.nextInt(pool.length)];
        }
        return result;
    }

    //Метод для создания потока массивов для JUnit в переменную list
    static Stream<Arguments> randomArrays() {
        List<Arguments> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            String[] array = randomStrings();
            list.add(Arguments.of((Object) array));
        }
        return list.stream();
    }

    //Test 10
    @Tag("homework2")
    @ParameterizedTest
    @MethodSource("randomArrays")
    void testHasBug(String[] messages) {
        boolean result = Homework.hasBug(messages);
        boolean expected = true;
        assertThat(result)
                .as("hasBug для массива " + Arrays.toString(messages))
                .isEqualTo(expected);
    }

    //Test 11
    @Tag("homework2")
    @ParameterizedTest
    @MethodSource("randomArrays")
    void testReverse(String[] arr) {
        String[] inputArray = arr;
        String[] result = Homework.reverse(arr);
        String[] expected = new String[]{"DEBUG", "John"};
        assertThat(result)
                .as("reverse для массива " + Arrays.toString(inputArray))
                .isEqualTo(expected);
    }

    //Анаогичный метод, только в этом имена
    static String[] randomNames() {
        String[] pool = {"Nikolay", "Anna", "Pol", "Tamara", "John", "Alexei", "Leonid"};
        Random random = new Random();
        String[] result = new String[random.nextInt(1, 7)];
        for (int i = 0; i < result.length; i++) {
            result[i] = pool[random.nextInt(pool.length)];
        }
        return result;
    }

    //Метод обертка для передачи в тест List<String>, String
    static Stream<Arguments> randomNamesAndRemove() {
        Random random = new Random();
        List<Arguments> result = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            List<String> names = new ArrayList<>(Arrays.asList(randomNames()));
            String nameToRemove = names.get(random.nextInt(names.size()));
            result.add(Arguments.of(names, nameToRemove));
        }
        return result.stream();
    }

    //Test 12
    @Tag("homework2")
    @ParameterizedTest
    @MethodSource("randomNamesAndRemove")
    void testRemoveSpecificName(List<String> list, String nameToRemove) {
        List<String> result = Homework.removeSpecificName(list, nameToRemove);
        List<String> expected = new ArrayList<>();
        System.out.println("Метод removeSpecificName: " + list + " удалить " + nameToRemove + " = " + result);
        assertThat(result)
                .as("removeSpecificName: убрать " + nameToRemove + " из " + nameToRemove)
                .isEqualTo(expected);

    }
}