package org.example.constants;

import org.example.model.Time;

import java.util.function.Predicate;

public interface Constants {

    String MIDNIGHT = "midnight";
    String NOON = "noon";
    String WHOLE_HOUR_O_CLOCK = "o'clock";
    String QUARTER = "quarter";
    String HALF = "half";
    String PAST = "past";
    String TO = "to";
    String SPACE = " ";
    String OH = "o";
    Predicate<Time> MIDNIGHT_PREDICATE = time -> time.getHour() == 0 && time.getMinute()==0;
    Predicate<Time> NOON_PREDICATE = time -> time.getHour() == 12 && time.getMinute()==0;
    Predicate<Time> WHOLE_HOUR_PREDICATE = time -> time.getMinute() == 0;
    Predicate<Time> FIRST_HALF_PREDICATE = time -> time.getMinute() > 0 && time.getMinute()<=30;
    Predicate<Time> SECOND_HALF_PREDICATE = time -> time.getMinute() > 30 && time.getMinute()<=59;

}
