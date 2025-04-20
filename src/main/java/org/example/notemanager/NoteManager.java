package org.example.notemanager;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class NoteManager {
    private static final Path NOTES_DIR = Paths.get("notes");
    public NoteManager() throws IOException {
        if(!Files.exists(NOTES_DIR))
            Files.createDirectories(NOTES_DIR);
    }
    public void saveNote(Note note) throws IOException {
        Path file = NOTES_DIR.resolve(note.getTitle()+".txt");
        Files.writeString(file,note.getContent());
    }
}
