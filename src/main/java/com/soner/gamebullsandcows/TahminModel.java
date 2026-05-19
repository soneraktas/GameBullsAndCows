package com.soner.gamebullsandcows;

public class TahminModel {

    private final String tahmin;
    private final int sira; // Yeni alan

    public TahminModel(int sira, String tahmin) {
        this.sira = sira;
        this.tahmin = tahmin;

    }//end yapılandırıcı

    // Sıra numarasını TableView'a beslemek için Getter
    public int getSira() {
        return sira;
    }

    // TableView'ın veriyi okuyabilmesi için Getter metodu ŞARTTIR.
    public String getTahmin() {
        return tahmin;
    }//end getter


}//end class