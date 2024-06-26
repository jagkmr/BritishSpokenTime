# BritishSpokenTime

### Problem Statement:

In British English, the expression "half [hour]" is used colloquially to denote 30 minutes past the hour. For example, "
half ten" means 10:30
(without specifying morning or night). This is itself an abbreviation of an older colloquialism, "half 'past' ten". The
abbreviation can cause
misunderstanding with non-British English speakers as this contrasts with many European languages, where the same type
of expression
denotes 30 minutes before the hour. For example, in Czech, půl desáté ("half ten") means 9:30. Another example, in
German, halb zehn
("half ten") means 9:30. Write a program in Java that outputs the British spoken form of a time given as input.
For example, the program will get 12:00 as input and
will give noon as output.

### Overview of the solution:

The solution outputs the british spoken time for a given input time.
Have modularized the code and made it generic so that it can easily be extended and maintained.

#### Notable mentions

1. The solution is implemented such that the input sentences are validated, processed and then published to respective
   interface.
2. It's interactive and user can enter time to get the
   britishSpokenTime equivalent of the input on commandLine.
3. For a given time it can randomly generate US (or) UK spelt time.
4. It can be easily extended to have inputs from different sources by implementing InputProcessor and the results
   can be published to multiple sources by implementing Publisher interface.

### How to run:

#### 1. Run in an IDE

```text
1. Import the project to your IDE
2. Requires Java 17 version.
3. Run the main method from the Main.java class
   a. Optionally you can add a property to set the logLevel, by default logLevel is set to OFF.
      Example: -DlogLevel=INFO
      
      Note: logLevel property is optional, if not set the logs won't be generated by default.
```

#### 2. Run from a jar

```text
1. Ensure you have a java runtime version 17 installed in your system. 
2. The jar BritishSpokenTime.jar is added in the root path.
3. Run the following command
   
   java -jar -DlogLevel=<logLevel> BritishSpokenTime.jar
   Example: java -jar BritishSpokenTime.jar 
   Example: java -jar -DlogLevel=INFO BritishSpokenTime.jar
   
   Note: logLevel property is optional, if not set the logs won't be generated by default.
```