package Problems;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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

    public static int arraySum(int[] nums) {
        int sum = 0;

        for (int i = 0; i < nums.length; ++i) {
            sum += nums[i];
        }

        return sum;
    }

    public static String reverseArray(int[] nums) {
        for (int i = 0; i < nums.length / 2; ++i) {
            int temp = nums[i];
            nums[i] = nums[nums.length - i - 1];
            nums[nums.length - i - 1] = temp;
        }

        return Arrays.toString(nums);
    }

    public static int evenNumberCount(int[] nums) {
        int evenCount = 0;

        for (int i = 0; i < nums.length; ++i) {
            if (nums[i] % 2 == 0) { ++evenCount; }
        }

        return evenCount;
    }

    public static int secondLargestElement(int[] nums) {
        nums = Arrays.stream(nums).sorted().toArray();
        return nums[nums.length - 2];
    }

    public static int indexOf(int[] nums, int target) {
        for (int i = 0; i < nums.length; ++i) {
            if (nums[i] == target) { return i; }
        }

        return -1;
    }

    public static List<Integer> removeDuplicates(int[] nums) {
        List<Integer> uniqueArray = new ArrayList<>();

        for (int i = 0; i < nums.length; ++i) {
            if (!uniqueArray.contains(nums[i])) {
                uniqueArray.add(nums[i]);
            }
        }

        return uniqueArray;
    }

    public static int[] rotateArrayRight(int[] nums, int rotations) {
        if (nums == null || nums.length == 0) { return nums; }
        
        rotations %= nums.length;
        if (rotations == 0) { return nums.clone(); }

        int[] rotatedArray = new int[nums.length];
        int counter = 0;
        int startingPoint = nums.length - rotations;

        for (int i = startingPoint; i < nums.length; ++i) {
            rotatedArray[counter++] = nums[i];
        }

        for (int i = 0; i < startingPoint; ++i) {
            rotatedArray[counter++] = nums[i];
        }

        return rotatedArray;
    }

    public static void sumPair(int[] nums, int target) {
        int missingPair = -1;
        List<int[]> sumPairs = new ArrayList<>();

        for (int i = 0; i < nums.length - 1; ++i) {
            if (nums[i] > target) { continue; } // skip if current number is greater than the target
            missingPair = target - nums[i]; // calculate the missing number being searched, then look for the missing pair in the array
            for (int j = i + 1; j < nums.length; ++j) {
                if (nums[j] == missingPair) {
                    sumPairs.add(new int[] {i, j});
                }
            }
        }

        for (int[] pair : sumPairs) {
            System.out.println(Arrays.toString(pair));
        }
    }

    public static int[] prioritizeNonZeros(int[] nums) {
        int index = 0;

        for (int num : nums) {
            if (num != 0) {
                nums[index++] = num;
            }
        }

        while (index < nums.length) {
            nums[index++] = 0;
        }

        return nums;
    }

    public static int longestEqualElementsSubarray(int[] nums) {
        int longestLength = 1;
        int currentLength = 1;

        // return the length of the subarray with the longest equal elements
        // Test Case: {1, 2, 2, 2, 3, 1}
        for (int i = 1; i < nums.length; ++i) {
            if (nums[i - 1] == nums[i]) { ++currentLength; }
            else { longestLength = Math.max(longestLength, currentLength); }
        }

        return longestLength;
    }

    public static int[] recurringElements(int[] nums) {
        int[] recurredElements = new int[nums.length];
        int counter = 0;

        for (int i = 0; i < nums.length - 1; ++i) {
            int currentElement = nums[i];

            boolean alreadyAdded = false;

            // check if element already added
            for (int k = 0; k < nums.length; ++k) {
                if (recurredElements[k] == currentElement) {
                    alreadyAdded = true;
                    break;
                }
            }

            // check if element has duplicate
            for (int j = i + 1; j < nums.length; ++j) {
                if (nums[j] == currentElement) {
                    recurredElements[counter++] = currentElement;
                    break;
                }
            }
            
            alreadyAdded = false; // reset flag
        }

        return Arrays.copyOf(recurredElements, counter);
    }

    public static int[] shiftNonZeroElementsLeft(int[] nums) {
        // Test Case: {1, 0, 2, 0, 0, 3}
        for (int i = 0; i < nums.length - 1; ++i) {
            for (int j = nums.length - 1; j > i; --j) {
                if (nums[j - 1] == 0 && nums[j] != 0) {
                    int temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;
                }
            }
        }

        return nums;
    }

    public static void main(String[] args) {
        // System.out.println(maxElement(new int[] {5, 2, 1, 4, 3}));
        // System.out.println(digitSum("12345"));
        // fibonacciSequence(5);
        // System.out.println(Arrays.toString(sortArray(new int[] {7, 4, 10, 2, 6, 9, 5, 3, 1, 8})));
        // System.out.println(arraySum(new int[] {1, 2, 3, 4, 5}));
        // System.out.println(reverseArray(new int[] {1, 2, 3, 4, 5}));
        // System.out.println(evenNumberCount(new int[] {1, 2, 3, 4, 5, 6}));
        // System.out.println(secondLargestElement(new int[] {1, 2, 3, 4, 5}));
        // System.out.println(indexOf(new int[] {1, 2, 3, 4, 5}, 3));
        // System.out.println(removeDuplicates(new int[] {1, 1, 2, 3, 3, 3, 4, 5, 5}));
        // System.out.println(Arrays.toString(rotateArrayRight(new int[] {1, 2, 3, 4, 5}, 3)));
        // sumPair(new int[] {2, 4, 3, 5, 7}, 9);
        // System.out.println(Arrays.toString(prioritizeNonZeros(new int[] {0, 3, 0, 5, 2, 0, 1})));
        // System.out.println(longestEqualElementsSubarray(new int[] {1, 2, 2, 2, 3, 1}));
        System.out.println(Arrays.toString(recurringElements(new int[] {1, 5, 1, 3, 2, 5, 4})));
        System.out.println(Arrays.toString(shiftNonZeroElementsLeft(new int[] {1, 0, 2, 0, 0, 3})));
    }
}
