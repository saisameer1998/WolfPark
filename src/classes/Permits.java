package classes;

import java.sql.*;

public class Permits extends WolfPark {

	static String jdbcURL = "jdbc:mariadb://classdb2.csc.ncsu.edu:3306/sguttha";
    static String user = "sguttha";
    static String pswd = "Maria@MegaMind1";

    // String permit_id;
    // String lot_name;
    // String zone_id;
    // String space_type;
    // String start_date;
    // String expiration_date;
    // String expiration_time;
    // String driver_id;
    // String permit_type;

    // public void Permits(String permit_id, String lot_name, String zone_id, String space_type, String start_date,
    //         String expiration_date, String expiration_time, String driver_id, String permit_type) {
    //     this.permit_id = permit_id;
    //     this.lot_name = lot_name;
    //     this.zone_id = zone_id;
    //     this.space_type = space_type;
    //     this.start_date = start_date;
    //     this.expiration_date = expiration_date;
    //     this.expiration_time = expiration_time;
    //     this.driver_id = driver_id;
    //     this.permit_type = permit_type;
    // }

    public static void CreatePermitInfo(String permit_id, String lot_name, String zone_id, String space_type, String start_date,
            String expiration_date, String expiration_time, String driver_id, String permit_type) throws SQLException {
        Connection connection = connectToDatabase(jdbcURL, user, pswd);
        try {
            String sql = "INSERT INTO permits VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, permit_id);
            preparedStatement.setString(2, lot_name);
            preparedStatement.setString(3, zone_id);
            preparedStatement.setString(4, space_type);
            preparedStatement.setString(5, start_date);
            preparedStatement.setString(6, expiration_date);
            preparedStatement.setString(7, expiration_time);
            preparedStatement.setString(8, driver_id);
            preparedStatement.setString(9, permit_type);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(connection);
        }
    }

    public static void UpdatePermitInfo(String updatedLotName, String permitId) throws SQLException {
        Connection connection = connectToDatabase(jdbcURL, user, pswd);
        try {
            String sql = "UPDATE permits SET lot_name = ? WHERE permit_id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, updatedLotName);
            preparedStatement.setString(2, permitId);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(connection);
        }
    }

    public static void DeletePermitInfo(String permitId) throws SQLException {
        Connection connection = connectToDatabase(jdbcURL, user, pswd);
        try {
            String sql = "DELETE FROM permits WHERE permit_id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, permitId);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(connection);
        }
    }

    public static void GetPermitInfo(String permitId) throws SQLException {
    	Connection connection = connectToDatabase(jdbcURL, user, pswd);
        ResultSet result = null;
        try {
            String sql = "SELECT * FROM permits WHERE permit_id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, permitId);
            result = preparedStatement.executeQuery();
            while (result.next()) {
                String lotName = result.getString("lot_name");
                String zoneId = result.getString("zone_id");
                String spaceType = result.getString("space_type");
                String startDate = result.getString("start_date");
                String expirationDate = result.getString("expiration_date");
                String expirationTime = result.getString("expiration_time");
                String driverId = result.getString("driver_id");
                String permitType = result.getString("permit_type");

                System.out.println("Permit ID: " + permitId);
                System.out.println("Lot Name: " + lotName);
                System.out.println("Zone ID: " + zoneId);
                System.out.println("Space Type: " + spaceType);
                System.out.println("Start Date: " + startDate);
                System.out.println("Expiration Date: " + expirationDate);
                System.out.println("Expiration Time: " + expirationTime);
                System.out.println("Driver ID: " + driverId);
                System.out.println("Permit Type: " + permitType);
                System.out.println("--------------------------");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(connection);
        }
    }

    //Fix Query
    public static boolean IsValidPermit(String permitId) throws SQLException {
        Connection connection = connectToDatabase(jdbcURL, user, pswd);
        ResultSet result = null;
        try {
            String sql = "SELECT 1 FROM permits WHERE permit_id = ? AND expiration_date >= CURRENT_DATE";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, permitId);
            result = preparedStatement.executeQuery();
            return result.next();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(connection);
        }
        return false;
    }

    private static Connection connectToDatabase(String jdbcURL, String user, String pswd)
            throws SQLException {
        Connection connection = null;
        try {
        	System.out.println("ooooo");
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