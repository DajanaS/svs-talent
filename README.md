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

## Exercises

### WordCounter
Count the number of occurrences of each word in a file specified as an argument to the application. 

### NumberPrinter
Create an application that prints out the numbers starting from one (1) up until a specified number.
The print process should be interrupted if it fails to complete in a given time interval.

### StopWatch
Create a stopwatch component that prints out each passing second until terminated by a command from the console captured from the standard input.
Additional commands should allow the stopwatch to be paused and resumed. 

### MotionDetector
Create a motion detector component which once started takes images (byte array) from an image capturing device every one (1) second. In case it detects changes between two subsequent images, it needs to trigger an alarm on a number of previously registered alarm channels.
For testing/simulation purposes, create an image capturing device which simulates image capturing by reading text from the console (System.in) and a single alarm channel which when used writes the "Alarm" text to the console (System.out). Group component related classes and interfaces in distinct packages.