package com.soner.gamebullsandcows;

public class TahminModel {
    private final int sira;
    private final String tahmin;
    private final int bulls;
    private final int cows;

    public TahminModel(int sira, String tahmin, int bulls, int cows) {
        this.sira = sira;
        this.tahmin = tahmin;
        this.bulls = bulls;
        this.cows = cows;
    }

    // JavaFX TableView bu metodları (get...) kullanarak veriyi ekrana yansıtır
    public int getSira() { return sira; }
    public String getTahmin() { return tahmin; }
    public int getBulls() { return bulls; }
    public int getCows() { return cows; }
}