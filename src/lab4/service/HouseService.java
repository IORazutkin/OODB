package lab4.service;

import lab4.entity.House;

import java.util.List;

public class HouseService {
    public static House findHouseByAddress(List<House> houseList, String address) {
        return houseList.stream()
                .filter(house -> house.getAddress().equals(address))
                .findFirst().orElse(null);
    }
}