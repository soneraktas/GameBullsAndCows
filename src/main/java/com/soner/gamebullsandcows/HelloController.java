package com.soner.gamebullsandcows;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;


public class HelloController {

    @FXML
    private Button btnGuess;

    @FXML
    private Button btnReset;

    @FXML
    private TableColumn<?, ?> colBulls;

    @FXML
    private TableColumn<?, ?> colCows;

    @FXML
    private TableColumn<?, ?> colGuess;

    @FXML
    private TableColumn<?, ?> colTurn;

    @FXML
    private GridPane gridNumbers;

    @FXML
    private Label lblStatus;

    @FXML
    private TableView<?> tblHistory;

    @FXML
    private TextField txtGuess;

    @FXML
    void onGuessSubmit(ActionEvent event) {
        System.out.println("onGuessSubmit butonuna tıklandı");

    }//end onGuessSubmit

    @FXML
    void onNumberToggle(ActionEvent event) {
        System.out.println("onNumberToggle butonuna tıklandı");

        // Tıklanan butonu event üzerinden yakalıyoruz
        Button clickedButton = (Button) event.getSource();

        // Butonun mevcut arka plan rengini stil metninden kontrol ediyoruz
        String currentStyle = clickedButton.getStyle();

        if (currentStyle.contains("#393E46") || currentStyle.isEmpty()) {
            // 1. Tıklama: Rakam VAR (Yeşil yap)
            clickedButton.setStyle("-fx-background-color: #2ecc71; -fx-text-fill: white; -fx-font-weight: bold; -fx-cursor: hand;");
        } else if (currentStyle.contains("#2ecc71")) {
            // 2. Tıklama: Rakam YOK (Kırmızı yap)
            clickedButton.setStyle("-fx-background-color: #e74c3c; -fx-text-fill: white; -fx-font-weight: bold; -fx-cursor: hand;");
        } else {
            // 3. Tıklama: Başa Dön (Eski nötr rengi)
            clickedButton.setStyle("-fx-background-color: #393E46; -fx-text-fill: white; -fx-font-weight: bold; -fx-cursor: hand;");
        }//end else

    // ... diğer metodların ...

    }//end onNumberToggle


    @FXML
    void onResetGame(ActionEvent event) {
        System.out.println("onResetGame butonuna tılandı");

    }//end onResetGame

}//end class
