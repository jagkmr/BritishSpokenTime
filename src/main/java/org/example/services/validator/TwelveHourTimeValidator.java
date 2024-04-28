package org.example.services.validator;

import org.example.constants.Constants;
import org.example.interfaces.Validator;

import java.util.regex.Pattern;

/**
 * Validates twelve hour time format
 */
public class TwelveHourTimeValidator implements Validator<String> {
    @Override
    public boolean validate(String input) {
        return Pattern.matches(Constants.TWELVE_HOUR_REGEX, input);
    }
}
