package com.soner.gamebullsandcows;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.image.Image;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Vildan Koleji Robotik Kodlama ve Yazılım Kulübü");

        // --- İkon Yükleme Bölümü ---
        try {
            // Dosya yolunu değişkene alalım (Başındaki / işaretine dikkat)
            String imagePath = "/com/soner/gamebullsandcows/icon01.png";
            var resource = getClass().getResource(imagePath);

            if (resource != null) {
                stage.getIcons().clear();

                // 1. Orijinal kare ikon (256x256 olan)
                stage.getIcons().add(new Image(resource.openStream()));

                // 2. Sisteme alternatif olarak 32x32 boyutunu da sunalım
                stage.getIcons().add(new Image(resource.openStream(), 32, 32, true, true));

/*
                // İkonu 32x32 olarak pürüzsüz (smooth) bir şekilde yüklemesini zorluyoruz
                // true, true parametreleri: oranları koru ve yumuşatarak ölçekle demektir
                Image stageIcon = new Image(resource.openStream(), 32, 32, true, true);

                stage.getIcons().add(stageIcon);

 */
                System.out.println("✅ İkon başarıyla bulundu ve yüklendi: " + resource.toExternalForm());
            } else {
                System.err.println("❌ HATA: İkon dosyası kaynaklar içinde bulunamadı!");
                System.err.println("Aranan yol: src/main/resources" + imagePath);
            }
        } catch (Exception e) {
            System.err.println("⚠️ İkon yüklenirken teknik bir hata oluştu: " + e.getMessage());
        }
        // ---------------------------

        stage.setScene(scene);
        stage.show();
    }

}//end class
