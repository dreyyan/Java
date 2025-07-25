package Problems;

import java.util.Stack;

public class QueueProblems {
    class QueueByStacks {
        Stack<Integer> mainStack = new Stack<>();
        Stack<Integer> queueStack = new Stack<>();

        public void offer(int x) {
            mainStack.push(x);
        }

        public void poll() {
            if (queueStack.isEmpty()) {
                while (!mainStack.isEmpty()) {
                    queueStack.push(mainStack.pop());
                }
            }

            queueStack.pop();
        }

        public int peek() {
            if (queueStack.isEmpty()) {
                while (!mainStack.isEmpty()) {
                    queueStack.push(mainStack.pop());
                }
            }
            return queueStack.peek();
        }
    }

    public static void main(String[] args) {

    }
}
