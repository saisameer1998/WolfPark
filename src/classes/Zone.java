package classes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Zone extends WolfPark{
	
	String zoneId;

    public Zone(String zoneId) {
        this.zoneId = zoneId;
    }
    
    
    public void enterZoneInfo() {
        try (Connection connection = DriverManager.getConnection("jdbc:your_database_url", "username", "password")) {
            String sql = "INSERT INTO zone_assignments  VALUES (?)";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setString(1, zoneId);
                preparedStatement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    
    public void updateZoneInfo(String newZoneId) {
        try (Connection connection = DriverManager.getConnection("jdbc:your_database_url", "username", "password")) {
            String sql = "UPDATE zones SET zone_id = ? WHERE zone_id = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setString(1, newZoneId);
                preparedStatement.setString(2, zoneId);
                preparedStatement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    
    public void deleteZoneInfo() {
        try (Connection connection = DriverManager.getConnection("jdbc:your_database_url", "username", "password")) {
            String sql = "DELETE FROM zones WHERE zone_id = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setString(1, zoneId);
                preparedStatement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public String getZoneInfo() {
        String zoneInfo = null;
        try (Connection connection = DriverManager.getConnection("jdbc:your_database_url", "username", "password")) {
            String sql = "SELECT * FROM zones WHERE zone_id = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setString(1, zoneId);
                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    if (resultSet.next()) {
                        zoneInfo = resultSet.getString("zone_id");
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return zoneInfo;
    }

}
