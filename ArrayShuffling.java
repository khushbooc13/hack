/*Given three arrays A,B,C of same length N . 
You have of find maximum of sum of length of any two longest 
non decreasing subsequence that we can obtain by 
shuffling A[i],B[i],C[i] (1≤i≤N) among themselves for any number of index
*/
import java.util.*;
import java.io.*;
class ArrayShuffling {
    static int[][][] dp;
    static int[][] arr;
    static class Pair {
        int a, b;
        Pair(int a, int b) {
            this.a = a;
            this.b = b;
        }
    }
    static int n;
    static int ans(int ind, int a, int b) {
        if(ind==n)
            return 0;
        if(dp[ind][a][b]!=-1)
            return dp[ind][a][b];
        Pair[] comb = new Pair[6];
        comb[0] = new Pair(arr[0][ind], arr[1][ind]);
        comb[1] = new Pair(arr[0][ind], arr[2][ind]);
        comb[2] = new Pair(arr[1][ind], arr[0][ind]);
        comb[3] = new Pair(arr[2][ind], arr[0][ind]);
        comb[4] = new Pair(arr[1][ind], arr[2][ind]);
        comb[5] = new Pair(arr[2][ind], arr[1][ind]);
        int res = 0;
        for(int i = 0; i<6; i++) {
            if(comb[i].a>=a && comb[i].b>=b) {
                res = Math.max(res, 2+ans(ind+1, comb[i].a, comb[i].b));
                res = Math.max(res, 1+ans(ind+1, a, comb[i].b));
                res = Math.max(res, 1+ans(ind+1, comb[i].a, b));
                res = Math.max(res, ans(ind+1, a, b));
            }
            else if(comb[i].a>=a) {
                res = Math.max(res, 1+ans(ind+1, comb[i].a, b));
                res = Math.max(res, ans(ind+1, a, b));
            }
            else if(comb[i].b>=b) {
                res = Math.max(res, 1+ans(ind+1, a, comb[i].b));
                res = Math.max(res, ans(ind+1, a, b));
            }
            else
                res = Math.max(res, ans(ind+1, a, b));
        }
        return dp[ind][a][b] = res;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        arr = new int[3][n];
        for(int i = 0; i<3; i++) {
            for(int j = 0; j<n; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        dp = new int[n][101][101];
        for(int[][] i: dp)
            for(int[] j: i)
                Arrays.fill(j, -1);
        System.out.println(ans(0, 0, 0));
    }
}