package org.example.services.timeSpeller;

import org.example.constants.Constants;
import org.example.interfaces.TimeSpeller;
import org.example.model.Time;

/**
 * Factory pattern is used to return the appropriate TimeSpeller
 */
public class TimeSpellerFactory {

    public static TimeSpeller getTimeSpeller(Time time) {
        TimeSpeller timeSpeller = null;
        if (Constants.WHOLE_HOUR_PREDICATE.test(time)) {
            return new WholeHourTimeSpeller();
        }
        else if (Constants.FIRST_HALF_PREDICATE.test(time)) {
            return new FirstHalfTimeSpeller();
        }
        else if (Constants.SECOND_HALF_PREDICATE.test(time)) {
            return new SecondHalfTimeSpeller();
        }
        return timeSpeller;
    }
}
