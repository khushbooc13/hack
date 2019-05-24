import java.util.*; 
  
class CountPairInArray { 
  
    public static int countPairs(int arr[], int n) 
    {  
        //A method to return number of pairs with 
        // equal values 
          
        HashMap<Integer,Integer> hm = new HashMap<>(); 
          
        // Finding frequency of each number. 
        for(int i = 0; i < n; i++) 
        { 
        if(hm.containsKey(arr[i])) 
            hm.put(arr[i],hm.get(arr[i]) + 1); 
        else
            hm.put(arr[i], 1);  
        } 
        int ans=0;  
          
        // Calculating count of pairs with equal values 
        for(Map.Entry<Integer,Integer> it : hm.entrySet()) 
        {  
            int count = it.getValue(); 
            ans += (count * (count - 1)) / 2; 
        } 
        return ans; 
    } 
      
    // Driver code 
    public static void main(String[] args)  
    { 
        int arr[] = new int[]{1, 2, 3, 1}; 
        System.out.println(countPairs(arr,arr.length)); 
    } 
} 