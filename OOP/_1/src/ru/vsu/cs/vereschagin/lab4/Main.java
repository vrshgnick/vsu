package ru.vsu.cs.vereschagin.lab4;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class Main {
    public static void main(String[] args) {
        LocalDate firstPassportIssueDate = LocalDate.of(2020, 5, 10);
        LocalDate firstPassportExpirationDate = LocalDate.of(2030, 5, 10);
        LocalDate secondPassportIssueDate = LocalDate.of(2021, 7, 15);
        LocalDate secondPassportExpirationDate = LocalDate.of(2031, 7, 15);

        Passport firstPassport = new Passport("123456789", "Иванов", "Иван", "Иванович",
                LocalDate.of(1990, 1, 1), "Москва", firstPassportIssueDate, firstPassportExpirationDate, "ГУ МВД России");
        Passport copyFirstPassport = new Passport("123456789", "Иванов", "Иван", "Иванович",
                LocalDate.of(1990, 1, 1), "Москва", firstPassportIssueDate, firstPassportExpirationDate, "ГУ МВД России");
        Passport secondPassport = new Passport("987654321", "Петров", "Петр", "Петрович",
                LocalDate.of(1995, 2, 2), "Санкт-Петербург", secondPassportIssueDate, secondPassportExpirationDate, "ГУ МВД России");

        System.out.println("Сравниваем паспорт один и его копию: " + firstPassport.equals(copyFirstPassport));
        System.out.println("Сравниваем паспорт один и второй паспорт: " + firstPassport.equals(secondPassport));
        System.out.println("Хешкод первого паспорта: " + firstPassport.hashCode());
        System.out.println("Хешкод копии паспорта: " + copyFirstPassport.hashCode());

        ArrayList<Passport> passportList = new ArrayList<>();
        passportList.add(firstPassport);
        System.out.println("Содержит ли список копию первого паспорта? - " + passportList.contains(copyFirstPassport));
        System.out.println("Какой порядковый номер имеет копия? - " + passportList.indexOf(copyFirstPassport));
        System.out.println("Попытка удалить копию - " + passportList.remove(copyFirstPassport));
        System.out.println("Текущий размер массива - " + passportList.size());

        HashSet<Passport> passportHashSet = new HashSet<>();
        passportHashSet.add(firstPassport);
        System.out.println("В хеш-таблицу добавлен первый паспорт " + firstPassport.getName() + " " + firstPassport.getSurname());
        passportHashSet.add(copyFirstPassport);
        System.out.println("В хеш-таблицу добавлен второй паспорт-копия " + copyFirstPassport.getName() + " " + copyFirstPassport.getSurname());
        System.out.println("Текущий размер коллекции - " + passportHashSet.size());

        HashMap<Passport, String> addressMap = new HashMap<>();
        System.out.println("Добавим в HashMap первый паспорт");
        addressMap.put(firstPassport, "Москва, Красная площадь, 1");
        System.out.println("Попробуем получить адрес - " + addressMap.get(firstPassport));
        System.out.println("Попробуем получить адрес по старым значениям - " + addressMap.get(copyFirstPassport));
    }
}
