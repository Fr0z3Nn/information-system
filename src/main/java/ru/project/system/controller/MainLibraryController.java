package ru.project.system.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import ru.project.system.DB.Book;
import ru.project.system.DB.Status;

import java.io.IOException;

public class MainLibraryController {
    private static TableView<Book> tableToRefresh;
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
    public TableColumn<Book, Integer> idBook;
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

    public static void resfreshTable(){
        tableToRefresh.refresh();
    }

    @FXML
    public void initialize() {

        tableToRefresh = table;

        idBook.setCellValueFactory(new PropertyValueFactory<>("id"));
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

        takeBook.setOnMouseClicked(event -> {
            Stage stage = new Stage();
            Parent root = null;
            try {
                root = FXMLLoader.load(getClass().getResource("/takeBook.fxml"));
            } catch (IOException e) {
                e.printStackTrace();
            }
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        });

        returnBook.setOnMouseClicked(event -> {
            Stage stage = new Stage();
            Parent root = null;
            try {
                root = FXMLLoader.load(getClass().getResource("/returnBook.fxml"));
            } catch (IOException e) {
                e.printStackTrace();
            }
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        });
    }
}
