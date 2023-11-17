package classes;

public class Menu {

    public static void clearScreen() {
        // System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public static void displayMainMenu() {
        clearScreen();
        System.out.println("\n===== Parking Management System Menu =====");
        System.out.println("1. Driver Operations");
        System.out.println("2. Vehicle Operations");
        System.out.println("3. Permit Operations");
        System.out.println("4. Parking Lot Operations");
        System.out.println("5. Zone Operations");
        System.out.println("6. Space Operations");
        System.out.println("7. Citation Operations");
        System.out.println("0. Exit");
    }

    public static void displayDriverMenu() {
        clearScreen();
        System.out.println("\n===== Driver Operations Menu =====");
        System.out.println("1. Enter Driver Information");
        System.out.println("2. Update Driver Information");
        System.out.println("3. Delete Driver Information");
        System.out.println("4. Get Employee Permit Count");
        System.out.println("5. Pay Citation Fee");
        System.out.println("6. Appeal Citation");
        System.out.println("7. Get Driver Information");
        System.out.println("0. Go back to main menu");
    }

    public static void displayDriverUpdateMenu() {
        clearScreen();
        System.out.println("\n===== Driver Update Operations Menu =====");
        System.out.println("1. Update Driver Name");
        System.out.println("2. Update Driver Status");
        System.out.println("3. Update Driver Disability");
        System.out.println("0. Go back to Driver Menu");
    }

    public static void displayVehicleMenu() {
        clearScreen();
        System.out.println("\n===== Vehicle Operations Menu =====");
        System.out.println("1. Get Vehicle Information");
        System.out.println("2. Add a Vehicle");
        System.out.println("3. Delete a Vehicle");
        System.out.println("4. Update Vehicle Information");
        System.out.println("0. Go back to main menu");
    }

    public static void displayVehicleUpdateMenu() {
        clearScreen();
        System.out.println("\n===== Vehicle Update Operations Menu =====");
        System.out.println("1. Update Driver ID");
        System.out.println("2. Update Vehicle Model");
        System.out.println("3. Update Vehicle Color");
        System.out.println("4. Update Vehicle Manufacturer");
        System.out.println("6. Update Vehicle Year");
        System.out.println("0. Go back to Vehicle Menu");
    }

    public static void displayPermitMenu() {
        clearScreen();
        System.out.println("\n===== Permit Operations Menu =====");
        System.out.println("1. Create Permit Information");
        System.out.println("2. Update Permit Information");
        System.out.println("3. Delete Permit Information");
        System.out.println("4. Get Permit Information");
        System.out.println("5. Check Validity of Permit");
        System.out.println("0. Go back to Main Menu");
    }

    public static void displayPermitUpdateMenu() {
        clearScreen();
        System.out.println("\n===== Permit Update Operations Menu =====");
        System.out.println("1. Update Lot Name");
        System.out.println("2. Update Zone ID");
        System.out.println("3. Update Space Type");
        System.out.println("4. Update Start Date");
        System.out.println("6. Update Expiration Date");
        System.out.println("7. Update Expiration Time");
        System.out.println("8. Update Driver ID");
        System.out.println("9. Update Permit Type");
        System.out.println("0. Go back to Permit Menu");
    }

    public static void displayParkingLotMenu() {
        clearScreen();
        System.out.println("\n===== Parking Lot Operations Menu =====");
        System.out.println("1. Enter Parking Lot Information");
        System.out.println("2. Update Parking Lot Address");
        System.out.println("3. Delete Parking Lot Information");
        System.out.println("0. Go back to Main Menu");
    }

    public static void displayZoneMenu() {
        clearScreen();
        System.out.println("\n===== Zone Operations Menu =====");
        System.out.println("1. Enter Zone Information");
        System.out.println("2. Delete Zone Information");
        System.out.println("3. Get Zone Information");
        System.out.println("4. Get Assigned Zones");
        System.out.println("0. Go back to Main Menu");
    }

    public static void displaySpaceMenu() {
        clearScreen();
        System.out.println("\n===== Space Operations Menu =====");
        System.out.println("1. Enter Space Information");
        System.out.println("2. Update Space Type");
        System.out.println("3. Delete Space Information");
        System.out.println("4. Get Available Space");
        System.out.println("5. Get Space Type Availability in Lot");
        System.out.println("0. Go back to Main Menu");
    }

    public static void displayCitationMenu() {
        clearScreen();
        System.out.println("\n===== Citation Operations Menu =====");
        System.out.println("1. Generate Citation");
        System.out.println("2. Update Citation");
        System.out.println("3. Delete Citation");
        System.out.println("4. Get Citation Report");
        System.out.println("5. Get Violated Cars Information");
        System.out.println("0. Go back to main menu");
    }

    public static void displayCitationUpdateMenu() {
        clearScreen();
        System.out.println("\n===== Update Citation Operations Menu =====");
        System.out.println("1. Update Citation Car License Number");
        System.out.println("2. Update Citation Lot Name");
        System.out.println("3. Update Citation Category");
        System.out.println("4. Update Citation Fee");
        System.out.println("5. Update Citation Payment Status");
        System.out.println("6. Update Citation Citation Date");
        System.out.println("7. Update Citation Citation Time");
        System.out.println("0. Go back to main menu");
    }

}
