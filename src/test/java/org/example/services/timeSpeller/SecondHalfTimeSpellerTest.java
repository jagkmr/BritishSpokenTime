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

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Stream;

class SecondHalfTimeSpellerTest {

    private Random random = Mockito.mock(Random.class);
    private SecondHalfTimeSpeller secondHalfTimeSpeller = Mockito.spy(new SecondHalfTimeSpeller());

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @AfterEach
    void tearDown() {
    }

    @ParameterizedTest
    @MethodSource("argsProvider")
    void testSecondHalfTimeSpeller(int randomValue, int hour, int minute, List<String> expectedValues) throws Exception {

        Field field = secondHalfTimeSpeller.getClass().getDeclaredField("random");
        field.setAccessible(true);
        field.set(secondHalfTimeSpeller, random);

        Mockito.when(random.nextInt(2)).thenReturn(randomValue);

        Time time = new Time();
        time.setHour(hour);
        time.setMinute(minute);

        String speltTime = secondHalfTimeSpeller.spell(time);
        Assert.assertTrue(expectedValues.contains(speltTime));
    }

    private static Stream<Arguments> argsProvider() {
        return Stream.of(
                // US time
                Arguments.of(0, 1, 31, Arrays.asList("one thirty one")),
                Arguments.of(0, 1, 39, Arrays.asList("one thirty nine")),
                Arguments.of(0, 2, 40, Arrays.asList("two forty")),
                Arguments.of(0, 4, 45, Arrays.asList("four forty five")),
                Arguments.of(0, 3, 59, Arrays.asList("three fifty nine")),
                Arguments.of(0, 11, 59, Arrays.asList("eleven fifty nine")),

                // UK time
                Arguments.of(1, 1, 31, Arrays.asList("twenty nine to two")),
                Arguments.of(1, 1, 39, Arrays.asList("twenty one to two")),
                Arguments.of(1, 2, 40, Arrays.asList("twenty to three")),
                Arguments.of(1, 4, 45, Arrays.asList("quarter to five")),
                Arguments.of(1, 3, 59, Arrays.asList("one to four")),
                Arguments.of(1, 11, 59, Arrays.asList("one to twelve"))
        );
    }


}