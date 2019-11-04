package lab4;

import lab4.entity.House;
import lab4.service.HouseService;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class Main {
    private final static String DATABASE_URL      = "jdbc:postgresql://localhost:5432/postgres";
    private final static String DATABASE_USERNAME = "postgres";
    private final static String DATABASE_PASSWORD = "12345";

    public static void main(String[] args) throws SQLException {
        Connection connection = DriverManager.getConnection(DATABASE_URL, DATABASE_USERNAME, DATABASE_PASSWORD);
        List<House> houseList = LoadDB.loadHouseList(connection);
        houseList.stream().forEach(house -> System.out.println(house.getAddress()));

        Scanner scanner = new Scanner(System.in);
        String address = scanner.nextLine();

        House house = HouseService.findHouseByAddress(houseList, address);
        if (house == null) {
            house = new House(houseList.size(), address);
            SaveDB.saveHouse(connection, house);
        } else {
            System.out.println("Данный дом уже существует");
        }
    }
}