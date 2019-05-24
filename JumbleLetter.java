/*Prashant started to attend programming lessons. On the first lesson his task was 
to write a simple program. The program was supposed to do the following: in the given 
string, consisting if uppercase and lowercase Latin letters, it:

deletes all the vowels,
inserts a character "." before each consonant,
replaces all uppercase consonants with corresponding lowercase ones.

Vowels are letters "A", "O", "Y", "E", "U", "I", and the rest are consonants. 
The program's input is exactly one string, it should return the output as a single string, 
resulting after the program's processing the initial string.

Help Prashant cope with this easy task.
*/
import java.io.BufferedReader;
import java.io.InputStreamReader;
 
//import for Scanner and other utility classes
import java.util.*;
 
 
// Warning: Printing unwanted or ill-formatted data to output will cause the test cases to fail
 
class JumbleLetter {
    public static void main(String args[] ) throws Exception {
   BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
        int testCases=Integer.parseInt(reader.readLine());
        List<Character> vowels= Arrays.asList('A','E','I','O','U','Y','a','e','i','o','u','y');
        for(int i=0;i<testCases;i++){
                StringBuilder sb=new StringBuilder();
            String str=reader.readLine();
            for(Character ch:str.toCharArray()){
                if(!vowels.contains(ch)) {
                    sb.append(".");
                    if(Character.isUpperCase(ch)){
                        sb.append(Character.toLowerCase(ch));
                    }else{
                        sb.append(ch);
                    }
                }
            }
            System.out.println(sb.toString());
        }
    }
}