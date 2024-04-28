package org.example.services;

import org.example.constants.Constants;
import org.example.interfaces.TimeSpeller;
import org.example.model.Time;
import org.example.services.timeSpeller.TimeSpellerFactory;

import java.util.function.Predicate;

public class BritishSpokenTimeService {

    public String processTime(Time time){

        if (Constants.MIDNIGHT_PREDICATE.test(time)){
            return Constants.MIDNIGHT;
        }
        if (Constants.NOON_PREDICATE.test(time)){
            return Constants.NOON;
        }

        TimeSpeller timeSpeller = TimeSpellerFactory.getTimeSpeller(time);
        return timeSpeller.spell(time);
    }


}
