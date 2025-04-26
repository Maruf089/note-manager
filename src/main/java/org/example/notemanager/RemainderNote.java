package org.example.notemanager;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public final class RemainderNote implements Note{
    private  final String title;
    private final String content;
    private final LocalDateTime remaindAt;

    public RemainderNote(String title, String content, LocalDateTime remaindAt) {
        this.title = title;
        this.content = content;
        this.remaindAt = remaindAt;
    }


    @Override
    public String title() {
        return title;
    }

    @Override
    public String content() {
        return content;
    }

    @Override
    public String type() {
        return "Remainder";
    }

    public LocalDateTime remaindAt(){
        return remaindAt;
    }

    @Override
    public String toString() {
        return new StringBuilder()
                .append("── Reminder Note ──\n")
                .append("Title: ").append(title).append("\n")
                .append("Content: ").append(content).append("\n")
                .append("Remind At: ").append(
                        remaindAt.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"))
                )
                .toString();
    }

}
