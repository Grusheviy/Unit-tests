package org.example;

import org.example.NoteManager;

import java.util.Scanner;

public class NoteUI extends NoteManager {

    public NoteUI(String filePath) {
        super(filePath);
    }

    public void startUI() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println('\n' + "----------------" + '\n');
            System.out.println("1. Создать заметку");
            System.out.println("2. Вывести список заметок");
            System.out.println("3. Прочитать выбранную заметку");
            System.out.println("4. Редактировать заметку");
            System.out.println("5. Удалить заметку");
            System.out.println("6. Выйти");
            System.out.println('\n' + "----------------" + '\n');

            System.out.println("Выберите действие: ");
            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    createNoteFromInput();
                    break;
                case "2":
                    readNotes();
                    break;
                case "3":
                    readSelectedNoteFromInput(scanner);
                    break;
                case "4":
                    editNoteFromInput();
                    break;
                case "5":
                    deleteNoteFromInput();
                    break;
                case "6":
                    System.out.println("Программа завершена.");
                    System.exit(0);
                default:
                    System.out.println("Неверный выбор. Попробуйте еще раз.");
            }
        }
    }
}