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

    }//end onNumberToggle

    @FXML
    void onResetGame(ActionEvent event) {
        System.out.println("onResetGame butonuna tılandı");

    }//end onResetGame

}//end class
