/*Bruce becomes very sad when he realises that Harvey is now killing people based 
on the outcome of a coin toss. He also knows that Harvey kills someone only when he 
remembers Rachel while tossing the coin.

Harvey tosses the coin finite number of times and lists the outcomes. 
In the list if Tails comes three times in a row, He remebers Rachel and kills the other person.

Bruce is sad but wants to focus on positives. so he thinks about the number 
of ways when the other person is  killed for given number of tosses. As he is unable to 
compute desired number he asks you to do so.
*/
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