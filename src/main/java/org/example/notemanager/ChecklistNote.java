package org.example.notemanager;

import java.util.List;

public final class ChecklistNote implements Note{
    private final String title;
    private final List<String>items;


    public ChecklistNote(String title, List<String> items) {
        this.title = title;
        this.items = items;
    }

    @Override
    public String title(){
        return title;
    }

    @Override
    public String content(){
        return String.join("\n- ",items);
    }

    @Override
    public String type(){
        return "Checklist";
    }

    @Override
    public String toString() {
        return "── Checklist Note ── \n" +
                "Title: " + title + "\n" +
                "Items: "  + String.join("\n- ", items) + "\n";
    }

//    @Override
//    public String toString(){
//        StringBuilder str = new StringBuilder("── Checklist Note ── \n");
//        str.append("Title: ").append(title).append("\n");
//        str.append("Items : \n");
//        for (String item : items) {
//            sb.append("- ").append(item).append("\n");
//        }
//        return sb.toString();
//    }


}
