package org.example;
import org.example.NoteUI;
import org.example.NoteManager;
import org.example.Note;

public class Main {
    public static void main(String[] args) {
        String filePath = "notes.json";
        NoteUI noteUI = new NoteUI(filePath);
        noteUI.startUI();
    }
}