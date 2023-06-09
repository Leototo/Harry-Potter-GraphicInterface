package com.example.hpgraph;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Random;

public class Page4Controller {

    private int sorcererHP = 100;
    private int trollHP = 100;
    private boolean sorcererDefending = false;
    private boolean trollDefending = false;
    private boolean defendButtonDisabled = false;

    private Random random = new Random();

    @FXML
    private Button attackButton;

    @FXML
    private Button defendButton;

    @FXML
    private Button winButton;

    @FXML
    private Text statusText;

    @FXML
    private Text sorcererHPText;

    @FXML
    private Text trollHPText;

    @FXML
    public void initialize() {
        updateHPTexts();

        statusText.setText("Your wizard encounters an horrible troll !!");
        statusText.setFont(Font.font("System", FontWeight.BOLD, 14));

        attackButton.setOnAction(event -> handleAttackButton());
        defendButton.setOnAction(event -> handleDefendButton());

        winButton.setDisable(true);
    }

    private void updateHPTexts() {
        sorcererHPText.setText("Wizard HP: " + sorcererHP);
        trollHPText.setText("Troll HP: " + trollHP);
    }

    private void checkForEndGame() {
        if (sorcererHP <= 0) {
            statusText.setText("Troll wins!");
            attackButton.setDisable(true);
            defendButton.setDisable(true);
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("mort.fxml"));
                Parent root = loader.load();
                Scene scene = new Scene(root);
                Stage stage = (Stage) attackButton.getScene().getWindow();
                stage.setScene(scene);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else if (trollHP <= 0) {
            statusText.setText("You win! Congratulations ! ");
            attackButton.setDisable(true);
            defendButton.setDisable(true);
            winButton.setDisable(false);
        }
    }

    private void trollAttacks() {
        if (random.nextDouble() < 0.5) {
            int damage = 20;
            if (sorcererDefending) {
                damage /= 2;
                sorcererDefending = false;
            }
            sorcererHP -= damage;
            statusText.setText(statusText.getText() + "\nTroll hits with his mass! you take " + damage + " damage.");
        } else {
            statusText.setText(statusText.getText() + "\nTroll misses.");
        }

        updateHPTexts();
        checkForEndGame();
    }

    @FXML
    public void handleAttackButton() {
        if (random.nextDouble() < 0.8) {
            trollHP -= 20;
            statusText.setText("Wizard casts Leviosa! Troll takes 20 damage.");
        } else {
            statusText.setText("Wizard misses Leviosa.");
        }

        sorcererDefending = false;
        trollAttacks();

        checkForEndGame();
    }

    @FXML
    public void handleDefendButton() {
        if(!defendButtonDisabled) {
            sorcererDefending = true;
            sorcererHP += 20;
            statusText.setText("Wizard drinks a health potion and gains 20 HP.");
            trollAttacks();
            defendButtonDisabled = true;
            defendButton.setDisable(true);
            checkForEndGame();
        }
    }
    @FXML
    public void handleWinButton() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("page5.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root);
            Stage stage = (Stage) winButton.getScene().getWindow();
            stage.setScene(scene);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}







