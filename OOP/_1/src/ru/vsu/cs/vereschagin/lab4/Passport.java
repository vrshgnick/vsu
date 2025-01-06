package ru.vsu.cs.vereschagin.lab4;

import java.time.LocalDate;
import java.util.Objects;

public class Passport {
    private final String passportNumber;
    private final String surname;
    private final String name;
    private final String patronymic;
    private final LocalDate dateOfBirth;
    private final String placeOfBirth;
    private final LocalDate issueDate;
    private final LocalDate expirationDate;
    private final String issuingAuthority;

    public Passport(String passportNumber, String surname, String name, String patronymic,
                    LocalDate dateOfBirth, String placeOfBirth, LocalDate issueDate,
                    LocalDate expirationDate, String issuingAuthority) {
        this.passportNumber = passportNumber;
        this.surname = surname;
        this.name = name;
        this.patronymic = patronymic;
        this.dateOfBirth = dateOfBirth;
        this.placeOfBirth = placeOfBirth;
        this.issueDate = issueDate;
        this.expirationDate = expirationDate;
        this.issuingAuthority = issuingAuthority;
    }

    public String getPassportNumber() {
        return passportNumber;
    }

    public String getSurname() {
        return surname;
    }

    public String getName() {
        return name;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public String getPlaceOfBirth() {
        return placeOfBirth;
    }

    public LocalDate getIssueDate() {
        return issueDate;
    }

    public LocalDate getExpirationDate() {
        return expirationDate;
    }

    public String getIssuingAuthority() {
        return issuingAuthority;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Passport passport = (Passport) o;
        return Objects.equals(passportNumber, passport.passportNumber) &&
                Objects.equals(surname, passport.surname) &&
                Objects.equals(name, passport.name) &&
                Objects.equals(patronymic, passport.patronymic) &&
                Objects.equals(dateOfBirth, passport.dateOfBirth) &&
                Objects.equals(placeOfBirth, passport.placeOfBirth) &&
                Objects.equals(issueDate, passport.issueDate) &&
                Objects.equals(expirationDate, passport.expirationDate) &&
                Objects.equals(issuingAuthority, passport.issuingAuthority);
    }

    @Override
    public int hashCode() {
        return Objects.hash(passportNumber, surname, name, patronymic, dateOfBirth,
                placeOfBirth, issueDate, expirationDate, issuingAuthority);
    }

    @Override
    public String toString() {
        return "Passport{" +
                "passportNumber='" + passportNumber + '\'' +
                ", surname='" + surname + '\'' +
                ", name='" + name + '\'' +
                ", patronymic='" + patronymic + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", placeOfBirth='" + placeOfBirth + '\'' +
                ", issueDate=" + issueDate +
                ", expirationDate=" + expirationDate +
                ", issuingAuthority='" + issuingAuthority + '\'' +
                '}';
    }
}