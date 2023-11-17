/**
 * The ParkingLot class represents a basic management system for parking lots.
 * It extends the WolfPark class, implying a relationship with another class.
 * This class provides methods for adding, updating, deleting, and retrieving information about parking lots
 * from a MariaDB database using JDBC.
 */

package classes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ParkingLot extends WolfPark {

    static String jdbcURL = "jdbc:mariadb://classdb2.csc.ncsu.edu:3306/sguttha";
    static String user = "sguttha";
    static String pswd = "Maria@MegaMind1";

    public static void addParkingLot(String lotName, String address) throws SQLException {
        /**
         * Adds a new parking lot to the database.
         *
         * @param lotName  The name of the parking lot.
         * @param address  The address of the parking lot.
         * @throws SQLException If a database access error occurs.
         */

        Connection connection = connectToDatabase(jdbcURL, user, pswd);
        try {
            String sql = "INSERT INTO parking_lots VALUES (?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, lotName);
            preparedStatement.setString(2, address);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(connection);
        }
    }

    public static void updateParkingLotAddress(String lotName, String newAddress) throws SQLException {
        /**
         * Updates the address of an existing parking lot in the database.
         *
         * @param lotName     The name of the parking lot to be updated.
         * @param newAddress  The new address for the parking lot.
         * @throws SQLException If a database access error occurs.
         */

        Connection connection = connectToDatabase(jdbcURL, user, pswd);
        try {
            String sql = "UPDATE parking_lots SET address= ? WHERE lot_name = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, newAddress);
            preparedStatement.setString(2, lotName);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(connection);
        }
    }

    public static void deleteParkingLot(String lotName) throws SQLException {
        /**
         * Deletes a parking lot from the database based on its name.
         *
         * @param lotName  The name of the parking lot to be deleted.
         * @throws SQLException If a database access error occurs.
         */

        Connection connection = connectToDatabase(jdbcURL, user, pswd);
        try {
            String sql = "DELETE FROM parking_lots WHERE lotName = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, lotName);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(connection);
        }
    }

    public static void getParkingLotInfo(String lotName) throws SQLException {
        /**
         * Retrieves and prints information about a parking lot based on its name.
         *
         * @param lotName  The name of the parking lot to retrieve information about.
         * @throws SQLException If a database access error occurs.
         */

        Connection connection = connectToDatabase(jdbcURL, user, pswd);
        ResultSet result = null;
        try {
            String sql = "SELECT * WHERE lot_name= ? ";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, lotName);
            result = preparedStatement.executeQuery();
            while (result.next()) {
                String lotNames = result.getString("lot_name");
                String address = result.getString("address");

                System.out.println("Lot Name: " + lotNames);
                System.out.println("Address: " + address);
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
         * @param jdbcURL  The JDBC URL for the database.
         * @param user     The username for the database connection.
         * @param pswd     The password for the database connection.
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
