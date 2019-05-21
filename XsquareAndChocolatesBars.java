/*Xsquare loves to eat chocolates like we all do. Xsquare's father has given him a chocolate bar B 
of length N where each chocolate piece is either of strawberry flavour S or of caramel flavour C. 
Xsquare's mom does not want him to eat all the chocolates as she thinks that consumption of too 
many chocolates will make him chocoholic. Therefore, she decided to take some chocolates back from him. 
She has some empty boxes to keep chocolates. Each box can contain exactly three chocolates.
 No box can contain all the chocolates of same flavour. She has ordered Xsquare to return her back, 
 the longest contiguous sub-bar of the original chocolate bar such that she can place every three consecutive 
 chocolates from that contiguous chocolate bar in an empty box. Each empty box can accomodate exactly 
 three chocolates, neither less, nor more. A sub-bar is defined as contiguous peices of chocolates in 
 some particular range.
Xsquare agrees to whatever his mom has ordered. Now, he is wondering how many chocolates he is able 
to eat at the end after he returns the longest contiguous sub-bar.*/

import java.io.*;
import java.util.*;
 
 
public class XsquareAndChocolatesBars {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while(t-->0)
        {
            String s = br.readLine();
            int n = s.length();
            int dp[]= new int[n];
            boolean lastTwoSame = s.charAt(0)==s.charAt(1);
            int ans=0;
            for(int i=2;i<n;i++)
            {
                boolean temp = (lastTwoSame&&s.charAt(i)==s.charAt(i-1));
                if(temp==false)
                {
                    dp[i] = 3 + (i-3>=0 ? dp[i-3] : 0);
                }
                
                ans = Math.max(ans,dp[i]);
                lastTwoSame= s.charAt(i)==s.charAt(i-1);
            }
            
            System.out.println(n- ans);
        }
    }
}