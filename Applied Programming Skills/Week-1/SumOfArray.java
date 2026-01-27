import java.util.*;

public class SumOfArray {

    
    public static void sum(int[] array) {
        
        for (int i = 1; i < array.length; i++) {
            array[i] = array[i] + array[i - 1];
        }
    }

    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4};
        sum(array); 

        System.out.println("After performing the sum of array: " 
                           + Arrays.toString(array));
    }
}
