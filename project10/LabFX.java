import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class LabFX extends Application {

    private Chair[] chairs = new Chair[5]; // 5 chairs
    private TextArea outputArea; // To display output

    @Override
    public void start(Stage primaryStage) {
        // Initialize chairs array
        for (int i = 0; i < chairs.length; i++) {
            chairs[i] = new Chair(); // Create empty chairs
        }

        // Create the UI components
        Label nameLabel = new Label("Student Name:");
        TextField nameField = new TextField();

        Label rollLabel = new Label("Roll No:");
        TextField rollField = new TextField();

        Label chairLabel = new Label("Chair No (0-4):");
        TextField chairField = new TextField();

        Button insertButton = new Button("Insert");
        Button deleteButton = new Button("Delete");
        Button searchButton = new Button("Search");
        Button updateButton = new Button("Update");
        Button displayButton = new Button("Display All");

        outputArea = new TextArea();
        outputArea.setEditable(false);

        // Set up event handlers for buttons
        insertButton.setOnAction(e -> insertStudent(nameField.getText(), rollField.getText(), chairField.getText()));
        deleteButton.setOnAction(e -> deleteStudent(chairField.getText()));
        searchButton.setOnAction(e -> searchStudent(chairField.getText()));
        updateButton.setOnAction(e -> updateStudent(nameField.getText(), rollField.getText(), chairField.getText()));
        displayButton.setOnAction(e -> displayAllChairs());

        // Layout setup
        VBox inputBox = new VBox(10, nameLabel, nameField, rollLabel, rollField, chairLabel, chairField, insertButton, deleteButton, searchButton, updateButton, displayButton);
        inputBox.setPrefWidth(200);

        VBox outputBox = new VBox(10, new Label("Output:"), outputArea);
        outputBox.setPrefWidth(400);

        HBox root = new HBox(20, inputBox, outputBox);
        root.setStyle("-fx-padding: 20;");

        // Set up the scene and stage
        Scene scene = new Scene(root, 600, 400);
        primaryStage.setTitle("Lab Management System");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    // Insert a student into a chair
    private void insertStudent(String name, String rollNo, String chairNoStr) {
        try {
            int chairNo = Integer.parseInt(chairNoStr);
            if (chairNo >= 0 && chairNo < chairs.length) {
                if (!chairs[chairNo].checkStatus()) {
                    Student student = new Student(name, rollNo);
                    chairs[chairNo].SetStatus(true, student);
                    outputArea.appendText("Student inserted in chair " + chairNo + ".\n");
                } else {
                    outputArea.appendText("Chair " + chairNo + " is already occupied.\n");
                }
            } else {
                outputArea.appendText("Invalid chair number. Must be between 0 and 4.\n");
            }
        } catch (NumberFormatException e) {
            outputArea.appendText("Invalid input for chair number.\n");
        }
    }

    // Delete a student from a chair
    private void deleteStudent(String chairNoStr) {
        try {
            int chairNo = Integer.parseInt(chairNoStr);
            if (chairNo >= 0 && chairNo < chairs.length) {
                if (chairs[chairNo].checkStatus()) {
                    chairs[chairNo].SetStatus(false, null);
                    outputArea.appendText("Chair " + chairNo + " is now unoccupied.\n");
                } else {
                    outputArea.appendText("Chair " + chairNo + " is already unoccupied.\n");
                }
            } else {
                outputArea.appendText("Invalid chair number. Must be between 0 and 4.\n");
            }
        } catch (NumberFormatException e) {
            outputArea.appendText("Invalid input for chair number.\n");
        }
    }

    // Search for a student in a specific chair
    private void searchStudent(String chairNoStr) {
        try {
            int chairNo = Integer.parseInt(chairNoStr);
            if (chairNo >= 0 && chairNo < chairs.length) {
                outputArea.appendText("Chair " + chairNo + " details:\n");
                chairs[chairNo].DisplayChair();
            } else {
                outputArea.appendText("Invalid chair number. Must be between 0 and 4.\n");
            }
        } catch (NumberFormatException e) {
            outputArea.appendText("Invalid input for chair number.\n");
        }
    }

    // Update a student's details in a specific chair
    private void updateStudent(String name, String rollNo, String chairNoStr) {
        try {
            int chairNo = Integer.parseInt(chairNoStr);
            if (chairNo >= 0 && chairNo < chairs.length) {
                if (chairs[chairNo].checkStatus()) {
                    Student updatedStudent = new Student(name, rollNo);
                    chairs[chairNo].SetStatus(true, updatedStudent);
                    outputArea.appendText("Student in chair " + chairNo + " updated.\n");
                } else {
                    outputArea.appendText("Chair " + chairNo + " is unoccupied.\n");
                }
            } else {
                outputArea.appendText("Invalid chair number. Must be between 0 and 4.\n");
            }
        } catch (NumberFormatException e) {
            outputArea.appendText("Invalid input for chair number.\n");
        }
    }

    // Display the status of all chairs
    private void displayAllChairs() {
        outputArea.appendText("\nDisplaying all chairs:\n");
        for (int i = 0; i < chairs.length; i++) {
            outputArea.appendText("Chair " + i + ":\n");
            chairs[i].DisplayChair();
        }
    }

    // Student class definition
    class Student {
        private String name;
        private String rollNo;

        public Student(String n, String r) {
            name = n;
            rollNo = r;
        }

        public void DisplayStd() {
            outputArea.appendText("Name: " + name + "\n");
            outputArea.appendText("Roll No: " + rollNo + "\n");
        }
    }

    // Chair class definition
    class Chair {
        private boolean status;
        private Student studentObj;

        public Chair() {
            status = false;
            studentObj = null;
        }

        public boolean checkStatus() {
            return status;
        }

        public void SetStatus(boolean s, Student obj) {
            status = s;
            studentObj = obj;
        }

        public void DisplayChair() {
            if (status && studentObj != null) {
                outputArea.appendText("Status: Occupied\n");
                studentObj.DisplayStd();
            } else {
                outputArea.appendText("Status: Unoccupied\n");
            }
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
