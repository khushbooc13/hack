/*Dexter and Mandark are playing a game. The game consists of N rounds. 
After each round, the winner (either Dexter or Mandark) will be awarded one point. 
The player with more points at the end of the game wins.

Mandark is Dexter's arch enemy. Dexter wants to prove that he is superior to Mandark.
He wants that after each round in the game he has atleast M times the points that Mandark has.
Dexter is busy planning his game strategy so he asks you to tell him the number of ways 
he can win the game with the condition just described.

Two ways of winning the game are said to be different if some round is won by a different person.*/

import java.util.*;
import java.io.*;
 
class DexterandMandark {
    public static void main(String args[]) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw=new PrintWriter(System.out);
        int t=Integer.parseInt(br.readLine());
        int MOD=1000000007;
        while(t-- >0){
            String str=br.readLine();
            StringTokenizer st=new StringTokenizer(str," ");
            int n=Integer.parseInt(st.nextToken());
            int m=Integer.parseInt(st.nextToken());
            long[][] dp=new long[n+1][n+1];
            dp[0][0]=1;
            for(int i=0;i<=n;i++){
                dp[i][0]=0;
                dp[0][i]=1;
            }
            for(int i=1;i<=n;i++){
                for(int j=1;j<=n;j++){
                    if(i+j <=n && i*m<=j){
                        dp[i][j]=(dp[i-1][j]+dp[i][j-1])%MOD;
                    }
                }
            }
            long answer=0;
            for(int i=0;i<=n;i++){
                if(n-i>=i*m && n-i>i)
                    answer=(answer+dp[i][n-i])%MOD;
            }
            pw.println(answer);
        }
        pw.close();
    }
}