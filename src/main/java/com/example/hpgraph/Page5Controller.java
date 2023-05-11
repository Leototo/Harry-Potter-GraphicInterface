package com.example.hpgraph;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

import java.util.Random;

public class Page5Controller {

    private int sorcererHP = 100;
    private int trollHP = 120;
    private boolean sorcererDefending = false;
    private boolean trollDefending = false;

    private Random random = new Random();

    @FXML
    private Button attackButton;

    @FXML
    private Button defendButton;

    @FXML
    private Text statusText;

    @FXML
    private Text sorcererHPText;

    @FXML
    private Text trollHPText;

    @FXML
    public void initialize() {
        updateHPTexts();

        statusText.setText("Wizard encounters a troll!");
        statusText.setFont(Font.font("System", FontWeight.BOLD, 14));

        attackButton.setOnAction(event -> handleAttackButton());
        defendButton.setOnAction(event -> handleDefendButton());
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
            System.exit(0);
        } else if (trollHP <= 0) {
            statusText.setText("Wizard wins!");
            attackButton.setDisable(true);
            defendButton.setDisable(true);
        }
    }

    private void trollAttacks() {
        if (random.nextDouble() < 0.6) {
            int damage = 30;
            if (sorcererDefending) {
                damage /= 2;
                sorcererDefending = false;
            }
            sorcererHP -= damage;
            statusText.setText(statusText.getText() + "\nTroll hits with his club! Sorcerer takes " + damage + " damage.");
        } else {
            statusText.setText(statusText.getText() + "\nTroll misses with his club.");
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
            statusText.setText("Wizard misses with Leviosa.");
        }

        sorcererDefending = false;
        trollAttacks();

        checkForEndGame();
    }

    @FXML
    public void handleDefendButton() {
        sorcererDefending = true;
        sorcererHP += 20;
        statusText.setText("Wizard drinks a health potion and gains 20 HP.");
        trollAttacks();

        checkForEndGame();
    }

}




