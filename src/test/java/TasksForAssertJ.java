import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class TasksForAssertJ {
    public String makeUpperWords(String words) {
        return words.toUpperCase();
    }

    @Test
    void testmakeUpperWords() {
        String result = makeUpperWords("HELLO");
        String expected = "HELLO";
        assertThat(result)
                .as("Перевод слова в верхний регистр")
                .isEqualTo(expected);

    }
    //Метод для проверки палиндрома одинаовое чтение слева направо и справа налево
    public boolean isPalindrome(String text) {
        String reversed = new StringBuilder(text).reverse().toString();
        return reversed.equals(text);
    }

    @Test
    void testIsPalindromeTrue() {
        boolean result = isPalindrome("radar");
        boolean expected = true;

        assertThat(result)
                .as("Проверка, что слово radar является палиндромом")
                .isEqualTo(expected);
    }

    @Test
    void testIsPalindromeFalse() {
        boolean result = isPalindrome("java");
        boolean expected = false;
        assertThat(result)
                .as("Проверка, что слово java не является палиндромом")
                .isEqualTo(expected);
    }

    public List<Integer> getEvenNumbers(List<Integer> numbers) {
        List<Integer> result = new ArrayList<>();
        for (int number : numbers) {
            if (number % 2 == 0) {
                result.add(number);
            }
        }
        return result;
    }

    @Test
    void testGetEvenNumbers() {
        List<Integer> result = getEvenNumbers(List.of(1, 2, 3, 4, 5, 6));
        List<Integer> expected = List.of(2, 4, 6);

        assertThat(result)
                .as("Фильтрация чётных чисел из списка 1..6")
                .isEqualTo(expected);
    }


    public int calcDiscount(int price, int percent) {
        return price * percent / 100;
    }

    @Test
    void testCalcDiscount() {
        int result = calcDiscount(200, 10);
        int expected = 180;

        assertThat(result)
                .as("Цена 200 со скидкой 10%")
                .isEqualTo(expected);
    }






}
