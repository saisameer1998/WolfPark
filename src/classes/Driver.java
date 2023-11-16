package classes;

import java.sql.*;

public class Driver extends WolfPark {

    static String jdbcURL = "jdbc:mariadb://classdb2.csc.ncsu.edu:330/";
    static String user = "sguttha";
    static String pswd = "Maria@MegaMind1";

    // String driver_id;
    // String name;
    // String status;
    // String disability;

    // public Driver(String driver_id, String name, String status, String
    // disability) {
    // this.driver_id = driver_id;
    // this.name = name;
    // this.status = status;
    // this.disability = disability;
    // }

    public static void addDriver(String driver_id, String name, String status, String disability)
            throws SQLException {
        Connection connection = connectToDatabase(jdbcURL, user, pswd);
        try {
            String sql = "INSERT INTO drivers VALUES (?, ? ,? ,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, driver_id);
            preparedStatement.setString(2, name);
            preparedStatement.setString(3, status);
            preparedStatement.setString(4, disability);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(connection);
        }
    }

    public static void updateDriverInfo(String driver_id, String name) throws SQLException {
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

    public static void deleteDriver(String driver_id) throws SQLException {
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
