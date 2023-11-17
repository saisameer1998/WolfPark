/**
 * The Driver class manages interactions with the database related to drivers.
 */

package classes;

import java.sql.*;

public class Driver extends WolfPark {

    // Database connection details
    static String jdbcURL = "jdbc:mariadb://classdb2.csc.ncsu.edu:330/";
    static String user = "sguttha";
    static String pswd = "Maria@MegaMind1";

    public static void getDriverInfo(String driver_id) throws SQLException {
        /**
         * Retrieves information about a specific driver from the database.
         *
         * @param driver_id The ID of the driver to retrieve information for.
         * @throws SQLException If a database error occurs.
         */

        Connection connection = connectToDatabase(jdbcURL, user, pswd);
        ResultSet result = null;
        try {
            String sql = "SELECT * WHERE driver_id= ? ";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, driver_id);
            result = preparedStatement.executeQuery();
            while (result.next()) {
                String driverId = result.getString("driver_id");
                String name = result.getString("name");
                String status = result.getString("status");
                String disability = result.getString("disability");

                System.out.println("Driver ID: " + driverId);
                System.out.println("Name: " + name);
                System.out.println("Status: " + status);
                System.out.println("Disability: " + disability);
                System.out.println("--------------------------");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(connection);
        }
    }

    public static void addDriver(String driver_id, String name, String status, String disability)
            throws SQLException {
                /**
                 * Adds a new driver to the database.
                 *
                 * @param driver_id  The ID of the new driver.
                 * @param name       The name of the new driver.
                 * @param status     The status of the new driver.
                 * @param disability The disability status of the new driver.
                 * @throws SQLException If a database error occurs.
                 */
                Connection connection = connectToDatabase(jdbcURL, user, pswd);
                try {
                    // Start the transaction
                    connection.setAutoCommit(false);

                    String sql = "INSERT INTO drivers VALUES (?, ?, ?, ?)";
                    try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                        preparedStatement.setString(1, driver_id);
                        preparedStatement.setString(2, name);
                        preparedStatement.setString(3, status);
                        preparedStatement.setString(4, disability);
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


    public static void updateDriverName(String driver_id, String name) throws SQLException {
        /**
     	* Updates the name of a driver in the database.
     	*
     	* @param driver_id   The unique identifier for the driver.
     	* @param name        The new name for the driver.
     	* @throws SQLException     If a database access error occurs.
     	*/

        Connection connection = connectToDatabase(jdbcURL, user, pswd);
        try {
            String sql = "UPDATE drivers SET name = ? WHERE driver_id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, driver_id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(connection);
        }
    }

    public static void updateDriverStatus(String driver_id, String status) throws SQLException {
        /**
     	* Updates the status of a driver in the database.
     	*
     	* @param driver_id   The unique identifier for the driver.
     	* @param status      The new status for the driver.
     	* @throws SQLException     If a database access error occurs.
     	*/

        Connection connection = connectToDatabase(jdbcURL, user, pswd);
        try {
            String sql = "UPDATE drivers SET status = ? WHERE driver_id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, status);
            preparedStatement.setString(2, driver_id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(connection);
        }
    }

    public static void updateDriverDisability(String driver_id, String disability) throws SQLException {
        /**
     	* Updates the disability of a driver in the database.
     	*
     	* @param driver_id   The unique identifier for the driver.
     	* @param disability  The new disability for the driver.
     	* @throws SQLException     If a database access error occurs.
     	*/

        Connection connection = connectToDatabase(jdbcURL, user, pswd);
        try {
            String sql = "UPDATE drivers SET disability = ? WHERE driver_id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, disability);
            preparedStatement.setString(2, driver_id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(connection);
        }
    }

    public static void deleteDriver(String driver_id) throws SQLException {
        /**
     	* Deletes a driver entry from the database.
     	*
     	* @param driver_id      The unique identifier for the driver to be deleted.
     	* @throws SQLException     If a database access error occurs.
     	*/

        Connection connection = connectToDatabase(jdbcURL, user, pswd);
        try {
            String sql = "DELETE FROM drivers WHERE driver_id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, driver_id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(connection);
        }
    }

    public static void getEmpPermCount(String lot_name, String status) throws SQLException {
        /**
         * Retrieves the count of distinct drivers with a specific status in a given parking lot.
         *
         * @param lot_name The name of the parking lot.
         * @param status   The status of the drivers.
         * @throws SQLException If a database error occurs.
         */

        Connection connection = connectToDatabase(jdbcURL, user, pswd);
        ResultSet result = null;

        try {
            String sql = "SELECT COUNT(DISTINCT(d.driver_id)) as 'driver_count' FROM permits p, drivers d WHERE p.driver_id = d.driver_id AND p.lot_name= ? AND d.status = ?;";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, lot_name);
            preparedStatement.setString(2, status);
            result = preparedStatement.executeQuery();
            while (result.next()) {
            int count = result.getInt("driver_count"); // Assuming the count is in the first column
            System.out.println("Employee Permit Count: " + count);
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
            } catch (Throwable whatever) {
            }
        }

    }

}
