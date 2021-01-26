package ru.project.system.DB;

import java.util.ArrayList;
import java.util.Objects;

public class Book {
    public static ArrayList<Book> bookDataBase = new ArrayList<>();

    private String name;
    private String author;
    private Status status;
    private String reader;

    public Book(String name, String author, Status status, String reader) {
        this.name = name;
        this.author = author;
        this.status = status;
        this.reader = reader;
    }

    public static void addBook(Book book) {
        bookDataBase.add(book);
    }

    public static void removeBook(Book book) {
        bookDataBase.remove(book);
    }

    public static Book getBook(Book book, Status status) {
        for (Book value : bookDataBase) {
            if (value.equals(book)) {
                return value;
            }
        }
        return null;
    }

    public static void changeStatus(Book book, Status status) {
        for (int i = 0; i < bookDataBase.size(); i++) {
            if (bookDataBase.get(i).equals(book)) {
                Book newBook = bookDataBase.get(i);
                newBook.setStatus(status);
                bookDataBase.remove(book);
                bookDataBase.add(i, newBook);
            }
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return Objects.equals(name, book.name) &&
                Objects.equals(author, book.author) &&
                status == book.status &&
                Objects.equals(reader, book.reader);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, author, status, reader);
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Status getStatus() {
        return status;
    }

    public String getReader() {
        return reader;
    }

    public void setReader(String reader) {
        this.reader = reader;
    }
}
