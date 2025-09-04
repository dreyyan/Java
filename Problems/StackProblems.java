package Problems;
import java.util.Stack;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.PriorityQueue;

public class StackProblems {
    public static boolean validParentheses(String parentheses) {
        Stack<Character> parenthesesStack = new Stack<Character>();
        Map<Character, Character> parenthesesMap = new HashMap<>();
        parenthesesMap.put('(', ')');
        parenthesesMap.put('{', '}');
        parenthesesMap.put('[', ']');


        if (parentheses.length() % 2 != 0) { return false; }


        for (int i = 0; i < parentheses.length(); ++i) {
            if (parenthesesMap.keySet().contains(parentheses.charAt(i))) { // if opening parentheses, push
                parenthesesStack.push(parentheses.charAt(i));
            } else { // it's a closing parenthesis, check whether opening parenthesis in stack matches the current closing parenthesis
                if (parenthesesStack.empty()) { return false; }
                if (parenthesesMap.get(parenthesesStack.peek()) == parentheses.charAt(i)) {
                    parenthesesStack.pop();
                } else { return false; }
            }
        }

        return parenthesesStack.isEmpty();
    }

    class StackByQueues {
        Queue<Integer> mainQueue = new LinkedList<Integer>();
        Queue<Integer> stackQueue = new LinkedList<Integer>();

        // {5, 4, 3, 2, 1}
        public void push(Integer x) {
            mainQueue.offer(x);
        }

        public void pop() {
            while (mainQueue.size() > 1) { 
                stackQueue.offer(mainQueue.poll());
            }

            mainQueue.poll();

            // swap queues
            shiftStacks();
        }

        public int peek() {
            while (mainQueue.size() > 1) { 
                stackQueue.offer(mainQueue.poll());
            }

            int top = mainQueue.peek();

            // move element after peeking
            stackQueue.offer(mainQueue.poll());

            shiftStacks();
            return top;
        }

        public boolean isEmpty() {
            return (mainQueue.isEmpty() && stackQueue.isEmpty());
        }

        public void shiftStacks() {
            Queue<Integer> temp = mainQueue;
            mainQueue = stackQueue;
            stackQueue = temp;
        }
    }

    class MinStack {
        Stack<Integer> stack = new Stack<Integer>();
        Stack<Integer> minStack = new Stack<Integer>();

        // push an element onto the stack
        public void push(int x) {
            stack.push(x);

            if (minStack.isEmpty()) {
            minStack.push(x);
            } else {
                minStack.push(Math.min(x, minStack.peek()));
            }
        }

        // remove the top element
        public void pop() {
            stack.pop();
            minStack.pop();
        }

        // return the top element
        public int top() {
            return stack.peek();
        }

        // return the minimum element in the stack at any time
        public int getMin() {
            return minStack.peek();
        }
    }

    public static String reverseStringViaStacks(String str) {
        Stack<Character> stack = new Stack<>();
        StringBuilder reversedString = new StringBuilder();

        for (int i = 0; i < str.length(); ++i) {
            stack.push(str.charAt(i));
        }

        while (!stack.isEmpty()) {
            reversedString.append(stack.pop());
        }

        return reversedString.toString();
    }

    public static int[] nextGreaterElement(int[] nums) {
        Stack<Integer> greaterElement = new Stack<>();
        int[] nextGreaterElements = new int[nums.length];
        greaterElement.push(-1);

        for (int i = nums.length - 1; i >= 0; --i) {
            // 5, 4, 2, 3, 1
            // -1, -1, 3, -1, -1
        }

        return nextGreaterElements;
    }

    public static int dailyTemperatures(float[] temperatures) {
        Stack<Float> temperatureStack = new Stack<>();


        // return how many days you'd have to wait until a warmer temperature
        return -1;
    }
    
    public static void main(String[] args) {
        // System.out.println(validParentheses("([{}])"));
        System.out.println(reverseStringViaStacks("The quick brown fox jumps over the fence."));
        int[] nextGreaterElements = nextGreaterElement(new int[] {6, 10, 2, 4, 5, 1, 7, 8, 3});
        for (int i = 0; i < nextGreaterElements.length; ++i) { System.out.print(nextGreaterElements[i] + ' '); }
    }
}
