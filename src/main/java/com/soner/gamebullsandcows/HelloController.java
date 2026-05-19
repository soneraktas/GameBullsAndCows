package com.soner.gamebullsandcows;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
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
    private TableColumn<TahminModel, String> colGuess;

    @FXML
    private TableColumn<?, ?> colTurn;

    @FXML
    private GridPane gridNumbers;

    @FXML
    private Label lblStatus;

    // FXML'deki TableView ve TableColumn bileşenlerini bağlıyoruz.
    // <TahminModel, ...> ifadesi, bu tablonun TahminModel nesnelerini listeleyeceğini belirtir.
    // JavaFX'te tablolar dinamik listeleri (ObservableList) takip eder.
    private ObservableList<TahminModel> tahminListesi = FXCollections.observableArrayList();

    @FXML
    private TableView<TahminModel> tblHistory;

    @FXML
    private TextField txtGuess;

    @FXML
    public void initialize() {
        // 1. Tablo Sütunu ile Model Sınıfını birbirine bağlıyoruz.
        // "tahmin" yazısı, TahminModel sınıfındaki "getTahmin()" metoduna işaret eder.
        colGuess.setCellValueFactory(new PropertyValueFactory<>("tahmin"));

        // 2. Oluşturduğumuz listeyi tabloya kaynak olarak gösteriyoruz.
        tblHistory.setItems(tahminListesi);
    }

    @FXML
    void onGuessSubmit(ActionEvent event) {
        System.out.println("onGuessSubmit butonuna tıklandı");

        // 1. TextField'dan veriyi oku (Hiçbir kontrol yapmadan)
        String girilenVeri = txtGuess.getText();

        // 2. Bu veriyle yeni bir model nesnesi oluştur
        TahminModel yeniTahmin = new TahminModel(girilenVeri);

        // 3. Nesneyi listeye ekle (Tablo otomatik olarak güncellenecektir)
        tahminListesi.add(yeniTahmin);

        // 4. Kullanıcı kolaylığı için TextField'ı temizle
        txtGuess.clear();

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
