package lab2.entity;

import java.util.Date;

public class People {
    long id;
    String fullName;
    Date birthDay;
    Apartment apartment;

    public People(long id, String fullName, Date birthDay, Apartment apartment) {
        this.id = id;
        this.fullName = fullName;
        this.birthDay = birthDay;
        this.apartment = apartment;
    }

    void printAddress() {
        System.out.println(apartment.house.address + " " + apartment.number);
    }
}