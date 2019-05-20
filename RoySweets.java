/* Its Diwali time and Little Roy's family is having a lot of guests. Guests come in families. 
Each guest family has M members. Roy's task is to serve sweets to them. Roy has N different sweets 
and each sweet has some specific sweetness level S and quantity Q.

Each guest family will give R rupees (as a token of gratitude) to Roy if 
following conditions are satisfied:

The sweetness level of sweet served is greater than or equal to the members in the guest family
Every member should get sweet of one particular sweetness level
Every member should get equal quantity of sweets
where R = 100 * Quantity of sweet(s) each member had.

After each guest family has left, Roy's Mom makes sure that the quantity of sweets that guest 
family had is restored to its original value.

Your task is to find R - maximum amount in rupees Roy has after all the guests have come and left.*/
import java.io.*;
import java.util.*;
class RoySweets
{
	int max(int a,int b) {
		return a>b ? a : b;
	}
	public static void main(String args[] ) throws Exception 
	{
		TestClass t = new TestClass();
	        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int len = 1000001;
		int Q[] = new int[len];
		for(int i=0;i<N;i++) {
			String str[] = br.readLine().split(" ");
			int p = Integer.parseInt(str[0]), w = Integer.parseInt(str[1]);
			Q[p]=w;
		}
		int dp[] = new int[len];
		dp[len-1] = Q[len-1];
		int max=dp[len-1];
		for(int i=len-2;i>0;i--) {
			if(Q[i]>max) max = Q[i];
			dp[i] = max;
		}
		int F = Integer.parseInt(br.readLine());
		long ans=0;
		for(int i=0;i<F;i++)  {
			int M = Integer.parseInt(br.readLine());
			ans = ans + (dp[M]/M)*100;
		}
		System.out.println(ans);
    	}
}