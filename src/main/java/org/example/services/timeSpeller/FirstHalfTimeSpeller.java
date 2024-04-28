package org.example.services.timeSpeller;

import org.example.constants.Constants;
import org.example.interfaces.TimeSpeller;
import org.example.model.Time;
import org.example.utils.NumberSpeller;

import java.util.Random;
import java.util.function.Predicate;

/**
 * First half timeSpeller implementation
 */
public class FirstHalfTimeSpeller implements TimeSpeller {
    private final Random random = new Random();

    @Override
    public String spell(Time time) {

        int hour = time.getHour();
        int minute = time.getMinute();

        int randomInt = random.nextInt(2);

        String spelledTime;

        // Added randomness to spell time in different format
        if (randomInt == 0) {
            if (Constants.MINUTE_LESS_THAN_TEN.test(time)) {
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
