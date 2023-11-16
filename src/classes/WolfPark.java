package classes;

import java.sql.Driver;
import java.sql.SQLException;
import java.util.Scanner;

class WolfPark {

    public static void main(String[] args) throws SQLException {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            menu.displayMainMenu();
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
            menu.displayDriverMenu();
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
                    menu.displayMainMenu();
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
                    break;
            }
        } while (choice != 0);

        scanner.close();
    }

    private static void handleVehicleOperations() {
        Scanner scanner = new Scanner(System.in);
        int choice;

        Vehicles vehicles = new Vehicles();

        do {
            menu.displayVehicleMenu();
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    vehicles.GetVehicleInfo("null");
                    break;
                case 2:
                    vehicles.AddVehicle("null", "null", "null", "null", "null", 0);
                    break;
                case 3:
                    vehicles.DeleteVehicle("null");
                    break;
                case 4:
                    vehicles.UpdateVehicle("null", "null", "null", "null", 0);
                    break;
                case 0:
                    System.out.println("Exiting vehicle operations...");
                    menu.displayMainMenu();
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
            menu.displayPermitMenu();
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
                    menu.displayMainMenu();
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

        do {
            menu.displayParkingLotMenu();
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

        do {
            menu.displayZoneMenu();
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline left after nextInt()

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
                    menu.displayMainMenu();
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

        do {
            menu.displaySpaceMenu();
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline left after nextInt()

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
                    menu.displayMainMenu();
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

        do {
            menu.displayCitationMenu();
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline left after nextInt()

            switch (choice) {
                case 1:
                    //updateCitationPaymentStatus
                    break;
                case 2:
                    //generateCitation
                    break;
                case 3:
                    //updateCitation
                    break;
                case 4:
                    //payCitationFee
                    break;
                case 5:
                    //getCitationReport
                    break;
                case 6:
                    //getViolatedCarsInfo
                    break;
                case 0:
                    System.out.println("Exiting citation operations...");
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
                    break;
            }
        } while (choice != 0);

        scanner.close();
    }

}
