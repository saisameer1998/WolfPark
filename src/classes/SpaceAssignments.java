package classes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SpaceAssignments extends WolfPark {

    static String jdbcURL = "jdbc:mariadb://classdb2.csc.ncsu.edu:3306/sguttha";
    static String user = "sguttha";
    static String pswd = "Maria@MegaMind1";

    public static void assignSpace(int spaceNumber, String zoneId, String lotName, String availabilityStatus) throws SQLException {
        Connection connection = connectToDatabase(jdbcURL, user, pswd);
        try {
            String sql = "INSERT INTO space_assignments(space_number, zone_id, lot_name, availability_status) VALUES (?, ?, ?, ?)";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setString(1, spaceNumber);
                preparedStatement.setString(2, zoneId);
                preparedStatement.setString(1, lotName);
                preparedStatement.setString(2, availabilityStatus);
                preparedStatement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(connection);
        }
    }

    public static void deleteSpaceAssignment(int spaceNumber, String zoneId, String lotName) throws SQLException {
        Connection connection = connectToDatabase(jdbcURL, user, pswd);
        try {
            String sql = "DELETE FROM space_assignments WHERE space_number = ? AND zone_id = ? AND lot_name = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, spaceNumber);
            preparedStatement.setString(2, zoneId);
            preparedStatement.setString(3, lotName);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(connection);
        }
    }

    public static void getSpaceTypeAvailabilityInLot(String spaceType, String lotName) throws SQLException {
        Connection connection = connectToDatabase(jdbcURL, user, pswd);
        try {
            String sql = "SELECT count(*) as 'space_availability_number' FROM space_assignments WHERE lot_name = ? AND" +
                          " availability_status = 'YES' AND space_number in (SELECT space_number FROM spaces WHERE space_type = ?);
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, lotName);
            preparedStatement.setString(2, spaceType);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (result.next()) {
                String spaceAvailabilityNumber = result.getString("space_availability_number");

                System.out.println("Number of Spaces Available: " + spaceAvailabilityNumber);
                System.out.println("--------------------------");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(connection);
        }
    }

    public static void getSpaceAssignments() throws SQLException {
        Connection connection = connectToDatabase(jdbcURL, user, pswd);
        try {
            String sql = "SELECT * FROM space_assignments";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (result.next()) {
                String spaceNumber = result.getString("space_number");
                String zoneID = result.getString("zone_id");
                String lotName = result.getString("lot_name");
                String availabilityStatus = result.getString("availability_status");

                System.out.println("Space Number " + spaceNumber);
                System.out.println("Zone ID: " + zoneId);
                System.out.println("Lot Name: " + lotName);
                System.out.println("Availability Status: " + availabilityStatus);
                System.out.println("--------------------------");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(connection);
        }
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
