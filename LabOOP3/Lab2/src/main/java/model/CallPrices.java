package org.example.model;
public class CallPrices {
    private double insideNetwork;
    private double outsideNetwork;
    private double landline;

    public CallPrices(double insideNetwork, double outsideNetwork, double landline) {
        this.insideNetwork = insideNetwork;
        this.outsideNetwork = outsideNetwork;
        this.landline = landline;
    }

    public double getInsideNetwork() {
        return insideNetwork;
    }

    public void setInsideNetwork(double insideNetwork) {
        this.insideNetwork = insideNetwork;
    }

    public double getOutsideNetwork() {
        return outsideNetwork;
    }

    public void setOutsideNetwork(double outsideNetwork) {
        this.outsideNetwork = outsideNetwork;
    }

    public double getLandline() {
        return landline;
    }

    public void setLandline(double landline) {
        this.landline = landline;
    }
}
