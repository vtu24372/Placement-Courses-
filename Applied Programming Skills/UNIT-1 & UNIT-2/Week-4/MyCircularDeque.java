public class MyCircularDeque {
    private int[] q;
    private int front, size, cap;

    public MyCircularDeque(int k) {
        q = new int[k];
        cap = k;
        front = 0;
        size = 0;
    }

    public boolean insertFront(int value) {
        if (isFull()) return false;
        front = (front - 1 + cap) % cap;
        q[front] = value;
        size++;
        return true;
    }

    public boolean insertLast(int value) {
        if (isFull()) return false;
        int rear = (front + size) % cap;
        q[rear] = value;
        size++;
        return true;
    }

    public boolean deleteFront() {
        if (isEmpty()) return false;
        front = (front + 1) % cap;
        size--;
        return true;
    }

    public boolean deleteLast() {
        if (isEmpty()) return false;
        size--;
        return true;
    }

    public int getFront() {
        return isEmpty() ? -1 : q[front];
    }

    public int getRear() {
        if (isEmpty()) return -1;
        int rear = (front + size - 1) % cap;
        return q[rear];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == cap;
    }

    // For VS Code testing
    public static void main(String[] args) {
        MyCircularDeque myCircularDeque = new MyCircularDeque(3);
        System.out.println(myCircularDeque.insertLast(1));  // true
        System.out.println(myCircularDeque.insertLast(2));  // true
        System.out.println(myCircularDeque.insertFront(3)); // true
        System.out.println(myCircularDeque.insertFront(4)); // false
        System.out.println(myCircularDeque.getRear());      // 2
        System.out.println(myCircularDeque.isFull());       // true
        System.out.println(myCircularDeque.deleteLast());   // true
        System.out.println(myCircularDeque.insertFront(4)); // true
        System.out.println(myCircularDeque.getFront());     // 4
    }
}
