import java.util.*;

class Villages1{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n=sc.nextInt();
		int arr[] = new int[n];
		for(int i=0;i<n;i++)
		{
			arr[i]= sc.nextInt();
		}
		int output=solve(arr,n);
		System.out.println(output);
	}

	static int solve(int arr[],int n)
	{
		int maxstart[]=new int[n];
		for(int i=0;i<n;i++)
		{
			maxstart[i]=FindMax(i,n,arr);
		}
		Arrays.sort(maxstart);
		return maxstart[n-1];
	}

	static int FindMax(int i,int n,int arr[])
	{
		int max[]=new int[n];
		int k=0;
		for(int l=0;l<n;l++)
		{
			max[l]=arr[i];
		}
		for(int j=i+1;j<n;j++)
		{
			if(arr[j]%arr[i]==0)
				max[k++]+=FindMax(j,n,arr);
		}

		if(k>0)
			Arrays.sort(max);
		return max[n-1];
	}
}


/*static int solve(int[] array)
{
    Integer[] dp = new Integer[array.length];
    int result = 0;
    for(int i = 0 ; i< array.length ; i++)
    {
       dp[i] = array[i]; 
    }
    
    for(int i = 1 ; i<array.length ; i++)
    {   
        for(int j=0;j<i;j++)
        {
            if(array[i] % array[j] == 0)
            {
                dp[i] = dp[j] + array[i];
            }
            
        }
    }
    
    result = Collections.max(Arrays.asList(dp));
    return result;
    
}
    */