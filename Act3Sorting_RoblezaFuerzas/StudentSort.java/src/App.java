import java.util.ArrayList;
import java.util.Scanner;

class Student {
    String name;
    double grade;

    public Student(String name, double grade) {
        this.name = name;
        this.grade = grade;
    }

    @Override
    public String toString() {
        return name + " - " + grade;
    }
}

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("How many students?");
        int numStudents = scanner.nextInt();
        scanner.nextLine();

        ArrayList<Student> students = new ArrayList<>();
        for (int i = 0; i < numStudents; i++) {
            System.out.println("Enter details for Student #" + (i + 1));
            System.out.print("Name: ");
            String name = scanner.nextLine();
            System.out.print("Grade: ");
            double grade = scanner.nextDouble();
            scanner.nextLine();

            students.add(new Student(name, grade));
        }

        for (int i = 0; i < students.size() - 1; i++) {
            for (int j = 0; j < students.size() - 1 - i; j++) {
                if (students.get(j).grade > students.get(j + 1).grade) {
                    Student temp = students.get(j);
                    students.set(j, students.get(j + 1));
                    students.set(j + 1, temp);
                }
            }
        }

        System.out.println("Sorted Students by Grade (Ascending):");
        for (Student student : students) {
            System.out.println(student);
        }

        scanner.close();
    }
}
