package classes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Zone extends WolfPark {

    static String jdbcURL = "jdbc:mariadb://classdb2.csc.ncsu.edu:3306/sguttha";
    static String user = "sguttha";
    static String pswd = "Maria@MegaMind1";

    // String zoneId;

    // public Zone(String zoneId) {
    // this.zoneId = zoneId;
    // }

    public static void addZone(String zoneId) throws SQLException {
        Connection connection = connectToDatabase(jdbcURL, user, pswd);
        try {
            // Start the transaction
            connection.setAutoCommit(false);

            String sql = "INSERT INTO zone_assignments VALUES (?)";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setString(1, zoneId);
                preparedStatement.executeUpdate();
            }
            // Commit the transaction if everything is successful
            connection.commit();
        } catch (SQLException e) {
            // Rollback the transaction in case of an exception
            if (connection != null) {
                connection.rollback();
            }
            e.printStackTrace();
        } finally {
            try {
                // Set auto-commit back to true
                if (connection != null) {
                    connection.setAutoCommit(true);
                }
            } finally {
                // Close the connection
                if (connection != null) {
                    close(connection);
                }
            }
        }

    }

    public static void deleteZone(String zoneId) throws SQLException {
        Connection connection = connectToDatabase(jdbcURL, user, pswd);
        try {
            String sql = "DELETE FROM zones WHERE zone_id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, zoneId);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(connection);
        }
    }

    public static String getZoneInfo(String zoneId) throws SQLException {
        String zoneInfo = null;
        Connection connection = connectToDatabase(jdbcURL, user, pswd);
        try {
            String sql = "SELECT * FROM zones WHERE zone_id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, zoneId);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                zoneInfo = resultSet.getString("zone_id");
                System.out.println(zoneInfo);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(connection);
        }

        return zoneInfo;
    }

    private static Connection connectToDatabase(String jdbcURL, String user, String pswd)
            throws SQLException {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(jdbcURL, user, pswd);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return connection;
    }

    private static void close(Connection conn) {
        if (conn != null) {
            try {
                conn.close();
                System.out.println("Connnection closed");
            } catch (Throwable whatever) {
            }
        }

    }

}
