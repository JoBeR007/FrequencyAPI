package ru.counter.frequencycounter;

import org.junit.jupiter.api.Test;
import ru.counter.frequencycounter.util.Counter;

import java.util.LinkedHashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

public class CounterTest {
    @Test
    public void testEmptyString() {
        String input = "";
        Map<Character, Long> expected = Map.of();
        Map<Character, Long> actual = Counter.countChars(input);
        assertEquals(expected, actual);
    }

    @Test
    public void testSingleCharacter() {
        String input = "a";
        Map<Character, Long> expected = Map.of('a', 1L);
        Map<Character, Long> actual = Counter.countChars(input);
        assertEquals(expected, actual);
    }

    @Test
    public void testMultipleCharacters() {
        String input = "helloworld";
        Map<Character, Long> expected = Map.of('l', 3L, 'o', 2L, 'e', 1L, 'h', 1L, 'w', 1L, 'r', 1L, 'd', 1L);
        Map<Character, Long> actual = Counter.countChars(input);
        assertEquals(expected, actual);
    }

    @Test
    public void testUppercaseCharacters() {
        String input = "HELLOWORLD";
        Map<Character, Long> expected = Map.of('L', 3L, 'O', 2L, 'E', 1L, 'H', 1L, 'W', 1L, 'R', 1L, 'D', 1L);
        Map<Character, Long> actual = Counter.countChars(input);
        assertEquals(expected, actual);
    }

    @Test
    public void testCountChars() {
        String input = "Hello,world!";
        Map<Character, Long> expected = new LinkedHashMap<>();
        expected.put('l', 3L);
        expected.put('o', 2L);
        expected.put('e', 1L);
        expected.put(',', 1L);
        expected.put('H', 1L);
        expected.put('w', 1L);
        expected.put('!', 1L);
        expected.put('d', 1L);
        expected.put('r', 1L);
        Map<Character, Long> actual = Counter.countChars(input);
        assertEquals(expected, actual);
    }

    @Test
    public void testUnableToCalcForMultibyteCharacters() {
        String input = "😀😀😀";
        Map<Character, Long> actual = Counter.countChars(input);
        int expectedSize = 1;
        assertNotEquals(expectedSize, actual.size());
    }

    @Test
    public void testWhitespaceCharacters() {
        String input = "     ";
        Map<Character, Long> expected = Map.of(' ', 5L);
        Map<Character, Long> actual = Counter.countChars(input);
        assertEquals(expected, actual);
    }

    @Test
    public void testAllSameCharacters() {
        String input = "aaaaaaaaaa";
        Map<Character, Long> expected = Map.of('a', 10L);
        Map<Character, Long> actual = Counter.countChars(input);
        assertEquals(expected, actual);
    }

    @Test
    public void testAllDifferentCharacters() {
        String input = "abcdefghijklmnopqrstuvwxyz";
        Map<Character, Long> expected = new LinkedHashMap<>();
        for (char c = 'a'; c <= 'z'; c++) {
            expected.put(c, 1L);
        }
        Map<Character, Long> actual = Counter.countChars(input);
        assertEquals(expected.size(), actual.size());
        for (Map.Entry<Character, Long> entry : expected.entrySet()) {
            assertTrue(actual.containsKey(entry.getKey()));
            assertEquals(entry.getValue(), actual.get(entry.getKey()));
        }
    }

    @Test
    public void testCountCharsSpecial() {
        String input = "@#$%^&*()_+";
        Map<Character, Long> expected = new LinkedHashMap<>();
        expected.put('@', 1L);
        expected.put('#', 1L);
        expected.put('$', 1L);
        expected.put('%', 1L);
        expected.put('^', 1L);
        expected.put('&', 1L);
        expected.put('*', 1L);
        expected.put('(', 1L);
        expected.put(')', 1L);
        expected.put('_', 1L);
        expected.put('+', 1L);
        Map<Character, Long> actual = Counter.countChars(input);
        assertEquals(expected, actual);
    }
}
