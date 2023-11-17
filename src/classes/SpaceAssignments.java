/**
 * The SpaceAssignments class manages space assignments in a parking lot system.
 * It extends the WolfPark class to inherit any common functionality.
 * The class provides methods to assign, delete, and retrieve parking space assignments.
 */

package classes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SpaceAssignments extends WolfPark {

    // Database connection details
    static String jdbcURL = "jdbc:mariadb://classdb2.csc.ncsu.edu:3306/sguttha";
    static String user = "sguttha";
    static String pswd = "Maria@MegaMind1";

    public static void assignSpace(int spaceNumber, String zoneId, String lotName, String availabilityStatus)
            throws SQLException {
        /**
         * Assigns a parking space with the specified details to the database.
         *
         * @param spaceNumber         The number of the parking space to be assigned.
         * @param zoneId              The zone ID of the parking space.
         * @param lotName             The name of the parking lot.
         * @param availabilityStatus The availability status of the parking space.
         * @throws SQLException If a database access error occurs.
         */

        Connection connection = connectToDatabase(jdbcURL, user, pswd);
        try {
            String sql = "INSERT INTO space_assignments(space_number, zone_id, lot_name, availability_status) VALUES (?, ?, ?, ?)";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setInt(1, spaceNumber);
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
        /**
         * Deletes a parking space assignment with the specified details from the database.
         *
         * @param spaceNumber The number of the parking space to be deleted.
         * @param zoneId      The zone ID of the parking space.
         * @param lotName     The name of the parking lot.
         * @throws SQLException If a database access error occurs.
         */

        Connection connection = connectToDatabase(jdbcURL, user, pswd);
        try {
            String sql = "DELETE FROM space_assignments WHERE space_number = ? AND zone_id = ? AND lot_name = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, spaceNumber);
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
        /**
         * Retrieves and displays the number of available parking spaces of a specific type in a given lot.
         *
         * @param spaceType The type of parking space to check availability for.
         * @param lotName   The name of the parking lot.
         * @throws SQLException If a database access error occurs.
         */

        Connection connection = connectToDatabase(jdbcURL, user, pswd);
        try {
            String sql = "SELECT count(*) as 'space_availability_number' FROM space_assignments WHERE lot_name = ? AND"
                    +
                    " availability_status = 'YES' AND space_number in (SELECT space_number FROM spaces WHERE space_type = ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, lotName);
            preparedStatement.setString(2, spaceType);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String spaceAvailabilityNumber = resultSet.getString("space_availability_number");

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
        /**
         * Retrieves and displays all parking space assignments from the database.
         *
         * @throws SQLException If a database access error occurs.
         */

        Connection connection = connectToDatabase(jdbcURL, user, pswd);
        try {
            String sql = "SELECT * FROM space_assignments";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String spaceNumber = resultSet.getString("space_number");
                String zoneID = resultSet.getString("zone_id");
                String lotName = resultSet.getString("lot_name");
                String availabilityStatus = resultSet.getString("availability_status");

                System.out.println("Space Number " + spaceNumber);
                System.out.println("Zone ID: " + zoneID);
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
        /**
         * Establishes a connection to the MariaDB database.
         *
         * @param jdbcURL The JDBC URL of the database.
         * @param user    The database username.
         * @param pswd    The database password.
         * @return A Connection object representing the database connection.
         * @throws SQLException If a database access error occurs.
         */

        Connection connection = null;
        try {
            connection = DriverManager.getConnection(jdbcURL, user, pswd);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return connection;
    }

    private static void close(Connection conn) {
        /**
         * Closes the provided database connection.
         *
         * @param conn The database connection to be closed.
         */

        if (conn != null) {
            try {
                conn.close();
                System.out.println("Connnection closed");
            } catch (Throwable whatever) {
            }
        }

    }

}
