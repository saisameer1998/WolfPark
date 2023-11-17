/**
 * The Zone class manages information related to parking zones in a parking system.
 * It extends the WolfPark class to inherit any common functionality.
 * The class provides methods to add, delete, and retrieve information about parking zones
 * in a MariaDB database.
 */

package classes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Zone extends WolfPark {

    // Database connection details
    static String jdbcURL = "jdbc:mariadb://classdb2.csc.ncsu.edu:3306/sguttha";
    static String user = "sguttha";
    static String pswd = "Maria@MegaMind1";

    public static void addZone(String zoneId) throws SQLException {
        /**
         * Adds a new parking zone with the specified ID to the database.
         *
         * @param zoneId The ID of the new parking zone.
         * @throws SQLException If a database access error occurs.
         */

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
        /**
         * Deletes a parking zone with the specified ID from the database.
         *
         * @param zoneId The ID of the parking zone to be deleted.
         * @throws SQLException If a database access error occurs.
         */

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
        /**
         * Retrieves and returns information about a parking zone based on its ID.
         *
         * @param zoneId The ID of the parking zone to retrieve information for.
         * @return A String representing the ID of the retrieved parking zone.
         * @throws SQLException If a database access error occurs.
         */
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
