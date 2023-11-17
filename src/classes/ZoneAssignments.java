package classes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ZoneAssignments extends WolfPark {

    static String jdbcURL = "jdbc:mariadb://classdb2.csc.ncsu.edu:3306/sguttha";
    static String user = "sguttha";
    static String pswd = "Maria@MegaMind1";

    public static void assignZone(String zoneId, String lotName) throws SQLException {
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
        Connection connection = connectToDatabase(jdbcURL, user, pswd);
        try {
            String sql = "SELECT * FROM zone_assignments";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (result.next()) {
                String zoneId = result.getString("zone_id");
                String lotName = result.getString("lot_name");

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
        Connection connection = connectToDatabase(jdbcURL, user, pswd);
        try {
            String sql = "SELECT * FROM zone_assignments WHERE zone_id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, zoneId);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (result.next()) {
                String zoneId = result.getString("zone_id");
                String lotName = result.getString("lot_name");

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

    public static void getZonesInLot(String lotName) throws SQLException {
        Connection connection = connectToDatabase(jdbcURL, user, pswd);
        try {
            String sql = "SELECT * FROM zone_assignments WHERE lot_name = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, lotName);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (result.next()) {
                String zoneId = result.getString("zone_id");
                String lotName = result.getString("lot_name");

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
