import java.io.*;
import java.util.*;

public class StudentManagementSystem {
    private List<Student> students;
    private final String fileName = "students.txt";

    public StudentManagementSystem() {
        students = new ArrayList<>();
        loadStudentsFromFile();
    }

    public void addStudent(Student student) {
        for (Student s : students) {
            if (s.getRollNumber().equals(student.getRollNumber())) {
                System.out.println("Roll number already exists!");
                return;
            }
        }
        students.add(student);
        saveStudentsToFile();
        System.out.println("Student added successfully!");
    }

    public void removeStudent(String rollNumber) {
        boolean removed = students.removeIf(s -> s.getRollNumber().equals(rollNumber));
        if (removed) {
            saveStudentsToFile();
            System.out.println("Student removed.");
        } else {
            System.out.println("Student not found.");
        }
    }

    public Student searchStudent(String rollNumber) {
        for (Student s : students) {
            if (s.getRollNumber().equals(rollNumber)) {
                return s;
            }
        }
        return null;
    }

    public void displayAllStudents() {
        if (students.isEmpty()) {
            System.out.println("No students available.");
        } else {
            for (Student s : students) {
                System.out.println(s);
            }
        }
    }

    public void saveStudentsToFile() {
        try (PrintWriter pw = new PrintWriter(new FileWriter(fileName))) {
            for (Student s : students) {
                pw.println(s.getRollNumber() + "," + s.getName() + "," + s.getGrade());
            }
        } catch (IOException e) {
            System.out.println("Error saving data.");
        }
    }

    public void loadStudentsFromFile() {
        File file = new File(fileName);
        if (!file.exists()) return;

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 3) {
                    students.add(new Student(parts[1], parts[0], parts[2]));
                }
            }
        } catch (IOException e) {
            System.out.println("Error loading student data.");
        }
    }
}

