/**
 * The Space class manages information about parking spaces in a parking system.
 * It extends the WolfPark class, indicating a relationship with another class.
 * This class provides methods for retrieving, adding, updating, and deleting parking space information
 * from a MariaDB database using JDBC. Additionally, it includes a method to check the availability
 * of a specific parking space in a given parking lot.
 */

package classes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Space extends WolfPark {

    // Database connection details
    static String jdbcURL = "jdbc:mariadb://classdb2.csc.ncsu.edu:3306/sguttha";
    static String user = "sguttha";
    static String pswd = "Maria@MegaMind1";

    public static void getSpaceInfo(int space_Number) throws SQLException {
        /**
         * Retrieves and prints information about a parking space based on its space number.
         *
         * @param space_Number The unique identifier for the parking space.
         * @throws SQLException If a database access error occurs.
         */

        Connection connection = connectToDatabase(jdbcURL, user, pswd);
        ResultSet result = null;

        try {
            String sql = "SELECT * WHERE space_number=?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, space_Number);
            result = preparedStatement.executeQuery();
            while (result.next()) {
                int spaceNumber = result.getInt("space_number");
                String spaceType = result.getString("space_type");

                System.out.println("Space Number: " + spaceNumber);
                System.out.println("Space Type: " + spaceType);
                System.out.println("--------------------------");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(connection);
        }
    }

    public static void addSpace(int spaceNumber, String spaceType) throws SQLException {
        /**
         * Adds a new parking space entry to the database.
         *
         * @param spaceNumber The unique identifier for the parking space.
         * @param spaceType   The type of parking space.
         * @throws SQLException If a database access error occurs.
         */

        Connection connection = connectToDatabase(jdbcURL, user, pswd);
        try {
            String sql = "INSERT INTO spaces VALUES (?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, spaceNumber);
            preparedStatement.setString(2, spaceType);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(connection);
        }
    }

    public static void updateSpaceType(int spaceNumber, String newSpaceType) throws SQLException {
        /**
         * Updates the type of a parking space in the database.
         *
         * @param spaceNumber   The unique identifier for the parking space.
         * @param newSpaceType  The new type for the parking space.
         * @throws SQLException If a database access error occurs.
         */

        Connection connection = connectToDatabase(jdbcURL, user, pswd);
        try {
            String sql = "UPDATE spaces SET space_type = ? WHERE space_number = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, newSpaceType);
            preparedStatement.setInt(2, spaceNumber);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(connection);
        }
    }

    public static void deleteSpace(int spaceNumber) throws SQLException {
        /**
         * Deletes a parking space entry from the database based on the space number.
         *
         * @param spaceNumber The unique identifier for the parking space to be deleted.
         * @throws SQLException If a database access error occurs.
         */

        Connection connection = connectToDatabase(jdbcURL, user, pswd);
        try {
            String sql = "DELETE FROM spaces WHERE space_number = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, spaceNumber);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(connection);
        }
    }

    public static int getAvailableSpace(int spaceNumber, String lotName) throws SQLException {
        /**
         * Retrieves the number of available spaces for a specific space in a given parking lot.
         *
         * @param spaceNumber The unique identifier for the parking space.
         * @param lotName     The name of the parking lot.
         * @return The number of available spaces.
         * @throws SQLException If a database access error occurs.
         */

        int availableSpace = 0;
        Connection connection = connectToDatabase(jdbcURL, user, pswd);
        try {
            String sql = "SELECT COUNT(*) FROM space_assignments sa, spaces s " +
                    "WHERE sa.space_number = s.space_number " +
                    "AND sa.lot_name = ? " +
                    "AND sa.space_number = ? " +
                    "AND sa.availability_status = 'YES'";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, lotName);
            preparedStatement.setInt(2, spaceNumber);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                availableSpace = resultSet.getInt(1);
                // System.out.println(preparedStatement);
                System.out.println(availableSpace);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(connection);
        }
        return availableSpace;
    }

    private static Connection connectToDatabase(String jdbcURL, String user, String pswd)
            throws SQLException {
        /**
         * Establishes a connection to the MariaDB database.
         *
         * @param jdbcURL The JDBC URL of the database.
         * @param user    The username for the database connection.
         * @param pswd    The password for the database connection.
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
         * @param conn The Connection object to be closed.
         */

        if (conn != null) {
            try {
                conn.close();
            } catch (Throwable whatever) {
            }
        }

    }
}
