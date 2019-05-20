/*Panda is fond of numbers. Given a number, he subtracts it with squares of any one
 particular digit of that number to get new numbers. This operation can be applied any 
 number of times (possibly zero) till he obtains a pandatic number. If he is able to reach 
 to a pandatic number then he wins. A pandatic number is a number which can be expressed in 
 the form AA, where A is a positive integer.*/

import java.util.*;
class Panda {
    public static void main(String args[] ) throws Exception {
 
        Scanner s = new Scanner(System.in);
        int t=s.nextInt();
        Vector<Integer> v=new Vector<Integer>();
        v.add(1);
        v.add(4);
        v.add(27);
        v.add(256);
        v.add(46656);
        v.add(823543);
        boolean dp[]=new boolean[1000001];
        for(int i=0;i<v.size();i++)
        {
            dp[v.get(i)]=true;
        }
        for(int i=13;i<=1000000;i++)
        {
            boolean b=false;
            int n=i;
            int a=0;
            while(n>0)
            {
                a=n%10;
                n=n/10;
                if(i-a*a>=0 && i-a*a<=1000000)
                {
                    b=b||dp[i-a*a];
                }
            }
            dp[i]=b;
        }
        for(int i=0;i<t;i++)
        {
            int z=s.nextInt();
            if(dp[z])
            System.out.println("Yes");
            else
            System.out.println("No");
        }
    }
}