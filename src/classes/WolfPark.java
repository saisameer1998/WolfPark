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
                    break;
                case 7:
                    handleCitationOperations();
                    break;
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
        String lotName;

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
                    System.out.println("What do you want to update: ");
                    Menu.displayDriverUpdateMenu();
                    int choice2 = scanner.nextInt();

                    switch (choice2) {
                        case 1:
                            System.out.println("Updating driver name...");
                            System.out.print("Enter driver ID to update: ");
                            driverId = scanner.nextLine();
                            System.out.print("Enter new driver name: ");
                            driverName = scanner.nextLine();
                            Driver.updateDriverName(driverId, driverName);
                            break;
                        case 2:
                            System.out.println("Updating driver status...");
                            System.out.print("Enter driver ID to update: ");
                            driverId = scanner.nextLine();
                            System.out.print("Enter new driver status: ");
                            driverStatus = scanner.nextLine();
                            Driver.updateDriverStatus(driverId, driverStatus);
                            break;
                        case 3:
                            System.out.println("Updating driver disability...");
                            System.out.print("Enter driver ID to update: ");
                            driverId = scanner.nextLine();
                            System.out.print("Enter new driver disability: ");
                            driverDisability = scanner.nextLine();
                            Driver.updateDriverDisability(driverId, driverDisability);
                            break;
                        case 0:
                            System.out.println("Exiting driver update operations...");
                            Menu.displayDriverMenu();
                            break;
                        default:
                            System.out.println("Invalid choice. Please enter a valid option.");
                            break;
                    }
                    break;
                case 3:
                    System.out.println("Deleting driver...");
                    System.out.print("Enter driver ID to delete: ");
                    driverId = scanner.nextLine();
                    Driver.deleteDriver(driverId);
                    break;
                case 4:
                    System.out.println("Getting employee permit count");
                    System.out.println("Enter Lot name");
                    lotName = scanner.nextLine();
                    System.out.println("Enter Driver Status");
                    driverStatus = scanner.nextLine();
                    Driver.getEmpPermCount(lotName, driverStatus);
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
                    driverId = scanner.nextLine();
                    Vehicles.GetVehicleInfo(driverId);
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
                    System.out.println("What do you want to update: ");
                    Menu.displayVehicleUpdateMenu();
                    int choice2 = scanner.nextInt();

                    switch (choice2) {
                        case 1:
                            System.out.println("Updating driver ID...");
                            System.out.print("Enter car license number of the vehicle to update: ");
                            carLicenseNumber = scanner.nextLine();
                            System.out.print("Enter updated driver ID: ");
                            driverId = scanner.nextLine();
                            Vehicles.updateVehicleDriverId(carLicenseNumber, driverId);
                            break;
                        case 2:
                            System.out.println("2. Updating vehicle model...");
                            System.out.print("Enter car license number of the vehicle to update: ");
                            carLicenseNumber = scanner.nextLine();
                            System.out.print("Enter updated vehicle model: ");
                            model = scanner.nextLine();
                            Vehicles.updateVehicleModel(carLicenseNumber, model);
                            break;
                        case 3:
                            System.out.println("3. Updating vehicle color...");
                            System.out.print("Enter car license number of the vehicle to update: ");
                            carLicenseNumber = scanner.nextLine();
                            System.out.print("Enter updated vehicle color: ");
                            color = scanner.nextLine();
                            Vehicles.updateVehicleColor(carLicenseNumber, color);
                            break;
                        case 4:
                            System.out.println("4. Updating vehicle manufacturer...");
                            System.out.print("Enter car license number of the vehicle to update: ");
                            carLicenseNumber = scanner.nextLine();
                            System.out.print("Enter updated vehicle manufacturer: ");
                            manufacturer = scanner.nextLine();
                            Vehicles.updateVehicleManufacturer(carLicenseNumber, manufacturer);
                            break;
                        case 5:
                            System.out.println("6. Updating vehicle year...");
                            System.out.print("Enter car license number of the vehicle to update: ");
                            carLicenseNumber = scanner.nextLine();
                            System.out.print("Enter updated vehicle year: ");
                            year = scanner.nextInt();
                            Vehicles.updateVehicleYear(carLicenseNumber, year);
                            break;
                        case 0:
                            System.out.println("Exiting vehicle update operations...");
                            Menu.displayVehicleMenu();
                            break;
                        default:
                            System.out.println("Invalid choice. Please enter a valid option.");
                            break;
                    }
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
                    System.out.println("What do you want to update: ");
                    Menu.displayDriverUpdateMenu();
                    int choice2 = scanner.nextInt();

                    switch (choice2) {
                        case 1:
                            System.out.println("Updating lot name...");
                            System.out.print("Enter permit ID of the permit to update: ");
                            permitId = scanner.nextLine();
                            System.out.print("Lot name: ");
                            lotName = scanner.nextLine();
                            Permits.UpdatePermitLotName(lotName, permitId);
                            break;
                        case 2:
                            System.out.println("Updating zone ID...");
                            System.out.print("Enter permit ID of the permit to update: ");
                            permitId = scanner.nextLine();
                            System.out.print("Zone ID: ");
                            zoneId = scanner.nextLine();
                            Permits.UpdatePermitZoneID(zoneId, permitId);
                            break;
                        case 3:
                            System.out.println("Updating space type...");
                            System.out.print("Enter permit ID of the permit to update: ");
                            permitId = scanner.nextLine();
                            System.out.print("Space type: ");
                            spaceType = scanner.nextLine();
                            Permits.UpdatePermitSpaceType(spaceType, permitId);
                            break;
                        case 4:
                            System.out.println("Updating start date...");
                            System.out.print("Enter permit ID of the permit to update: ");
                            permitId = scanner.nextLine();
                            System.out.print("Start date (YYYY-MM-DD): ");
                            startDate = scanner.nextLine();
                            Permits.UpdatePermitStartDate(startDate, permitId);
                            break;
                        case 5:
                            System.out.println("Updating expiration date...");
                            System.out.print("Enter permit ID of the permit to update: ");
                            permitId = scanner.nextLine();
                            System.out.print("Expiration date (YYYY-MM-DD): ");
                            expirationDate = scanner.nextLine();
                            Permits.UpdatePermitExpirationDate(expirationDate, permitId);
                            break;
                        case 6:
                            System.out.println("Updating expiration time...");
                            System.out.print("Enter permit ID of the permit to update: ");
                            permitId = scanner.nextLine();
                            System.out.print("Expiration time: ");
                            expirationTime = scanner.nextLine();
                            Permits.UpdatePermitExpirationTime(expirationTime, permitId);
                            break;
                        case 7:
                            System.out.println("Updating driver ID...");
                            System.out.print("Enter permit ID of the permit to update: ");
                            permitId = scanner.nextLine();
                            System.out.print("Driver ID: ");
                            driverId = scanner.nextLine();
                            Permits.UpdatePermitDriverId(driverId, permitId);
                            break;
                        case 8:
                            System.out.println("Updating permit type...");
                            System.out.print("Enter permit ID of the permit to update: ");
                            permitId = scanner.nextLine();
                            System.out.print("Permit type: ");
                            permitType = scanner.nextLine();
                            Permits.UpdatePermitPermitType(permitType, permitId);
                            break;
                        case 0:
                            System.out.println("Exiting permit update operations...");
                            Menu.displayPermitMenu();
                            break;
                        default:
                            System.out.println("Invalid choice. Please enter a valid option.");
                            break;
                    }
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
                    break;
                case 5:
                    System.out.println("Checking if the permit is valid...");
                    System.out.print("Enter permit ID: ");
                    permitId = scanner.nextLine();
                    boolean isValid = Permits.IsValidPermit(permitId);
                    // FIX METHOD CALL
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
                    System.out.println("Updating lot address...");
                    System.out.print("Enter lot name to update: ");
                    lotName = scanner.nextLine();
                    System.out.print("Enter new address: ");
                    String newAddress = scanner.nextLine();
                    ParkingLot.updateParkingLotAddress(lotName, newAddress);
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
                    System.out.println("Deleting zone...");
                    System.out.print("Enter zone ID to delete: ");
                    zoneId = scanner.nextLine();
                    Zone.deleteZone(zoneId);
                    break;
                case 3:
                    System.out.println("Getting zone information...");
                    System.out.print("Enter zone ID to get information: ");
                    zoneId = scanner.nextLine();
                    Zone.getZoneInfo(zoneId);
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
                    Space.updateSpaceType(spaceNumber, spaceType);
                    break;
                case 3:
                    System.out.println("Deleting space...");
                    System.out.print("Enter space number to delete: ");
                    spaceNumber = scanner.nextInt();
                    Space.deleteSpace(spaceNumber);
                    break;
                case 4:
                    System.out.println("Getting space information...");
                    // System.out.print("Enter space number: ");
                    // spaceNumber = scanner.nextInt();
                    System.out.print("Enter lot name: ");
                    // scanner.next();
                    lotName = scanner.nextLine();
                    System.out.print("Enter space number: ");
                    spaceNumber = scanner.nextInt();
                    Space.getAvailableSpace(spaceNumber, lotName);
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

    private static void handleCitationOperations() throws SQLException {
        Scanner scanner = new Scanner(System.in);
        int choice;

        String citationNumber;
        String carLicenseNumber;
        String lotName;
        String category;
        float fee;
        String paymentStatus;
        String startDate;
        String endDate;
        String citationDate;
        String citationTime;

        do {
            Menu.displayCitationMenu();
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.println("Generating citation...");
                    System.out.print("Enter citation number: ");
                    citationNumber = scanner.nextLine();
                    System.out.print("Enter car license number: ");
                    carLicenseNumber = scanner.nextLine();
                    System.out.print("Enter lot name: ");
                    lotName = scanner.nextLine();
                    System.out.print("Enter category: ");
                    category = scanner.nextLine();
                    System.out.print("Enter fee: ");
                    fee = scanner.nextFloat();
                    scanner.nextLine();
                    System.out.print("Enter payment status: ");
                    paymentStatus = scanner.nextLine();
                    Citation.generateCitation(citationNumber, carLicenseNumber, lotName, category, fee, paymentStatus);
                    break;
                case 2:
                    System.out.println("What do you want to update: ");
                    Menu.displayCitationUpdateMenu();
                    int choice2 = scanner.nextInt();

                    switch (choice2) {
                        case 1:
                            System.out.println("Updating citation car license number...");
                            System.out.print("Enter citation number: ");
                            citationNumber = scanner.nextLine();
                            System.out.print("Enter new car license number: ");
                            carLicenseNumber = scanner.nextLine();
                            Citation.updateCitationCarLsncNum(citationNumber, carLicenseNumber);
                            break;
                        case 2:
                            System.out.println("Updating citation lot name...");
                            System.out.print("Enter citation number: ");
                            citationNumber = scanner.nextLine();
                            System.out.print("Enter new lot name: ");
                            lotName = scanner.nextLine();
                            Citation.updateCitationLotName(citationNumber, lotName);
                            break;
                        case 3:
                            System.out.println("Updating citation category...");
                            System.out.print("Enter citation number: ");
                            citationNumber = scanner.nextLine();
                            System.out.print("Enter new category: ");
                            category = scanner.nextLine();
                            Citation.updateCitationCategory(citationNumber, category);
                            break;
                        case 4:
                            System.out.println("Updating citation fee...");
                            System.out.print("Enter citation number: ");
                            citationNumber = scanner.nextLine();
                            System.out.print("Enter new fee: ");
                            fee = scanner.nextFloat();
                            scanner.nextLine();
                            Citation.updateCitationFee(citationNumber, fee);
                            break;
                        case 5:
                            System.out.println("Updating citation payment status...");
                            System.out.print("Enter citation number: ");
                            citationNumber = scanner.nextLine();
                            System.out.print("Enter new payment status: ");
                            paymentStatus = scanner.nextLine();
                            Citation.updateCitationPymntStatus(citationNumber, paymentStatus);
                            break;
                        case 6:
                            System.out.println("Updating citation date...");
                            System.out.print("Enter citation number: ");
                            citationNumber = scanner.nextLine();
                            System.out.print("Enter new citation date (yyyy-MM-dd): ");
                            citationDate = scanner.nextLine();
                            Citation.updateCitationDate(citationNumber, citationDate);
                            break;
                        case 7:
                            System.out.println("Updating citation time...");
                            System.out.print("Enter citation number: ");
                            citationNumber = scanner.nextLine();
                            System.out.print("Enter new citation time (hh:mm:ss): ");
                            citationTime = scanner.nextLine();
                            Citation.updateCitationTime(citationNumber, citationTime);
                            break;
                        case 0:
                            System.out.println("Exiting citation update operations...");
                            Menu.displayCitationMenu();
                            break;
                        default:
                            System.out.println("Invalid choice. Please enter a valid option.");
                            break;
                    }
                    break;
                case 3:
                    System.out.println("Deleting citation...");
                    System.out.print("Enter citation number to delete: ");
                    citationNumber = scanner.nextLine();
                    Citation.deleteCitation(citationNumber);
                    break;
                case 4:
                    System.out.println("Getting citation report: ");
                    System.out.print("Enter start date (yyyy-MM-dd): ");
                    startDate = scanner.nextLine();
                    System.out.print("Enter end date (yyyy-MM-dd): ");
                    endDate = scanner.nextLine();
                    Citation.getCitationReport(startDate, endDate);
                    break;
                case 5:
                    System.out.println("Getting violated cars information...");
                    System.out.print("Enter start date (yyyy-MM-dd): ");
                    startDate = scanner.nextLine();
                    System.out.print("Enter end date (yyyy-MM-dd): ");
                    endDate = scanner.nextLine();
                    Citation.getViolatedCarsInfo(startDate, endDate);
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
