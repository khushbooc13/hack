import java.io.*;
import java.util.*;

public class Villages {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter wr = new PrintWriter(System.out);
        int n = Integer.parseInt(br.readLine().trim());
        String[] arr_p = br.readLine().split(" ");
        int[] p = new int[n];
        for (int i_p = 0; i_p < arr_p.length; i_p++) {
            p[i_p] = Integer.parseInt(arr_p[i_p]);
        }

        int out_ = solve(p);
        wr.println(out_);

        wr.close();
        br.close();
    }

    static int solve(int[] p) {
        // Write your code here.
        Integer dp[] = new Integer[p.length];
        for(int i=0;i<p.length;i++)
        {
            dp[i]=p[i];
        }
        for(int i=0;i<p.length;i++)
        {
            for(int j=0;j<i;j++)
            {
                if(p[i]%p[j]==0)
                {
                    dp[i]=Math.max(dp[j],dp[j]+p[i]);
                }
            }
        }
        return Collections.max(Arrays.asList(dp));
    }
}