package lab7;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public final class ScanDB {
    private static Connection connection;
    private static final String DB_URL = "jdbc:postgresql://localhost:5432/OODB";
    private static final String DB_USER = "postgres";
    private static final String DB_PASSWORD = "12345";

    private static final String DB_GET_TABLES =
            "SELECT table_name FROM information_schema.tables " +
                    "WHERE table_type = 'BASE TABLE' AND" +
                    " table_schema NOT IN ('pg_catalog', 'information_schema')";
    private static final String DB_GET_TABLE_FIELDS =
            "SELECT a.attname FROM pg_catalog.pg_attribute a " +
                    "WHERE a.attrelid = (SELECT c.oid FROM pg_catalog.pg_class c " +
                    "LEFT JOIN pg_catalog.pg_namespace n ON n.oid = c.relnamespace " +
                    " WHERE pg_catalog.pg_table_is_visible(c.oid) AND c.relname = ? )" +
                    " AND a.attnum > 0 AND NOT a.attisdropped";

    public static HashMap<String, HashSet<String>> getDBStructure() {
        HashMap<String, HashSet<String>> tables = new HashMap<>();

        try (Connection connection = getConnection()) {
            List<String> tbls = getTables(connection);

            for (String table : tbls) {
                List<String> fields = getFields(connection, table);

                tables.put(table, new HashSet<>(fields));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return tables;
    }

    private static Connection getConnection() throws SQLException {
        if (connection != null && !connection.isClosed()) {
            return connection;
        }

        connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
        return connection;
    }

    private static List<String> getTables(Connection connection) throws SQLException {
        List<String> list = new ArrayList<>();

        PreparedStatement st = connection.prepareStatement(DB_GET_TABLES);

        ResultSet resultSet = st.executeQuery();

        while (resultSet.next()) {
            list.add(resultSet.getString("table_name"));
        }

        st.close();
        return list;
    }

    private static List<String> getFields(Connection connection, String tableName) throws SQLException {

        List<String> list = new ArrayList<>();

        PreparedStatement st = connection.prepareStatement(DB_GET_TABLE_FIELDS);

        st.setString(1, tableName);
        ResultSet resultSet = st.executeQuery();

        while (resultSet.next()) {;
            list.add(resultSet.getString("attname"));
        }

        st.close();
        return list;
    }
}
