import java.util.*;
public class SortedSquares{
    public static void sort(int[] nums){
        for(int i=0; i<nums.length; i++){
            nums[i] = nums[i]*nums[i];
        }
        Arrays.sort(nums);
    }
    public static void main(String[] args){
        int[] nums ={-4,-1,0,3,10};
        sort(nums);
        System.out.println("The arrays after sorted :"+ Arrays.toString(nums) );


    }
}