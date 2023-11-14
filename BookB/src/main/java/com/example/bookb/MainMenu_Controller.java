package com.example.bookb;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


public class MainMenu_Controller implements Initializable {
    private Stage stage;
    private Scene scene;
    private Parent root;
    @FXML
    private AnchorPane scenePane;
    @FXML
    private Button Details2;
    @FXML
    private Label ratingLabel;
    @FXML
    private TableColumn<Book, Integer> bRating;
    @FXML
    private TableView<Book> tableView;
    @FXML
    private TableColumn<Book, String> bAuthor;
    @FXML
    private TableColumn<Book, String> bTitle;
    @FXML
    private Label label;
    @FXML
    private Label label1;
    @FXML
    private TextField textAuthor;
    @FXML
    private TextField textTitle;
    @FXML
    private ChoiceBox<Integer> dropDown;
    private final Integer[] rate = {0, 1, 2, 3, 4, 5};
    @FXML
    private Pane displayPanel;


    @FXML
    void insert(ActionEvent event) {
        Book book  = new Book(textTitle.getText(), (textAuthor.getText()), (dropDown.getValue()));
        ObservableList<Book> books = tableView.getItems();
        books.add(book);
        tableView.setItems(books);

        }


    public void userClickedOnTable() {
        this.Details2.setDisable(false);
        this.displayPanel.setDisable(false);
    }

    public void changeScenebutton(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("Library.fxml"));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void getRating(ActionEvent event) {
        Integer myRating = dropDown.getValue();
    }

    public void changeProfile(ActionEvent event) throws IOException {
      root = FXMLLoader.load(getClass().getResource("Profile.fxml"));
      stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
      scene = new Scene(root);
      stage.setScene(scene);
      stage.show();
    }


    public void logout(ActionEvent event) {
        stage = (Stage) scenePane.getScene().getWindow();
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Exit");
        alert.setHeaderText("You are now exiting Book Buddy.");
        alert.setContentText("Continue?");

        if(alert.showAndWait().get() == ButtonType.OK){
            stage.close();
            System.out.println("Application successfully closed");
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

//        Title, Author, and Rating Cell
        bTitle.setCellValueFactory(new PropertyValueFactory<>("title"));
        bAuthor.setCellValueFactory(new PropertyValueFactory<>("author"));
        bRating.setCellValueFactory(new PropertyValueFactory<>("rate"));

//        Get Book class info
        tableView.setItems(getBooks());

//        Dropdown Selection
        dropDown.getItems().addAll(rate);
        dropDown.setOnAction(this::getRating);
        if(dropDown.getValue() == null){
            Alert alert2 = new Alert (Alert.AlertType.ERROR);
            alert2.setTitle("Null");
            alert2.setHeaderText("No rating input");
        }

//        Disables Library button until user clicks table
        this.Details2.setDisable(true);
        this.displayPanel.setDisable(true);


        tableView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Book>() {
            @Override
            public void changed(ObservableValue<? extends Book> observableValue, Book book, Book t1) {
                book = tableView.getSelectionModel().getSelectedItem();
                label.setText("By: " + book.getAuthor());
                label1.setText("''" + book.getTitle() + "''");
                ratingLabel.setText("You gave " + "''" + book.getTitle() + "''" + " a rating of: " + book.getRate());

            }


        });
    }

    public ObservableList<Book> getBooks() {

        ObservableList<Book> books = FXCollections.observableArrayList();
        books.add(new Book("Secrets of the Hidden Garden", "James Mitchell", 1));
        books.add(new Book("Under the Parisian Stars", "Emily Bennett", 0));
        books.add(new Book("The Quest for the Sapphire Key", "Ben Anderson", 4));
        books.add(new Book("The Mystery at Willowbrook Manor", "Olivia Harper", 5));
        books.add(new Book("Moonlight Sonata", "David Roberts", 5));
        return books;
    }

    @FXML
    void remove(ActionEvent event) {
        int selectedID = tableView.getSelectionModel().getSelectedIndex();
        tableView.getItems().remove(selectedID);
    }
}


