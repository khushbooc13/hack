import java.util.*;
class Occurance{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the string");
		String str =sc.next();
		HashMap<Character, Integer> charCountMap = new HashMap<Character, Integer>();
		char arr[]=str.toCharArray();
		for(char c: arr)
		{
			if(charCountMap.containsKey(c))
			{
				charCountMap.put(c,charCountMap.get(c)+1);
			}
			else
			{
				charCountMap.put(c,1);
			}
		}
		Map<Character,Integer> mapValues= new HashMap<Character,Integer>(charCountMap);
		Set<Character> mySet = new HashSet<Character>();
		 for (Iterator itr = tree.entrySet().iterator(); itr.hasNext();)
		 {
		 	Map.Entry<Character, Integer> entrySet = (Map.Entry) itr.next();
		 	int value = entrySet.getValue();
		 	if (!mySet.add(value))
        	{
            	itr.remove();               
        	}
        }
        System.out.println(mySet);


		 /*int freq[] = new int[str.length()]; 
		 int len=str.length();
		 char arr[]=str.toCharArray();
		 for (int i = 0; i < str.length(); i++) 
		 { 
		 	//System.out.println(arr[i]);

            if (arr[i] != ' ') { 

                freq[str.charAt(i) - 'a']++; 

            } 
        }
        //Arrays.sort(freq);
       for(int i=0;i<26;i++)
       {
       		System.out.println(freq[i]);
       }*/
       
	}
}