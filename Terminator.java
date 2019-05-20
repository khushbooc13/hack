/* We sent some spies to the Terminator camp to gather more information about their tactics. 
Our spies observed the following:

1. There are a total of n terminators in the camp. They are numbered from 1 to n. 
All terminators have a unique strength level.

2. They are divided into groups. Each group has a certain number of terminators in it. 
The size of each group may be different.

3. Every day the terminators stand in a queue for inspection. The spies observed that the 
terminators stood in such a way that a terminator never stands ahead of a stronger terminator 
of his group. A terminator may stand ahead of a stronger terminator of a different group.

The spies observed the camp for two days. They noted down the position of each terminator in the 
queue for each day. The supreme Commander of the Human Army has appointed you.
 Your job is to tell the maximum possible number of terminators in one group.*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
 
class Terminators {
	public static void main(String ar[]) throws IOException {
		BufferedReader input = new BufferedReader(new InputStreamReader(
				System.in));
		int t = Integer.parseInt(input.readLine());
		while (t-- > 0) {
			int n = Integer.parseInt(input.readLine());
			int A[] = new int[n];
			int B[] = new int[n];
			for (int i = 0; i < n; i += 1) {
				String ab[] = input.readLine().split(" ");
				int a = Integer.parseInt(ab[0]);
				int b = Integer.parseInt(ab[1]);
				A[a - 1] = i;
				B[b - 1] = i;
			}
			int lcs[][] = new int[n + 2][n + 2];
			int ans = Integer.MIN_VALUE;
			for (int i = 1; i <= n; i += 1) {
				for (int j = 1; j <= n; j += 1) {
					if (A[i - 1] == B[j - 1]) {
						lcs[i][j] = 1 + lcs[i - 1][j - 1];
					} else {
						lcs[i][j] = Math.max(lcs[i][j - 1], lcs[i - 1][j]);
					}
					ans = Math.max(lcs[i][j], ans);
				}
			}
			System.out.println(ans);
		}
	}
}
Language: Java