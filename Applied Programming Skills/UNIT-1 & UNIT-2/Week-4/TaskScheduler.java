import java.util.*;

public class TaskScheduler {

    public static int leastInterval(char[] tasks, int n) {
        int[] freq = new int[26];
        for (char t : tasks) freq[t - 'A']++;

        int maxFreq = 0, maxCount = 0;
        for (int f : freq) {
            if (f > maxFreq) {
                maxFreq = f;
                maxCount = 1;
            } else if (f == maxFreq) {
                maxCount++;
            }
        }

        int result = (maxFreq - 1) * (n + 1) + maxCount;
        return Math.max(tasks.length, result);
    }

    public static void main(String[] args) {
        char[] tasks1 = {'A','A','A','B','B','B'};
        int n1 = 2;
        System.out.println("Output 1: " + leastInterval(tasks1, n1)); // 8

        char[] tasks2 = {'A','C','A','B','D','B'};
        int n2 = 1;
        System.out.println("Output 2: " + leastInterval(tasks2, n2)); // 6

        char[] tasks3 = {'A','A','A','B','B','B'};
        int n3 = 3;
        System.out.println("Output 3: " + leastInterval(tasks3, n3)); // 10
    }
}
