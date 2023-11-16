package classes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Driver extends WolfPark {
    String driverName;
    String licenseNumber;

    public Driver(String driverName, String licenseNumber) {
        this.driverName = driverName;
        this.licenseNumber = licenseNumber;
    }

    public void enterDriverInfo() {
        try (Connection connection = DriverManager.getConnection("jdbc:your_database_url", "username", "password")) {
            String sql = "INSERT INTO drivers VALUES (?, ?)";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setString(1, driverName);
                preparedStatement.setString(2, licenseNumber);
                preparedStatement.executeUpdate();
            } finally {
                close(connection);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateDriverInfo(String newLicenseNumber) {
        try (Connection connection = DriverManager.getConnection("jdbc:your_database_url", "username", "password")) {
            String sql = "UPDATE drivers SET license_number = ? WHERE driver_name = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setString(1, newLicenseNumber);
                preparedStatement.setString(2, driverName);
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
            String sql = "DELETE FROM drivers WHERE driver_name = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setString(1, driverName);
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
