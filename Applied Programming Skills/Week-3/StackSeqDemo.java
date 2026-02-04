import java.util.*;

public class StackSeqDemo {

    static boolean isValid(int[] pushed, int[] popped) {
        Deque<Integer> st = new ArrayDeque<>();
        int j = 0;

        for (int x : pushed) {
            st.push(x);
            while (!st.isEmpty() && st.peek() == popped[j]) {
                st.pop();
                j++;
            }
        }
        return st.isEmpty();
    }

    public static void main(String[] args) {
        int[] pushed = {1,2,3,4,5};
        int[] popped = {4,5,3,2,1};

        System.out.println(isValid(pushed, popped)); // true
    }
}
