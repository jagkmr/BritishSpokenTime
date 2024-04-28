package org.example.services.timeSpeller;

import org.example.constants.Constants;
import org.example.interfaces.TimeSpeller;
import org.example.model.Time;
import org.example.utils.NumberSpeller;

/**
 * Spells whole hour time.
 * Ex: 1:00 - one o'clock
 */
public class WholeHourTimeSpeller implements TimeSpeller {
    @Override
    public String spell(Time time) {
        return NumberSpeller.spell(time.getHour()) + Constants.SPACE + Constants.WHOLE_HOUR_O_CLOCK;
    }
}
