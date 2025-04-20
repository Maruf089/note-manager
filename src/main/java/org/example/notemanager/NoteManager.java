package org.example.notemanager;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.teeing;

public class NoteManager {
    private static final Path NOTES_DIR = Paths.get("notes");
    public NoteManager() throws IOException {
        if(!Files.exists(NOTES_DIR))
            Files.createDirectories(NOTES_DIR);
    }
    public void saveNote(Note note) throws IOException {
        Path file = NOTES_DIR.resolve(note.getTitle()+".txt");
        // The resolve method appends the file name (derived from the note object's title with a .txt extension)
        // to this directory path, creating a full path to the file.

        Files.writeString(file,note.getContent());

        // The Files.writeString method writes the content of the note (retrieved via note.getContent()) to the specified file path.
        //If the file doesn't exist, it creates the file; if it does exist, it overwrites the file's content.
    }

    public List<Note> listNotes(){
        if(!Files.exists(NOTES_DIR)) return Collections.emptyList();
        try(Stream<Path> paths = Files.list(NOTES_DIR)){
            return (List<Note>) paths.filter(Files::isRegularFile)
                    .map(path -> {
                        try {
                            String title = path.getFileName().toString().replaceFirst(".txt","");
                            String contect = Files.readString(path);
                            return new Note(title,contect, LocalDateTime.now());
                        }
                        catch (IOException e) {
                            e.printStackTrace();
                            return null;
                        }
                    })
                    .filter(Objects::nonNull)
                    .collect(Collectors.toList());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void printStats(){
        var notes = listNotes();
        var stats = notes.stream().collect(
                teeing(
                       Collectors.counting(),
                       Collectors.averagingInt(n -> n.getContent().length()),
                        (count,avgContent) -> Map.of("Count",count,
                        "Average Length", avgContent)
                )
        );
        // The Collectors.teeing method in Java (introduced in Java 12) is used to combine two collectors into a single collector.
        // It takes three arguments: two collectors and a "merger" function that combines the results from the two collectors
        System.out.println("\n--- Note Stats ---");
        stats.forEach((k, v) -> System.out.println(k + ": " + v));
    }
}
