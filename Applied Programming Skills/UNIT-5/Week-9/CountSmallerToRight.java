import java.util.*;

public class CountSmallerToRight {
    static int[] counts;
    static int[][] indexed;

    static void mergeSort(int[][] arr, int left, int right) {
        if (left >= right) return;
        int mid = (left + right) / 2;
        mergeSort(arr, left, mid);
        mergeSort(arr, mid + 1, right);
        merge(arr, left, mid, right);
    }

    static void merge(int[][] arr, int left, int mid, int right) {
        int[][] temp = new int[right - left + 1][2];
        int i = left, j = mid + 1, k = 0;

        while (i <= mid && j <= right) {
            if (arr[i][0] <= arr[j][0]) {
                counts[arr[i][1]] += j - (mid + 1);
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];
            }
        }

        while (i <= mid) {
            counts[arr[i][1]] += j - (mid + 1);
            temp[k++] = arr[i++];
        }

        while (j <= right) temp[k++] = arr[j++];

        for (int l = 0; l < temp.length; l++) arr[left + l] = temp[l];
    }

    public static void main(String[] args) {
        int[] nums = {5, 2, 6, 1};
        int n = nums.length;
        counts = new int[n];
        indexed = new int[n][2];

        for (int i = 0; i < n; i++) indexed[i] = new int[]{nums[i], i};

        mergeSort(indexed, 0, n - 1);

        System.out.println(Arrays.toString(counts));
    }
}