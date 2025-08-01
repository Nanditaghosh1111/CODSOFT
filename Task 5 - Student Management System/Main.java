import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        StudentManagementSystem sms = new StudentManagementSystem();
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n=== Student Management System ===");
            System.out.println("1. Add Student");
            System.out.println("2. Search Student");
            System.out.println("3. Remove Student");
            System.out.println("4. Display All Students");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = getValidInt(sc);

            switch (choice) {
                case 1:
                    System.out.print("Enter Roll Number: ");
                    String roll = sc.nextLine().trim();
                    System.out.print("Enter Name: ");
                    String name = sc.nextLine().trim();
                    System.out.print("Enter Grade: ");
                    String grade = sc.nextLine().trim();

                    if (roll.isEmpty() || name.isEmpty() || grade.isEmpty()) {
                        System.out.println("All fields are required!");
                    } else {
                        sms.addStudent(new Student(name, roll, grade));
                    }
                    break;

                case 2:
                    System.out.print("Enter Roll Number to search: ");
                    String r = sc.nextLine().trim();
                    Student found = sms.searchStudent(r);
                    if (found != null) {
                        System.out.println("Student Found: " + found);
                    } else {
                        System.out.println("Student not found.");
                    }
                    break;

                case 3:
                    System.out.print("Enter Roll Number to remove: ");
                    String removeRoll = sc.nextLine().trim();
                    sms.removeStudent(removeRoll);
                    break;

                case 4:
                    sms.displayAllStudents();
                    break;

                case 5:
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid choice.");
            }
        } while (choice != 5);

        sc.close();
    }

    public static int getValidInt(Scanner sc) {
        while (!sc.hasNextInt()) {
            System.out.print("Please enter a number: ");
            sc.next(); // discard invalid input
        }
        int num = sc.nextInt();
        sc.nextLine(); // consume newline
        return num;
    }
}

