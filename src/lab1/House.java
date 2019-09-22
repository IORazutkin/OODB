package lab1;

import java.util.List;

public class House {
    long id;
    String address;
    List<Apartment> apartments;

    void printInfo() {
        System.out.println("Address: " + address
                + "\nApartments:");
        apartments.stream().forEach(apartment -> {
            System.out.println(apartment.number);
            apartment.printPeoples();
        });
        System.out.println();
    }
}