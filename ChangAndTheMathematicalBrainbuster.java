/*Chang loves solving mathematical puzzles. One day he was solving a puzzle. 
According to the problem statement of the puzzle: "there are N integers. 
you are asked to delete some numbers such that the series obtained after 
deletion follows the condition. (condition/equation): a - 3b<=0 where a is 
the maximum and b is the minimum of the series obtained after deletion is done. 
This condition/equation must be followed by the series of numbers obtained by 
deleting some numbers from original series of numbers". The question asks to tell 
the mininium number of integers to be deleted so that the above condition is followed 
by the remaining numbers obtained after deletion. Help chang in solving this mathematical brainbuster.*/
import java.util.Arrays;
import java.util.Scanner;
 
public class ChangAndTheMathematicalBrainbuster {
 
	static int n;
	static long integers[];
 
	static int deleteMin(int begin, int end){
		if(begin > end || integers[end] - 3 * integers[begin] <= 0)
			return 0;
		return Math.min(deleteMin(begin+1, end), deleteMin(begin, end-1)) + 1;
	}
 
	public static void main(String args[]){
		Scanner s = new Scanner(System.in);
		n = s.nextInt();
		integers = new long[n];
		for(int i=0; i<n; i++)
			integers[i] = s.nextLong();
		Arrays.sort(integers);
		int dp[][] = new int[n][n];
		for(int i=1; i<n; i++){
			for(int j=0; i+j<n; j++){
				if(integers[i+j] - 3 * integers[j] <= 0){
					dp[i][j] = 0;
				}
				else{
					if(j < n-1 && i+j > 0)		
						dp[j][i+j] = Math.min(dp[j][i+j-1], dp[j+1][i+j]);
					else if(i+j > 0)		
						dp[j][i+j] = dp[j][i+j-1];
					else if(j < n-1)
						dp[j][i+j] = dp[j+1][i+j];
					dp[j][i+j]++;
				}
			}
		}
		//System.out.println(deleteMin(0, n-1));
		System.out.println(dp[0][n-1]);
	}
 
}