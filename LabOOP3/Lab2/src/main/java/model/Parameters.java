package org.example.model;
public class Parameters {
    private int favoriteNumbers;
    private String tariffication;
    private double connectionFee;

    public Parameters(int favoriteNumbers, String tariffication, double connectionFee) {
        this.favoriteNumbers = favoriteNumbers;
        this.tariffication = tariffication;
        this.connectionFee = connectionFee;
    }

    public int getFavoriteNumbers() {
        return favoriteNumbers;
    }

    public void setFavoriteNumbers(int favoriteNumbers) {
        this.favoriteNumbers = favoriteNumbers;
    }

    public String getTariffication() {
        return tariffication;
    }

    public void setTariffication(String tariffication) {
        this.tariffication = tariffication;
    }

    public double getConnectionFee() {
        return connectionFee;
    }

    public void setConnectionFee(double connectionFee) {
        this.connectionFee = connectionFee;
    }
}