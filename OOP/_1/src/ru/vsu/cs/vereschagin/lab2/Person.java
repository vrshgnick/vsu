package ru.vsu.cs.vereschagin.lab2;

public class Person {

    private String personName;
    private String personSurname;
    private int personAge;
    private String hobby;

    public String getPersonName() {
        return personName;
    }

    public void setPersonName(String personName) {
        this.personName = personName;
        System.out.println("Имя изменено на: " + personName);
    }

    public String getPersonSurname() {
        return personSurname;
    }

    public void setPersonSurname(String personSurname) {
        this.personSurname = personSurname;
        System.out.println("Фамилия изменена на: " + personSurname);
    }

    public int getPersonAge() {
        return personAge;
    }

    public void setPersonAge(int personAge) {
        this.personAge = personAge;
        System.out.println("Возраст изменён на: " + personAge + " лет.");
    }

    public String getHobby() {
        return hobby;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
        System.out.println("Хобби изменено на: " + hobby);
    }

    public Person(String personName, String personSurname, int personAge, String hobby) {
        this.personName = personName;
        this.personSurname = personSurname;
        this.personAge = personAge;
        this.hobby = hobby;
    }

    public void showPersonInfo() {
        System.out.println("Информация о человеке:");
        System.out.println("Имя: " + getPersonName());
        System.out.println("Фамилия: " + getPersonSurname());
        System.out.println("Возраст: " + getPersonAge());
        System.out.println("Хобби: " + getHobby());
    }

    public void increaseAge() {
        this.personAge++;
        System.out.println("Возраст увеличен. Текущий возраст: " + this.personAge + " лет.");
    }
}
