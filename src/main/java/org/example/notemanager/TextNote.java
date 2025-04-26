package org.example.notemanager;

public final class TextNote implements Note  {
    private final String title;
    private final String content;

    public TextNote(String title, String content) {
        this.title = title;
        this.content = content;
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
        return "Text";
    }

    @Override
    public String toString() {
        return "── Text Note ──\n" +
                "Title: " + title + "\n" +
                "Content:\n" + content;
    }


}
