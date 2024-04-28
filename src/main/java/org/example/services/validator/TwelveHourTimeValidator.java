package org.example.services.validator;

import org.example.interfaces.Validator;

import java.util.regex.Pattern;

public class TwelveHourTimeValidator implements Validator<String> {

    String regex = "^(1[0-2]|0?[0-9]):[0-5][0-9]$";
    @Override
    public boolean validate(String input) {
        return Pattern.matches(regex, input);
    }
}
