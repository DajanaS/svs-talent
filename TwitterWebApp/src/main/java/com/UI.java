package com;

import com.readinput.*;
import com.tweet.Tweet;
import com.repository.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class UI {
    public static void displayMenu() {
        System.out.println("============================ MENU ============================");
        System.out.println("Enter the number (1, 2 or 3) for one of the following actions:");
        System.out.println("1) Tweet a message");
        System.out.println("2) List all tweets");
        System.out.println("3) Exit");
        System.out.println("==============================================================");
    }

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(UI.class, args);
        TweetsRepository tweets = context.getBean(CollectionTweetsRepository.class);
        ReadInput reader = context.getBean(ConsoleReadInput.class);

        displayMenu();
        String input = reader.readInput();

        while (!input.equals("3")) {
            if (input.equals("1")) {
                System.out.println("Write your message below");
                String content = reader.readInput();
                tweets.add(new Tweet(content));
                System.out.println("Tweet saved.");
            } else if (input.equals("2")) {
                System.out.println("All tweets starting by the latest:\n");
                System.out.println(tweets);
            } else {
                System.out.println("Entered option not valid.");
            }
            System.out.println("Press any key to go back to the menu.");
            input = reader.readInput();

            displayMenu();
            input = reader.readInput();
        }
        System.exit(-1);
    }
}