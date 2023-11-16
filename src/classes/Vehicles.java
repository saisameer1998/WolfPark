package classes;

import java.sql.*;

public class Vehicles extends WolfPark {

    String jdbcURL = "jdbc:mariadb://classdb2.csc.ncsu.edu:330/";
    String user = "sguttha";
    String pswd = "Maria@MegaMind1";

    String car_license_number;
    String driver_id;
    String model;
    String color;
    String manufacturer;
    int year;

    public Vehicles(String car_license_number, String driver_id, String model, String color, String manufacturer,
            int year) {
        this.car_license_number = car_license_number;
        this.driver_id = driver_id;
        this.model = model;
        this.color = color;
        this.manufacturer = manufacturer;
        this.year = year;
    }

    public void GetVehicleInfo(String driver_id) throws SQLException {
        Connection connection = connectToDatabase(jdbcURL, user, pswd);
        ResultSet result = null;
        try {
            String sql = "SELECT * FROM vehicles WHERE driver_id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, driver_id);
            result = preparedStatement.executeQuery();
            // Process the ResultSet or return it as needed
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(connection);
        }
    }

    public void AddVehicle(String car_license_number, String driver_id, String model, String color, String manufacturer,
            int year) throws SQLException {
        Connection connection = connectToDatabase(jdbcURL, user, pswd);
        try {
            String sql = "INSERT INTO vehicles VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, car_license_number);
            preparedStatement.setString(2, driver_id);
            preparedStatement.setString(3, model);
            preparedStatement.setString(4, color);
            preparedStatement.setString(5, manufacturer);
            preparedStatement.setInt(6, year);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(connection);
        }
    }

    public void DeleteVehicle(String car_license_number) throws SQLException {
        Connection connection = connectToDatabase(jdbcURL, user, pswd);
        try {
            String sql = "DELETE FROM vehicles WHERE car_license_number = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, car_license_number);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(connection);
        }
    }

    public void UpdateVehicle(String car_license_number, String model, String color, String manufacturer, int year)
            throws SQLException {
        Connection connection = connectToDatabase(jdbcURL, user, pswd);
        try {
            String sql = "UPDATE vehicles SET model=?, color=?, manufacturer=?, year=? WHERE car_license_number = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, model);
            preparedStatement.setString(2, color);
            preparedStatement.setString(3, manufacturer);
            preparedStatement.setInt(4, year);
            preparedStatement.setString(5, car_license_number);
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