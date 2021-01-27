package ru.project.system.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import ru.project.system.DB.Book;
import ru.project.system.DB.Status;

public class TakeBookController {
    @FXML
    public TextField nameUser;
    @FXML
    public TextField idBooks;
    @FXML
    public Button createOrder;

    public void initialize() {
        createOrder.setOnMouseClicked(event -> {
            String[] booksList = idBooks.getText().split("\\s+");
            for(String booksId : booksList){
                int id = Integer.parseInt(booksId);
                Book.takeBook(id,nameUser.getText());
            }
        });
    }
}
