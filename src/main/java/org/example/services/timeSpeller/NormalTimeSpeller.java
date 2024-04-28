package org.example.services.timeSpeller;

import org.example.constants.Constants;
import org.example.interfaces.TimeSpeller;
import org.example.model.Time;
import org.example.utils.NumberSpeller;

public class NormalTimeSpeller implements TimeSpeller {
    @Override
    public String spell(Time time) {
        return NumberSpeller.spell(time.getHour()) + Constants.SPACE + NumberSpeller.spell(time.getMinute());
    }
}
