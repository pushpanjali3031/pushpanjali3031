import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class StudentGradeManagementSystem {
    private static Map<Integer, Student> studentMap = new HashMap<>();
    private static int rollNumberCounter = 1;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n1. Add Student");
            System.out.println("2. Update Student");
            System.out.println("3. Delete Student");
            System.out.println("4. View Student");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    addStudent(scanner);
                    break;
                case 2:
                    updateStudent(scanner);
                    break;
                case 3:
                    deleteStudent(scanner);
                    break;
                case 4:
                    viewStudent();
                    break;
                case 5:
                    System.out.println("Exiting...");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        }
    }

    private static void addStudent(Scanner scanner) {
        System.out.print("Enter student name: ");
        String name = scanner.next();
        System.out.print("Enter marks for Subject 1: ");
        int subject1 = scanner.nextInt();
        System.out.print("Enter marks for Subject 2: ");
        int subject2 = scanner.nextInt();
        System.out.print("Enter marks for Subject 3: ");
        int subject3 = scanner.nextInt();

        Student student = new Student(rollNumberCounter++, name, subject1, subject2, subject3);
        studentMap.put(student.getRollNumber(), student);

        System.out.println("Student added successfully!");
    }

    private static void updateStudent(Scanner scanner) {
        System.out.print("Enter roll number of the student to update: ");
        int rollNumber = scanner.nextInt();
        if (studentMap.containsKey(rollNumber)) {
            System.out.print("Enter new marks for Subject 1: ");
            int subject1 = scanner.nextInt();
            System.out.print("Enter new marks for Subject 2: ");
            int subject2 = scanner.nextInt();
            System.out.print("Enter new marks for Subject 3: ");
            int subject3 = scanner.nextInt();

            Student student = studentMap.get(rollNumber);
            student.setSubject1(subject1);
            student.setSubject2(subject2);
            student.setSubject3(subject3);

            System.out.println("Student information updated successfully!");
        } else {
            System.out.println("Student with given roll number does not exist!");
        }
    }

    private static void deleteStudent(Scanner scanner) {
        System.out.print("Enter roll number of the student to delete: ");
        int rollNumber = scanner.nextInt();
        if (studentMap.containsKey(rollNumber)) {
            studentMap.remove(rollNumber);
            System.out.println("Student deleted successfully!");
        } else {
            System.out.println("Student with given roll number does not exist!");
        }
    }

    private static void viewStudent() {
        if (studentMap.isEmpty()) {
            System.out.println("No student records available!");
        } else {
            for (Student student : studentMap.values()) {
                System.out.println(student);
            }
        }
    }
}

class Student {
    private int rollNumber;
    private String name;
    private int subject1;
    private int subject2;
    private int subject3;

    public Student(int rollNumber, String name, int subject1, int subject2, int subject3) {
        this.rollNumber = rollNumber;
        this.name = name;
        this.subject1 = subject1;
        this.subject2 = subject2;
        this.subject3 = subject3;
    }

    public int getRollNumber() {
        return rollNumber;
    }

    public String getName() {
        return name;
    }

    public int getSubject1() {
        return subject1;
    }

    public void setSubject1(int subject1) {
        this.subject1 = subject1;
    }

    public int getSubject2() {
        return subject2;
    }

    public void setSubject2(int subject2) {
        this.subject2 = subject2;
    }

    public int getSubject3() {
        return subject3;
    }

    public void setSubject3(int subject3) {
        this.subject3 = subject3;
    }

    public double calculatePercentage() {
        return (subject1 + subject2 + subject3) / 3.0;
    }

    public String calculateGrade() {
        double percentage = calculatePercentage();
        if (percentage >= 90) {
            return "A";
        } else if (percentage >= 80) {
            return "B";
        } else if (percentage >= 70) {
            return "C";
        } else if (percentage >= 60) {
            return "D";
        } else {
            return "F";
        }
    }

    @Override
    public String toString() {
        return "Roll Number: " + rollNumber +
                ", Name: " + name +
                ", Subject 1: " + subject1 +
                ", Subject 2: " + subject2 +
                ", Subject 3: " + subject3 +
                ", Percentage: " + calculatePercentage() +
                ", Grade: " + calculateGrade();
    }
}
