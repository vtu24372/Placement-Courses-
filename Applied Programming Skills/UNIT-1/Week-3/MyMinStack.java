import java.util.Stack;

public class MyMinStack {

    private Stack<Integer> stack;
    private Stack<Integer> minStack;

    public MyMinStack() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int val) {
        stack.push(val);

        if (minStack.isEmpty() || val <= minStack.peek()) {
            minStack.push(val);
        }
    }

    public void pop() {
        int removed = stack.pop();
        if (removed == minStack.peek()) {
            minStack.pop();
        }
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }

    // Simple demo
    public static void main(String[] args) {
        MyMinStack minStack = new MyMinStack();

        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);

        System.out.println("getMin() = " + minStack.getMin()); // -3
        minStack.pop();
        System.out.println("top()    = " + minStack.top());    // 0
        System.out.println("getMin() = " + minStack.getMin()); // -2
    }
}
