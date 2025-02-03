import java.util.Scanner;
abstract class Person {
    protected String name;
    protected int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
    public abstract void displayDetails();
}
class Student extends Person {
    private int rollNumber;

    public Student(String name, int age, int rollNumber) {
        super(name, age);
        this.rollNumber = rollNumber;
    }
    @Override
    public void displayDetails() {
        System.out.println("Type: Student");
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Roll Number: " + rollNumber);
    }
}
class Teacher extends Person {
    private String subject;

    public Teacher(String name, int age, String subject) {
        super(name, age);
        this.subject = subject;
    }
    @Override
    public void displayDetails() {
        System.out.println("Type: Teacher");
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Subject: " + subject);
    }
}
public class StudentManagementSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of people: ");
        int n = sc.nextInt();
        sc.nextLine(); 

        Person[] people = new Person[n];

        for (int i = 0; i < n; i++) {
            System.out.println("\nPerson " + (i + 1) + ":");
            System.out.print("Type (Student/Teacher): ");
            String type = sc.next();
            sc.nextLine(); 
            System.out.print("Name: ");
            String name = sc.nextLine();
            System.out.print("Age: ");
            int age = sc.nextInt();
            sc.nextLine(); 

            if (type.equalsIgnoreCase("Student")) {
                System.out.print("Roll Number: ");
                int rollNumber = sc.nextInt();
                sc.nextLine();
                people[i] = new Student(name, age, rollNumber);
            } else if (type.equalsIgnoreCase("Teacher")) {
                System.out.print("Subject: ");
                String subject = sc.nextLine();
                people[i] = new Teacher(name, age, subject);
            } else {
                System.out.println("Invalid type! Defaulting to Student with Roll Number 0.");
                people[i] = new Student(name, age, 0);
            }
        }

        System.out.println("\nStudent & Teacher Details:");
        for (Person person : people) {
            person.displayDetails();
        }

        sc.close();
    }
}

