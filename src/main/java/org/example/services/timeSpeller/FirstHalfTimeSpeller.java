package org.example.services.timeSpeller;

import org.example.constants.Constants;
import org.example.interfaces.TimeSpeller;
import org.example.model.Time;
import org.example.utils.NumbersToWords;

import java.util.Random;

public class FirstHalfTimeSpeller implements TimeSpeller {
    @Override
    public String spell(Time time) {

        int hour = time.getHour();
        int minute = time.getMinute();

        String timeSpelled;

        switch (minute) {
            case 15: {
                timeSpelled = Constants.QUARTER + Constants.SPACE + Constants.PAST + Constants.SPACE + NumbersToWords.generate(hour);
                break;
            }
            case 30: {
                timeSpelled = Constants.HALF + Constants.SPACE + Constants.PAST + Constants.SPACE + NumbersToWords.generate(hour);
                break;
            }
            default: {
                timeSpelled = NumbersToWords.generate(minute) + Constants.SPACE + Constants.PAST + Constants.SPACE + NumbersToWords.generate(hour);
            }
        }

        return timeSpelled;
    }
}
