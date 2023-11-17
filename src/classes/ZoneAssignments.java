/**
 * The ZoneAssignments class manages the assignment of parking zones to specific lots in a parking system.
 * It extends the WolfPark class to inherit any common functionality.
 * The class provides methods to assign and delete parking zones from lots,
 * as well as retrieve information about zone assignments in various ways from a MariaDB database.
 */

package classes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ZoneAssignments extends WolfPark {

    // Database connection details
    static String jdbcURL = "jdbc:mariadb://classdb2.csc.ncsu.edu:3306/sguttha";
    static String user = "sguttha";
    static String pswd = "Maria@MegaMind1";

    public static void assignZone(String zoneId, String lotName) throws SQLException {
        /**
     * Assigns a parking zone to a specific lot in the database.
     *
     * @param zoneId The ID of the parking zone to be assigned.
     * @param lotName The name of the lot to which the zone is assigned.
     * @throws SQLException If a database access error occurs.
     */
        Connection connection = connectToDatabase(jdbcURL, user, pswd);
        try {
            String sql = "INSERT INTO zone_assignments(zone_id, lot_name) VALUES (?, ?)";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setString(1, zoneId);
                preparedStatement.setString(2, lotName);
                preparedStatement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(connection);
        }
    }

    public static void deleteZoneAssignment(String zoneId, String lotName) throws SQLException {
        /**
     * Deletes a parking zone assignment from a specific lot in the database.
     *
     * @param zoneId The ID of the parking zone to be unassigned.
     * @param lotName The name of the lot from which the zone is unassigned.
     * @throws SQLException If a database access error occurs.
     */
        Connection connection = connectToDatabase(jdbcURL, user, pswd);
        try {
            String sql = "DELETE FROM zone_assignments WHERE zone_id = ? AND lot_name = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, zoneId);
            preparedStatement.setString(2, lotName);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(connection);
        }
    }

    public static void getZoneAssignments() throws SQLException {
        /**
     * Retrieves and prints information about all parking zone assignments from the database.
     *
     * @throws SQLException If a database access error occurs.
     */
        Connection connection = connectToDatabase(jdbcURL, user, pswd);
        try {
            String sql = "SELECT * FROM zone_assignments";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String zoneId = resultSet.getString("zone_id");
                String lotName = resultSet.getString("lot_name");

                System.out.println("Zone ID: " + zoneId);
                System.out.println("Lot Name: " + lotName);
                System.out.println("--------------------------");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(connection);
        }
    }

    public static void getZoneAssignedLots(String zoneId) throws SQLException {
        /**
     * Retrieves and prints information about parking zone assignments for a specific zone from the database.
     *
     * @param zoneId The ID of the parking zone to retrieve assignments for.
     * @throws SQLException If a database access error occurs.
     */
        Connection connection = connectToDatabase(jdbcURL, user, pswd);
        try {
            String sql = "SELECT * FROM zone_assignments WHERE zone_id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, zoneId);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String zoneID = resultSet.getString("zone_id");
                String lotName = resultSet.getString("lot_name");

                System.out.println("Zone ID: " + zoneID);
                System.out.println("Lot Name: " + lotName);
                System.out.println("--------------------------");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(connection);
        }
    }

    public static void getZonesInLot(String lotName) throws SQLException {
        /**
     * Retrieves and prints information about parking zones assigned to a specific lot from the database.
     *
     * @param lotName The name of the lot to retrieve assigned zones for.
     * @throws SQLException If a database access error occurs.
     */
        Connection connection = connectToDatabase(jdbcURL, user, pswd);
        try {
            String sql = "SELECT * FROM zone_assignments WHERE lot_name = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, lotName);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String zoneId = resultSet.getString("zone_id");
                String lotNames = resultSet.getString("lot_name");

                System.out.println("Zone ID: " + zoneId);
                System.out.println("Lot Name: " + lotNames);
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
