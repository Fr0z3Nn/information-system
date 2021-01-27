package ru.project.system.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import ru.project.system.DB.Book;

public class AcceptBookController {
    @FXML
    public TextField idBooks;
    @FXML
    public Button acceptOrder;
    public void initialize() {
        acceptOrder.setOnMouseClicked(event -> {
            String[] booksList = idBooks.getText().split("\\s+");
            for(String booksId : booksList){
                int id = Integer.parseInt(booksId);
                Book.acceptBook(id);
            }
        });
    }
}
