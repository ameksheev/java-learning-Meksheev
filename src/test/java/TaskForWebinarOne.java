import org.example.Homework;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Stream;

public class TaskForWebinarOne {

    //Test 1
    @Test
    void testIsPositive() {
        Random random = new Random();
        int randomNumber = random.nextInt(-100, 100);
        boolean isPositive = Homework.isPositive(randomNumber);
        boolean Result = randomNumber >= 0;
        System.out.println("Метод isPositive: " + randomNumber + " = " + isPositive);
        if (Result == isPositive) {
            System.out.println("TEST PASSED");
        } else {
            System.out.println("TEST FAILED");
        }
    }

    //Test 2
    @Test
    void testIsEven() {
        Random random = new Random();
        int randomNumber = random.nextInt(101);
        boolean result = Homework.isEven(randomNumber);
        boolean expectedResult = randomNumber % 2 == 0;
        System.out.println("Метод isEven: " + randomNumber + " = " + result);
        if (expectedResult == result) {
            System.out.println("TEST PASSED");
        } else {
            System.out.println("TEST FAILED");
        }
    }

    //Test 3
    @Test
    void testCheckAccess() {
        Random random = new Random();
        int randomNumber = random.nextInt(0, 100);
        String result = Homework.checkAccess(randomNumber);
        String expectedResult = (randomNumber > 18) ? "Allowed" : "Denied";
        System.out.println("Метод checkAccess: " + randomNumber + " = " + result);
        if (result.equals(expectedResult)) {
            System.out.println("TEST PASSED");
        } else {
            System.out.println("TEST FAILED");
        }
    }

    //Test 4
    @Test
    void testSumToN() {
        Random random = new Random();
        int randomNumber = random.nextInt(0, 101);
        int result = Homework.sumToN(randomNumber);
        int expectedResult = 5050;
        System.out.println("Метод sumToN: " + randomNumber + " = " + result);
        if (result == expectedResult) {
            System.out.println("TEST PASSED");
        } else {
            System.out.println("TEST FAILED");
        }
    }

    //Test 5
    @RepeatedTest(3)
    void testBlastOff() {
        int start = new Random().nextInt(1, 10);
        String result = Homework.blastOff(start);
        String expected = "5 4 3 2 1 Поехали!";
        System.out.println("Метод blastOff: " + start + " = " + result);
        if (result.equals(expected)) {
            System.out.println("TEST PASSED");
        } else {
            System.out.println("TEST FAILED");
        }
    }

    //Test 6
    @RepeatedTest(4)
    void testFindMax() {
        Random random = new Random();
        int[] array = new int[random.nextInt(1, 8)];
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(0, 101);
        }
        int result = Homework.findMax(array);
        int expected = 92;
        System.out.println("Метод findMax: " + Arrays.toString(array) + " = " + result);
        if (result > expected) {
            System.out.println("TEST PASSED");
        } else {
            System.out.println("TEST FAILED");
        }
    }

    //Test 7
    @RepeatedTest(5)
    void testCalcAverage() {
        Random random = new Random();
        List<Integer> list = new ArrayList<>();
        int size = random.nextInt(1, 11);
        for (int i = 0; i < size; i++) {
            list.add(random.nextInt(1, 101));
        }
        int result = Homework.calcAverage(list);
        int expected = 63;
        System.out.println("Метод calcAverage: " + list + " = " + result);
        if (result < expected) {
            System.out.println("TEST PASSED");
        } else {
            System.out.println("TEST FAILED");
        }
    }

    //Test 8
    @RepeatedTest(2)
    void testGetEvenInRange() {
        int start = new Random().nextInt(0, 10);
        int end = new Random().nextInt(11, 20);
        String result = Homework.getEvenInRange(start, end);
        String expected = "8 10 12 14";
        System.out.println("Метод getEvenInRange: " + start + ", " + end + " = " + result);
        if (!(result.equals(expected))) {
            System.out.println("TEST PASSED");
        } else {
            System.out.println("TEST FAILED");
        }
    }

    //Test 9
    // Использую метод с класса HomeworkTestClass
    @ParameterizedTest
    @MethodSource("HomeworkTestClass#randomNumbers")
    void testGetGrade(int score) {
        String result = Homework.getGrade(score);
        String expected = "D";
        System.out.println("Метод getGrade: " + score + " = " + result);
        if (result.equals(expected)) {
            System.out.println("TEST PASSED");
        } else {
            System.out.println("TEST FAILED");
        }
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
        for (int i = 0; i < 4; i++) {
            String[] array = randomStrings();
            list.add(Arguments.of((Object) array));
        }
        return list.stream();
    }

    //Test 10
    @ParameterizedTest
    @MethodSource("randomArrays")
    void testHasBug(String[] messages) {
        boolean result = Homework.hasBug(messages);
        boolean expected = true;
        System.out.println("Метод hasBug: " + Arrays.toString(messages) + " = " + result);
        if (result == expected) {
            System.out.println("TEST PASSED");
        } else {
            System.out.println("TEST FAILED");
        }
    }

    //Test 11
    @ParameterizedTest
    @MethodSource("randomArrays")
    void testReverse(String[] arr) {
        String[] inputArray = arr;
        String[] result = Homework.reverse(arr);
        String[] expected = new String[]{"DEBUG", "John"};
        System.out.println("Метод reverse" + Arrays.toString(inputArray) + " = " + Arrays.toString(result));
        if (!Arrays.equals(result, expected)) {
            System.out.println("TEST PASSED");
        } else {
            System.out.println("TEST FAILED");
        }
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
        for (int i = 0; i < 3; i++) {
            List<String> names = new ArrayList<>(Arrays.asList(randomNames()));
            String nameToRemove = names.get(random.nextInt(names.size()));
            result.add(Arguments.of(names, nameToRemove));
        }
        return result.stream();
    }

    //Test 12
    @ParameterizedTest
    @MethodSource("randomNamesAndRemove")
    void testRemoveSpecificName(List<String> list, String nameToRemove) {
        List<String> result = Homework.removeSpecificName(list, nameToRemove);
        List<String> expected = new ArrayList<>();
        System.out.println("Метод removeSpecificName: " + list + " удалить " + nameToRemove + " = " + result);
        if (result.equals(expected)) {
            System.out.println("TEST PASSED");
        } else {
            System.out.println("TEST FAILED");
        }

    }
}