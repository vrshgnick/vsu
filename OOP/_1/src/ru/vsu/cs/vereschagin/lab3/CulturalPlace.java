package ru.vsu.cs.vereschagin.lab3;

import ru.vsu.cs.vereschagin.lab3.Place;

public class CulturalPlace extends Place {

    private String culturalImportance;
    private boolean hasMuseum;
    public static final int PRICE = 100;

    static {
        System.out.println("Инициализация класса CulturalPlace. Статический блок");
    }

    {
        System.out.println("Нестатический блок CulturalPlace");
    }

    public CulturalPlace(String placeName, int rating, int capacity, String type, String culturalImportance, boolean hasMuseum) {
        super(placeName, rating, capacity, type);
        this.culturalImportance = culturalImportance;
        this.hasMuseum = hasMuseum;
        System.out.println("Создается объект класса CulturalPlace: " + placeName + "\n");
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
    public void payForTicket() {
        System.out.println("Покупка билета для посещения культурного места " + getPlaceName() + ". Цена билета: " + PRICE + " рублей.");
    }

    public void checkCulturalSignificance() {
        if (culturalImportance != null && !culturalImportance.isEmpty()) {
            System.out.println("Место " + getPlaceName() + " известно своей культурной важностью: " + culturalImportance);
        } else {
            System.out.println("Место " + getPlaceName() + " не известно как культурная достопримечательность.");
        }
    }


}
