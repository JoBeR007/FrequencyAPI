package ru.counter.frequencycounter.util;

import lombok.extern.slf4j.Slf4j;

import java.util.AbstractMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * This class provides a static method to count the number of occurrences of each character in a given string.
 */
@Slf4j
public class Counter {

    /**
     * Returns a sorted in descending order map of character counts in the input string.
     *
     * @param inputString the input string to count characters in
     * @return a map of character counts in the input string
     */

    public static Map<Character, Long> countChars(String inputString){
        log.info("Counting characters");
        PriorityQueue<Map.Entry<Character, Long>> pq = inputString.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(Function.identity(),
                        Collectors.counting()))
                .entrySet().stream()
                .map(e -> new AbstractMap.SimpleEntry<>(e.getKey(), e.getValue()))
                .collect(Collectors.toCollection(() -> new PriorityQueue<>((a, b) -> b.getValue().compareTo(a.getValue()))));
        Map<Character, Long> result = new LinkedHashMap<>();
        while (!pq.isEmpty()) {
            Map.Entry<Character, Long> entry = pq.poll();
            result.put(entry.getKey(), entry.getValue());
        }
        return result;
    }
}