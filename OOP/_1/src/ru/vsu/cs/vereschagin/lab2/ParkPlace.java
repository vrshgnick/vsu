package ru.vsu.cs.vereschagin.lab2;

public class ParkPlace extends Place {

    private boolean hasForest;
    private boolean hasLake;
    private double parkArea;

    public ParkPlace(String placeName, int rating, int capacity, String type, boolean hasForest, boolean hasLake, double parkArea) {
        super(placeName, rating, capacity, type);
        this.hasForest = hasForest;
        this.hasLake = hasLake;
        this.parkArea = parkArea;
    }

    public boolean isHasForest() {
        return hasForest;
    }

    public void setHasForest(boolean hasForest) {
        this.hasForest = hasForest;
    }

    public boolean isHasLake() {
        return hasLake;
    }

    public void setHasLake(boolean hasLake) {
        this.hasLake = hasLake;
    }

    public double getParkArea() {
        return parkArea;
    }

    public void setParkArea(double parkArea) {
        this.parkArea = parkArea;
    }

    @Override
    public String toString() {
        String forestInfo = hasForest ? "есть лес" : "нет леса";
        String lakeInfo = hasLake ? "есть озеро" : "нет озера";
        return super.toString() + "; Площадь парка: " + parkArea + " гектар; " + forestInfo + "; " + lakeInfo;
    }

    public void checkNatureFeatures() {
        if (hasForest && hasLake) {
            System.out.println("Место " + getPlaceName() + " имеет как лес, так и озеро.");
        } else if (hasForest) {
            System.out.println("Место " + getPlaceName() + " имеет лес, но не имеет озера.");
        } else if (hasLake) {
            System.out.println("Место " + getPlaceName() + " имеет озеро, но не имеет леса.");
        } else {
            System.out.println("Место " + getPlaceName() + " не имеет ни леса, ни озера.");
        }
    }
}
