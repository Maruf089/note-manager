package org.example.notemanager;

import java.time.LocalDateTime;
//
//public class Note {
//    private final String title;
//    private final String content;
//    private final LocalDateTime createdAt;
//
//    public Note(String title, String content, LocalDateTime createdAt) {
//        this.title = title;
//        this.content = content;
//        this.createdAt = createdAt;
//    }
//
//    public String getTitle() {
//        return title;
//    }
//
//    public String getContent() {
//        return content;
//    }
//
//    public LocalDateTime getCreatedAt() {
//        return createdAt;
//    }
//
//    public String preview() {
//        return title + " - " + createdAt.toString();
//    }
//}

public sealed interface Note permits TextNote , ChecklistNote, RemainderNote {
    String title();
    String content();
    String type(); // return "Text", "Checklist", or "Reminder"
}
