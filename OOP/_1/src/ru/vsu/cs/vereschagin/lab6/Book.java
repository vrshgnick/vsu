package ru.vsu.cs.vereschagin.lab6;

class Book {
    private String title;
    private BookCategory category;

    public Book(String title, BookCategory category) {
        this.title = title;
        this.category = category;
    }

    public void printInfo() {
        System.out.println("Название: " + title);
        System.out.println("Категория: " + category + " - " + category.getDescription());
    }
}
