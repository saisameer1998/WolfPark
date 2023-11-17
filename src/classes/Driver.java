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
        Connection connection = connectToDatabase(jdbcURL, user, pswd);
        try {
            String sql = "SELECT COUNT(DISTINCT ( d.driver_id ) ) FROM permits p, drivers d WHERE p.driver_id = d.driver_id AND p.lot_name= ? AND d.status = ?;";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, lot_name);
            preparedStatement.setString(2, status);
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
