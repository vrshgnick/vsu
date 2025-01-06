package ru.vsu.cs.vereschagin.lab2;

public class Place {

    public String getPlaceName() {
        return placeName;
    }

    public void setPlaceName(String placeName) {
        this.placeName = placeName;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Place(String placeName, int rating, int capacity, String type) {
        this.placeName = placeName;
        this.rating = rating;
        this.capacity = capacity;
        this.type = type;
    }

    private String placeName;
    private int rating;
    private int capacity;
    private String type;



    public void increaseRating() {
        if (rating < 10) {
            this.rating++;
            System.out.println("Рейтинг " + placeName  +  " увеличен на 1. Текущий рейтинг: " + this.rating);
        } else {
            System.out.println("Рейтинг " + placeName  + " уже максимальный - 10.");
        }
    }

    public boolean canAccommodate(int people) {
        boolean canAccommodate = people <= this.capacity;
        if (canAccommodate) {
            System.out.println("Место " + this.getPlaceName() + " может вместить " + people + " человек.");
        } else {
            System.out.println("Место " + this.getPlaceName() + " не может вместить " + people + " человек.");
        }
        return canAccommodate;
    }


    @Override
    public String toString() {
        return "Место: " + placeName + "; Рейтинг: " + rating + "; Вместимость: " + capacity;
    }

    public void compareRatingWithOtherPlace(Place otherPlace) {
        if (this.rating > otherPlace.getRating()) {
            System.out.println("Место " + this.getPlaceName() + " имеет более высокий рейтинг, чем " + otherPlace.getPlaceName());
        } else if (this.rating < otherPlace.getRating()) {
            System.out.println("Место " + otherPlace.getPlaceName() + " имеет более высокий рейтинг, чем " + this.getPlaceName());
        } else {
            System.out.println("Места " + this.getPlaceName() + " и " + otherPlace.getPlaceName() + " имеют одинаковый рейтинг.");
        }
    }


}
