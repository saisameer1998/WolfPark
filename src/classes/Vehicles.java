/**
 * The Vehicles class manages information related to vehicles in a parking system.
 * It extends the WolfPark class to inherit any common functionality.
 * The class provides methods to retrieve, add, delete, and update vehicle information
 * in a MariaDB database.
 */

package classes;

import java.sql.*;

public class Vehicles extends WolfPark {

    // Database connection details
    static String jdbcURL = "jdbc:mariadb://classdb2.csc.ncsu.edu:3306/sguttha";
    static String user = "sguttha";
    static String pswd = "Maria@MegaMind1";

    public static void GetVehicleInfo(String car_license_number) throws SQLException {
        /**
         * Retrieves and displays information about a vehicle based on its license plate number.
         *
         * @param car_license_number The license plate number of the vehicle to retrieve information for.
         * @throws SQLException If a database access error occurs.
         */

        Connection connection = connectToDatabase(jdbcURL, user, pswd);
        ResultSet result = null;
        try {
            String sql = "SELECT * FROM vehicles WHERE car_license_number = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, car_license_number);
            result = preparedStatement.executeQuery();
            while (result.next()) {
                String carLicenseNumber = result.getString("car_license_number");
                String model = result.getString("model");
                String color = result.getString("color");
                String manufacturer = result.getString("manufacturer");
                int year = result.getInt("year");

                System.out.println("Car License Number: " + carLicenseNumber);
                System.out.println("Model: " + model);
                System.out.println("Color: " + color);
                System.out.println("Manufacturer: " + manufacturer);
                System.out.println("Year: " + year);
                System.out.println("--------------------------");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(connection);
        }
    }

    public static void AddVehicle(String car_license_number, String driver_id, String model, String color,
            String manufacturer, int year) throws SQLException {
        /**
         * Adds a new vehicle with the specified details to the database.
         *
         * @param car_license_number The license plate number of the new vehicle.
         * @param driver_id          The driver ID associated with the vehicle.
         * @param model              The model of the vehicle.
         * @param color              The color of the vehicle.
         * @param manufacturer       The manufacturer of the vehicle.
         * @param year               The manufacturing year of the vehicle.
         * @throws SQLException If a database access error occurs.
         */

        Connection connection = connectToDatabase(jdbcURL, user, pswd);
        try {
            String sql = "INSERT INTO vehicles VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, car_license_number);
            if(driver_id.isBlank()) {
            	preparedStatement.setNull(2, java.sql.Types.VARCHAR);
            }
            else {
            	preparedStatement.setString(2, driver_id);
            }
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

    public static void DeleteVehicle(String car_license_number) throws SQLException {
        /**
         * Deletes a vehicle with the specified license plate number from the database.
         *
         * @param car_license_number The license plate number of the vehicle to be deleted.
         * @throws SQLException If a database access error occurs.
         */

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

    public static void updateVehicleDriverId(String car_license_number, String driverId) throws SQLException {
        /**
         * Updates the driver ID associated with a vehicle in the database.
         *
         * @param car_license_number The license plate number of the vehicle to be updated.
         * @param driverId           The new driver ID to associate with the vehicle.
         * @throws SQLException If a database access error occurs.
         */

        Connection connection = connectToDatabase(jdbcURL, user, pswd);

        try {
            String sql = "UPDATE vehicles SET driver_id=? WHERE car_license_number = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, driverId);
            preparedStatement.setString(2, car_license_number);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(connection);
        }
    }

    public static void updateVehicleModel(String car_license_number, String model) throws SQLException {
        /**
         * Updates model associated with a vehicle in the database.
         *
         * @param car_license_number The license plate number of the vehicle to be updated.
         * @param model           The new model to associate with the vehicle.
         * @throws SQLException If a database access error occurs.
         */
        Connection connection = connectToDatabase(jdbcURL, user, pswd);

        try {
            String sql = "UPDATE vehicles SET model=? WHERE car_license_number = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, model);
            preparedStatement.setString(2, car_license_number);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(connection);
        }
    }

    public static void updateVehicleColor(String car_license_number, String color) throws SQLException {
        /**
         * Updates color associated with a vehicle in the database.
         *
         * @param car_license_number The license plate number of the vehicle to be updated.
         * @param color           The new color to associate with the vehicle.
         * @throws SQLException If a database access error occurs.
         */
        Connection connection = connectToDatabase(jdbcURL, user, pswd);

        try {
            String sql = "UPDATE vehicles SET color=? WHERE car_license_number = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, color);
            preparedStatement.setString(2, car_license_number);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(connection);
        }
    }

    public static void updateVehicleManufacturer(String car_license_number, String manufacturer) throws SQLException {
        /**
         * Updates manufacturer associated with a vehicle in the database.
         *
         * @param car_license_number The license plate number of the vehicle to be updated.
         * @param manufacturer           The new manufacturer to associate with the vehicle.
         * @throws SQLException If a database access error occurs.
         */
        Connection connection = connectToDatabase(jdbcURL, user, pswd);

        try {
            String sql = "UPDATE vehicles SET manufacturer=? WHERE car_license_number = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, manufacturer);
            preparedStatement.setString(2, car_license_number);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(connection);
        }
    }
    
    public static void updateVehicleYear(String car_license_number, int year) throws SQLException {
        /**
         * Updates year associated with a vehicle in the database.
         *
         * @param car_license_number The license plate number of the vehicle to be updated.
         * @param year           The new year to associate with the vehicle.
         * @throws SQLException If a database access error occurs.
         */
        Connection connection = connectToDatabase(jdbcURL, user, pswd);

        try {
            String sql = "UPDATE vehicles SET year=? WHERE car_license_number = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, year);
            preparedStatement.setString(2, car_license_number);
            preparedStatement.executeUpdate();
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
         * @param jdbcURL The JDBC URL of the database.
         * @param user    The database username.
         * @param pswd    The database password.
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
         * @param conn The database connection to be closed.
         */
    
        if (conn != null) {
            try {
                conn.close();
            } catch (Throwable whatever) {
            }
        }

    }

}
