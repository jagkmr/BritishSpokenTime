package org.example.services;

import org.example.model.Time;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.testng.Assert;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

class BritishSpokenTimeServiceTest {

    @InjectMocks
    private BritishSpokenTimeService britishSpokenTimeService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @AfterEach
    void tearDown() {
    }

    @ParameterizedTest
    @MethodSource("argsProvider")
    void testTime(int hour, int minute, List<String> expectedValues) {
        Time time = new Time();
        time.setHour(hour);
        time.setMinute(minute);
        String speltTime = britishSpokenTimeService.processTime(time);
        Assert.assertTrue(expectedValues.contains(speltTime));
    }

    private static Stream<Arguments> argsProvider() {
        return Stream.of(
                Arguments.of(1, 0, Arrays.asList("one o'clock")),
                Arguments.of(2, 5, Arrays.asList("two o five", "five past two")),
                Arguments.of(3, 10, Arrays.asList("three ten", "ten past three")),
                Arguments.of(4, 15, Arrays.asList("four fifteen", "quarter past four")),
                Arguments.of(5, 20, Arrays.asList("five twenty", "twenty past five")),
                Arguments.of(6, 25, Arrays.asList("six twenty five", "twenty five past six")),
                Arguments.of(6, 32, Arrays.asList("six thirty two", "twenty eight to seven")),
                Arguments.of(7, 30, Arrays.asList("seven thirty", "half past seven")),
                Arguments.of(7, 35, Arrays.asList("seven thirty five", "twenty five to eight")),
                Arguments.of(8, 40, Arrays.asList("eight forty", "twenty to nine")),
                Arguments.of(9, 45, Arrays.asList("nine forty five", "quarter to ten")),
                Arguments.of(10, 50, Arrays.asList("ten fifty", "ten to eleven")),
                Arguments.of(11, 55, Arrays.asList("eleven fifty five", "five to twelve")),
                Arguments.of(0, 0, Arrays.asList("midnight")),
                Arguments.of(12, 0, Arrays.asList("noon"))
        );
    }
}