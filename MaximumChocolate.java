/*Bharat is chocoholic. He found a chocolate factory of N floors ,but the factory has N*N rooms 
where in each room specific number of chocolate is present. Now, Bharat starts collecting chocolate 
from ground floor. He can only collect chocolate from one room in a floor. Bharat can only move to 
upper room or upper-right room or upper-left room .
He want to collect maximum number of chocolate possible. Help him in finding maximum number of chocolate.*/
import java.util.Scanner;
 
public class MaximumChocolate {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[][] = new int[n][n];
        int dp[][] = new int[n][n];
        long max = -1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j] += sc.nextInt();
                System.out.println(dp[i][j]);
                max = Math.max(dp[i][j],max);
                if (i + 1 < n) {
                    dp[i + 1][j] = Math.max(dp[i + 1][j], dp[i][j]);
                    if (j + 1 < n) dp[i + 1][j + 1] = Math.max(dp[i + 1][j + 1], dp[i][j]);
                    if (j - 1 >= 0) dp[i + 1][j - 1] = Math.max(dp[i + 1][j - 1], dp[i][j]);
                }
            }
        }
        System.out.println(max);
    }
}