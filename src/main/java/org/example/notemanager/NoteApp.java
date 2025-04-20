package org.example.notemanager;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Scanner;


public class NoteApp {
    public static void main(String[] args) throws IOException {
        System.out.println("Hello world!");
        var scanner = new Scanner(System.in);
        var manager = new NoteManager();

        // use of var in Java 11

        while(true) {
            System.out.println("\n--- Note Manager ---");
            System.out.println("1. Create Note");
            System.out.println("2. View Notes");
            System.out.println("3. Stats");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");

            String input = scanner.nextLine();

//            int choice;
//            switch (input) {
//                case "1": choice = 1; break;
//                case "2": choice = 2; break;
//                case "3": choice = 3; break;
//                case "4": choice = 4; break;
//                default: choice = 0;
//            }

            int choice = switch (input) {
                case "1" -> 1;
                case "2" -> 2;
                case "3" -> 3;
                case "4" -> 4;
                default -> 0;
            };
            System.out.print(choice);

            switch (choice){
                case 1 -> {
                    System.out.println("Enter Title: ");
                    var title = scanner.nextLine().strip();
                    System.out.print("Enter content (end with a single line with only 'END'):\n");
                    var content = new StringBuilder();
                    String line;
                    while(!(line = scanner.nextLine()).equals("END")){
                        content.append(line).append("\n");
                    }
                    var note = new Note(title, content.toString().strip(), LocalDateTime.now());
                    manager.saveNote(note);
                    System.out.println("Note saved.");
                    break;
                }
                default -> System.out.println("Invalid Choice, Try Again");
            }
        }


    };
}