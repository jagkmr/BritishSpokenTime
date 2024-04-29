package org.example.services.timeSpeller;

import org.example.model.Time;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.testng.Assert;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

class WholeHourTimeSpellerTest {
    private WholeHourTimeSpeller wholeHourTimeSpeller = Mockito.spy(new WholeHourTimeSpeller());

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @AfterEach
    void tearDown() {
    }

    @ParameterizedTest
    @MethodSource("argsProvider")
    void testSecondHalfTimeSpeller(int hour, int minute, List<String> expectedValues) throws Exception {

        Time time = new Time();
        time.setHour(hour);
        time.setMinute(minute);

        String speltTime = wholeHourTimeSpeller.spell(time);
        Assert.assertTrue(expectedValues.contains(speltTime));
    }

    private static Stream<Arguments> argsProvider() {
        return Stream.of(
                Arguments.of(1, 0, Arrays.asList("one o'clock")),
                Arguments.of(2, 0, Arrays.asList("two o'clock")),
                Arguments.of(6, 0, Arrays.asList("six o'clock")),
                Arguments.of(10, 0, Arrays.asList("ten o'clock")),
                Arguments.of(11, 0, Arrays.asList("eleven o'clock"))
        );
    }


}