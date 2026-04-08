import java.util.Stack;
import java.util.Arrays;

public class DailyTemperaturesDemo {

    public static int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] answer = new int[n];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                int prevIndex = stack.pop();
                answer[prevIndex] = i - prevIndex;
            }
            stack.push(i);
        }

        return answer;
    }

    public static void main(String[] args) {
        int[] t1 = {73, 74, 75, 71, 69, 72, 76, 73};
        int[] t2 = {30, 40, 50, 60};
        int[] t3 = {30, 60, 90};

        int[] ans1 = dailyTemperatures(t1);
        int[] ans2 = dailyTemperatures(t2);
        int[] ans3 = dailyTemperatures(t3);

        System.out.println("Input : " + Arrays.toString(t1));
        System.out.println("Output: " + Arrays.toString(ans1)); // [1,1,4,2,1,1,0,0]

        System.out.println("Input : " + Arrays.toString(t2));
        System.out.println("Output: " + Arrays.toString(ans2)); // [1,1,1,0]

        System.out.println("Input : " + Arrays.toString(t3));
        System.out.println("Output: " + Arrays.toString(ans3)); // [1,1,0]
    }
}
