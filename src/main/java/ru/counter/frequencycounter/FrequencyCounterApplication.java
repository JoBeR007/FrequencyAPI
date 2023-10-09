package ru.counter.frequencycounter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

/**
 * The main class for Frequency API
 */
@Slf4j
@EnableCaching
@SpringBootApplication
public class FrequencyCounterApplication {

    public static void main(String[] args) {
        log.info("Entering application");
        SpringApplication.run(FrequencyCounterApplication.class, args);
    }

}
