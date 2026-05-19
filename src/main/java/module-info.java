module com.soner.gamebullsandcows {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.soner.gamebullsandcows to javafx.fxml;
    exports com.soner.gamebullsandcows;
}