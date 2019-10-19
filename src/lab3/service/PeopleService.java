package lab3.service;


import lab3.entity.Apartment;
import lab3.entity.House;
import lab3.entity.People;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class PeopleService {
    public static People createPerson(int id, List<House> houseList, List<Apartment> apartmentList) {
        System.out.println("New Person Registration");
        Scanner scanner = new Scanner(System.in);
        System.out.print("Full Name: "); String fullName = scanner.nextLine();
        System.out.print("Address: "); String address = scanner.nextLine();
        System.out.print("Apartment number: "); int number = scanner.nextInt();

        House house = HouseService.findHouseByAddress(houseList, address);
        Apartment apartment;
        if (house != null) {
            apartment = ApartmentService.findApartmentByHouse_AddressAndNumber(apartmentList, address, number);
            if (apartment == null) {
                apartment = new Apartment(apartmentList.size(), house, number);
                apartmentList.add(apartment);
            }
        } else {
            house = new House(houseList.size(), address);
            houseList.add(house);
            apartment = new Apartment(apartmentList.size(), house, number);
            apartmentList.add(apartment);
        }
        return new People(id, fullName, new Date(), apartment);
    }
}
