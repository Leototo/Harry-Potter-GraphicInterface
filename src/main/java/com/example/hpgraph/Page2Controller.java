package com.example.hpgraph;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class Page2Controller {
    @FXML
    private void start(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("Page3.fxml")));
        Scene scene = new Scene(root, 600, 400);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }


    ObservableList<String> maritalStatusList = FXCollections.observableArrayList("Rat", "Toad", "Owl");
    @FXML
    private ChoiceBox maritalStatusBox;

    @FXML
    private void initialize() {
        maritalStatusBox.setValue("Rat");
        maritalStatusBox.setItems(maritalStatusList);

    }
    ObservableList<String> StatusList = FXCollections.observableArrayList("Phoenix_Feather", "Dragon_heartstring", "Owl");
    @FXML
    private ChoiceBox StatusBox;

    @FXML
    private void initialize1() {
        StatusBox.setValue("Rat");
        StatusBox.setItems(StatusList);

    }
}
