/*As we all know RK loves his name very much especially the character 'R' so this time task for you 
is based on his awesome name. RK gives you a string S consisting of characters 'R' and 'K' only. 
Now you are allowed to do exactly one move that is you have to choose two indices i and j 
(1<=i<=j<=|S| where |S| is string length ) and flip all the characters at position X where i<=X<=j. 
Flipping the character means :*/

/*Gurpreet loves his crush A(secret) very much. Recently he forgot her birthday that made "A" 
very upset.
Gurpreet tried lot to make her happy and asked her to forgive him once. Finally "A" changed her
mood and gave Gurpreet a task to prove his love.*/

import java.util.*;
class NoofR {
    public static int rk(int[] arr, int a){
        int start = 0;
        int end = 0;
        int curr = 0;
        int m = 0;
        int max_so_far = Integer.MIN_VALUE;
        for(int i=0;i<arr.length;i++){
            curr += arr[i];
            if(max_so_far < curr){
                max_so_far = curr;
                start = m;
                end = i;
            }
            if(curr < 0){
                curr = 0;
                m = i+1;
            }
        }
        int sum = 0;
        for(int i=start;i<=end;i++){
            if(arr[i] == 1){
                sum++;
            }
            else{
                sum--;
            }
        }
        return (sum+a);
    }
    public static void main(String args[] ) throws Exception {
        
        Scanner s = new Scanner(System.in);
        int t = s.nextInt();
        for(int h=0;h<t;h++){
            String st = s.next();
            int arr[] = new int[st.length()];
            int a = 0;
            for(int i=0;i<st.length();i++){
                if(st.charAt(i)=='A'){
                    arr[i]=-1;
                    a++;
                }
                else{
                    arr[i]=1;
                }    
            }
            System.out.println(rk(arr,a));
        }
 
    }
}