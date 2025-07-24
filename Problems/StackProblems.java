package Problems;
import java.util.Stack;
import java.util.HashMap;
import java.util.Map;

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

    public static void stacksUsingQueues() {

    }
 
    public static void queuesUsingStacks() {

    }

    public static void reverseStringViaStacks() {

    }

    public static void minElementViaStacks() {
        
    }

    public static void main(String[] args) {
        System.out.println(validParentheses("([{}])"));
    }
}
