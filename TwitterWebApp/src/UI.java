import java.util.*;

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
        displayMenu();
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        TweetsContainer tweets = new TweetsContainer();
        while (!input.equals("3")) {
            if (input.equals("1")) {
                System.out.println("Write your message below");
                String content = scanner.nextLine();
                tweets.add(new Tweet(content));
                System.out.println("Tweet saved.");
            } else if (input.equals("2")) {
                System.out.println("All tweets starting by the latest:\n");
                System.out.println(tweets);
            } else {
                System.out.println("Entered option not valid.");
            }
            System.out.println("Press any key to go back to the menu.");
            input = scanner.nextLine();
            displayMenu();
            input = scanner.nextLine();
        }
    }
}