package org.example.services.timeSpeller;

import org.example.constants.Constants;
import org.example.interfaces.TimeSpeller;
import org.example.model.Time;
import org.example.utils.NumbersToWords;

import java.util.Random;

public class SecondHalfTimeSpeller implements TimeSpeller {
    @Override
    public String spell(Time time) {

        int hour = time.getHour();
        int minute = time.getMinute();

        Random random = new Random();
        int randomInt = random.nextInt(2);

        String timeSpelled;

        if (randomInt == 0){
            timeSpelled =  NumbersToWords.generate(hour) + Constants.SPACE + NumbersToWords.generate(minute);
        }
        else {
            switch (minute){
                case 45: {
                    timeSpelled = Constants.QUARTER + Constants.SPACE + Constants.TO + Constants.SPACE + NumbersToWords.generate(hour + 1);
                    break;
                }
                default: {
                    timeSpelled = NumbersToWords.generate(60 - minute) + Constants.SPACE + Constants.TO + Constants.SPACE + NumbersToWords.generate(hour + 1);
                }
            }
        }

        return timeSpelled;
    }
}
