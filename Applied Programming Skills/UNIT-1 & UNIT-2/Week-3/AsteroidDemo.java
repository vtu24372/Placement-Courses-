import java.util.*;

public class AsteroidDemo {

    static int[] solve(int[] a) {
        Stack<Integer> st = new Stack<>();

        for (int x : a) {
            while (!st.isEmpty() && x < 0 && st.peek() > 0 && st.peek() < -x) st.pop();
            if (!st.isEmpty() && x < 0 && st.peek() > 0 && st.peek() == -x) { st.pop(); continue; }
            if (!st.isEmpty() && x < 0 && st.peek() > 0) continue;
            st.push(x);
        }

        int[] res = new int[st.size()];
        for (int i = res.length - 1; i >= 0; i--) res[i] = st.pop();
        return res;
    }

    public static void main(String[] args) {
        int[] asteroids = {3, 5, -6, 2, -1, 4};
        System.out.println(Arrays.toString(solve(asteroids)));
    }
}
