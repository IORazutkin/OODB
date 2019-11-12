package lab5;

import lab5.entity.Apartment;
import lab5.entity.House;
import lab5.entity.Person;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public final class Queries {
    private final static String SELECT_ALL_PERSONS = "select (person).person_id, (person).full_name, (person).birth_day," +
            "(person).person_apartment.apartment_id, (person).person_apartment.apartment_number," +
            "(person).person_apartment.apartment_house.house_id, (person).person_apartment.apartment_house.address" +
            " from lab5person";
    private final static String INSERT_PERSON      = "insert into lab5person ((person).person_id, (person).birth_day," +
            "(person).full_name, (person).person_apartment.apartment_id, (person).person_apartment.apartment_number," +
            "(person).person_apartment.apartment_house.house_id, (person).person_apartment.apartment_house.address)" +
            " values (?, ?, ?, ?, ?, ?, ?)";
    private final static String UPDATE_PERSON      = "update lab5person set person.full_name = ?," +
            "person.person_apartment.apartment_number = ?, person.person_apartment.apartment_house.address = ?" +
            " where (person).person_id = ?";

    public static List<Person> selectAllPersons(Connection connection) throws SQLException {
        List<Person> personList = new ArrayList<>();

        PreparedStatement statement = connection.prepareStatement(SELECT_ALL_PERSONS);
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()) {
            long id = resultSet.getLong("person_id");
            String fullName = resultSet.getString("full_name");
            Date birthDay = resultSet.getDate("birth_day");
            long apartmentId = resultSet.getLong("apartment_id");
            int apartmentNumber = resultSet.getInt("apartment_number");
            long houseId = resultSet.getLong("house_id");
            String address = resultSet.getString("address");

            Person person = new Person(id, fullName, birthDay,
                    new Apartment(apartmentId, new House(houseId, address), apartmentNumber));
            personList.add(person);
        }
        statement.close();

        return personList;
    }

    public static void insertPerson(Connection connection, Person person) throws SQLException {
        PreparedStatement statement = connection.prepareStatement(INSERT_PERSON);
        statement.setLong(1, person.getPerson_id());
        statement.setDate(2, person.getBirth_day());
        statement.setString(3, person.getFull_name());
        statement.setLong(4, person.getPerson_apartment().getApartment_id());
        statement.setInt(5, person.getPerson_apartment().getApartment_number());
        statement.setLong(6, person.getPerson_apartment().getApartment_house().getHouse_id());
        statement.setString(7, person.getPerson_apartment().getApartment_house().getAddress());
        statement.executeUpdate();
        statement.close();
    }

    public static void updatePerson(Connection connection, Person person) throws SQLException {
        PreparedStatement statement = connection.prepareStatement(UPDATE_PERSON);
        statement.setString(1, person.getFull_name());
        statement.setInt(2, person.getPerson_apartment().getApartment_number());
        statement.setString(3, person.getPerson_apartment().getApartment_house().getAddress());
        statement.setObject(4, person.getPerson_id());
        statement.executeUpdate();
        statement.close();
    }
}