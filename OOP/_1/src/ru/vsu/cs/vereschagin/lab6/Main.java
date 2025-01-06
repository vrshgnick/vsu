package ru.vsu.cs.vereschagin.lab6;

import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите название книги: ");
        String title = scanner.nextLine();

        System.out.print("Введите категорию книги (FICTION, NON_FICTION, SCIENCE, HISTORY, BIOGRAPHY): ");
        String categoryInput = scanner.next().toUpperCase();

        try {
            BookCategory category = BookCategory.valueOf(categoryInput);
            Book book = new Book(title, category);
            book.printInfo();
        } catch (IllegalArgumentException e) {
            System.out.println("Некорректная категория книги.");
        }
    }
}