package ru.project.system.DB;

import ru.project.system.controller.MainLibraryController;

import java.util.ArrayList;
import java.util.Objects;

public class Book {
    public static ArrayList<Book> bookDataBase = new ArrayList<>();
    private static Integer count = 0;
    private Integer id;
    private String name;
    private String author;
    private Status status;
    private String reader;

    public Book(String name, String author, Status status, String reader) {
        this.id = count++;
        this.name = name;
        this.author = author;
        this.status = status;
        this.reader = reader;
    }

    public static void addBook(Book book) {
        bookDataBase.add(book);
    }

    public static void takeBook(int id, String name) {
        for (Book book : bookDataBase) {
            if (book.getId() == id) {
                book.setReader(name);
                book.setStatus(Status.WAIT_ISSUE);
            }

        }
        MainLibraryController.resfreshTable();
    }

    public static void returnBook(int id){
        for (Book book : bookDataBase) {
            if (book.getId() == id) {
                book.setStatus(Status.WAIT_REFUND);
            }
        }
        MainLibraryController.resfreshTable();
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

    public static Integer getCount() {
        return count;
    }

    public static void setCount(Integer count) {
        Book.count = count;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
