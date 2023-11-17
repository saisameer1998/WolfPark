package classes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Space extends WolfPark {

    static String jdbcURL = "jdbc:mariadb://classdb2.csc.ncsu.edu:3306/sguttha";
    static String user = "sguttha";
    static String pswd = "Maria@MegaMind1";

    // int spaceNumber;
    // String spaceType;

    // public Space(int spaceNumber, String spaceType) {
    // this.spaceNumber = spaceNumber;
    // this.spaceType = spaceType;
    // }

    public static void addSpace(int spaceNumber, String spaceType) throws SQLException {
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
                System.out.println(preparedStatement);
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
