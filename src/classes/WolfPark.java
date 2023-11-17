package classes;

import java.sql.SQLException;
import java.util.Scanner;

class WolfPark {

    public static void main(String[] args) throws SQLException {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            Menu.displayMainMenu();
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    handleDriverOperations();
                    break;
                case 2:
                    handleVehicleOperations();
                    break;
                case 3:
                    handlePermitOperations();
                    break;
                case 4:
                    handleParkingLotOperations();
                    break;
                case 5:
                    handleZoneOperations();
                    break;
                case 6:
                    handleSpaceOperations();
                case 7:
                    handleCitationOperations();
                    // Add cases for other operations as per the menu
                case 0:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
                    break;
            }
        } while (choice != 0);

        scanner.close();
    }

    private static void handleDriverOperations() throws SQLException {
        Scanner scanner = new Scanner(System.in);
        int choice;

        String driverId;
        String driverName;
        String driverStatus;
        String driverDisability;

        do {
            Menu.displayDriverMenu();
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.println("Adding driver...");
                    System.out.print("Enter driver ID: ");
                    driverId = scanner.nextLine();
                    System.out.print("Enter driver name: ");
                    driverName = scanner.nextLine();
                    System.out.print("Enter driver status: ");
                    driverStatus = scanner.nextLine();
                    System.out.print("Enter driver disability: ");
                    driverDisability = scanner.nextLine();
                    Driver.addDriver(driverId, driverName, driverStatus, driverDisability);
                    break;
                case 2:
                    System.out.println("Updating driver information...");
                    System.out.print("Enter driver ID to update: ");
                    driverId = scanner.nextLine();
                    System.out.print("Enter new driver name: ");
                    driverName = scanner.nextLine();
                    Driver.updateDriverInfo(driverId, driverName);
                    // Add more updates
                    break;
                case 3:
                    System.out.println("Deleting driver...");
                    System.out.print("Enter driver ID to delete: ");
                    driverId = scanner.nextLine();
                    Driver.deleteDriver(driverId);
                    break;
                case 4:
                    // Driver.getEmpPermCount();
                    break;
                case 0:
                    System.out.println("Exiting driver operations...");
                    Menu.displayMainMenu();
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
                    break;
            }
        } while (choice != 0);

        scanner.close();
    }

    private static void handleVehicleOperations() throws SQLException {
        Scanner scanner = new Scanner(System.in);
        int choice;

        String carLicenseNumber;
        String driverId;
        String model;
        String color;
        String manufacturer;
        int year;

        do {
            Menu.displayVehicleMenu();
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.println("Getting vehicle information...");
                    System.out.println("Enter car license number: ");
                    String driverID = scanner.nextLine();
                    Vehicles.GetVehicleInfo(driverID);
                    // Print Result
                    break;
                case 2:
                    System.out.println("Adding a new vehicle...");
                    System.out.print("Enter car license number: ");
                    carLicenseNumber = scanner.nextLine();
                    System.out.print("Enter driver ID: ");
                    driverId = scanner.nextLine();
                    System.out.print("Enter model: ");
                    model = scanner.nextLine();
                    System.out.print("Enter color: ");
                    color = scanner.nextLine();
                    System.out.print("Enter manufacturer: ");
                    manufacturer = scanner.nextLine();
                    System.out.print("Enter year: ");
                    year = scanner.nextInt();
                    scanner.nextLine();
                    Vehicles.AddVehicle(carLicenseNumber, driverId, model, color, manufacturer, year);
                    break;
                case 3:
                    System.out.println("Deleting a vehicle...");
                    System.out.print("Enter car license number of the vehicle to delete: ");
                    carLicenseNumber = scanner.nextLine();
                    Vehicles.DeleteVehicle(carLicenseNumber);
                    break;
                case 4:
                    System.out.println("Updating vehicle information...");
                    System.out.print("Enter car license number of the vehicle to update: ");
                    carLicenseNumber = scanner.nextLine();
                    System.out.print("Enter updated model: ");
                    model = scanner.nextLine();
                    System.out.print("Enter updated color: ");
                    color = scanner.nextLine();
                    System.out.print("Enter updated manufacturer: ");
                    manufacturer = scanner.nextLine();
                    System.out.print("Enter updated year: ");
                    year = scanner.nextInt();
                    scanner.nextLine();
                    // Sepearate Updates
                    Vehicles.UpdateVehicle(carLicenseNumber, model, color, manufacturer, year);
                    break;
                case 0:
                    System.out.println("Exiting vehicle operations...");
                    Menu.displayMainMenu();
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
                    break;
            }
        } while (choice != 0);

        scanner.close();
    }

    private static void handlePermitOperations() throws SQLException {
        Scanner scanner = new Scanner(System.in);
        int choice;

        String permitId;
        String lotName;
        String zoneId;
        String spaceType;
        String startDate;
        String expirationDate;
        String expirationTime;
        String driverId;
        String permitType;

        do {
            Menu.displayPermitMenu();
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.println("Creating a new permit...");
                    System.out.print("Enter permit ID: ");
                    permitId = scanner.nextLine();
                    System.out.print("Enter lot name: ");
                    lotName = scanner.nextLine();
                    System.out.print("Enter zone ID: ");
                    zoneId = scanner.nextLine();
                    System.out.print("Enter space type: ");
                    spaceType = scanner.nextLine();
                    System.out.print("Enter start date (YYYY-MM-DD): ");
                    startDate = scanner.nextLine();
                    System.out.print("Enter expiration date (YYYY-MM-DD): ");
                    expirationDate = scanner.nextLine();
                    System.out.print("Enter expiration time: ");
                    expirationTime = scanner.nextLine();
                    System.out.print("Enter driver ID: ");
                    driverId = scanner.nextLine();
                    System.out.print("Enter permit type: ");
                    permitType = scanner.nextLine();
                    Permits.CreatePermitInfo(permitId, lotName, zoneId, spaceType, startDate, expirationDate,
                            expirationTime, driverId, permitType);
                    break;
                case 2:
                    System.out.println("Updating permit information...");
                    System.out.print("Enter permit ID of the permit to update: ");
                    permitId = scanner.nextLine();
                    System.out.println("Enter updated permit information:");
                    System.out.print("Lot name: ");
                    lotName = scanner.nextLine();
                    System.out.print("Zone ID: ");
                    zoneId = scanner.nextLine();
                    System.out.print("Space type: ");
                    spaceType = scanner.nextLine();
                    System.out.print("Start date (YYYY-MM-DD): ");
                    startDate = scanner.nextLine();
                    System.out.print("Expiration date (YYYY-MM-DD): ");
                    expirationDate = scanner.nextLine();
                    System.out.print("Expiration time: ");
                    expirationTime = scanner.nextLine();
                    System.out.print("Driver ID: ");
                    driverId = scanner.nextLine();
                    System.out.print("Permit type: ");
                    permitType = scanner.nextLine();
                    // Separate Updates
                    Permits.UpdatePermitInfo(lotName, permitId);
                    break;
                case 3:
                    System.out.println("Deleting a permit...");
                    System.out.print("Enter permit ID of the permit to delete: ");
                    permitId = scanner.nextLine();
                    Permits.DeletePermitInfo(permitId);
                    break;
                case 4:
                    System.out.println("Getting permit information...");
                    System.out.print("Enter permit ID: ");
                    permitId = scanner.nextLine();
                    Permits.GetPermitInfo(permitId);
                    // Display Result
                    break;
                case 5:
                    System.out.println("Checking if the permit is valid...");
                    System.out.print("Enter permit ID: ");
                    permitId = scanner.nextLine();
                    boolean isValid = Permits.IsValidPermit(permitId);
                    // Method call needs to be fixed
                    break;
                case 0:
                    System.out.println("Exiting permit operations...");
                    Menu.displayMainMenu();
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
                    break;
            }
        } while (choice != 0);

        scanner.close();
    }

    private static void handleParkingLotOperations() throws SQLException {
        Scanner scanner = new Scanner(System.in);
        int choice;

        String lotName;
        String address;

        do {
            Menu.displayParkingLotMenu();
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.println("Adding parking lot...");
                    System.out.print("Enter lot name: ");
                    lotName = scanner.nextLine();
                    System.out.print("Enter address: ");
                    address = scanner.nextLine();
                    ParkingLot.addParkingLot(lotName, address);
                    break;
                case 2:
                    System.out.println("Updating lot information...");
                    System.out.print("Enter lot name to update: ");
                    lotName = scanner.nextLine();
                    System.out.print("Enter new address: ");
                    String newAddress = scanner.nextLine();
                    ParkingLot.updateParkingLotInfo(lotName, newAddress);
                    break;
                case 3:
                    System.out.println("Deleting lot...");
                    System.out.print("Enter lot name to delete: ");
                    lotName = scanner.nextLine();
                    ParkingLot.deleteParkingLot(lotName);
                    break;
                case 0:
                    System.out.println("Exiting parking lot operations...");
                    Menu.displayMainMenu();
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
                    break;
            }
        } while (choice != 0);

        scanner.close();
    }

    private static void handleZoneOperations() throws SQLException {
        Scanner scanner = new Scanner(System.in);
        int choice;

        String zoneId;
        String zoneName;

        do {
            Menu.displayZoneMenu();
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.println("Adding zone...");
                    System.out.print("Enter zone ID: ");
                    zoneId = scanner.nextLine();
                    System.out.print("Enter zone name: ");
                    zoneName = scanner.nextLine();
                    Zone.addZone(zoneId);
                    break;
                case 2:
                    System.out.println("Updating zone information...");
                    System.out.print("Enter zone ID to update: ");
                    zoneId = scanner.nextLine();
                    System.out.print("Enter new zone name: ");
                    zoneName = scanner.nextLine();
                    Zone.updateZoneInfo(zoneId, zoneName);
                    break;
                case 3:
                    System.out.println("Deleting zone...");
                    System.out.print("Enter zone ID to delete: ");
                    zoneId = scanner.nextLine();
                    Zone.deleteZone(zoneId);
                    break;
                case 4:
                    System.out.println("Getting zone information...");
                    System.out.print("Enter zone ID to get information: ");
                    zoneId = scanner.nextLine();
                    Zone.getZoneInfo(zoneId);
                    // Display Results
                    break;
                case 0:
                    System.out.println("Exiting zone operations...");
                    Menu.displayMainMenu();
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
                    break;
            }
        } while (choice != 0);

        scanner.close();
    }

    private static void handleSpaceOperations() throws SQLException {
        Scanner scanner = new Scanner(System.in);
        int choice;

        int spaceNumber;
        String spaceType;
        String lotName;

        do {
            Menu.displaySpaceMenu();
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.println("Adding space...");
                    System.out.print("Enter space number: ");
                    spaceNumber = scanner.nextInt();
                    System.out.print("Enter space type: ");
                    spaceType = scanner.nextLine();
                    Space.addSpace(spaceNumber, spaceType);
                    break;
                case 2:
                    System.out.println("Updating space information...");
                    System.out.print("Enter space number to update: ");
                    spaceNumber = scanner.nextInt();
                    System.out.print("Enter new space type: ");
                    spaceType = scanner.nextLine();
                    Space.updateSpaceInfo(spaceNumber, spaceType);
                    break;
                case 3:
                    System.out.println("Deleting space...");
                    System.out.print("Enter space number to delete: ");
                    spaceNumber = scanner.nextInt();
                    Space.deleteSpace(spaceNumber);
                    break;
                case 4:
                    System.out.println("Getting space information...");
//                    System.out.print("Enter space number: ");
//                    spaceNumber = scanner.nextInt();
                    System.out.print("Enter lot name: ");
                    //scanner.next();
                    lotName = scanner.nextLine();
                    System.out.print("Enter space number: ");
                    spaceNumber = scanner.nextInt();
                    Space.getAvailableSpace(spaceNumber, lotName);
                    // Display Result
                    break;
                case 0:
                    System.out.println("Exiting space operations...");
                    Menu.displayMainMenu();
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
                    break;
            }
        } while (choice != 0);

        scanner.close();
    }

    private static void handleCitationOperations() {
        Scanner scanner = new Scanner(System.in);
        int choice;

        // Citation citation = new Citation();

        do {
            Menu.displayCitationMenu();
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    // updateCitationPaymentStatus
                    break;
                case 2:
                    // generateCitation
                    break;
                case 3:
                    // updateCitation
                    break;
                case 4:
                    // payCitationFee
                    break;
                case 5:
                    // getCitationReport
                    break;
                case 6:
                    // getViolatedCarsInfo
                    break;
                case 0:
                    System.out.println("Exiting citation operations...");
                    Menu.displayMainMenu();
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
                    break;
            }
        } while (choice != 0);

        scanner.close();
    }

}
