package com.example.hpgraph;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;

public class Page6Controller {

    @FXML
    private Label combatText;

    @FXML
    private Label vieLabel;

    @FXML
    private Button attaquerButton;

    @FXML
    private Button allerPage7Button;

    private int nombreDeCoups = 0;
    private boolean basilicEnVie = true;
    private boolean sorcierEnVie = true;
    private int vie = 100;

    public void initialize() {
        String texte = "Vous voilà face au basilic !\nVous pouvez essayer de l'attaquer, mais prenez garde à son regard !";
        combatText.setText(texte);
        vieLabel.setText("Vie: " + vie);
    }

    @FXML
    void attaquerButtonClick() {
        nombreDeCoups++;
        if (basilicEnVie) {
            if (Math.random() < 0.7) {
                String texte = "Vous avez esquivé le basilic vous êtes toujours en vie ! ";
                combatText.setText(texte);
            } else {
                basilicEnVie = false;
                String texte = "Une des dents du basilic est tombé !.";
                combatText.setText(texte);
            }
        } else {
            if (sorcierEnVie) {
                sorcierEnVie = false;
                String texte = "Vous avez poignardé le carnet de Tom Jedusor, le basilic est mort.";
                combatText.setText(texte);
                attaquerButton.setDisable(true); // désactiver le bouton "attaquer"
            } else {
                if (vie <= 0) {
                    String texte = "Vous êtes mort !";
                    combatText.setText(texte);
                    attaquerButton.setDisable(true); // désactiver le bouton "attaquer"
                    // Rediriger vers la page mort.fxml
                    try {
                        FXMLLoader loader = new FXMLLoader(getClass().getResource("mort.fxml"));
                        Parent root = loader.load();
                        Scene scene = new Scene(root);
                        Stage stage = (Stage) allerPage7Button.getScene().getWindow();
                        stage.setScene(scene);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                } else {
                    String texte = "Vous êtes mort !";
                    combatText.setText(texte);
                    attaquerButton.setDisable(true); // désactiver le bouton "attaquer"
                }
            }
        }
        if (basilicEnVie) {
            if (Math.random() < 0.7) {
                int degats = 20;
                vie -= degats;
                vieLabel.setText("Vie : " + vie);
                if (vie <= 0) {
                    sorcierEnVie = false;
                    String texte = "Le basilic vous a tué...";
                    combatText.setText(texte);
                } else {
                    String texte = "Le basilic vous a attaqué ! Vous avez perdu " + degats + " points de vie.";
                    combatText.setText(texte);
                }
            } else {
                String texte = "Le basilic vous attaque mais rate son coup !";
                combatText.setText(texte);
            }
        }
    }


    @FXML
    public void page7ButtonClick() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("page7.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root);
            Stage stage = (Stage) allerPage7Button.getScene().getWindow();
            stage.setScene(scene);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
