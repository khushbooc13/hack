/*The Coder bank of Coderland has decided to start an offer for its account holders. 
The currency denominations used in Coderland are different than those used generally. 
There are  currency denominations in Coderland which are given in the form of an array. 
The offer from the bank is that the account holder which requests the minimum amount 
greater than the maximum currency denomination available at the bank which cannot be 
paid to the account holder will be given a gift. Since you are a customer of this bank, 
you want to win this gift. Print the number which can get you this prize.*/

import java.util.*;
class PrizeMoney {
    public static void main(String args[] ) throws Exception {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int d[]=new int[n];
        int max=0;
        for(int i=0;i<n;i++){
            d[i]=sc.nextInt();
            max=Math.max(max,d[i]);
        }
        int dp[]=new int[4000004];
        int change=0;
        dp[0]=1;
        for(int i=0;i<n;i++){
            for(int j=d[i];j<=2*max;j++){
                dp[j]=dp[j]|dp[j-d[i]];
            }
        }
        for(int i=max+1;i<=2*max;i++){
            
            if(dp[i]==0){
                System.out.println(i);
                change=-1;
                break;
            }
        }
        if(change==0)
        System.out.println("Fake Offer!");
    }
}