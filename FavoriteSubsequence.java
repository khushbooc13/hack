/*You are given a String S of length N.
Now, a good subsequence is one that can be represented in the form  a`i b`j c`k, 
where i>=1,j>=1  and k>=1. For example ,if ,,, it represents the string . In short, 
a good subsequence is a subsequence that first consist of i a characters, 
followed by j b characters, followed by k c characters,where i>=1,j>=1  and k>=1 
Now, you need to find the number of good subsequences of String S. As the number 
of such subsequences could be rather large, print the answer Modulo .*/

import java.util.*;
import java.io.*;
class FavoriteSubsequence { 
       
     static long mod=1000000007;
    static long countSubsequences(String s) 
    {
        long cCount = 0,aCount=0,bCount=0; 
        for (int i=0; i< s.length(); i++) 
        { 
            if (s.charAt(i) == 'a') 
                aCount = (1 + 2 * aCount)%mod; 
       
            else if (s.charAt(i) == 'b') 
                bCount = (aCount + 2 * bCount)%mod; 
       
   
            else if (s.charAt(i) == 'c') 
                cCount = (bCount + 2 * cCount)%mod; 
        } 
        return cCount; 
    } 
       
    public static void main(String args[]) 
    { 
              Scanner sc = new Scanner(System.in);
              PrintWriter out = new PrintWriter(System.out);
        String s = sc.next();
        System.out.println(countSubsequences(s)); 
    } 
}