package com.soner.gamebullsandcows;

public class TahminModel {

    private final String tahmin;

    public TahminModel(String tahmin) {
        this.tahmin = tahmin;
    }//end yapılandırıcı

    // TableView'ın veriyi okuyabilmesi için Getter metodu ŞARTTIR.
    public String getTahmin() {
        return tahmin;
    }//end getter


}//end class