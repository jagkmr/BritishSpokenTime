package org.example.services.timeSpeller;

import org.example.constants.Constants;
import org.example.interfaces.TimeSpeller;
import org.example.model.Time;
import org.example.utils.NumberSpeller;

import java.util.Random;
import java.util.function.Predicate;

public class FirstHalfTimeSpeller implements TimeSpeller {
    private final Random random = new Random();

    private Predicate<Time> minuteLessThanTen = time -> time.getMinute() > 0 && time.getMinute() < 10;

    @Override
    public String spell(Time time) {

        int hour = time.getHour();
        int minute = time.getMinute();

        int randomInt = random.nextInt(2);

        String spelledTime;

        if (randomInt == 0) {
            if (minuteLessThanTen.test(time)) {
                spelledTime = NumberSpeller.spell(hour) + Constants.SPACE + Constants.OH + Constants.SPACE + NumberSpeller.spell(minute);
            }
            else {
                spelledTime = NumberSpeller.spell(hour) + Constants.SPACE + NumberSpeller.spell(minute);
            }
        }
        else {
            switch (minute) {
                case 15: {
                    spelledTime = Constants.QUARTER + Constants.SPACE + Constants.PAST + Constants.SPACE + NumberSpeller.spell(hour);
                    break;
                }
                case 30: {
                    spelledTime = Constants.HALF + Constants.SPACE + Constants.PAST + Constants.SPACE + NumberSpeller.spell(hour);
                    break;
                }
                default: {
                    spelledTime = NumberSpeller.spell(minute) + Constants.SPACE + Constants.PAST + Constants.SPACE + NumberSpeller.spell(hour);
                }
            }
        }

        return spelledTime;
    }
}
