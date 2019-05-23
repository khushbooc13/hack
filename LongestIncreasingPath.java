/*There is a 2D matrix of N rows and M columns. Rows are number 1 to N from top to 
bottom and columns 1 to M from left to right. You are standing at (1,1).

From, A [ i ] [ j ] you can move to A [ i + 1 ] [ j ] 
if A [ i + 1 ] [ j ] > A [ i ] [ j ]. Or, from, A [ i ] [ j ] 
you can move to A [ i ] [ j + 1 ] if A [ i ] [ j + 1 ] > A [ i ] [ j ].

Moving from (1,1), what is the longest path that you can travel?*/
import java.io.*;
import java.util.*;
 
 class Longest_Increasing_Path {
   
   
    
    public static void main(String[] args) throws IOException {
    
        Scanner  s=new Scanner(System.in);
        int totalCases=s.nextInt();
        for(int i=0;i<totalCases;i++){
            int N=s.nextInt();
            int M=s.nextInt();
            int A[][]=new int[N][M];
            for(int  j=0;j<N;j++){
                for(int k=0;k<M;k++){
                    A[j][k]=s.nextInt();
                }
            }
            
            int dp[][]=new int[N][M];
            
            for (int d[] : dp) {
                Arrays.fill(d, -1);
 
            }
            
           int ans=fun(0,0,A,dp,N,M);
           
            System.out.println(ans+1);
 
 
    }
}
 
    private static int fun(int row, int column, int[][] A, int[][] dp,int n,int m) {
        
        if(dp[row][column]!=-1){
            return dp[row][column];
        }
        
        int ans=0;
        if(row<=n-2 && A[row][column]<A[row+1][column]){
            int ans1=1+fun(row+1, column, A, dp, n, m);
            ans=Math.max(ans, ans1);
        }
        
        if(column<=m-2 && A[row][column]<A[row][column+1]){
            int ans1=1+fun(row, column+1, A, dp, n, m);
            ans=Math.max(ans, ans1);
        }
        
        dp[row][column]=ans;
        return ans;
        
    }
}