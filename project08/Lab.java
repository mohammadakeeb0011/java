import java.util.Scanner;

class Student {
    private String name;
    private String rollNo;

    public Student(String n, String r) {
        name = n;
        rollNo = r;
    }

    public void DisplayStd() {
        System.out.println("Name     : " + name);
        System.out.println("Roll No. : " + rollNo);
    }

    public void setStd() {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter name of student: ");
        name = scan.nextLine();
        System.out.print("Enter roll no. of student: ");
        rollNo = scan.nextLine();
    }
}

class Chair {
    private boolean status;
    private Student studentObj;

    public Chair() {
        status = false; // Initially unoccupied
        studentObj = null;
    }

    public Chair(boolean s, Student obj) {
        status = s;
        studentObj = obj;
    }

    public boolean checkStatus() {
        return status;
    }

    public void SetStatus(boolean s, Student obj) {
        status = s;
        studentObj = obj;
    }

    public void DisplayChair() {
        String a = (status) ? "Occupied" : "Unoccupied";
        System.out.println("Status   : " + a);
        if (status && studentObj != null) {
            System.out.println("Student Details:");
            studentObj.DisplayStd();
        }
    }
}

class Lab {
    public static void main(String args[]) {
        Chair[] chairs = new Chair[5]; // Initialize an array of 5 chairs
        for (int i = 0; i < 5; i++) {
            chairs[i] = new Chair(); // Initialize each Chair object
        }

        byte option;
        Scanner scan = new Scanner(System.in);

        do {
            System.out.println("\n\n---------------Menu---------------\n");
            System.out.println("1. Insert");
            System.out.println("2. Delete");
            System.out.println("3. Search");
            System.out.println("4. Update");
            System.out.println("5. Display");
            System.out.println("6. Exit");

            System.out.print("Enter your choice : ");
            option = scan.nextByte();
            scan.nextLine(); // Consume the newline character

            switch (option) {
                case 1:
                    System.out.print("Enter chair number (0-4): ");
                    int insertIndex = scan.nextInt();
                    scan.nextLine(); 

                    if (insertIndex >= 0 && insertIndex < chairs.length) {
                        Student temp = new Student("", "");
                        temp.setStd();
                        chairs[insertIndex].SetStatus(true, temp);
                        System.out.println("Student inserted into chair " + insertIndex);
                    } else {
                        System.out.println("Invalid chair number!");
                    }
                    break;

                case 2:
                    System.out.print("Enter chair number to delete (0-4): ");
                    int deleteIndex = scan.nextInt();
                    scan.nextLine(); // Consume newline

                    if (deleteIndex >= 0 && deleteIndex < chairs.length && chairs[deleteIndex].checkStatus()) {
                        chairs[deleteIndex].SetStatus(false, null);
                        System.out.println("Chair " + deleteIndex + " is now unoccupied.");
                    } else {
                        System.out.println("Invalid chair number or chair already unoccupied.");
                    }
                    break;

                case 3:
                    System.out.print("Enter chair number to search (0-4): ");
                    int searchIndex = scan.nextInt();
                    scan.nextLine(); // Consume newline

                    if (searchIndex >= 0 && searchIndex < chairs.length) {
                        chairs[searchIndex].DisplayChair();
                    } else {
                        System.out.println("Invalid chair number!");
                    }
                    break;

                case 4:
                    System.out.print("Enter chair number to update (0-4): ");
                    int updateIndex = scan.nextInt();
                    scan.nextLine(); // Consume newline

                    if (updateIndex >= 0 && updateIndex < chairs.length && chairs[updateIndex].checkStatus()) {
                        System.out.println("Update student details for chair " + updateIndex);
                        Student updatedStudent = new Student("", "");
                        updatedStudent.setStd();
                        chairs[updateIndex].SetStatus(true, updatedStudent);
                    } else {
                        System.out.println("Invalid chair number or chair unoccupied.");
                    }
                    break;

                case 5:
                    System.out.println("\nDisplaying all chairs:");
                    for (int i = 0; i < chairs.length; i++) {
                        System.out.println("\nChair " + i + ":");
                        chairs[i].DisplayChair();
                    }
                    break;

                case 6:
                    System.out.println("Exiting program...");
                    break;

                default:
                    System.out.println("Invalid option! Please choose between 1 and 6.");
            }
        } while (option != 6);

        scan.close();
    }
}
