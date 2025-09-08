import Enums.Department;
import Enums.Course;

public class Main {
    public static void main(String[] args) {
       Student student = new Student(
        "Adrian Dominic Tan",
        20,
        20241207,
        Course.BS_COMPUTER_SCIENCE,
        false
        );

        student.displayInformation();
    }
}