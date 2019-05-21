/*It is Valentine's Day and Rishabh's girlfriend has asked Rishabh to buy her 
the new iPhone 8 as a gift. Rishabh is a poor guy and doesn't have enough money 
to buy the iPhone, at the same time he does not want to disappoint his girlfriend. 
In order to keep his girlfriend happy, he decides to sell one of his kidneys 
to get the money for the iPhone.
But he has a helpful friend - Viral, so he asks him for money so that he would 
not have to sell his kidney. Viral, being an algorithm lover agrees to give Rishabh 
the money only if he solves the following problem- You are given a string s made up 
of 0s, 1s and xs only. In place of 'x', you can fill in any single character - '0' or '1'. 
Print the length of a sub-string of s, such that after filling in all the xs with either 
'0' or '1', the number of 0s is equal to the number of 1s in that sub-string and the 
sub-string is of maximum length. Note that it is NOT necessary that all xs should have 
the same value. You can replace different xs with different values(either '1' or '0' only). 
If there is no such sub-string having equal number of 0s and 1s after replacing all the xs 
with 0 or 1, then print -1.

Since Rishabh is from EEE, he is not very good at coding and needs your help to solve 
the problem. Can you help him and save his kidney ?
*/
import java.util.*;
class SavetheKidney {
    static int Maxi = -1;
    static int maxlength(String str){
        int zero = 0;
        int one = 0;
        int max = -1;
        
        Map<Integer,Integer> map = new HashMap<>();
        
        for(int i=0;i<str.length();i++){
            char ch = str.charAt(i);
            
            if(ch == '0'){
                zero++;
            }
            else{
                one++;
            }
            
            if(zero==one){
                if(max < i +1){
                    max = i+1;
                }
            }
            
            int key = zero - one;
            if(!map.containsKey(key)){
                map.put(key,i);
            }
            else{
                int index = map.get(key);
                if(max < i - index){
                    max = i - index;
                }
            }
            
        }
        
        return max;
        
        
    }
    
    static void nos(String str,int nox){
        if(nox == 0){
            int tmax =maxlength(str); 
            if(Maxi < tmax){
                Maxi = tmax;
            }
            
         
        }
        
        for(int i=0;i<str.length();i++){
            if(str.charAt(i) == 'x'){
                String temp = str.substring(0,i) + 0 + str.substring(i+1);
                
                String temp2 = str.substring(0,i) + 1 + str.substring(i+1);
                nos(temp,nox - 1);
                nos(temp2,nox - 1);
                break;
            }
        }
        
    }
    public static void main(String args[] ) throws Exception {
       
        Scanner s = new Scanner(System.in);
         int n = s.nextInt();
         char c[] = s.next().toCharArray();
         
         
         int nox = 0;
         for(char ch:c){
             if(ch=='x'){
                 nox++;
             }
         }
                      nos(new String(c),nox);
               
             
       
         
         System.out.println(Maxi);
 
    }
}