
/*Cat Noku recently picked up construction working as a hobby. He's currently working 
with a row of buildings and would like to make it beautiful.

There are n buildings in a row. The height of the i-th building is xi.
Cat Noku can modify the buildings by adding or removing floors to change the heights. 
It costs him P dollars to increase the height of one building by 1, and M dollars to 
lower the height of one building by 1. Note that the heights of all the buildlings must 
remain integers (i.e. Cat Noku cannot choose to raise the height of a building by 0.5).

At the end of the day Cat Noku will get a bonus for the number of buildings which are 
adjacent and have the same height. For each section i, if section i+1 has the same height, 
Cat Noku will gain a profit of S (of course, it is not possible to get this bonus for the 
last building in the row). Thus, his net profit can be described by his total profit minus 
the cost it took him to change the building heights.

Help Cat Noku determine the maximum possible net profit he can gain.
*/
import java.util.Scanner;
 
public class BalancedBuildings {
 
	public static void main(String[] args) {
 
		Scanner sc = new Scanner(System.in);
		long n = sc.nextLong();
		long s = sc.nextLong();
		long m = sc.nextLong();
		long p = sc.nextLong();
		long arr[] = new long[1000001];
		long S[][] = new long[3000][3000];
		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
			if (arr[i] > arr[0])
				S[0][i] = (arr[0] - arr[i]) * p;
			else
				S[0][i] = (arr[i] - arr[0]) * m;
		}
		for (int i = 1; i < n; i++) {
			long y = 0;
			for (int j = 0; j < n; j++) {
				y = Math.max(y, S[i - 1][j]);
			}
			for (int j = 0; j < n; j++) {
				S[i][j] = Math.max(S[i - 1][j] + s, y);
				if (arr[j] > arr[i])
					S[i][j] += (arr[i] - arr[j]) * p;
				else
					S[i][j] += (arr[j] - arr[i]) * m;
				//System.out.print(S[i][j]+" ");
			}
			//System.out.println();
 
		}
		long max = 0;
		for (int i = 0; i < S.length; i++) {
			max = Math.max(max, S[(int) (n - 1)][i]);
		}
		System.out.println(max);
 
	}
 
}