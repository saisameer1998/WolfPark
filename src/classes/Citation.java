/**
 * The Citation class provides methods to interact with a MariaDB database
 * to manage and retrieve information related to parking citations.
 * It extends the WolfPark class, indicating a potential inheritance relationship.
 */

package classes;

import java.sql.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Citation extends WolfPark {

	// Database connection details
	static String jdbcURL = "jdbc:mariadb://classdb2.csc.ncsu.edu:3306/sguttha";
	static String user = "sguttha";
	static String pswd = "Maria@MegaMind1";

	public static void generateCitation(String citationNumber, String carLicenseNumber, String lotName,
			String category, float fee, String paymentStatus) throws SQLException {
		/**
     		* Generates a new citation entry in the database with the specified details.
     		*
     		* @param citationNumber    The unique identifier for the citation.
     		* @param carLicenseNumber  The license number of the cited vehicle.
     		* @param lotName           The name of the parking lot where the citation occurred.
     		* @param category          The category of the citation.
     		* @param fee               The fee associated with the citation.
    	 	* @param paymentStatus     The payment status of the citation.
     		* @throws SQLException     If a database access error occurs.
     		*/

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
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(connection);
		}
	}

	public static void updateCitationCarLsncNum(String citationNumber, String carLicenseNumber) throws SQLException {
		/**
     		* Updates the license number of a citation in the database.
     		*
     		* @param citationNumber    The unique identifier for the citation.
     		* @param carLicenseNumber  The new license number for the cited vehicle.
     		* @throws SQLException     If a database access error occurs.
     		*/

		Connection connection = connectToDatabase(jdbcURL, user, pswd);
		try {
			String sql = "UPDATE citations SET car_license_number = ? WHERE citation_number = ?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, carLicenseNumber);
			preparedStatement.setString(2, citationNumber);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(connection);
		}
	}

	public static void updateCitationLotName(String citationNumber, String lotName) throws SQLException {
		/**
     		* Updates the lot name of a citation in the database.
     		*
     		* @param citationNumber    The unique identifier for the citation.
     		* @param lotName           The new lot name for the cited vehicle.
     		* @throws SQLException     If a database access error occurs.
     		*/

		Connection connection = connectToDatabase(jdbcURL, user, pswd);
		try {
			String sql = "UPDATE citations SET lot_name = ? WHERE citation_number = ?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, lotName);
			preparedStatement.setString(2, citationNumber);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(connection);
		}
	}

	public static void updateCitationCategory(String citationNumber, String category) throws SQLException {
		/**
     		* Updates the category of a citation in the database.
     		*
     		* @param citationNumber    The unique identifier for the citation.
     		* @param category          The new category for the cited vehicle.
     		* @throws SQLException     If a database access error occurs.
     		*/

		Connection connection = connectToDatabase(jdbcURL, user, pswd);
		try {
			String sql = "UPDATE citations SET category = ? WHERE citation_number = ?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, category);
			preparedStatement.setString(2, citationNumber);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(connection);
		}
	}

	public static void updateCitationFee(String citationNumber, float fee) throws SQLException {
		/**
     		* Updates the fee of a citation in the database.
     		*
     		* @param citationNumber    The unique identifier for the citation.
     		* @param fee               The new fee for the cited vehicle.
     		* @throws SQLException     If a database access error occurs.
     		*/

		Connection connection = connectToDatabase(jdbcURL, user, pswd);
		try {
			String sql = "UPDATE citations SET fee = ? WHERE citation_number = ?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setFloat(1, fee);
			preparedStatement.setString(2, citationNumber);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(connection);
		}
	}

	public static void updateCitationPymntStatus(String citationNumber, String paymentStatus) throws SQLException {
		/**
     		* Updates the payment status of a citation in the database.
     		*
     		* @param citationNumber    The unique identifier for the citation.
     		* @param paymentStatus     The new payment status for the cited vehicle.
     		* @throws SQLException     If a database access error occurs.
     		*/

		Connection connection = connectToDatabase(jdbcURL, user, pswd);
		try {
			String sql = "UPDATE citations SET payment_status = ? WHERE citation_number = ?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, paymentStatus);
			preparedStatement.setString(2, citationNumber);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(connection);
		}
	}

	public static void updateCitationDate(String citationNumber, String citationDate) throws SQLException {
		/**
     		* Updates the citation date of a citation in the database.
     		*
     		* @param citationNumber    The unique identifier for the citation.
     		* @param citationDate      The new citation date for the cited vehicle.
     		* @throws SQLException     If a database access error occurs.
     		*/

		Connection connection = connectToDatabase(jdbcURL, user, pswd);
		try {
			String sql = "UPDATE citations SET citation_date = ? WHERE citation_number = ?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, citationDate);
			preparedStatement.setString(2, citationNumber);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(connection);
		}
	}

	public static void updateCitationTime(String citationNumber, String citationTime) throws SQLException {
		/**
     		* Updates the citation time of a citation in the database.
     		*
     		* @param citationNumber    The unique identifier for the citation.
     		* @param citationTime      The new citation time for the cited vehicle.
     		* @throws SQLException     If a database access error occurs.
     		*/

		Connection connection = connectToDatabase(jdbcURL, user, pswd);
		try {
			String sql = "UPDATE citations SET citation_time = ? WHERE citation_number = ?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, citationTime);
			preparedStatement.setString(2, citationNumber);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(connection);
		}
	}

	public static void deleteCitation(String citationNumber) throws SQLException {
		/**
     		* Deletes a citation entry from the database.
     		*
     		* @param citationNumber    The unique identifier for the citation to be deleted.
     		* @throws SQLException     If a database access error occurs.
     		*/

		Connection connection = connectToDatabase(jdbcURL, user, pswd);
		try {
			String sql = "DELETE FROM citations WHERE citation_number = ?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, citationNumber);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(connection);
		}
	}

	public static void payCitationFee(String citationNumber) throws SQLException {
		/**
 		* Updates the payment status of a citation to "PAID" in the database.
 		*
 		* This method takes a citation number as a parameter and calls the updateCitationPymntStatus method to set the payment 
 		* status to "PAID"
		* @param citationNumber    The unique identifier for the citation to be marked as paid.
		* @throws SQLException     If a database access error occurs.
 		*/

		updateCitationPymntStatus(citationNumber, "PAID");
	}

	public static void appealCitationFee(String citationNumber) throws SQLException {
		/**
 		* Updates the payment status of a citation to "APPEAL" in the database.
 		*
 		* This method takes a citation number as a parameter and calls the updateCitationPymntStatus method to set the payment 
 		* status to "APPEAL"
		* @param citationNumber    The unique identifier for the citation to be marked as paid.
		* @throws SQLException     If a database access error occurs.
 		*/

		updateCitationPymntStatus(citationNumber, "APPEAL");
	}

	public static void getCitationReport(String startDate, String endDate) throws SQLException {
		/**
     		* Retrieves a citation report for a specified date range and prints the information.
     		*
     		* @param startDate         The start date of the report.
     		* @param endDate           The end date of the report.
     		* @throws SQLException     If a database access error occurs.
     		*/

		Connection connection = connectToDatabase(jdbcURL, user, pswd);
		ResultSet result = null;
		try {
			String sql = "SELECT lot_name, count(*) as 'Num Citations' FROM citations" +
					"WHERE citation_date BETWEEN ? AND ? GROUP BY lot_name";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, startDate);
			preparedStatement.setString(2, endDate);
			result = preparedStatement.executeQuery();
			while (result.next()) {
				String lotName = result.getString("lot_name");
				int numCitations = result.getInt("Num Citations");

				System.out.println("Lot Name: " + lotName);
				System.out.println("Number of Citations: " + numCitations);
				System.out.println("--------------------------");
        		}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(connection);
		}

		return result;
	}

	public static void getViolatedCarsInfo(String startDate, String endDate) throws SQLException {
		/**
     		* Retrieves information about violated cars within a specified date range and prints the information.
     		*
     		* @param startDate         The start date of the violation report.
     		* @param endDate           The end date of the violation report.
     		* @throws SQLException     If a database access error occurs.
     		*/

		Connection connection = connectToDatabase(jdbcURL, user, pswd);
		ResultSet result = null;
		try {
			String sql = "SELECT count(*) as 'Num Violated Cars' FROM citations" +
					"WHERE payment_status <> 'PAID'";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			result = preparedStatement.executeQuery();
			while (result.next()) {
				int numViolatedCars = result.getInt("Num Violated Cars");

				System.out.println("Number of Violated Cars: " + numViolatedCars);
				System.out.println("--------------------------");
        		}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(connection);
		}

		return result;
	}

	private static Connection connectToDatabase(String jdbcURL, String user, String pswd)
			throws SQLException {
		/**
     		* Establishes a connection to the MariaDB database.
     		*
     		* @param jdbcURL   The JDBC URL for the database.
     		* @param user      The username for database access.
     		* @param pswd      The password for database access.
     		* @return          A Connection object representing the database connection.
     		* @throws SQLException     If a database access error occurs.
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
     		* Closes the given database connection.
     		*
     		* @param conn  The Connection object to be closed.
     		*/

		if (conn != null) {
			try {
				conn.close();
			} catch (Throwable whatever) {
			}
		}
	}

}
