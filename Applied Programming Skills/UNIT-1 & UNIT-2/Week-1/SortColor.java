import java.util.*;
public class SortColor{
    public static void sort(int[] arr){
        int n = arr.length;
        for(int i=0; i<n-1; i++){
            for(int j=0; j<n-i-1; j++){
                if(arr[j]>arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
    }
    public static void main(String[] args){
        int[] arr ={1,5,6,7,3,8,9,4,2,10};
        System.out.println("Array before sorted :" + Arrays.toString(arr));
        sort(arr);
        System.out.println("Array after sorted :" + Arrays.toString(arr));
    }
}