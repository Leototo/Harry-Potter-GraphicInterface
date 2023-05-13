package com.example.hpgraph;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class Page5Controller {

    @FXML
    private TextField houseInput;

    @FXML
    private void goToNextPage(ActionEvent event) throws IOException {
        String house = houseInput.getText().trim().toLowerCase();
        if (house.equals("griffyndor")) {
            Parent root = FXMLLoader.load(getClass().getResource("Griffyndor.fxml"));
            Scene scene = new Scene(root, 600, 400);
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        } else {
            Parent root = FXMLLoader.load(getClass().getResource("page6.fxml"));
            Scene scene = new Scene(root, 600, 400);
            Stage stage = (Stage) ((
                    Node) event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        }
    }

}