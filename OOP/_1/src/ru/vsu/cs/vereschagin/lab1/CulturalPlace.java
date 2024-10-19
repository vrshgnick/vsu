package ru.vsu.cs.vereschagin.lab1;

public class CulturalPlace extends Place {

    private String culturalImportance;
    private boolean hasMuseum;

    public CulturalPlace(String placeName, int rating, int capacity, String type, String culturalImportance, boolean hasMuseum) {
        super(placeName, rating, capacity, type);
        this.culturalImportance = culturalImportance;
        this.hasMuseum = hasMuseum;
    }

    public String getCulturalImportance() {
        return culturalImportance;
    }

    public void setCulturalImportance(String culturalImportance) {
        this.culturalImportance = culturalImportance;
    }

    public boolean isHasMuseum() {
        return hasMuseum;
    }

    public void setHasMuseum(boolean hasMuseum) {
        this.hasMuseum = hasMuseum;
    }

    @Override
    public String toString() {
        String museumInfo = hasMuseum ? "имеет музей" : "не имеет музей";
        return super.toString() + "; Культурная важность: " + culturalImportance + "; " + museumInfo;
    }

    public void checkCulturalSignificance() {
        if (culturalImportance != null && !culturalImportance.isEmpty()) {
            System.out.println("Место " + getPlaceName() + " известно своей культурной важностью: " + culturalImportance);
        } else {
            System.out.println("Место " + getPlaceName() + " не известно как культурная достопримечательность.");
        }
    }
}
