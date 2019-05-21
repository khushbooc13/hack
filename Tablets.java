/* Therasa is a Nurse. She wants to give some tablets to the patients in her practice. 
All the patients sit in a line and each of them has a rating score according to his 
or her health score. Therasa wants to give at least 1 tablet for each patient. 
Patients get jealous of their immediate neighbors, so if two patients sit next to each 
other then the one with the higher rating must get more tablets. Therasa wants to save money, 
so she wants to minimize the total number of tablets.*/

import java.util.*;
class Tablets {
    public static void main(String args[] ) throws Exception {
        
        Scanner s = new Scanner(System.in);
        int t = s.nextInt();
        int[] arr = new int[t];
        int[] brr = new int[t];
        for(int o=0;o<t;o++){
            arr[o] = s.nextInt();
            brr[o] = 1;
        }
        for(int i=0;i<t-1;i++){
            if(arr[i+1] > arr[i]){
                brr[i+1] = brr[i]+1;
                
            }
         //   System.out.println(brr[i]);
        }
        for(int j=t-1;j>0;j--){
            if(arr[j-1] > arr[j] && brr[j-1] <= brr[j]){
                brr[j-1] = brr[j]+1;
            }
        }
        int sum = 0;
        for(int i=0;i<t;i++){
            sum += brr[i];
        }
        System.out.println(sum);
 
    }
}