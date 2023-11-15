package classes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Space extends WolfPark{
	
	int spaceNumber;
    String spaceType;

    public Space(int spaceNumber, String spaceType) {
        this.spaceNumber = spaceNumber;
        this.spaceType = spaceType;
    }

    
    public void enterSpaceInfo() {
        try (Connection connection = DriverManager.getConnection("jdbc:your_database_url", "username", "password")) {
            String sql = "INSERT INTO spaces VALUES (?, ?)";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setInt(1, spaceNumber);
                preparedStatement.setString(2, spaceType);
                preparedStatement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    
    public void updateSpaceInfo(String newSpaceType) {
        try (Connection connection = DriverManager.getConnection("jdbc:your_database_url", "username", "password")) {
            String sql = "UPDATE spaces SET space_type = ? WHERE space_number = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setString(1, newSpaceType);
                preparedStatement.setInt(2, spaceNumber);
                preparedStatement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    
    public void deleteSpaceInfo() {
        try (Connection connection = DriverManager.getConnection("jdbc:your_database_url", "username", "password")) {
            String sql = "DELETE FROM spaces WHERE space_number = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setInt(1, spaceNumber);
                preparedStatement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public int getAvailableSpace(String lotName) {
        int availableSpace = 0;
        try (Connection connection = DriverManager.getConnection("jdbc:your_database_url", "username", "password")) {
            String sql = "SELECT COUNT(*) FROM space_assignments sa, spaces s " +
                         "WHERE sa.space_number = s.space_number " +
                         "AND sa.lot_name = ? " +
                         "AND sa.space_number = ? " +
                         "AND sa.availability_status = 'Available'";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setString(1, lotName);
                preparedStatement.setInt(2, spaceNumber);
                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    if (resultSet.next()) {
                        availableSpace = resultSet.getInt(1);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return availableSpace;
    }
}
