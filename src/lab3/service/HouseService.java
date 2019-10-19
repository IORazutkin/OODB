package lab3.service;

import lab3.entity.House;

import java.util.List;

public class HouseService {
    public static House findHouseByAddress(List<House> houseList, String address) {
        return houseList.stream()
                .filter(x -> x.getAddress().equals(address))
                .findFirst().orElse(null);
    }
}