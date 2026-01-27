import java.util.*;
public class binarySearch{
    public static int BinarySearch(int[] array, int target){
        int low = 0;
        int high = array.length-1;
        while(low<=high){
            int mid = low+(high-low)/2;
            if(array[mid]==target){
                return target;
            } else if(array[mid]<target){
                low = mid+1;
            } else{
                high = mid-1;
            }
        }
        return -1;
    }
    public static void main(String[] args){
        int[] array = {1,2,3,4,5,6,7,8,9};
        int target = 5;
        int index = BinarySearch(array, target);
        if (index != -1) { 
            System.out.println("Element is found: " + target + " at index " + index);
        } else {
            System.out.println("Element is not found: " + target);
        }
        
    }

}