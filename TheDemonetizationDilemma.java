/*Anik is big foodie and frequently goes on outings to restaurants and food corners in the city or town 
he is living in. Due to the Indian government’s decision to demonetize Rs 500 and Rs 1000, Anik is 
in a huge scarcity for change. He cannot possibly survive without his beloved food. Notes are not 
available in the market, so he is having to pay only through coins. So he decides that he will pay 
the amount through the minimum number of coins he possibly can.

Input:

First line contains a number T which denotes the number of test cases. Each test case contains 3 lines.

First line consists of a single integer A which signifies the amount Anik has to pay.
Second line consists of a single integer N which is the number of coin denominations available in the market.
Third line consists of N integers a1, a2, a3 ... an denoting the coin denominations available in the market.*/
import java.util.*;
// Warning: Printing unwanted or ill-formatted data to output will cause the test cases to fail
 
class TheDemonetizationDilemma {
    public static void main(String args[] ) throws Exception {
        Scanner manik=new Scanner(System.in);
        int t=manik.nextInt();
        
        for(int i=0;i<t;i++){
            int money=manik.nextInt();
            int n=manik.nextInt();
            int arr[]=new int[n];
            for(int j=0;j<n;j++){
                arr[j]=manik.nextInt();
            }
            
            int C[]=new int[money+1];
            Arrays.fill(C,10000000);
            C[0]=0;
            for(int k=0;k<n;k++){
                for(int j=1;j<=money;j++){
                    if(j>=arr[k]){
                        C[j]=Math.min(C[j],1+C[j-arr[k]]);
                    }
                }
            }
            if(C[money]>=10000000){
                System.out.println("No solution");
            }
            else{
                System.out.println(C[money]);
            }
        }
    }
}