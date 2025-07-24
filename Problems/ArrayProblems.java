package Problems;
import java.util.Arrays;

public class ArrayProblems {
    public static int maxElement(int[] nums) {
        int maxNumber = -1;
         for (int i = 0; i < nums.length; ++i) {
            if (i > maxNumber) {
                maxNumber = nums[i];
            }
         }
         return maxNumber;
    }

    public static int digitSum(String digits) {
        int sum = 0;

        for (int i = 0; i < digits.length(); ++i) {
            sum += Character.getNumericValue(digits.charAt(i));
        }

        return sum;
    }

    public static void fibonacciSequence(int n) {
        int sum = 0, num1 = 1, num2 = 1;

        if (n == 1) {
            System.out.println('1');
            return;
        }
       
        System.out.printf("%d, %d", num1, num2);

        for (int i = 2; i < n; ++i) {
            sum = num1 + num2;

            System.out.printf(", %d", sum);

            num1 = num2;
            num2 = sum;
        }

        System.out.printf("%n");
    }

    public static int[] sortArray(int[] nums) {
        for (int i = 0; i < nums.length; ++i) {
            for (int j = 0; j < nums.length - i - 1; ++j) {
                if (nums[j] > nums[j + 1]) {
                    int temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;
                }
            }
        }

        return nums;
    }

    public static void main(String[] args) {
        System.out.println(maxElement(new int[] {5, 2, 1, 4, 3}));
        System.out.println(digitSum("12345"));
        fibonacciSequence(5);
        System.out.println(Arrays.toString(sortArray(new int[] {7, 4, 10, 2, 6, 9, 5, 3, 1, 8})));
    } 
}
