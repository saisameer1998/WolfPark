package classes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Driver extends WolfPark {
    String driver_id;
    String name;
    String status;
    String disability;

    public Driver(String driver_id, String name, String status, String disability) {
        this.driver_id = driver_id;
        this.name = name;
        this.status= status;
        this.disability= disability;
    }

    public void enterDriverInfo() {
        try (Connection connection = DriverManager.getConnection("jdbc:your_database_url", "username", "password")) {
            String sql = "INSERT INTO drivers VALUES (?, ? ,? ,?)";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setString(1, driver_id);
                preparedStatement.setString(2, name);
                preparedStatement.setString(3, status);
                preparedStatement.setString(4, disability);
                preparedStatement.executeUpdate();
            } finally {
                close(connection);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateDriverInfo(String name) {
        try (Connection connection = DriverManager.getConnection("jdbc:your_database_url", "username", "password")) {
            String sql = "UPDATE drivers SET name = ? WHERE driver_id = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setString(1, name);
                preparedStatement.setString(2, driver_id);
                preparedStatement.executeUpdate();
            } finally {
                close(connection);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteDriverInfo() {
        try (Connection connection = DriverManager.getConnection("jdbc:your_database_url", "username", "password")) {
            String sql = "DELETE FROM drivers WHERE driver_id = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setString(1, driver_id);
                preparedStatement.executeUpdate();
            } finally {
                close(connection);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    static void close(Connection conn) {
        if (conn != null) {
            try {
                conn.close();
            } catch (Throwable whatever) {
            }
        }
    }
}
