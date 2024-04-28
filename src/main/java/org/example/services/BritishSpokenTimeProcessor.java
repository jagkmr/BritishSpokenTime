package org.example.services;

import org.apache.commons.collections.CollectionUtils;
import org.example.interfaces.Publisher;
import org.example.interfaces.Validator;
import org.example.model.Time;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class BritishSpokenTimeProcessor extends AbstractProcessor<String, String> {

    Logger LOG = LoggerFactory.getLogger(BritishSpokenTimeProcessor.class);
    Validator<String> validator;
    List<Publisher<String>> publishers;
    BritishSpokenTimeService britishSpokenTimeService = new BritishSpokenTimeService();

    public BritishSpokenTimeProcessor(Validator<String> validator, List<Publisher<String>> publishers) {
        this.validator = validator;
        this.publishers = publishers;
    }

    @Override
    public boolean validate(String input) {
        return validator.validate(input);
    }

    @Override
    public String process(String input) {
        LOG.info("Started process");

        String[] timeFormat = input.split(":");
        Time time = new Time();
        time.setHour(Integer.parseInt(timeFormat[0]));
        time.setMinute(Integer.parseInt(timeFormat[1]));

        return britishSpokenTimeService.processTime(time);
    }

    @Override
    public void postProcess(String output) {
        if (CollectionUtils.isNotEmpty(publishers)) {
            publishers.forEach(publisher -> publisher.publish(output));
        }
    }
}
