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
			//if(arr[j]%arr[i]==0)
				max[k++]+=FindMax(j,n,arr);
		}

		if(k>0)
			Arrays.sort(max);
		return max[n-1];
	}
}