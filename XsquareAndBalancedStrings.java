/*Xsquare got bored playing with the arrays all the time. 
Therefore he has decided to buy a string S consists of N lower case alphabets. 
Once he purchased the string, He starts formulating his own terminologies over 
his string S. Xsquare calls a string str A Balanced String if and only if the 
characters of the string str can be paritioned into two multisets M1 and M2 such that M1= M2 .

Xsquare wants to break the string he has purchased into some number of substrings 
so that each substring is a balanced string . However he does not want break the 
string into too many substrings, otherwise the average size of his strings will 
become small. What is the minimum number of substrings in which the given string can 
be broken so that each substring is a balanced string.
*/


import java.io.BufferedReader; 
import java.io.InputStreamReader; 
 
// Warning: Printing unwanted or ill-formatted data to output will cause the test cases to fail
 
class XsquareAndBalancedStrings {
    public static void main(String args[] ) throws Exception {
       
        //Scanner
      //  Scanner s = new Scanner(System.in);    // Writing output to STDOUT
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
  
        int t=Integer.parseInt(br.readLine());
        
        while(t-->0)
        {
            StringBuilder s1=new StringBuilder(br.readLine());
            int count=-1;
            count=countbalstr(s1,count);
            System.out.println(count);
        }
    }
    static int countbalstr(StringBuilder s2,int count)
    {
        if(s2.length()%2!=0)
            return count;
        else
        {
            while(s2.length()!=0)
            {
                String c1= Character.toString(s2.charAt(0));
                s2.delete(0,1);
                int index=s2.indexOf(c1);
                if(index>=0)
                {
                    s2.delete(index,index+1);
                }
                else
                    return count;
            }
            if(count==-1)
                count=1;
            return count;
        }
    }
}