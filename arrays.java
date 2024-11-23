import java.util.Arrays;

public class arrays {
    public static void main(String[] args) {
        int[] numbers = {1, 2, 3, 4, 5}; // Static Initialization
        int[] number_array = new int[5]; // Dynamic Allocation
        System.out.println(Arrays.toString(numbers));
        System.out.println(Arrays.toString(number_array));
    }
}
