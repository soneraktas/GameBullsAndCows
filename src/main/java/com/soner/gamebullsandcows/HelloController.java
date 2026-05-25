package com.soner.gamebullsandcows;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.util.Duration;
import java.util.ArrayList;
import java.util.Collections;

public class HelloController {

    @FXML private Label lblStatus;
    @FXML private TextField txtGuess;
    @FXML private Button btnGuess;
    @FXML private TableView<TahminModel> tblHistory;
    @FXML private TableColumn<TahminModel, Integer> colTurn;
    @FXML private TableColumn<TahminModel, String> colGuess;
    @FXML private TableColumn<TahminModel, Integer> colBulls;
    @FXML private TableColumn<TahminModel, Integer> colCows;

    // Rakam butonlarını sıfırlayabilmek için üst konteynırı bağlamalıyız (FXML'de VBox'a fx:id="vboxNumbers" verebilirsin)
    // Ya da sadece onReset içinde listeyi temizlemek yeterli olacaktır.

    private String hedefSayi;
    private int hamleSayaci = 1;
    private int saniye = 0;
    private Timeline timeline;
    private ObservableList<TahminModel> tahminListesi = FXCollections.observableArrayList();

    @FXML
    public void initialize() {
        colTurn.setCellValueFactory(new PropertyValueFactory<>("sira"));
        colGuess.setCellValueFactory(new PropertyValueFactory<>("tahmin"));
        colBulls.setCellValueFactory(new PropertyValueFactory<>("bulls"));
        colCows.setCellValueFactory(new PropertyValueFactory<>("cows"));

        tblHistory.setItems(tahminListesi);

        setupTimer();
        yeniOyunBaslat();
    }

    private void setupTimer() {
        if (timeline != null) timeline.stop();
        timeline = new Timeline(new KeyFrame(Duration.seconds(1), e -> {
            saniye++;
            lblStatus.setText("Süre: " + saniye + " sn | Tahmin yapın!");
        }));
        timeline.setCycleCount(Timeline.INDEFINITE);
    }

    private void yeniOyunBaslat() {
        tahminListesi.clear();
        hamleSayaci = 1;
        saniye = 0;
        sayiUret();
        timeline.playFromStart();
        btnGuess.setDisable(false);
        txtGuess.clear();
        lblStatus.setText("Yeni oyun başladı! 4 basamaklı sayı girin.");
    }

    private void sayiUret() {
        ArrayList<Integer> rakamlar = new ArrayList<>();
        for (int i = 0; i <= 9; i++) rakamlar.add(i);
        do {
            Collections.shuffle(rakamlar);
        } while (rakamlar.get(0) == 0);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 4; i++) sb.append(rakamlar.get(i));
        hedefSayi = sb.toString();
        System.out.println("Hedef: " + hedefSayi);
    }

    @FXML
    void onGuessSubmit(ActionEvent event) {
        String tahmin = txtGuess.getText();

        if (tahmin.length() != 4 || !tahmin.matches("\\d+")) {
            lblStatus.setText("Hata: Sadece 4 basamaklı sayı!");
            return;
        }

        int b = 0, c = 0;
        for (int i = 0; i < 4; i++) {
            char t = tahmin.charAt(i);
            if (t == hedefSayi.charAt(i)) b++;
            else if (hedefSayi.contains(String.valueOf(t))) c++;
        }

        tahminListesi.add(0, new TahminModel(hamleSayaci++, tahmin, b, c));
        txtGuess.clear();

        if (b == 4) {
            timeline.stop();
            lblStatus.setText("TEBRİKLER! Sayı: " + hedefSayi);
            btnGuess.setDisable(true);
            skorKaydet(saniye, hamleSayaci - 1);
        }
    }

    private void skorKaydet(int sure, int hamle) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Vildan Koleji - Oyun Bitti");
        alert.setHeaderText("Harika İş çıkardın!");
        alert.setContentText("Süre: " + sure + " saniye\nHamle: " + hamle + "\n\nYeni bir rekor için tekrar dene!");
        alert.showAndWait();
    }

    @FXML
    void onNumberToggle(ActionEvent event) {
        Button btn = (Button) event.getSource();
        String style = btn.getStyle();

        if (style.contains("#393E46") || style.isEmpty()) {
            btn.setStyle("-fx-background-color: #2ecc71; -fx-text-fill: white; -fx-font-weight: bold;");
        } else if (style.contains("#2ecc71")) {
            btn.setStyle("-fx-background-color: #e74c3c; -fx-text-fill: white; -fx-font-weight: bold;");
        } else {
            btn.setStyle("-fx-background-color: #393E46; -fx-text-fill: white; -fx-font-weight: bold;");
        }
    }

    @FXML
    void onResetGame(ActionEvent event) {
        yeniOyunBaslat();
    }
}