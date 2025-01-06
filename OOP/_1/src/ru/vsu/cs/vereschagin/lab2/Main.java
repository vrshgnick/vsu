package ru.vsu.cs.vereschagin.lab2;

public class Main {
    public static void main(String[] args) {

        Place vrn = new Place("Воронеж", 10, 10, "город");
        Place park = new Place("Динамо", 3, 10, "природа");

        vrn.compareRatingWithOtherPlace(park);
        vrn.canAccommodate(100);
        park.increaseRating();
        vrn.increaseRating();
        System.out.println(vrn.toString());

        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~");

        Person person = new Person("Мария", "Петрова", 30, "Путешествия");

        person.showPersonInfo();
        person.setHobby("Рисование");
        person.showPersonInfo();

        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~");

        personInPlace personInVrn = new personInPlace(person, vrn);

        personInVrn.showPersonInPlaceInfo();

        personInVrn.movePersonToNewPlace(park);

        personInVrn.showPersonInPlaceInfo();

        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~");

        CulturalPlace museum = new CulturalPlace("Лувр", 9, 500, "музей", "Всемирное наследие", true);

        museum.increaseRating();
        museum.checkCulturalSignificance();
        System.out.println(museum.toString());

        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~");

        ParkPlace parkPlace = new ParkPlace("Центральный парк", 8, 200, "парк", true, true, 50.5);

        parkPlace.increaseRating();
        parkPlace.checkNatureFeatures();
        System.out.println(parkPlace.toString());
    }
}
