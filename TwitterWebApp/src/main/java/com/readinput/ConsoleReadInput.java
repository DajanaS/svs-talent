package com.readinput;

import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class ConsoleReadInput implements ReadInput {
    private Scanner scanner;

    public ConsoleReadInput() {
        scanner = new Scanner(System.in);
    }

    @Override
    public String readInput() {
        return scanner.nextLine();
    }
}