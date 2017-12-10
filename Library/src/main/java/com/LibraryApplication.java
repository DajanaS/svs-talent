package com;

import com.book.Book;
import com.member.Member;
import com.readinput.*;
import com.repository.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class LibraryApplication {
    public static void displayMenu() {
        System.out.println("============================ MENU ============================");
        System.out.println("Enter the number (1, 2 or 3) for one of the following actions:");
        System.out.println("1) Register a book");
        System.out.println("2) List all registered books");
        System.out.println("3) Register a member");
        System.out.println("4) List all registered members");
        System.out.println("5) Book lending");
        System.out.println("6) Exit");
        System.out.println("==============================================================");
    }

    public static void main(String[] args) throws Exception {
        ApplicationContext context = SpringApplication.run(LibraryApplication.class, args);
        LibraryRepository repository = context.getBean(LibraryRepositoryBookRepositoryAdapter.class);
        ReadInput reader = context.getBean(ConsoleReadInput.class);

        displayMenu();
        String input = reader.readInput();

        while (!input.equals("6")) {
            if (input.equals("1")) {
                System.out.println("Write the isbn and the title of the book below");
                String[] content = reader.readInput().split(" ");
                repository.registerBook(new Book(content[0], content[1]));
                System.out.println("Book registered.");
            } else if (input.equals("2")) {
                System.out.println("All registered books:\n");
                Iterable<Book> bookIterable = repository.listRegisteredBooks();
                for (Book book : bookIterable) {
                    System.out.println(book.toString());
                }
            } else if (input.equals("3")) {
                System.out.println("Write the name of the member below:\n");
                String content = reader.readInput();
                repository.registerMember(new Member(content));
                System.out.println("Member registered.");
            } else if (input.equals("4")) {
                System.out.println("All registered members:\n");
                Iterable<Member> memberIterable = repository.listRegisteredMembers();
                for (Member member : memberIterable) {
                    System.out.println(member.toString());
                }
            } else if (input.equals("5")) {
                System.out.println("Enter the id of the member and the id of the book (s)he is lending:\n");
                String[] content = reader.readInput().split(" ");
                String memberID = content[0];
                String bookID = content[1];
                repository.landBook(memberID, bookID);
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
