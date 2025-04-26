package org.example.notemanager;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class NoteApp {
//    public static void main(String[] args) throws IOException {
//        System.out.println("Hello world!");
//        var scanner = new Scanner(System.in);
//        var manager = new NoteManager();
//
//        // use of var in Java 11
//
//        while(true) {
//            System.out.println("\n--- Note Manager ---");
//            System.out.println("1. Create Note");
//            System.out.println("2. View Notes");
//            System.out.println("3. Stats");
//            System.out.println("4. Exit");
//            System.out.print("Choose an option: ");
//
//            String input = scanner.nextLine();
//
////            int choice;
////            switch (input) {
////                case "1": choice = 1; break;
////                case "2": choice = 2; break;
////                case "3": choice = 3; break;
////                case "4": choice = 4; break;
////                default: choice = 0;
////            }
//
//            int choice = switch (input) {
//                case "1" -> 1;
//                case "2" -> 2;
//                case "3" -> 3;
//                case "4" -> 4;
//                default -> 0;
//            };
////            System.out.print(choice);
//
//            switch (choice){
//                case 1 -> {
//                    System.out.println("Enter Title: ");
//                    var title = scanner.nextLine().strip();
//                    System.out.print("Enter content (end with a single line with only 'END'):\n");
//                    var content = new StringBuilder();
//                    String line;
//                    while(!(line = scanner.nextLine()).equals("END")){
//                        content.append(line).append("\n");
//                    }
//                    var note = new Note(title, content.toString().strip(), LocalDateTime.now());
//                    manager.saveNote(note);
//                    System.out.println("Note saved.");
//                }
//
//                case 2 -> {
//                    List<Note> notes = manager.listNotes();
//                    if (notes.isEmpty()) {
//                        System.out.println("No notes found.");
//                    } else {
//                        notes.forEach(n -> {
//                            System.out.println("\n" + n.preview());
//                            System.out.println("------------\n" + n.getContent() + "\n------------");
//                        });
//                    }
//                }
//
//                case 3 -> {
//                    manager.printStats();
//                }
//
//                case 4 -> {
//                    System.out.println("Exiting...");
//                    return;
//                }
//
//                default -> System.out.println("Invalid Choice, Try Again");
//            }
//        }
//
//
//    };
//

    private static final Scanner scanner = new Scanner(System.in);
    private static final NoteManager manager = new NoteManager();

    public static void main(String[] arg){
        boolean running = true;
        while(running){
            System.out.println("""
                
                ===== Note Manager =====
                1. Create Text Note
                2. Create Checklist Note
                3. Create Reminder Note
                4. View All Notes
                5. Exit
                """);

            System.out.print("Choose an option: ");
            String input = scanner.nextLine().strip();

            switch (input) {
                case "1" -> createTextNote();
                case "2" -> createChecklistNote();
                case "3" -> createReminderNote();
                case "4" -> manager.printNotes();
                case "5" -> {
                    System.out.println("Goodbye!");
                    running = false;
                }
                default -> System.out.println("Invalid option!");
            }


        }
    }

    private static void createReminderNote() {
        System.out.print("Title: ");
        String title = scanner.nextLine();

        System.out.println("Enter content:");
        String content = scanner.nextLine();

        System.out.print("Enter reminder datetime (yyyy-MM-dd HH:mm): ");
        String timeInput = scanner.nextLine();
        LocalDateTime remindAt = LocalDateTime.parse(timeInput, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));

        manager.addNote(new RemainderNote(title, content, remindAt));
        System.out.println("✅ Reminder note created.\n");
    }

    private static void createChecklistNote() {
        System.out.print("Title: ");
        String title = scanner.nextLine();

        List<String> items = new ArrayList<>();
        System.out.println("Enter checklist items (type 'END' to finish):");
        while (true) {
            String item = scanner.nextLine();
            if ("END".equalsIgnoreCase(item)) break;
            items.add(item);
        }

        manager.addNote(new ChecklistNote(title, items));
        System.out.println("✅ Checklist note created.\n");
    }

    private static void createTextNote() {
        System.out.println("Title : ");
        String title = scanner.nextLine();
        System.out.println("Enter content (type 'END' on its own line to finish):");
        StringBuilder content = new StringBuilder();

        while(true){
            String line = scanner.nextLine();
            if("END".equalsIgnoreCase(line)) break;
            content.append(line).append("\n");
        }

        manager.addNote(new TextNote(title,content.toString().strip()));
        System.out.println("✅ Text note created.\n");
    }
    
    

}