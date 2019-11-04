package lab4;

import com.google.gson.Gson;
import lab4.entity.House;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class SaveDB {
    public static void saveHouse(Connection connection, House house) throws SQLException {
        if (house != null) {
            Gson gson = new Gson();
            String houseAsJson = gson.toJson(house);

            PreparedStatement statement = connection.prepareStatement("insert into lab4Houses (content, contentb) values ( cast(? as json), cast (? as jsonb))");
            statement.setString(1, houseAsJson);
            statement.setString(2, houseAsJson);

            int count = statement.executeUpdate();

            statement.close();
        }
    }
}