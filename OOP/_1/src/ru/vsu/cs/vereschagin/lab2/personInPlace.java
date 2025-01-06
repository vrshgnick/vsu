package ru.vsu.cs.vereschagin.lab2;

public class personInPlace {
    private Person person;
    private Place place;

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public Place getPlace() {
        return place;
    }

    public void setPlace(Place place) {
        this.place = place;
    }

    public personInPlace(Person person, Place place) {
        this.person = person;
        this.place = place;
    }

    public void movePersonToNewPlace(Place newPlace) {
        setPlace(newPlace);
        System.out.println(person.getPersonName() + " " + person.getPersonSurname() + " перемещён в место: " + newPlace.getPlaceName());
    }

    public void showPersonInPlaceInfo() {
        System.out.println(person.getPersonName() + " " + person.getPersonSurname() + " в возрасте " + person.getPersonAge() + " лет находится в месте: " + place.getPlaceName() + ".");
        System.out.println("Хобби: " + person.getHobby() + ". Место может вместить " + place.getCapacity() + " человек.");
    }
}
