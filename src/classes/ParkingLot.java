package classes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class ParkingLot extends  WolfPark {
	
	String lotName;
	String address;
	
	public ParkingLot(String lotName, String address) {
        this.lotName = lotName;
        this.address = address;
    }
	
	public void enterParkingLotInfo() {
		try (Connection connection = DriverManager.getConnection("jdbc:your_database_url", "username", "password")) {
            String sql = "INSERT INTO parking_lots VALUES (?, ?)";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setString(1, lotName);
                preparedStatement.setString(2, address);
                preparedStatement.executeUpdate();
            } finally {
                //close(rs);
                //close(preparedStatement);
                close(connection);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
	}
	
	public void updateParkingLotInfo(String newAddress) {
        try (Connection connection = DriverManager.getConnection("jdbc:your_database_url", "username", "password")) {
            String sql = "UPDATE parking_lots SET address= ? WHERE lot_name = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setString(1, newAddress);
                preparedStatement.setString(2, lotName);
                preparedStatement.executeUpdate();
            } finally {
                //close(rs);
                //close(preparedStatement);
                close(connection);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
	
	public void deleteParkingLotInfo() {
        // Implement code to delete parking lot information from the database
        try (Connection connection = DriverManager.getConnection("jdbc:your_database_url", "username", "password")) {
            String sql = "DELETE FROM parking_lots WHERE lotName = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setString(1, lotName);
                preparedStatement.executeUpdate();
            } finally {
                //close(rs);
                //close(preparedStatement);
                close(connection);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
	
	
	
	
	
	static void close(Connection conn) {
        if(conn != null) {
            try { conn.close(); } catch(Throwable whatever) {}
        }
    }
	
//	static void close(PreparedStatement st) {
//        if(st != null) {
//            try { st.close(); } catch(Throwable whatever) {}
//        }
//    }

}
