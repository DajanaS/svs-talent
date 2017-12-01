package readinput;

import java.util.*;

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