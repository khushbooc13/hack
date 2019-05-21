/*Harit wants to climb ladder having n steps but he want to climb only in step of 2 and 5. 
Now he felt boring repeating same thing again and again. So he discovered new way, now each 
time Harit wants to climb in step of k also. In other words he can use steps of 2, 5 or k to 
climb the ladder. So Harit want to calculate number of different ways to reach at cur step , 
where k and cur are integers . Although Harit is intelligent yet lazy so he wants your help to 
calculate number of ways. As number of ways could be too large so he wants you to output it 
modulo 1000000007 (10^9 + 7) .*/
import java.util.Arrays;
import java.util.Scanner;
 
public class LadderRide {
    public static final int MODULO = 1000000007;
    
    public static void main(String[] args) {
	Scanner scanner = new Scanner(System.in);
 
	int t = scanner.nextInt();
	int n = scanner.nextInt();
	if (t < 1 || n < 1)
	    return;
	
	long[] cache0 = new long[n + 1];
	Arrays.fill(cache0, 0, n + 1, 0);
	cache0[0] = cache0[2] = cache0[4] = cache0[5] = 1;
 
	int i;
	for (i = 6; i <= n; i++)
	    cache0[i] = (cache0[i - 2] + cache0[i - 5]) % MODULO;
 
	int cur, k;
	long[] cache1 = new long[n + 1];
	for ( ; t > 0; t--) {
	    cur = scanner.nextInt();
	    k = scanner.nextInt();
 
	    if (cur > n ||
		k < 5)
		continue;
 
	    if (k > cur || k == 5)
		System.out.println(cache0[cur]);
	    else {
		for (i = k; i <= cur; i++)
		    cache1[i] = ((((i - 2) >= k) ? cache1[i - 2] : cache0[i - 2]) +
				 (((i - 5) >= k) ? cache1[i - 5] : cache0[i - 5]) +
				 (((i - k) >= k) ? cache1[i - k] : cache0[i - k])) % MODULO;
		System.out.println(cache1[cur]);
	    }
	}
	
	scanner.close();
    }
}