package org.example.services.timeSpeller;

import org.example.constants.Constants;
import org.example.interfaces.TimeSpeller;
import org.example.model.Time;
import org.example.utils.NumbersToWords;

public class NormalTimeSpeller implements TimeSpeller {
    @Override
    public String spell(Time time) {
        return NumbersToWords.generate(time.getHour()) + Constants.SPACE + NumbersToWords.generate(time.getMinute());
    }
}
