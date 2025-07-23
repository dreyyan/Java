package Operations;
import java.util.Arrays;

public class ArrayOperations {
    public static void main(String[] args) {
        int[] static_numbers = {1, 2, 3, 4, 5};
        int[] dynamic_numbers = new int[5];
        
        String output = String.format("Static Numbers: %s%nDynamic Numbers: %s", Arrays.toString(static_numbers), Arrays.toString(dynamic_numbers));
        System.out.println(output);
    }
}