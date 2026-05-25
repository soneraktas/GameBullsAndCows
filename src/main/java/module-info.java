module com.soner.gamebullsandcows {
    requires javafx.controls;
    requires javafx.fxml;

    // Bu satır kritik: resources altındaki görsellere erişim izni verir
    opens com.soner.gamebullsandcows to javafx.fxml, javafx.graphics;
    //opens com.soner.gamebullsandcows to javafx.fxml;
    exports com.soner.gamebullsandcows;
}