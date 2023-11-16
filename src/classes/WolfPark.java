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

    private static void handleDriverOperations() {
        Scanner scanner = new Scanner(System.in);
        int choice;

        // Driver driver = new Driver();

        do {
            Menu.displayDriverMenu();
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    // enterDriverInfo
                    break;
                case 2:
                    // updateDriverInfo
                    break;
                case 3:
                    // deleteDriverInfo
                    break;
                case 4:
                    // getEmpPermCount
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
                    System.out.println("Getting vehicle info...");
                    System.out.println("Enter Driver ID: ");
                    String driverID = scanner.nextLine();
                    Vehicles.GetVehicleInfo(driverID);
                    // Print result
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

        do {
            Menu.displayPermitMenu();
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            Permits permit = new Permits();

            // ASK USER FOR INPUT
            switch (choice) {
                case 1:
                    permit.CreatePermitInfo();
                    break;
                case 2:
                    permit.UpdatePermitInfo("null", "null");
                    break;
                case 3:
                    permit.DeletePermitInfo("null");
                    break;
                case 4:
                    permit.GetPermitInfo("null");
                    break;
                case 5:
                    permit.IsValidPermit("null");
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

    private static void handleParkingLotOperations() {
        Scanner scanner = new Scanner(System.in);
        int choice;

        // ParkingLot lot = new ParkingLot();

        do {
            Menu.displayParkingLotMenu();
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    // enterParkingLotInfo
                    break;
                case 2:
                    // updateParkingLotInfo
                    break;
                case 3:
                    // deleteParkingLotInfo
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

    private static void handleZoneOperations() {
        Scanner scanner = new Scanner(System.in);
        int choice;

        // Zone zone = new Zone();

        do {
            Menu.displayZoneMenu();
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    // enterZoneInfo
                    break;
                case 2:
                    // updateZoneInfo
                    break;
                case 3:
                    // deleteZoneInfo
                    break;
                case 4:
                    // getZoneInfo
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

    private static void handleSpaceOperations() {
        Scanner scanner = new Scanner(System.in);
        int choice;

        // Space space = new Space();

        do {
            Menu.displaySpaceMenu();
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    // enterSpaceInfo
                    break;
                case 2:
                    // updateSpaceInfo
                    break;
                case 3:
                    // deleteSpaceInfo
                    break;
                case 4:
                    // getAvailableSpace
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
