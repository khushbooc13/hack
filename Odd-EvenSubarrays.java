/*You are given an array A of N positive integer values. 
A subarray of this array is called Odd-Even subarray if the number 
of odd integers in this subarray is equal to the number  of 
even integers in this subarray.
Find the number of Odd-Even subarrays for the given array.*/

import java.util.Scanner;
class Odd-EvenSubarrays {
    static int[] arr;
    static int[] arr1;
    static Scanner in = new Scanner(System.in);
    public static void main(String args[] ){
        
        int n = in.nextInt();
        arr = new int[n];
        arr1 = new int[n];
        arr1[0] = 0;
        arr[0] = in.nextInt();
 
        for (int i = 1; i < n; i++) {
            arr[i] = in.nextInt();
            arr1[i] = count(i);
        }
        
        long sum=0;
        for (int i = 0; i < n; i++) {
            sum += arr1[i];
        }
        System.out.println(sum);
    }
 
    public static int count(int index){
        int t = arr[index]%2 == 0 ? 1 : -1;
        int res = 0;
        for(int i = index-1 ;i>=0 ; i--){
            t += arr[i]%2 == 0 ? 1 : -1;
            if(t==0  & i>0)
                return 1 + arr1[i-1];
        }
        if(t==0){
            return 1;
        }else{
            return 0;
        }
    }
    
}