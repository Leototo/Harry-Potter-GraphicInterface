package com.example.hpgraph;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Random;

public class Page3Controller {

    @FXML
    private Label houseLabel;

    @FXML
    private void start(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Page5.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root, 600, 400);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    private void displayHouse(ActionEvent event) {
        // Randomly select a house
        String[] houses = {"Ravenclaw", "Hufflepuff", "Gryffindor", "Slytherin"};
        int randomIndex = new Random().nextInt(houses.length);
        String selectedHouse = houses[randomIndex];

        String message = "Your house will be " + selectedHouse;
        houseLabel.setText(message);
    }

}