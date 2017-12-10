# Exercises for 2017 Java Talent Program

## Topics covered
- Java Standard Edition
- OOP
- Persistence with relational database
- Web

## Application: Twitter
Create social network application that (in the first phase) allows an anonymous user to:

1. Tweet a message.
2. List all messages in a chronological order with the latest messages displayed first.
3. Exit the application.

The user chooses a functionality from a menu using the standard input stream (console).

## Exercises Java SE

### WordCounter
Count the number of occurrences of each word in a file specified as an argument to the application. 

### NumberPrinter
Create an application that prints out the numbers starting from one (1) up until a specified number.
The print process should be interrupted if it fails to complete in a given time interval.

### StopWatch
Create a stopwatch component that prints out each passing second until terminated by a command from the console captured from the standard input.
Additional commands should allow the stopwatch to be paused and resumed. 

### Factory
Refactor the [Factory application](https://github.com/nikola-zivkov/svs-talent/tree/master/01.%20Java%20SE/Code/15.02%20-%20Exercise%20-%20Factory%20(ISP)/Factory.Bad/src "Factory (ISP)/Factory.Bad") to be compliant with the interface segregation principle.

### MotionDetector
Create a motion detector component which once started takes images (byte array) from an image capturing device every one (1) second. In case it detects changes between two subsequent images, it needs to trigger an alarm on a number of previously registered alarm channels.
For testing/simulation purposes, create an image capturing device which simulates image capturing by reading text from the console (System.in) and a single alarm channel which when used writes the "Alarm" text to the console (System.out). Group component related classes and interfaces in distinct packages.

### WaterHeater
A large industry manufacturer Ventoelectrics has asked your company ACME to provide two thermoregulator components, **standard** and **efficient**, which they intent to use in their water heater production line. They have their own production for the other components, the power switch, the heater and the thermometer.

The thermoregulator components should run on its own taking a read from the thermometer, the standard version every three (3) seconds and the efficient every one (1) second. Both enable and disable the heater in respect to the following rules:

- The heater is disabled if the temperature raises above a configured value.
- The heater is enabled if the temperature drops below a configured value.

Group component related classes and interfaces in distinct packages following the *com.<company\>.<component\>* package organization schema.

Make sure you're able to offer the thermoregulator product line to other vendors in the future - your thermoregulator components should not depend on Ventoelectrics' components (classes and interfaces).

## Exercises Java Enterprise

### ImprovedWordCounter
Modify the WordCounter application to ignore the word capitalization using Apache's Commons Lang 3 Library. Hint: Use https://mvnrepository.com to find the correct GAV for the library in question.

### MultiModuleWaterHeater
Modify the project structure of the WaterHeater to use a module for each component and configure the dependencies among the modules. Create a separate "application" module for the "main" application class.

 