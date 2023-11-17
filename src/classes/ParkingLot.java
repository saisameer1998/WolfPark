package classes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ParkingLot extends WolfPark {

    static String jdbcURL = "jdbc:mariadb://classdb2.csc.ncsu.edu:330/";
    static String user = "sguttha";
    static String pswd = "Maria@MegaMind1";

    public static void addParkingLot(String lotName, String address) throws SQLException {
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
            } catch (Throwable whatever) {
            }
        }

    }

}
