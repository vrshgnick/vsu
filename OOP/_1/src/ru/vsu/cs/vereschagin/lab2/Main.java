package ru.vsu.cs.vereschagin.lab2;

import static ru.vsu.cs.vereschagin.lab2.Place.getTotalPlaces;

public class Main {
    public static void main(String[] args) {

            ParkPlace park = new ParkPlace("Динамо", 9, 30, "парк", true,true, 1100);


        CulturalPlace museum = new CulturalPlace("Лувр", 9, 500, "музей", "Всемирное наследие", true);
        museum.checkCulturalSignificance();

        museum.payForTicket();

        System.out.println("Статический метод для числа мест - " + getTotalPlaces());
    }

}