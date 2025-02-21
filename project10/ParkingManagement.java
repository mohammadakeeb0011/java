/*
import java.util.Scanner;

class Person {
    private String job;
    private String vehicleNumber;

    public Person(String j, String v) {
        job = j;
        vehicleNumber = v;
    }

    public void DisplayPer() {
        System.out.println("Job      : " + job);
        System.out.println("Vehicle Number: " + vehicleNumber);
    }

    public void setPer() {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter job of Person (student, teaching, emergency, VIP): ");
        job = scan.nextLine();
        System.out.print("Enter vehicle number: ");
        vehicleNumber = scan.nextLine();
    }

    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public String getJob() {
        return job;
    }
}

class Slot {
    private boolean status;
    private Person personObj;

    public Slot() {
        status = false; // Initially unoccupied
        personObj = null;
    }

    public boolean checkStatus() {
        return status;
    }

    public void setStatus(boolean s, Person obj) {
        status = s;
        personObj = obj;
    }

    public Person getPerson() {
        return personObj;
    }

    public void DisplaySlot() {
        String a = (status) ? "Occupied" : "Unoccupied";
        System.out.println("Status   : " + a);
        if (status && personObj != null) {
            System.out.println("Person Details:");
            personObj.DisplayPer();
        }
    }
}

public class ParkingManagement {
    private static Slot[] vipSlots = new Slot[7]; 
    private static Slot[] studentSlots = new Slot[54];
    private static Slot[] teachingSlots = new Slot[36];
    private static Slot[] emergencySlots = new Slot[3];

    public static void main(String[] args) {
        int availableVipSlots = vipSlots.length;
        int availableStudentSlots = studentSlots.length;
        int availableTeachingSlots = teachingSlots.length;
        int availableEmergencySlots = emergencySlots.length;

        for (int i = 0; i < vipSlots.length; i++) {
            vipSlots[i] = new Slot();
        }
        for (int i = 0; i < studentSlots.length; i++) {
            studentSlots[i] = new Slot();
        }
        for (int i = 0; i < teachingSlots.length; i++) {
            teachingSlots[i] = new Slot();
        }
        for (int i = 0; i < emergencySlots.length; i++) {
            emergencySlots[i] = new Slot();
        }

        byte option;
        Scanner scan = new Scanner(System.in);

        do {
            System.out.println("\n\n---------------Menu---------------\n");
            System.out.println("1. Parking");
            System.out.println("2. Departing");
            System.out.println("3. Search");
            System.out.println("5. Display available slots");
            System.out.println("6. Exit");

            System.out.print("Enter your choice: ");
            option = scan.nextByte();
            scan.nextLine(); // Consume the newline character

            switch (option) {
                case 1:
    Person temp = new Person("", "");
    temp.setPer();
    boolean parked = false;

    switch (temp.getJob().toLowerCase()) {
        case "vip":
            for (int i = 0; i < vipSlots.length; i++) {
                if (!vipSlots[i].checkStatus()) {
                    vipSlots[i].setStatus(true, temp);
                    availableVipSlots--;
                    System.out.println("Person parked in VIP Slot " + i);
                    parked = true;
                    break;
                }
            }
            break;
        case "student":
            for (int i = 0; i < studentSlots.length; i++) {
                if (!studentSlots[i].checkStatus()) {
                    studentSlots[i].setStatus(true, temp);
                    availableStudentSlots--;
                    System.out.println("Person parked in Student Slot " + i);
                    parked = true;
                    break;
                }
            }
            break;
        case "teaching":
            for (int i = 0; i < teachingSlots.length; i++) {
                if (!teachingSlots[i].checkStatus()) {
                    teachingSlots[i].setStatus(true, temp);
                    availableTeachingSlots--;
                    System.out.println("Person parked in Teaching Slot " + i);
                    parked = true;
                    break;
                }
            }
            break;
        case "emergency":
            // First, try to park in an emergency slot
            for (int i = 0; i < emergencySlots.length; i++) {
                if (!emergencySlots[i].checkStatus()) {
                    emergencySlots[i].setStatus(true, temp);
                    availableEmergencySlots--;
                    System.out.println("Person parked in Emergency Slot " + i);
                    parked = true;
                    break;
                }
            }

            // If no emergency slots are available, park in any other slot
            if (!parked) {
                boolean foundAnySlot = false;

                // Try to park in VIP, Student, or Teaching slots
                for (Slot[] slotsArray : new Slot[][]{vipSlots, studentSlots, teachingSlots}) {
                    for (int i = 0; i < slotsArray.length; i++) {
                        if (!slotsArray[i].checkStatus()) {
                            slotsArray[i].setStatus(true, temp);
                            System.out.println("Person (Emergency) parked in " + (slotsArray == vipSlots ? "VIP" : slotsArray == studentSlots ? "Student" : "Teaching") + " Slot " + i);
                            foundAnySlot = true;
                            parked = true;
                            break;
                        }
                    }
                    if (foundAnySlot) break; // Break the outer loop as well once a slot is found
                }
            }
            break;
        default:
            System.out.println("Invalid job type.");
    }

    if (!parked) {
        System.out.println("No available slots for your job type.");
    }
    break;

                case 2:
                    System.out.print("Enter vehicle number to depart: ");
                    String vehicleNum = scan.nextLine();
                    boolean found = false;

                    found = departVehicle(vehicleNum, vipSlots, availableVipSlots, "VIP");
                    if (!found) found = departVehicle(vehicleNum, studentSlots, availableStudentSlots, "Student");
                    if (!found) found = departVehicle(vehicleNum, teachingSlots, availableTeachingSlots, "Teaching");
                    if (!found) found = departVehicle(vehicleNum, emergencySlots, availableEmergencySlots, "Emergency");

                    if (!found) {
                        System.out.println("Vehicle not found in any slots.");
                    }
                    break;

                case 3:
                    System.out.print("Enter vehicle number to search: ");
                    String searchVehicleNum = scan.nextLine();
                    boolean slotFound = false;

                    slotFound = searchVehicle(searchVehicleNum, vipSlots, "VIP");
                    if (!slotFound) slotFound = searchVehicle(searchVehicleNum, studentSlots, "Student");
                    if (!slotFound) slotFound = searchVehicle(searchVehicleNum, teachingSlots, "Teaching");
                    if (!slotFound) slotFound = searchVehicle(searchVehicleNum, emergencySlots, "Emergency");

                    if (!slotFound) {
                        System.out.println("Vehicle not found in any slots.");
                    }
                    break;

                case 5:
                    System.out.println("Available Slots:");
                    System.out.println("VIP Slots: " + availableVipSlots + "/" + vipSlots.length);
                    System.out.println("Student Slots: " + availableStudentSlots + "/" + studentSlots.length);
                    System.out.println("Teaching Slots: " + availableTeachingSlots + "/" + teachingSlots.length);
                    System.out.println("Emergency Slots: " + availableEmergencySlots + "/" + emergencySlots.length);
                    break;

                case 6:
                    System.out.println("Exiting the system. Thank you!");
                    break;

                default:
                    System.out.println("Invalid choice. Please select a valid option.");
            }
        } while (option != 6);

        scan.close();
    }

    // Helper method for departing vehicle
    private static boolean departVehicle(String vehicleNum, Slot[] slots, int availableSlots, String slotType) {
        for (int i = 0; i < slots.length; i++) {
            if (slots[i].checkStatus() && slots[i].getPerson().getVehicleNumber().equals(vehicleNum)) {
                slots[i].setStatus(false, null);
                availableSlots++;
                System.out.println(slotType + " Slot " + i + " is now unoccupied.");
                return true;
            }
        }
        return false;
    }

    // Helper method for searching vehicle
    private static boolean searchVehicle(String vehicleNum, Slot[] slots, String slotType) {
        for (int i = 0; i < slots.length; i++) {
            if (slots[i].checkStatus() && slots[i].getPerson().getVehicleNumber().equals(vehicleNum)) {
                System.out.println("Vehicle found in " + slotType + " Slot " + i);
                slots[i].DisplaySlot();
                return true;
            }
        }
        return false;
    }
}
*/
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.*;

public class ParkingManagement extends Application {
    private static Slot[] vipSlots = new Slot[7]; 
    private static Slot[] studentSlots = new Slot[54];
    private static Slot[] teachingSlots = new Slot[36];
    private static Slot[] emergencySlots = new Slot[3];

    private static int availableVipSlots = vipSlots.length;
    private static int availableStudentSlots = studentSlots.length;
    private static int availableTeachingSlots = teachingSlots.length;
    private static int availableEmergencySlots = emergencySlots.length;

    private TextArea outputArea;
    private TextField vehicleNumField, jobField;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        // Initialize slots
        initializeSlots();

        // Set up the UI
        VBox mainLayout = new VBox(10);
        Scene scene = new Scene(mainLayout, 600, 400);

        // Title
        Label title = new Label("Parking Management System");
        title.setStyle("-fx-font-size: 20px;");

        // Buttons
        Button parkButton = new Button("Park Vehicle");
        Button departButton = new Button("Depart Vehicle");
        Button searchButton = new Button("Search Vehicle");
        Button displayButton = new Button("Display Available Slots");

        // Text Fields for input
        Label jobLabel = new Label("Enter Job (VIP, Student, Teaching, Emergency):");
        jobField = new TextField();
        Label vehicleLabel = new Label("Enter Vehicle Number:");
        vehicleNumField = new TextField();

        // Output Area
        outputArea = new TextArea();
        outputArea.setEditable(false);

        // Set button actions
        parkButton.setOnAction(e -> parkVehicle());
        departButton.setOnAction(e -> departVehicle());
        searchButton.setOnAction(e -> searchVehicle());
        displayButton.setOnAction(e -> displayAvailableSlots());

        // Layout configuration
        mainLayout.getChildren().addAll(title, jobLabel, jobField, vehicleLabel, vehicleNumField,
                                        parkButton, departButton, searchButton, displayButton, outputArea);

        primaryStage.setTitle("Parking Management System");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    // Initialize all the slots
    private void initializeSlots() {
        for (int i = 0; i < vipSlots.length; i++) {
            vipSlots[i] = new Slot();
        }
        for (int i = 0; i < studentSlots.length; i++) {
            studentSlots[i] = new Slot();
        }
        for (int i = 0; i < teachingSlots.length; i++) {
            teachingSlots[i] = new Slot();
        }
        for (int i = 0; i < emergencySlots.length; i++) {
            emergencySlots[i] = new Slot();
        }
    }

    // Park a vehicle
    private void parkVehicle() {
        String job = jobField.getText().toLowerCase();
        String vehicleNumber = vehicleNumField.getText();
        boolean parked = false;

        Person temp = new Person(job, vehicleNumber);

        switch (job) {
            case "vip":
                parked = parkInSlot(vipSlots, temp, "VIP");
                break;
            case "student":
                parked = parkInSlot(studentSlots, temp, "Student");
                break;
            case "teaching":
                parked = parkInSlot(teachingSlots, temp, "Teaching");
                break;
            case "emergency":
                parked = parkInSlot(emergencySlots, temp, "Emergency");
                if (!parked) {
                    // If emergency slots are full, park in other slots
                    parked = tryParkInOtherSlots(temp);
                }
                break;
            default:
                outputArea.setText("Invalid job type. Please enter VIP, Student, Teaching, or Emergency.");
        }

        if (!parked) {
            outputArea.setText("No available slots for " + job + " job type.");
        }
    }

    // Helper method to park in a specific slot type
    private boolean parkInSlot(Slot[] slots, Person person, String slotType) {
        for (int i = 0; i < slots.length; i++) {
            if (!slots[i].checkStatus()) {
                slots[i].setStatus(true, person);
                updateAvailableSlots(slotType, -1);
                outputArea.setText("Vehicle parked in " + slotType + " Slot " + i);
                return true;
            }
        }
        return false;
    }

    // Try to park in other slots (if emergency slots are full)
    private boolean tryParkInOtherSlots(Person person) {
        boolean parked = false;
        for (Slot[] slots : new Slot[][]{vipSlots, studentSlots, teachingSlots}) {
            for (int i = 0; i < slots.length; i++) {
                if (!slots[i].checkStatus()) {
                    slots[i].setStatus(true, person);
                    outputArea.setText("Emergency vehicle parked in another available slot.");
                    parked = true;
                    break;
                }
            }
            if (parked) break;
        }
        return parked;
    }

    // Depart a vehicle
    private void departVehicle() {
        String vehicleNumber = vehicleNumField.getText();
        boolean found = false;

        found = departFromSlot(vipSlots, vehicleNumber, "VIP");
        if (!found) found = departFromSlot(studentSlots, vehicleNumber, "Student");
        if (!found) found = departFromSlot(teachingSlots, vehicleNumber, "Teaching");
        if (!found) found = departFromSlot(emergencySlots, vehicleNumber, "Emergency");

        if (!found) {
            outputArea.setText("Vehicle not found in any slots.");
        }
    }

    // Helper method to handle departure from slots
    private boolean departFromSlot(Slot[] slots, String vehicleNum, String slotType) {
        for (int i = 0; i < slots.length; i++) {
            if (slots[i].checkStatus() && slots[i].getPerson().getVehicleNumber().equals(vehicleNum)) {
                slots[i].setStatus(false, null);
                updateAvailableSlots(slotType, 1);
                outputArea.setText(slotType + " Slot " + i + " is now unoccupied.");
                return true;
            }
        }
        return false;
    }

    // Search for a vehicle in any slot
    private void searchVehicle() {
        String vehicleNumber = vehicleNumField.getText();
        boolean found = false;

        found = searchInSlot(vipSlots, vehicleNumber, "VIP");
        if (!found) found = searchInSlot(studentSlots, vehicleNumber, "Student");
        if (!found) found = searchInSlot(teachingSlots, vehicleNumber, "Teaching");
        if (!found) found = searchInSlot(emergencySlots, vehicleNumber, "Emergency");

        if (!found) {
            outputArea.setText("Vehicle not found in any slots.");
        }
    }

    // Helper method to search vehicle in a slot type
    private boolean searchInSlot(Slot[] slots, String vehicleNum, String slotType) {
        for (int i = 0; i < slots.length; i++) {
            if (slots[i].checkStatus() && slots[i].getPerson().getVehicleNumber().equals(vehicleNum)) {
                outputArea.setText("Vehicle found in " + slotType + " Slot " + i);
                return true;
            }
        }
        return false;
    }

    // Display available slots
    private void displayAvailableSlots() {
        outputArea.setText("Available Slots:\n" +
                "VIP Slots: " + availableVipSlots + "/" + vipSlots.length + "\n" +
                "Student Slots: " + availableStudentSlots + "/" + studentSlots.length + "\n" +
                "Teaching Slots: " + availableTeachingSlots + "/" + teachingSlots.length + "\n" +
                "Emergency Slots: " + availableEmergencySlots + "/" + emergencySlots.length);
    }

    // Update the available slot count
    private void updateAvailableSlots(String slotType, int change) {
        switch (slotType) {
            case "VIP":
                availableVipSlots += change;
                break;
            case "Student":
                availableStudentSlots += change;
                break;
            case "Teaching":
                availableTeachingSlots += change;
                break;
            case "Emergency":
                availableEmergencySlots += change;
                break;
        }
    }
}
