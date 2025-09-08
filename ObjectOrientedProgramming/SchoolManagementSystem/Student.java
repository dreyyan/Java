import java.util.ArrayList;
import Enums.Course;
import Enums.Department;
import Interfaces.Registerable;

public class Student extends Person implements Registerable {
    // Attributes
    protected ArrayList<Integer> grades;
    protected Department department;
    protected Course course;
    protected boolean isEnrolled;
    
    // Student → extra fields (grade, section)
    // Teacher → extra fields (subject, salary)
    // Staff → extra fields (role)
    // Features you can add:
    // Register students & teachers
    // Assign teachers to classes
    // Track grades or attendance

    // Getters & Setters
    // [ GETTER ]: Return the average grade
    public float getGrades() {
        if (this.grades == null || this.grades.size() == 0) return 0.0f;
        float averageGrade = 0;

        for (int grade : grades) {
            averageGrade += grade;
        } return averageGrade /= grades.size();
    }

    public Course getCourse() { return this.course; }

    // [ SETTER ]: Set the course and department under the course
    public void setCourse(Course course) {
        this.course = course;
        this.department = course.getDepartment();
    }

    // Default Constructor
    public Student() {}
    
    // Parameterized Constructor
    public Student(String name, int age, int id, Course course, boolean isEnrolled) {
        this.name = name;
        this.age = age;
        this.id = id;
        this.course = course;
        this.isEnrolled = isEnrolled;

    }
    
    // Methods
    public void displayInformation() {
        System.out.println("[ STUDENT INFORMATION ]");
        System.out.println("=".repeat(30));
        System.out.printf("Name: %s\n", getName());
        System.out.printf("Age: %s\n", getAge());
        System.out.printf("ID: %s\n", getId());
        System.out.printf("Grades: %s\n", getGrades());
        System.out.printf("Department: %s\n", course.getDepartment());
        System.out.printf("Course: %s\n", getCourse());
        System.out.println("=".repeat(30));
    }

    // Methods: Inherited
    public void register() {
        System.out.println(">> registering student...");
    }
}