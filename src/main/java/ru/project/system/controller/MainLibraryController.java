package ru.project.system.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import ru.project.system.DB.Book;
import ru.project.system.DB.Status;

public class MainLibraryController {
    @FXML
    public PasswordField pass;
    @FXML
    public TableView<Book> table;
    @FXML
    public Button takeBook;
    @FXML
    public Button returnBook;
    @FXML
    public Button checkRoot;
    @FXML
    public Button giveBook;
    @FXML
    public Button acceptBook;
    @FXML
    public TableColumn<Book, String> nameBook;
    @FXML
    public TableColumn<Book, String> authorBook;
    @FXML
    public TableColumn<Book, Status> statusBook;
    @FXML
    public TableColumn<Book, String> readerBook;

    private final ObservableList<Book> booksObservableList
            = FXCollections.observableArrayList();

    @FXML
    public void initialize() {
        nameBook.setCellValueFactory(new PropertyValueFactory<>("name"));
        authorBook.setCellValueFactory(new PropertyValueFactory<>("author"));
        statusBook.setCellValueFactory(new PropertyValueFactory<>("status"));
        readerBook.setCellValueFactory(new PropertyValueFactory<>("reader"));

        booksObservableList.setAll(Book.bookDataBase);
        table.setItems(booksObservableList);


        giveBook.visibleProperty().setValue(false);
        acceptBook.visibleProperty().setValue(false);
        checkRoot.setOnMouseClicked(event -> {
            if (pass.getText().equals("qwerty")){
                giveBook.visibleProperty().setValue(true);
                acceptBook.visibleProperty().setValue(true);
            }
        });

    }
}
