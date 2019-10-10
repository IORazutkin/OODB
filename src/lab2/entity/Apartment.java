package lab2.entity;

public class Apartment {
    long id;
    House house;
    int number;

    public Apartment(long id, House house, int number) {
        this.id = id;
        this.house = house;
        this.number = number;
    }

    public House getHouse() {
        return house;
    }

    public int getNumber() {
        return number;
    }
}