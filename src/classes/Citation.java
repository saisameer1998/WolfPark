package classes;

import java.sql.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Citation extends WolfPark {
	
//	String lotName;
//	String address;
//	
//	public ParkingLot(String lotName, String address) {
//        this.lotName = lotName;
//        this.address = address;
//    }
	String jdbcURL = "jdbc:mariadb://classdb2.csc.ncsu.edu:330/";
	String user = "sguttha";
	String pswd = "Maria@MegaMind1";
	
	public void generateCitation(String citationNumber, String carLicenseNumber, String lotName, 
									String category, float fee, String paymentStatus) throws SQLException {

		Connection connection = connectToDatabase(jdbcURL, user, pswd);
		try {
			String sql = "INSERT INTO citations(citation_number, car_license_number," +
							" citation_date, citation_time, lot_name, category, fee, payment_status)" +
							" VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?)";
			String citationDate = LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
			String citationTime = LocalTime.now().format(DateTimeFormatter.ofPattern("hh:mm:ss"));
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, citationNumber);
			preparedStatement.setString(2, carLicenseNumber);
			preparedStatement.setString(3, citationDate);
			preparedStatement.setString(4, citationTime);
			preparedStatement.setString(5, lotName);
			preparedStatement.setString(6, category);
			preparedStatement.setFloat(7, fee);
			preparedStatement.setString(8, paymentStatus);
			preparedStatement.executeUpdate();
		} 
		catch (SQLException e) {
            e.printStackTrace();
        }
		finally {
            close(connection);
    	}
    }

	public void UpdateCitationCarLsncNum(String citationNumber, String carLicenseNumber) throws SQLException {

		Connection connection = connectToDatabase(jdbcURL, user, pswd);
		try {
			String sql = "UPDATE citations SET car_license_number = ? WHERE citation_number = ?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, carLicenseNumber);
			preparedStatement.setString(2, citationNumber);
			preparedStatement.executeUpdate();
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			close(connection);
		}
	}

	public void UpdateCitationLotName(String citationNumber, String lotName) throws SQLException {

		Connection connection = connectToDatabase(jdbcURL, user, pswd);
		try {
			String sql = "UPDATE citations SET lot_name = ? WHERE citation_number = ?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, lotName);
			preparedStatement.setString(2, citationNumber);
			preparedStatement.executeUpdate();
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			close(connection);
		}
	}

	public void UpdateCitationCategory(String citationNumber, String category) throws SQLException {

		Connection connection = connectToDatabase(jdbcURL, user, pswd);
		try {
			String sql = "UPDATE citations SET category = ? WHERE citation_number = ?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, category);
			preparedStatement.setString(2, citationNumber);
			preparedStatement.executeUpdate();
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			close(connection);
		}
	}

	public void UpdateCitationFee(String citationNumber, float fee) throws SQLException {

		Connection connection = connectToDatabase(jdbcURL, user, pswd);
		try {
			String sql = "UPDATE citations SET fee = ? WHERE citation_number = ?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setFloat(1, fee);
			preparedStatement.setString(2, citationNumber);
			preparedStatement.executeUpdate();
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			close(connection);
		}
	}

	public void UpdateCitationPymntStatus(String citationNumber, String paymentStatus) throws SQLException {

		Connection connection = connectToDatabase(jdbcURL, user, pswd);
		try {
			String sql = "UPDATE citations SET payment_status = ? WHERE citation_number = ?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, paymentStatus);
			preparedStatement.setString(2, citationNumber);
			preparedStatement.executeUpdate();
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			close(connection);
		}
	}

	public void UpdateCitationCitationDate(String citationNumber, String citationDate) throws SQLException {

		Connection connection = connectToDatabase(jdbcURL, user, pswd);
		try {
			String sql = "UPDATE citations SET citation_date = ? WHERE citation_number = ?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, citationDate);
			preparedStatement.setString(2, citationNumber);
			preparedStatement.executeUpdate();
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			close(connection);
		}
	}

	public void UpdateCitationCitationTime(String citationNumber, String citationTime) throws SQLException {

		Connection connection = connectToDatabase(jdbcURL, user, pswd);
		try {
			String sql = "UPDATE citations SET citation_time = ? WHERE citation_number = ?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, citationTime);
			preparedStatement.setString(2, citationNumber);
			preparedStatement.executeUpdate();
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			close(connection);
		}
	}

	public void DeleteCitation(String citationNumber) throws SQLException {

		Connection connection = connectToDatabase(jdbcURL, user, pswd);
		try {
			String sql = "DELETE FROM citations WHERE citation_number = ?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, citationNumber);
			preparedStatement.executeUpdate();
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			close(connection);
		}
	}

	public void PayCitationFee(String citationNumber) throws SQLException {

		UpdateCitationPymntStatus(citationNumber, "PAID");
	}

	public ResultSet GetCitationReport(String startDate, String endDate) throws SQLException {

		Connection connection = connectToDatabase(jdbcURL, user, pswd);
		ResultSet result = null;
		try {
			String sql = "SELECT lot_name, count(*) as 'Num Citations' FROM citations" +
							"WHERE citation_date BETWEEN ? AND ? GROUP BY lot_name";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, startDate);
			preparedStatement.setString(2, endDate);
			result = preparedStatement.executeQuery();
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			close(connection);
		}

		return result;
	}

	public ResultSet GetViolatedCarsInfo(String startDate, String endDate) throws SQLException {

		Connection connection = connectToDatabase(jdbcURL, user, pswd);
		ResultSet result = null;
		try {
			String sql = "SELECT count(*) as 'Num Violated Cars' FROM citations" +
							"WHERE payment_status <> 'PAID'";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			result = preparedStatement.executeQuery();
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			close(connection);
		}

		return result;
	}

	private static Connection connectToDatabase(String jdbcURL, String user, String pswd)
			throws SQLException {
		Connection connection = null;
		try {
			connection = DriverManager.getConnection(jdbcURL, user, pswd);
		}
		catch (SQLException e){
			e.printStackTrace();
		}

		return connection;
	}
	
	private static void close(Connection conn) {
        if(conn != null) {
            try { conn.close(); } catch(Throwable whatever) {}
        }
    }

}
