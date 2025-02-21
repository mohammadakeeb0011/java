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

    public void setStd(Scanner scan) {  // Accept Scanner as parameter
        System.out.print("Enter name of student: ");
        name = scan.nextLine();
        System.out.print("Enter roll no. of student: ");
        rollNo = scan.nextLine();
    }
}

class Chair {
    private boolean status;
    private Student studentObj;

    public Chair(boolean s, Student obj) {
        status = s;
        studentObj = obj;
    }

    public boolean checkStatus() {
        return status;
    }

    public void DisplayChair() {
        String a = (status) ? "Occupied" : "Unoccupied";
        System.out.println("Status   : " + a);
        if (status) {
            System.out.println("Student Details:");
            studentObj.DisplayStd();
        }
    }
}

class Lab {
    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);

        Chair[] chairs = new Chair[5];

        for (int i = 0; i < 5; i++) {
            System.out.println("Enter details for Student " + (i + 1));
            Student temp = new Student("", "");  // Create a temporary student
            temp.setStd(scan);  // Pass Scanner instance
            chairs[i] = new Chair(true, temp); // Assign student to a chair
        }

        while (true) {
            System.out.print("Enter chair number (0-4) to view details or -1 to exit: ");
            int i = scan.nextInt();
            scan.nextLine();  // Consume newline

            if (i == -1) break;

            if (i >= 0 && i < 5) {
                chairs[i].DisplayChair();
            } else {
                System.out.println("Invalid chair number. Try again.");
            }

            System.out.print("Do you want to continue? (y/n): ");
            String choice = scan.nextLine();
            if (choice.equalsIgnoreCase("n")) break;
        }

        byte option;
        do {
            System.out.println("\n\n--------------- Menu ---------------");
            System.out.println("1. Insert");
            System.out.println("2. Delete");
            System.out.println("3. Search");
            System.out.println("4. Update");
            System.out.println("5. Display");
            System.out.println("6. Exit");

            System.out.print("Enter your choice: ");
            option = scan.nextByte();
            scan.nextLine();  // Consume newline

            switch (option) {
                case 1:
                    System.out.println("Insert option selected");
                    break;
                case 2:
                    System.out.println("Delete option selected");
                    break;
                case 3:
                    System.out.println("Search option selected");
                    break;
                case 4:
                    System.out.println("Update option selected");
                    break;
                case 5:
                    System.out.println("Display option selected");
                    break;
                case 6:
                    System.out.println("Exiting program...");
                    break;
                default:
                    System.out.println("Invalid choice! Please select a valid option.");
            }
        } while (option != 6);

        scan.close();  // Close Scanner at the end
    }
}
