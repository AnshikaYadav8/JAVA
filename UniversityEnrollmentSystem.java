import java.util.*;

class CourseFullException extends Exception {
    public CourseFullException(String message) {
        super(message);
    }
}

class PrerequisiteNotMetException extends Exception {
    public PrerequisiteNotMetException(String message) {
        super(message);
    }
}

class Course {
    private String courseName;
    private int maxEnrollment;
    private int enrolledStudents;
    private List<String> prerequisites;

    public Course(String courseName, int maxEnrollment, List<String> prerequisites) {
        this.courseName = courseName;
        this.maxEnrollment = maxEnrollment;
        this.enrolledStudents = 0; 
        this.prerequisites = prerequisites;
    }

    public String getCourseName() {
        return courseName;
    }

    public boolean isFull() {
        return enrolledStudents >= maxEnrollment;
    }

    public boolean checkPrerequisites(String completedCourse) {
        return prerequisites.contains(completedCourse);
    }

    public void enrollStudent() throws CourseFullException {
        if (isFull()) {
            throw new CourseFullException(courseName + " is full. Cannot enroll.");
        }
        enrolledStudents++;
        System.out.println("Successfully enrolled in " + courseName);
    }
}

public class UniversityEnrollmentSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        List<String> advancedJavaPrerequisites = Arrays.asList("Core Java");
        List<String> machineLearningPrerequisites = Arrays.asList("Python");

        Course advancedJava = new Course("Advanced Java", 20, advancedJavaPrerequisites);
        Course machineLearning = new Course("Machine Learning", 20, machineLearningPrerequisites);

        System.out.print("Enter the course name to enroll in (Advanced Java or Machine Learning): ");
        String courseChoice = sc.nextLine();

        try {
            if (courseChoice.equalsIgnoreCase("Advanced Java")) {
                System.out.println("Prerequisite: Core Java");
                System.out.print("Have you completed Core Java? (yes/no): ");
                String completed = sc.nextLine();
                if (!completed.equalsIgnoreCase("yes")) {
                    throw new PrerequisiteNotMetException("Complete Core Java before enrolling in Advanced Java.");
                }
                advancedJava.enrollStudent();
            } else if (courseChoice.equalsIgnoreCase("Machine Learning")) {
                System.out.println("Prerequisite: Python");
                System.out.print("Have you completed Python? (yes/no): ");
                String completed = sc.nextLine();
                if (!completed.equalsIgnoreCase("yes")) {
                    throw new PrerequisiteNotMetException("Complete Python before enrolling in Machine Learning.");
                }
                machineLearning.enrollStudent();
            } else {
                System.out.println("Invalid course selected.");
            }
        } catch (CourseFullException | PrerequisiteNotMetException e) {
            System.out.println("Error: " + e.getMessage());
        }

        sc.close();
    }
}
