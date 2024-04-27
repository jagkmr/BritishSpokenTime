package org.example.services;

public class CommandLineProcessor extends AbstractProcessor<Integer, String>{

    public CommandLineProcessor(){

    }

    @Override
    public boolean validate(Integer input) {
        return false;
    }

    @Override
    public String process(Integer input) {
        return null;
    }

    @Override
    public void postProcess(String output) {

    }
}
