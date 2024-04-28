package org.example.services;

import org.example.constants.Constants;
import org.example.interfaces.TimeSpeller;
import org.example.model.Time;
import org.example.services.timeSpeller.TimeSpellerFactory;

import java.util.function.Predicate;

public class BritishSpokenTimeService {

    private static Predicate<Time> midnight = time -> time.getHour() == 0 && time.getMinute()==0;
    private static Predicate<Time> noon = time -> time.getHour() == 12 && time.getMinute()==0;

    public String processTime(Time time){

        if (midnight.test(time)){
            return Constants.MIDNIGHT;
        }
        if (noon.test(time)){
            return Constants.NOON;
        }

        TimeSpeller timeSpeller = TimeSpellerFactory.getTimeSpeller(time);
        return timeSpeller.spell(time);
    }


}
