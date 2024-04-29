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

class FirstHalfTimeSpellerTest {

    private Random random = Mockito.mock(Random.class);
    private FirstHalfTimeSpeller firstHalfTimeSpeller = Mockito.spy(new FirstHalfTimeSpeller());

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @AfterEach
    void tearDown() {
    }

    @ParameterizedTest
    @MethodSource("argsProvider")
    void testFirstHalfTimeSpeller(int randomValue, int hour, int minute, List<String> expectedValues) throws Exception {

        Field field = firstHalfTimeSpeller.getClass().getDeclaredField("random");
        field.setAccessible(true);
        field.set(firstHalfTimeSpeller, random);

        Mockito.when(random.nextInt(2)).thenReturn(randomValue);

        Time time = new Time();
        time.setHour(hour);
        time.setMinute(minute);

        String speltTime = firstHalfTimeSpeller.spell(time);
        Assert.assertTrue(expectedValues.contains(speltTime));
    }

    private static Stream<Arguments> argsProvider() {
        return Stream.of(
                // US time
                Arguments.of(0, 1, 1, Arrays.asList("one o one")),
                Arguments.of(0, 1, 9, Arrays.asList("one o nine")),
                Arguments.of(0, 2, 10, Arrays.asList("two ten")),
                Arguments.of(0, 3, 30, Arrays.asList("three thirty")),
                Arguments.of(0, 4, 15, Arrays.asList("four fifteen")),
                Arguments.of(0, 10, 20, Arrays.asList("ten twenty")),
                Arguments.of(0, 12, 29, Arrays.asList("twelve twenty nine")),

                // UK time
                Arguments.of(1, 1, 1, Arrays.asList("one past one")),
                Arguments.of(1, 1, 9, Arrays.asList("nine past one")),
                Arguments.of(1, 2, 10, Arrays.asList("ten past two")),
                Arguments.of(1, 3, 30, Arrays.asList("half past three")),
                Arguments.of(1, 4, 15, Arrays.asList("quarter past four")),
                Arguments.of(1, 10, 20, Arrays.asList("twenty past ten")),
                Arguments.of(1, 12, 29, Arrays.asList("twenty nine past twelve"))
        );
    }


}