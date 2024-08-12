class Student {
    private String name;
    private int rollNumber;
    private int[] marks;

    public Student(String name, int rollNumber, int[] marks) {
        this.name = name;
        this.rollNumber = rollNumber;
        this.marks = marks;
    }

    public double calculateAverage() {
        int totalMarks = 0;
        for (int mark : marks) {
            totalMarks += mark;
        }
        return (double) totalMarks / marks.length;
    }

    public void displayDetails() {
        System.out.println("Name: " + name);
        System.out.println("Roll Number: " + rollNumber);
        System.out.print("Marks: ");
        for (int mark : marks) {
            System.out.print(mark + " ");
        }
        System.out.println();
        System.out.println("Average Marks: " + calculateAverage());
    }

    public String isPassed() {
        for (int mark : marks) {
            if (mark < 40) {
                return "fail";
            }
        }
        return "passed";
    }
}

public class StudentManagement {
    public static void main(String[] args) {
        Student[] students = {
            new Student("Burak", 1, new int[]{85, 90, 78}),
            new Student("Deniz", 2, new int[]{75, 82, 69}),
            new Student("Ibrahim", 3, new int[]{92, 88, 95})
        };

        double totalClassMarks = 0;
        for (Student student : students) {
            student.displayDetails();
            System.out.println("Passed: " + student.isPassed()); 
            totalClassMarks += student.calculateAverage();
            System.out.println();  // Added for better readability
        }

        double classAverage = totalClassMarks / students.length;
        System.out.println("Class Average: " + classAverage);
    }
}
