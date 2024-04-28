package org.example.services.timeSpeller;

import org.example.constants.Constants;
import org.example.interfaces.TimeSpeller;
import org.example.model.Time;
import org.example.utils.NumberSpeller;

import java.util.Random;

/**
 * Second half timeSpeller implementation
 */
public class SecondHalfTimeSpeller implements TimeSpeller {
    private final Random random = new Random();

    @Override
    public String spell(Time time) {

        int hour = time.getHour();
        int minute = time.getMinute();

        int randomInt = random.nextInt(2);

        String spelledTime;

        // Added randomness to spell time in different format
        if (randomInt == 0) {
            spelledTime = NumberSpeller.spell(hour) + Constants.SPACE + NumberSpeller.spell(minute);
        }
        else {
            switch (minute) {
                case 45: {
                    spelledTime = Constants.QUARTER + Constants.SPACE + Constants.TO + Constants.SPACE + NumberSpeller.spell(hour + 1);
                    break;
                }
                default: {
                    spelledTime = NumberSpeller.spell(60 - minute) + Constants.SPACE + Constants.TO + Constants.SPACE + NumberSpeller.spell(hour + 1);
                }
            }
        }

        return spelledTime;
    }
}
