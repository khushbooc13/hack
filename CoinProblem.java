import java.io.*;
 
class CoinProblem {
    
    static int mod =  1000000007;
    static int dp[]  = new int[1000001];
    
    static void load(){
        dp[1] = 2;
        dp[2] = 4;
        dp[3] = 7;
        
        
        for(int i=4;i<dp.length;i++){
            dp[i] = ((dp[i-1] + dp[i-2])%mod + dp[i-3])%mod;
        }
    }
   
    
    public static void main(String args[] ) throws Exception {
        
        BufferedReader s = new BufferedReader(new InputStreamReader(System.in));
         load();
         
         int t = Integer.parseInt(s.readLine());
         
         while(t-- > 0){
             
             int i = Integer.parseInt(s.readLine());
             System.out.println(dp[i]);
         }
         
    }
}