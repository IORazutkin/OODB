package lab4;

import com.google.gson.Gson;
import lab4.entity.House;

import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LoadDB {
    public static List<House> loadHouseList(Connection connection) throws SQLException {
        PreparedStatement statement = connection.prepareStatement("select content from lab4Houses");
        ResultSet resultSet = statement.executeQuery();

        List<String> pStr = new ArrayList<>();
        long start = System.nanoTime();
        while (resultSet.next()) {
            pStr.add(resultSet.getString("content"));
        }
        System.out.println(System.nanoTime() - start);

        statement.close();

        Gson gson = new Gson();
        House[] houses = gson.fromJson(Arrays.toString(pStr.toArray()), House[].class);

        statement = connection.prepareStatement("select contentb from lab4Houses");
        resultSet = statement.executeQuery();

        pStr = new ArrayList<>();
        start = System.nanoTime();
        while (resultSet.next()) {
            pStr.add(resultSet.getString("contentb"));
        }
        System.out.println(System.nanoTime() - start);

        statement.close();

        if (houses != null && houses.length > 0)
            return Arrays.asList(houses);
        return new ArrayList<>();
    }
}