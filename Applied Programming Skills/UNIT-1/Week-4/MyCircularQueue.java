public class MyCircularQueue {
    private int[] q;
    private int front, rear, count, cap;

    public MyCircularQueue(int k) {
        q = new int[k];
        cap = k;
        front = 0;
        rear = -1;
        count = 0;
    }

    public boolean enQueue(int value) {
        if (isFull()) return false;
        rear = (rear + 1) % cap;
        q[rear] = value;
        count++;
        return true;
    }

    public boolean deQueue() {
        if (isEmpty()) return false;
        front = (front + 1) % cap;
        count--;
        return true;
    }

    public int Front() {
        return isEmpty() ? -1 : q[front];
    }

    public int Rear() {
        return isEmpty() ? -1 : q[rear];
    }

    public boolean isEmpty() {
        return count == 0;
    }

    public boolean isFull() {
        return count == cap;
    }

    public static void main(String[] args) {
        MyCircularQueue myCircularQueue = new MyCircularQueue(3);
        System.out.println(myCircularQueue.enQueue(1)); // true
        System.out.println(myCircularQueue.enQueue(2)); // true
        System.out.println(myCircularQueue.enQueue(3)); // true
        System.out.println(myCircularQueue.enQueue(4)); // false
        System.out.println(myCircularQueue.Rear());     // 3
        System.out.println(myCircularQueue.isFull());   // true
        System.out.println(myCircularQueue.deQueue());  // true
        System.out.println(myCircularQueue.enQueue(4)); // true
        System.out.println(myCircularQueue.Rear());     // 4
    }
}
