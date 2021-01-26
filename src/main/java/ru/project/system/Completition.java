package ru.project.system;

import ru.project.system.DB.Book;
import ru.project.system.DB.Status;
import ru.project.system.controller.MainLibraryController;

public class Completition {
    public Completition() {
        Book.addBook(new Book("Мастер и Маргарита","Булгаков", Status.STOCK,"---"));
        Book.addBook(new Book("Мертвые души","Гоголь", Status.STOCK,"---"));
        Book.addBook(new Book("Собачье сердце","Булгаков", Status.STOCK,"---"));
        Book.addBook(new Book("Преступление и наказание","Достоевский", Status.STOCK,"---"));
        Book.addBook(new Book("Отцы и дети","Тургенев", Status.STOCK,"---"));
    }
}
