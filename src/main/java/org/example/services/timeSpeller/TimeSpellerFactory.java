package org.example.services.timeSpeller;

import org.example.interfaces.TimeSpeller;
import org.example.model.Time;

import java.util.function.Predicate;

public class TimeSpellerFactory {

    private static Predicate<Time> wholeHour = time -> time.getMinute() == 0;
    private static Predicate<Time> firstHalf = time -> time.getMinute() > 0 && time.getMinute()<=30;
    private static Predicate<Time> secondHalf = time -> time.getMinute() > 30 && time.getMinute()<=59;

    public static TimeSpeller getTimeSpeller(Time time){
        TimeSpeller timeSpeller = null;
        if (wholeHour.test(time)){
            return new WholeHourTimeSpeller();
        }
        else if (firstHalf.test(time)){
            return new FirstHalfTimeSpeller();
        }
        else if (secondHalf.test(time)){
            return new SecondHalfTimeSpeller();
        }
        return timeSpeller;
    }
}
