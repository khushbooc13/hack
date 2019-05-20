import java.util.*;


// Warning: Printing unwanted or ill-formatted data to output will cause the test cases to fail

class TestClass {
    static void combinationUtil(int arr[], int n, int r, 
                          int index, int data[], int i) 
    { 
        // Current combination is ready to be printed,  
        // print it 
        if (index == r) { 

            return data[r]; 
        } 
  
        // When no more elements are there to put in data[] 
        if (i >= n) 
            return; 
  
        // current is included, put next at next 
        // location 
        data[index] = arr[i]; 
        combinationUtil(arr, n, r, index + 1,  
                               data, i + 1); 
  
        // current is excluded, replace it with 
        // next (Note that i+1 is passed, but 
        // index is not changed) 
        combinationUtil(arr, n, r, index, data, i + 1); 
    } 
  
    // The main function that prints all combinations 
    // of size r in arr[] of size n. This function  
    // mainly uses combinationUtil() 
    static void printCombination(int arr[], int n, int r) 
    { 
        // A temporary array to store all combination 
        // one by one 
        int data[] = new int[r]; 
  
        // Print all combination using temprary 
        // array 'data[]' 
        combinationUtil(arr, n, r, 0, data, 0); 
        System.out.println(data.length());
    } 
    public static void main(String args[] ) throws Exception {
        Scanner sc = Scanner(System.in);
        int n=sc.nextInt();
        int arr[]= new int[n];
        for(int i=0;i<n;i++)
        {
            arr[i]=sc.nextInt();
        }
        int r=sc.nextInt();
        printCombination(arr, n, r);
    }
}
