package org.example;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class NoteManager {
    private String filePath;
    private List<Note> notes;

    public NoteManager(String filePath) {
        this.filePath = filePath;
        this.notes = loadNotes();
    }

    private List<Note> loadNotes() {
        List<Note> loadedNotes = new ArrayList<>();
        try {
            List<String> lines = Files.readAllLines(Paths.get(filePath));
            for (String line : lines) {
                String[] parts = line.split(",");
                Note note = Note.fromDict(parts[0], parts[1], parts[2]);
                loadedNotes.add(note);
            }
        } catch (IOException e) {
            // Если файл не найден, возвращаем пустой список
        }
        return loadedNotes;
    }
    private void saveNotes() {
        try {
            List<String> lines = new ArrayList<>();
            for (Note note : notes) {
                lines.add(note.toJSON());
            }
            Path file = Paths.get(filePath);
            Files.write(file, lines);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void createNoteFromInput() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите заголовок заметки: ");
        String title = scanner.nextLine();
        System.out.println("Введите содержимое заметки: ");
        String content = scanner.nextLine();
        createNote(title, content);
    }

    public void createNote(String title, String content) {
        Note note = new Note(title, content);
        notes.add(note);
        saveNotes();
        System.out.println("\nЗаметка успешно создана.");
    }
    public void readNotes() {
        if (notes.isEmpty()) {
            System.out.println("\nСписок заметок пуст.");
        } else {
            System.out.println("Список заметок:");
            for (int i = 0; i < notes.size(); i++) {
                Note note = notes.get(i);
                System.out.println('\n' + (i - 9) + ". " + note.getTitle() +
                        " (" + note.getCreated_at().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")) + ")");
            }
        }
    }

    public void readSelectedNoteFromInput(Scanner scanner) {
        scanner = new Scanner(System.in);
        System.out.println("Введите индекс заметки для прочтения: ");
        int noteIndex = scanner.nextInt();
        readSelectedNote(noteIndex);
    }

    public void readSelectedNote(int noteIndex) {
        if (noteIndex < 1 || noteIndex > notes.size()) {
            System.out.println('\n' + "Неверный индекс заметки.");
        } else {
            Note note = notes.get(noteIndex - 1);
            System.out.println('\n' + "Заголовок: " + note.getTitle());
            System.out.println("Содержимое: " + note.getContent());
            System.out.println("Дата создания: " + note.getCreated_at().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
        }
    }

    public void editNoteFromInput() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите индекс заметки для редактирования: ");
        int noteIndex = scanner.nextInt();
        scanner.nextLine(); // Очистка буфера после nextInt
        System.out.println("Введите новый заголовок заметки: ");
        String newTitle = scanner.nextLine();
        System.out.println("Введите новое содержимое заметки: ");
        String newContent = scanner.nextLine();
        editNote(noteIndex, newTitle, newContent);
    }

    public void editNote(int noteIndex, String newTitle, String newContent) {
        if (noteIndex < 1 || noteIndex > notes.size()) {
            System.out.println('\n' + "Неверный индекс заметки.");
        } else {
            Note note = notes.get(noteIndex - 1);
            note.setTitle(newTitle);
            note.setContent(newContent);
            saveNotes();
            System.out.println('\n' + "Заметка успешно отредактирована.");
        }
    }

    public void deleteNoteFromInput() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите индекс заметки для удаления: ");
        int noteIndex = scanner.nextInt();
        deleteNote(noteIndex);
    }

    public void deleteNote(int noteIndex) {
        if (noteIndex < 1 || noteIndex > notes.size()) {
            System.out.println('\n' + "Неверный индекс заметки.");
        } else {
            Note note = notes.remove(noteIndex - 1);
            saveNotes();
            System.out.println('\n' + "Заметка \"" + note.getTitle() + "\" успешно удалена.");
        }
    }
}
