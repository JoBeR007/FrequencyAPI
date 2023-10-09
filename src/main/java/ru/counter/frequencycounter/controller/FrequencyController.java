package ru.counter.frequencycounter.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

import static ru.counter.frequencycounter.util.Counter.countChars;

/**
 * REST Controller for FrequencyCounter
 */
@Slf4j
@RestController
@RequestMapping("/frequency-api")
@CacheConfig(cacheNames = {"freq"})
public class FrequencyController {


    /**
     * Gets Map of frequencies for given String input
     *
     * @param string input
     * @return Response entity with Map of frequencies they are present
     * or HttpStatus.BAD_REQUEST if the input string is empty
     */
    @Cacheable(key = "#string")
    @GetMapping
    public ResponseEntity<Map<Character, Long>> calculateFrequency(@RequestBody String string){
        if (string.isEmpty()) {
            log.info("Input is empty string");
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        log.info("Getting map");
        return new ResponseEntity<>(countChars(string), HttpStatus.OK);
    }
}
