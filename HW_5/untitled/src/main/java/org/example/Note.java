package org.example;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


public class Note {
    private String title;
    private String content;
    private LocalDateTime created_at;

    public Note(String title, String content) {
        this.title = title;
        this.content = content;
        this.created_at = LocalDateTime.now();
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public LocalDateTime getCreated_at() {
        return created_at;
    }

    public void setTitle(String newTitle) {
        this.title = newTitle;
    }

    public void setContent(String newContent) {
        this.content = newContent;
    }

    public static Note fromDict(String title, String content, String created_at) {
        Note note = new Note(title, content);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        created_at = created_at.replace("\"", "").trim();
        String[] parts = created_at.split(",");
        if (parts.length == 3) {
            note.created_at = LocalDateTime.parse(parts[2], formatter);
        } else {
        }
        return note;
    }

    public String toJSON() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return String.format("{\"title\": \"%s\", \"content\": \"%s\", \"created_at\": \"%s\"}",
                this.title, this.content, this.created_at.format(formatter));
    }
}
