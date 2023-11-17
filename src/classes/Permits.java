/**
 * The Permits class manages information about parking permits in a parking system.
 * It extends the WolfPark class, indicating a relationship with another class.
 * This class provides methods for creating, updating, deleting, and retrieving permit information
 * It also includes a method to check the validity of a permit.
 */

package classes;

import java.sql.*;

public class Permits extends WolfPark {

    // Database connection details
    static String jdbcURL = "jdbc:mariadb://classdb2.csc.ncsu.edu:3306/sguttha";
    static String user = "sguttha";
    static String pswd = "Maria@MegaMind1";

    public static void CreatePermitInfo(String permit_id, String lot_name, String zone_id, String space_type,
            String start_date,
            String expiration_date, String expiration_time, String driver_id, String permit_type) throws SQLException {
        /**
         * Creates a new entry for a parking permit in the database.
         *
         * @param permit_id          The unique identifier for the permit.
         * @param lot_name           The name of the parking lot associated with the permit.
         * @param zone_id            The zone identifier associated with the permit.
         * @param space_type         The type of parking space associated with the permit.
         * @param start_date         The start date of the permit's validity.
         * @param expiration_date    The expiration date of the permit.
         * @param expiration_time    The expiration time of the permit.
         * @param driver_id          The driver's identifier associated with the permit.
         * @param permit_type        The type of permit.
         * @throws SQLException If a database access error occurs.
         */

        Connection connection = connectToDatabase(jdbcURL, user, pswd);
        try {
            String sql = "INSERT INTO permits VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, permit_id);
            preparedStatement.setString(2, lot_name);
            preparedStatement.setString(3, zone_id);
            preparedStatement.setString(4, space_type);
            preparedStatement.setString(5, start_date);
            preparedStatement.setString(6, expiration_date);
            preparedStatement.setString(7, expiration_time);
            preparedStatement.setString(8, driver_id);
            preparedStatement.setString(9, permit_type);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(connection);
        }
    }

    public static void UpdatePermitLotName(String lotName, String permitId) throws SQLException {
        /**
         * Updates the parking lot associated with a permit in the database.
         *
         * @param lotName   The new parking lot name for the permit.
         * @param permitId  The unique identifier for the permit.
         * @throws SQLException If a database access error occurs.
         */

        Connection connection = connectToDatabase(jdbcURL, user, pswd);
        try {
            String sql = "UPDATE permits SET lot_name = ? WHERE permit_id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, lotName);
            preparedStatement.setString(2, permitId);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(connection);
        }
    }

    public static void UpdatePermitZoneID(String zoneID, String permitId) throws SQLException {
        /**
         * Updates the zone identifier associated with a permit in the database.
         *
         * @param zoneID    The new zone identifier for the permit.
         * @param permitId  The unique identifier for the permit.
         * @throws SQLException If a database access error occurs.
         */

        Connection connection = connectToDatabase(jdbcURL, user, pswd);
        try {
            String sql = "UPDATE permits SET zone_id = ? WHERE permit_id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, zoneID);
            preparedStatement.setString(2, permitId);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(connection);
        }
    }

    public static void UpdatePermitSpaceType(String spaceType, String permitId) throws SQLException {
        /**
         * Updates the space type associated with a permit in the database.
         *
         * @param spaceType The new space type for the permit.
         * @param permitId  The unique identifier for the permit.
         * @throws SQLException If a database access error occurs.
         */

        Connection connection = connectToDatabase(jdbcURL, user, pswd);
        try {
            String sql = "UPDATE permits SET space_type = ? WHERE permit_id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, spaceType);
            preparedStatement.setString(2, permitId);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(connection);
        }
    }

    public static void UpdatePermitStartDate(String startDate, String permitId) throws SQLException {
        /**
         * Updates the start date associated with a permit in the database.
         *
         * @param startDate The new start date for the permit's validity.
         * @param permitId  The unique identifier for the permit.
         * @throws SQLException If a database access error occurs.
         */

        Connection connection = connectToDatabase(jdbcURL, user, pswd);
        try {
            String sql = "UPDATE permits SET start_date = ? WHERE permit_id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, startDate);
            preparedStatement.setString(2, permitId);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(connection);
        }
    }

    public static void UpdatePermitExpirationDate(String expirationDate, String permitId) throws SQLException {
        /**
         * Updates the expiration date associated with a permit in the database.
         *
         * @param expirationDate The new expiration date for the permit.
         * @param permitId       The unique identifier for the permit.
         * @throws SQLException If a database access error occurs.
         */

        Connection connection = connectToDatabase(jdbcURL, user, pswd);
        try {
            String sql = "UPDATE permits SET expiration_date = ? WHERE permit_id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, expirationDate);
            preparedStatement.setString(2, permitId);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(connection);
        }
    }

    public static void UpdatePermitExpirationTime(String expirationTime, String permitId) throws SQLException {
        /**
         * Updates the expiration time associated with a permit in the database.
         *
         * @param expirationTime The new expiration time for the permit.
         * @param permitId       The unique identifier for the permit.
         * @throws SQLException If a database access error occurs.
         */

        Connection connection = connectToDatabase(jdbcURL, user, pswd);
        try {
            String sql = "UPDATE permits SET expiration_time = ? WHERE permit_id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, expirationTime);
            preparedStatement.setString(2, permitId);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(connection);
        }
    }

    public static void UpdatePermitDriverId(String driverId, String permitId) throws SQLException {
        /**
        * Updates the driver's identifier associated with a permit in the database.
        *
        * @param driverId The new driver's identifier for the permit.
        * @param permitId The unique identifier for the permit.
        * @throws SQLException If a database access error occurs.
        */

        Connection connection = connectToDatabase(jdbcURL, user, pswd);
        try {
            String sql = "UPDATE permits SET driver_id = ? WHERE permit_id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, driverId);
            preparedStatement.setString(2, permitId);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(connection);
        }
    }

    public static void UpdatePermitPermitType(String permitType, String permitId) throws SQLException {
        /**
         * Updates the type of permit associated with a permit in the database.
         *
         * @param permitType The new type of permit.
         * @param permitId   The unique identifier for the permit.
         * @throws SQLException If a database access error occurs.
         */

        Connection connection = connectToDatabase(jdbcURL, user, pswd);
        try {
            String sql = "UPDATE permits SET permit_type = ? WHERE permit_id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, permitType);
            preparedStatement.setString(2, permitId);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(connection);
        }
    }

    public static void DeletePermitInfo(String permitId) throws SQLException {
        /**
         * Deletes permit information from the database based on the permit's unique identifier.
         *
         * @param permitId The unique identifier for the permit to be deleted.
         * @throws SQLException If a database access error occurs.
         */

        Connection connection = connectToDatabase(jdbcURL, user, pswd);
        try {
            String sql = "DELETE FROM permits WHERE permit_id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, permitId);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(connection);
        }
    }

    public static void GetPermitInfo(String permitId) throws SQLException {
        /**
         * Retrieves and prints information about a permit based on its unique identifier.
         *
         * @param permitId The unique identifier for the permit to retrieve information about.
         * @throws SQLException If a database access error occurs.
         */

        Connection connection = connectToDatabase(jdbcURL, user, pswd);
        ResultSet result = null;
        try {
            String sql = "SELECT * FROM permits WHERE permit_id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, permitId);
            result = preparedStatement.executeQuery();
            while (result.next()) {
                String lotName = result.getString("lot_name");
                String zoneId = result.getString("zone_id");
                String spaceType = result.getString("space_type");
                String startDate = result.getString("start_date");
                String expirationDate = result.getString("expiration_date");
                String expirationTime = result.getString("expiration_time");
                String driverId = result.getString("driver_id");
                String permitType = result.getString("permit_type");

                System.out.println("Permit ID: " + permitId);
                System.out.println("Lot Name: " + lotName);
                System.out.println("Zone ID: " + zoneId);
                System.out.println("Space Type: " + spaceType);
                System.out.println("Start Date: " + startDate);
                System.out.println("Expiration Date: " + expirationDate);
                System.out.println("Expiration Time: " + expirationTime);
                System.out.println("Driver ID: " + driverId);
                System.out.println("Permit Type: " + permitType);
                System.out.println("--------------------------");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(connection);
        }
    }

    public static void IsValidPermit(String permitId) throws SQLException {
        /**
         * Checks if a permit is valid based on its unique identifier and expiration date.
         *
         * @param permitId The unique identifier for the permit to check.
         * @throws SQLException If a database access error occurs.
         */

        Connection connection = connectToDatabase(jdbcURL, user, pswd);
        ResultSet result = null;
        try {
            String sql = "SELECT 1 FROM permits WHERE permit_id = ? AND expiration_date >= CURRENT_DATE";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, permitId);
            result = preparedStatement.executeQuery();
            if (result.next() == true) {
                System.out.println("True");
            } else {
                System.out.println("False");
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
     	* @param jdbcURL   The JDBC URL for the database.
     	* @param user      The username for database access.
     	* @param pswd      The password for database access.
     	* @return          A Connection object representing the database connection.
     	* @throws SQLException     If a database access error occurs.
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
     	* Closes the given database connection.
     	*
     	* @param conn  The Connection object to be closed.
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
