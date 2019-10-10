package lab2;

import lab1.Apartment;

import java.util.List;

public class ApartmentService {
    public static Apartment findApartmentByHouse_AddressAndNumber(List<Apartment> apartmentList, String address, int number) {
        return apartmentList.stream()
                .filter(x -> x.getHouse().getAddress().equals(address))
                .filter(x -> x.getNumber() == number)
                .findFirst().orElse(null);

    }
}
