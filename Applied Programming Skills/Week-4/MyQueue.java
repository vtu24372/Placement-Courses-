import java.util.Stack;

public class MyQueue {
    private Stack<Integer> in = new Stack<>();
    private Stack<Integer> out = new Stack<>();

    public void push(int x) {
        in.push(x);
    }

    public int pop() {
        move();
        return out.pop();
    }

    public int peek() {
        move();
        return out.peek();
    }

    public boolean empty() {
        return in.isEmpty() && out.isEmpty();
    }

    private void move() {
        if (out.isEmpty())
            while (!in.isEmpty())
                out.push(in.pop());
    }

    public static void main(String[] args) {
        MyQueue myQueue = new MyQueue();
        myQueue.push(1);                // queue: [1]
        myQueue.push(2);                // queue: [1, 2]
        System.out.println(myQueue.peek());  // 1
        System.out.println(myQueue.pop());   // 1, queue: [2]
        System.out.println(myQueue.empty()); // false
    }
}
