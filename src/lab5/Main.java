package lab5;

import lab5.entity.Apartment;
import lab5.entity.House;
import lab5.entity.Person;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class Main {
    private final static String DATABASE_URL      = "jdbc:postgresql://localhost:5432/OODB";
    private final static String DATABASE_USERNAME = "postgres";
    private final static String DATABASE_PASSWORD = "12345";

    public static void main(String[] args) throws SQLException {
        Connection connection = DriverManager.getConnection(DATABASE_URL, DATABASE_USERNAME, DATABASE_PASSWORD);

        List<Person> personList = Queries.selectAllPersons(connection);
        personList.stream().forEach(System.out::println);

        Scanner scanner = new Scanner(System.in);
        System.out.println("1) Add new person;");
        System.out.println("2) Update person;");
        int mode = scanner.nextInt();

        System.out.print("Person ID: ");          int id = scanner.nextInt();
                                                  scanner.nextLine();
        System.out.print("Full name: ");          String fullName = scanner.nextLine();
        System.out.print("Address: ");            String address = scanner.nextLine();
        System.out.print("Apartment number: ");   int apartmentNumber = scanner.nextInt();

        House house = new House(0, address);
        Apartment apartment = new Apartment(0, house, apartmentNumber);
        Person person = new Person(id, fullName, new Date(0), apartment);

        if (mode == 1)
            Queries.insertPerson(connection, person);
        else
            Queries.updatePerson(connection, person);

        connection.close();
    }
}